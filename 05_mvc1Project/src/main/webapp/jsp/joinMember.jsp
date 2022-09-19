<%@page import="kr.or.iei.member.model.service.MemberService"%>
<%@page import="kr.or.iei.member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% 
    //1. 인코딩
    request.setCharacterEncoding("utf-8");
    //2. 값추출
    Member m = new Member();
    m.setMemberId(request.getParameter("id"));
    m.setMemberPw(request.getParameter("pw"));
    m.setMemberName(request.getParameter("name"));
    m.setMemberPhone(request.getParameter("phone"));
    m.setMemberAddr(request.getParameter("addr"));
    //3. 비즈니스 로직
    MemberService service = new MemberService();
    int result = service.insertMember(m);
    //4. 결과처리
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>회원가입 결과</h1>
	<%if(result>0){ %>
		<h2>회원가입 성공</h2>
		<h3><a href="/index.jsp">메인페이지로 돌아가기</a></h3>
	<%} else{ %>
		<h2>회원가입 실패</h2>
		<h3><a href="/index.jsp">메인페이지로 돌아가기</a></h3>
	<%} %>
</body>
</html>