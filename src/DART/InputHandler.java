package DART;

import java.util.Scanner;

public class InputHandler { // This class handles input.

    public static int inputInt(Scanner input, String prompt, int min, int max) {
        System.out.print(prompt);
        int result = input.nextInt();
        input.nextLine();
        while (result < min || result > max) {
            System.out.println("Please enter a valid value(" + min + "-" + max + "):");
            result = input.nextInt();       // We need to check if user types a number.
            input.nextLine();
        }
        return result;
    }

    public static String inputString(Scanner input, String prompt) {

        return "";
    }

    public static double inputDouble(Scanner input, String prompt) {

        return 0.0;
    }
}
