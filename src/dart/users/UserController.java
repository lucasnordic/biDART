package dart.users;

import dart.UserInputHandler;

import java.util.ArrayList;

/**
 * This class handles all Users and the methods required.
 */

public class UserController {

    private ArrayList<Customer> customerList = new ArrayList<>();
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private ArrayList<User> userList = new ArrayList<>();

    public UserController() {
        mockData();
    }

    /**
     * These methods are related to Customers:
     */

    public void registration() {

        System.out.print("Please enter a username: ");
        String name = UserInputHandler.inputString();

        System.out.print("Please enter the password you want to use: ");
        String password = UserInputHandler.inputString();

        User customer = new Customer();
        customer.setName(name);
        customer.setPassword(password);

        userList.add(customer);
        System.out.println(userList.toString());
    }

    public void addCustomer(Customer customer){
        userList.add(customer);
    }

//    public void cancellation() {
//
//        System.out.println("Which customer should be removed? ID:");
//        int ID = UserInputHandler.inputInt();
//
//        for (int i = 0; i < customerList.size(); i++) {
//
//            int a = (customerList.get(i)).getId();
//
//            if (a == ID) {
//
//                customerList.remove(i);
//                System.out.println(customerList);
//            } else {
//                System.out.println("Customer's ID not found");
//            }
//        }
//    }

//    public void customerMembership() {
//        Customer newCustomer = null;
//        do {
//            System.out.print("Do you want to upgrade your membership type(type yes or no): ");
//            String[] validChoices = {"yes", "no"};
//            String yesNo = UserInputHandler.inputValidString(validChoices);
//            switch (yesNo) {
//                case "yes" -> registerCustomer();
//                case "no" -> registerCustomer();
//            }
//
//        }while(newCustomer == null);
//    }

    /**
     * These methods are related to Employees:
     */

    // Prints the list of employees:
    public void showEmployeeList() {
        for (User user : userList) {
            if (user instanceof Employee){
                System.out.println(user);
            }
        }
    }

    public void addEmployee() {

        System.out.print("Type employee's name: ");
        String employeeName = UserInputHandler.inputString();

        System.out.print("Type employee's birth year: ");
        int employeeBirthYear = UserInputHandler.inputInt();

        System.out.print("Type employee's gross salary: ");
        double employeeGrossSalary = UserInputHandler.inputDouble();

        User newEmployee = new Employee(
                employeeName,
                "password123",
                employeeBirthYear,
                employeeGrossSalary
        );
        userList.add(newEmployee);

        System.out.println("You added: " + newEmployee);
    }

    public void addEmployee(Employee employee){
        userList.add(employee);
    }

    public void RemoveEmployee() {

        Employee foundEmployee = null;

        System.out.println(" ");
        showEmployeeList();

        // Here we check if the user exists in the array:
        while (foundEmployee == null) {
            System.out.print("Which employee should be removed? Please enter a correct ID or NAME: ");
            String input = UserInputHandler.inputString();
            int count = 0;

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

    public double calculateNetSalary() {

        double netSalary = 0;
        Employee employee = new Employee();

        if (employee.getGrossSalary() * 12 < 100000) {
            netSalary = employee.getGrossSalary() * 12;
        } else if (employee.getGrossSalary() * 12 >= 100000) {
            netSalary = (employee.getGrossSalary() * 12) * 0.70;
        } else {
            netSalary =+ employee.getGrossSalary();
        }

        return netSalary;
    }

    /**
     * Here we check if a user exists:
     */

    public boolean checkIfUserExists(String name, String password) {
        boolean userFound = false;

        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);

            if (user instanceof Customer) {
                if (user.getName().equals(name)) {
                    if (user.getPassword().equals(password)) {
                        userFound = true;
                    }
                }
            } else if (user instanceof Employee) {
                if (user.getName().equals(name)) {
                    if(user.getPassword().equals(password)) {
                        userFound = true;
                    }
                }
            } else {
                userFound = false;
            }
        }
        return userFound;
    }

    /**
     * This is just "test" data:
     */

    public void mockData() {
//        addEmployee(new Employee("Anwar", "koko", 2010, 10.0));
//        addEmployee(new Employee("Lucas","koko", 1990, 100.0));
//        addEmployee(new Employee("Maryam","koko", 1930, 1000.0));
//        addEmployee(new Employee("Deba","koko", 309, 10000.0));
//        addEmployee(new Employee("Olga","koko", 1769, 100000.0));

        addCustomer(new Customer("lucas", "123"));
        addCustomer(new Customer("maryam", "234"));
        addCustomer(new Customer("deba", "345"));
        addCustomer(new Customer("anwar", "456"));
        addCustomer(new Customer("olga", "567"));
    }
}


