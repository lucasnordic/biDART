package DART;

import java.util.Scanner;

// This Class handles input.
public class InputHandler {

    //  This method handles integer input only
    public static int inputInt(Scanner input, int min, int max) {

        //  Here we let the user input an integer. Later we can check this integer and see if it corresponds to a number
        //  in our menuItems array :)
        int inputResult = input.nextInt();
        input.nextLine();

        // We need to check if user types a number.
        // This while loop does that by using the variables,
        // "min" and "max" that we got from the class "MenuHandler".
        while (inputResult < min || inputResult > max) {
            System.out.println("Please enter a valid value(" + min + "-" + max + "):");
            inputResult = input.nextInt();
            input.nextLine();
        }

        // Finally it returns the result, which will be a number.
        // This number is corresponding to the position of the array that stores the menu choices
        return inputResult;
    }
}













// Unused code below:
/*
    public static String inputString(Scanner input, String prompt) {
        System.out.println("");
        return "";
    }

    public static double inputDouble(Scanner input, String prompt) {

        return 0.0;
    }
*/