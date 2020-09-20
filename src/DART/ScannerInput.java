package DART;

import java.util.Arrays;
import java.util.Scanner;

// This Class only handles input.
public class ScannerInput {

    private static final Scanner input = new Scanner(System.in);    // initializes the scanner to be used everywhere in this class "ScannerInput".

    // If you want the user to input a number between two values.
    public static int inputIntMinMax(int min, int max) {  // This method handles integer input only. It needs to have a min and max value.
        int inputResult = input.nextInt();  // Here we let the user input an integer.
        input.nextLine();
        // This while loop checks if user types a number between the variables "min" and "max".
        while (inputResult < min || inputResult > max) {
            System.out.print("Please enter a valid value(" + min + "-" + max + "): ");
            inputResult = input.nextInt();
            input.nextLine();
        }
        return inputResult;
    }

    // If you want the user to input a String.
    public static String inputString() {
        return input.nextLine();
    }

    //  This method handles string input. We send "validUserInput to the method so it knows when it is done.
    public static String inputValidString(String[] validUserInput) {
        String inputResult = input.nextLine();
        // We need to check if user types a correct string.
        while (!Arrays.asList(validUserInput).contains(inputResult.toUpperCase())) {
            System.out.print("Please enter a valid value( " + Arrays.toString(validUserInput) + " ): ");
            inputResult = input.nextLine();
        }
        System.out.println(" ");
        return inputResult;
    }

    public static String inputString() {
        return input.nextLine();
    }
  
    // If you want the user to input a single integer.
    public int inputInt() {
        return input.nextInt();
    }

    //  This method handles double input. Not being used atm.
    public static double inputDouble() {
        return input.nextDouble();
    }
}