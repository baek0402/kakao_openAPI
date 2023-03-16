package openAPI.TmiBoard.controller;

import lombok.extern.slf4j.Slf4j;
import openAPI.TmiBoard.dto.out.ResponseDto;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Slf4j
@RestControllerAdvice
public class MyboardControllerAdvice {

    //@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseDto<Void> handleUnknownException(MethodArgumentNotValidException e) {
        String errorId = UUID.randomUUID().toString();
        log.error("[{}] Unknown Exception. message={}", errorId, e.getMessage(), e);
        return new ResponseDto<>(String.format("[%s] JSON으로 넘어온 값을 확인하세요. msg: %s", errorId, e.getMessage()));
    }

    /*@ExceptionHandler(Exception.class)
    protected ResponseDto<Void> handleUnknownException(Exception e) {
        String errorId = UUID.randomUUID().toString();
        log.error("[{}] Unknown Exception. message={}", errorId, e.getMessage(), e);
        return new ResponseDto<>(String.format("[%s] 알 수 없는 오류가 발생하였습니다. msg: %s", errorId, e.getMessage()));
    }*/

    @ExceptionHandler({DataAccessException.class, JpaSystemException.class})
    public ResponseDto<?> handleDataAccessException(DataAccessException e1, JpaSystemException e2) {

        return new ResponseDto<>(String.format("JPA관련 오류가 발생했습니다"));
        // 데이터 액세스 예외 처리
    }

}
