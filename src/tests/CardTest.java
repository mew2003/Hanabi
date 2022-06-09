package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import principal.Card;

class CardTest {

	Card[] jeuxDeTests =  {
			new Card("red", 3),
			new Card("yellow", 0),
			new Card("pink", 5)
	};

	@Test
	void testCard() {
		
		assertThrows(IllegalArgumentException.class, () -> new Card("a", 0));
		assertThrows(IllegalArgumentException.class, () -> new Card("red", 7));
		assertDoesNotThrow(() -> new Card("red", 3));
		
	}

	@Test
	void testGetColor() {
		
		assertEquals("red", jeuxDeTests[0].getColor());
		assertEquals("yellow", jeuxDeTests[1].getColor());
		assertEquals("pink", jeuxDeTests[2].getColor());
		
	}

	@Test
	void testGetValue() {

		assertEquals(3, jeuxDeTests[0].getValue());
		assertEquals(0, jeuxDeTests[1].getValue());
		assertEquals(5, jeuxDeTests[2].getValue());
		
	}

	@Test
	void testToString() {

		assertEquals("[red, 3]", jeuxDeTests[0].toString());
		assertEquals("[yellow, 0]", jeuxDeTests[1].toString());
		assertEquals("[pink, 5]", jeuxDeTests[2].toString());
		
	}

}
