import java.util.Scanner;

public class Password {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] password = new String[2];

        System.out.println("Create a password: ");
        password[0] = input.next();

        System.out.println("Reenter the password: ");
        password[1] = input.next();

        while (!password[0].equals(password[1])) {

            System.out.println("Reenter the password: ");
            password[1] = input.next();

        }

        System.out.println("Nice.");

    }

}
