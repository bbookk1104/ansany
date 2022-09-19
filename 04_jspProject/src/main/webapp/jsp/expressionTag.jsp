<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ExpressionTag</title>
</head>
<body>
	<h1>표현식태그</h1>
	<hr>
	<h3>자바의 데이터를 HTML컨텐츠로 표현하기위해 사용하는 태그</h3>
	<%
		int age = 15;
		ArrayList<String> list = new ArrayList<String>();
		list.add("부가원1");
		list.add("부가원2");
		list.add("부가원3");
		list.add("부가원4");
		list.add("부가원5");
	%>
	<%if(age>19){ %>
		<h3><%=age %>살은 성인</h3>
	<%} else { %>
		<h3><%=age %>살은 미성년자</h3>
	<%} %>
	<hr>
	<%for(int i=0;i<list.size();i++) {%>
		<h3><%=i %>_<%=list.get(i) %></h3>
	<%} %>
</body>
</html>