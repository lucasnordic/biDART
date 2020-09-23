package DART.Data;

import java.util.ArrayList;

public class EmployeeLibrary {
    private ArrayList<Employee> employeeList = new ArrayList<>();


    // TODO: Implement, add employee String name, int birthYear, double grossSalary
    public Employee createEmployee(String name, int birthYear, double grossSalary) {

        return new Employee(name, birthYear, grossSalary);
    }

    // TODO: Check for existing ID.
    public void addEmployee(Employee newEmployee) {
        employeeList.add(newEmployee);
        System.out.println("Employee was succesfully added :)");
        System.out.println(" ");
    }

    // TODO: Implement, remove employeeFromList


    // TODO: getEmployeeFromList
    public Employee getEmployeeFromList(String id) {
        // TODO: Implemet this bonkers feuture
        return null;
    }

    // TODO: getAllEmployees
    public ArrayList<Employee> getEmployeeList(){
        return employeeList;
    }


    // TODO: Implement, add Customer
}