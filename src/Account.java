import java.util.Scanner;

/**
 * This is the account abstract class which purpose is to read details of accounts, display the accounts
 * and has a abstract method with updates the balance, is the parent class of both checking and savings
 * 
 * @author Jared Amos
 * @version 1.0
 * @see Bank
 * @see Checking
 * @see Savings 
 * 
 */
public abstract class Account {
	protected long accNumber; // creates a long that subclasses can access as well 
	protected Person accHolder = new Person(); // creates a new person object that subclasses can access as well 
	protected double balance; // creates a double called balance that subclasses can access as well 

	/**
	 * The purpose of this method is to read the account details form the user and outputs an
	 * error message if the user enters the wrong option 
	 * 
	 * @param scan Scanner that reads the user inputs 
	 */
	public void readAccountDetails(Scanner scan)
	{
		boolean isRunning = true; // this boolean is used to control the while loop
		// this while loop will run until the user enters the correct info
		// if they enter invalid inputs, try catch block will output a message for them to try again
		while(isRunning) // while is running is true run the code below
		try
		{
		System.out.print("Enter account number: "); 
		accNumber = scan.nextLong();
		accHolder.readPersonalDetails(scan); 
		System.out.print("Enter balance: ");
		balance = scan.nextDouble();
		isRunning = false; // exits the while loop because every input was valid 
		}
		catch(Exception e) // if any exception is thrown moves the scanner to to the next line and tells user to try again
		{
			scan.next();
			System.out.print("Invalid entry... Please try again\n");
		}
		
		
	}
	
	/**
	 * The purpose of this method is to display account details in a formatted output using a printf statment
	 */
	public void displayAccount()
	{
		
		System.out.printf("       %6d| %15s | %15s | %18d | %12.2f |\n",accNumber , accHolder.getName(), 
				 accHolder.getEmail(), accHolder.getPhoneNumber(), balance); 
		// displays the account info and person info by call accessor methods in a formatted output 
	}
	
	/**
	 * The purpose of this abstract class is to ensure that checking and savings class implement
	 * a updateBalance method with will apply fees or add interest payments depending on the account
	 */
	public abstract void updateBalance(); // abstract method that subclass must implement 

}
