package DART;
import java.util.Scanner;
public class employee {

    public static String employeeMenu (String mainMenuChoice) {
        Scanner input=new Scanner(System.in);

        String password = "";
        System.out.println("Insert password:");
        password = input.nextLine();

        if (password.equals("password123")) {

            System.out.println("Employee Screen - Type one of the options below:\n" +
                    "\n" +
                    "1. Register a game\n" +
                    "\n" +
                    "2. Remove a game\n" +
                    "\n" +
                    "3. Register a customer\n" +
                    "\n" +
                    "4. Remove a customer\n" +
                    "\n" +
                    "5. Show total rent profit\n" +
                    "\n" +
                    "6. View all games\n" +
                    "\n" +
                    "7. Return to Main Menu");
        } else {
            System.out.println("INVALID PASSWORD" + mainProgram.mainMenu (password)); // How can I make 'Scanner input' in mainMenu, an output in here?

        }

        return "";
    }
}
