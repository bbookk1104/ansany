<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디/비밀번호 찾기</title>
<style>
	.page-title{
		text-align: center;
		margin-bottom: 30px;
	}
	.input-wrap{
		padding: 15px
		margin: 0px auto;
	}
	.input-wrap>label{
		font-size:1.1em;
		display:block;
		width: 50%;
		margin: 10px auto;
	}
	.input-wrap>input{
		width: 50%;
		margin: 0px auto;
	}
	.submit-btn{
		padding:15px;
		margin: 20px auto;
		text-align: center;
	}
	.submit-btn>button{
		width: 600px;
	}
</style>
</head>
<body>
	<%@include file="/WEB-INF/views/common/header.jsp" %>
	<div class="page-wrap">
		<div class="page-content">
			<div class="page-title">아이디찾기 (이름 & 전화번호 입력)</div>
			<form action="/searchId.do" method="post">
				<div class="input-wrap">
					<label for="memberName">이름</label>
					<input type="text" name="memberName" id="memberName" class="input-form">
				</div>
				<div class="input-wrap">
					<label for="memberPhone">전화번호</label>
					<input type="text" name="memberPhone" id="memberPhone" class="input-form" placeholder="010-0000-0000">
				</div>
				<div class="submit-btn">
				<button type="submit" class="btn bc66 bs4">아이디찾기</button>
				</div>
			</form>
		</div>
		<hr>
		<div class="page-content">
			<div class="page-title">비밀번호찾기 (아이디 & 전화번호 입력)</div>
			<form action="/searchPw.do" method="post">
				<div class="input-wrap">
					<label for="memberId">아이디</label>
					<input type="text" name="memberId" id="memberId" class="input-form">
				</div>
				<div class="input-wrap">
					<label for="memberPhone">전화번호</label>
					<input type="text" name="memberPhone" id="memberPhone" class="input-form" placeholder="010-0000-0000">
				</div>
				<div class="submit-btn">
				<button type="submit" class="btn bc44 bs4">비밀번호찾기</button>
				</div>
			</form>
		</div>
	</div>
	<%@include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>