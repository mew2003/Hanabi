package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import principal.Deck;

class DeckTest {

	@Test
	void testGetCards() {

		Deck deck = new Deck();
		assertNotNull(deck.getCards());
		for (int i = 0; i < 49; i++) {
			deck.getCards();
		}
		assertThrows(IllegalArgumentException.class, () -> deck.getCards());
		
	}

	@Test
	void testGetNbCards() {

		Deck deck = new Deck();
		assertEquals(50, deck.getNbCards());
		deck.getCards();
		assertEquals(49, deck.getNbCards());
		for (int i = 0; i < 49; i++) {
			deck.getCards();
		}
		assertEquals(0, deck.getNbCards());
		assertEquals(0, deck.getNbCards());
		
	}

}
