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
	
	public boolean deposit(double amount) {
		if (amount > 0) {
		this.balance += amount;
		}
		return amount > 0;
		}
	
	public boolean withdraw(double amount) {
		if (amount > 0) {
			if (amount > this.balance) {
				return false;
			}
		this.balance -= amount;
		}
		return amount > 0;
		}
}
