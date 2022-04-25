package simulator;

import java.util.LinkedList;
import java.util.Scanner;

public class BlackJack {

	private Deck deck;
	private Hand playerHand;
	private Hand CPUHand;
	private boolean isDone;

	public BlackJack() {
		this.deck = new Deck();
		this.deck.generateCards();
		this.deck.shuffleCards();
		this.playerHand = new Hand(false);
		this.CPUHand = new Hand(true);
		this.isDone = false;

	}

	private void initializeHands() {
		for (int x = 0; x < 2; x++) {
			this.playerHit();
			this.CPUHit();
		}
	}

	public void stand() {
		this.isDone = true;

	}

	public int play() {
		this.initializeHands();
		while (this.isDone == false && this.playerHand.evaluate() != -1 && this.playerHand.evaluate() != 21) {
			String input = this.playPrompt();
			if (input.equalsIgnoreCase("H")) {
				this.playerHit();
			} else if (input.equalsIgnoreCase("S")) {
				this.stand();
			} else {
				System.out.println("Invalid input");
			}
		}
		System.out.println("-----------");
		int retValue = this.evaluateWinner();
		this.displayPlayerHand();
		this.CPUHand.makeVisisble();
		this.displayCPUHand();
		System.out.println();
		return retValue;
	}

	private void CPUPlay() {
		while (this.CPUHand.evaluate() < this.playerHand.evaluate() && this.CPUHand.evaluate() != -1) {
			this.CPUHit();
		}
	}

	public int evaluateWinner() {
		if (this.playerHand.evaluate() == 21) {
			System.out.println("You have won");
			return 1;
		} else if (this.playerHand.evaluate() == -1) {
			System.out.println("You have lost");
			return -1;
		} else {
			this.CPUPlay();
			if (this.playerHand.evaluate() > this.CPUHand.evaluate()) {
				System.out.println("You have won");
				return 1;
			} else if (this.playerHand.evaluate() < this.CPUHand.evaluate()) {
				System.out.println("You have Lost");
				return -1;
			}
			System.out.println("You have tied");
			return 0;
		}
	}

	private String playPrompt() {
		Scanner reader = new Scanner(System.in);
		System.out.println();
		System.out.println("H: Hit");
		System.out.println("S: Stand");
		String input = reader.nextLine();
		return input;
	}

	public int playerHit() {
		Card newCard = this.deck.drawCard();
		this.playerHand.addCard(newCard);
		int sum = this.playerHand.evaluate();
		this.displayPlayerHand();
		return sum;
	}

	public int CPUHit() {
		Card newCard = this.deck.drawCard();
		this.CPUHand.addCard(newCard);
		int sum = this.CPUHand.evaluate();
		this.displayCPUHand();
		return sum;
	}

	public int getPlayerHandValue() {
		return this.playerHand.evaluate();
	}

	public int getCPUHandValue() {
		return this.CPUHand.evaluate();
	}

	public int getPlayerHandSize() {
		return this.playerHand.getSize();
	}

	public int getCPUHandSize() {
		return this.CPUHand.getSize();
	}

	public void displayPlayerHand() {
		System.out.println("Player Hand: " + this.playerHand);
	}

	public void displayCPUHand() {
		System.out.println("CPU Hand: " + this.CPUHand);
	}

}
