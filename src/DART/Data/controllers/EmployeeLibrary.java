package DART.Data.controllers;

import DART.Data.users.Employee;

import java.util.ArrayList;

public class EmployeeLibrary {
    private ArrayList<Employee> employeeList = new ArrayList<>();

    public Employee createEmployee(String name, int birthYear, double grossSalary) {
        return new Employee(name, birthYear, grossSalary);
    }

    public void addEmployee(Employee newEmployee) {
        employeeList.add(newEmployee);
        System.out.println("Employee was succesfully added :)");
        System.out.println(" ");
    }

    public void removeEmployee(Employee employee) {
        employeeList.remove(employee);
    }

    public ArrayList<Employee> getEmployeeList(){
        return employeeList;
    }
}