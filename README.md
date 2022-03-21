# GamblingSimulator

Bank Account:

	variables
		double balance
		ArrayList<String> history

	public interface
		getBalance
		deposit
		withdraw
		getTransactionHistory

Roulette:
	
	variables
		ArrayList<Pocket> pockets

	public interface
		addBet (number or even/odd)
		displayBets
		play


Pocket
	
	variables
		int number
		double bet

	public interface
		getNumber
		getBet
		addBet
		clearBet