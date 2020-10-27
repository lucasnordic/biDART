package dart;


import dart.tool.UserInputHandler;
import dart.view.DartView;


/**
 * </www.biDART.com>
 *
 * <Changes from milestone 1 to milestone 2:
 *  "To implement "Epic feature 8", We modified the "class Dart/DartView" by <adding> : <method> : loginCheckCustomer"
 *  "To implement "Epic feature 9", We modified the "class Dart/DartView" by <adding> : <method> : messageCenterMenu, receiveMessage, sendMessage..."
 *  "To implement "Epic feature 9", We modified the "class UserController" by <adding> : <method> : getCurrentUserId, SetCurrentUser, getCurrentUser, getUserWithNameAndPassword..."
 *  "To implement "Epic feature X", We modified the "class X" by <adding | removing> : <attribute | method> : A, B, C..."
 *  "To implement "Epic feature X", We modified the "class X" by <adding | removing> : <attribute | method> : A, B, C..."
 *  "To implement "Epic feature X", We modified the "class X" by <adding | removing> : <attribute | method> : A, B, C..."
 *
 * <Changes from milestone 1 and 2 to milestone 3:
 *  "To implement "Epic feature X", We modified the "class X" by <adding | removing> : <attribute | method> : A, B, C..."
 *  "To implement "Epic feature X", We modified the "class X" by <adding | removing> : <attribute | method> : A, B, C..."
 *  "To implement "Epic feature X", We modified the "class X" by <adding | removing> : <attribute | method> : A, B, C..."
 *  "To implement "Epic feature X", We modified the "class X" by <adding | removing> : <attribute | method> : A, B, C..."
 *  "To implement "Epic feature X", We modified the "class X" by <adding | removing> : <attribute | method> : A, B, C..."
 *
 */

public class Main {
    public static void main(String[] args) {
        DartView.printIntroAscii();
        DartView dart = new DartView();

        UserInputHandler.closeScanner();
    }
}