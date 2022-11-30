public class Main {

    public static void printMove(String from, String to) {

        System.out.println("From: " + from + "\tTo: " + to);

    }

    public static void towers(int n, String from, String to, String spare) {

        if (n == 1) {

            printMove(from, to);

        }

        else {

            towers(n-1, from, spare, to);
            printMove(from, to);
            towers(n-1, spare, to, from);

        }

    }

    public static void main(String[] args) {

        towers(5, "p1", "p3", "p2");

    }

}
