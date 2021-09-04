import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is the NonFiction class and extends the abstract class Book and 
 * its purpose is to read inputs from the user about the NonFiction object and
 * to display the details of the NonFiction object
 * 
 * @author Jared Amos
 *
 */
public class NonFiction extends Book {

	/**
	 * The purpose of this method is to read inputs from the user about the new NonFiction object that is
	 * being created 
	 * 
	 * @param input Scanner that will read inputs
	 */
	@Override
	public void readBookDetails(Scanner input) {
		this.bookType = "Fiction"; // sets book type to fiction 
		boolean control = true; // controls the while loop
		while(control) // reads the info about the book
		{
			input = new Scanner(System.in); // creates new instance of scanner
			try{
				this.objDate = LocalDate.now(); // sets the date of book to current day
				System.out.print("What is the name of the novel: ");
				this.bookName = input.nextLine(); // reads the novel name
				System.out.print("Who is the author of the book: ");
				this.Author = input.nextLine(); // reads the authors name
				control = false; //exits loop
				
			}
			catch(InputMismatchException ime) // if input exception is caught loop continues, displays message
			{
				System.err.println("Input Mismatch Exception please try entering book details again ");
			}
		}
		
	}

	
	/**
	 * The purpose of this method is to display the information about this Fiction object in
	 * a formatted output to the user
	 */
	@Override
	public void displayBook() {
		// converts date to String
		String stringDate = objDate.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		// displays book info
		System.out.printf("NAME: %s     |AUTHOR: %s     |GENRE: %s     |SIGNED OUT: %s     |", this.bookName, this.Author, this.bookType, stringDate);
		
	}

	/**
	 * The purpose of this method is to return the name of the book
	 * so outside classes can grab the name of the book
	 * 
	 * @return the book name
	 */
	@Override
	public String getBookName() {
		
		return this.bookName; // returns the book name
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

}
