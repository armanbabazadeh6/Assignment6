/*
 * Class: CMSC203
 * Instructor: Prof.Grinberg
 * Description: Beverage class which is the super class of the three beverages
 * Due: 5/1/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Arman Babazadeh
*/

import java.util.Objects;

/**
 * Beverage class which is the Superclass for the subclasses smoothie, coffee,
 * alchohol
 * 
 * @author armanbabazadeh
 *
 */
public abstract class Beverage {

	protected String bevName; // some instance variables
	protected Type type;
	protected Size size;
	private final double BASE_PRICE = 2.0; // Set constants for both basePrice and SizePrice
	private final double SIZE_PRICE = 1.0;

	public Beverage(String bevName, Type type, Size size) { // constructor using this keyword
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}

	public String getBevName() { // Mulitple getter and setter methods
		return bevName;
	}

	public void setBevName(String bevName) {
		this.bevName = bevName;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public double getBASE_PRICE() {
		return BASE_PRICE;
	}

	public double getSIZE_PRICE() {
		return SIZE_PRICE;
	}

	/**
	 * Extra price for medium and large drinks
	 * 
	 * @return
	 */
	public double addSizePrice() { // This is the for sizePrice extra price if drinks are medium or large

		double sizePrice = 0;

		if (size == Size.MEDIUM || size == Size.LARGE) {

			sizePrice = SIZE_PRICE + BASE_PRICE;

		}
		return sizePrice;

	}

	/**
	 * toString method which returns name and size
	 */
	@Override
	public String toString() { // overrided toString method
		return bevName + " " + size;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bevName, size, type);
	}

	@Override
	public boolean equals(Object anotherBev) {
		Beverage beverage = (Beverage) anotherBev;
		if (bevName.equals(beverage.getBevName()) && size.equals(beverage.getSize())
				&& type.equals(beverage.getType())) {
			return true;
		}

		return false;

	}

	public abstract double calcPrice();

}
