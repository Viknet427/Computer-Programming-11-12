import java.util.Scanner;

public class ModularFactoringBonus {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter 2 numbers: ");

        int[] num = new int[2];
        num[0] = input.nextInt();
        num[1] = input.nextInt();

        int counter = 0;

        for (int i = 0; i < num[1]; i++) {

            if ((i % 7 == 0) && (i >= num[0]) && (i != 0)) {

                System.out.println(i + " is a factor");
                counter++;

            }

        }

        System.out.println("There are " + counter + " factors");

    }

}
