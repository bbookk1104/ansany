<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	int totalCount = (Integer)request.getAttribute("totalCount");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사진게시판</title>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-content">
		<div class="page-title">사진게시판</div>
		<%if(m!=null) {%>
		<a href="/photoWriteFrm.do" class="btn bc4">글쓰기</a>
		<%} %>
		<div class="photoWrapper posting-wrap">
			
		</div>
		<button class="btn bc44 bs4" id="more-btn"
			totalCount="<%=totalCount %>"
			currentCount="0"
			value="1">더보기</button>
			<%--
				totalCount : 전체 게시물  수
				currentCount : 실제 jsp에 가지고온 게시물 수
				value : 더보기 요청 시 다음 게시물 시작번호
			 --%>
	</div>
	<script>
		$("#more-btn").on("click",function(){
			const amount = 5;//더보기 클릭 시 추가로 가져올 게시물 수
			const start = $(this).val();//추가로 가져올 게시물 시작번호
			$.ajax({
				url: "/photoMore.do",
				type: "post",
				data: {start:start, amount:amount},
				success: function(data){
					console.log(data);
					for(let i=0;i<data.length;i++){
						const p = data[i];
						const div = $("<div>");
						div.addClass("posting-item");
						
						const imgDiv = $("<div>");
						imgDiv.addClass("posting-img");						
						const img = $("<img>");
						img.attr("src","/upload/photo/"+p.filepath);						
						imgDiv.append(img);
						
						const titleDiv = $("<div>");
						titleDiv.addClass("posting-content");
						const title=$("<p>");
						title.append(p.photoTitle);
						titleDiv.append(title);
						
						div.append(imgDiv).append(titleDiv);
						
						$(".photoWrapper").append(div);
					}
					//화면추가완료 후 다음 더보기를 위한 값 수정
					//value를 증가 -> 기존value+amount
					$("#more-btn").val(Number(start)+Number(amount));
					//currentCount값도 읽어온 만큼으로 수정
					const currentCount = Number($("#more-btn").attr("currentCount"))+data.length;
					$("#more-btn").attr("currentCount",currentCount);
					const totalCount = $("#more-btn").attr("totalCount");
					if(totalCount == currentCount){
						$("#more-btn").attr("disabled",true);
						$("#more-btn").css("cursor","not-allowed");
					}
				},
				error: function(){
					console.log("에러발생");
				}			
			});
		});
		$("#more-btn").click();//첫 화면부터 사진뜨게~
	</script>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>