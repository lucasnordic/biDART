package dart;

import java.util.Arrays;
import java.util.Scanner;

// This Class only handles input.
public class UserInputHandler {

    // We create a variable, "input", of type Scanner
    private static final Scanner input = new Scanner(System.in);

    // If we want the user to stop and have to enter a key to continue:
    public static void pressAnyKeyCon() {
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
        input.nextLine();


        return inputResult;
    }

    // Input an integer between a min and a max value:
    public static int inputIntMinMax(int min, int max) {
        int inputResult = input.nextInt();
        input.nextLine();

        // Checks if user types a number between the variables "min" and "max".
        while (inputResult < min || inputResult > max) {
            System.out.print("Please enter a valid value(" + min + "-" + max + "): ");
            inputResult = input.nextInt();
            input.nextLine();
        }

        //input.close();

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

    //
    public static void closeScanner() {
        input.close();
    }

//    public static void debugData() {
//        String text = new Scanner(String.class.getResourceAsStream("test.txt"), "UTF-8").next();
//    }

}


/*
// Check if input is correct:
//        while (!input.hasNextInt()) {
//            System.out.print("That's not a number! Try again: ");
//            input.next(); // this is important!?
//        }
// once the user has input a correct value we store it in this variable:
 */