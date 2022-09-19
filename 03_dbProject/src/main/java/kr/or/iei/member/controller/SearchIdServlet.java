package kr.or.iei.member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.member.model.service.MemberService;
import kr.or.iei.member.model.vo.Member;

/**
 * Servlet implementation class SearchIdServlet
 */
@WebServlet(name = "SearchId", urlPatterns = { "/searchId.do" })
public class SearchIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchIdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String searchId = request.getParameter("id");
		MemberService service = new MemberService();
		Member m = service.selectIdMember(searchId);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html><head><title>아이디로 회원조회</title></head>");
		out.println("<body>");
		if(m == null) {
			out.println("<h2>회원정보를 조회할 수 없습니다.</h2>");
		}else {
			out.println("<h1>"+searchId+"로 검색한 회원 정보</h1>");
			out.println("<hr>");
			out.println("<ul>");
			out.println("<li>회원번호 : "+m.getMemberNo()+"</li>");
			out.println("<li>아이디 : "+m.getMemberId()+"</li>");
			out.println("<li>비밀번호 : "+m.getMemberPw()+"</li>");
			out.println("<li>이름 : "+m.getMemberName()+"</li>");
			out.println("<li>전화번호 : "+m.getMemberPhone()+"</li>");
			out.println("<li>주소 : "+m.getMemberAddr()+"</li>");
			out.println("<li>회원등급 : "+m.getMemberLevel()+"</li>");
			out.println("<li>가입일 : "+m.getEnrollDate()+"</li>");
			out.println("</ul>");
			
			out.println("<table border='1'>");
			out.println("<tr>");
			out.println("<th>회원번호</th>");
			out.println("<th>아이디</th>");
			out.println("<th>비밀번호</th>");
			out.println("<th>이름</th>");
			out.println("<th>전화번호</th>");
			out.println("<th>주소</th>");
			out.println("<th>회원등급</th>");
			out.println("<th>가입일</th>");
			out.println("</tr");
			out.println("<tr>");
			out.println("<td>"+m.getMemberNo()+"</td>");
			out.println("<td>"+m.getMemberId()+"</td>");
			out.println("<td>"+m.getMemberPw()+"</td>");
			out.println("<td>"+m.getMemberName()+"</td>");
			out.println("<td>"+m.getMemberPhone()+"</td>");
			out.println("<td>"+m.getMemberAddr()+"</td>");
			out.println("<td>"+m.getMemberLevel()+"</td>");
			out.println("<td>"+m.getEnrollDate()+"</td>");
			out.println("</tr");
			out.println("</table>");
		}
		out.println("</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
