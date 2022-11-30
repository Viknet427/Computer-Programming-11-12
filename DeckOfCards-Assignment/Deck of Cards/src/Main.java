import java.util.Collections;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<Card> deck = new LinkedList<>();
        for (Suit suit : Suit.values()) {

            for (int i = 1; i <= 13; i++) {

                if (i == 1 || i == 11 || i == 12 || i == 13) {

                    deck.add(new FaceCard(i, suit));

                }

                else {

                    deck.add(new NumberCard(i, suit));

                }

            }

        }

        System.out.println("-----Fresh New Deck-----");
        for (Card card : deck) {

            System.out.println(card);

        }

        Collections.sort(deck);
        System.out.println("-----In Ascending Number Order-----");
        for (Card card : deck) {

            System.out.println(card);

        }

        CompareByFace compare = new CompareByFace();
        Collections.sort(deck, compare);
        System.out.println("-----In Ascending Face Order-----");
        for (Card card : deck) {

            System.out.println(card);

        }

    }

}
