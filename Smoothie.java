/*
 * Class: CMSC203 
 * Instructor: Prof.Grinberg
 * Description: This is the sub class for beverage which is smoothie. This has all the information for the beverage smoothie
 * Due: 5/1/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Arman Babazadeh
*/

/**
 * Beverage class smoothie which extends Superclass Beverage
 * 
 * @author armanbabazadeh
 *
 */
public class Smoothie extends Beverage {

	private int numOfFruits; // 4 instance varibles declared with two with Protein cost and Fruit cost.
	private boolean addProtein;
	private final double PROTEIN_COST = 1.5;
	private final double FRUIT_COST = .50;

	/**
	 * Constructor for smoothie class
	 * 
	 * @param bevName
	 * @param size
	 * @param numOfFruits
	 * @param addProtein
	 */
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) { // Four parameters
		super(bevName, Type.SMOOTHIE, size);
		this.addProtein = addProtein;
		this.numOfFruits = numOfFruits;

	}

	/**
	 * Getter methods for instance varibles
	 * 
	 * @return
	 */
	public int getNumOfFruits() {
		return numOfFruits;
	}

	public void setNumOfFruits(int numOfFruits) {
		this.numOfFruits = numOfFruits;
	}

	public boolean getAddProtein() {
		return addProtein;
	}

	public void setAddProtein(boolean addProtein) {
		this.addProtein = addProtein;
	}

	/**
	 * ToString method in which returns information for smoothie
	 */
	@Override
	public String toString() {

		String extra = "";

		if (addProtein) { // if Protein added add statement
			extra += " + Protein added";
		}

		return getBevName() + "," + getSize() + "," + extra + numOfFruits + " $" + String.format("%.2f", calcPrice()); // return
																														// information
																														// of
																														// smoothie
	}

	/**
	 * Calculate price for smoothie
	 */
	public double calcPrice() {

		double calcPrice = super.getBASE_PRICE();
		if (super.getSize() == Size.MEDIUM) { // if Medium or Large add extra fee
			calcPrice += super.getSIZE_PRICE();
		} else if (super.getSize() == Size.LARGE) {
			calcPrice += 2 * super.getSIZE_PRICE();
		}

		calcPrice += numOfFruits * FRUIT_COST; // add fee for the FRUIT cost
		if (addProtein) { // if protein is true
			calcPrice += PROTEIN_COST; // add cost
		}

		return calcPrice; // return price

	}

	/**
	 * Equals method comparing anotherBev
	 */
	@Override
	public boolean equals(Object anotherBev) {
		Smoothie smoothie = (Smoothie) anotherBev;

		if (super.equals(anotherBev) && getNumOfFruits() == smoothie.getNumOfFruits() // If true and equals
				&& getAddProtein() == smoothie.getAddProtein()) {
			return true; // return true
		}
		return false; // or return false if not true

	}

}
