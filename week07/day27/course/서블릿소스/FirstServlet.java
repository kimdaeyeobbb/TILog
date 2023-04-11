package week07.day27.course.서블릿소스;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/FirstServlet")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// HttpServletRequest - 요청 관련 기능 (서블릿이 요청될떄까지 클라이언트로부터 요청된 정보를 추출하는 기능)
		// HttpServletResponse - 응답 관련 기능 (수행결과를 클라이언트에 응답할 때 응답용으로 사용함)
		System.out.println("FirstServlet 실행.....");
		response.setContentType("text/html; charset=utf-8");
		// 서블릿에서는 System.out.println이 클라이언트에게 전달되지 않고 톰캣을 기동시킨 창에 뜬다.
		// utf 대신 ufc입력하면 error

		PrintWriter out = response.getWriter();
		// 문자기반 출력 스트림을 내보냄

		out.print("<h1>안녕? Servlet!</h1>");
		out.close();
	}
}
