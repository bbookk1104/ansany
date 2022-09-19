package kr.or.iei.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.iei.member.service.MemberService;

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
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값추출
		String memberName = request.getParameter("memberName");
		String memberPhone = request.getParameter("memberPhone");
		//3. 비즈니스로직
		MemberService service = new MemberService();
		String searchId = service.selectMemberId(memberName,memberPhone);
		//4. 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(searchId != null) {
			request.setAttribute("title", "아이디찾기 성공");
			request.setAttribute("msg", "아이디는 "+searchId+"입니다");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title", "아이디찾기 실패");
			request.setAttribute("msg", "입력하신 정보로 찾을 수 없습니다.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/searchIdPwFrm.do");
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
