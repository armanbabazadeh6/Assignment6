/*
 * Class: CMSC203 
 * Instructor: Prof.Grinberg
 * Description: This is the Order class which implements the OrderInterface
 * Due: 5/1/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Arman Babazadeh
*/

import java.util.ArrayList;
import java.util.Random;

/**
 * Order class which creats order and has the beverage ArrayList
 * 
 * @author armanbabazadeh
 *
 */
public class Order implements OrderInterface, Comparable<Order> {
	private int orderNumber; // Five instance varibles in which are delcared here
	private int orderTime;
	private Day orderDay;
	private Customer customer;
	private ArrayList<Beverage> beverages; // ArrayList for beverages

	/**
	 * Constructor for Order class
	 * 
	 * @param orderTime
	 * @param orderDay
	 * @param cust
	 */
	public Order(int orderTime, Day orderDay, Customer cust) {
		this.orderDay = orderDay;
		this.orderTime = orderTime;
		this.customer = cust;
		this.orderNumber = generateOrder(); // Set order number = to the random generated order method below
		beverages = new ArrayList<>();
	}

	/**
	 * Getter methods
	 * 
	 * @return
	 */
	public int getOrderNo() {
		return orderNumber;
	}

	public int getOrderTime() {
		return orderTime;
	}

	public Day getOrderDay() {
		return orderDay;
	}

	public Customer getCustomer() {
		return new Customer(customer);
	}

	public ArrayList<Beverage> getBeverages() {
		return beverages;
	}

	public Day getDay() {
		return orderDay;
	}

	/**
	 * Compareto method comparing to order o
	 * 
	 * @param Order o
	 */
	@Override
	public int compareTo(Order o) {
		if (orderNumber > o.orderNumber) { // if orderNumber is greater than orderNumber o
			return 1; // return 1
		} else if (orderNumber < o.orderNumber) { // less than
			return -1; // return -1
		} else {
			return 0; // if not either return 0
		}
	}

	/**
	 * Check if it is weekend
	 */
	@Override
	public boolean isWeekend() {
		if (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) { // if orderDay is either saturday or sunday than it is
																	// weekend
			return true; // return true if not return false
		}
		return false;
	}

	/**
	 * return beverage get itemNo
	 * 
	 * @param itemNo
	 */
	@Override
	public Beverage getBeverage(int itemNo) {
		// TODO Auto-generated method stub
		return beverages.get(itemNo); // this returns beverage at a specified index
	}

	/**
	 * return beveragelist size
	 * 
	 * @return
	 */
	public int getTotalItems() {
		return beverages.size(); // returns the size of the beverageList
	}

	/**
	 * This adds a new beverage for Coffee
	 * 
	 * @param String bevName, Size size, boolean extraShot, boolean extraSyrup
	 */
	@Override
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup); // create Coffee object and implement bevName
																			// size etc
		beverages.add(coffee); // add to arrayList

	}

	/**
	 * This adds a new beverage for Alcohol
	 * 
	 * @param String bevName, Size size
	 */
	@Override
	public void addNewBeverage(String bevName, Size size) {
		boolean isWeekend = false;
		if (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY) { // if orderDay is either saturday or sunday
			isWeekend = true; // set weekend equal to true
		}
		Alcohol alchohol = new Alcohol(bevName, size, isWeekend); // create new alcohol object and set bevName etc
		beverages.add(alchohol); // add to ArrayList

	}

	/**
	 * This adds a new beverage for Smoothie
	 * 
	 * @param String bevName, Size size, int numOfFruits, boolean addProtein
	 * 
	 */

	@Override
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein) {
		Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtein); // create smoothie object add bevName
																					// Etc
		beverages.add(smoothie); // add to arrayList

	}

	/**
	 * This calculates orderTotal
	 * 
	 */
	@Override
	public double calcOrderTotal() {
		double orderTot = 0;
		for (Beverage bev : beverages) { // go through beverage with enhanced for loop
			orderTot += bev.calcPrice(); // orderTot is equal to bev call calcPrice
		}
		return orderTot; // return
	}

	/**
	 * finds number of Beverage type
	 * 
	 * @param Type type
	 */
	@Override
	public int findNumOfBeveType(Type type) {
		int numberOfBev = 0;
		for (Beverage bev : beverages) {
			if (bev.getType() == type) {
				numberOfBev++;
			}
		}
		return numberOfBev;
	}

	/**
	 * ToString method returning information
	 */
	public String toString() {
		return orderDay.toString() + "," + orderTime + customer.toString() + "," + "The Order Number: " + orderNumber
				+ beverages.toString() + calcOrderTotal(); // Bunch of information being returned like customer
															// orderNumber etc
	}

	/**
	 * This generates a random number between 10000 and 90000
	 * 
	 * @return
	 */
	public int generateOrder() {
		Random rand = new Random(); // make a Random object
		int random_int = rand.nextInt(90000 - 10000) + 10000; // create min and max
		return random_int; // return values
	}

}
