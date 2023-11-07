package com.example.collectionslists090923.service;

import com.example.collectionslists090923.exception.EmployeeStorageIsFullException;
import com.example.collectionslists090923.model.Employee;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeServiceImplTest {

    private final EmployeeServiceImpl employeeServiceImpl = new EmployeeServiceImpl();

    @Test
    void add_success() {
        //Подготовка входных данных
        String firstName = "Ivan";
        String lastName = "Ivanov";
        int departmentId = 1;
        int salary = 45000;

        //Подготовка ожидаемого результата
        Employee expectedEmployee = new Employee(firstName, lastName, departmentId, salary);

        //Начало теста
        Employee actualEmployee = employeeServiceImpl.add(firstName, lastName, departmentId, salary);
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    void add_withEmployeeStorageIsFullException() {
        //Подготовка входных данных

        String firstName1 = "Vova";
        String lastName1 = "Vovanov";
        int departmentId1 = 2;
        int salary1 = 6000;

        String firstName2 = "Ira";
        String lastName2 = "Vicina";
        int departmentId2 = 3;
        int salary2 = 56000;

        String firstName3 = "Inna";
        String lastName3 = "Komoba";
        int departmentId3 = 1;
        int salary3 = 60000;

        //Подготовка ожидаемого результата

        String expectedMessage = "Массив сотрудников переполнен";

        //Начало теста
        employeeServiceImpl.add(firstName1, lastName1, departmentId1, salary1);
        employeeServiceImpl.add(firstName2, lastName2, departmentId2, salary2);
        Exception exception = assertThrows(
                EmployeeStorageIsFullException.class,
                () -> employeeServiceImpl.add(firstName3, lastName3, departmentId3, salary3)
        );
        assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void remove() {
    }

    @Test
    void get() {
    }

    @Test
    void getAll() {
    }
}