import java.util.Scanner;
public class InputClass {
    public static Scanner input = new Scanner(System.in);
    public static double readDouble( String addNameText) {
        System.out.print( addNameText );
        double decimalValue = input.nextDouble();
        input.nextLine();
        return decimalValue;
    }public static int readInt( String addBirthYearText) {
        System.out.print( addBirthYearText );
        int numbers = input.nextInt();
        input.nextLine();
        return numbers; }
    public static String readLine(String addGrossSalaryText ) {
        System.out.println( addGrossSalaryText );
        String sentence = input.nextLine();
        input.nextLine();
        return sentence; }
}
