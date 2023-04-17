package day16.course.mvc;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;

import static org.junit.jupiter.api.Assumptions.assumeTrue;

@DisplayName("첫번째 JUnit 테스트 클래스")
class MySQLConnectTest {

    @Test
    @DisplayName("DB서버 접속 확인")
    void connect() {
        assumeTrue(MySQLConnect.connect() instanceof Connection);
    }
}