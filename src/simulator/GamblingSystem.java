package simulator;

import java.util.Scanner;

public class GamblingSystem {

	private Roulette roulette;

	public GamblingSystem() {
		this.roulette = new Roulette();
	}

	public void runRoulette() throws InterruptedException {
		Scanner reader = new Scanner(System.in);

		boolean isDone = false;

		while (!isDone) {
			System.out.println("b: Place a bet");
			System.out.println("d: Display the bets");
			System.out.println("p: Play the game");
			
			String userInput = reader.nextLine();
			if(userInput.equalsIgnoreCase("b")) {
				this.makeRouletteBet();
			}
			else if(userInput.equalsIgnoreCase("d")) {
				this.roulette.displayBets();
			}
			else if(userInput.equalsIgnoreCase("p")) {
				this.roulette.play();
			}
			else {
				System.out.println("Invalid Input");
			}
		}

	}

	public void makeRouletteBet() {

		String[] input = promptRouletteBet();

		double betAmount = 0;
		int betLocation = 0;
		if (isValidRouletteBet(input)) {
			betAmount = Double.parseDouble(input[0]);
			betLocation = Integer.parseInt(input[1]);

			placeRoulleteBet(betAmount, betLocation);
		} else {
			System.out.println("Bet Not Valid");
		}

	}

	public void placeRoulleteBet(double betAmount, int betLocation) {

		if (Character.isLetter(betLocation)) {
			this.roulette.addBet(betAmount, (char) betLocation);
		}
		this.roulette.addBet(betAmount, betLocation);

	}

	private boolean isValidRouletteBet(String[] userBet) {
		try {
			double betAmount = Double.parseDouble(userBet[0]);
			int betLocation = Integer.parseInt(userBet[1]);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	private String[] promptRouletteBet() {
		Scanner reader = new Scanner(System.in);
		System.out.println("Please place your bet in the form amount pocketnumber/e/o");
		return reader.nextLine().split(" ");
	}

}
