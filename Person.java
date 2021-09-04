import java.util.Scanner;
/**
 * This is the person class which purpose is to represent a person for the
 * bank system project, this class has a method that reads details about a person
 * and has methods to get the details for other classes
 * 
 * @author Jared Amos
 * @version 1.0
 * @see Bank
 
 */
public class Person {
	
	private String firstName;  // class variable that represents the Person objects first name
	private String lastName;  // class variable that represents the Person objects last name
	private String email; // class variable that represents the Person objects email
	private long phoneNumber;  // class variable that represents the Person objects phone number
	
	/**
	 * This is the default constructor for the class which creates
	 * a person object with none of the class variables instantiated
	 */
	public Person() {}
	
	/**
	 * This is the overloaded constructor for the class which creates
	 * a person object and instantiates the class variables through
	 * the user's input parameters of the constructor 
	 * 
	 * @param fName this is the first name for the person object
	 * @param lName this is the last name for the person object 
	 * @param email this is the email for the person object 
	 * @param phone this is the phone number for the person object
	 */
	public Person(String fName, String lName, String email, long phone)
	{
		this.firstName = fName; // sets the first name of the object equal to the constructor param fName
		this.lastName = lName; // sets the last name of the object equal to the constructor param lName
		this.email = email; // sets the email of the object equal to the constructor param email
		this.phoneNumber = phone; // sets the phoneNumber of the object equal to the constructor param phone
	}
	
	/**
	 * This is the getter method for the name of the person object
	 * 
	 * @return a string that joins the first and last name of person object into one string
	 */
	public String getName()
	{
		// returns a string that is the joining of the first name and the last name with a space in between
		return(String.join(" ", firstName, lastName)); 
	}
	
	/**
	 * This is the getter method for the email of the person object 
	 * 
	 * @return a string, the email of the person object 
	 */
	public String getEmail()
	{
		return email; // returns the class string variable email
	}
	
	/**
	 * This is the getter method for the phone number of the person object
	 * 
	 * @return the phone number of the person object 
	 */
	public long getPhoneNumber()
	{
		return phoneNumber; // returns the class long variable phoneNumber
	}
	
	/**
	 * This method reads the details of the person object and sets the user's input
	 * equal to the class variables 
	 * 
	 * @param input scanner object that takes inputs from the user 
	 */
	public void readPersonalDetails(Scanner input)
	{
		boolean isRunning = true; // this boolean is used for the while loop to ensure only proper inputs are read
		while(isRunning) // while is running is true execute code below
		{
			// this try statement is used to read personal info like name, email and phone
			// if all inputs are valid and none throw a type mismatch exception then the while loop
			// is exited, if it does throw an error prints a error message and loop repeats
			// prompting user to enter the info again because its invalid
			try {
				System.out.print("Enter first name: "); // prompts user for first name
				firstName = input.next(); // reads user input and sets it equal to class variable
				// regex statement, if the string contains a number 0-9 go into the if statement block
				if((firstName.matches("\\d*")) == true) 
				{
					System.out.print("Invalid name please try again...\n"); // prompts user to try again
					continue; // ends the current loop and starts again from the beginning 
				}
				System.out.print("Enter last name: "); // prompts user for last name
				lastName = input.next();  // reads user input and sets it equal to class variable
				// regex statement, if the string contains a number 0-9 go into the if statement block
				if((lastName.matches("\\d*")) == true) 
				{
					System.out.print("Invalid name please try again...\n"); // prompts user to try again
					continue; // ends the current loop and starts again from the beginning 
				}
				System.out.print("Enter email: "); // prompts user for email
				email = input.next(); // reads user input and sets it equal to class variable
				System.out.print("Enter phone number: ");// prompts user for phone number
				phoneNumber = input.nextLong(); // reads user input and sets it equal to class variable
				isRunning =false; // sets the control boolean to false and exits the loop
			}
			catch(Exception e) // if there is an exception thrown by any of the user inputs execute code below
			{
				input.next(); // moves the scanner to next input
				System.out.print("Invalid entry... please try again\n"); // prompts user to try again
			}
		}
	}
}
