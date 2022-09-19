<%@page import="kr.or.iei.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.iei.member.model.service.MemberService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //1. 인코딩
    request.setCharacterEncoding("utf-8");
    //2. 값추출
    //입력값 없어서 생략
    //3. 비즈니스 로직
    MemberService service = new MemberService();
    ArrayList<Member> list = service.selectAllMember();
    //4. 결과처리
    //<body>에 바로 작성~
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>1. 전체회원조회</title>
</head>
<body>
	<h1>전체회원조회</h1>
	<hr>
	<%if(list.isEmpty()){ %>
		<h3>회원정보가 없습니다.</h3>
		<a href="/">메인페이지로 가기</a>
	<%} else {%>
		<table border="1">
			<tr>
				<th>회원번호</th>
				<th>아이디</th>
				<th>비밀번호</th>
				<th>이름</th>
				<th>전화번호</th>
				<th>주소</th>
				<th>회원등급</th>
				<th>가입일</th>
			</tr>
			<%for(Member m : list) {%>
			<tr>
				<td><%=m.getMemberNo() %></td>
				<td><%=m.getMemberId() %></td>
				<td><%=m.getMemberPw() %></td>
				<td><%=m.getMemberName() %></td>
				<td><%=m.getMemberPhone() %></td>
				<td><%=m.getMemberAddr() %></td>
				<td><%=m.getMemberLevel() %></td>
				<td><%=m.getEnrollDate() %></td>
			</tr>
			<%} %>
		</table>
	<%} %>
</body>
</html>