package DART.Data;


public class Employee {

    String name;
    int birthYear;
    double grossSalary;

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

    // will do this later
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
/*
    public static void main(String[] args) {
        int NumOfEmployees = 2;
        for (int j = 0; j < NumOfEmployees ; j++) {
            String name = InputClass.readLine("Type employee's name: ");
            int birthYear = InputClass.readInt("Type employee's birth year: ");
            double funds = InputClass.readDouble("Type employee's gross salary: ");
            employee employee = new employee(name, birthYear, funds);
            String[] allEmployees = employee.getName();
            for(int i = 0; i < allEmployees.length; i++) {
                System.out.println(allEmployees[i] + " ");

            }
        }
        //System.out.println( employee.toString() );
    }
 */
}

