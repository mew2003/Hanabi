package principal;

public class Token {

    /** Nombre de token */
    public int value;

    /**
     * Définition d'un jeton
     * @param value Nombre de token
     * @throws IllegalArgumentException si le nombre de token est invalide (inférieur à 0 ou supérieur à 8)
     */
    public Token(int value) {
        if (value < 0 || value > 8) {
            throw new IllegalArgumentException("Valeur impossible");
        }
        this.value = value;
    }

    /**
     * Incrémente le nombre de token par 1
     * @return La nouvelle valeur du token
     * @throws IllegalArgumentException si le nombre de token est invalide (supérieur à 8)
     */
    public int incToken() {
        ++value;
        if (value > 8) {
            throw new IllegalArgumentException("Valeur impossible");
        }
        return value;
    }

    /**
     * Décrémente le nombre de token par 1
     * @return La nouvelle valeur du token
     * @throws IllegalArgumentException si le nombre de token est invalide (inférieur à 0)
     */
    public int decToken() {
        --value;
        if (value < 0) {
            throw new IllegalArgumentException("Valeur impossible");
        }
        return value;
    }

    public int getValue() {
        return value;
    }
}
