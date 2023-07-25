public abstract class Card implements Comparable<Card> {

    private final int value;
    private final Suit suit;

    /**
     * The constructor creates a card using a number and a suit
     * @param value must be a positive integer between 1 and 13
     * @param suit must be DIAMOND, CLUB, HEART, or SPADE
     */
    public Card(int value, Suit suit) {

        this.value = value;
        this.suit = suit;

    }

    public int getValue() {

        return value;

    }

    public Suit getSuit() {

        return suit;

    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Card) {

            Card other = (Card)obj;
            return this.value == other.value && this.suit.equals(other.suit);

        }

        return false;

    }

    @Override
    public int hashCode() {

        return suit.getSuit().hashCode() + value;

    }

    public abstract String toString();

    @Override
    public int compareTo(Card o) {

        if (this.value < o.value) {

            return -1;

        }

        else if (this.value > o.value) {

            return 1;

        }

        return 0;

    }

}
