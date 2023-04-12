package week07.day28.course;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CountServlet")
public class CountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		if(session.getAttribute("cnt") == null) {  // 추출하는메서드 (이 과정은 1번만 수행. 등록하고나서 또 등록하지 않으므로.)
			// 등록되어있는데 또 등록하면 마지막것만 남음
			// 상태정보저장하는 객체를 아직 등록하지 않은 것
			// 반드시 저장하고자 하는 것은 name&value쌍이어야 함

			session.setAttribute("cnt", new int[1]);
			// 배열 객체의 주소값(참조값)을 cnt라는 이름으로 등록함
		}
		int[] count = (int[])session.getAttribute("cnt");
		// cnt라는 이름으로 보관된 객체를 꺼냄
		// 받아올 떄에는 형변환해서 받아와야함. 안그러면 object. object는 자손에서 추가된것은 가져올 수 없으므로 형변환 연산자를 붙여야 함


		count[0]++;
		out.print("<h3>당신은 "+ count[0] + 
				                       "번째 방문입니다.</h3>");		
		out.close();
	}
}



