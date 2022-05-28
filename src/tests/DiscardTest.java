package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import principal.Discard;

class DiscardTest {

	@Test
	void testGetCardList() {

		Discard discard = new Discard();
		
		assertEquals(50, discard.getCardList().length);
		
		
	}

	@Test
	void testToString() {
		
		Discard discard = new Discard();
		
		assertEquals("", discard.toString());
		
	}

}
