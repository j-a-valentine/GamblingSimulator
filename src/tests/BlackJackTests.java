package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import simulator.BlackJack;

public class BlackJackTests {
	
	
	@Test
	void generateDeck() {
		BlackJack bj = new BlackJack();
		int size = bj.getDeckSize();
		assertEquals(52, size, 0);
	}
}
