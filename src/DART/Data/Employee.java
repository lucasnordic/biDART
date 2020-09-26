package DART.Data;

import java.util.Arrays;
import java.util.Calendar;
import java.util.UUID;

public class Employee {

    private String name;
    private int birthYear;
    private double grossSalary;
    private String id;
    private int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    private double netSalary;

    // controller:
    public Employee(String name, int birthYear, double grossSalary) {
        this.name = name;
        this.birthYear = birthYear;
        this.grossSalary = grossSalary;
        this.id = UUID.randomUUID().toString();
        this.netSalary = 0;
    }

    public String getName() {
        return name;
    }

    public double getGrossSalary() {
        return this.grossSalary + getBonus();
    }

    public int getAge() {
        return 2020 - birthYear;
    }

    public String getId() {
        return id;
    }

    //
    public double getBonus() {
        if ((currentYear - birthYear) < 22) {
            return 4000.0;
        } else if ((currentYear - birthYear) <= 30) {
            return 6000.0;
        } else {
            return 7500.0;
        }
    }

    public void getNetSalary() {
        if (getGrossSalary() * 12 < 100000) {
            netSalary = getGrossSalary() * 12;
        }
        if (getGrossSalary() * 12 >= 100000) {
            netSalary = (getGrossSalary() * 12) * 0.70;
        }
    }

    //Setters
    public void setName (String name){
        this.name = name;
    }

    public void setBirthYear ( int birthYear){
        this.birthYear = birthYear;
    }
    private void initializeArray (String[]anArray){
        Arrays.fill(anArray, "");
    }

    //Return a String that represent the object.
    public String toString () {
        return id + " : " + name + " - " + birthYear + " (" + (currentYear - birthYear) + ")" + " : " + this.getGrossSalary() + " SEK.";
    }
}

