package com.example.collectionslists090923.service;

import com.example.collectionslists090923.model.Employee;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public interface departmentService {

    Employee getEmployeeWithMaxSalary(Integer departmentId);
    Employee getEmployeeWithMinSalary(Integer departmentId);
    Collection <Employee> getEmployee(Integer departmentId);
    Map<Integer, List<Employee>> getEmployee();
}
