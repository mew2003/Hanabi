/*
 * Discard.java                18/05/2022
 * Info1
 */

package principal;

/** 
 * L'endroit o� les cartes invalides jou�es par les joueurs sont stock�s
 * @author S�bastien, Mewen, Maxime
 *
 */
public class Discard {

    /** Liste des cartes de la d�fausse */
    private final Card[] cardList;

    /**
     * D�finition de Discard
     */
    public Discard() {
        /* Nombre de cartes pr�sente dans Hanabi */
        final int NB_CARD_MAX = 50;
        cardList = new Card[NB_CARD_MAX];
    }

    /** @return la liste des cartes présentes dans la d�fausse */
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
