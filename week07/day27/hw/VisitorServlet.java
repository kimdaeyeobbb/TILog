package week07.day27.hw;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

@WebServlet("/visitorpost")
public class VisitorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // HttpServletRequest - 요청 관련 기능 (서블릿이 요청될떄까지 클라이언트로부터 요청된 정보를 추출하는 기능)
        // HttpServletResponse - 응답 관련 기능 (수행결과를 클라이언트에 응답할 때 응답용으로 사용함)
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        // 문자기반 출력 스트림을 내보냄

        String userName = request.getParameter("username");
        String opinion = request.getParameter("opinion");

        /* 날짜 추출 */
        LocalDate today = LocalDate.now();


        out.print("<h2>"+ userName+"님이 "+ today.getYear() +"년 "+ today.getMonthValue()+"월 "+ today.getDayOfMonth()+"일에 남긴 글입니다.</h2>");
        out.print("<p>"+ opinion+"</p>");


        out.print("<a href='"+request.getHeader("referer")+"'>입력화면으로 가기</a>");
        out.close();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // post기능 지원하기 위해서 doPost 오버라이딩
        request.setCharacterEncoding("utf-8");  // 한글 깨짐 방지
        doGet(request, response);
    }
}
