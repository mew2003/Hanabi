package principal;

import java.util.Arrays;

public class Discard {

    /** Nombre de carte présente dans Hanabi */
    private final int NBCARD_MAX = 50;

    /** Nombre de cartes actuellement présentes dans la défausse */
    private int nbCard;

    /** Liste des cartes de la défausse */
    private Card[] cardList;

    /**
     * Définition de Discard
     */
    public Discard() {
        cardList = new Card[NBCARD_MAX];
        nbCard = 0;
    }

    /**
     * Ajoute une carte à la défausse
     * @param cardList
     */
    public void setCardList(Card[] cardList) {
        this.cardList = cardList;
    }

    public Card[] getCardList() {
        return cardList;
    }

    @Override
    public String toString() {
        return "Liste des cartes de la défausse : " + Arrays.toString(cardList);
    }
}
