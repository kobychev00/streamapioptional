package com.example.collectionslists090923.controller;

import com.example.collectionslists090923.model.Employee;
import com.example.collectionslists090923.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.example.collectionslists090923.model.Employee;
import com.example.collectionslists090923.service.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/max-salary")
    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
        return departmentService.getEmployeeWithMaxSalary(departmentId);
    }
    @GetMapping("/min-salary")
    public Employee getEmployeeWithMinSalary(Integer departmentId) {
        return departmentService.getEmployeeWithMinSalary(departmentId);
    }

    @GetMapping(value = "/all", params = {"departmentId"})
    public Collection<Employee> getEmployee(@RequestParam Integer departmentId) {
        return departmentService.getEmployee(departmentId);
    }
    @GetMapping("/all")
    public Map<Integer, List<Employee>> getEmployee(){
        return departmentService.getEmployee();
    }
}

