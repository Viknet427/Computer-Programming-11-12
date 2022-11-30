import java.util.Scanner;

public class Addison {

    public static void main(String[] args) {

       Scanner scan = new Scanner(System.in);

       while (true) {
           int random = (int)(Math.random()*3);
           String[] hands = {"rock", "paper", "scissors"};
           String com = hands[random];
           System.out.println("What does the gamer want to choose?");
           String ans = scan.nextLine();
           int winState = 0;
           if (ans.toLowerCase().equals("rock") || ans.toLowerCase().equals("paper") || ans.toLowerCase().equals("scissors")){
               if(ans.toLowerCase().equals(com)){
                   winState = 2;
               }
               if (ans.toLowerCase().equals("rock")){
                   if(com.equals("scissors")){
                       winState = 1;
                   }
               }
               if (ans.toLowerCase().equals("scissors")){
                   if(com.equals("rock")){
                        winState = 1;
                   }
               }
               if (ans.toLowerCase().equals("paper")){
                   if(com.equals("scissors")){
                       winState = 1;
                   }
               }
               if (winState == 2){
                   System.out.println("It's a tie");
               }
               else if (winState == 1){
                   System.out.println("You win");
               }
               else{
                   System.out.println("u gay");
               }
               System.out.println("Play again? (y/n)");
               String re = scan.nextLine();
               if (re.toLowerCase().equals("n")) {
                   break;
           }
           }
           else{
               System.out.println("Wrong answer!");
           }
       }

    }

}
