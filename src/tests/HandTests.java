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

}
