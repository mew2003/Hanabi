package principal;

public class Discard {

    /** Liste des cartes de la défausse */
    private final Card[] cardList;

    /**
     * Définition de Discard
     */
    public Discard() {
        /* Nombre de cartes présente dans Hanabi */
        final int NB_CARD_MAX = 50;
        cardList = new Card[NB_CARD_MAX];
    }

    public Card[] getCardList() {
        return cardList;
    }

    @Override
    public String toString() {
        StringBuilder discard = new StringBuilder();
        for (int i = 0; cardList[i] != null; i++) {
            discard.append(cardList[i].toString()).append(", ");
        }
        return discard.toString();
    }
}
