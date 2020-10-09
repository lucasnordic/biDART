package dart.users;

import dart.UserInputHandler;

import java.util.Arrays;
import java.util.Calendar;
import java.util.UUID;

/**
 * This class handles the Employee and methods related:
 */

public class Employee extends User {

    private final int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    private int birthYear;
    private double grossSalary;

    /**
     *  Constructors here. We can choose to create an empty Employee or if we want to send create an employee with attributes:
     */

    public Employee(String name, String password, int birthYear, double grossSalary) {
        super(name, password);
        this.birthYear = birthYear;
        this.grossSalary = grossSalary;
    }

    public Employee() {
        super();
    }

    /**
     *  Getters and setters:
     */

    public int getBirthYear() {
        return birthYear;
    }
    public void setBirthYear ( int birthYear){
        this.birthYear = birthYear;
    }

    public double getGrossSalary() {
        return this.grossSalary + getBonus();
    }
    public double setGrossSalary(double grossSalary) { return this.grossSalary = grossSalary; }

    /**
     *  Methods:
     */

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

    /**
     *  Override:
     */

    @Override
    public String toString () {
        return getId() + " : " + getName() + " - " + birthYear + " (" + getAge() + ")" + " : " + this.getGrossSalary() + " SEK.";
    }
}