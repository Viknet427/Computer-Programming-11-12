import java.util.Scanner;

public class Range {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("What is your age?");
        int age = scan.nextInt();

        while (age < 10 || age > 50) {

            if (age < 10) {
                System.out.println("Too young.");
                age = scan.nextInt();
            }

            if (age > 50) {

                System.out.println("Too old.");
                age = scan.nextInt();
            }

        }

        System.out.println("Nice.");

    }

}
