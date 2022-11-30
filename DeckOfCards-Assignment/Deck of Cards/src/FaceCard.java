public class FaceCard extends Card {

    private String face;

    FaceCard(int value, Suit suit) {

        super(value, suit);
        if (value == 1) {

            face = "Ace";

        }

        else if (value == 11) {

            face = "Jack";

        }

        else if (value == 12) {

            face = "Queen";

        }

        else if (value == 13) {

            face = "King";

        }

    }

    public String toString() {

        return face + " of " + this.getSuit();

    }

}
