package aop00;

public interface Internet {
    public Status openConnection(String host);
    // status -> enum임 (3개 값중 하나가 추출될 것임)
}
