package com.project.menu.config.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.xml.bind.ValidationException;


@ControllerAdvice
public class ApiExceptionHandler {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApiExceptionHandler.class);

    @ExceptionHandler(ApiException.class)
    protected ResponseEntity<ApiExceptionInfo> handleApiException(
        ApiException e) {
        LOGGER.error("API Exception : {}", e.getMessage());
        for (StackTraceElement element : e.getStackTrace()) {
            LOGGER.error("{}", element.toString());
        }
        final ApiExceptionInfo response = new ApiExceptionInfo();
        response.setHttpStatus(e.getStatusCode());
        response.setMessage(e.getMessage());
        response.setSuccess(false);
        response.setErrorCode(e.getStatusText());


        return new ResponseEntity<>(response, e.getStatusCode());
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<ApiExceptionInfo> handleMethodArgumentNotValidException(
        MethodArgumentNotValidException e) {
        LOGGER.error("API Exception : {}", e.getMessage());
        for (StackTraceElement element : e.getStackTrace()) {
            LOGGER.error("{}", element.toString());
        }
        final ApiExceptionInfo response = new ApiExceptionInfo();
        response.setHttpStatus(HttpStatus.BAD_REQUEST);
        response.setMessage(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
        response.setSuccess(false);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<ApiExceptionInfo> handleExceptions(Exception e) {
        LOGGER.error("API Exception : {}", e.getMessage());
        for (StackTraceElement element : e.getStackTrace()) {
            LOGGER.error("{}", element.toString());
        }
        final ApiExceptionInfo response = new ApiExceptionInfo();
        response.setHttpStatus(HttpStatus.INTERNAL_SERVER_ERROR);
        response.setMessage(e.getMessage());
        response.setSuccess(false);

        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ValidationException.class)
    protected ResponseEntity<ApiExceptionInfo> validationException(ValidationException e) {
        LOGGER.error("API Exception : {}", e.getMessage());
        for (StackTraceElement element : e.getStackTrace()) {
            LOGGER.error("{}", element.toString());
        }
        final ApiExceptionInfo response = new ApiExceptionInfo();
        response.setHttpStatus(HttpStatus.BAD_REQUEST);
        String message = e.getMessage();
        String[] splited= message.split(": ");
        String pureMessage = splited[splited.length - 1];
        response.setMessage(pureMessage);
        response.setSuccess(false);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
