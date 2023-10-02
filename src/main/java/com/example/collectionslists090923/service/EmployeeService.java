package com.example.collectionslists090923.service;

import com.example.collectionslists090923.model.Employee;

import java.util.Collection;

public interface EmployeeService {

    /*добавить элемент в мапу employees*/
    Employee add(String firstName,
                 String lastName,
                 Integer departmentId,
                 Integer salary);

    /*Убрать элемент из списка employees*/
    Employee remove(String firstName, String lastName, Integer departmentId, Integer salary);

    Employee get(String firstName, String lastName);

    Collection<Employee> getAll();
}
