package dart;


import dart.tool.UserInputHandler;
import dart.view.DartView;


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
        DartView dart = new DartView();

        DartView.printIntroAscii();
        //dart.mainMenu();

        UserInputHandler.closeScanner();
    }
}