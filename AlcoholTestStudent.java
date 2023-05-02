import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * AlcoholTestStudent
 * 
 * @author armanbabazadeh
 *
 */
public class AlcoholTestStudent {

	Alcohol a1, a2, a3, a4;

	@Before
	public void setUp() throws Exception {
		a1 = new Alcohol("a1Name", Size.SMALL, false);
		a2 = new Alcohol("a2NAme", Size.MEDIUM, true);
		a3 = new Alcohol("a3NAme", Size.LARGE, false);
		a4 = new Alcohol("a4NAme", Size.SMALL, true);
	}

	@After
	public void tearDown() throws Exception {
		a1 = a2 = a3 = a4 = null;
	}

	/**
	 * This test calcPrice
	 */
	@Test
	public void testCalPrice() {

		assertEquals(2, a1.calcPrice(), .01); // go through each one using assertEquals
		assertEquals(3.6, a2.calcPrice(), .01);
		assertEquals(4, a3.calcPrice(), .01);
		assertEquals(2.6, a4.calcPrice(), .01);
	}

	/**
	 * This test my toString method going through each one
	 */
	@Test
	public void testToString() {
		assertTrue(a1.toString().contains(a1.getBevName())); // check to see if it contains
		assertTrue(a1.toString().contains(String.valueOf(a1.calcPrice())));
		assertTrue(a1.toString().contains(a1.getSize().toString()));
	}

	/**
	 * this test my equals method
	 */
	@Test
	public void testEquals() {
		Alcohol a5 = new Alcohol("a1Name", Size.SMALL, false); // check if it equals
		assertTrue(a1.equals(a5));
	}
}
