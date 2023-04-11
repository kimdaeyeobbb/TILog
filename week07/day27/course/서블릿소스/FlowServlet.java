package core;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/flow")  // 매핑명 - /flow
public class FlowServlet extends HttpServlet {
	// 서블릿은 최초 요청시 객체가 생성됨

	private static final long serialVersionUID = 1L;
	public FlowServlet() {
		super();
		System.out.println("FlowServlet 객체 생성....");
	}

	/* 콜백 메서드 - 약속한 시점에 자동으로 호출됨 */
	public void init(ServletConfig config) throws ServletException {
		// 서블릿 최초요청시 한번만 생성 (생성자와 유사)
		// 최초 1번만 수행하고 싶으면 init에 구현

		System.out.println("init() 메서드 호출....");
	}
	public void destroy() {
		// 서블릿 객체가 메모리에서 사라질 때 (서버가 종료될때, 자동 리로드가 수행되었을 때)
		System.out.println("destroy() 메서드 호출....");
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// service를 오버라이딩
		// 서비스가 doGet, doPost를 대신함
		System.out.println("service() 메서드 호출....");
	}

}
