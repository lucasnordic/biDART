package dart.data;

import dart.UserInputHandler;
import dart.data.users.Customer;
import dart.data.users.Employee;
import java.util.ArrayList;

public class EmployeesController {

    ArrayList <Customer> customers = new ArrayList<Customer>();
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
void mainRun() {
    //E,M,C,X
    //1,2,
    //
    // }

    String name = UserInputHandler.inputString();
    String membershipType =UserInputHandler.inputString();
    Customer c = new Customer(name, membershipType);
    Employee e = new Employee();
    e.addCustomer(c,customers);


}

}