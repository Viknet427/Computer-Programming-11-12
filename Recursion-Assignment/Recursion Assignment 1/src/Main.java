public class Main {

    public static int fibonacciSequenceNotRecursive(int n) {

        int prev = 1;
        int nextPrev = 0;
        int current = 0;
        
        for (int i = 1; i < n; i++) {

            if (i != 2) {

                current = prev + nextPrev;
                nextPrev = prev;
                prev = current;

            }

        }

        return current;

    }

    /**
     *
     * @param n must be a positive integer that is not 0
     * @param prev the previous number of the fibonacci sequence (1)
     * @param nextPrev the previous, previous number of the fibonacci sequence (0)
     * @return returns the n+2 term of the fibonacci sequence
     * e.g. n = 6 returns 13, the 8th number of the fibonacci sequence
     */
    public static int fibonacciSequence(int n, int prev, int nextPrev) {

        if (n == 1) { return prev + nextPrev; }
        return fibonacciSequence(n - 1, prev + nextPrev, prev);

    }

    public static void main(String[] args) {

        int prev = 1;
        int nextPrev = 0;
        int term = 6;
        System.out.println("Term " + (term + 2) + " of the fibonacci sequence is: "
                + fibonacciSequence(term, prev, nextPrev));

    }

}
