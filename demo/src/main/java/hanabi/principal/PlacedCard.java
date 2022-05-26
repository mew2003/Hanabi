package principal;

public class PlacedCard {

    /** Liste des cartes centrales du plateau de jeu */
    private Card[] cardList;

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
     * @return
     */
    public boolean placeACard(Card card, Token token) {

        boolean isSuccess = false;

        for (int i = 0; i < cardList.length; i++) {
            if (card.getColor() == cardList[i].getColor() && card.getValue() == cardList[i].getValue() + 1) {
                isSuccess = true;
                cardList[i] = card;
                if (card.getValue() == 5) {
                    token.incToken();
                }
            }
        }

        return isSuccess;
    }

    public Card[] getCardList() {
        return cardList;
    }
}
