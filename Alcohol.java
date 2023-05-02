/*
 * Class: CMSC203 
 * Instructor: Prof.Grinberg
 * Description: This is the sub class for beverage which is alcohol. Has all the information and pricing for the Alcohol beverage
 * Due: 5/1/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Arman Babazadeh
*/

/**
 * This is the sub class of Beverage which is alcohol
 * 
 * @author armanbabazadeh
 *
 */
public class Alcohol extends Beverage {
	private boolean isWeekend; // Two instance varibles
	private final double WEEKEND_FEE = .6;

	public Alcohol(String bevName, Size size, boolean isWeekend) { // constructor
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}

	/**
	 * CalcPrice method which calculates price for alcohol beverage
	 */
	public double calcPrice() {
		double calcPrice = super.getBASE_PRICE();
		if (super.getSize() == Size.MEDIUM) { // if medium size
			calcPrice += super.getSIZE_PRICE(); // call size price
		} else if (super.getSize() == Size.LARGE) { // else if large size
			calcPrice += 2 * super.getSIZE_PRICE(); // call size price
		}
		if (isWeekend) { // if it is weekend
			calcPrice += WEEKEND_FEE; // add weekend fee
		}

		return calcPrice; // return

	}

	/**
	 * toString method
	 */
	public String toString() {

		String extra = "";

		if (isWeekend) { // if weekend add weekend beverage offered
			extra += " + Weekend Beverage Offered";
		}

		return getBevName() + "," + getSize() + "," + extra + " $" + String.format("%.2f", calcPrice()); // return
																											// string
																											// with all
																											// information
	}

	/**
	 * equals method
	 */
	@Override
	public boolean equals(Object anotherBev) {
		Alcohol alcohol = (Alcohol) anotherBev; // cast in Alcohol
		if (super.equals(anotherBev) && isWeekend() == alcohol.isWeekend) { // true
			return true; // return true
		}
		return false;
	}

	/**
	 * check weekend
	 * 
	 * @return
	 */
	public boolean isWeekend() {
		if (isWeekend) { // if true return true
			return true;
		}
		return false;
	}

}
