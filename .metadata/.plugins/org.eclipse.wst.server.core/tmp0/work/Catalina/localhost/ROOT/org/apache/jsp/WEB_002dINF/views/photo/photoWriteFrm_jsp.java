/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.82
 * Generated at: 2022-09-07 03:02:53 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.WEB_002dINF.views.photo;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import kr.or.iei.member.vo.Member;

public final class photoWriteFrm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/views/common/header.jsp", Long.valueOf(1662453898560L));
    _jspx_dependants.put("/WEB-INF/views/common/footer.jsp", Long.valueOf(1661910696206L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("kr.or.iei.member.vo.Member");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>사진게시판 작성</title>\r\n");
      out.write("<style>\r\n");
      out.write("	.photoWrite td, .photoWrite th{\r\n");
      out.write("		border : 1px solid #eee;\r\n");
      out.write("	}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");

    	Member m = (Member)session.getAttribute("m");
    
      out.write("\r\n");
      out.write("    <!-- 구글 아이콘 -->\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/icon?family=Material+Icons\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- jquery -->\r\n");
      out.write("    <script src=\"/js/jquery-3.6.0.js\"></script>\r\n");
      out.write("    <!-- 기본 CSS -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"/css/default.css\" />\r\n");
      out.write("    <!-- 기본 js -->\r\n");
      out.write("    <script src=\"/js/default.js\"></script>\r\n");
      out.write("	<header>\r\n");
      out.write("      <div class=\"site-logo\">\r\n");
      out.write("        <a href=\"/\">BOOOOP!</a>\r\n");
      out.write("      </div>\r\n");
      out.write("      <nav>\r\n");
      out.write("        <ul class=\"navi\">\r\n");
      out.write("          <li><a href=\"/noticeList.do?reqPage=1\">공지사항</a></li>\r\n");
      out.write("          <li><a href=\"#\">자유게시판</a></li>\r\n");
      out.write("          <li><a href=\"/ajax.do\">AJAX</a></li>\r\n");
      out.write("          <li><a href=\"/photoList.do\">사진게시판</a></li>\r\n");
      out.write("          <li>\r\n");
      out.write("			<a href=\"#\">메뉴-5</a>\r\n");
      out.write("            <ul class=\"sub-navi\">\r\n");
      out.write("              <li><a href=\"#\">sub-1</a></li>\r\n");
      out.write("              <li><a href=\"#\">sub-2</a></li>\r\n");
      out.write("              <li><a href=\"#\">sub-3</a></li>\r\n");
      out.write("            </ul>\r\n");
      out.write("           </li>\r\n");
      out.write("        </ul>\r\n");
      out.write("      </nav>\r\n");
      out.write("      <div class=\"header-link\">\r\n");
      out.write("      	");
if(m==null) {
      out.write("\r\n");
      out.write("        <button class=\"btn bc11 modal-open-btn\" target=\"#login-modal\">SIGN IN</button>\r\n");
      out.write("        <a class=\"btn bc11\" href=\"/signupFrm.do\">SIGN UP</a>\r\n");
      out.write("        ");
} else{ 
      out.write("\r\n");
      out.write("        <!-- <a class=\"btn bc11\" href=\"/mypage1.do\">");
      out.print(m.getMemberName() );
      out.write("</a> -->\r\n");
      out.write("        <a class=\"btn bc11\" href=\"/mypage2.do?memberId=");
      out.print(m.getMemberId());
      out.write('"');
      out.write('>');
      out.print(m.getMemberName() );
      out.write("</a>\r\n");
      out.write("        <a class=\"btn bc11\" href=\"/logout.do\">LOGOUT</a>        \r\n");
      out.write("        ");
} 
      out.write("\r\n");
      out.write("      </div>\r\n");
      out.write("    </header>\r\n");
      out.write("    ");
if(m==null) {
      out.write("\r\n");
      out.write("    <div id=\"login-modal\" class=\"modal-bg\">\r\n");
      out.write("      <div class=\"modal-wrap\">\r\n");
      out.write("        <div class=\"modal-head\">\r\n");
      out.write("          <h2>SIGN IN</h2>\r\n");
      out.write("          <span class=\"material-icons close-icon modal-close\">close</span>\r\n");
      out.write("        </div>\r\n");
      out.write("        <form action=\"/signin.do\" method=\"post\">\r\n");
      out.write("	        <div class=\"modal-content\">\r\n");
      out.write("	          <div class=\"input-box\">\r\n");
      out.write("	          	<label for=\"signId\">아이디</label>\r\n");
      out.write("	          	<input type=\"text\" name=\"signId\" id=\"signId\" class=\"input-form\" placeholder=\"아이디입력\">\r\n");
      out.write("	          </div>\r\n");
      out.write("	          <div class=\"input-box\">\r\n");
      out.write("	          	<label for=\"signPw\">비밀번호</label>\r\n");
      out.write("	          	<input type=\"password\" name=\"signPw\" id=\"signPw\" class=\"input-form\" placeholder=\"비밀번호입력\">\r\n");
      out.write("	          </div>\r\n");
      out.write("	          <div class=\"input-box link-box\">\r\n");
      out.write("	          	<a href=\"/searchIdPwFrm.do\">아이디/비밀번호 찾기</a>\r\n");
      out.write("	          </div>\r\n");
      out.write("	        </div>\r\n");
      out.write("	        <div class=\"modal-foot\">\r\n");
      out.write("	          <button type=\"submit\" class=\"btn bc11\">로그인</button>\r\n");
      out.write("	          <button type=\"button\" class=\"btn bc1 modal-close\">취소</button>\r\n");
      out.write("	        </div>\r\n");
      out.write("        </form>\r\n");
      out.write("      </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    ");
} 
      out.write("\r\n");
      out.write("	<div class=\"page-content\">\r\n");
      out.write("		<div class=\"page-title\">사진게시판 작성</div>\r\n");
      out.write("		<form action=\"/photoWrite.do\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("			<table class=\"tbl photoWrite\">\r\n");
      out.write("				<tr class=\"tr-1\">\r\n");
      out.write("					<th class=\"td-2\">제목</th>\r\n");
      out.write("					<td colspan=\"3\">\r\n");
      out.write("						<input type=\"text\" name=\"photoTitle\" class=\"input-form\">\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr class=\"tr-1\">\r\n");
      out.write("					<th class=\"td-2\">작성자</th>\r\n");
      out.write("					<td>\r\n");
      out.write("						");
      out.print(m.getMemberId() );
      out.write("\r\n");
      out.write("						<input type=\"hidden\" name=\"photoWriter\" value=\"");
      out.print(m.getMemberId());
      out.write("\">\r\n");
      out.write("					</td>\r\n");
      out.write("					<th class=\"td-2\">이미지</th>\r\n");
      out.write("					<td>\r\n");
      out.write("						<input type=\"file\" name=\"imageFile\" accept=\".jpg,.png,.jpeg\" onchange=\"loadImg(this);\">\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr class=\"tr-1\">\r\n");
      out.write("					<th class=\"td-2\">이미지 미리보기</th>\r\n");
      out.write("					<td colspan=\"3\">\r\n");
      out.write("						<div id=\"img-viewer\">\r\n");
      out.write("							<img id=\"img-view\" width=\"500px\">\r\n");
      out.write("						</div>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr class=\"tr-1\">\r\n");
      out.write("					<th class=\"td-2\">내용</th>\r\n");
      out.write("					<td colspan=\"3\">\r\n");
      out.write("						<textarea name=\"photoContent\" class=\"input-form\"></textarea>\r\n");
      out.write("					</td>\r\n");
      out.write("				</tr>\r\n");
      out.write("				<tr class=\"tr-1\">\r\n");
      out.write("					<th colspan=\"4\">\r\n");
      out.write("						<button type=\"submit\" class=\"btn bc22 bs4\">등록</button>\r\n");
      out.write("					</th>\r\n");
      out.write("				</tr>\r\n");
      out.write("			</table>\r\n");
      out.write("		</form>\r\n");
      out.write("	</div>\r\n");
      out.write("	<script>\r\n");
      out.write("		function loadImg(f){\r\n");
      out.write("			//첨부파일이 여러개일 수 있으므로 항상 배열처리\r\n");
      out.write("			console.log(f.files);//input에서 file을 선택하면 해당 파일이 들어있는 배열\r\n");
      out.write("			if(f.files.length !=0 && f.files[0] != 0){\r\n");
      out.write("				const reader = new FileReader();//파일정보를 읽어올 수 있는 객체\r\n");
      out.write("				reader.readAsDataURL(f.files[0]);//선택한 파일정보 읽어옴\r\n");
      out.write("				//파일리더가 파일을 다 읽어오면 동작할 함수 작성\r\n");
      out.write("				reader.onload = function(e){\r\n");
      out.write("					$(\"#img-view\").attr(\"src\",e.target.result);\r\n");
      out.write("				}\r\n");
      out.write("			}else{\r\n");
      out.write("				$(\"#img-view\").attr(\"src\",\"\");\r\n");
      out.write("			}\r\n");
      out.write("		}\r\n");
      out.write("	</script>\r\n");
      out.write("	");
      out.write("\r\n");
      out.write("	<footer>\r\n");
      out.write("      <div class=\"footer-content\">\r\n");
      out.write("        <ul>\r\n");
      out.write("          <li><a href=\"#\">이용약관</a></li>\r\n");
      out.write("          <li><a href=\"#\">개인정보취급방침</a></li>\r\n");
      out.write("          <li><a href=\"#\">인재채용</a></li>\r\n");
      out.write("          <li><a href=\"#\">제휴문의</a></li>\r\n");
      out.write("          <li><a href=\"#\">인스타그램</a></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("        <p>Made by LeeYunSu</p>\r\n");
      out.write("        <p>\r\n");
      out.write("          KH정보교육원 당산지원 A강의장 수업자료입니다. 무단복제를 허용하지\r\n");
      out.write("          않습니다.\r\n");
      out.write("        </p>\r\n");
      out.write("      </div>\r\n");
      out.write("    </footer>");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
