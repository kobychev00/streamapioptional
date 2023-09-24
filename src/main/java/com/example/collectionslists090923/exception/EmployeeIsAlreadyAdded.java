package com.example.collectionslists090923.exception;

public class EmployeeIsAlreadyAdded extends RuntimeException {
    public EmployeeIsAlreadyAdded(String message) {
        super(message);
    }
}
