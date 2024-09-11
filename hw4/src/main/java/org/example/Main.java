package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EmployeeDirectory directory = new EmployeeDirectory();

        Employee employee1 = new Employee(1, "11111", "Axe", 1);
        Employee employee2 = new Employee(2, "22222", "Kek", 6);
        Employee employee3 = new Employee(3, "33333", "Dan", 14);

        directory.addEmployee(employee1);
        directory.addEmployee(employee2);
        directory.addEmployee(employee3);

        List<Employee> employeesWithExperience = directory.findEmployeesByExperience(6);
        System.out.println("Сотрудники со стажем 6 лет: " + employeesWithExperience);

        List<String> phoneNumbers = directory.findPhoneNumbersByName("Axe");
        System.out.println("Номера телефонов сотрудника Axe: " + phoneNumbers);

        Employee employee = directory.findEmployeeById(1);
        if (employee != null) {
            System.out.println("Сотрудник с табельным номером 1: " + employee);
        } else {
            System.out.println("Сотрудник не найден.");
        }
    }
}