public abstract class Employee {

    public String name;
    public int hireYear;

    Employee(String name, int hireYear) {

        this.name = name;
        this.hireYear = hireYear;

    }

    Employee() {

        name = "";
        hireYear = 0;

    }

    public String getName() {

        return name;

    }

    public int getHireYear() {

        return hireYear;

    }

    public abstract double annualSalary();

    public abstract double monthlySalary();

    public String toString() {

        return "Employee[Name: " + name + ", Hire Year: " + hireYear + "]";

    }

}
