package com.example.collectionslists090923.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class EmployeeIsNotFoundException extends RuntimeException {
    public EmployeeIsNotFoundException(String message) {
        super(message);
    }
}
