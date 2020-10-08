package dart;

import dart.menus.MenuManager;

import java.util.Arrays;
import java.util.Scanner;

/*
    This class only handles Input.
 */

public class UserInputHandler {
    private static final Scanner input = new Scanner(System.in);
    private static String managerPassword = "admin1234";
    private static String employeePassword = "password123";



    /*
        Here we only deal with Input:
     */

    // If we want the user to stop and have to enter a key to continue:
    public static void pressAnyKeyCon() {
        System.out.print("Press any key to continue: ");
        input.nextLine();
    }

    // Input and return a String:
    public static String inputString() {
        String inputResult = input.nextLine();

        return inputResult;
    }

    // Input and return an integer:
    public static int inputInt() {
        int inputResult = input.nextInt();
        input.nextLine();

        return inputResult;
    }

    // Input and return a double:
    public static double inputDouble() {
        double inputResult = input.nextDouble();

        return inputResult;
    }

    // Input an integer between a min and a max value:
    public static int inputIntMinMax(int min, int max) {
        int inputResult = input.nextInt();
        input.nextLine();

        // Checks if user types a number between the variables "min" and "max":
        while (inputResult < min || inputResult > max) {
            System.out.print("Please enter a valid value(" + min + "-" + max + "): ");
            inputResult = input.nextInt();
            input.nextLine();
        }

        return inputResult;
    }

    //  Input a String and check with the sent array if the input is of a correct value:
    public static String inputValidString(String[] validValueChoices) {
        String inputResult = input.nextLine();

        // Checks if the input is part of the array of validValues.
        while (!Arrays.asList(validValueChoices).contains(inputResult.toUpperCase())) {
            System.out.print("Please enter a valid value( " + Arrays.toString(validValueChoices) + " ): ");
            inputResult = input.nextLine();
        }

        return inputResult;
    }

    //  We call this when we want to close the scanner:
    public static void closeScanner() {
        input.close();
    }


    /*
        Here we only deal with Output/Printing:
     */


}
