import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is an extension of the NonFiction class and its role
 * is to read and display info that is specific to Science books
 * 
 * @author Jared Amos
 *
 */
public class Science extends NonFiction {
	/**
	 * This is the field of study that the book is about
	 */
	private String field;
	
	/**
	 * Reads info about NonFiction books and then reads info specific to science novels 
	 * 
	 * @param input Scanner 
	 */
	public void readBookDetails(Scanner input)
	{
	this.genre = "Science"; // sets the genre of this book to Science 
	super.readBookDetails(input); // read the NonFiction book details
	boolean control = true; // boolean to control loop
	while(control)
	{
		input = new Scanner(System.in); // creates new instance of scanner
		try {
			System.out.print("What is the field of this science book: ");
			field= input.nextLine(); // reads the field from user input
			control = false; // exits loop
		}
		catch(InputMismatchException ime) // if the input throws an exception, display message
		{
			System.err.print("Input mismatch exception, please try entering the Science book info in again!\n");
		}
	
	}
	}
	
	/**
	 * Displays info about the NonFiction book and then displays info about the Science book
	 */
	public void displayBook() {
		// displays NonFiction book info
		super.displayBook();
		//displays Science info
		System.out.printf("SUBGENRE: %s     | FIELD: %s", this.genre, this.field);
		
	}

}
