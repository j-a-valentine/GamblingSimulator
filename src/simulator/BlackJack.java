package simulator;

import java.util.LinkedList;

public class BlackJack {

	private Deck deck;
	private Hand playerHand;
	private Hand CPUHand;
	
	public BlackJack() {
		this.deck = new Deck();
		this.deck.generateCards();
		this.deck.shuffleCards();
		this.playerHand = new Hand(false);
		this.CPUHand = new Hand(true);
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
