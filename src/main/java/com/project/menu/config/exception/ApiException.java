package com.project.menu.config.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpStatusCodeException;

public class ApiException extends HttpStatusCodeException {

    public ApiException(HttpStatus statusCode, String statusText) {
        super(statusText, statusCode, String.valueOf(statusCode.value()), null, null, null);
    }
}
