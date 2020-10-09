package dart;

/**
</www.Dart.com>
 */
public class Main {

    public static void main(String[] args) {

//        TESTDATA testdata = new TESTDATA();
//        testdata.mockData();

        Dart dart = new Dart();
        dart.mainMenu();

        UserInputHandler.closeScanner();  // We go into the class that has the scanner and close it.
    }
}