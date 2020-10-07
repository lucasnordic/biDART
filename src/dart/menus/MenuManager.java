package dart.menus;

import dart.InputOutput;
import dart.data.users.Employee;

import java.util.ArrayList;

public class MenuManager {
    //  This method handles the manager menu contents:
    public void managerMenu() {
        String title = "Manager Screen - Type one of the options below:";
        String[] menuItems = {
                "Add an employee",
                "View all employees",
                "Remove an employee",
                "View Net Salary",
                "Return to Main Menu"
        };
        String inputPrompt = "Enter choice: ";
        int minMenuChoice = 1;
        int maxMenuChoice = menuItems.length;

        // Here we send this content to be printed:
        InputOutput.printMenuItems(title, menuItems, inputPrompt);

        // Here we let the user input a number between the choices available based on the size of the menuItems array:
        int menuChoice = InputOutput.inputIntMinMax(minMenuChoice, maxMenuChoice);

        // Here we go to different menus based on user input:
        switch (menuChoice) {
            case 1 -> menuAddEmployee();
            case 2 -> {
                menuShowEmployeeList();
                System.out.print("Press any key to continue...");
                InputOutput.pressAnyKeyCon();
            }
            case 3 -> menuRemoveEmployee();
            case 4 -> menuViewNetSalary();
            case 5 -> mainMenu();
        }
        // This is not nececcary?
        managerMenu();
    }

    //This method handles the sub-menu when adding an employee:
    public void menuAddEmployee() {

        System.out.print("Type employee's name: ");
        String employeeName = InputOutput.inputString();

        System.out.print("Type employee's birth year: ");
        int employeeBirthYear = InputOutput.inputInt();

        System.out.print("Type employee's gross salary: ");
        double employeeGrossSalary = InputOutput.inputDouble();

        // Here we create a new employee:
        Employee newEmployee = new Employee(
                employeeName,
                employeeBirthYear,
                employeeGrossSalary
        );

        // Here we add the new employee to the employee arrayList:
        employeeLibrary.addEmployee(newEmployee);

        System.out.println("You added: " + newEmployee);
        System.out.println(" ");

    }

    // this method handles showing the employeelist:
    public void menuShowEmployeeList() {
        ArrayList<Employee> list = employeeLibrary.getEmployeeList();


        // Prints the list of employees:
        for (Employee employee : list) {
            System.out.println(employee);
        }
    }

    // This method handles removing employees:
    public void menuRemoveEmployee() {
        ArrayList<Employee> list = employeeLibrary.getEmployeeList();
        Employee foundEmployee = null;

        System.out.println(" ");
        menuShowEmployeeList();

        // Here we check if the user exists in the array:
        while (foundEmployee == null) {
            System.out.print("Which employee should be removed? Please enter a correct ID or NAME (Press ´M´ to go back to menu): ");
            String input = InputOutput.inputString();
            int count = 0;

            if (input.equalsIgnoreCase("M")) {
                mainMenu();
            }

            // Here we check if the ID is actually a unique ID.
            // On the first run we go through the loop to find the first ID, similar to the users input.
            for (int i = 0; i < list.size() && count < 2; i++) {
                Employee currentEmployee = list.get(i);

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
        employeeLibrary.removeEmployee(foundEmployee);
        System.out.print("Employee removed! Press any key to continue:");
        InputOutput.pressAnyKeyCon();
    }

    public void menuViewNetSalary() {
        System.out.println("The Net salary for all employees are: " + employeeLibrary.getNetSalary() + " SEK.");
        System.out.print("Press any key to continue: ");
        InputOutput.pressAnyKeyCon();
    }

}
