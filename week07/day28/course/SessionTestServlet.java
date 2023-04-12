package week07.day28.course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@WebServlet("/sessiontest")
public class SessionTestServlet extends HttpServlet {	
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		String command = request.getParameter("comm");
		// comm이라고 전달되는 쿼리문자열을 가져오겠다는 것
		// comm을 가져오지 않으면 nullpointerexception 발생
		HttpSession session = request.getSession();
		// 세션 객체 생성 (사실 생성보다는 '준비'가 맞다)
		//

		String msg="";
		long time = session.getCreationTime();
		String id = session.getId();
		//생성된 세션객체의 id 추출

	    if(command.equals("view")) {
			// command가 지금 null이므로 equals를 호출할 수 없음 -> 따라서 nullpointerexception 발생
			// 에러를 발생시키지 않으려면 comm이라는

			if(session.isNew()) {
				// 세션변수가 참조하고 있는 세션 객체가 처음 만들어졌는지를 판단하는 것
				msg = "세션 객체 생성 : "; 
			} else {
				msg = "세션 객체 추출 : "; 
			}
			// http://localhost:8088/edu/sessiontest?comm=view를 url에 입력시 에러가 나지 않음
			// 생성되는 세션 아이디는 랜덤하게 만들어짐

			msg += "<br>id : " + id + " <br>time : " +
			                new Date(time);
		} else if (command.equals("delete")) {
			session.invalidate();
			msg = id + "을 id로 갖는 세션 객체 삭제!!";
		} else {
			msg = "요청시 Query 문자열로 comm=view 또는 comm=delete 를 "
					+ "전달해주세요!!";
		}
		out.print("<h2>"+ msg+"</h2>");
		out.close();
	}
}



