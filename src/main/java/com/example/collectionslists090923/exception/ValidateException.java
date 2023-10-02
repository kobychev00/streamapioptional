package com.example.collectionslists090923.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.client.HttpStatusCodeException;

public class ValidateException extends HttpStatusCodeException {

    public ValidateException(String message) {
        super(HttpStatus.BAD_REQUEST, message);
    }
}
