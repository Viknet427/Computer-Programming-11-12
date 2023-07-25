public class PartTime extends HourlyEmployee {

    public boolean hasBenefits;

    PartTime(String name, int hireYear, double hoursPerWeek, double hourlyWage) {

        super(name, hireYear, hoursPerWeek, hourlyWage);

    }

    public boolean hasBenefits() {

        return hasBenefits;

    }

    public double annualSalary() {

        return hoursPerWeek*hourlyWage*52;

    }

    public double monthlySalary() {

        return hoursPerWeek*hourlyWage*4;

    }

}
