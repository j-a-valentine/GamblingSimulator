package simulator;

import java.util.LinkedList;

public class Hand {
	
	private LinkedList<Card> cards;
	private boolean hideFirst;
	
	public Hand(boolean hideFirst) {
		this.cards = new LinkedList<Card>();
		this.hideFirst = hideFirst;
	}
	
	public void addCard(Card c) {
		this.cards.add(c);
	}
	
	public int getSize() {
		return this.cards.size();
	}
	
	public String toString() {
		String output = "";
		for(Card c : this.cards) {
			output += c.getDisplay()+" ";
		}
		return output;
	}
}
