/*
 * Discard.java                18/05/2022
 * Info1
 */

package principal;

/** 
 * L'endroit où les cartes invalides jouées par les joueurs sont stockés
 * @author Sébastien, Mewen, Maxime
 *
 */
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

    /** @return la liste des cartes prÃ©sentes dans la défausse */
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
