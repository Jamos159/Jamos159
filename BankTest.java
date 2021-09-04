import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This is the BankTest class which is the driver class for the program which purpose is to
 * call the methods from Bank, Account, Savings, Checking, Person to create a bank system
 * which will prompt the user to either run monthly process's, display accounts, exit or read 
 * accounts, starts the program off by asking for the name of the bank and the amount of accounts
 * that need to be read
 * 
 * @author Jared Amos
 * @version 1.0
 * @see Bank
 * @see Account
 * @see Checking
 * @see Person
 * @see Savings
 * 
 */
public class BankTest {
	private static Scanner input = new Scanner(System.in); // this is the Scanner that is used for the whole package
	private static int num; // static int for the number of account holders
	
	/** This is the main method for the project and the purpose is to make calls to the various different methods
	 * that will read info about the Bank and accounts from the user and then print those inputs in a formatted 
	 * way to the console
	 * 
	 * @param args used for storing command line strings 
	 * */
	public static void main(String[] args) {
		boolean isRunning = true; // this boolean is used to control the while loop to ensure the user is entering valid info
		boolean control = false;  // this boolean is used to control the while loop to ensure the user is entering valid info
		String name = ""; // creates a string for the name of the bank
		System.out.print("Enter the name of the bank: ");
		while(control == false) // this while loop will ensure that the user enters a bank name that is not just a number
		{
			name = input.nextLine(); // grabs user input
			try 
			{
				int test = Integer.parseInt(name); // if the user input is just a number than will not go to catch block and loop continues
				System.out.print("Wrong input... please try again!\nEnter the name of the bank: "); //prompts user to try again
			
			}
			catch(NumberFormatException nfe) // if a exception is thrown means the name is not just a number and the loop is exited
			{
			
				control = true;
			}
		}
		// this while loop is to ensure the user enters a integer for the amount of account holder
		// if there is an error thrown prompts user to try again, loop will exit when a integer is entered
		while(isRunning)
		{
			try {
				System.out.print("How many account holders do you have: ");
				num = input.nextInt();
				isRunning = false;
		}
			catch(InputMismatchException e)
		{
				input.next();
				System.out.print("Invalid entry... please try again!\n");
		}
		}
		Bank bank = new Bank(name,num); //creates a new bank object with the name and size that was read from the user
		isRunning = true;
		// this while loop is ensure that that the program will keep displaying options to the user
		// as long as they dont enter 4 which will exit the program
		while(isRunning) 
		{
			System.out.print("1. Read accounts\n2. Run monthly process\n3. Display accounts\n4. Exit\n"); // prints options for user
			try
			{
				int choice = input.nextInt();
				if(choice == 1) // if user enters 1 reads account details from user
				{
					bank.readAccounts(input);
				}
				else if(choice ==2) // if user enters 2 runs monthly processes of accounts 
				{
					bank.runMonthlyProcess();
				}
				else if(choice == 3) // if user enters 3 displays all the accounts
				{
					bank.displayAccounts();
				}
				else if(choice==4) // if user enters 4 exits the program and the loop is ended
				{
					isRunning = false;
				}
				else // if the user entered a different integer user is prompted to try again, loop continues
				{
					//input.next();
					System.out.print("Invalid entry... please try again!\n");
				}
			}
			catch(Exception e) // if the user enters anyting BUT an integer catches the exception and prompts the user to try again
			{
				input.next();
				System.out.print("Invalid entry... please try again!\n");
			}
		}
		System.out.print("Goodbye... have a nice day"); 
		input.close(); // closes the scanner 

	}

}
