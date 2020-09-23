package DART.Old;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class EmployeeSalary {

    public static void EmployeeList (String employeeChoice) {

        List<Object> vowels = new ArrayList<>();

        vowels.add("A");
        vowels.add("E"); // [A, E]
        vowels.add("U"); // [A, E, U]

        System.out.println(vowels); // [A, E, U]

        vowels.add(2, "I"); // [A, E, I, U]
        vowels.add(3, "O"); // [A, E, I, O, U]

        System.out.println(vowels); // [A, E, I, O, U]
    }

}