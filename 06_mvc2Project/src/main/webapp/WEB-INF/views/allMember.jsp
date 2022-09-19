<%@page import="kr.or.iei.member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<Member> list = (ArrayList<Member>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%if(list.isEmpty()){ %>
		<h3>회원을 조회할 수 없습니다.</h3>
	<%}else{ %>
		<table border='1'>
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
		<%for(Member m : list){ %>
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