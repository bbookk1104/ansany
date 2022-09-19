package kr.or.iei.photo.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import kr.or.iei.notice.vo.Notice;
import kr.or.iei.photo.model.service.PhotoService;
import kr.or.iei.photo.model.vo.Photo;

/**
 * Servlet implementation class PhotoWriteServlet
 */
@WebServlet(name = "PhotoWrite", urlPatterns = { "/photoWrite.do" })
public class PhotoWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PhotoWriteServlet() {
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
		/*2-1. 파일이 업로드될 경로를 지정
		root : webapp폴더의 절대경로 가져옴(c드라이브부터 탐색)
		saveDirectory : 저장경로 지정*/
		String root = getServletContext().getRealPath("/");
		String saveDirectiory = root + "upload/photo";
		/*2-2. 파일 업로드 최대용량 설정(일반적인 웹은 최대용량 10MB)*/
		int maxSize = 10*1024*1024;
		/*2-3. multipart/form-data에서 데이터를 꺼내기위한 객체변환
		request를 MultipartRequest객체로 변환(cos.jar)
		매개변수 5개를 전달하면서 객체 생성
		1)request
		2)저장경로 = saveDirectory
		3)파일최대용량 = 2-2에서 지정한 변수나 값
		4)인코딩타입 = "utf-8"
		5)파일명중복처리객체 = new DefaultFileRenamePolicy()*/
		MultipartRequest mRequest = new MultipartRequest(
				request, saveDirectiory,
				maxSize, "utf-8",
				new DefaultFileRenamePolicy()
				);
		/*MultipartRequest객체가 생성되는 시점에 파일 업로드가 완료됨
		데이터를 request에서 추출하면 모두 null로 리턴되기 때문에 데이터추출은 MultipartRequest에서 수행한다.*/
		/*2-4. 진짜최종 값추출[mRequest.getParameter("");]해서 Photo객체로 저장*/
		Photo p = new Photo();
		p.setPhotoTitle(mRequest.getParameter("photoTitle"));
		p.setPhotoWriter(mRequest.getParameter("photoWriter"));
		p.setPhotoContent(mRequest.getParameter("photoContent"));
		p.setFilepath(mRequest.getFilesystemName("imageFile"));//input[type=file]의 name값
		//3. 비즈니스로직
		PhotoService service = new PhotoService();
		int result = service.insertPhoto(p);
		//4. 결과처리
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp");
		if(result>0) {
			request.setAttribute("title", "등록 완료");
			request.setAttribute("msg", "등록이 완료되었습니다.");
			request.setAttribute("icon", "success");
		}else {
			request.setAttribute("title", "등록 실패");
			request.setAttribute("msg", "등록에 실패하였습니다.");
			request.setAttribute("icon", "error");
		}
		request.setAttribute("loc", "/photoList.do");
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
