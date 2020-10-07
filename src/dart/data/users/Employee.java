package dart.data.users;

import dart.data.users.parent.User;

import java.util.Calendar;

public class Employee extends User {
    private int birthYear;
    private double grossSalary;

    // Constructor:
    public Employee(String name, int birthYear, double grossSalary) {
        super(name);
        this.birthYear = birthYear;
        this.grossSalary = grossSalary;
    }


    // Setters and Getters:
    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear (int birthYear){
        this.birthYear = birthYear;
    }

    public double getGrossSalary() {
        return this.grossSalary + getBonus();
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public int getAge() {
        return Calendar.getInstance().get(Calendar.YEAR) - birthYear;
    }


    // Methods:
    public double getBonus() {
        if (getAge()< 22) {
            return 4000.0;
        } else if (getAge() <= 30) {
            return 6000.0;
        } else {
            return 7500.0;
        }
    }

    public String toString () {
        return getId() + " : " + name + " - " + birthYear + " (" + getAge() + ")" + " : " + this.getGrossSalary() + " SEK.";
    }
}