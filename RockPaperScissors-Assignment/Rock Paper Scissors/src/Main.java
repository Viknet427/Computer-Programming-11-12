import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int wins = 0;
        int losses = 0;

        Scanner scan = new Scanner(System.in);
        String[] options = {"rock", "paper", "scissors"};

        boolean ans = true;
        do {

            System.out.println("Current Score");
            System.out.println("You: " + wins);
            System.out.println("Computer: " + losses + "\n");

            int random = (int) (Math.random() * 3);
            String com = options[random];

            String player;
            do {

                System.out.println("Choose rock, paper, or scissors: ");
                player = scan.next();

            } while (!Arrays.asList(options).contains(player));

            System.out.println("Computer chose: " + com + "\nYou chose: " + player);

            boolean cont = true;
            if (com.equals(player)) {

                System.out.println("You tied.");
                cont = false;

            }

            if (cont) {

                boolean winState = false;
                switch (player) {

                    case "rock":
                        winState = com.equals("scissors");
                        break;

                    case "paper":
                        winState = com.equals("rock");
                        break;

                    case "scissors":
                        winState = com.equals("paper");
                        break;

                }

                if (winState) {

                    System.out.println("You win!");
                    wins++;

                } else {

                    System.out.println("You lose...");
                    losses++;

                }

            }

            String[] choices = {"y", "n"};
            String choice;
            do {

                System.out.println("Do you want to play again? (y/n)");
                choice = scan.next();

            } while (!Arrays.asList(choices).contains(choice));

            if (choice.equals("n")) {

                ans = false;

            }

        } while (ans);

        System.out.println("Final Score");
        System.out.println("You: " + wins);
        System.out.println("Computer: " + losses);

    }

}
