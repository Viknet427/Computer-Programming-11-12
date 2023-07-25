public abstract class HourlyEmployee extends Employee {

    public double hoursPerWeek;
    public double hourlyWage;
    public boolean hasBenefits;

    HourlyEmployee(String name, int hireYear, double hoursPerWeek, double hourlyWage) {

        super(name, hireYear);

        this.hoursPerWeek = hoursPerWeek;
        this.hourlyWage = hourlyWage;

    }

    public abstract boolean hasBenefits();

}
