import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PocketTests {

	@Test
	void testGetBetEmpty() {
		Pocket p = new Pocket(5);
		assertEquals(0, p.getBet(), 0);
	}

}
