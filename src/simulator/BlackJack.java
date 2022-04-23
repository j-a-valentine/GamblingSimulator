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
		this.playerHand.hit();
		this.playerHand.hit();
		this.CPUHand.hit();
		this.CPUHand.hit();
	}
	
	public void stand() {
		this.isDone = true;
		
	}
	

	
	public int play() {
		
		 while(this.isDone == false && this.playerHand.evaluate() < 21) {
			 String input = this.playPrompt();
			 if(input.equalsIgnoreCase("H")) {
				 this.playerHit();
			 }
			 else if(input.equalsIgnoreCase("S")){
				 this.stand();
			 }
			 else {
				 System.out.println("Invalid input");
			 }	 
		 }
		 return this.evaluateWinner();
	}
	
	
	private void CPUPlay() {
		while(this.CPUHand.evaluate() < this.playerHand.evaluate()) {
			this.CPUHit();
		}
	}
	
	public int evaluateWinner() {
		if(this.playerHand.evaluate() > 21) {
			return -1;
		}
		else if(this.playerHand.evaluate() < 21) {
			CPUPlay();
			if(this.playerHand.evaluate() > CPUHand.evaluate()) {
				return 1;
			}
			else if(this.playerHand.evaluate() < CPUHand.evaluate()) {
				return -1;
			}
			if(this.playerHand.evaluate() == CPUHand.evaluate()) {
				return 0;
			}
		}
	}
	
	
	private String playPrompt() {
		 Scanner reader = new Scanner(System.in);
		 System.out.println(this.playerHand);
		 System.out.println(this.CPUHand);
		 System.out.println("Press H to hit, and S to stand.");
		 String input = reader.nextLine();
		 return input;
	}
	
	
	public int playerHit() {
		Card newCard = this.deck.drawCard();
		this.playerHand.addCard(newCard);
		int sum = this.playerHand.evaluate();
		return sum;
	}
	
	public int CPUHit() {
		Card newCard = this.deck.drawCard();
		this.CPUHand.addCard(newCard);
		int sum = this.CPUHand.evaluate();
		return sum;
	}
	
	public int getPlayerHandSize() {
		return this.playerHand.getSize();
	}
	
	public int getCPUHandSize() {
		return this.CPUHand.getSize();
	}

	
	
}
