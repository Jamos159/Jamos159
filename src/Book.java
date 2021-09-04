import java.time.LocalDate;
import java.util.Scanner;

/**
 * The purpose of this abstract class is to ensure that classes that extend Book
 * have implemented the proper methods so that the program runs smoothly when
 * dealing with subclasses of Book
 * 
 * @author Jared Amos
 *
 */
public abstract class Book {
	
	/** Represents the day the book was checked out 
	 */
	protected LocalDate objDate;
	/** Represents the book name
	 */
	protected String bookName;
	/** Represents the day the bookType
	 */
	protected String bookType;
	/** Represents the author of the book
	 */
	protected String Author;
	/** Represents the genre of the book
	 */
	protected String genre;
	
	/**
	 * This method will force subclasses to implement a method that
	 * reads the details of the book from the users 
	 * 
	 * @param input Scanner for user inputs
	 */
	public abstract void readBookDetails(Scanner input);
	
	/**
	 * This method will force subclasses to make a method
	 * that displays the details of the book in a formatted output
	 * to the user
	 * 
	 */
	public abstract void displayBook();
	
	/**
	 * This method will force subclasses to implement a method that
	 * will return the name of the book
	 * 
	 * @return name of the book
	 */
	public abstract String getBookName();
	
	/**
	 * This method will force subclasses to implement a method that
	 * will return the date of when the book was checked out
	 * 
	 * @return date of the book
	 */
	public abstract LocalDate getDate();
	

}
