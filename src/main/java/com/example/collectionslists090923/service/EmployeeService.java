package com.example.collectionslists090923.service;

import com.example.collectionslists090923.exception.EmployeeIsAlreadyAdded;
import com.example.collectionslists090923.exception.EmployeeIsNotFoundException;
import com.example.collectionslists090923.exception.EmployeeStorageIsFullException;
import com.example.collectionslists090923.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

/*Объект Сервис Списка Сотрудников*/

@Service
public class EmployeeService {

    /*размер списков объектов типа Employee*/
    private final Map<String, Employee> employees = new LinkedHashMap<>();

    /*размер списка Employees*/
    private static final int MAX_SIZE = 5;

    /*добавить элемент в мапу employees*/
    public Employee add(String firstName,
                        String lastName,
                        Integer departmentId,
                        Integer salary ) {

        /*условие 1. Размер списка*/

        if (employees.size() > MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Массив сотрудников переполнен");
        }

        String key = getKey(firstName, lastName);

        Employee addedEmployee = new Employee(firstName, lastName, departmentId, salary);

        if (employees.containsKey(key)) {
            throw new EmployeeIsAlreadyAdded("Сотрудник уже добавлен");
        }

        employees.put(key, addedEmployee);

        return addedEmployee;
    }

    /*Убрать элемент из списка employees*/
    public Employee remove(String firstName, String lastName, Integer departmentId, Integer salary) {
        String key = getKey(firstName, lastName);

        /*создание локального объекта removedEmployee типа Employee для метода remove*/

        Employee removedEmployee = new Employee(firstName, lastName, departmentId, salary);

        /*условие 1.Сотрудник не найден*/

        if (!employees.containsKey(key)) {
                throw new EmployeeIsNotFoundException("Сотрудник %s не найден");
            }
        /* Удаление из списока employee локального объекта метода remove (list)*/

        employees.remove(key);

        /*Возвращаем локальный объект метода remove*/

        return removedEmployee;
    }
    public Employee get(String firstName, String lastName) {
        String key = getKey(firstName, lastName);
        /*условие 1.Сотрудник не найден*/
        if (!employees.containsKey(key)) {
            throw new EmployeeIsNotFoundException("Сотрудник не найден");
        }
        return employees.get(key);
    }

    /*метод типа list, который возвращает все элементы list*/
    public Collection<Employee> findAll() {
        return Collections.unmodifiableCollection(employees.values());
    }



    private String getKey(String firstName, String lastName) {
        return firstName + lastName;
    }
}