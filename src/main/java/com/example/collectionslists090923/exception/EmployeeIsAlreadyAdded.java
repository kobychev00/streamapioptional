package com.example.collectionslists090923.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class EmployeeIsAlreadyAdded extends RuntimeException {
    public EmployeeIsAlreadyAdded(String message) {

        super(message);
    }

    public EmployeeIsAlreadyAdded(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeIsAlreadyAdded(Throwable cause) {
        super(cause);
    }

    public EmployeeIsAlreadyAdded(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
