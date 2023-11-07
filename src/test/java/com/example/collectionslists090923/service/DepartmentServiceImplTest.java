package com.example.collectionslists090923.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DepartmentServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;
    @Test
    void getEmployeeWithMaxSalary_success() {
    }

    @Test
    void getEmployeeWithMaxSalary_withEmployeeNotFoundException() {

    }

    @Test
    void getEmployeeWithMinSalary_success() {
    }

    @Test
    void getEmployeeWithMinSalary_withEmployeeNotFoundException() {
    }

    @Test
    void getEmployee_success() {
    }

    @Test
    void getEmployee_withDepartmentIdIsNull() {
    }
}