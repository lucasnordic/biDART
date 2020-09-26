package DART.Data;

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

    // TODO: Implement, remove employeeFromList

    public Employee getEmployeeFromList(String id) {
        // TODO: Implemet this bonkers feuture

        // employeeList.remove()
        return null;
    }

    public ArrayList<Employee> getEmployeeList(){
        return employeeList;
    }
}