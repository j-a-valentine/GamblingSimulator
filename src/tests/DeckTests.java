package tests;

import org.junit.Test;

import simulator.Deck;

public class DeckTests {
	
	@Test
	void testGenerateCards() {
		Deck d = new Deck();
		int size = d.getDeckSize();
		assertEquals(52, size, 0);
	}
}
