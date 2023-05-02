import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Junit test for Order class
 * 
 * @author armanbabazadeh
 *
 */
public class OrderTestStudent {

	private Order A1, A2, A3; // A meaning Arman

	@Before
	public void setUp() throws Exception {
		A1 = new Order(8, Day.MONDAY, new Customer("Arman", 22)); // setup using my name and my brother for fun
		A2 = new Order(12, Day.SATURDAY, new Customer("Amir", 45));
		A3 = new Order(10, Day.SUNDAY, new Customer("Armeen", 21));
	}

	@After
	public void tearDown() throws Exception {
		A1 = A2 = A3 = null;
	}

	/**
	 * Test addNewBeverage method
	 * 
	 * @throws NullPointerException
	 */
	@Test
	public void testAddNewBeverage() throws NullPointerException {
		// Order A1
		assertTrue(A1.getTotalItems() == 0);
		A1.addNewBeverage("Blacked Coffee", Size.SMALL, false, false); // go through each one and check for assert true
		assertTrue(A1.getBeverage(0).getType().equals(Type.COFFEE));
		A1.addNewBeverage("Vanilla Coffee", Size.SMALL);
		assertTrue(A1.getBeverage(1).getType().equals(Type.ALCOHOL));
		A1.addNewBeverage("Burn Vodka", Size.MEDIUM, 1, false);
		assertTrue(A1.getBeverage(2).getType().equals(Type.SMOOTHIE));
		assertTrue(A1.getTotalItems() == 3);

		// Order A2
		assertTrue(A2.getTotalItems() == 0);
		A2.addNewBeverage("Burn Coffee", Size.MEDIUM, 4, true); // do the same for here
		assertTrue(A2.getBeverage(0).getType().equals(Type.SMOOTHIE));
		A2.addNewBeverage("Vanilla Coffee", Size.SMALL);
		assertTrue(A2.getBeverage(1).getType().equals(Type.ALCOHOL));
		A2.addNewBeverage("Blacked Coffee", Size.MEDIUM, true, false);
		assertTrue(A2.getBeverage(2).getType().equals(Type.COFFEE));
		assertTrue(A2.getTotalItems() == 3);

		// Order A3
		assertTrue(A3.getTotalItems() == 0);
		A3.addNewBeverage("MilkShake", Size.LARGE, 2, true); // check here as well for each assert true in the Junit
																// test
		assertTrue(A3.getBeverage(0).getType().equals(Type.SMOOTHIE));
		A3.addNewBeverage("Milkshake", Size.MEDIUM);
		A3.addNewBeverage("Hot chocolate", Size.LARGE, true, false);
		assertTrue(A3.getBeverage(2).getType().equals(Type.COFFEE));
		assertTrue(A3.getTotalItems() == 3);
	}

	/**
	 * checks if it is weekend
	 */
	@Test
	public void testisWeekend() {

		assertFalse(A1.isWeekend()); // go through each A1,A2,A3
		assertTrue(A2.isWeekend());
		assertTrue(A3.isWeekend());

	}

	/**
	 * Checks calcOrderTotal for each one
	 */
	@Test
	public void testCalcOrderTotal() {
		A1.addNewBeverage("Black Coffee", Size.SMALL, false, false); // add new beverages
		A1.addNewBeverage("Vodka", Size.SMALL);
		assertEquals(4.0, A1.calcOrderTotal(), .01); // check for assert equals
		A2.addNewBeverage("Vanila", Size.MEDIUM, true, false); // add

	}

	/**
	 * check findNumBeveType method
	 */
	@Test
	public void testFindNumOfBeveType() {

		A1.addNewBeverage("Blacked Coffee", Size.SMALL, false, false); // As you go through check for each one and add
																		// each new beverage
		A1.addNewBeverage("Frappe", Size.SMALL);
		A1.addNewBeverage("Espresso", Size.MEDIUM, 1, false);
		A1.addNewBeverage("Caremel", Size.LARGE, true, true);
		assertEquals(2, A1.findNumOfBeveType(Type.COFFEE)); // check if each asserts true
		assertEquals(1, A1.findNumOfBeveType(Type.SMOOTHIE));
		assertEquals(1, A1.findNumOfBeveType(Type.ALCOHOL));

		A2.addNewBeverage("Blacked Coffee", Size.MEDIUM, true, false); // add new beverage
		A2.addNewBeverage("Mohito", Size.SMALL);
		assertEquals(0, A2.findNumOfBeveType(Type.SMOOTHIE)); // check if assert equals

		assertEquals(0, A3.findNumOfBeveType(Type.SMOOTHIE));

	}

	/**
	 * This test if we getBeverage
	 */
	@Test
	public void testGetBeverage() {
		Coffee Coffee = new Coffee("Blacked Coffee", Size.SMALL, false, false); // create three beverages objects
		Alcohol alcohol = new Alcohol("Vodka", Size.SMALL, false);
		Smoothie smoothie = new Smoothie("Detox", Size.LARGE, 1, false);

		A1.addNewBeverage("Blacked Coffee", Size.SMALL, false, false); // adds each to new beverage
		A1.addNewBeverage("Vodka", Size.SMALL);
		A1.addNewBeverage("Burn", Size.MEDIUM, 1, false);
		assertTrue(A1.getBeverage(0).equals(Coffee)); // checks if each asserts true
		assertTrue(A1.getBeverage(1).equals(alcohol));
		assertFalse(A1.getBeverage(2).equals(smoothie));

	}

	/**
	 * this checks my toString method which I had a lot of difficulty
	 */
	@Test
	public void testToString() {

		A1.addNewBeverage("Blacked Coffee", Size.SMALL, false, false); // add two new beverages
		A1.addNewBeverage("Expresso", Size.LARGE);

		assertTrue(A1.toString().contains(String.valueOf(A1.getOrderNo()))); // check if each contains
		assertTrue(A1.toString().contains(A1.getCustomer().getName()));
		assertTrue(A1.toString().contains(A1.getBeverage(0).getSize().toString()));
		assertTrue(A1.toString().contains(A1.getBeverage(0).getBevName()));

		assertTrue(A1.toString().contains(A1.getBeverage(1).getSize().toString()));
		assertTrue(A1.toString().contains(A1.getBeverage(1).getBevName()));
		assertTrue(A1.toString().contains(String.valueOf(A1.getBeverage(1).calcPrice())));

		assertTrue(A1.toString().contains(String.valueOf(A1.calcOrderTotal())));

	}
}