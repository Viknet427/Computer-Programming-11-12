public class Main {

    public static int[] add(int[] arr, int num) {

        System.out.println("Adding a value to the end of an array");

        int[] temp = new int[arr.length + 1];
        System.arraycopy(arr, 0, temp, 0, arr.length);
        temp[temp.length-1] = num;

        return temp;

    }

    public static int[] delete(int[] arr) {

        System.out.println("Deleting a value from the end of the array");

        int[] temp = new int[arr.length - 1];
        System.arraycopy(arr, 0, temp, 0, temp.length);

        return temp;

    }

    public static int[] insert(int[] arr, int num, int pos) {

        System.out.println("Inserting a value at a chosen index position");

        int[] temp = new int[arr.length + 1];
        System.arraycopy(arr, 0, temp, 0, arr.length);

        for (int i = 0; i < (temp.length - pos); i++) {

            if (i == (temp.length - 1)) {

                temp[temp.length - (i + 1)] = 0;

            }

            else {

                temp[temp.length - (i + 1)] = temp[temp.length - (i + 2)];

            }

        }

        temp[pos] = num;

        return temp;

    }

    public static void main(String[] args) {

        int[] arr = {2,3,5};

        System.out.println("Array");
        for (int arra : arr) {

            System.out.println(arra);

        }

        System.out.println();

        int[] arr2;
        arr2 = add(arr, 6);

        for (int arr2a : arr2) {

            System.out.println(arr2a);

        }

        System.out.println();

        int[] arr3;
        arr3 = delete(arr);

        for (int arr3a : arr3) {

            System.out.println(arr3a);
        }

        System.out.println();

        int[] arr4;
        arr4 = insert(arr, 4, 2);

        for (int arr4a : arr4) {

            System.out.println(arr4a);

        }

        System.out.println();

    }

}
