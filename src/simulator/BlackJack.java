package simulator;

import java.util.LinkedList;

public class BlackJack {

	private LinkedList<Card> deck;
	
	public BlackJack() {
		this.deck = new LinkedList<Card>();
		this.fillDeck();
	}

	public void fillDeck() {
		this.fillNumericalCards();
		this.fillFaceCards();
		this.shuffleDeck();
	}
	
	private void fillNumericalCards() {
		int val = 2;
		for(int x = 0; x < 36; x++) {
			if(x % 4 == 0) {
				val ++;
			}
			this.deck.add(val, " "+val);
		}
	}
	
	private void fillFaceCards() {
		String [] displays = {"10", " J", " Q", " K", " A"};
		for(String s : displays) {
			for(int  x = 0; x < 4; x++) {
				this.deck.add(10, s);
			}
		}
	}
	
	private void shuffleDeck() {
		LinkedList<Card> tempDeck = new LinkedList<Card>();
		while(this.deck.length > 0) {
			int randomIndex = (int)Math.random()*this.deck.length();
			tempDeck.add(this.deck.get(randomIndex));
			this.deck.remove(randomIndex);
		}
		this.deck = tempDeck;
	}
	
	public int getDeckSize() {
		return this.deck.length();
	}
	
}
