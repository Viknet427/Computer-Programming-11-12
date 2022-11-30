import java.util.Arrays;
import java.util.Scanner;

public class MainOld {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String[] options = {"rock", "paper", "scissors", "x"};
        int wins = 0;
        int losses = 0;

        boolean ans = true;
        do {

            System.out.println("Current Score");
            System.out.println("You: " + wins);
            System.out.println("Computer: " + losses + "\n");

            int com = (int)(Math.random() * 3 + 1);
            int rock = 1;
            int paper = 2;
            int scissors = 3;

            String player;
            do {

                System.out.println("Choose rock, paper or scissors (X to exit): ");
                player = scan.next();

            } while (!Arrays.asList(options).contains(player));

            if (player.toLowerCase().equals("x")) {

                break;

            }

            int playerChoice = 0;
            switch (player) {

                case "rock":

                    playerChoice = 1;
                    break;

                case "paper":

                    playerChoice = 2;
                    break;

                case "scissors":

                    playerChoice = 3;
                    break;

            }

            String comChoice = "";
            switch (com) {

                case 1:
                    comChoice = "rock";
                    break;

                case 2:
                    comChoice = "paper";
                    break;

                case 3:
                    comChoice = "scissors";
                    break;

            }

            System.out.println("Computer chose: " + comChoice + "\nYou chose: " + player);

            if (com == playerChoice) {


                System.out.println("It's a tie.");

            }

            else if (com == rock) {

                if (playerChoice == paper) {

                    System.out.println("You win!");
                    wins++;

                }

                else if (playerChoice == scissors) {

                    System.out.println("You lose...");
                    losses++;

                }

            }

            else if (com == paper) {

                if (playerChoice == scissors) {

                    System.out.println("You win!");
                    wins++;

                }

                else if (playerChoice == rock) {

                    System.out.println("You lose...");
                    losses++;

                }

            }

            else if (com == scissors) {


                if (playerChoice == rock) {

                    System.out.println("You win!");
                    wins++;

                }

                else if (playerChoice == paper) {

                    System.out.println("You lose...");
                    losses++;

                }

            }

            String[] choices = {"y", "n"};
            String choice;
            do {

                System.out.println("Do you want to play again? (Y/N) ");
                choice = scan.next();

            } while (!Arrays.asList(choices).contains(choice));

            System.out.println("\n");

            if (choice.toLowerCase().equals("n")) {

                ans = false;

            }

        } while (ans);

        System.out.println("Final Score");
        System.out.println("You: " + wins);
        System.out.println("Computer: " + losses);

    }

}
