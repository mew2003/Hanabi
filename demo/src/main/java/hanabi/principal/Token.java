/*
 * Token.java                18/05/2022
 * Info1
 */

package principal;

/**
 * TODO le commentaire
 *
 */
public class Token {

    /** Nombre de jetons */
    private int tokenNumber;

    /**
     * Définition d'un jeton
     * @param tokenNumber Nombre de jetons
     */
    public Token(int tokenNumber) {
        this.tokenNumber = tokenNumber;
    }

    /** return le nombre de jetons */
    public int getTokenNumber() {
        return tokenNumber;
    }

    /** permet de définir le nombre de jetons */
    public Token setTokenNumber(int tokenNumber) {
        this.tokenNumber = tokenNumber;
        return this;
    }
}
