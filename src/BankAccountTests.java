import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BankAccountTests {

	@Test
	void testGetBalanceEmpty() {
		BankAccount b = new BankAccount();
		double balance = b.getBalance();
		assertEquals(0, balance, 0);
	}


	@Test
	void successfulDepositEmptyAmount() {
		BankAccount account = new BankAccount();

		double initialBalance = account.getBalance();
		boolean successfulDepositStatus = account.deposit(0);
		double finalBalance = account.getBalance();

		assertFalse(successfulDepositStatus);
		assertEquals(initialBalance, finalBalance, 0);
	}

	@Test
	void successfulDepositSingleAmount() {
		BankAccount account = new BankAccount();

		double initialBalance = account.getBalance();
		boolean successfulDepositStatus = account.deposit(17.3);
		double finalBalance = account.getBalance();

		assertTrue(successfulDepositStatus);
		assertEquals(initialBalance + 17.3, finalBalance, 0);
	}
}
