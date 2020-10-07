package dart.data.items;

import dart.data.items.parent.grandparent.Item;

import java.util.Calendar;

public class Employee extends Item {
    private int birthYear;
    private double grossSalary;
    private int currentYear = Calendar.getInstance().get(Calendar.YEAR);

    // Constructor:
    public Employee(String name, int birthYear, double grossSalary) {
        super(name);
        this.birthYear = birthYear;
        this.grossSalary = grossSalary;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public String getName() {
        return name;
    }

    public double getGrossSalary() {
        return this.grossSalary + getBonus();
    }

    public int getAge() {
        return currentYear - birthYear;
    }

//    public void setName (String name){
//        this.name = name;
//    }



    public void setBirthYear (int birthYear){
        this.birthYear = birthYear;
    }

    // Methods:
    public double getBonus() {
        if ((currentYear - birthYear) < 22) {
            return 4000.0;
        } else if ((currentYear - birthYear) <= 30) {
            return 6000.0;
        } else {
            return 7500.0;
        }
    }

    public String toString () {
        return getId() + " : " + name + " - " + birthYear + " (" + getAge() + ")" + " : " + this.getGrossSalary() + " SEK.";
    }
}