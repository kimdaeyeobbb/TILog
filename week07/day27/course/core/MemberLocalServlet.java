package week07.day27.course.core;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/memberlocal")  //     /memberlocal - 매핑 path
public class MemberLocalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int member_v = 0;  // 멤버변수
	// static이 아닌 멤버변수 - 객체 생성시 메모리 할당이 됨
	// 서버가 죽을 떄까지 모든 클라이언트가 공유하며 유지됨
	// 내가 만든게 다른 유저가 공유하지 않았으면 하는 경우 - 쇼핑카트 => 클라이언트별로 생성.
	// 쇼핑 카트를 멤버변수로 만들면 모든 클라이언트가 선택한 상품이 한곳에 모임. 지역변수로 만들면 유지가 안됨.
	// 따라서 개별 클라이언트별로 원하는 데이터가 유지되게 만들고 싶으면 데이터를 세션이 보관함
	// 로그인은 세션으로 처리함

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			// doGet을 오버라이딩
			// url 입력하는것은 get 방식

			throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		// getWriter 보다 setContent를 먼저 호출해야 함
		int local_v = 0;  // 지역 변수
		// 지역변수 - 메서드가 호출될때마다 메모리 할당됨
		// 요칭시마다 메모리 할당. 데이터를 유지하고 싶으면 지역변수에 담으면 안됨

		member_v++;
		local_v++;
		out.print("<h2>member_v(멤버변수) : " + member_v +"ㅋㅋㅋ"+ "</h2>");
		out.print("<h2>local_v(지역변수) : " + local_v + "</h2>");
		out.close();
	}
}
