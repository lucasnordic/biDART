// https://www.youtube.com/watch?v=MoXxF3aWW8k&ab_channel=IntelliJIDEAbyJetBrains
// Learn how to GitHub.
package DART;

import DART.MenuItems.MenuBase;
import DART.MenuItems.MenuMain;
import java.util.Scanner;

public class MainProgram {
    public static void main(String[] args) {
        // Creates a scanner that is used throughout the program
        // So wherever the name "input" comes up. That means I am sending the scanner along the program.
        // Maybe there is a better way of doing this. Perhaps opening and closing the scanner in every class? help..
        Scanner input = new Scanner(System.in);
        // Program goes directly into the mainMenu Class. The method needs the scanner(input).
        MenuMain.mainMenu(input);
    }
}