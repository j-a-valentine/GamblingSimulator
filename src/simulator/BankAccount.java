package simulator;
import java.util.ArrayList;

public class BankAccount {

	private double balance;
	private ArrayList<String> history;

	public BankAccount() {
		this.history = new ArrayList<String>();
		this.balance = 0;
	}

	public double getBalance() {
		return this.balance;
	}

	public String toString() {
		return this.getTransactionHistory();
	}

	public boolean deposit(double amount) {
		if (amount > 0) {
			this.balance += amount;
			writeEvent("deposit", amount);
		}
		return amount > 0;
	}

	public boolean withdraw(double amount) {
		if (amount > 0) {
			if (amount > this.balance) {
				return false;
			}
			this.balance -= amount;
			writeEvent("withdraw", amount);
		}
		return amount > 0;
	}

	public String getTransactionHistory() {
		String printHistory = "";
		for (String s : this.history) {
			printHistory += s + '\n';
		}
		return printHistory;
	}

	private void writeEvent(String transactionType, double amount) {
		String typePhrase = "";
		String verb = "";
		if (transactionType.equals("deposit")) {
			typePhrase = "Deposited";
			verb = "into";
		} else {
			typePhrase = "Withdrew";
			verb = "from";
		}
		this.history.add(this.history.size() + 1 + ") " + typePhrase + " $" + amount + " " + verb + " account. Balance: $" + this.balance);
	}
}
