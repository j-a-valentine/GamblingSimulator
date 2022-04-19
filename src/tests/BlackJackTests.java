package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import simulator.BlackJack;

public class BlackJackTests {
	
	
	@Test
	void testPlayerHit() {
		BlackJack bj = new BlackJack();
		int h1 = bj.playerHit();
		int h2 = bj.playerHit();
		int h3 = bj.playerHit();
		int handSize = bj.getPlayerHandSize();
		
		assertTrue(h3 <= 21 || h3 == 0);
		assertEquals(3,handSize, 0);
	}
	
	@Test
	void testPlayerHitTwo() {
		BlackJack bj = new BlackJack();
		int h1 = bj.playerHit();
		int h2 = bj.playerHit();
		int handSize = bj.getPlayerHandSize();
		
		assertTrue(h2 <= 21);
		assertEquals(2, handSize, 0);
		
	}
	
	@Test
	void testCPUHit() {
		BlackJack bj = new BlackJack();
		int h1 = bj.CPUHit();
		int h2 = bj.CPUHit();
		int h3 = bj.CPUHit();
		int handSize = bj.getCPUHandSize();
		
		assertTrue(h3 <= 21 || h3 == 0);
		assertEquals(3,handSize, 0);
	}
	
	@Test
	void testCPUHitTwo() {
		BlackJack bj = new BlackJack();
		int h1 = bj.CPUHit();
		int h2 = bj.CPUHit();
		int handSize = bj.getCPUHandSize();
		
		assertTrue(h2 <= 21);
		assertEquals(2, handSize, 0);
		
	}
	
}
