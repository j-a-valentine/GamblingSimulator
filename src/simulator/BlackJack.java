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
		 while(this.isDone == false) {
			 String input = this.playPrompt();
			 if(input.equalsIgnoreCase("H")) {
				 if(this.playerHand.hit()>21) {
					 this.stand();
				 }
			 }
			 else if(input.equalsIgnoreCase("S")){
				 this.stand();
			 }
			 else {
				 System.out.println("Invalid input");
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
