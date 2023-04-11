package week07.day27.hw;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Locale;

@WebServlet("/myfirst")
public class MyFirstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // get 방식 지원을 위해 doGet 오버라이딩
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        /* 쿼리 문자열 추출 */
        String userName = request.getParameter("guestName");

        /* 날짜 추출 */
        LocalDate currentDate = LocalDate.now();
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        String whatDay = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN);


        if(userName != null){
            out.print("<h2>"+ userName+"님 반가워요.." + "오늘은 " + whatDay +"입니다!!" );
        } else {
            out.print("<h2> GUEST님 반가워요.." + "오늘은 " + whatDay +"입니다!!" );
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // post 기능 지원을 위해 doPost 오버라이딩
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }
}
