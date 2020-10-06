package DART;

import DART.Other.FunStuff;

/**
</www.Dart.com>
 */
public class Dart {

    public static void main(String[] args) {

        FunStuff.printIntroAscii();

        // "new Dart();" is an object, all methods of "Dart" class go inside this new instantiation.
        MainMenu dart = new MainMenu();
        dart.mainMenu();

        // We go into the class that has the scanner and close it.
        UserInputHandler.closeScanner();
    }
}