package simulator;

import java.util.LinkedList;

public class Deck {
	private LinkedList<Card> cards;

	public Deck() {
		this.cards = new LinkedList<Card>();
	}

	public void generateCards() {
		this.fillNumericalCards();
		this.fillFaceCards();
	}

	private void fillNumericalCards() {
		int val = 2;
		for (int x = 0; x < 32; x++) {
			if (x % 4 == 0 && x != 0) {
				val++;
			}
			this.cards.add(new Card(val, " " + val));
		}
	}

	private void fillFaceCards() {
		String[] displays = { "10", " J", " Q", " K", " A" };
		for (String s : displays) {
			for (int x = 0; x < 4; x++) {
				this.cards.add(new Card(10, s));
			}
		}
	}
	
	public void shuffleCards() {
		LinkedList<Card> temp = new LinkedList<Card>();
		while(this.cards.size() > 0) {
			int randomIndex = (int)(Math.random()*this.cards.size());
			temp.add(this.cards.get(randomIndex));
			this.cards.remove(randomIndex);
		}
		this.cards = temp;
	}
	
	public int getSize() {
		return this.cards.size();
	}
	public String toString() {
		String output = "";
		for(Card c : this.cards) {
			output += c.getDisplay();
		}
		return output;
	}

}
