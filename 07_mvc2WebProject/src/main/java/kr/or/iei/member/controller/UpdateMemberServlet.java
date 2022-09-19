package kr.or.iei.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.oreilly.servlet.HttpsMessage;

import kr.or.iei.member.service.MemberService;
import kr.or.iei.member.vo.Member;

/**
 * Servlet implementation class UpdateMemberServlet
 */
@WebServlet(name = "UpdateMember", urlPatterns = { "/updateMember.do" })
public class UpdateMemberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateMemberServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값추출
		/*
		Member m = new Member();
		m.setMemberId(request.getParameter("memberId"));
		m.setMemberPw(request.getParameter("memberPw"));
		m.setMemberPhone(request.getParameter("memberPhone"));
		m.setMemberAddr(request.getParameter("memberAddr"));
		*/
		//정보수정을 위한 조건절 작성을 위해 memberNo가 필요
		//로그인된 세션에서 회원번호를 가져옴
		HttpSession session = request.getSession(false);
		Member m = (Member)session.getAttribute("m");
		int memberNo = m.getMemberNo();
		String memberId = m.getMemberId();
		Member member = new Member();
		String memberPw = request.getParameter("memberPw");
		String memberPhone = request.getParameter("memberPhone");
		String memberAddr = request.getParameter("memberAddr");
		member.setMemberNo(memberNo);
		member.setMemberPw(memberPw);
		member.setMemberPhone(memberPhone);
		member.setMemberAddr(memberAddr);
		//3. 비즈니스로직
		/*
		MemberService service = new MemberService();
		int result = service.updateMember(m);
		*/
		MemberService service = new MemberService();
		int result = service.updateMember2(member);
		//4. 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			m.setMemberPw(memberPw);
			m.setMemberPhone(memberPhone);
			m.setMemberAddr(memberAddr);
			request.setAttribute("title", "정보수정완료");
			request.setAttribute("msg", "회원정보가 수정되었습니다.");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title", "정보수정실패");
			request.setAttribute("msg", "회원정보 수정에 실패하였습니다.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/mypage2.do?memberId="+memberId); //WEB-INF안의 jsp에 직접 접근불가
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
