package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import principal.PlacedCard;
import principal.Token;
import principal.Card;

class PlacedCardTest {

	@Test
	void testPlaceACard() {

		PlacedCard placedCard = new PlacedCard();
		
		assertTrue(placedCard.placeACard(new Card("red", 1), new Token(0)));
		assertFalse(placedCard.placeACard(new Card("red", 1), new Token(0)));
		assertFalse(placedCard.placeACard(new Card("blue", 0), new Token(0)));
		for (int i = 2; i < 6; i++) {
			placedCard.placeACard(new Card("red", i), new Token(0));
		}
		//Ce test provoque l'exception de la classe principal.Card, l'exception est crée par raison de sécurité
		assertThrows(IllegalArgumentException.class, () -> placedCard.placeACard(new Card("red", 6), new Token(0)));
	}

	@Test
	void testGetCardList() {
		
		PlacedCard placedCard = new PlacedCard();
		Card[] jeuxDeTest = {
				new Card("red", 0),
		        new Card("blue", 0),
		        new Card("pink", 0),
		        new Card("yellow", 0),
		        new Card("white", 0)
		};
		
		for (int i = 0; i < 5; i++) {
			assertEquals(jeuxDeTest[i].getColor(), placedCard.getCardList()[i].getColor());
			assertEquals(jeuxDeTest[i].getValue(), placedCard.getCardList()[i].getValue());
		}
		for (int i = 1; i < 6; i++) {
			placedCard.placeACard(new Card("red", i), new Token(0));
		}
		jeuxDeTest[0] = new Card("red", 5);
		assertEquals(jeuxDeTest[0].getColor(), placedCard.getCardList()[0].getColor());
		assertEquals(jeuxDeTest[0].getValue(), placedCard.getCardList()[0].getValue());
		
	}

	@Test
	void testToString() {

		PlacedCard placedCard = new PlacedCard();
		String attendu = "[red, 0] [blue, 0] [pink, 0] [yellow, 0] [white, 0] ";
		
		assertEquals(attendu, placedCard.toString());
	}

}
