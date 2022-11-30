import java.util.ArrayList;

public class Main {

    public static ArrayList<SalaryEmployee> salaryEmployees(ArrayList<Employee> employees) {

        ArrayList<SalaryEmployee> salaryEmployees = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < employees.size(); i++) {

            if (employees.get(i) instanceof SalaryEmployee) {

                while (employees.get(i) instanceof SalaryEmployee) {

                    salaryEmployees.add((SalaryEmployee)employees.get(i));

                    if (i != employees.size()-1) {

                        i++;

                    }

                    else {

                        j++;
                        if (j == 1) {

                            break;

                        }

                    }

                }

            }

        }

        return salaryEmployees;

    }

    public static ArrayList<PartTime> partTimes(ArrayList<Employee> employees) {

        ArrayList<PartTime> partTimes = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < employees.size(); i++) {

            if (employees.get(i) instanceof PartTime) {

                while (employees.get(i) instanceof PartTime) {

                    partTimes.add((PartTime)employees.get(i));

                    if (i != employees.size()-1) {

                        i++;

                    }

                    else {

                        j++;
                        if (j == 1) {

                            break;

                        }

                    }

                }

            }

        }

        return partTimes;

    }

    public static ArrayList<FullTime> fullTimes(ArrayList<Employee> employees) {

        ArrayList<FullTime> fullTimes = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < employees.size(); i++) {

            if (employees.get(i) instanceof FullTime) {

                while (employees.get(i) instanceof FullTime) {

                    fullTimes.add((FullTime)employees.get(i));

                    if (i != employees.size()-1) {

                        i++;

                    }

                    else {

                        j++;
                        if (j == 1) {

                            break;

                        }

                    }

                }

            }

        }

        return fullTimes;

    }

    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();
        employees.add(new SalaryEmployee("Jon", 2016, 80000));
        employees.add(new PartTime("Joe", 2014, 12, 13.65));
        employees.add(new FullTime("Job", 2017, 40, 17));
        employees.add(new SalaryEmployee("Jon", 2016, 80000));
        employees.add(new SalaryEmployee("Jon", 2016, 80000));
        employees.add(new FullTime("Job", 2017, 40, 17));
        employees.add(new FullTime("Job", 2017, 40, 17));
        employees.add(new PartTime("Joe", 2014, 12, 13.65));
        employees.add(new PartTime("Joe", 2014, 12, 13.65));

        System.out.println("Salary Employees");
        ArrayList<SalaryEmployee> salaryEmployees = salaryEmployees(employees);
        for (SalaryEmployee salaryEmployee : salaryEmployees) {

            System.out.println(salaryEmployee);

        }

        System.out.println("Part Timers");
        ArrayList<PartTime> partTimes = partTimes(employees);
        for (PartTime partTime : partTimes) {

            System.out.println(partTime);

        }

        System.out.println("Full Timers");
        ArrayList<FullTime> fullTimes = fullTimes(employees);
        for (FullTime fullTime : fullTimes) {

            System.out.println(fullTime);

        }

    }

}
