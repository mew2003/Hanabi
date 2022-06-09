/*
 * Token.java                18/05/2022
 * Info1
 */

package principal;

/** 
 * TODO Commenter la responsabilit� de cette class
 * @author 
 *
 */
public class Token {

    /** Nombre de token */
    private int value;

    /**
     * D�finition d'un jeton
     * @param value Nombre de token
     * @throws IllegalArgumentException si le nombre de tokens est invalide (inf�rieur � 0 ou sup�rieur � 8)
     */
    public Token(int value) {
        if (value < 0 || value > 8) {
            throw new IllegalArgumentException("Valeur impossible");
        }
        this.value = value;
    }

    /**
     * Incr�mente le nombre de tokens par 1
     * @return La nouvelle valeur du token
     * @throws IllegalArgumentException si le nombre de tokens est invalide (sup�rieur � 8)
     */
    public int incToken() {
        ++value;
        if (value > 8) {
            throw new IllegalArgumentException("Valeur impossible");
        }
        return value;
    }

    /**
     * D�cr�mente le nombre de tokens par 1
     * @return La nouvelle valeur du token
     * @throws IllegalArgumentException si le nombre de tokens est invalide (inf�rieur � 0)
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
