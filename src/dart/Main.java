package dart;
/**
</www.Dart.com>
 */
public class Main {

    public static void main(String[] args) {
        Dart.printIntroAscii();

        // "new Dart();" is an object, all methods of "Dart" class go inside this new instantiation.
        Dart dart = new Dart();
        dart.mainMenu();

        // We go into the class that has the scanner and close it.
        UserInputHandler.closeScanner();
    }
}