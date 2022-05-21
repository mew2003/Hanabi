package Test;

import org.junit.jupiter.api.Test;
import principal.Card;

import static org.junit.jupiter.api.Assertions.*;

class CardTest extends Card {

    /**
     * Définition d'une carte avec couleur et numéro
     *
     * @param color Couleur de la carte
     * @param value Numéro de la carte
     */
    public CardTest(String color, int value) {
        super(color, value);
    }

    @Test
    void testGetColor() {
    }

    @Test
    void testGetValue() {
    }
}