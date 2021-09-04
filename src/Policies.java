import java.time.LocalDate;

/**
 * This is interface is to ensure classes that implement it have a method
 * that check if a book is returned past its due date
 * 
 * @author Jared Amos
 *
 */
public interface Policies {
	
	/**
	 * This method will check if the date the book is returned after the due date for the
	 * book, if the if it checked out past 14 days charges will be added to the members account
	 * 
	 * @param signOut Date the book was signed out
	 * @param signIn Date the book was returned 
	 */
	public abstract void pastDue(LocalDate signOut, LocalDate signIn);
	

}
