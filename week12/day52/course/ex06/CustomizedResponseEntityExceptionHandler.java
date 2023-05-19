package springrest.exam.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

// ResponseEntityExceptionHandler를 상속받는 클래스
// 사용하는 시스템에서 에러가 발생하게되면,
// 에러를 핸들링하기 위해 스프링 부트에서 제공되는 클래스
@RestController
@ControllerAdvice
// aop가 적용된 클래스를 만드는 결과가 됨. 아래 코드를 보면 에러 메시지를 추출해서 responseentity객체로 리턴하게 만듦
// 예외 발생시 모든 예외를 처리하게 만듦
// validation관련 문제가 생기면 그에 대한 예외메시지 및 상태코드가 같이 응답되게 만들어줌
// 모든 컨트롤러가 실행이 될때 @ControllerAdvice 어노테이션을 가지고 있는 빈이 실행되게 되어있는데
// 만약 에러가 발생하면 예외 핸들러 클래스가 실행됨
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // 사용자가 존재하지않았을 때 사용하는 UserNotFound Exception
    @ExceptionHandler(UserNotFoundException.class)
    public final ResponseEntity<Object> handleUserNotFoundException(Exception ex, WebRequest request){

        ExceptionResponse exceptionResponse = new ExceptionResponse( new Date(), ex.getMessage(), request.getDescription(false));
        // NOT_FOUND
        return new ResponseEntity(exceptionResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers,
                                                                  HttpStatus status,
                                                                  WebRequest request) {

        ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(),
                ex.getMessage(),ex.getBindingResult().toString());

        return new ResponseEntity(exceptionResponse,HttpStatus.BAD_REQUEST);
    }
}
