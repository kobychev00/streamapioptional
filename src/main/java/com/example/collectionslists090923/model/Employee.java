package com.example.collectionslists090923.model;

import java.util.Objects;

public class Employee {
    private final String firstName;

    private final String lastName;
    private final Integer departmentId;

    private final Integer salary;


    public Employee(String firstName, String lastName, Integer departmentId, Integer salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.departmentId = departmentId;
        this.salary = salary;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public Integer getSalary() {
        return salary;
    }

    /*переопределение метода equals*/

    @Override
    public boolean equals(Object o) {
        /*условие 1 - равенство объектов, возращаем true*/
        if (this == o) {
            return true;
        }
        /*условие 2 - равенство классов и не null, возвращаем false */
        if (this == null || getClass() != o.getClass())
            return false;


        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName)
                && Objects.equals(lastName, employee.lastName)
                && Objects.equals(departmentId, employee.departmentId)
                && Objects.equals(salary, employee.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, departmentId, salary);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", departmentId=" + departmentId +
                ", salary=" + salary +
                '}';
    }
}


