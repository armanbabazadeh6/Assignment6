import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * This is student test for Smoothie beverage
 * 
 * @author armanbabazadeh
 *
 */
public class SmoothieTestStudent {

	Smoothie Smoothie1, Smoothie2, Smoothie3, Smoothie4;

	@Before
	public void setUp() throws Exception {
		Smoothie1 = new Smoothie("Smoothie1Name", Size.SMALL, 1, false);
		Smoothie2 = new Smoothie("Smoothie2NAme", Size.MEDIUM, 2, true);
		Smoothie3 = new Smoothie("Smoothie3NAme", Size.LARGE, 3, true);
		Smoothie4 = new Smoothie("Smoothie4NAme", Size.SMALL, 4, false);

	}

	@After
	public void tearDown() throws Exception {
		Smoothie1 = Smoothie2 = Smoothie3 = Smoothie4 = null;
	}

	/**
	 * Checks calcPrice
	 */
	@Test
	public void testCalPrice() {

		assertEquals(2.5, Smoothie1.calcPrice(), .01); // using asset equals to check each one
		assertEquals(5.5, Smoothie2.calcPrice(), .01);
		assertEquals(7, Smoothie3.calcPrice(), .01);
		assertEquals(4, Smoothie4.calcPrice(), .01);

	}

	/**
	 * testBasePrice
	 */
	@Test
	public void testGetBasePrice() {
		assertEquals(2.0, Smoothie1.getBASE_PRICE(), .01); // using assertEquals to check each individual smoothie
		assertEquals(2.0, Smoothie2.getBASE_PRICE(), .01);
		assertEquals(2, Smoothie3.getBASE_PRICE(), .01);
		assertEquals(2, Smoothie4.getBASE_PRICE(), .01);
	}

	/**
	 * checks the equals method
	 */
	@Test
	public void testEquals() {
		Smoothie Smoothie1 = new Smoothie("Strawberry Banana Smoothie", Size.MEDIUM, 2, true);
		Smoothie Smoothie2 = new Smoothie("Strawberry Banana Smoothie", Size.MEDIUM, 2, true);
		Smoothie Smoothie3 = new Smoothie("Blueberry Smoothie", Size.SMALL, 3, false);

		assertTrue(Smoothie1.equals(Smoothie2));
		assertFalse(Smoothie1.equals(Smoothie3));
	}

	/**
	 * Test to string method
	 */
	@Test
	public void testToString() {

		assertTrue(Smoothie1.toString().contains(Smoothie1.getBevName()));
		assertTrue(Smoothie1.toString().contains(String.valueOf(Smoothie1.calcPrice())));
		assertTrue(Smoothie1.toString().contains(Smoothie1.getSize().toString()));
		assertTrue(Smoothie1.toString().contains(String.valueOf(Smoothie1.getNumOfFruits())));

	}

}
