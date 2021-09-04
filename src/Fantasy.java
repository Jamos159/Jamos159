import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is an extension of the Fiction class and its role
 * is to read and display info that is specific to fantasy novels
 * 
 * @author Jared Amos
 *
 */
public class Fantasy extends Fiction {
	
	/**
	 * This is the name of the series this book is part of 
	 */
	private String series;
	
	/**
	 * First calls the method that reads about fiction object and then reads info that
	 * is specific to Fantasy novels 
	 * 
	 * @param input Scanner 
	 */
	public void readBookDetails(Scanner input)
	{
	this.genre = "Fantasy"; // sets the Fiction objects genre to fantasy 
	super.readBookDetails(input); // method call from Fiction class, reads Fiction object details
	boolean control = true;//boolean to control while loop
	while(control)
	{
		input = new Scanner(System.in); // new scanner created from the one passed into the method
		try {
			System.out.print("What is series is this book is part of: "); // prompts user for series name
			series = input.nextLine(); // sets user input equal to the class variable "series"
			control = false; // exits the loop
		}
		catch(InputMismatchException ime) // catches any Input Exception errors, displays error message, loop continues
		{
			System.err.print("Input mismatch exception, please try entering the Fantasy novel info in again!\n");
		}
	
	}
	}

/**
 * This method will display the info about the fiction object and then display info that is specific 
 * to fantasy novels 
 * 
 */
public void displayBook() {
		super.displayBook(); // displays Fiction object details
		System.out.printf("SUBGENRE: %s     | SERIES: %s", this.genre, this.series); // displays Fantasy object details
		
	}

}
