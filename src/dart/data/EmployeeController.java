package dart.data;

import dart.data.items.Employee;
import java.util.ArrayList;

public class EmployeeController {

    private ArrayList<Employee> employeeList = new ArrayList<>();
    private double netSalary;

    public ArrayList<Employee> getEmployeeList(){
        return employeeList;
    }

    public void addEmployee(Employee newEmployee) {
        employeeList.add(newEmployee);
    }

    public void removeEmployee(Employee employee) {
        employeeList.remove(employee);
    }

    public double getNetSalary() {
        calculateNetSalary();
        return netSalary;
    }

    private void calculateNetSalary() {

        for (Employee employee : employeeList) {
            if (employee.getGrossSalary() * 12 < 100000) {
                netSalary =+ employee.getGrossSalary() * 12;
            }
            if (employee.getGrossSalary() * 12 >= 100000) {
                netSalary =+ (employee.getGrossSalary() * 12) * 0.70;
            }
        }
    }
}