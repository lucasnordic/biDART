package dart.users;

import dart.tools.InvalidDataInput;

import java.util.Calendar;

/**
 * This class handles the Employee and methods related:
 */

public class Employee extends User {

    private final int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    private int birthYear;
    private double grossSalary;
    private String type = "Employee";
    private double netSalary;

    /**
     *  Constructors here. We can choose to create an empty Employee or if we want to send create an employee with attributes:
     */

    public Employee (String name, String password, int birthYear, double grossSalary) {
        super(name, password);
        this.birthYear = birthYear;
        this.grossSalary = grossSalary;
        if (name.isEmpty() && grossSalary < 0) {
            throw new InvalidDataInput("Invalid data. Employee's name cannot be empty and gross salary cannot be negative");
        } if (name.isEmpty()){
            throw new InvalidDataInput("Invalid data. Employee's name cannot be empty");
        } if (grossSalary < 0) {
            throw new InvalidDataInput("Invalid data. Gross salary cannot be negative.");
        }else { }
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
        return this.grossSalary + calculateBonus();
    }
    public double setGrossSalary(double grossSalary) { return this.grossSalary = grossSalary; }

    public double getNetSalary() {
        if (getGrossSalary() * 12 < 100000) {
            netSalary =+ getGrossSalary() * 12;
        } else if (getGrossSalary() * 12 >= 100000) {
            netSalary =+ (getGrossSalary() * 12) * 0.70;
        }

        return netSalary;
    }

    @Override
    public String getType() {
        return type;
    }

    /**
     *  Methods:
     */

    public int calculateAge() {
        return currentYear - birthYear;
    }

    public double calculateBonus() {
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
        return getId() + " : " + getName() + " - " + birthYear + " (" + calculateAge() + ")" + " : " + this.getGrossSalary() + " SEK.";
    }
}