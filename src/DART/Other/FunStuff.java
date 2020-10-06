package DART.Other;

import DART.Data.EmployeeController;
import DART.Data.items.parent.Employee;

public class FunStuff {
    EmployeeController employeeController;

    // Removable methods:
    public static void printIntroAscii() {
//        System.out.println("- - - - - - - - - - - - - - - - -");
        System.out.println(" _   _ ____  _____ _____ _____ \n" +
                "| |_|_|    \\|  _  | __  |_   _|\n" +
                "| . | |  |  |     |    -| | |  \n" +
                "|___|_|____/|__|__|__|__| |_|  ");
        // System.out.println("- - - - - - - - - - - - - - - - - -");
    }
    public static void printOutroAscii () {
        System.out.println("- - - - - - - - - - - - -");
        System.out.println("                       _   \n" +
                " _____            _   |_|_ \n" +
                "| __  |_ _ ___   |_|    | |\n" +
                "| __ -| | | -_|   _     | |\n" +
                "|_____|_  |___|  |_|   _|_|\n" +
                "      |___|           |_|  ");
//        System.out.println("- - - - - - - - - - - - -");
    }
    public void mockData() {
        employeeController.addEmployee(new Employee("Anwar", 1998, 1000));
        employeeController.addEmployee(new Employee("Lucas", 1992, 1000));
        employeeController.addEmployee(new Employee("Maryam", 1992, 1000));
        employeeController.addEmployee(new Employee("Deba", 1988, 10000));
        employeeController.addEmployee(new Employee("Olga", 1990, 10000));
    }
}
