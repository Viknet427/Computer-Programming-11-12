package AverageCounter;

public class Main {

    public static void main(String[] args) {

        int[] numbers = new int[10];

        for (int i = 0; i < numbers.length; i++) {

            int random = (int)(Math.random()*100 + 1);
            numbers[i] = random;

        }

        int total = 0;

        for (int number : numbers) {

            total = total + number;

        }

        int average = total / numbers.length;

        //Two random indexes swapped array
        int[] swap = new int[numbers.length];

        for (int i = 0; i < numbers.length; i++) {

            swap[i] = numbers[i];
            System.out.println("Index: " + i + "\tValue: " + numbers[i]);

        }

        System.out.println("\nThe average of the randomly generated numbers from 1 and 100 is: " + average + "\n");

        for (int i = 0; i < 2; i++) {

            int[] swap2 = new int[swap.length];

            int random;
            int random2;

            if (i != 0) {

                System.arraycopy(swap, 0, swap2, 0, swap.length);

            }

            do {

                random = (int)(Math.random()*10);
                random2 = (int)(Math.random()*10);

            } while (random == random2);

            if (i == 0) {

                swap[random] = numbers[random2];
                swap[random2] = numbers[random];

            }

            else {

                swap[random] = swap2[random2];
                swap[random2] = swap2[random];

            }

            System.out.println("Index: " + random + " was swapped with Index: " + random2);

        }

        System.out.println();

        for (int i = 0; i < numbers.length; i++) {

            System.out.println("Index: " + i + "\tValue: " + swap[i]);

        }

        System.out.println();

        //Reversing the previous array
        int[] reversed = new int[swap.length];

        for (int i = 0; i < reversed.length; i++) {

            reversed[i] = swap[reversed.length-1 - i];

        }

        for (int i = 0; i < reversed.length; i ++) {

            System.out.println("Index: " + i + "\tValue: " + reversed[i]);

        }

    }

}
