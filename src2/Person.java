import java.util.Scanner;

/**
 * This is the abstract class Person which has 4 protected class variables and 
 *  2 abstract methods, Student is an Extension of this class, the purpose of this
 *  class is ensure that classes that extend Person inherit the class variables
 *  and write code for the abstract methods.
 * 
 * @author Jared Amos
 * @version 1.0
 *
 */
public abstract class Person {
	/** the first name of the Person object */
	protected String firstName;
	/** the last name of the Person object */
	protected String lastName;
	/** the emailID of the Person object */
	protected String emailID;
	/** the phoneNumber of the Person object */
	protected long phoneNumber;
	
	/** this method is to ensure classes that inherit Person 
	 *  have the readInfo method and write code so that
	 *  the program can read a Person's info through user inputs
	 *  
	 *  @param input Scanner
	 *   */
	public abstract void readInfo(Scanner input);
	/** this method is to ensure classes that inherit Person 
	 *  have the printInfo method and write code so that
	 *  the program can print a Person's info to console when called
	 *   */
	public abstract void printInfo();
	
	
}
