import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This is the Member class the purpose of this class to perform the behaviors of a library
 * member, the member can sign out books and sign books back in and can be charged fees to their
 * account if the member returns a book after 14 days, this object will have an array list of books
 * they have signed out and that cannot exceed 5 books, this class implements the policies interface
 * and extends User class
 * 
 *@author Jared Amos
 *@see User
 *@see Policies
 */
public class Member extends User implements Policies {
	/** * Represents the Members ID that will be used to identify them in the system */
	private int ID;
	/** * Represents the Members age */
	private int age;
	/** * Represents the Members fee balance , which will be have charges added after a book is returned in more than 14 days*/
	private int fees;
	/** * Represents the Members list of books they currently have signed out*/
	private ArrayList<Book> bookList = new ArrayList<Book>();
	
	/** * This is the default constructor for the class, initializes no class variables*/
	public Member() {}
	
	/**
	 * This is the overloaded constructor that takes the input parameters and initializes all class variables 
	 * equal to the input parameters, this constructor is used when reading from files
	 * 
	 * @param fName represents the first name
	 * @param lName represents the last name
	 * @param inputEmail represents the email
	 * @param phone represents the phone number
	 * @param ID represents the ID of the member
	 * @param age represents the age of the member
	 * @param fees represents the fee balanc of the member
	 */
	public Member(String fName, String lName, String inputEmail, long phone, int ID, int age, int fees)
	{
		//sets the class variables equal to the input parameters of the overloaded constructor
		this.firstName = fName; 
		this.lastName = lName;
		this.email = inputEmail;
		this.phoneNumber = phone;
		this.ID = ID;
		this.age = age;
		this.fees = fees;
	}
	
	/**
	 *  The purpose of this method to prompt the user to enter information about the new member object
	 *  being created, it then sets the class variables equal to the user inputs
	 *  
	 *  @param input Scanner that will read user inputs
	 */
	@Override
	public void readInfo(Scanner input) {
		boolean control = true; //used to control 
		super.readInfo(input); // reads the info about the User object
		while(control) // loop to ensure proper user input
		{
			input = new Scanner(System.in); // creates new instance of scanner
			try {
				System.out.print("Please enter a member ID: ");
				ID = input.nextInt(); // reads the ID of the member
				System.out.print("PLease enter age: ");
				age = input.nextInt(); // reads the age of the member
				control = false;
				
			}
			catch(InputMismatchException ime) // if an exception is caught from bad input, output error message loop continues
			{
				System.err.print("Input mismatch exception please enter member info again!\n");
			}
			
			
			
		}
	}
	
	/**
	 * The purpose of this mutator method is to set the fee balance of the member object
	 * 
	 * @param fees is the amount of charges being added to the account 
	 */
	public void setFees(int fees) {
		this.fees += fees;
	}
	
	/**
	 * The purpose of this method is to add books to the member objects array list of books
	 * ensures that the member does not already have 5 books signed out then adds the book to the array list
	 * 
	 * @param book the book object that is being added to the list of books
	 */
	public void addBook(Book book)
	{
		
		if(bookList.size() >= 5) // if there are already 5 books in the members book list, outputs message
		{
			System.out.println("This member has already exceeded the maximum amount of books a member can have");
		}
		else { // if there are not 5 books in the book list
			
			bookList.add(book); // add the book object to the members book list
		}
		
	}
	
	/**
	 * The purpose of this method is to display all the books this member currently has checked out
	 * if the member has no books checked out, then the user is informed of that through an output message
	 */
	public void getBook() {
		if(bookList.size() > 0) // if the book list is not empty
		{
			for(int i = 0; i < bookList.size(); i++) // iterates through the book list
			{
				System.out.print("\n");
				bookList.get(i).displayBook(); // displays the book info
			}
		}
		else { // if there are no books in the members book list, display message
			System.out.print("There are no books to display for this member");
		}
	}
	
	/**
	 * The purpose of this method is to allow outside classes to grab the value of this members ID
	 * 
	 * @return ID the integer value used to represent this member
	 */
	public int getID()
	{
		return ID; // returns the ID of the member
	}
	
	/**
	 * The purpose of this method is to allow outside classes to grab this members name
	 * 
	 * @return String that is the combination of the first name and last name
	 */
	public String getName()
	{
		return(this.firstName + " " + this.lastName); // returns the first name and last name combined
	}
	
	/**
	 * The purpose of this method is to allow outside classes to grab the size of the members book list
	 * 
	 * @return book list size 
	 */
	public int getList()
	{
		return bookList.size(); // returns the size of the book list
	}
	
	/**
	 * The purpose of this method is to allow a member to return a book that they have signed out
	 * asks them for the book they are returning and the return date, if the member has no books they
	 * can return outputs a message telling the user that 
	 * 
	 * @param input Scanner that grabs user inputs
	 */
	public void bookReturn(Scanner input)
	{
		boolean control = true; // controls the while loop
		while(control) // while loop to display the members book and have the user enter the book they are returning
		{
			input = new Scanner(System.in);
			System.out.print("\nPlease enter the name of the book you are trying to return: ");
			String signIn = input.nextLine(); // grabs the name of the book they are returning
			int index = 0; // used to track the index of the book in Members book list
			boolean check = false; // used to ensure the book the user inputs is in the list
			for(int i = 0; i < bookList.size(); i++) // iterates through book list
			{
				if(signIn.equals(bookList.get(i).getBookName())) // if the name inputed matches any in the list
				{
					check = true; // book is in list so set to true
					index = i; // grabs the index of the book they are signing out
				}
			}
			if(check == true) // if the book is in the list
			{
				try {
					//prompt and read the date the book is being returned
					System.out.print("What is the date you are returning this book\n");
					System.out.print("Year: ");
					int checkInYear = input.nextInt(); // read year
					System.out.print("Month: ");
					int checkInMonth = input.nextInt(); // read month
					System.out.print("Day: ");
					int checkInDay = input.nextInt(); // read day
					LocalDate checkIn = LocalDate.of(checkInYear,checkInMonth, checkInDay); // used to compare the checkin date and checkout date of the book
					if(checkIn.compareTo(bookList.get(index).getDate()) > 0) // if the check in date is NOT before the check out date
					{
						pastDue(bookList.get(index).getDate(), checkIn); // apply the fees if anything to the members 'fees'
						bookList.remove(index); // remove the book from the index found earlier 
						control = false; // exit loop
					}
					else // if the user entered a wrong date
					{
						System.out.print("Invalid input the date you are returning the book is before you checkout the book out, Please try again!/n");
						continue; // go to begining of loop
					}
				}
				catch(InputMismatchException ime) // if a input mismatch exception is caught, loop continues, displays error message
				{
					System.err.println("Input mismatch exception while inputting the date, please try again!\n");
				}
				catch(DateTimeException dte) // if there is an exception while entering the date, loop continues, output error message
				{
					System.err.print("Date time exception while inputtting the date, please try again!\n");
				}
			}
			else {// if there are no books in the list that match that name, display message
				System.out.print("The name you entered does not match any of the ones in that members book list, please try again!\n");
			}
		}	
	}

	/**
	 * This method will compare the date the user signed the book out and the date they are returning it
	 * if the date they are returning it is 14 days past the signout date then for each day they will
	 * be charged 1 dollar
	 * 
	 * @param signOut the date the book was signed out
	 * @param signIn the date the book was returned 
	 */
	@Override
	public void pastDue(LocalDate signOut, LocalDate signIn) {
		if(signIn.compareTo(signOut) > 14) // if it has been more than 14 days since signout date 
		{
			this.fees += signIn.compareTo(signOut) - 14; // add the difference between signout date and signin date to 'fees'
		}
		
	}
	
	/**
	 * This method displays all the information about this member
	 */
	public void printInfo() {
		super.printInfo(); // prints the User object info
		// prints the Member object info
		System.out.printf("|ID: %d     |Age: %d     |Fees: %d \n", this.ID, this.age, this.fees);
		
	}
	
	
	
}
