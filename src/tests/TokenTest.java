package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import principal.Token;

class TokenTest {
    

	@Test
	void testToken() {
		assertThrows(IllegalArgumentException.class, () -> new Token(-1));
		assertThrows(IllegalArgumentException.class, () -> new Token(9));
		assertDoesNotThrow(() -> new Token(5));
	}

	@Test
	void testIncToken() {
	    Token blueToken = new Token(8);
	    Token redToken = new Token(0);
	    assertThrows(IllegalArgumentException.class, () -> blueToken.incToken());
	    assertDoesNotThrow(() -> redToken.incToken());
	}

	@Test
	void testDecToken() {
	    Token blueToken = new Token(8);
            Token redToken = new Token(0);
            assertThrows(IllegalArgumentException.class, () -> redToken.decToken());
            assertDoesNotThrow(() -> blueToken.decToken());
	}

	@Test
	void testGetValue() {
	    Token blueToken = new Token(8);
	    assertEquals(8, blueToken.getValue());
	}

}
