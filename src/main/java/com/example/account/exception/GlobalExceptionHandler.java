package com.example.account.exception;

import com.example.account.dto.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import static com.example.account.type.ErrorCode.INVALID_REQUEST;
import static com.example.account.type.ErrorCode.INVALID_SERVER_ERROR;

/**
 * 예외 처리를 위한 핸들러
 * @author 이희영
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountException.class)
    public ErrorResponse handleAccountException(AccountException e) {
        log.error("{} is occurred.", e.getErrorCode());

        return new ErrorResponse(e.getErrorCode(), e.getErrorMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("MethodArgumentNotValidException is occurred.", e);

        return new ErrorResponse(
                INVALID_REQUEST,
                INVALID_REQUEST.getDescription()
        );
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ErrorResponse handleDataIntegrityViolationException(DataIntegrityViolationException e) {
        log.error("DataIntegrityViolationException is ocurred.", e);

        return new ErrorResponse(
                INVALID_REQUEST,
                INVALID_REQUEST.getDescription()
        );
    }

    @ExceptionHandler(Exception.class)
    public ErrorResponse handleException(Exception e) {
        log.error("Exception is ocurred.", e);

        return new ErrorResponse(
                INVALID_SERVER_ERROR,
                INVALID_SERVER_ERROR.getDescription()
        );
    }
}
