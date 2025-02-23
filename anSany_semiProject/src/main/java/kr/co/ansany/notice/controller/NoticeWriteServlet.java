package kr.co.ansany.notice.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.co.ansany.notice.model.service.NoticeService;
import kr.co.ansany.notice.model.vo.Notice;

/**
 * Servlet implementation class NoticeWriteServlet
 */
@WebServlet(name = "NoticeWrite", urlPatterns = { "/noticeWrite.do" })
public class NoticeWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public NoticeWriteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String root = getServletContext().getRealPath("/");
		String saveDirectory = root + "upload/notice";
		int maxSize = 10 * 1024 * 1024;
		MultipartRequest mRequest = new MultipartRequest(request, saveDirectory, maxSize, "UTF-8",
				new DefaultFileRenamePolicy());

		String noticeTitle = mRequest.getParameter("noticeTitle");
		String noticeContent = mRequest.getParameter("noticeContent");

		String filename = mRequest.getOriginalFileName("upfile");
		String filepath = mRequest.getFilesystemName("upfile");
		Notice n = new Notice();
		n.setNoticeTitle(noticeTitle);
		n.setNoticeContent(noticeContent);
		n.setNoticeContent(noticeContent);
		n.setNoticeFilename(filename);
		n.setNoticeFilepath(filepath);

		NoticeService service = new NoticeService();
		int result = service.insertNotice(n);
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if (result > 0) {
			request.setAttribute("title", "성공");
			request.setAttribute("msg", "공지사항이 등록 되었습니다.");
			request.setAttribute("icon", "success");
		} else {
			request.setAttribute("title", "실패");
			request.setAttribute("msg", "등록에 실패했습니다.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/noticeList.do?reqPage=1");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
