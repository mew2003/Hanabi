/*
 * GameBoard.java                18/05/2022
 * Info1
 */

package principal;

public class GameBoard {

    private Card[] board = {
            new Card("white", 0),
            new Card("yellow", 0),
            new Card("blue", 0),
            new Card("pink", 0),
            new Card("red", 0)
    };

    /**
     * Plateau de jeu où les cartes seront placées quand elles seront jouées
     */
    public GameBoard() {


    }


    /**
     * ajoute une carte sur le plateau si elle est correcte
     * @param toAdd  la carte à ajouter
     * @return  la carte à ajouter
     * @throws IllegalArgumentException si la carte à ajouter a une valeur
     *                                 inférieure ou supérieure
     *                                 à la valeur attendue
     */
    public Card addCard(Card toAdd) {


        return toAdd;
    }

}
