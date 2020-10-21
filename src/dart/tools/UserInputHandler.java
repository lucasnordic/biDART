package dart.tools;

import java.util.Arrays;
import java.util.Scanner;

/**
 *  This class only handles Input.
 */

public class UserInputHandler {

    // We create a variable, "input", of type Scanner
    private static final Scanner input = new Scanner(System.in);

    /**
     * Here we have simple methods for handling different input:
     */

    // If we want the user to stop and have to enter a key to continue:
    public static void pressAnyKeyCon() {
        System.out.print("Press enter to continue: ");
        input.nextLine();
        System.out.print("");
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
        input.nextLine();

        return inputResult;
    }

    /**
     *  Here we have more involved methods for checking correct input:
     */

    // Input an integer between a min and a max value:
    public static int inputIntMinMax(int min, int max) {
        int inputResult = input.nextInt();
        input.nextLine();

        // Checks if user types a number between the variables "min" and "max".
        // Loop is repeated until a correct number is entered.
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
        // Loop is repeated as long as the String input is not equal to any valid String.
        while (!Arrays.asList(validValueChoices).contains(inputResult.toUpperCase())) {
            System.out.print("Please enter a valid value( " + Arrays.toString(validValueChoices) + " ): ");
            inputResult = input.nextLine();
        }

        return inputResult;
    }

    /**
     *  When we want to close the Scanner we call this method. It's only needed once when the program shuts down:
     */

    public static void closeScanner() {
        input.close();
    }
}