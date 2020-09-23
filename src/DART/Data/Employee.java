package DART.Data;

import DART.PrintStuff;
import DART.userInputHandler;

import java.util.Arrays;

public class Employee {

    private String name;
    private int birthYear;
    private double grossSalary;

    // controller:
    public Employee(String name, int birthYear, double grossSalary) {
        this.name = name;
        this.birthYear = birthYear;
        this.grossSalary = grossSalary;
    }

    public String[] getName() {
        return new String[]{this.name};
    }

    public double getGrossSalary() {
        return this.grossSalary;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    //
    public double getBonus() {
        if (birthYear < 22) {
            return 4000.0;
        } else if (birthYear <= 30){
            return 6000.0;
        } else {
            return 7500.0;
        }
    }
    
    //Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setBirthYear(int birthYear){
        this.birthYear = birthYear;
    }
    private void initializeArray(String[] anArray) {
        Arrays.fill(anArray, "");
    }

    //Return a String that represent the object.
    public String toString() {
        return "Employee: " + name + ".\n" + "Birth Year: " +  this.getBirthYear() + "\nGross Salary: " + this.getGrossSalary() + "\n\n";
    }

    // TODO: Move this to employeeMenu?
    public static void main(String[] args) {
        PrintStuff printText = new PrintStuff();

        // Here we are printing text and then we are assigning a value to "employeeName".
        // We then
        printText.printLine("Type employee's name: ");
        String employeeName = userInputHandler.inputString();

        printText.printLine("Type employee's birth year: ");
        int employeeBirthYear = userInputHandler.inputInt();

        printText.printLine("Type employee's gross salary: ");
        double employeeGrossSalary = userInputHandler.inputDouble();

        /*
        Employee employee = new Employee(employeeName, employeeBirthYear, employeeGrossSalary);
        String[] allEmployees = employee.getName();
        for (String allEmployee : allEmployees) {
            System.out.println(allEmployee + " ");

        }
        */
    }

}
