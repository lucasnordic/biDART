package DART;

//  This class will handle printing
public class PrintStuff {

    // this method is access after creating new instance
    // and calling the method like this:
    //
    //    PrintStuff p = new PrintStuff();
    //    p.printLine("Something I want to print");
    //
    public void printLine(String text) {
        System.out.println(text);
    }

    // This method is accessed everywhere in the code and is available
    // as long as the program lives:
    //
    //    PrintStuff.printInfo();
    //
    public static void printInfo() {
        System.out.println("This is DART");
    }

}

