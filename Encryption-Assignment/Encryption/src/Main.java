import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        char[] alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        char[] cipher = "poqvnylzaxejmgcwitufsdbrkhPOQVNYLZAXEJMGCWITUFSDBRKH".toCharArray();
        StringBuilder[] encryption = new StringBuilder[2];

        System.out.println("Enter a word or a bunch of random letters to be encrypted: ");
        String word = scan.next();

        char[] encrypt = word.toCharArray();
        encryption[0] = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {

            for (int k = 0; k < alphabet.length; k++) {

                if (encrypt[i] == alphabet[k]) {

                    encryption[0].append(cipher[k]);

                }

            }

        }

        System.out.println(encryption[0]);

        char[] decrypt = encryption[0].toString().toCharArray();
        encryption[1] = new StringBuilder();

        for (int i = 0; i < encryption[0].length(); i++) {

            for (int k = 0; k < cipher.length; k++) {

                if (decrypt[i] == cipher[k]) {

                    encryption[1].append(alphabet[k]);

                }

            }

        }

        System.out.println(encryption[1]);

    }

}
