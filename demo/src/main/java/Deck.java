/**
 * Deck.java                18/05/2022
 * Info1
 */

public class Deck {

    //Nombre de carte max dans le deck
    private final int MAX_CARDS = 50;

    //Liste des cartes du jeu
    private Card[] cards =
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
                    new Card("white", 5),
            };

    // Pour éviter l'instanciation inutile
    private Deck() {}
    public Card drawCard(Card card) {
        return card; //stub
    }
}
