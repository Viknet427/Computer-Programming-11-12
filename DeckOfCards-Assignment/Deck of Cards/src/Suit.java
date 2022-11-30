public enum Suit {

    DIAMOND("Diamond"), CLUB("Club"), HEART("Heart"), SPADE("Spade");

    private final String suit;

    Suit(String suit) {

        this.suit = suit;

    }

    public String getSuit() {

        return suit;

    }

}
