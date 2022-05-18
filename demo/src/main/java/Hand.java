/*
 * Hand.java                                                   18/05/2022
 * IUT Rodez, INFO 1, SAE Hanabi
 */

package java;


/**
 * TODO le commentaire
 *
 */

public class Hand {


    /** Positions des cartes dans la main du joueur */
    private int[] cardPositions;

    /**
     * Main des joueurs dont les cartes sont tirées aléatoirement
     * au début de la partie
     */
    private Card[] hand = {



        return this; // bouchon
    }

    /**
     * Ajoute la carte qui vient d'être pioché dans la main
     * (TODO voir si on peut pas fusionner cette méthode avec Deck.drawCard())
     * @param toAdd  carte à ajouter
     * @return  la carte à ajouter
     */
    public Hand addCard(Card toAdd) {

        return toAdd; // bouchon
    }

    /**
     * récupère la position d'une carte dans la main du joueur
     * @param toGet  la carte dont on veut la position
     * @return  la position de la carte
     */
    public int getPosition(Card toGet) {

        return toGet.cardPositions[0]; // bouchon
    }

    public Hand changePositions(Card swap1, Card swap2) {

        return this; // bouchon
    }





}


