package com.example.collectionslists090923;

import com.example.collectionslists090923.model.Employee;
import com.example.collectionslists090923.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;


@RestController
@RequestMapping("employee")
public class CollListController {

    private final EmployeeService employeeService;

    public CollListController(EmployeeService employeeService) {
        this.employeeService = employeeService;
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
        return employeeService.add(firstName, lastName, departmentId, salary);
    }

    @GetMapping(path = "/remove")
    public Employee remove(@RequestParam String firstName,
                           @RequestParam String lastName,
                           @RequestParam Integer departmentId,
                           @RequestParam Integer salary) {

        return employeeService.remove(firstName, lastName, departmentId, salary);
    }
    @GetMapping(path = "/get")
    public Employee get(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.get(firstName, lastName);
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
        return employeeService.getAll();
    }
}

