package DART.MenuItems;

public class MenuBase {
    String title;
    String[] items;
    String inputPrompt;

    public MenuBase(String title, String inputPrompt, String[] items) {
        this.title = title;
        this.items = items;
        this.inputPrompt = inputPrompt;
    }
/*
    public void runMenu(Scanner input) {
        int choice = 0;

        while (choice < 4) {
            choice = HandleMenu.chooseFromMenu(input, items, title, inputPrompt);
            handleMenuChoice(input, choice);
        }
    }

    public void handleMenuChoice (Scanner input, int menuChoice ) {

    }

 */
}
