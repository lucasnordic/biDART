package dart;


import dart.tools.UserInputHandler;

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