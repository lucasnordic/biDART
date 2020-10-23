package dart.controllers;

import dart.model.users.User;
import dart.tools.InvalidDataInput;
import dart.tools.UserInputHandler;
import dart.model.users.Customer;
import dart.model.users.Employee;

import java.util.ArrayList;


/**
 * This class handles all Users and the methods required.
 */

public class UserController {

    private ArrayList<User> userList = new ArrayList<>();
    private User currentUser;

    public UserController() {
        mockData();
    }


    /**
     * This controls the logged in user:
     */

    public String getCurrentUserId() {
        return currentUser.getId();
    }

    public String getCurrentUserName() {
        return currentUser.getName();
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getCurrentUser() {
        return this.currentUser;
    }


    /**
     * These methods are related to Customers:
     */

    public void registration() {

        System.out.print("Please enter the Customers username: ");
        String name = UserInputHandler.inputString();
        System.out.print("Please enter a password for the Customer: ");
        String password = UserInputHandler.inputString();
        try {
            User customer = new Customer(name, password);
            userList.add(customer);
            System.out.println(customer.toString());
        }
        catch(InvalidDataInput e){
            System.out.println(e.getMessage());
        }
//        customer.setName(name);
//        customer.setPassword(password);
//
//        User customer = new Customer(name, password);
//        userList.add(customer);
//        System.out.println(customer.toString());

    }

    public void cancellation() {
        showCustomerListNameId();
        System.out.print("Which customer should be removed? ID: ");
        String ID = UserInputHandler.inputString();

        for (int i = 0; i < userList.size(); i++) {

            String customerId = (userList.get(i)).getId();

            if (customerId.equals(ID)) {
                userList.remove(i);
                System.out.println("Customer is removed!");
            } else {
                System.out.println("Customer's ID not found!");
            }
        }
        UserInputHandler.pressAnyKeyCon();
    }

    public void addCustomer(Customer customer){
        userList.add(customer);
    }

    public void showCustomerList() {
        for (User user : userList) {
            if (user instanceof Customer){
                System.out.println(user);
            }
        }
    }

    public void showCustomerListNameId() {
        for (User user : userList) {
            if (user instanceof Customer){
                System.out.println(user.getName() + " : " + user.getId());
            }
        }
    }


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
        UserInputHandler.pressAnyKeyCon();
    }

    public void addEmployee() {

        System.out.print("Type employee's name: ");
        String employeeName = UserInputHandler.inputString();

        System.out.print("Type employee's birth year: ");
        int employeeBirthYear = UserInputHandler.inputInt();

        System.out.print("Type employee's gross salary: ");
        double employeeGrossSalary = UserInputHandler.inputDouble();
        try {
        User newEmployee = new Employee(
                employeeName,
                "password123",
                employeeBirthYear,
                employeeGrossSalary);
                userList.add(newEmployee);

            System.out.println("You added: " + newEmployee.toString());
            UserInputHandler.pressAnyKeyCon();

        }catch (InvalidDataInput e){
            System.out.println(e.getMessage());
        }
    }

    public void addEmployee(Employee employee){
        userList.add(employee);
    }

    public void removeEmployee() {

        User user = null;

        System.out.println(" ");
        showEmployeeList();

        // Here we check if the user exists in the array:
        while (user == null) {
            System.out.print("Which user should be removed? Please enter a correct ID or NAME: ");
            String input = UserInputHandler.inputString();
            int foundUsers = 0;

            // Here we check if the ID is actually a unique ID.
            // On the first run we go through the loop to find the first ID, similar to the users input.
            for (int i = 0; i < userList.size() && foundUsers < 2; i++) {
                User currentUser = userList.get(i);

                // When we find an ID, we increase the foundUsers by "1" and continue checking the Array of Employees:
                if (currentUser.getId().startsWith(input) && currentUser instanceof Employee || currentUser.getName().startsWith(input)) {
                    foundUsers++;
                    user = currentUser;
                }
            }

            // If the foundUsers is greater then one that means we have found more than two ID's matching the users input.
            // Then we reset user and we stay in the loop:
            if (foundUsers > 1) {
                System.out.println("Not a Unique ID, try again. ");
                user = null;
            }
        }

        // If we leave the last loop and the count is only "1" by the end, then we remove the "user":
        userList.remove(user);
        System.out.print("Employee removed! ");
        UserInputHandler.pressAnyKeyCon();
    }

    public double calculateNetSalary() {
        double netSalary = 0;
        for (User user : userList) {
            if (user instanceof Employee) {
                netSalary += ((Employee) user).getNetSalary();
            }
        }

        return netSalary;
    }


    /**
     * Here we check if a user exists:
     */

    public User getUserWithNameAndPassword(String name, String password) {
        User userFound = null;
        int index = 0;

        while(userFound == null && index < userList.size()) {
            User user = userList.get(index);

            if (user.getName().equals(name) && user.getPassword().equals(password)) {
                userFound = user;
            } else {
                index++;
            }
        }
        return userFound;
    }

    public User getUserWithId(String userId) {
        User userFound = null;
        int index = 0;

        while(userFound == null && index < userList.size()) {
            User user = userList.get(index);

            if (user.getId().equals(userId)) {
                userFound = user;
            } else {
                index++;
            }
        }
        return userFound;
    }


    /**
     * This is "test" data:
     */

    public void mockData() {
        addEmployee(new Employee("Anwar", "koko", 2010, 10.0));
        addEmployee(new Employee("Lucas","koko", 1990, 10.0));
//        addEmployee(new Employee("Maryam","koko", 1930, 10.0));
//        addEmployee(new Employee("Deba","koko", 309, 10.0));
//        addEmployee(new Employee("Olga","koko", 1769, 10.0));
//
        addCustomer(new Customer("lucas", "123"));
        addCustomer(new Customer("maryam", "234"));
//        addCustomer(new Customer("deba", "345"));
//        addCustomer(new Customer("anwar", "456"));
//        addCustomer(new Customer("olga", "567"));
    }
}

















// old methods:

//    private ArrayList<Customer> customerList = new ArrayList<>();
//    private ArrayList<Employee> employeeList = new ArrayList<>();

/*
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
 */

//        if (user instanceof Customer) {
////            CustomerSilver customerSilver =
//            System.out.println(
//                    "User is upgraded to Silver." +
//                    "Press any key to go back: "
//            );
//            UserInputHandler.pressAnyKeyCon();
//        } else if (user instanceof CustomerSilver) {
//            System.out.println(
//                    "User is upgraded to Gold." +
//                    "Press any key to go back: "
//            );
//            UserInputHandler.pressAnyKeyCon();
//        } else if (user instanceof CustomerGold) {
//            System.out.println(
//                    "User is upgraded to Platinum" +
//                    "Press any key to go back: "
//            );
//            UserInputHandler.pressAnyKeyCon();
//        } else if (user instanceof CustomerPlatinum) {
//            System.out.println(
//                    "User is already Platinum!" +
//                    "Press any key to go back: "
//            );
//            UserInputHandler.pressAnyKeyCon();
//        }

//    public void requestMembership() {
//        System.out.println("");
//    }

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