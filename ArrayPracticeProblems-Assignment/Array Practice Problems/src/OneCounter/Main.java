package OneCounter;

public class Main {

    public static void main(String[] args) {

        int[] numbers = new int[20];

        int counter = 0;
        for (int i = 0; i < numbers.length; i++) {

            int random = (int)(Math.random()*6 + 1);
            numbers[i] = random;

            if (numbers[i] == 1) {

                counter++;

            }

        }

        System.out.println("The number 1 was generated " + counter + " times");

    }

}
