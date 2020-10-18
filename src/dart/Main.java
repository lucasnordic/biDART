package dart;

import dart.tools.InvalidDataInput;
import dart.tools.UserInputHandler;
import dart.users.*;

/**
</www.Dart.com>
 */
public class Main {
    public static void main(String[] args) {
        Dart dart = new Dart();

        Dart.printIntroAscii();
        dart.mainMenu();

        UserInputHandler.closeScanner();
    }
}