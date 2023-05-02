/*
 * Class: CMSC203 
 * Instructor: Prof.Grinberg
 * Description: This class creats and deveolopes information for customer 
 * Due: 5/1/2023
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Arman Babazadeh
*/

/**
 * Customer Class
 * 
 * @author armanbabazadeh
 *
 */
public class Customer {

	private String name; // Two instane varibles
	private int age;

	/**
	 * Getter methods / Setter
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * Customer Constructor
	 * 
	 * @param name
	 * @param age
	 */
	public Customer(String name, int age) {
		this.name = name;
		this.age = age;
	}

	/**
	 * Copy Constructor
	 * 
	 * @param c
	 */
	public Customer(Customer c) {
		this.age = c.age;
		this.name = c.name;

	}

	/**
	 * toString method returning information about customer
	 */
	public String toString() {

		return name + " " + age;
	}

}
