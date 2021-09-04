import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is the User class and it extends the Person and its purpose is to read and display information to and from the user 
 * about User objects 
 * 
 * @author Jared Amos
 *
 */
public class User extends Person{
	
	/**
	 * Overloaded constructor for the class takes 4 parameters, and sets the class
	 * variables equal to the relating constructor parameters
	 * 
	 * @param fName first name of Person
	 * @param lName last name of Person
	 * @param email of the person
	 * @param phone of the person 
	 */
	public User(String fName, String lName, String email, long phone)
	{
		this.firstName = fName; // sets the class variable firstName equal to the constructor parameter fName
		this.lastName = lName; // sets the class variable lastName equal to the constructor parameter lName
		this.phoneNumber = phone; // sets the class variable phoneNumber equal to the constructor parameter phone
		this.email = email; // sets the class variable email to the constructor parameter email
	}
	
	/**
	 * Default constructor for the class, creates a new User object but does not instantiate 
	 * any of its class variables
	 */
	public User(){}
	
	/**
	 * The purpose of this method is to read inputs from the user about the User objects
	 * characteristics such as name, email and phone number
	 * 
	 * @param input Scanner that is used to read user's inputs
	 */
	@Override
	public void readInfo(Scanner input) {
		boolean control = true; // boolean to control while loop
		
		while(control){ // prompts user to enter info about User object, reads info
			input = new Scanner(System.in); // creates new instance of scanner
			boolean isNum = false; // boolean to check if the name is a number 
			try {
				System.out.print("Please enter first name: ");
				this.firstName = input.next(); // reads first name
				System.out.print("Please enter last name: ");
				this.lastName = input.next(); // reads last name
				for(int i = 0; i <= 10; i++) // iterates through possible numbers
				{
					String test = Integer.toString(i); // converts the number to string to compare
					if(this.firstName.contains(test) || this.lastName.contains(test) ) // if the name contains the number
					{
						isNum = true; 
					
					}
				}
				if( isNum == true) // if the name contained a number, output message loop continues
				{
					System.out.print("\nInvalid input for name, please try again\n\n");
					continue;
				}
				System.out.print("Please enter the email: ");
				this.email = input.next(); // reads email
				System.out.print("please enter the phone number: ");
				this.phoneNumber = input.nextLong(); //reads phone number
				control = false; // exits loop 
			}
			catch(InputMismatchException ime) { // if an input exception is caught display error message
				System.err.print("Input mismatch exception while reading inputs, please enter user data again!\n");
				
			}
			
		
		}
		
	}

	/**
	 * This method will display info in a formatted output to the user about the details of 
	 * User object 
	 * 
	 */
	@Override
	public void printInfo() {
		//displays the User objects info
		String FullName = firstName.concat(" " + lastName);
		System.out.printf("NAME: %s     |EMAIL: %s     |PHONE: %d     ", FullName, this.email, this.phoneNumber);
		
	}

}
