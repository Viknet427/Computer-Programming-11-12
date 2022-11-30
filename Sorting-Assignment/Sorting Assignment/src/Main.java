public class Main {

    public static int increase(int[] arr, int counter) {

        if (counter < arr.length-1) { return counter + 1; }
        else { return counter; }

    }

    public static int[] merge(int[] arrA, int[] arrB) {

        int[] arrC = new int[arrA.length + arrB.length];
        int a = 0;
        int b = 0;

        for (int i = 0; i < arrC.length; i++) {

            if (arrA[a] > arrB[b]) {

                arrC[i] = arrA[a];
                arrA[a] = 0;
                a = increase(arrA, a);

            }

            else if (arrB[b] >= arrA[a]) {

                arrC[i] = arrB[b];
                arrB[b] = 0;
                b = increase(arrB, b);

            }

        }

        return arrC;

    }

    public static int[] mergeSort(int[] arr) {

        if (arr.length < 2) {

            return arr;

        }

        else {

            int[] arrA = new int[arr.length/2];
            int[] arrB = new int[arr.length - arrA.length];
            System.arraycopy(arr, 0, arrA, 0, arrA.length);
            System.arraycopy(arr, arrA.length, arrB, 0, arrB.length);
            return merge(mergeSort(arrA), mergeSort(arrB));

        }

    }

    public static void main(String[] args) {

        int[] arrA = {5, 78, 56, 32, 15, 23, 56, 11};
        int[] arrB = mergeSort(arrA);
        for (int b : arrB) {

            System.out.println(b);

        }

    }

}
