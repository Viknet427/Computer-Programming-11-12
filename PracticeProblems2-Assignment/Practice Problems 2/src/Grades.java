import java.util.Scanner;

public class Grades {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("How many grades do you want to enter? ");
        int grade = scan.nextInt();

        int[] percent = new int[grade];

        for (int i = 0; i < grade; i++) {

            System.out.println("Enter the percentage of grade #" + (i + 1) + ": ");
            percent[i] = scan.nextInt();

        }

        int subTotal = 0;

        for (int counter = 0; counter < grade; counter++) {

            subTotal = subTotal + percent[counter];

        }

        int total = subTotal / grade;
        System.out.println("Your grade average is: " + total + "%.");

    }

}
