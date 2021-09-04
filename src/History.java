import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is an extension of the fiction class and its purpose is to display and read history
 * book details only 
 * 
 * @author Jared Amos
 *
 */
public class History extends NonFiction {

	/**
	 * This represents the period that the history book is about 
	 */
	private String period;
	
	/**
	 * This method reads details from the users input about history book specific traits 
	 * and sets those inputs equal to the class variables 
	 * 
	 * @param input Scanner that reads users objects
	 */
	public void readBookDetails(Scanner input)
	{
	this.genre = "History"; // sets genre of the NonFiction object to History
	super.readBookDetails(input); // calls the NonFiction method to read details about NonFiction object
	boolean control = true; // boolean used to control the while loop
	while(control) // while loop to ensure user is entering proper data
	{
		input = new Scanner(System.in); // new scanner creation based on the one passed into the method 
		try {
			System.out.print("What is the period of this History book: ");
			period = input.nextLine(); // reads input from user about the History books period
			control = false; // exits loop
		}
		catch(InputMismatchException ime) // if input exception is thrown, outputs error message to try again
		{
			System.err.print("Input mismatch exception, please try entering the history book info in again!\n");
		}
	
	}
	}
	
/**
 * This method displays the details of the book object that is specific to history books in a
 * formatted output
 * 
 */
public void displayBook() {
		super.displayBook(); // displays info about NonFiction object
		// displays info about History book object 
		System.out.printf("SUBGENRE: %s     | PERIOD: %s", this.genre, this.period);
		
	}
}
