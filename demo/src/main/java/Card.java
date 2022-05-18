/*
 * Card.java                18/05/2022
 * Info1
 */

package example;


/**
 * TODO le commentaire
 *
 */
public class Card {

    /** Couleur des cartes */
    private String color;

    /** Numéro des cartes  */
    private int value;

    /**
     * Définition d'une carte avec couleur et numéro
     * @param color Couleur de la carte
     * @param value Numéro de la carte
     */
    public Card(String color, int value) {
        //TODO : Complete this method
        this.color = color;
        this.value = value;
    }

    /** return la couleur de la carte */
    public String getColor() {
        return color;
    }

    /** return le numéro de la carte */
    public int getValue() {
        return value;
    }
}
