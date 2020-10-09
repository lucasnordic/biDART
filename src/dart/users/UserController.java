package dart.users;

import dart.Dart;
import dart.UserInputHandler;

import java.util.ArrayList;

/**
 * This class handles all Users and the methods required.
 */

public class UserController {

    ArrayList<Customer> customerList = new ArrayList<>();
    ArrayList <Employee> employeeList = new ArrayList();

    /**
     * These methods are related to Customers:
     */

    public void registration() {

        System.out.print("Creating a Customer. Please type the customer’s:\nID:  ");
        int ID = UserInputHandler.inputInt();

        System.out.print("Name:   ");
        String name = UserInputHandler.inputString();

        Customer customer = new Customer();
        customer.setID(ID);
        customer.setName(name);

        customerList.add(customer);
        System.out.println(customerList);

    }

    public void cancellation() {

        System.out.println("Which customer should be removed? ID:");
        int ID = UserInputHandler.inputInt();

        for (int i = 0; i < customerList.size(); i++) {

            int a = (customerList.get(i)).getID();

            if (a == ID) {

                customerList.remove(i);
                System.out.println(customerList);
            } else {
                System.out.println("Customer's ID not found");
            }
        }


    }

    /**
     * These methods are related to Employees:
     */

    public void addEmployee() {

        System.out.print("Type employee's name: ");
        String employeeName = UserInputHandler.inputString();

        System.out.print("Type employee's birth year: ");
        int employeeBirthYear = UserInputHandler.inputInt();

        System.out.print("Type employee's gross salary: ");
        double employeeGrossSalary = UserInputHandler.inputDouble();

        Employee newEmployee = new Employee(employeeName, "password123", employeeBirthYear, employeeGrossSalary);
        employeeList.add(newEmployee);

        System.out.println("You added: " + newEmployee);
        System.out.println(" ");

    }

    public void showEmployee() {

        // Prints the list of employees:
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    public void RemoveEmployee() {

        Dart dart = new Dart();

        Employee foundEmployee = null;

        System.out.println(" ");
        showEmployee();

        // Here we check if the user exists in the array:
        while (foundEmployee == null) {
            System.out.print("Which employee should be removed? Please enter a correct ID or NAME (Press ´M´ to go back to menu): ");
            String input = UserInputHandler.inputString();
            int count = 0;

            if (input.equalsIgnoreCase("M")) {
                dart.mainMenu();
            }

            // Here we check if the ID is actually a unique ID.
            // On the first run we go through the loop to find the first ID, similar to the users input.
            for (int i = 0; i < employeeList.size() && count < 2; i++) {
                Employee currentEmployee = employeeList.get(i);

                // When we find an ID, we increase the count by "1" and continue checking the Array of Employees:
                if (currentEmployee.getId().startsWith(input) || currentEmployee.getName().startsWith(input)) {
                    count++;
                    foundEmployee = currentEmployee;
                }
            }

            // If the count is greater then one that means we have found more than two ID's matching the users input.
            // Then we reset foundEmployee and we stay in the loop:
            if (count > 1) {
                System.out.println("Not a Unique ID, try again. ");
                foundEmployee = null;
            }
        }

        // If we leave the last loop and the count is only "1" by the end, then we remove the "foundEmployee":
        employeeList.remove(foundEmployee);
        System.out.print("Employee removed! Press any key to continue:");
        UserInputHandler.pressAnyKeyCon();
    }

    public double getNetSalary() {

        double netSalary = 0;
        Employee employee = new Employee();

        if (employee.getGrossSalary() * 12 < 100000) {
            return netSalary = employee.getGrossSalary() * 12;
        } else if (employee.getGrossSalary() * 12 >= 100000) {
            return netSalary = (employee.getGrossSalary() * 12) * 0.70;
        } else {
            return netSalary + employee.getGrossSalary();
        }
    }
}


