package DART.Data;

import DART.PrintStuff;
import DART.ScannerInput;

public class Employee {

    private String name;
    private int birthYear;
    private double grossSalary;

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
        for(int i = 0; i < anArray.length; i++) {
            anArray[i] = "";
        }
    }

    //Return a String that represent the object.
    public String toString() {
        return name + " was born in " + this.getBirthYear() + " and gets " + this.getGrossSalary() + " as gross salary.";
    }

    public static void main(String[] args) {
        PrintStuff printText = new PrintStuff();
        ScannerInput input = new ScannerInput();
   
        printText.printLine("Type employee's name: ");
        String employeeName = input.inputString();
        
        printText.printLine("Type employee's birth year: ");
        int employeeBirthYear = input.inputInt();
        printText.printLine("Type employee's gross salary: ");
        double employeeGrossSalary = input.inputDouble();
        Employee employee = new Employee(employeeName, employeeBirthYear, employeeGrossSalary);
        String[] allEmployees = employee.getName();
        for(int i = 0; i < allEmployees.length; i++) {
            System.out.println(allEmployees[i] + " ");
    
        }
        
    }

}
