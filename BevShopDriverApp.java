/*
 * Class: CMSC203
 * Instructor: Prof.Grinberg
 * Description: This is the BevShopDriver with the main method to display all contenets
 * Due: 5/1/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Arman Babazadeh
*/

import java.util.Scanner;

/**
 * This is DriverShop that I created a Bar
 * 
 * @author armanbabazadeh
 *
 */
public class BevShopDriverApp {

	private static final int MIN_AGE_FOR_ALCOHOL = 21;
	private static int category;

	public static void main(String[] args) {
		BevShop bevShop = new BevShop();
		Scanner scanner = new Scanner(System.in);
		Customer tempCustomer = new Customer("", 0);

		System.out.println("Welcome to the Bar");
		System.out.println("The current order in process can have at most " + bevShop.getMaxOrderForAlcohol()
				+ " alcoholic beverages.");
		System.out.println("The minimum age to order alcohol drink is " + bevShop.getMinAgeForAlcohol()); // This is the
																											// introduction
																											// to the
																											// bar

		System.out.println("Start please a new order!");
		bevShop.startNewOrder(1, Day.MONDAY, "John", 23);
		System.out.println("Total on the Order:" + bevShop.getCurrentOrder().calcOrderTotal());

		System.out.print("Would you please enter your name: "); // ask for the name
		String name = scanner.nextLine();
		tempCustomer.setName(name);

		System.out.print("Would you please enter your age: "); // ask for the age
		int age = scanner.nextInt();
		scanner.nextLine();
		tempCustomer.setAge(age);

		if (bevShop.isValidAge(age)) {
			System.out.println("Your age is above " + MIN_AGE_FOR_ALCOHOL + " and you are eligible to order alcohol."); // make
																														// sure
																														// person
																														// is
																														// within
																														// age
		} else {
			System.out.println("You are not eligible to order alcohol, and if you try you will be kicked out!");

		}

		while (true) {
			System.out.print("Would you like to add a drink to your order? (y/n): "); // add drink if true
			String answer = scanner.nextLine();
			if (answer.equalsIgnoreCase("n")) {
				System.out.println("Total on the Order:" + bevShop.getCurrentOrder().calcOrderTotal()); // give drink
																										// details if no
				break;
			}

			System.out.println("Please Select Alcohol this is a Bar:");
			System.out.println("1. Alcohol");
			category = scanner.nextInt();
			scanner.nextLine();
			if (!bevShop.isValidAge(age) && category == 1) {
				System.out.println("You can't buy alcohol! (kicked out) "); // kick person out if underage
				break;
			} else if (category != 1) {
				System.out.println("This is a bar we sell alcohol get out!!!"); // clicks different category kick out
				break;
			}

			switch (category) { // use switch to go through options
			case 1:
				if (category == 1) {
					if (bevShop.getNumOfAlcoholDrink() >= bevShop.getMaxOrderForAlcohol()) {
						System.out.println("You have reached the maximum number of alcohol drinks for this order.");
						System.out.println("You got to go! ");
						System.exit(0);
					} else {
						System.out
								.println("The current order of drinks is " + bevShop.getCurrentOrder().getTotalItems());
						System.out.println("Total on the Order:" + bevShop.getCurrentOrder().calcOrderTotal());
						System.out.println(
								"Your current alcohol drink order is less than " + bevShop.getMaxOrderForAlcohol());
						System.out.println("Would you please add an alcohol drink?");
						System.out.println("1. Beer");
						System.out.println("2. Wine");
						System.out.println("3. Spirit");
						System.out.println("4. Just Coffee");
						int alcoholType = scanner.nextInt();
						scanner.nextLine();
						switch (alcoholType) {
						case 1:
							bevShop.processAlcoholOrder("Beer", Size.SMALL); // add beer small
							break;
						case 2:
							bevShop.processAlcoholOrder("Wine", Size.LARGE); // add wine large
							break;
						case 3:
							bevShop.processAlcoholOrder("Spirit", Size.MEDIUM); // add spirit medium
							break;
						case 4:
							bevShop.processCoffeeOrder("Coffee", Size.SMALL, false, false);
							System.out.println("We only have small coffee here we ran out of medium and large enjoy!");

							break;
						default:
							System.out.println("Invalid drink type selected.");
							break;
						}

					}

				}
			}
		}
	}
}
