package aop00;

public class ProxyClient {
    public static void main(String[] args) {
//        Internet internet = new MyInternet();  // 번갈아 가면서 테스트할 것
        Internet internet = new ProxyInternet();  // 번갈아 가면서 테스트할 것

        /* 시나리오 */
        // 실제 인터넷을 사용할 수 있도록 기능을 제공하는 것은 myinternet임.
        // 프록시 인터넷은 어떤 인터넷으로 나가는지 체크만 하여, 블랙리스트인 경우 못나가도록 block처리를 함


        String host1 = "www.medium.com";
        String host2 = "www.facebook.com";
        Status status = internet.openConnection(host1);
        System.out.println(host1 + " Connection status: " + status);
        status = internet.openConnection(host2);
        System.out.println(host2 + " Connection status: " + status);
    }
}
