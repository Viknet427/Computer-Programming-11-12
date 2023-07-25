public class NumberCard extends Card {

    NumberCard(int value, Suit suit) {

        super(value, suit);

    }

    public String toString() {

        return this.getValue() + " of " + this.getSuit();

    }

}
