package DART;
/**
</www.Dart.com>
 */
public class Main {

    public static void main(String[] args) {
        // "new Dart();" is an object, all functions of "Dart" class go inside this new instantiation.
        Dart.printIntroAscii();
        Dart dart = new Dart();
        dart.mainMenu();
    }
}