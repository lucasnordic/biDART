package DART.Data;

import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;

public class Employee {

    private String name;
    private int employeeID;
    private int birthYear;
    private double grossSalary;

    // controller:
    public Employee(String name, int employeeID, int birthYear, double grossSalary) {
        this.name = name;
        this.employeeID = employeeID;
        this.birthYear = birthYear;
        this.grossSalary = grossSalary;
    }

    public String[] getName() {
        return new String[]{this.name};
    }

    public int getEmployeeID() {
        return this.employeeID;
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
    public void setEmployeeID(int employeeID) {
        this.birthYear = employeeID;
    }

    public void setBirthYear(int birthYear){
        this.birthYear = birthYear;
    }
    private void initializeArray(String[] anArray) {
        Arrays.fill(anArray, "");
    }

    //Return a String that represent the object.
    public String toString() {
        return "Employee: " + name + ".\n" +
                "ID: " + employeeID + "\nBirth Year: " +
                this.getBirthYear() + "\nGross Salary: " +
                this.getGrossSalary() + "\n\n";
    }
}
