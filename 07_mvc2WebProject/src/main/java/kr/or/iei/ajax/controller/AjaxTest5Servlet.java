package kr.or.iei.ajax.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import kr.or.iei.member.service.MemberService;
import kr.or.iei.member.vo.Member;

/**
 * Servlet implementation class AjaxTest5Servlet
 */
@WebServlet(name = "AjaxTest5", urlPatterns = { "/ajaxTest5.do" })
public class AjaxTest5Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AjaxTest5Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		request.setCharacterEncoding("utf-8");
		// 2. 값추출
		// 3. 비즈니스로직
		MemberService service = new MemberService();
		ArrayList<Member> list = service.selectAllMember();
		// 4. 결과처리
		JSONArray memberList = new JSONArray();
		if(!list.isEmpty()) {
			for(Member m : list) {
				JSONObject obj = new JSONObject();
				obj.put("memberNo", m.getMemberNo());
				obj.put("memberId", m.getMemberId());
				obj.put("memberPw", m.getMemberPw());
				obj.put("memberName", m.getMemberName());
				obj.put("memberPhone", m.getMemberPhone());
				obj.put("memberAddr", m.getMemberAddr());
				obj.put("memberLevel", m.getMemberLevel());
				obj.put("enrollDate", m.getEnrollDate());
				memberList.add(obj);
			}
		}
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		out.print(memberList);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
