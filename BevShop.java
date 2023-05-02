/*
 * Class: CMSC203 
 * Instructor: Prof.Grinberg
 * Description: This is class for BevShop where all information about the actual beverageShop will be implemented
 * Due: 5/1/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Arman Babazadeh
*/

import java.util.ArrayList;
import java.util.Collections;

/**
 * BevShop class that implements BevShopInterface
 * 
 * @author armanbabazadeh
 *
 */
public class BevShop implements BevShopInterface {
	private int numOfAlcholicOrder;
	private int currentOrder;
	private ArrayList<Order> listOfOrder;

	public BevShop() {
		this.listOfOrder = new ArrayList<>();
	}

	/**
	 * Checks if time is valid
	 * 
	 * @param int time
	 */
	public boolean isValidTime(int time) {
		if (time >= MIN_TIME && time <= MAX_TIME) { // if time is between min and max
			return true; // set true
		}
		return false; // else set false
	}

	/**
	 * Getter for maxNumFruits
	 */
	@Override
	public int getMaxNumOfFruits() {
		return MAX_FRUIT;
	}

	/**
	 * Getter for getMinAge
	 */
	@Override
	public int getMinAgeForAlcohol() {
		return MIN_AGE_FOR_ALCOHOL;
	}

	/**
	 * Checks if numOfFruits is greater than Max fruits allowed
	 * 
	 * @param int numOfFruits
	 */
	@Override
	public boolean isMaxFruit(int numOfFruits) {
		if (numOfFruits > MAX_FRUIT) { // if num is less than the max
			return true; // return true
		}
		return false;
	}

	/**
	 * Getter for getMaxOrderForAlcohol
	 */
	@Override
	public int getMaxOrderForAlcohol() {

		return MAX_ORDER_FOR_ALCOHOL;
	}

	/**
	 * Checks if someone is allowed for more drinks
	 */
	@Override
	public boolean isEligibleForMore() {
		if (numOfAlcholicOrder < MAX_ORDER_FOR_ALCOHOL) { // if numOfAlcohol is less than max order
			return true; // return true
		}
		return false;
	}

	/**
	 * Getter for numOfAlcohol
	 */
	@Override
	public int getNumOfAlcoholDrink() {

		return numOfAlcholicOrder;
	}

	/**
	 * check if age is valid
	 * 
	 * @param int age
	 */
	@Override
	public boolean isValidAge(int age) {
		if (age > MIN_AGE_FOR_ALCOHOL) { // if age is greater than minAge
			return true; // return true and age is Valid for alcohol
		}
		return false;
	}

	/**
	 * Start new order method
	 * 
	 * @param int    time
	 * @param Day    day
	 * @param String customerName
	 * @param int    customerAge
	 */
	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) {

		Customer customer = new Customer(customerName, customerAge); // Create customer object and sets customerName and
																		// age
		Order order = new Order(time, day, customer); // create order object which sets time day and customer
		listOfOrder.add(order); // add to the listOfOrder ArrayList
		currentOrder = listOfOrder.indexOf(order);
		numOfAlcholicOrder = 0; // set numOfAlcohol order to 0

	}

	/**
	 * This will process Coffee Order
	 * 
	 * @param bevName
	 * @param Size    size
	 * @param boolean extraShot
	 * @param boolean extraSyrup
	 */
	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) {
		listOfOrder.get(currentOrder).addNewBeverage(bevName, size, extraShot, extraSyrup); // get currentOrder and
																							// addNewBeverage and list

	}

	/**
	 * Process alcohol order method
	 * 
	 * @param bevName
	 * @param Size    size
	 */
	@Override
	public void processAlcoholOrder(String bevName, Size size) {
		listOfOrder.get(currentOrder).addNewBeverage(bevName, size); // add new beverage for alcohol
		numOfAlcholicOrder++;

	}

	/**
	 * Process smoothie beverage
	 * 
	 * @param bevName
	 * @param Size        size
	 * @param numOfFruits
	 * @param addProtein
	 */
	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) {
		listOfOrder.get(currentOrder).addNewBeverage(bevName, size, numOfFruits, addProtein); // add new beverage for
																								// smoothie

	}

	/**
	 * This method findsOrder number
	 * 
	 * @param orderNo
	 */
	@Override
	public int findOrder(int orderNo) {
		for (int i = 0; i < listOfOrder.size(); i++) { // go through ArrayList size
			if (listOfOrder.get(i).getOrderNo() == orderNo) { // if orderNo is equal to orderNo
				return i; // return the index
			}
		}
		return -1; // else return -1
	}

	/**
	 * This method getsTotal order price
	 * 
	 * @param orderNo
	 */
	@Override
	public double totalOrderPrice(int orderNo) {
		double totalOrderPrice = 0;

		for (Order orders : listOfOrder) { // go through listOfOrder using enhanced for loop

			if (orders.getOrderNo() == orderNo) { // if equal to one another
				for (Beverage b : orders.getBeverages()) { // go through beverage in orders using enhanced for loop
					totalOrderPrice += b.calcPrice(); // totalOrderPrice += beverage calcPrice
				}
			}

		}

		return totalOrderPrice; // return total
	}

	/**
	 * Total amount for monthly sale
	 */
	@Override
	public double totalMonthlySale() {
		double totalMonthlySale = 0;

		for (Order orders : listOfOrder) { // go through using enhanced for loop
			for (Beverage b : orders.getBeverages()) {
				totalMonthlySale += b.calcPrice(); // add all prices together for all beverages
			}
		}
		return totalMonthlySale; // return monhtlySale
	}

	/**
	 * return listOfOrder size
	 */
	@Override
	public int totalNumOfMonthlyOrders() {

		return listOfOrder.size();
	}

	/**
	 * return listOfOrder currentOrder
	 */
	@Override
	public Order getCurrentOrder() {

		return listOfOrder.get(currentOrder);
	}

	/**
	 * return current index
	 */
	@Override
	public Order getOrderAtIndex(int index) {

		return listOfOrder.get(index);
	}

	/**
	 * This method uses selection sort to sort ArrayList
	 */
	@Override
	public void sortOrders() {
		for (int i = 0; i < listOfOrder.size() - 1; i++) { // go through
			int sort = i;
			for (int j = i + 1; j < listOfOrder.size(); j++) {
				if (getOrderAtIndex(j).getOrderNo() < getOrderAtIndex(sort).getOrderNo()) { // if is less than
					sort = j; // set sort equal to j
				}
			}
			if (sort != i) { // if sort is not equal to j
				Collections.swap(listOfOrder, i, sort); // use collections swap
			}
		}
	}

	/**
	 * To string method returning information
	 */
	public String toString() {
		String info = "";
		for (Order order : listOfOrder) { // use enhanced for loop go through listOfOrder
			info += order.toString() + "\n";
		}
		info += "Total Monthly Sale: " + totalMonthlySale(); // add total monthly sale to concatinated info
		return info;
	}

}
