package ressources;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import boardgame.Resource;
import boardgame.resources.Rock;

public class RockTest {

	@Test
	public void getValueTest() {
		Resource r = new Rock(5);
		assertEquals(5, r.getValue());
	}

	@Test
	public void equalsTest() {
		Resource r = new Rock(5);
		Resource r2 = new Rock(5);
		Resource r3 = new Rock(6);
		assertTrue(r.equals(r2));
		assertFalse(r.equals(r3));
	}

	public static junit.framework.Test suite() {
		return new junit.framework.JUnit4TestAdapter(RockTest.class);
	}
}