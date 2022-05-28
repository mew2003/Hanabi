/*
 * Discard.java                18/05/2022
 * Info1
 */

package principal;

/** 
 * TODO Commenter la responsabilité de cette class
 * @author 
 *
 */
public class Discard {

    /** Liste des cartes de la dÃ©fausse */
    private final Card[] cardList;

    /**
     * DÃ©finition de Discard
     */
    public Discard() {
        /* Nombre de cartes prÃ©sente dans Hanabi */
        final int NB_CARD_MAX = 50;
        cardList = new Card[NB_CARD_MAX];
    }

    /** @return la liste des cartes présentes dans la défausse */
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
