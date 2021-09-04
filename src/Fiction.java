import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is the Fiction class and extends the abstract class Book and 
 * its purpose is to read inputs from the user about the Fiction object and
 * to display the details of the Fiction object
 * 
 * @author Jared Amos
 *
 */
public class Fiction extends Book {
	
	/**
	 * The purpose of this method is to read inputs from the user about the new Fiction object that is
	 * being created 
	 * 
	 * @param input Scanner that will read inputs
	 */
	@Override
	public void readBookDetails(Scanner input) {
		this.bookType = "Fiction"; // sets the objects bookType to Fiction
		boolean control = true; // boolean used to control the while loop
		while(control) // while loop to ensure proper data is inputed 
		{
			input = new Scanner(System.in); // new scanner created off the one passed in
			try{
				this.objDate = LocalDate.now(); // sets the date of object being signed out to current date 
				System.out.print("What is the name of the novel: ");
				this.bookName = input.nextLine(); // reads book name input from user
				System.out.print("Who is the author of the book: ");
				this.Author = input.nextLine(); // reads author name input from user
		
				control = false;
				
			}
			catch(InputMismatchException ime) // if the user enters improper input, outputs an error message and tells them to try again
			{
				System.err.println("Input Mismatch Exception please try entering book details again ");
			}
		}
		
	}

	/**
	 * The purpose of this method is to return the name of the book
	 * so outside classes can grab the name of the book
	 * 
	 * @return the book name
	 */
	public String getBookName()
	{
		return this.bookName; // returns the name of the book
	}
	
	/**
	 * The purpose of this method is to return the date of the book
	 * so outside classes can grab the date of the book
	 * 
	 * @return the date the book was checked out
	 */
	public LocalDate getDate()
	{
		return objDate; // returns the date of the book
	}
	
	/**
	 * The purpose of this method is to display the information about this Fiction object in
	 * a formatted output to the user
	 */
	@Override
	public void displayBook() {
		
		String stringDate = objDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); // converts the date of the book to string
		// displays Fiction details 
		System.out.printf("NAME: %s     |AUTHOR: %s     |GENRE: %s     |SIGNED OUT: %s     |", this.bookName, this.Author, this.bookType, stringDate);
		
	}

}
