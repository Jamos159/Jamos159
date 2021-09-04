import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is an extension of the NonFiction class and its role
 * is to read and display info that is specific to biographies
 * 
 * @author Jared Amos
 *
 */
public class Biography extends NonFiction{
	
	/**
	 * This is the name of who the biography is about 
	 */
	private String name;
	
	/**
	 * This method reads info about the NonFiction object and then reads info about the biography
	 * object 
	 * 
	 * @param input Scanner that will read user inputs
	 * 
	 */
	public void readBookDetails(Scanner input)
	{
	this.genre = "Biography"; // sets the objects "genre" to biography
	super.readBookDetails(input); // calls the super method to read info about the NonFiction details 
	boolean control = true; // boolean used to control the while loop
	while(control) // while loop to ensure the user enters the proper input
	{
		input = new Scanner(System.in); // creates a new scanner object that was passed into the method
		try {
			System.out.print("Who is this biography about:  ");
			name= input.nextLine(); // grabs the users inputs about the name and sets it equal to class variable
			control = false; // exits the loop
		}  // catch statement to catch any Inputmismatch exceptions, if caught will display a error message
		catch(InputMismatchException ime)
		{
			System.err.print("Input mismatch exception, please try entering the biography book info in again!\n");
		}
	
	}
	}
	
	/**
	 * This method will display the NonFiction details and the details specific to Biographies
	 */
	public void displayBook() {
		super.displayBook(); // calls the NonFiction display method, to show the NonFiction info
		System.out.printf("SUBGENRE: %s     | ABOUT: %s", this.genre, this.name); // displays the Biography specific info
		
	}

}
