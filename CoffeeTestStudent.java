import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CoffeeTestStudent {

	Coffee c1, c2, c3, c4;

	@Before
	public void setUp() throws Exception {
		c1 = new Coffee("c1Name", Size.SMALL, false, false);
		c2 = new Coffee("c2NAme", Size.MEDIUM, true, true);
		c3 = new Coffee("c3NAme", Size.LARGE, false, true);
		c4 = new Coffee("c4NAme", Size.SMALL, true, false);
	}

	@After
	public void tearDown() throws Exception {
		c1 = c2 = c3 = c4 = null;
	}

	/**
	 * This will test getBasePrice
	 */
	@Test
	public void testGetBasePrice() {
		assertEquals(2.0, c1.getBASE_PRICE(), .01); // checks with assertEquals
		assertEquals(2.0, c2.getBASE_PRICE(), .01);
		assertEquals(2, c3.getBASE_PRICE(), .01);
		assertEquals(2, c4.getBASE_PRICE(), .01);
	}

	/**
	 * Checks calcPrice
	 */
	@Test
	public void testCalcPrice() {
		assertEquals(2.0, c1.calcPrice(), .01); // uses asset equals and go throughs
		assertEquals(4.0, c2.calcPrice(), .01);
		assertEquals(4.5, c3.calcPrice(), .01);
		assertEquals(2.5, c4.calcPrice(), .01);
	}

	/**
	 * Checks my toString
	 */
	@Test
	public void testToString() { // make sure it contains each one
		assertTrue(c1.toString().contains(c1.getBevName()));
		assertTrue(c1.toString().contains(String.valueOf(c1.calcPrice())));
		assertTrue(c1.toString().contains(c1.getSize().toString()));
		assertTrue(!c1.toString().contains("+ Extra shot"));
		assertTrue(!c1.toString().contains("+ Extra syrup"));

		assertTrue(c2.toString().contains(c2.getBevName()));
		assertTrue(c2.toString().contains(String.valueOf(c2.calcPrice())));
		assertTrue(c2.toString().contains(c2.getSize().toString()));
		assertTrue(c2.toString().contains("+ Extra shot"));
		assertTrue(c2.toString().contains("+ Extra syrup"));

		assertTrue(c3.toString().contains(c3.getBevName()));
		assertTrue(c3.toString().contains(String.valueOf(c3.calcPrice())));
		assertTrue(c3.toString().contains(c3.getSize().toString()));
		assertTrue(!c3.toString().contains("+ Extra shot"));
		assertTrue(c3.toString().contains("+ Extra syrup"));

		assertTrue(c4.toString().contains(c4.getBevName()));
		assertTrue(c4.toString().contains(String.valueOf(c4.calcPrice())));
		assertTrue(c4.toString().contains(c4.getSize().toString()));
		assertTrue(c4.toString().contains("+ Extra shot"));
		assertTrue(!c4.toString().contains("+ Extra syrup"));
	}

	/**
	 * This test my equals method
	 */

	@Test
	public void testEquals() {
		Coffee c1Copy = new Coffee("c1Name", Size.SMALL, false, false);
		assertTrue(c1.equals(c1Copy)); // c1.equals the c1 copy check
	}

}
