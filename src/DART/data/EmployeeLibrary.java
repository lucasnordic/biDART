package DART.data;

import java.util.ArrayList;

public class EmployeeLibrary {
    private ArrayList<Employee> employeeList = new ArrayList<>();

    public Employee createEmployee(String name, int birthYear, double grossSalary) {
        return new Employee(name, birthYear, grossSalary);
    }

    public void addEmployee(Employee newEmployee) {
        employeeList.add(newEmployee);
        System.out.println("Employee was successfully added :)");
        System.out.println(" ");
    }

    // TODO: Implement, remove employeeFromList
    public boolean removeEmployee(String id) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id)) {
                employeeList.remove(i);
                return true;
            }
        }
        return false;
    }

    public Employee getEmployeeFromList(String id) {
        // TODO: Implement this bonkers feuture

        // employeeList.remove()
        // ---> to find an index of an employee array list by ID
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(id)) {
                return employeeList.get(i);
            }
        }
        return null;
    }

    public ArrayList<Employee> getEmployeeList() {
        return employeeList;
    }
}