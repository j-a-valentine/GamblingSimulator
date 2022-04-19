package simulator;

import java.util.LinkedList;

public class BlackJack {

	private Deck deck;
	
	public BlackJack() {
		this.deck = new Deck();
		this.deck.generateCards();
		this.deck.shuffleCards();
		
	}

	
	
}
