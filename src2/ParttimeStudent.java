import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This is the class ParttimeStudent and is an extension of Student class, the purpose
 * of this class is to override the readInfo and printInfo method from Student and add new class variables 
 * 
 * @author Jared Amos
 * @version 1.0
 * 
 * @see Student
 * @see College 
 * @see Person
 *
 */
public class ParttimeStudent extends Student {
	private double courseFeesTotal; // class variable courseFeesTotal
	private double credits; // class variable credits 
	
	/** 
	 *  This is the default constructor for the class, creates a object but does not instantiate any variables 
	 *  */
	public ParttimeStudent() {}
	
	
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
	 *  @param courseFees double that represents the objects course fees
	 *  @param credits double that represents the objects credits 
	 *  */
	public ParttimeStudent(int studNum, String fName, String lName, String email, long phoneNum, String progName, double gpa, double courseFees, double credits)
	{
		// sets what was entered in the parameters equal to the objects class variables 
		this.studentNumber = studNum;
		this.firstName = fName;
		this.lastName = lName;
		this.emailID = email;
		this.phoneNumber = phoneNum;
		this.programName = progName;
		this.gpa = gpa;
		this.credits = credits;
		this.courseFeesTotal = courseFees;
	}
	
	/** This is the readInfo method, the purpose of this method is to call the 
	 *  readInfo method from the super class and then to prompt the user to enter
	 *  additional information specific to this class 
	 *  
	 *  @param input Scanner to read users input 
	 *  */
	@Override
	public void readInfo(Scanner input)
	{
		super.readInfo(input); // calls super class method readinfo()
		boolean control = true; // boolean use to control while loop
		while(control) // loop will continues until user enters valid data 
		{
			try {
			
		
				System.out.print("Enter total course fees: "); // prompts user to enter course fees
				courseFeesTotal = input.nextDouble(); // sets the inputed course fees equal to class variable 
				if(courseFeesTotal < 1) // if course fees less than 1 prompt user to try again and go back to beginning of loop
				{
					System.out.print("Course fees cannot be less than zero... Please try again!\n");
					continue;
				}
				System.out.print("Enter credit hours: "); // prompts user to enter credit hours
				credits = input.nextDouble(); // sets  the class variable equal to the user input
				if(credits < 1) // if credits less than 1 prompt user to try again and go back to beginning of loop
				{
					System.out.print("Credits cannot be less than zero... Please try again!\n");
					continue;
				}
				control = false; // exits loop
			}
			catch(InputMismatchException ime) // if the user enters anything but a double, outputs error message, loop continues 
			{
			 System.err.println("Input Mismatch Exception when reading part time student info... Please try again!\n");
			 input.next(); // moves scanner to the next token
			}
		}
	}
	
	/** This is the printInfo method and its purpose is to call the printInfo method 
	 * from the super class and then print out some additional information specific to this class in a formatted way */
	@Override 
	public void printInfo()
	{
		super.printInfo(); // calls the super method printInfo()
		System.out.printf("%11.2f | %7.2f|", courseFeesTotal, credits); // outputs the student info in a formatted way
	}
}
