import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This is the FulltimeStudent class which is an extension of Student class
 * the purpose of this class is to make calls to a super method and then add 
 * the inputs or print out details that are specific to objects of this class 
 * 
 * @author Jared Amos
 * @version 1.0
 * @see Student
 * @see College 
 * @see Person
 *
 */
public class FulltimeStudent extends Student {
	private double tutionFees;// class variable called tutionFees 
	
	/** 
	 *  This is the default constructor for the class, creates a object but does not instantiate any variables 
	 *  */
	public FulltimeStudent() {}
	
	/** 
	 *  This is the overloaded constructor for the class, creates a object and instantiates and gives values to all class variables
	 *  based on the constructor parameters 
	 *  
	 *  @param studNum integer for student number 
	 *  @param fName string that represents the objects first name
	 *  @param lName string that represents the objects last name
	 *  @param email string that represents the objects email
	 *  @param phoneNum long that represents the objects phone number
	 *  @param progName string that represents the objects program of study
	 *  @param gpa double that represents the objects GPA
	 *  @param tutionFees double that represents the objects tuition fees
	 *  */
	public FulltimeStudent(int studNum, String fName, String lName, String email, long phoneNum, String progName, double gpa, double tutionFees)
	{
		// sets what was entered in the parameters equal to the objects class variables 
		this.studentNumber = studNum;
		this.firstName = fName;
		this.lastName = lName;
		this.emailID = email;
		this.phoneNumber = phoneNum;
		this.programName = progName;
		this.gpa = gpa;
		this.tutionFees = tutionFees;
	}
	
	/** This is the readInfo method, the purpose of this method is to call the 
	 *  readInfo method from the super class and then to prompt the user to enter
	 *  additional information specific to this class 
	 *  
	 *  @param input Scanner that reads users info 
	 *  */
	@Override 
	public void readInfo(Scanner input)
	{
		super.readInfo(input); // calls super method called readInfo()
		boolean control = true; // boolean use to control while loop
		while(control) // loop will continues until user enters valid data 
		{
			try {
				System.out.print("Enter tution fees: "); // outputs a prompt to the user
				tutionFees = input.nextDouble(); // grabs the input from he user and sets it equal to the class variable tutionFees
				if(tutionFees < 1) // if the tuition fees are less than zero output a message to try again and throws the loop back to the beginning  
				{
					System.out.print("Tution fees cannot be less than zero... Please try again!\n");
					continue;
				}
				control = false; // exits loop if no errors were caught
			}
			catch(InputMismatchException ime) // if the user enters anything but a double prints an error message, loop continues
			{
			 System.err.println("Input Mismatch Exception when reading full time student info... Please try again!\n");
			 input.next(); // moves scanner to next token 
			}
		}
	}
	
	
	/** This is the printInfo method and its purpose is to call the printInfo method 
	 * from the super class and then print out some additional information specific to this class in a formatted way */
	@Override
	public void printInfo()
	{
		super.printInfo(); // calls the super method printInfo which outputs students info in a formated output 
		System.out.printf(" %10.2f |", tutionFees); //adds the class specific info to the end of the formatted output of printInfo()
	}

}
