import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This is the class Student which extends Person and implements Policies, it has 3 class variables
 *  a default constructor and 4 methods. The purpose of this class to read the info and marks about students
 *  through user inputs and then print this info out as well as calculate a students GPA
 *  this is the parent class of FulltimeStudent and ParttimeStudent
 * 
 * @author Jared Amos
 * @version 1.0
 * @see Person
 * @see College
 *
 */

public class Student extends Person implements Policies {
	/** this is the student number of the student  */
	protected int studentNumber;
	/** this is the 3 letter name for the program the student is in */
	protected String programName;
	/** this is the value for the students GPA */
	protected double gpa;
	
	/** this is the default constructor for the class */
	public Student()
	{
	}
	
	/** The purpose of this method is calculate the GPA of the student by using the
	 * constants from the interface Policies that was implemented, once calculated the 
	 * class variable gpa is set equal to the calculated GPA
	 * 
	 * @param marks this is the array list that stores the marks of the student
	 * */
	@Override
	public void calculateGpa(ArrayList<Double> marks) {
		double sum = 0;
		for(int i = 0; i < marks.size(); i++) // for loop to cycle through the marks array
		{
			sum += marks.get(i); // adds every mark to sum 
		}
		double tester1 = marks.size();
		gpa = sum/(tester1 * MAX_MARKS)* MAX_GPA;
		
	}
	
	/** The purpose of this method is read the info about the student through 
	 * console prompts and user inputs, it will then set the class variables 
	 * equal to the inputed values from the user 
	 * 
	 * @param input Scanner that reads info of students 
	 * */
	@Override
	public void readInfo(Scanner input) {
		boolean control = true; // boolean used to control while loop
		input.nextLine(); // cleans up scanner before reading student info
		// this while is used to ensure the user enters good data, if any exceptions are caught or bad data is entered the loop continues, if not it exits
		while(control) 
		{
			input = new Scanner(System.in);
			try // try block used to ensure the program does not crash from input mismatch errors 
			{
				// prompts user for program name and then reads it 
				System.out.print("Enter program name: ");
				programName = input.nextLine();
				// if the program name contains a space and is less than 3, prompts user to try again and goes back to the begining of the loop
				if(programName.contains(" ") && programName.length() < 3) // if statement to ensure that the name is not a blank space
				{
					System.out.print("Wrong input... please try again!\n"); //prompts user to try again
					continue;
				}
				try 
				{
					double test = Double.parseDouble(programName); // if the user input is just a number than will not go to catch block and loop continues
					System.out.print("Wrong input... please try again!\n"); //prompts user to try again
					continue;
				
				}
				catch(NumberFormatException nfe) // if a exception is thrown means the name is not just a number and the loop is exited
				{ 
				}
				//prompts user to enter student number, then reads their input
				System.out.print("Enter student number: ");
				studentNumber = input.nextInt();
				if(studentNumber < 1) // if student number is less than one, prompt them to try again and goes to begining of loop again 
				{
					System.out.print("Student number must be greater than 0, Please Enter student info in again!\n");
					continue;
				}
				//prompts user to enter first name, then reads their input
				System.out.print("Enter first name: ");
				this.firstName = input.next();
				if(firstName.contains(" ") && firstName.length() < 3) // if statement to ensure that the name is not a blank space
				{
					System.out.print("Wrong input... Please Enter student info in again!\n"); //prompts user to try again
					continue;
				}
				try 
				{
					double test = Double.parseDouble(firstName); // if the user input is just a number than will not go to catch block and loop continues
					System.out.print("Wrong input... Please Enter student info in again!\n"); //prompts user to try again
					input.nextLine();
					continue;
				
				}
				catch(NumberFormatException nfe) // if a exception is thrown means the name is not just a number and the loop is exited
				{ 
				}
				//prompts user to enter last name, then reads their input
				System.out.print("Enter last name: ");
				this.lastName = input.next();
				if(lastName.contains(" ") && lastName.length() < 3) // if statement to ensure that the name is not a blank space
				{
					System.out.print("Wrong input... Please Enter student info in again!\n"); //prompts user to try again
					continue;
				}
				try 
				{
					double test = Double.parseDouble(lastName); // if the user input is just a number than will not go to catch block and loop continues
					System.out.print("Wrong input... Please Enter student info in again!\n"); //prompts user to try again
					input.nextLine();
					continue;
				
				}
				catch(NumberFormatException nfe) // if a exception is thrown means the name is not just a number and the loop is exited
				{ 
				}
				
				//prompts user to enter email, then reads their input
				System.out.print("Enter emailID: ");
				this.emailID = input.next();
				if(emailID.contains(" ") && emailID.length() < 3) // if statement to ensure that the name is not a blank space
				{
					System.out.print("Wrong input... Please Enter student info in again!\n"); //prompts user to try again
					continue;
				}
				try 
				{
					double test = Double.parseDouble(emailID); // if the user input is just a number than will not go to catch block and loop continues
					System.out.print("Wrong input... Please Enter student info in again!\n"); //prompts user to try again
					input.nextLine();
					continue;
				
				}
				catch(NumberFormatException nfe) // if a exception is thrown means the name is not just a number and the loop is exited
				{ 
				}
				//prompts user to enter phone number, then reads their input
				System.out.print("Enter phone number: ");
				this.phoneNumber = input.nextLong();
				if(phoneNumber < 1) // if the phone number is less than 0, outputs message to try again, loop goes back to begining 
				{
					System.out.print("Phone number must not be less than zero, Please Enter student info in again!\n");
					input.nextLine();
					continue;
				}
				readMarks(input); //  calls the readMarks method and passes the scanner input through it 
				control = false; // exits the loop
			}
			catch(InputMismatchException ime) // if a input mismatch exception happens, catch it, output error message and go back to start of loop
			{
				System.err.print("\nInput Mismatch Exception while reading Student info, enter Student info in again\n");
				input.nextLine(); //moves scanner off the current line
				continue; // goes back to the beginning of the loop
			}
		}
		
		
	}
	
	/** this method's purpose is to read the marks about the Student through inputs
	 * from the user, the marks are then added to an array and at the end of this method
	 * makes a call to the calculateGpa method  
	 * 
	 * @param input Scanner to read marks
	 * */
	private void readMarks(Scanner input)
	{
		int num =0;
		boolean control = true; //  boolean to control the while loop
		ArrayList<Double> marks = new ArrayList(); // creates an array list called marks 
		while(control) // while loop to ensure proper data is entered, if bad data is entered loop continues and prompts user to try again 
		{
			try {
				System.out.print("Enter number of courses: "); // prompts user to enter number of courses
				num = input.nextInt();	// grabs user input and sets it equal to num 
				if(num < 1)
				{
					System.out.print("Number of courses should be postive... Please try again!\n");
					continue;
				}
				marks = new ArrayList(num); // sets the size of the array marks equal to num
			}
			catch(InputMismatchException ife) // if an integer is not entered output error message, go to start of loop
			{
				System.err.print("Input Mismatch Exception while reading number of courses\n");
				input.next();
				continue;
			}
			int i =0;
			double markTemp = 0;
			while(i < num) // array that cycles through each element of the array and prompts the user to enter a mark 
			{
				try {
				System.out.printf("Enter mark %d: ", 1+i); // prompts user to enter mark number
				markTemp = input.nextDouble(); // grabs the number that was entered and sets it equal to the new double called markTemp
				if(markTemp > 100 || markTemp < 0) // if the user enters a mark above 100 or below 0, will output error message 
				{
					System.out.print("Input wrong... Mark must be between 0 - 100, Please try again!\n");
				}
				else // if the mark is in between 0 - 100, will be added to the array list and increments the loop control variable
				{
					marks.add(markTemp); // adds the mark to the array list
					i++;
				}
				}
				catch(InputMismatchException ife) // if the user entered something other than a double will throw an error 
				{
					System.err.print("Input Mismatch Exception while reading marks\n");
					input.next(); //moves scanner off the current line
					continue; // goes back to the beginning of the loop
				}
			
			}
			control = false; /// exits the loop
		}
		calculateGpa(marks); // calls calculateGpa and passes the array list marks through it 
	}
	
	/** This method's purpose is to print the info of the student out to the console in a formatted way */
	@Override
	public void printInfo() {
		
		System.out.printf("    %3s| %10d | %15s | %15s | %15d | %5.2f |", programName, studentNumber, 
				String.join( " ", firstName, lastName), emailID, phoneNumber, gpa); // formatted print statement that displays student info
		
	}

}
