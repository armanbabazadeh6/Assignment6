/*
 * Class: CMSC203 
 * Instructor: Prof.Grinberg
 * Description: This is the sub class for beverage which is alcohol. Has all the information and pricing for Coffee
 * Due: 5/1/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Arman Babazadeh
*/

/**
 * Class for Coffee extend Beverage
 * 
 * @author armanbabazadeh
 *
 */
public class Coffee extends Beverage {

	private boolean extraShot; // 4 instance variables which are declared here
	private boolean extraSyrup;

	private final double SHOT_COST = .5;
	private final double SYRUP_COST = .5;

	/**
	 * Constructor for Coffee
	 * 
	 * @param bevName
	 * @param size
	 * @param extraShot
	 * @param extraSyrup
	 */
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup) { // Constructor

		super(bevName, Type.COFFEE, size);

		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;

	}

	/**
	 * Geter methods
	 * 
	 * @return
	 */
	public boolean getExtraShot() {
		return extraShot;
	}

	public boolean getExtraSyrup() {
		return extraSyrup;
	}

	/**
	 * Calculates price for the Coffee drink
	 */
	@Override
	public double calcPrice() {

		double calcPrice = super.getBASE_PRICE(); // calcPrice is equal call super BASe_PRICE

		if (super.getSize() == Size.MEDIUM) { // if large or medium add extra fee
			calcPrice += super.getSIZE_PRICE();
		} else if (super.getSize() == Size.LARGE) {
			calcPrice += 2 * super.getSIZE_PRICE();
		}

		if (extraShot) { // if extra shot add fee
			calcPrice += SHOT_COST;
		}
		if (extraSyrup) { // if extra syrup add fee
			calcPrice += SYRUP_COST;
		}

		return calcPrice;

	}

	/**
	 * To String method which returns string with information
	 */
	@Override
	public String toString() {

		String extra = "";

		if (extraShot) { // if extraShot add statement
			extra += " + Extra shot";
		}

		if (extraSyrup) { // if syrup add statement
			extra += " + Extra syrup";
		}

		return getBevName() + "," + getSize() + "," + extra + " $" + String.format("%.2f", calcPrice()); // return all
																											// information

	}

	/**
	 * equals method comparing anotherBev object
	 */
	@Override
	public boolean equals(Object anotherBev) {
		Coffee coffee = (Coffee) anotherBev;

		if (super.equals(anotherBev) && super.getBASE_PRICE() == coffee.getBASE_PRICE()
				&& getExtraShot() == (coffee.getExtraShot()) && getExtraSyrup() == (coffee.getExtraSyrup())) { // if all
																												// equals
																												// return
																												// true
			return true;
		}
		return false; // if not than return false
	}

}
