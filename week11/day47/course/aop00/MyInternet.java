package aop00;

public class MyInternet implements Internet {

    @Override
    public Status openConnection(String host) {
        System.out.println("Connecting to host: " + host);
        return Status.SUCCESS;  // 무조건 인터넷 사용을 할 수 있게 시나리오 작성
    }
}
