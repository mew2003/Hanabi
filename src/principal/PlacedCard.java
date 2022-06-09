/*
 * PlacedCard.java                18/05/2022
 * Info1
 */

package principal;

import java.util.Objects;

/** 
 * Créer l'endroit où les cartes seront placé quand un joueur jouera une carte
 * @author Sébastien, Mewen, Maxime
 */
public class PlacedCard {

    /** Liste des cartes centrales du plateau de jeu */
    private final Card[] cardList;

    /**
     * Définition de PlacedCard
     * Initialise la liste des cartes centrales
     * avec des valeurs égales à 0 pour le bon fonctionnement
     * de la méthode placeACard.
     */
    public PlacedCard() {
        cardList = new Card[5];
        cardList[0] = new Card("red", 0);
        cardList[1] = new Card("blue", 0);
        cardList[2] = new Card("pink", 0);
        cardList[3] = new Card("yellow", 0);
        cardList[4] = new Card("white", 0);
    }

    /**
     * Place une carte sur le plateau de jeu si pour sa couleur la valeur
     * est la même que celle de la carte placée +1.
     * @param card Une carte dans la main d'un joueur
     * @param token Le jeton bleu 
     * @return true si la carte a été placée, false sinon
     * @throws IllegalArgumentException si la valeur de la carte est incorrect 
     *                                  (inférieur à 0 ou supérieur à 5)
     */
    public boolean placeACard(Card card, Token token) {
    	
    	if (card.getValue() < 0 || card.getValue() > 5) {
    		throw new IllegalArgumentException("La valeur " + card.getValue() + " de la carte est incorrect.");
    	}

        boolean isSuccess = false;

        for (int i = 0; i < cardList.length; i++) {
            if (Objects.equals(card.getColor(), cardList[i].getColor()) && card.getValue() == cardList[i].getValue() + 1) {
                isSuccess = true;
                cardList[i] = card;
                if (card.getValue() == 5) {
                    token.incToken();
                }
            }
        }

        return isSuccess;
    }

    /** @return La liste de carte placées */
    public Card[] getCardList() {
        return cardList;
    }

    @Override
    public String toString() {
        StringBuilder placedCard = new StringBuilder();
        for (Card card : cardList) {
            placedCard.append(card.toString()).append(" ");
        }
        return placedCard.toString();
    }
}
