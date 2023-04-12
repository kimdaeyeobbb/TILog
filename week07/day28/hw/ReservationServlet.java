package week07.day28.hw;
//package core;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/reservation")
public class ReservationServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();  // 문자기반 출력 스트림 내보냄
        request.setCharacterEncoding("utf-8");   // 한글깨짐 방지

        /* 예약자명, 룸, 추가 요청 사항, 예약일자 */
        String subscriber = request.getParameter("subscriber");
        String room = request.getParameter("room");
        String extraReq[] = request.getParameterValues("extraReq");
        String bookedDate = request.getParameter("bookedDate");
        String pw = request.getParameter("pw");


        /* 예약자명 - forward */
        if (subscriber == null || subscriber.length() == 0){
            RequestDispatcher rd = request.getRequestDispatcher("/first.html");
            rd.forward(request, response);
            return;   // 밑으로 더이상 내려가지 못하게 return문이 있어야함 (forward는 post가 다끝나고 나서 수행하므로)
            // return을 통해 되돌아가서 forward 수행이 되도록 만듦
        } else {
            out.print("<h1>"+ subscriber +"님의 예약내용</h1><hr>");
        }

        /* 암호 - redirect */
        if(pw == null || pw.length() == 0){
            // if문의 조건으로 pw.equals("")를 써도 됨
            response.sendRedirect("https://www.daum.net/");
            // sendRedirect - 요청 재지정
            return;   // 밑으로 더이상 내려가지 못하게 return문이 있어야 함 (redirect는 post가 다 끝나고 나서 수행하므로)
            // 나머지를 수행하고 리턴하는데 그러한 일이 일어나지 않도록 return
        }

        /* 출력 */
        out.print("<ul>");
        out.print("<li>룸: "+room+"</li>");
        out.print("<li>추가 요청 사항: ");
        if (extraReq != null && extraReq.length != 0){
            // 참조변수를 체크할 때에는 항상 null부터 체크할 것 (null 체크 안했는데 null이 들어오면 nullPointExcepction 오류발생)
            for (int i=0; i<extraReq.length-1; i++){
                out.print(extraReq[i]+", ");
            }
            out.print(extraReq[extraReq.length-1]);
        } else {
            out.print("없음");
        }
        out.print("</li>");
        out.print("<li>예약날짜: "+ bookedDate.split("-")[0] +"년 "+bookedDate.split("-")[1]+"월 "+ bookedDate.split("-")[2]+"일" + "</li>");
        out.print("</ul>");

        out.print("<a href='"+request.getHeader("referer")+"'>예약입력화면으로</a>");
        // 클라이언트가 누구든 상관없이 클라이언트의 uri 또는 url 정보를 추출해줌
        out.close();
    }
}
