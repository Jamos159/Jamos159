import java.util.Scanner;

/**
 * This is the abstract class Person and its purpose is to ensure classes that
 * extend Person implement and have the proper methods and characteristics of a
 * Person object 
 * 
 * @author Jared Amos
 *
 */
public abstract class Person {
	/** 
	 * Represents the Person objects first name 
	 */
	protected String firstName;
	/** 
	 * Represents the Person objects last name 
	 */
	protected String lastName;
	/** 
	 * Represents the Person objects phone number 
	 */
	protected long phoneNumber;
	/** 
	 * Represents the Person objects email 
	 */
	protected String email;
	
	/**
	 * The purpose of this method is to force subclasses that extend this class
	 * to implement this abstract method that will read inputs from the user
	 * about Person objects 
	 * 
	 * @param input Scanner for user input
	 */
	public abstract void readInfo(Scanner input);
	
	
	/**
	 * The purpose of this method is to force subclasses that extend this class
	 * to implement this abstract method that will print info about Person objects 
	 * 
	 */
	public abstract void printInfo();

}
