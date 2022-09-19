<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>2. 아이디로 회원조회</title>
</head>
<body>
	<h1>아이디로 회원 조회</h1>
	<hr>
	<form action="/jsp/searchId.jsp" method="get">
		<input type="text" name="searchId" placeholder="조회할 회원 아이디 입력">
		<input type="submit" value="조회">
	</form>
</body>
</html>