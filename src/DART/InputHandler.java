package DART;

import java.util.Scanner;

public class InputHandler { // This class handles input.

    public static int inputInt(Scanner input, String prompt, int min, int max) {
        System.out.print(prompt);
        int inputResult = input.nextInt();
        input.nextLine();
        while (inputResult < min || inputResult > max) {
            System.out.println("Please enter a valid value(" + min + "-" + max + "):");
            inputResult = input.nextInt();       // We need to check if user types a number.
            input.nextLine();
        }
        return inputResult;
    }

    public static String inputString(Scanner input, String prompt) {
        System.out.println("");
        return "";
    }

    public static double inputDouble(Scanner input, String prompt) {

        return 0.0;
    }
}
