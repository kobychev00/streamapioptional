package com.example.collectionslists090923.service;

import com.example.collectionslists090923.exception.EmployeeIsNotFoundException;
import com.example.collectionslists090923.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class departmentServiceImpl implements departmentService {

    public EmployeeService employeeService;

    public departmentServiceImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public Employee getEmployeeWithMaxSalary(Integer departmentId) {
        return employeeService.getAll()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeIsNotFoundException("Сотрудник не найден"));
    }

    @Override
    public Employee getEmployeeWithMinSalary(Integer departmentId) {
        return employeeService.getAll()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .min( Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(() -> new EmployeeIsNotFoundException("Сотрудник не найден"));
    }

    @Override
    public Collection<Employee> getEmployee (Integer departmentId) {
        return employeeService.getAll()
                .stream()
                .filter(e -> e.getDepartmentId() == departmentId)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getEmployee() {
        return employeeService.getAll()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartmentId));
    }
}
