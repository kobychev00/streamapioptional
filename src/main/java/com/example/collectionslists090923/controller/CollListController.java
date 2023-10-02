package com.example.collectionslists090923.controller;

import com.example.collectionslists090923.model.Employee;
import com.example.collectionslists090923.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpStatusCodeException;

import java.util.Collection;


@RestController
@RequestMapping("employee")
public class CollListController {

    @ExceptionHandler({HttpStatusCodeException.class})
    public String handleException(HttpStatusCodeException e) {
        return "Code: " + e.getStatusCode() + " Error: " + e.getMessage();
    }

    private final EmployeeServiceImpl employeeServiceImpl;

    public CollListController(EmployeeServiceImpl employeeServiceImpl) {
        this.employeeServiceImpl = employeeServiceImpl;
    }

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    /*add, remove, get - запросы к серверу, принимающие значения полей класса Employee
    возвращают результат выполнения методов класса employee.Service*/
    @GetMapping(path = "/add")
    public Employee add(@RequestParam String firstName,
                        @RequestParam String lastName,
                        @RequestParam Integer departmentId,
                        @RequestParam Integer salary) {
        return employeeServiceImpl.add(firstName, lastName, departmentId, salary);
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam Integer departmentId,
                           @RequestParam Integer salary) {

        return employeeServiceImpl.remove(firstName, lastName, departmentId, salary);
    }
    @GetMapping(path = "/get")
    public Employee get(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeServiceImpl.get(firstName, lastName);
    }
    /*метод типа String, который ловит исключения типа Runtimeexception
    * возвращают сообщения из методов Exception*/

    @ExceptionHandler(RuntimeException.class)
    public String exceptionHandler(RuntimeException e) {
        return e.getMessage();
    }

    /*метод типа list, который возвращает все элементы list*/
    @GetMapping
    public Collection<Employee> getAll() {
        return employeeServiceImpl.getAll();
    }
}

