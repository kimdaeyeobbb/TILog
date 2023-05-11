package springws.exam;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Service;


// http://localhost:8088/chattstart 으로 채팅화면 띄우기

@Service
@ServerEndpoint(value="/chatt")
public class WebSocketChatt {

	// 접속한 클라이언트에 대한 정보를 set 객체에 보관
	private static Set<Session> clientSet =
			Collections.synchronizedSet(new HashSet<Session>());

	// open 이벤트 발생시 호출되는 메서드
	@OnOpen
	public void onOpen(Session s) {
		if(!clientSet.contains(s)) {
			clientSet.add(s);
			System.out.println("[세션 오픈] " + s);
		}else {
			System.out.println("이미 연결된 세션임!!!");
		}
	}

	// 클라이언트로부터 메시지 이벤트 발생시 호출되는 메서드
	@OnMessage
	public void onMessage(String msg, Session session) throws Exception{
		System.out.println("[수신 메시지] " + msg);
		for(Session s : clientSet) {
			System.out.println("[송신 메시지] " + msg);
			s.getBasicRemote().sendText(msg);
		}
	}

	// 접속상태가 끊어질때 자동으로 호출되는 메서드
	@OnClose
	public void onClose(Session s) {
		System.out.println("[세션 종료] " + s);
		clientSet.remove(s);
	}
}
