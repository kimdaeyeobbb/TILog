package week07.day27.course.core;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet( {"/queryget", "/querypost"} )
public class QueryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// get방식 지원하기 위해 doGet 오버라이딩
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		/* 쿼리문자열 추출 부분 */
		String userName = request.getParameter("guestName");
		// guestName으로 쿼리가 안오면 null 리턴. 쿼리가 왔는데 없으면 null 문자열 리턴
		int number = Integer.parseInt(request.getParameter("num"));
		String food[] = request.getParameterValues("food");
		/* 여기까지가 클라이언트에서 전송되는 name 쌍과 똑같은 name을 지정해서 values를 추출 */
		// food 라는 이름으로 쿼리가 안오면 null. 쿼리가 왔으면 value가 비어있으면 비어있는 String형 배열을 리턴


		if (food != null && food.length != 0) {
			out.print("<h2>좋아하는 음식</h2>");
			out.print("<ul>");
			for(String f : food)
				out.print("<li>"+f+"</li>");
			out.print("</ul>");			
		} else {
			out.print("<h2>좋아하는 음식이 없군요</h2>");
		}
		out.print("<h2>요청 방식 : " + request.getMethod() + "</h2>");
		// 요청방식 확인하기 위해서 사용

		out.print("<h2>요청 URI : " + request.getRequestURI() + "</h2>");
		// 요청 대상의 URI 정보만 추출할 때 사용

		out.print("<h2>당신의 이름은 "+
		                  userName+"이군요!</h2>");
		out.print("<h2>당신이 좋아하는 숫자는 "+
                number+"이군요!</h2>");
		out.print("<a href='"+request.getHeader("referer")+"'>입력화면으로 가기</a>");
		// 서블릿을 요청한 HTML 파일로 옮겨가는 기능
		// 이번 요청을 요청한 페이지의 url 정보를 추출

		out.close();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// post기능 지원하기 위해서 doPost 오버라이딩
		request.setCharacterEncoding("utf-8");  // 한글 깨짐 방지
		doGet(request, response);
	}
}



