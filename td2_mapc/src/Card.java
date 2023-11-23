
enum Suit {
    HEARTS, DIAMONDS, CLUBS, SPADES
}

enum Rank {
    ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING
}
public class Card {
    private Suit aSuit;
    private Rank aRank;

    public Card(Suit aSuit, Rank aRank) {
        this.aSuit = aSuit;
        this.aRank = aRank;
    }

    public Suit getaSuit() {
        return aSuit;
    }

    public Rank getaRank() {
        return aRank;
    }
}
