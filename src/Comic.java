import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is an extension of the fiction class and its purpose is to display and read comic
 * book details only 
 * 
 * @author Jared Amos
 *
 */
public class Comic extends Fiction {
	/**
	 * This represents the comic book number of the novel
	 */
	private int seriesNum;
	
	/**
	 * This method reads details specific to comic books form the user and sets the class variables
	 * equal to the inputs
	 * 
	 * @param input Scanner that reads the objects details from the user
	 */
	public void readBookDetails(Scanner input)
	{
		this.genre = "Comic"; // sets the genre of this Fiction object to "comic"
		super.readBookDetails(input); // calls the Fiction method to read details about the Fiction object
		boolean control = true; // boolean to control while loop
		// this while loop is to ensure that the user is entering a proper number
		// if anything but an integer is entered loop continues and and displays
		// an error message tell the user to try again
		while(control)
		{
			input = new Scanner(System.in);
			try {
				System.out.print("What is comic book number for this book: ");
				seriesNum = input.nextInt(); // grabs user input and sets it equal to the class variable
				control = false;
			}
			catch(InputMismatchException ime) // catches input mismatch exception, then displays error message
			{
				System.err.print("Input mismatch exception, please try entering the comic info in again!\n");
			}
		
		}
		
	}
	
/**
 * This method calls the fiction class method displayBook and then displays the info specific to comic books
 * in a formatted output
 */
public void displayBook() {
		super.displayBook(); // displays the Fiction object details
		System.out.printf("SUBGENRE: %s     | COMIC NUMBER: %d", this.genre, this.seriesNum);//displays the comic object details
		
	}

}
