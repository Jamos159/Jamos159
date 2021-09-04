import java.util.ArrayList;
import java.util.Scanner;
/**
 * This is the Bank class which keeps track of accounts both savings and checkings
 * this class is also responsible for running monthly processes which will add checking fees
 * or add interest onto savings. Also has a method which prints all the accounts and another
 * one that prints the title in a formatted output 
 * 
 * @author Jared Amos
 * @version 1.0
 * @see Account
 * @see Checking
 * @see Savings 
 * 
 */
public class Bank {
	
	private static String name; // static class variable, it is static because it is used in static methods
	private ArrayList<Account> accounts = new ArrayList<Account>(); // creates an array list which will hold Account objects
	
	/**
	 * This is overloaded constructor for the class which intakes the name of the bank
	 * and the size of the Arraylist to hold the accounts for the bank
	 * 
	 * @param name is the name of the bank
	 * @param size is the size of the arraylist that holds the account, more accounts can be added than the size
	 */
	public Bank(String name, int size)
	{
		this.name = name; // sets the objects name to the same as the constructor param
		accounts = new ArrayList<Account>(size); // intializes the class array list with the size of the constructor param size
		
		
	}
	
	/**
	 * The purpose of this class is to read accounts from the user from a scanner and then
	 * create either a savings or checking account based on user input and then adds the account 
	 * to the array list, if the user enters a wrong option outputs a error message to prompt
	 * them to try again
	 * 
	 * @param scan Scanner that reads user inputs
	 */
	public void readAccounts(Scanner scan)
	{
			System.out.print("1. Checkings\n2. Savings\nEnter type of account you want to create: "); // prints options for user
			int choice = scan.nextInt(); // reads users input and sets it equal to an int called choice
			if(choice == 1) // if the user entered a 1 creates a new checking object and adds it to the array list
			{
				Checking check = new Checking(); // creates new checking object
				check.readAccountDetails(scan); // calls the new checking object read method to have it details read
				accounts.add(check); // adds the object to the array list
			}
			else if(choice == 2) // if the user entered a 2 creates a new savings object and adds it to the array list
			{
				Savings save = new Savings(); // creates new savings object
				save.readAccountDetails(scan); // calls the new savings object read method to have it details read
				accounts.add(save); // adds the object to the array list
			}
			else 
			{
				System.out.print("Invalid entry... Please try again!\n"); // if the user did not enter a 1 or 2 prompt them to try again
			}
	
	}
	
	/**
	 * The purpose of this class is to run the monthly processes of accounts by either
	 * subtracting checking fees from the balance of the checking accounts or adding interest to
	 * savings account balance, if there are no accounts to process then outputs a message informing
	 * the users of that
	 */
	public void runMonthlyProcess() {
		if(accounts.size() != 0) // if the arraylist is not empty update the balance of every account in the list
		{
			for(int i =0; i < accounts.size(); i++) // for loop to go through every account
			{
				accounts.get(i).updateBalance(); // calls the update balance method from account i
			}
		}
		else {
			System.out.print("No accounts to process\n"); // if there are no accounts in the array list outputs a message to inform the user
		}
	}
	
	/**
	 * The purpose of this account is to display the accounts of the bank system by displaying
	 * each account in the accounts array list, calls the displayAccount method from the accounts class
	 * if there are no accounts to display then outputs a message informing the user of that
	 */
	public void displayAccounts()
	{
		if(accounts.size() > 0) // if there is at least 1 account in the list calls the display account method for each account
		{
			printTitle(); // calls the static method print title
			for(int i =0; i < accounts.size(); i++)// for loops to cycle through every account
			{
				accounts.get(i).displayAccount(); // displays the account info of account i 
			}
		}
		else // if there are no accounts in the arraylist prints a message informing the user of that
		{
			System.out.print("No accounts to display\n");
		}
	}
	
	/**
	 * 	
	 * The purpose of this method is to print the title of the bank in a formatted output as
	 * well as the info that each account that will be shown, calls the print stars method
	 * to give it a formatted look  
	 * 
	 * */
	public static void printTitle()
	{
		printStars(); // calls the static method prints stars
		for(int i =0; i<40; i++) // for loop to center the title of the bank when displayed by using spaces
		{
			System.out.print(" ");
		}
		System.out.print(name+" Bank\n"); // the prints the name of the account
		printStars(); // calls the static method prints stars
		System.out.printf("    %3s| %15s | %15s | %18s | %12s |\n","accNumber" , "Name", 
				 "Email" , "Phone Number" , "Balance"); // displays what account info will be shown in a fomatted output
		printStars(); // calls the static method prints stars
	}
	
	/**
	 * The purpose of this method is to print stars out on a line
	 * giving the printTitle method a formatted output
	 */
	public static void printStars()
	{
		for(int i=0; i<86; i++) // for loop to print stars in a line
		{
			System.out.print("*");
		}
		System.out.print("\n");
	}
}
