import static org.junit.jupiter.api.Assertions.*;

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
}
