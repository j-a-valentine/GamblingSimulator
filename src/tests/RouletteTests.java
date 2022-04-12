package tests;
import static org.junit.jupiter.api.Assertions.*;

import simulator.Main;
import simulator.BankAccount;
import simulator.Pocket;
import simulator.Roulette;

import org.junit.jupiter.api.Test;

class RouletteTests {

	@Test
	void testAddBetNumber() {
		Roulette r = new Roulette();
		boolean result = r.addBet(100, 10);
		assertTrue(result);
	}
	@Test
	void testAddBetEven() {
		Roulette r = new Roulette();
		boolean result = r.addBet(100, 'e');
		assertTrue(result);
	}
	@Test
	void testAddBetOdd() {
		Roulette r = new Roulette();
		boolean result = r.addBet(100, 'o');
		assertTrue(result);
	}
	@Test
	void testAddBetInvalidAmount(){
		Roulette r = new Roulette();
		boolean result = r.addBet(-10, 'e');
		assertFalse(result);
	}
	@Test
	void testAddBetInvalidPocket(){
		Roulette r = new Roulette();
		boolean result = r.addBet(100, -1);
		assertFalse(result);
	}
	@Test
	void testNoBetPlay() throws InterruptedException{
		Roulette r = new Roulette();
		double winnings = r.play();
		assertEquals(0, winnings, 0);
	}
	@Test
	void testAllBetPlay() throws InterruptedException{
		Roulette r = new Roulette();
		r.addBet(18, 'e');
		r.addBet(18, 'o');
		r.addBet(1, 0);
		double winnings = r.play();
		assertEquals(36, winnings, .1);
	}
}
