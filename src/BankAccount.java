import java.util.ArrayList;

public class BankAccount {

	private double balance;
	private ArrayList<String> history;

	public BankAccount() {
		this.history = new ArrayList<String>();
		this.balance = 0;
	}
}
