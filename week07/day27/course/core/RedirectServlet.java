package core;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/redirect")
public class RedirectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("RedirectServlet 수행");
		response.sendRedirect("/edu/clientexam/output.html");
		// 네트워크창을 열어놓고 테스트하면 서버에서 302라는 응답코드와 함께 다시 요청해서 가져갈 페이지에 대한 url이 같이 옴
		// 성공했을 경우에는 200이라는 응답코드가 옴

		//response.sendRedirect("http://www.naver.com/");
		// 포워드는 네이버 url 앞에도 무조건 /edu를 무조건 붙이므로 이렇게 이용할 수 없음
	}
}