package principal;

public class Hand {

    private Card[] cards;

    public Hand() {}

    public Hand setHand(int position, Card card) {
        this.cards[position] = card;
        return this;
    }

}
