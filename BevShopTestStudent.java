import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

/**
 * This is test class for BevShop
 * 
 * @author armanbabazadeh
 *
 */
public class BevShopTestStudent {
	private BevShop bevShop;

	@Before
	public void setUp() {
		bevShop = new BevShop();
	}

	/**
	 * This test the valid times
	 */
	@Test
	public void testValidTime() {
		assertTrue(bevShop.isValidTime(8)); // I created times within and without
		assertTrue(bevShop.isValidTime(23));
		assertFalse(bevShop.isValidTime(2));
		assertFalse(bevShop.isValidTime(50));
	}

	/**
	 * This is to test if age is valid
	 */
	@Test
	public void testValidAge() {
		assertFalse(bevShop.isValidAge(20));
		assertTrue(bevShop.isValidAge(50));
	}

	/**
	 * This is to test the startNewOrder method
	 */
	@Test
	public void testStartNewOrder() {
		bevShop.startNewOrder(15, Day.MONDAY, "Arman", 55); // add new order
		assertEquals(15, bevShop.getCurrentOrder().getOrderTime()); // check each one to work
		assertEquals(Day.MONDAY, bevShop.getCurrentOrder().getOrderDay());
		assertEquals(15, bevShop.getCurrentOrder().getOrderTime());
		assertEquals("Arman", bevShop.getCurrentOrder().getCustomer().getName());
		assertEquals(55, bevShop.getCurrentOrder().getCustomer().getAge());
		assertEquals(0, bevShop.getNumOfAlcoholDrink());
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 0);

	}

	/**
	 * check the method testFindOrder
	 */
	@Test
	public void testFindOrder() {

		int orderNumber;
		bevShop.startNewOrder(84, Day.MONDAY, "Armeen", 15); // add to startNewOrder
		bevShop.processCoffeeOrder("Expresso", Size.SMALL, true, false); // process each
		bevShop.processCoffeeOrder("Cappuccino", Size.LARGE, false, false);
		bevShop.processSmoothieOrder("Late Night Boost", Size.LARGE, 4, true);

		orderNumber = bevShop.getCurrentOrder().getOrderNo(); // set
	}

	/**
	 * This test totalMonthlySale
	 */
	@Test
	public void testTotalMonthlySale() {
		bevShop.startNewOrder(150, Day.MONDAY, "Ahmad", 48); // start new order
		bevShop.processCoffeeOrder("Expresso", Size.SMALL, true, false); // process coffee
		bevShop.processCoffeeOrder("Latte", Size.LARGE, false, false);

	}

	/**
	 * This test process coffee order
	 */
	@Test
	public void testProcessCoffeeOrder() {
		Coffee Coffee;
		bevShop.startNewOrder(10, Day.MONDAY, "Amir", 75); // start new order
		bevShop.processCoffeeOrder("americano", Size.SMALL, true, false);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 1);

		Coffee = (Coffee) bevShop.getCurrentOrder().getBeverage(0);
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBevName().equals("americano")); // check each one
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(Size.SMALL));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(Type.COFFEE));
	}

	/**
	 * This is to check alcohol process
	 */
	@Test
	public void testProcessAlcoholOrder() {
		bevShop.startNewOrder(8, Day.MONDAY, "Arman", 55); // start new order

		bevShop.processAlcoholOrder("Vodka", Size.LARGE);
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 1);
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getBevName().equals("Vodka")); // check if each asserts true
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getSize().equals(Size.LARGE));
		assertTrue(bevShop.getCurrentOrder().getBeverage(0).getType().equals(Type.ALCOHOL));
		assertTrue(bevShop.isEligibleForMore());
		bevShop.processAlcoholOrder("Spicy", Size.MEDIUM); // create medium drink
		assertTrue(bevShop.getCurrentOrder().getTotalItems() == 2);
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getBevName().equals("Spicy"));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getSize().equals(Size.MEDIUM));
		assertTrue(bevShop.getCurrentOrder().getBeverage(1).getType().equals(Type.ALCOHOL));
		assertTrue(bevShop.isEligibleForMore());
	}

	/**
	 * This test my toString method
	 */
	@Test
	public void testToString() {
		// Create some orders and add them to the bevShop
		bevShop.startNewOrder(1, Day.MONDAY, "Arman", 20);
		bevShop.processCoffeeOrder("Black Coffee", Size.SMALL, true, false);
		bevShop.processCoffeeOrder("Expresso", Size.LARGE, false, false);

		bevShop.startNewOrder(2, Day.TUESDAY, "Amir", 30);
		bevShop.processSmoothieOrder("Milkshake", Size.MEDIUM, 1, true);

		// Check that the toString() method returns the expected output
		String expected = "Order No. 1 | Customer: Arman | Day: MONDAY\n"
				+ "Beverage No. 1: Black Coffee | Size: SMALL | Extra Shot: true | Extra Cream: false\n"
				+ "Beverage No. 2: Expresso | Size: LARGE | Extra Shot: false | Extra Cream: false\n"
				+ "Order No. 2 | Customer: Amir | Day: TUESDAY\n"
				+ "Beverage No. 1: Milkshake | Size: MEDIUM | Fruits: 1 | Protein Powder: true\n"
				+ "Total Monthly Sale: " + bevShop.totalMonthlySale();

	}

	/**
	 * This checks my sortOrders method which I had a little trouble in
	 */
	@Test
	public void testSortOrders() {
		bevShop.startNewOrder(38, Day.MONDAY, "Arman", 47);
		bevShop.startNewOrder(47, Day.SUNDAY, "Ahmad", 37);
		bevShop.startNewOrder(81, Day.SATURDAY, "Amir", 28);

		bevShop.sortOrders();
		assertTrue(bevShop.getOrderAtIndex(0).getOrderNo() < bevShop.getOrderAtIndex(1).getOrderNo()); // check if less
																										// than
		assertTrue(bevShop.getOrderAtIndex(1).getOrderNo() < bevShop.getOrderAtIndex(2).getOrderNo()); // check if less
																										// than

	}

}
