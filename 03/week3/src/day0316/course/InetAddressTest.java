package day0316.course;
import java.net.*;
public class InetAddressTest {
	public static void main(String[] args) throws Exception {
		InetAddress inet = InetAddress.getLocalHost();
		System.out.println(inet);
		inet = InetAddress.getByName("www.naver.com");  // getByName -> 도메인명을 삽입해서 IP주소 알아냄
		System.out.println(inet);
	}
}
