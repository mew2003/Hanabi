/*
 * Token.java                18/05/2022
 * Info1
 */

package principal;

/** 
 * Créer un jeton contenant une valeur
 * Sa valeur peut être incrémenté ou décrémenté 
 * @author Sébastien, Mewen, Maxime
 *
 */
public class Token {

    /** Nombre de token */
    public int value;

    /**
     * Définition d'un jeton
     * @param value Nombre de token
     * @throws IllegalArgumentException si le nombre de tokens 
     *         est invalide (inférieur à 0 ou sup�rieur à 8)
     */
    public Token(int value) {
        if (value < 0 || value > 8) {
            throw new IllegalArgumentException("Valeur impossible");
        }
        this.value = value;
    }

    /**
     * Incrémente le nombre de tokens par 1
     * @return La nouvelle valeur du token
     * @throws IllegalArgumentException si le nombre de tokens 
     *         est invalide (supérieur à 8)
     */
    public int incToken() {
        ++value;
        if (value > 8) {
            throw new IllegalArgumentException("Valeur impossible");
        }
        return value;
    }

    /**
     * Décrémente le nombre de tokens par 1
     * @return La nouvelle valeur du token
     * @throws IllegalArgumentException si le nombre de tokens 
     *         est invalide (inférieur � 0)
     */
    public int decToken() {
        --value;
        if (value < 0) {
            throw new IllegalArgumentException("Valeur impossible");
        }
        return value;
    }

    /** @return La valeur du jeton */
    public int getValue() {
        return value;
    }

	@Override
	public String toString() {
		return "" + value;
	}
}
