package com.example.collectionslists090923.controller;

import com.example.collectionslists090923.model.Employee;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    public Employee getEmployeeWithMaxSalary(Integer departmentId) {

    }
}
