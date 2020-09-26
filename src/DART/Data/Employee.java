package DART.Data;

import java.util.Arrays;
import java.util.UUID;

public class Employee {

    private String name;
    private int birthYear;
    private double grossSalary;
    private String id;

    // controller:
    public Employee(String name, int birthYear, double grossSalary) {
        this.name = name;
        this.birthYear = birthYear;
        this.grossSalary = grossSalary;
        this.id = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public double getGrossSalary() {

        return this.grossSalary + getBonus();
    }

    public int getAge() {
        return 2020-birthYear;
    }

    public String getId() {
        return id;
    }

    //
    public double getBonus() {
        if (getAge() < 22) {
            return 4000.0;
        } else if (getAge() <= 30){
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
        return "ID: " + id + " Name: " + name + ". " + "Age: " +  this.getAge() + " years old." + "Gross Salary: " + this.getGrossSalary();
    }
}
