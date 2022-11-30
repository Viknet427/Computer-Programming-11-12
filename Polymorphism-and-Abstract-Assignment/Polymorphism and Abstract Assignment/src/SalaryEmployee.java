public class SalaryEmployee extends Employee {

    int annualSalary;
    boolean hasBenefits;

    SalaryEmployee(String name, int hireYear, int annualSalary) {

        super(name, hireYear);
        this.annualSalary = annualSalary;

    }

    public double annualSalary() {

        return annualSalary;

    }

    public double monthlySalary() {

        return (double)annualSalary/12;

    }

}
