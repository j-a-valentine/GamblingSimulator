package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import simulator.GamblingSystem;

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
	void testCorrectGamblingWithdraw() {
		GamblingSystem system = new GamblingSystem();
			
		system.deposit(100);
		system.placeRouletteBet(3, 1);
		double endingAccount = system.getFinalBalance();
		
		assertEquals(97, endingAccount, 0.025);
	}
	

	@Test
	void testNegativeGamblingWithdraw() {
		GamblingSystem system = new GamblingSystem();
			
		system.deposit(100);
		system.placeRouletteBet(-3, 1);
		double endingAccount = system.getFinalBalance();
		
		assertEquals(100, endingAccount, 0.025);
	}
	
	@Test
	void testOverdrawnAccount() {
		GamblingSystem system = new GamblingSystem();
					
		boolean playDecision = system.placeRouletteBet(1100, 1);
		
		assertFalse(playDecision);
	}
	
	@Test
	void testPlacingGoodRouletteBet() {
		GamblingSystem system = new GamblingSystem();
					
		system.deposit(100);
		boolean playDecision = system.placeRouletteBet(10, 1);
		
		assertEquals(90, system.getFinalBalance(), 0.025);
		assertTrue(playDecision);
	}
	
	@Test
	void testPlacingBadRouletteBet() {
		GamblingSystem system = new GamblingSystem();
					
		system.deposit(100);
		boolean playDecision = system.placeRouletteBet(1000, 1);
		
		assertEquals(100, system.getFinalBalance(), 0.025);
		assertFalse(playDecision);
	}
	
	@Test
	void testPlacingNegativeRouletteBet() {
		GamblingSystem system = new GamblingSystem();
					
		system.deposit(100);
		boolean playDecision = system.placeRouletteBet(-10, 1);
		
		assertEquals(100, system.getFinalBalance(), 0.025);
		assertFalse(playDecision);
	}
	
	@Test
	void testPlacingNegativebetLocation() {
		GamblingSystem system = new GamblingSystem();
					
		boolean playDecisionChar = system.placeRouletteBet(10, -1);
		boolean playDecisionInt = system.placeRouletteBet(10, -100);
		
		assertFalse(playDecisionChar);
		assertFalse(playDecisionInt);

	}


}
