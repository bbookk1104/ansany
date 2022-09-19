<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3. 회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<hr>
	<form action="/jsp/joinMember.jsp" method="post">
		<label for="id">아이디 : </label>
		<input type="text" name="id" id="id"><br>
		<label for="pw">비밀번호 : </label>
		<input type="password" name="pw" id="pw"><br>
		<label for="name">이름 : </label>
		<input type="text" name="name" id="name"><br>
		<label for="phone">전화번호 : </label>
		<input type="text" name="phone" id="phone" placeholder="010-0000-0000"><br>
		<label for="addr">주소 : </label>
		<input type="text" name="addr" id="addr"><br>
		<input type="submit" value="가입하기">
	</form>
</body>
</html>