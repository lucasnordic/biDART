package DART.Data;

import DART.UserInputHandler;

import java.util.ArrayList;

public class EmployeeLibrary {
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private int nextPosition;

    public Employee createEmployee(String name, int employeeID, int birthYear, double grossSalary) {
        return new Employee(name, employeeID, birthYear, grossSalary);
    }

    // TODO: Check for existing ID.
    public void addEmployee(Employee newEmployee) {
        employeeList.add(newEmployee);
    }
    // TODO: Implement, remove employeeFromList
   /* public void removeEmployee(){
        UserInputHandler.inputInt();
        System.out.println("Enter employee's ID that" +
                " you want to remove:");
        int x = UserInputHandler.inputInt();
        remove.employeeList(1);*/


    public Employee getEmployeeFromList(String id) {
        // TODO: Implemet this bonkers feauture
        return null;
    }

    public ArrayList<Employee> getEmployeeList()
    {
        return employeeList;
    }
}