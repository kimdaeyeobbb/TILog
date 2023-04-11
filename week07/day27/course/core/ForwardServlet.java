package core;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/forward")  // 매핑정보. 요청시 /edu/forward 입력시 doGet 메서드가 호출됨
public class ForwardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ForwardServlet 수행");
// 호출되자마자  출력

		// 포워드는 리퀘스트디스패처 인터페이스를 생성해야 제기능을 함
		// 수행코드는 WAS가 제공함
		// 인터페이스이므로 new를 사용할 수 없고 팩토리 메서드를 이용해야함 (getRequestDispatcher)
		RequestDispatcher rd =
				request.getRequestDispatcher("/edu/clientexam/output.html");
		// context path인 edu를 추가하면 에러가 발생 - 스스로 /edu를 무조건 붙임
		// 같은 웹 애플리케이션 안에서만 되고 다른 웹 애플리케이션에서는 안되게 하기 위해 스스로 /edu를 이미 붙임
		// 따라서 포워드할 대상을 지정할 경우에는 context path를 빼고 나머지만 주는것임
		// 포워드될 대상정보를 context path를 뺴고 나머지 uri를 제공

//				request.getRequestDispatcher("/clientexam/output.html");
		// 리퀘스트 디스패쳐 객체를 생성해서 포워드 대상정보를 넘겨줌
		// 대상: /clientexam/output.html


		/*RequestDispatcher rd = 
				request.getRequestDispatcher("http://www.naver.com/");*/
		rd.forward(request,  response);
	}
}