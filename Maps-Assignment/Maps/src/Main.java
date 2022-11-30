import java.util.HashMap;
import java.util.Iterator;

public class Main {

    public static String cipher(HashMap<Letter, Letter> caesarCipher, String text) {

        StringBuilder cipherText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {

            if (text.charAt(i) == ' ') {

                cipherText.append(' ');

            }

            else if (Character.toUpperCase(text.charAt(i)) == text.charAt(i)) {

                cipherText.append(Character.toUpperCase(caesarCipher.get(
                        new Letter(Character.toLowerCase(text.charAt(i)))).letter));

            }

            else {

                cipherText.append(caesarCipher.get(new Letter(Character.toLowerCase(text.charAt(i)))));

            }

        }

        return cipherText.toString();

    }

    public static String decipher(HashMap<Letter, Letter> caesarCipher, String text) {

        StringBuilder decipherText = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {

            Iterator<Letter> letterIterator = caesarCipher.keySet().iterator();
            while (letterIterator.hasNext()) {

                Letter l = letterIterator.next();
                if (text.charAt(i) == ' ') {

                    decipherText.append(' ');
                    break;

                }

                else if (text.charAt(i) == Character.toUpperCase(text.charAt(i)) &&
                         Character.toLowerCase(text.charAt(i)) == caesarCipher.get(l).letter) {

                    decipherText.append(Character.toUpperCase(l.letter));
                    break;

                }

                else if (text.charAt(i) == caesarCipher.get(l).letter) {

                    decipherText.append(l.letter);
                    break;

                }

            }

        }

        return decipherText.toString();

    }

    public static void main(String[] args) {

        String text = "Hello World";
        int shift = -5;

        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        HashMap<Letter, Letter> cipher = new HashMap<>();
        for (int i = 0; i < alphabet.length(); i++) {

            while (shift < 0) {

                shift += 26;

            }

            cipher.put(new Letter(alphabet.charAt(i)), new Letter(alphabet.charAt((i + shift) % 26)));

        }

        String cipherText = cipher(cipher, text);
        System.out.println("Original: " + text);
        System.out.println("Ciphered: " + cipherText);

        String decipherText = decipher(cipher, cipherText);
        System.out.println("Deciphered: " + decipherText);

    }

}
