package controller;

import model.domain.TimeVO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

@WebServlet("/lotto1")
public class LottoServlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        // 1. 쿼리문자열로 전달되는 로또 번호 추출
        int lottoNum = Integer.parseInt(request.getParameter("num"));

        // 2. 1~6 사이의 랜덤값 추출
        int randNum = (int)(Math.random()*6+1);

        // 3. 톰캣 콘솔창에 "전달된 값 : X, 추출된 값 : X"를 출력
        System.out.printf("전달된 값 : %d, 추출된 값 : %d\n", lottoNum, randNum);

        // 4. 현재 시간 정보로 TimeVO 객체를 생성하여 응답용 JSP에게 전달하기 위해 저장함
        LocalTime now = LocalTime.now(); // 현재시간
        int hour = now.getHour();  // 시
        int minute = now.getMinute();   // 분

        TimeVO vo = new TimeVO(now.getHour(), now.getMinute());  // 객체 생성
        request.setAttribute("curTime", vo);// 저장


        // 5. 클라이언트에서 전달한 숫자와 동일하면   /jspexam/success.jsp 에 forward 하고 동일하지 않으면 /jspexam/fail.jsp 에 forward 한다.
        if(lottoNum == randNum){
            request.getRequestDispatcher("/jspexam/success.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("/jspexam/fail.jsp").forward(request, response);
        }
    }
}
