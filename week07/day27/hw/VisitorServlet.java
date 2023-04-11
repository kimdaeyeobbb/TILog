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

    // 객체 생성시점에 이미 시간이 정해져버리므로 static을 쓰는것은 좋지 않음
//    static{
//        date = LocaleDate.now()
//    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // HttpServletRequest - 요청 관련 기능 (서블릿이 요청될떄까지 클라이언트로부터 요청된 정보를 추출하는 기능)
        // HttpServletResponse - 응답 관련 기능 (수행결과를 클라이언트에 응답할 때 응답용으로 사용함)
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();
        // 문자기반 출력 스트림을 내보냄

        /* post 방식일때 setCharacterEncoding 호출안하고 추출하면 한글이 깨짐 */
        request.setCharacterEncoding("utf-8");
        // 한글깨짐 방지

        String userName = request.getParameter("username");
        String opinion = request.getParameter("opinion");

        /* 날짜 추출 */
        LocalDate today = LocalDate.now();

        out.print("<h2>"+ userName+"님이 "+ today.getYear() +"년 "+ today.getMonthValue()+"월 "+ today.getDayOfMonth()+"일에 남긴 글입니다.</h2>");
        out.print("<p>"+ opinion+"</p>");

        out.print("<a href='"+request.getHeader("referer")+"'>입력화면으로 가기</a>");
        // html에 되돌아가는 uri가 자동으로 만들어짐
        // api를 이용하면 그때그때 요청한것에 대한 정보가 자동으로 생성됨. 따라서 uri가 효율적

        out.close();
    }
}
