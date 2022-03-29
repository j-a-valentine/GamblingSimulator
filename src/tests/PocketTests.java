package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import simulator.Main;
import simulator.BankAccount;
import simulator.Pocket;
import simulator.Roulette;

class PocketTests {

	@Test
	void testGetBetEmpty() {
		Pocket p = new Pocket(5);
		assertEquals(0, p.getBet(), 0);
	}
	
	@Test
	void testAddPositiveBet() {
		Pocket p = new Pocket(5);
		boolean addedBet = p.addBet(5.50);
		assertTrue(addedBet);
		assertEquals(5.50, p.getBet(), 0.001);
	}
	
	@Test
	void testAddNegativeBet() {
		Pocket p = new Pocket(5);
		boolean addedBet = p.addBet(-5.50);
		assertTrue(!addedBet);
		assertEquals(0, p.getBet(), 0);
	}
	
	@Test
	void testAddMultipleBets() {
		Pocket p = new Pocket(5);
		boolean addedBet = p.addBet(5.50);
		assertTrue(addedBet);
		assertEquals(5.50, p.getBet(), 0.001);
		
		boolean addedBet2 = p.addBet(12.50);
		assertTrue(addedBet2);
		assertEquals(18.00, p.getBet(), 0.001);
	}
	
	@Test
	void testClearBet() {
		Pocket p = new Pocket(5);
		boolean addedBet = p.addBet(5.50);
		assertTrue(addedBet);
		assertEquals(5.50, p.getBet(), 0.001);
		
		p.clearBet();
		assertEquals(0, p.getBet(), 0);
	}

}
