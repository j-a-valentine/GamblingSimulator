package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import simulator.Card;
import simulator.Hand;

class HandTests {

	@Test
	void testAddCard() {
		Hand h = new Hand(false);
		int bsize = h.getSize();
		
		h.addCard(new Card(10, "10"));
		int asize = h.getSize();
		
		assertEquals(bsize+1, asize, 0);
		
	}
	@Test
	void testEvaluate() {
		Hand h = new Hand(false);
		h.addCard(new Card(10, "J"));
		h.addCard(new Card(11, "A"));
		int eval = h.evaluate();
		assertEquals(21, eval, 0);
	}
	@Test
	void testEvaluateOneAce() {
		Hand h = new Hand(false);
		h.addCard(new Card(10, "J"));
		h.addCard(new Card(11, "A"));
		h.addCard(new Card(5, "5"));
		int eval = h.evaluate();
		assertEquals(16, eval, 0);
	}
	@Test
	void testEvaluateTwoAce() {
		Hand h = new Hand(false);
		h.addCard(new Card(9, "9"));
		h.addCard(new Card(11, "A"));
		h.addCard(new Card(11, "A"));
		int eval = h.evaluate();
		assertEquals(21, eval, 0);
	}
	@Test
	void testEvaluateOver21() {
		Hand h = new Hand(false);
		h.addCard(new Card(10, "10"));
		h.addCard(new Card(10, "J"));
		h.addCard(new Card(11, "A"));
		h.addCard(new Card(4, "4"));
		int eval = h.evaluate();
		assertEquals(-1, eval, 0);
	}

}
