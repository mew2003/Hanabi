/*
 * Card.java                18/05/2022
 * Info1
 */

package principal;

/**
 * TODO le commentaire
 *
 */
public class Card {

    /** Couleur des cartes */
    private String color;

    private String[] possibleColor = {
        "red", "blue", "pink", "yellow", "white"
    };

    // Liste des valeurs possibles (0 permet de ne pas avoir de valeur)
    private int[] possibleValue = {
        0, 1, 2, 3, 4, 5
    };

    /** Numéro des cartes  */
    private int value;

    /**
     * Définition d'une carte avec couleur et numéro
     * @param color Couleur de la carte
     * @param value Numéro de la carte
     * @throws IllegalArgumentException si la couleur ou le numéro de la carte
     */
    public Card(String color, int value) {
        boolean isCorrect = false;

        for (int i = 0; i < possibleColor.length; i++) {
            if (possibleColor[i].equals(color)) {
                isCorrect = true;
            }
        }
        if (!isCorrect) {
            throw new IllegalArgumentException("La couleur n'existe pas");
        }

        isCorrect = false;
        for (int i = 0; i < possibleValue.length; i++) {
            if (possibleValue[i] == value) {
                isCorrect = true;
            }
        }
        if (!isCorrect) {
            throw new IllegalArgumentException("La valeur n'existe pas");
        }
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

    @Override
    public String toString() {
        return "[" + color + ", " + value + "]";
    }
}
