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
// localhost:8088/edu/myfirst?guestName=대니 => 이것이 쿼리문자열을 주는것임

public class MyFirstServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // get 방식 지원을 위해 doGet 오버라이딩
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();

        /* 쿼리 문자열 추출 */
        String userName = request.getParameter("guestName");
        // 서블릿 컨테이너가 HttpServletRequest request, HttpServletResponse response 객체를 생성
        // getParameter ->


        /* 날짜 추출 */
        LocalDate currentDate = LocalDate.now();
        DayOfWeek dayOfWeek = currentDate.getDayOfWeek();
        String whatDay = dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN);


        if(userName != null){
            out.print("<h2>"+ userName+"님 반가워요.." + "오늘은 " + whatDay +"입니다!!" );
        } else {
            out.print("<h2> GUEST님 반가워요.." + "오늘은 " + whatDay +"입니다!!" );
        }
        out.close();   // close()를 안하면 톰캣은 알아서 close해주지만 다른 WAS는 그렇지 않으므로 close()를 빼면 안됨
    }

    // 메서드를 따로 만들어도 됨
//    private String getDay(){}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // post 기능 지원을 위해 doPost 오버라이딩
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }
}
