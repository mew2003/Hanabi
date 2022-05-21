package Test;

import org.junit.jupiter.api.Test;
import principal.Token;

import static org.junit.jupiter.api.Assertions.*;

class TokenTest extends Token {

    /**
     * Définition d'un jeton
     *
     * @param tokenNumber Nombre de jetons
     */
    public TokenTest(int tokenNumber) {
        super(tokenNumber);
    }

    @Test
    void testGetTokenNumber() {
    }

    @Test
    void testSetTokenNumber() {
    }
}