package aop00;

import java.util.ArrayList;
import java.util.List;

public class ProxyInternet implements Internet {
    private Internet internet;

    // 리스트 객체
    private static List<String> blackListedHost;
    static {
        // 블록리스트 목록 -> 블랙 리스트로 간주
        blackListedHost = new ArrayList<>();
        blackListedHost.add("www.hacker.com");
        blackListedHost.add("www.facebook.com");
        blackListedHost.add("www.instagram.com");
    }

    // 접속하려고하는지를 확인
    @Override
    public Status openConnection(String host) {
        if (blackListedHost.contains(host)) {  // 블랙리스트에 포함되는 경우
            return Status.BLACKLISTED;
        }

        // 프록시 인터넷을 사용하더라도 내부에서 인터넷을 사용함 (블랙 리스트에 포함된 사이트를 사용하지 않는 경우에 한함)
        if (internet == null) {
            this.internet = new MyInternet();
        }
        return internet.openConnection(host);
    }
}
