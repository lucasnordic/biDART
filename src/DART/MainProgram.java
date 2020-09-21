// https://www.youtube.com/watch?v=MoXxF3aWW8k&ab_channel=IntelliJIDEAbyJetBrains
// Learn how to GitHub.
package DART;

import DART.Data.Menu;

public class MainProgram {
    /**
     * Program goes directly into the main class then creates an instance/object of the Menu class, "Menu menu = new Menu();".
     * We then go into the mainMenu, "menu.mainMenu();".
     * When the user does not want to keep running the program we shutdown.
     * "Enter "X" to exit system" -> "System.exit(0);"
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.mainMenu();
        System.exit(0);
    }
}