import java.util.Scanner;

public class CorrectNumber {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Guess my number.");
        int num = scan.nextInt();

        while (num != 7) {

            System.out.println("Guess again.");
            num = scan.nextInt();

        }

        System.out.println("Nice guess.");

    }

}
