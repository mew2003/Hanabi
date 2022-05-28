/*
 * Deck.java                18/05/2022
 * Info1
 */

package principal;

import java.util.Random;

/**
 * TODO le commentaire
 *
 */
public class Deck {

    /** Nombre de cartes restantes dans le deck */
    private int nbCards = 50;

    //Liste des cartes du jeu
    private final Card[] cards =
            {
                    new Card("red", 1),
                    new Card("red", 1),
                    new Card("red", 1),
                    new Card("red", 2),
                    new Card("red", 2),
                    new Card("red", 3),
                    new Card("red", 3),
                    new Card("red", 4),
                    new Card("red", 4),
                    new Card("red", 5),
                    new Card("blue", 1),
                    new Card("blue", 1),
                    new Card("blue", 1),
                    new Card("blue", 2),
                    new Card("blue", 2),
                    new Card("blue", 3),
                    new Card("blue", 3),
                    new Card("blue", 4),
                    new Card("blue", 4),
                    new Card("blue", 5),
                    new Card("pink", 1),
                    new Card("pink", 1),
                    new Card("pink", 1),
                    new Card("pink", 2),
                    new Card("pink", 2),
                    new Card("pink", 3),
                    new Card("pink", 3),
                    new Card("pink", 4),
                    new Card("pink", 4),
                    new Card("pink", 5),
                    new Card("yellow", 1),
                    new Card("yellow", 1),
                    new Card("yellow", 1),
                    new Card("yellow", 2),
                    new Card("yellow", 2),
                    new Card("yellow", 3),
                    new Card("yellow", 3),
                    new Card("yellow", 4),
                    new Card("yellow", 4),
                    new Card("yellow", 5),
                    new Card("white", 1),
                    new Card("white", 1),
                    new Card("white", 1),
                    new Card("white", 2),
                    new Card("white", 2),
                    new Card("white", 3),
                    new Card("white", 3),
                    new Card("white", 4),
                    new Card("white", 4),
                    new Card("white", 5)
            };

    // Pour éviter l'instanciation inutile
    public Deck() {}

    // Permet d'obtenir le paquet de cartes
    public Card getCards() {
        Random random = new Random();
        int result = random.nextInt(nbCards);
        Card selectedCard = cards[result];
        cards[result] = cards[nbCards - 1];
        nbCards--;
        return selectedCard;
    }

    public int getNbCards() {
        return nbCards;
    }
}

