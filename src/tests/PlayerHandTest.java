package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import principal.Card;
import principal.Deck;
import principal.Discard;
import principal.PlacedCard;
import principal.PlayerHand;
import principal.Token;


class PlayerHandTest {

	@Test
	void testPlayerHand() {
	    Deck deck = new Deck();
            assertThrows(IllegalArgumentException.class, () -> new PlayerHand("joueur1", 1, deck));
            assertThrows(IllegalArgumentException.class, () -> new PlayerHand("joueur2", 6, deck));
            assertDoesNotThrow(() -> new PlayerHand("joueur1", 2, deck));
            assertDoesNotThrow(() -> new PlayerHand("joueur2", 5, deck));
	}

	@Test
	void testGetName() {
	    Deck deck = new Deck();
	    PlayerHand hand = new PlayerHand("joueur1", 5, deck);
	    assertEquals("joueur1", hand.getName());
	}

	@Test
	void testGetHand() {
	    Deck deck = new Deck();
            PlayerHand playerHand = new PlayerHand("joueur1", 5, deck);
            assertNotNull(playerHand.getHand());
	}

	@Test
	void testDrawACard() {
	    Deck deck = new Deck();
	    PlayerHand playerHand = new PlayerHand("joueur1", 5, deck);
	    assertThrows(IllegalArgumentException.class, () -> playerHand.drawACard(6, deck));
	}

	@Test
	void testPlayACard() {
	    Deck deck = new Deck();
	    Discard discard = new Discard();
            PlayerHand playerHand = new PlayerHand("joueur1", 5, deck);
            Token blueToken = new Token(8);
            Token redToken = new Token(0);
            PlacedCard placedCard = new PlacedCard();
	    assertThrows(IllegalArgumentException.class, () -> playerHand.playACard(-1, deck, redToken, blueToken, placedCard, discard));
	    playerHand.getHand()[1] = new Card("red", 1); 
	    assertDoesNotThrow(() -> playerHand.playACard(1, deck, redToken, blueToken, placedCard, discard));
	    playerHand.getHand()[1] = new Card("blue", 4); 
	    assertDoesNotThrow(() -> playerHand.playACard(1, deck, redToken, blueToken, placedCard, discard));
	}

	@Test
	void testGiveAHintPlayerHandTokenString() {
	    Deck deck = new Deck();
	    PlayerHand playerHand = new PlayerHand("joueur1", 5, deck);
	    Token blueToken = new Token(8);
	    assertThrows(IllegalArgumentException.class, () -> playerHand.giveAHint(playerHand, blueToken, "rouge"));
	    playerHand.getHand()[1] = new Card("red", 3);
	    assertDoesNotThrow(() -> playerHand.giveAHint(playerHand, blueToken, "red"));
	    for (int i = 0; i < 4; i++) {
	        playerHand.getHand()[i] = new Card("blue", 3);
	    }
	    assertDoesNotThrow(() -> playerHand.giveAHint(playerHand, blueToken, "red"));
	}

	@Test
	void testGiveAHintPlayerHandTokenInt() {
	    Deck deck = new Deck();
            PlayerHand playerHand = new PlayerHand("joueur1", 5, deck);
            Token blueToken = new Token(8);
            assertThrows(IllegalArgumentException.class, () -> playerHand.giveAHint(playerHand, blueToken, 6));
            playerHand.getHand()[1] = new Card("red", 1);
            assertDoesNotThrow(() -> playerHand.giveAHint(playerHand, blueToken, 1));
            for (int i = 0; i < 4; i++) {
                playerHand.getHand()[i] = new Card("blue", 3);
            }
            assertDoesNotThrow(() -> playerHand.giveAHint(playerHand, blueToken, 1));
	}

	@Test
	void testDiscardACard() {
	    Deck deck = new Deck();
            PlayerHand playerHand = new PlayerHand("joueur1", 5, deck);
            Token blueToken = new Token(8);
            Discard discard = new Discard();
            assertDoesNotThrow(() -> playerHand.discardACard(1, deck, blueToken, discard));
	}

	@Test
	void testToString() {
	    Deck deck = new Deck();
	    PlayerHand playerHand = new PlayerHand("joueur1", 5, deck);
	    assertDoesNotThrow(() -> playerHand.toString());
	    for (int i = 0; i < 4; i++) {
                playerHand.getHand()[i] = new Card("blue", 3);
            }
	    assertEquals("Le joueur joueur1 à la main [blue, 3] [blue, 3] [blue, 3] [blue, 3] " , playerHand.toString());
	}

}
