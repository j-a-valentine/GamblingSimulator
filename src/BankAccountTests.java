import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankAccountTests {

	@Test
	void testGetBalanceEmpty() {
		BankAccount b = new BankAccount();
		double balance = b.getBalance();
		assertEquals(0, balance, 0);
	}

}
