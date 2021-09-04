import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Formatter;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This is the staff class which purpose is to read info specific to staff members only and display
 * info specific to staff members only 
 * 
 * @author Jared Amos
 *
 */
public class Staff extends User {
	/**
	 * Represents the ID of the staff member
	 */
	private int staffID;
	/**
	 * Represents the floor number of the staff member that they work on 
	 */
	private int floor;
	/**
	 * Represents the section of the staff member that they work in
	 */
	private String section;
	
	/**
	 * Default constructor does not initialize any class variables 
	 */
	public Staff() {}
	
	/**
	 * Overloaded constructor, takes input parameters which is info about the new staff object
	 * being created and then sets the objects class variables equal to the input parameters
	 * 
	 * @param fName represents the first Name
	 * @param lName represents the last Name
	 * @param inputEmail represents the email
	 * @param phone represents the phone number
	 * @param staffID represents the staff ID
	 * @param floor represents the floor number
	 * @param section represents the section number 
	 */
	public Staff(String fName, String lName, String inputEmail, long phone, int staffID, int floor, String section)
	{
		// sets the class variables equal to the input parameters of the overloaded constructor 
		this.firstName = fName;
		this.lastName = lName;
		this.email = inputEmail;
		this.phoneNumber = phone;
		this.staffID = staffID;
		this.floor = floor;
		this.section = section;
	}
	
	/**
	 * This method reads info about a user object from the user 
	 * and then reads info that is specific to staff members only 
	 * 
	 * @param input Scanner that reads inputs
	 */
	public void readInfo(Scanner input) {
		boolean control = true; // to control while loop
		super.readInfo(input); // reads the User object info
		while(control) // prompts the user to enter Staff object info, reads it, 
		{
			input = new Scanner(System.in); // creates new instance of scanner 
			try {
				System.out.print("Please enter a staff ID: "); 
				staffID = input.nextInt(); // reads staffID input
				System.out.print("PLease enter floor: ");
				floor = input.nextInt(); // reads floor input
				System.out.print("Please enter section: ");
				section = input.next();// reads Section input
				control = false; // exits loop
				
			}
			catch(InputMismatchException ime) // if a bad input is caught, displays message , loop continues
			{
				System.err.print("Input mismatch exception please enter staff info again!\n");
			}
			
			
			
		}
	}
	
	/**
	 * Prints about the user object and then prints info that is specific to staff members
	 * 
	 */
	public void printInfo() {
		// prints User object info
		super.printInfo();
		//prints Staff object info 
			System.out.printf("|StaffID: %d     |Floor: %d     |Section: %s \n", this.staffID, this.floor, this.section);
		
		
		
	}
	

}
