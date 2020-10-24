package dart.controller;

import dart.model.user.Customer;
import dart.model.user.Employee;
import dart.model.user.User;
import dart.tool.UserInputHandler;

import java.util.ArrayList;


/**
 * This class handles all Users and the methods required.
 */

public class UserController {

    private ArrayList<User> userList = new ArrayList<>();
    private User currentUser;

//    public UserController() {
//        mockData();
//    }


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
     * These methods are related to all users:
     */

    // With this you have to type the whole ID:
    public String removeUser(String idInput){
        for (int i = 0; i < userList.size(); i++){
            if(userList.get(i).getId().equals(idInput)){
                userList.remove(i);
                return "User removed!";
            }
        }

        return "ID " + idInput + " is not found";
    }

    // With this you only need to input a part of the ID:
    public String removeUserByPartialInput(String idInput){
        User user = checkIfInputIsUniqueId(idInput); // We want to check if the user is unique

        if (user != null) { // Remove user depending on result:
            userList.remove(user);

            return "User removed!";
        }

        return "ID " + idInput + " is not found";
    }

    // Checks only part of input and tries to find if the idInput is unique:
    public User checkIfInputIsUniqueId(String idInput) {
        User user = null;
        while (user == null) {

            // Here we check if the ID is actually a unique ID.
            int foundUsers = 0;
            for (int i = 0; i < userList.size() && foundUsers < 2; i++) {
                User currentUser = userList.get(i);

                // When we find an ID, we increase the foundUsers by "1" and continue checking the Array of Employees:
                if (currentUser.getId().startsWith(idInput)) {
                    foundUsers++;
                    user = currentUser;
                }
            }

            // If the foundUsers is greater then one that means we have found more than two ID's matching the users input.
            // Then we reset user.
            if (foundUsers > 1) {
                System.out.println("ID: " + idInput + ", is not found");
                user = null;
            }
        }
        return user;
    }


    /**
     * These methods are related to Customers:
     */

    public void registerCustomer(Customer customer) {
        userList.add(customer);
        System.out.println(customer.toString());

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

    public void addEmployee(User newEmployee) {
        userList.add(newEmployee);
    }

//    public void addEmployee(Employee employee){
//        userList.add(employee);
//    }


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
}





/**
 * This is "test" data:
 */

// public void mockData() {
//  addEmployee(new Employee("Anwar", "koko", 2010, 10.0));
// addEmployee(new Employee("Lucas","koko", 1990, 10.0));
//        addEmployee(new Employee("Maryam","koko", 1930, 10.0));
//        addEmployee(new Employee("Deba","koko", 309, 10.0));
//        addEmployee(new Employee("Olga","koko", 1769, 10.0));
//
//        addCustomer(new Customer("lucas", "123"));
//        addCustomer(new Customer("maryam", "234"));
//        addCustomer(new Customer("deba", "345"));
//        addCustomer(new Customer("anwar", "456"));
//        addCustomer(new Customer("olga", "567"));
//  }


// old methods:


//
//    public void removeCustomer(String id) {
//  for (int i = 0; i < userList.size(); i++) {
//
//            String customerId = (userList.get(i)).getId();
//
//            if (customerId.equals(id)) {
//                userList.remove(i);
//                System.out.println("Customer is removed!");
//            } else {
//                System.out.println("Customer's ID not found!");
//            }
//        }
//        UserInputHandler.pressAnyKeyCon();
//    }

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


//        for (int i = 0; i < userList.size(); i++){
//            if(userList.get(i).getId().equals(id)){
//                userList.remove(i);
//                return "User removed!";
//            }
//        }
//        return "ID " + id + " is not found";

// Old  || currentUser.getName().startsWith(input) && currentUser instanceof Employee