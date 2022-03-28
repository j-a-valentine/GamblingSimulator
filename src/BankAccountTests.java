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
	
	@Test
	void withdrawNegativeAmount() {
		BankAccount account = new BankAccount();
		
		boolean withDrawFromEmpty = account.withdraw(-5);
		
		assertFalse(withDrawFromEmpty);
	}
	
	@Test
	void withdrawCorrectAmount() {
		BankAccount account = new BankAccount();
		
		account.deposit(10);
		boolean withdrawFromEmpty = account.withdraw(5);
		double endingBalance = account.getBalance();
		
		assertTrue(withdrawFromEmpty);
		assertEquals(5, endingBalance, 0.005);
	}
	
	@Test
	void withdrawEmptyAmount() {
		BankAccount account = new BankAccount();
		
		boolean overDrawn = account.withdraw(5);
		double endingBalance = account.getBalance();
		
		assertFalse(overDrawn);
	}
	
}
