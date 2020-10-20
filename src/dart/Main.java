package dart;


import dart.tools.InvalidDataInput;
import dart.tools.UserInputHandler;
import dart.users.*;


/**
 * </www.biDART.com>
 *
 * <Changes from milestone 1 to milestone 2:
 *  "To implement "Epic feature X", I modified the "class X" by <adding | removing> : <attribute | method> : A, B, C..."
 *
 * <Changes from milestone 1 and 2 to milestone 3:
 *  "To implement "Epic feature X", I modified the "class X" by <adding | removing> : <attribute | method> : A, B, C..."
 *
 */

public class Main {
    public static void main(String[] args) {
        Dart dart = new Dart();

        Dart.printIntroAscii();
        dart.mainMenu();

        UserInputHandler.closeScanner();
    }
}