package simulator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GamblingSystemTest {
	
	
	
	@Test
	void testUserGoodRouletteBetNumber() {
		GamblingSystem system = new GamblingSystem();
		String [] input = {"10.23", "7"};
		int ret = system.isValidRouletteBet(input);
		assertEquals(1,ret, 0);
	}
	
	@Test
	void testUserGoodRouletteBetOdd() {
		GamblingSystem system = new GamblingSystem();
		String [] input = {"12.43", "o"};
		int ret = system.isValidRouletteBet(input);
		assertEquals(2,ret, 0);
	}
	
	@Test
	void testUserGoodRouletteBetEven() {
		GamblingSystem system = new GamblingSystem();
		String [] input = {"100.08", "e"};
		int ret = system.isValidRouletteBet(input);
		assertEquals(2,ret, 0);
	}
	
	@Test
	void testUserBadRouletteBetAmount() {
		GamblingSystem system = new GamblingSystem();
		String [] input = {"badinput", "7"};
		int ret = system.isValidRouletteBet(input);
		assertEquals(0,ret, 0);
	}
	
	@Test
	void testUserBadRouletteBetLocation() {
		GamblingSystem system = new GamblingSystem();
		String [] input = {"10", "badinput"};
		int ret = system.isValidRouletteBet(input);
		assertEquals(0,ret, 0);
	}

	@Test
	void testGamblingWithdraw() {
		GamblingSystem system = new GamblingSystem();
			
		system.placeRouletteBet(3, 1);
		double endingAccount = system.getFinalBalance();
		
		assertEquals(997, endingAccount, 0.025);
	}
	
	@Test
	void testOverdrawnAccount() {
		GamblingSystem system = new GamblingSystem();
					
		boolean playDecision = system.placeRouletteBet(1100, 1);
		
		assertFalse(playDecision);
	}
	
	


}
