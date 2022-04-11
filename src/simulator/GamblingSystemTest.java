package simulator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GamblingSystemTest {

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
