package tests;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CardTests {
	void testGetValue() {
		Card three = new Card (3, '3');
		assertEquals(3, three.getValue(), .001);
	}
	void testGetDisplay() {
		Card three = new Card (3, '3');
		assertTrue('3', three.getDisplay());
	}
}