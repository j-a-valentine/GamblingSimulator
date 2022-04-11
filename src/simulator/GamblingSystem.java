package simulator;

import java.util.Scanner;

public class GamblingSystem {

	private Roulette roulette;
	private BankAccount account;

	public GamblingSystem() {
		this.roulette = new Roulette();
		this.account = new BankAccount();
	}

	public void runRoulette() throws InterruptedException {
		Scanner reader = new Scanner(System.in);

		boolean isDone = false;

		while (!isDone) {
			System.out.println("b: Place a bet");
			System.out.println("d: Display the bets");
			System.out.println("p: Play the game");

			String userInput = reader.nextLine();
			if (userInput.equalsIgnoreCase("b")) {
				this.makeRouletteBet();
			} else if (userInput.equalsIgnoreCase("d")) {
				this.roulette.displayBets();
			} else if (userInput.equalsIgnoreCase("p")) {
				double winningAmount = this.roulette.play();
				winningAmount = (Math.round(winningAmount * 100)) / 100;
				account.deposit(winningAmount);
				isDone = true;
			} else {
				System.out.println("Invalid Input");
			}
		}

	}

	public void makeRouletteBet() {

		String[] input = promptRouletteBet();

		double betAmount = 0;
		
		if (isValidRouletteBet(input) == 1) {
			betAmount = Double.parseDouble(input[0]);
			int betLocation = Integer.parseInt(input[1]);
			placeRouletteBet(betAmount, betLocation);
		}
		else if(isValidRouletteBet(input) == 2){
			betAmount = Double.parseDouble(input[0]);
			char betLocation = input[1].charAt(0);
			placeRouletteBet(betAmount, betLocation);
		}
		else {
			System.out.println("Bet Not Valid");
		}

	}

	public void placeRouletteBet(double betAmount, int betLocation) {

		if (Character.isLetter(betLocation)) {
			if (this.roulette.addBet(betAmount, (char) betLocation)) {
				account.withdraw(betAmount);
			}
		} else {
			this.roulette.addBet(betAmount, betLocation);
			if (this.roulette.addBet(betAmount, (char) betLocation)) {
				account.withdraw(betAmount);
			}
		}

	}

	private int isValidRouletteBet(String[] userBet) {
		try {
			Double.parseDouble(userBet[0]);
		} catch (NumberFormatException e) {
			return 0;
		}
		try {
			Integer.parseInt(userBet[1]);
			return 1;
		} catch (NumberFormatException e) {
			if ((userBet[1].charAt(0) == 'e' || userBet[1].charAt(0) == 'o') && userBet[1].length()==1) {
				return 2;
			}
			return 0;
		}
	}

	private String[] promptRouletteBet() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please place your bet in the form amount pocketnumber/e/o");
		return reader.nextLine().split(" ");
	}

}
