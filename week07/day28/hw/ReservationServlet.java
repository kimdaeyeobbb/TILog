//package week07.day28.hw;
package core;

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
        } else {
            out.print("<h1>"+ subscriber +"님의 예약내용</h1><hr>");
        }

        /* 암호 - redirect */
        if(pw == null || pw.length() == 0){
            response.sendRedirect("https://www.daum.net/");
        }

        /* 출력 */
        out.print("<ul>");
        out.print("<li>룸: "+room+"</li>");
        out.print("<li>추가 요청 사항: ");
        if (extraReq != null && extraReq.length != 0){
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
        out.close();
    }
}
