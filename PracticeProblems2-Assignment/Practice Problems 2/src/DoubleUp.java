import java.util.Scanner;

public class DoubleUp {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Pick a number and how many times it should be multiplied by 2.");

        int[] num = new int[2];
        num[0] = scan.nextInt();
        num[1] = scan.nextInt();

        int counter = 0;

        System.out.print("answer = " + num[0]);

        for (int i = 0; i < num[1]; i++) {

            System.out.print("x2");
            counter++;

        }

        int multiplier = (int)(Math.pow(2, counter));
        int answer = num[0] * multiplier;

        System.out.println("\n" + answer);

    }

}
