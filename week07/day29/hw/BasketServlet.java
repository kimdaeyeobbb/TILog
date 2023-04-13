package core;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.HashMap;
import org.json.JSONObject;

@WebServlet("/basket")
public class BasketServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html; charset=utf-8");
        PrintWriter out = response.getWriter();  // 문자기반 출력 스트림 내보냄
        String imgId = request.getParameter("imgId");
        System.out.println(imgId);
        HttpSession session = request.getSession();
        // 세션 객체 생성

        JSONObject jo = new JSONObject();
        String msg = "";
        String id = session.getId();
        // 생성된 세션객체의 id 추출

        HashMap<Integer, String> productID = new HashMap<>();
        for(int i = 1; i < 11; i++) {
            productID.put(i, "p00" + i);
        }

        if(session.getAttribute("productKey") == null){
            System.out.println("세션 객체 새로 생성");
            session.setAttribute("cnt",new int[10]);
            // setAttribute(key, value) - key를 사용해서 객체를 세션에 바인딩
        } else {
            System.out.println("세션 객체 추출");
        }

        /* 문자열이 안들어온 경우/안들어온 경우 */
        if(imgId == null){  // 문자열이 안들어온 경우
            session.invalidate();  // 쿼리문자열이 없을 때 세션 삭제
            jo.put("msg", "상품이 모두 삭제되었습니다");
            out.write(jo.toString());
        } else {  // 문자열이 들어온 경우
            int[] count =(int[])session.getAttribute("cnt");
            // cnt라는 이름으로 보관된 객체를 꺼냄
            // 받아올 떄에는 형변환을 해야함 (안그러면 object임. -> 자손에서 추가된것을 가져올 수 없음)

            count[Integer.parseInt(imgId)-1]++;    // 클릭시 선택횟수+1
            int cnt= 0;
            System.out.println("카운팅: "+cnt);
            for (String productName: productID.values()) {
                jo.put(productName, count[cnt++]);
            }
            out.write(jo.toString());
        }
        out.close();
    }
}
