/*
 * Card.java                18/05/2022
 * Info1
 */

package principal;

/** 
 * TODO Commenter la responsabilit� de cette class
 * @author 
 *
 */
public class Card {

    /** Couleur des cartes */
    private final String color;

    /** Num�ro des cartes  */
    private final int value;

    /**
     * Définition d'une carte avec couleur et num�ro
     * @param color Couleur de la carte
     * @param value Num�ro de la carte
     * @throws IllegalArgumentException si la couleur ou le num�ro de la carte
     */
    public Card(String color, int value) {
        boolean isCorrect = false;
        final String[] POSSIBLE_COLOR = {
                "red", "blue", "pink", "yellow", "white"
        };
        final int[] POSSIBLE_VALUE = {
                0, 1, 2, 3, 4, 5
        };

        for (String s : POSSIBLE_COLOR) {
            if (s.equals(color)) {
                isCorrect = true;
                break;
            }
        }
        if (!isCorrect) {
            throw new IllegalArgumentException("La couleur n'existe pas");
        }

        isCorrect = false;

        // Liste des valeurs possibles (0 permet de ne pas avoir de valeur)
        for (int j : POSSIBLE_VALUE) {
            if (j == value) {
                isCorrect = true;
                break;
            }
        }
        if (!isCorrect) {
            throw new IllegalArgumentException("La valeur n'existe pas");
        }
        this.color = color;
        this.value = value;
    }

    /** @return la couleur de la carte */
    public String getColor() {
        return color;
    }

    /** @return le num�ro de la carte */
    public int getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "[" + color + ", " + value + "]";
    }
}
