import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Customer student test
 * 
 * @author armanbabazadeh
 *
 */
class CustomerTestStudent {

	/**
	 * Test getName
	 */
	@Test
	void testGetName() {
		Customer customer = new Customer("John Smith", 25);
		assertEquals("John Smith", customer.getName());
	}

	/**
	 * Test setName
	 */
	@Test
	void testSetName() {
		Customer customer = new Customer("John Smith", 25);
		customer.setName("Jane Doe");
		assertEquals("Jane Doe", customer.getName());
	}

	/**
	 * Test getAge
	 */
	@Test
	void testGetAge() {
		Customer customer = new Customer("John Smith", 25);
		assertEquals(25, customer.getAge());
	}

	/**
	 * test SetAge
	 */
	@Test
	void testSetAge() {
		Customer customer = new Customer("John Smith", 25);
		customer.setAge(30);
		assertEquals(30, customer.getAge());
	}

	/**
	 * this will test the toStrinf method
	 */
	@Test
	void testToString() {
		Customer customer = new Customer("John Smith", 25);
		assertEquals("John Smith 25", customer.toString());
	}

	/**
	 * This will test my copy constructor to make sure it works
	 */
	@Test
	void testCopyConstructor() {
		Customer customer1 = new Customer("John Smith", 25); // creating two customer objects
		Customer customer2 = new Customer(customer1);
		assertEquals(customer1.getName(), customer2.getName());
		assertEquals(customer1.getAge(), customer2.getAge());
	}

}
