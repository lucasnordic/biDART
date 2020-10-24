package dart.view;

import dart.controller.ItemController;
import dart.controller.MessageController;
import dart.controller.StorageController;
import dart.controller.UserController;
import dart.model.user.Employee;
import dart.model.user.User;
import dart.tool.InvalidDataInput;
import dart.tool.UserInputHandler;

public class ManagerView {
    private ItemController itemController;
    private MessageController messageController;
    private UserController userController;
    private StorageController storageController;


    public ManagerView( ItemController itemController, MessageController messageController, UserController userController,StorageController storageController){
        this.itemController=itemController;
        this.userController=userController;
        this.messageController=messageController;
        this.storageController=storageController;
        menuManager();
    }

    public void menuManager() {
        // Here we create the content of the menu:
        String title = "Manager Screen - Type one of the options below:";
        String[] menuItems = {
                "Add an employee",
                "Remove an employee",
                "View all employees",
                "Calculate Net Salary",
                "View transaction",
                "Most profitable items",
                "Most popular items",
                "Best customers",
                "Import or export a file",
                "Return to Main Menu"
        };
        String inputPrompt = "Enter choice: ";
        printMenuItems(title, menuItems, inputPrompt, "yes"); // Here we send this content to be printed:

        // Here we let the user input a number between the choices available based on the size of the menuItems array:
        int menuChoice = UserInputHandler.inputIntMinMax(1, menuItems.length);
        switch (menuChoice) { // Here we go to different menus based on user input:
            case 1 -> addEmployee();
            case 2 -> removeEmployee();
            case 3 -> userController.showEmployeeList();
            case 4 -> menuShowNetSalary();
            case 5 -> itemController.showTransaction();
            case 6 -> itemController.profitableItems();
            case 7 -> itemController.rentFrequency();
            case 8 -> itemController.myFavoriteCustomer();
            case 9 -> menuImportOrExportFile();
            case 10 -> {
                return;
            }
        }
        menuManager();
    }

    public void addEmployee(){
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
            userController.addEmployee(newEmployee);
        }catch (InvalidDataInput e){
            System.out.println(e.getMessage());
        }

    }

    public void removeEmployee(){
        userController.showEmployeeList();
        System.out.print("Please enter the ID of the employee you want to remove: ");
        String id = UserInputHandler.inputString();
        String result = userController.removeUser(id);
        System.out.println(result);

    }



    // This menu shows net salary:
    public void menuShowNetSalary() {
        System.out.println("The total net salary of all employees are " + userController.calculateNetSalary());
        UserInputHandler.pressAnyKeyCon();
    }

    public void menuImportOrExportFile() {

        String title = "Import/Export menu";
        String[] menuItems = {
                "Import a file",
                "Export a file( you do not need to press anything, it is generated automatically :) ) ",
                "Go back"
        };
        String inputPrompt = "Enter choice: ";
        printMenuItems(title, menuItems, inputPrompt, "yes"); // Here we send this content to be printed:

        // Here we let the user input a number between the choices available based on the size of the menuItems array:
        int menuChoice = UserInputHandler.inputIntMinMax(1, menuItems.length);
        System.out.println("\nImported objects from file:");
        switch (menuChoice) { // Here we go to different menus based on user input:
            case 1 -> storageController.importCustomerCSVBuffer(this.userController, this.itemController);
//            case 2 -> storageController.importCustomerCSVBuffer();
            case 3 -> menuManager();
        }
        UserInputHandler.pressAnyKeyCon();
        menuManager();
    }

    private void printMenuItems(String title, String[] subMenus, String inputPrompt, String line) {
        if (line.equalsIgnoreCase("yes")) {
            System.out.println("- - - - - - - - - - - - - - - - - - - - - -");
        }
        System.out.println(title);

        // This loop prints out all the menu options that are stored in the "menuItems" array.
        for (int i = 0; i < subMenus.length; i++) {
            System.out.println((i + 1) + ". " + subMenus[i]);
        }
        System.out.println("");
        System.out.print(inputPrompt);
    }

}
