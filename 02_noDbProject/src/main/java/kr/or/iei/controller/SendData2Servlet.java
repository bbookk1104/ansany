package kr.or.iei.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendData2Servlet
 */
@WebServlet(name = "sendData2", urlPatterns = { "/sendData2.do" })
public class SendData2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SendData2Servlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("sendData2 호출완료");
		//1. 인코딩
		request.setCharacterEncoding("utf-8");
		//2. 값추출
		//name=부가원 & age=25 & addr=서울시+마포구
		String data1 = request.getParameter("name");
		String data2 = request.getParameter("age");
		int data22 = Integer.parseInt(data2);//숫자타입으로 변환
		//int data22 = Integer.parseInt(request.getParameter("age"));
		String data3 = request.getParameter("addr");
		System.out.println(data1);
		System.out.println(data22);
		System.out.println(data3);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
