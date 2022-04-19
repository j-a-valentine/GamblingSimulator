package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import simulator.Card;

class CardTests {
	@Test
	void testGetValue() {
		Card three = new Card (3, "3");
		int value = three.getValue();
		assertEquals(3, value, 0);
	}
	@Test
	void testGetDisplay() {
		Card three = new Card (3, "3");
		assertTrue(three.getDisplay().equals("3"));
	}
}