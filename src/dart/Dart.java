package dart;

/**
</www.Dart.com>
 */
public class Dart {

    public static void main(String[] args) {

        // We make an instance of Mainmenu, which is connected to everything Dart does:
        MainMenu dart = new MainMenu();
        dart.mainMenu();

        // We go into the class that has the scanner and close it.
        UserInputOutput.closeScanner();
    }
}