package dart.users;

import dart.UserInputHandler;

import java.util.Arrays;
import java.util.Calendar;
import java.util.UUID;

/**
 * This class handles the Employee and methods related:
 */

public class Employee extends User {

    private int birthYear;
    private double grossSalary;
    private final int currentYear = Calendar.getInstance().get(Calendar.YEAR);

    // controller:
    public Employee(String name, String password, int birthYear, double grossSalary) {
        super(name, password);
        this.birthYear = birthYear;
        this.grossSalary = grossSalary;
    }

    public Employee() {
        super();
    }

    public String getName() {
        return name;
    }

    public double getGrossSalary() {
        return this.grossSalary + getBonus();
    }

    public double setGrossSalary(double grossSalary) { return this.grossSalary = grossSalary; }

    public int getAge() {
        return currentYear - birthYear;
    }

    public double getBonus() {
        if ((currentYear - birthYear) < 22) {
            return 4000.0;
        } else if ((currentYear - birthYear) <= 30) {
            return 6000.0;
        } else {
            return 7500.0;
        }
    }

    //Setters
    public void setName (String name){
        this.name = name;
    }

    public void setBirthYear ( int birthYear){
        this.birthYear = birthYear;
    }

    @Override
    public String getName(String name) {
        return name;
    }

    @Override
    public String toString () {
        return getId() + " : " + name + " - " + birthYear + " (" + getAge() + ")" + " : " + this.getGrossSalary() + " SEK.";
    }
}

// Old:
//     private void initializeArray (String[]anArray){
//        Arrays.fill(anArray, "");
//    }
