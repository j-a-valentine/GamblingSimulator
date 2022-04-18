package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import simulator.Deck;
import simulator.Card;

public class DeckTests {
	
	@Test
	void testGenerateCards() {
		Deck d = new Deck();
		d.generateCards();
		int size = d.getSize();
		assertEquals(52, size, 0);
	}
	@Test
	void testShuffleCards() {
		Deck d = new Deck();
		d.generateCards();
		String before = d.toString();
		int beforeSize = d.getSize();
		
		d.shuffleCards();
		String after = d.toString();
		int afterSize = d.getSize();
		
		assertFalse(before.equals(after));
		assertEquals(beforeSize, afterSize, 0);
		
	}
	@Test
	void testDrawCard() {
		Deck d = new Deck();
		for(int x = 0; x < d.getSize(); x++) {
			Card c = d.drawCard();
			assertTrue(c != null && c instanceof Card);
		}
		Card n = d.drawCard();
		assertTrue(n == null);
	}
}
