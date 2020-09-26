package DART;

import java.io.File;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

// This Class only handles input.
public class UserInputHandler {

    // We create a variable, "input", of type Scanner
    private static Scanner input;

    // If we want the user to stop and have to enter a key to continue:
    public static void pressAnyKeyCon() {
        input = new Scanner(System.in);
        input.nextLine();
        input.close();
    }

    // Input and return a String:
    public static String inputString() {
        input = new Scanner(System.in);
        String inputResult = input.nextLine();
        input.close();

        return inputResult;
    }

    // Input and return an integer:
    public static int inputInt() {
        input = new Scanner(System.in);
        int inputResult = input.nextInt();
        input.nextLine();
        input.close();

        return inputResult;
    }

    // Input and return a double:
    public static double inputDouble() {
        input = new Scanner(System.in);
        double inputResult = input.nextDouble();
        input.close();

        return inputResult;
    }

    // Input an integer between a min and a max value:
    public static int inputIntMinMax(int min, int max) {
        input = new Scanner(System.in);
        int inputResult = input.nextInt();  // Here we let the user input an integer.
        input.nextLine();

        // Checks if user types a number between the variables "min" and "max".
        while (inputResult < min || inputResult > max) {
            System.out.print("Please enter a valid value(" + min + "-" + max + "): ");
            inputResult = input.nextInt();
            input.nextLine();
        }

        input.close();

        return inputResult;
    }

    //  Input a String and check with the sent array if the input is of a correct value:
    public static String inputValidString(String[] validUserInput) {
        input = new Scanner(System.in);
        String inputResult = input.nextLine();

        // Checks if the input is part of the array.
        while (!Arrays.asList(validUserInput).contains(inputResult.toUpperCase())) {
            System.out.print("Please enter a valid value( " + Arrays.toString(validUserInput) + " ): ");
            inputResult = input.nextLine();
        }

        input.close();

        return inputResult;
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