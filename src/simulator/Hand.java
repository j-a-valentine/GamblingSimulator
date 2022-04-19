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

	public int evaluate() {
		int value = 0;
		for (Card c : this.cards) {
			value += c.getValue();
		}
		int aceCount = this.numAces();
		while (value > 21 && aceCount > 0) {
			aceCount--;
			value -= 10;
		}
		if (value > 21) {
			value = -1;
		}
		return value;
	}

	private int numAces() {
		int aceCount = 0;
		for (Card c : this.cards) {
			if (c.getDisplay().equals("A")) {
				aceCount++;
			}
		}
		return aceCount;
	}

	public String toString() {
		String output = "";
		for (int x = 0; x < this.cards.size(); x++) {
			if (this.hideFirst && x == 0) {
				output += "* ";
			} else {
				output += this.cards.get(x).getDisplay() + " ";
			}
		}
		return output;
	}
}
