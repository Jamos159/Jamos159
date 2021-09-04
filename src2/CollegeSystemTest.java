import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This is the class that contains the main method for the project and this is where
 * all the code will be executed and run 
 * 
 * @author Jared Amos
 * @version 1.0
 * 
 * @see College
 * @see FulltimeStudent
 * @see ParttimeStudent
 * @see Policies
 * @see Student 
 * @see Person
 * 
 *
 */
public class CollegeSystemTest {
	
	private static Scanner input = new Scanner(System.in); // this is the Scanner that is used for the whole package
	private static int n; // this variable will be used to determine how many students the College system will have

	/** This is the main method for the project and the purpose is to make calls to the various different methods
	 * that will read info about the college and students from the user and then print those inputs in a formatted 
	 * way to console. This method will create a college system based on inputs from the users and will continually
	 * display a option menu for the user to either input student details from the keyboard, input from a file, 
	 * print details of all students or exit the program. 
	 * 
	 * @param args used for storing command line strings 
	 * */
	public static void main(String[] args) {
		boolean control = false;
		System.out.print("Enter name of College: "); // prompts user to enter college name
		String name = input.nextLine(); // sets string name equal to the user input
		while(control == false) // this while loop is used to ensure the user enters a proper name for the college, if a proper name is entered loop ends
		{
			if(name.contains(" ") && name.length() < 3) // if statement to ensure that the name is not a blank space
			{
				System.out.print("Wrong input... please try again!\nEnter the name of the College: "); //prompts user to try again
				name = input.nextLine(); // grabs the input again from the user
				continue; // goes back to the beginning of loop
			}
			// this try statement converts the user's input into a double, if it converts successfully, means the user entered  number for the name
			// and outputs a message telling them to try again, loop continues
			try 
			{
				double test = Double.parseDouble(name); // if the user input is just a number than will not go to catch block and loop continues
				System.out.print("Wrong input... please try again!\nEnter the name of the College: "); //prompts user to try again
				name = input.nextLine(); // grabs their input again
			
			}
			catch(NumberFormatException nfe) // if a exception is thrown means the name is not just a number and the loop is exited
			{
					control = true; // exits the loop
			
			}
		}
		while(control) // this while loop is to ensure the user is entering a integer for # of students at the college, if the input is valid loop ends
		{
			System.out.print("Enter number of students: "); // prompts user to enter number of students 
			try
			{
				n = input.nextInt(); // grabs the input of the  user and sets it equal to int n
				if( n < 1) // if the number entered is less than 1, user will be prompted to enter another value as that one was invalid 
				{
					System.out.print("Number of students should be postive... please try again!!\n");
				}
				else
				{
					control = false; // exits the loop
				}
			}
			catch(InputMismatchException ime) // if the user enters anything but a integer, they will be prompted to enter again
			{
				System.err.print("\nInput mismatch while trying to read number of students... please try again!!\n"); // prints out an error message
				input.next(); // moves scanner to next input to be scanned 
			}
		}
		
		College c1 = new College(name, n); // creates a new college object by passing name and n through as arguments 
		
		while(control == false) // prompts user to enter a integer by displaying their options and does different method calls depending on user choice
		{
			// prints options out to the user and prompts them to enter a integer
			System.out.print("1. Read students info from keyboard\n2. Read students info from file\n3. Print details of all students\n4. Exit");
			System.out.print("\nEnter your option: ");
			// this try statement is to ensure if the user enters anything but an integer that the program will not crash, but output an error message
			try {
				int choice = input.nextInt(); // grabs users input
				if(choice == 1) // if the choice is 1 then calls a College object method to read the student details from the user and adds it to an array list
				{
					c1.readStudentDetails(input); // calls the college method to grab the details of students
				}
				else if(choice == 2) // if the user enters a 2, opens the file to be read, reads the file and adds the students to the array list of students
				{
					c1.openFile(input); //opens file from the College Object method, will return true if no FileIO errors are thrown
					if(c1.openFile(input)) // if the file is opened and returns true read the file by call the College object method readFromFile
					{
					c1.readFromFile(input);
					}
				}
				else if(choice == 3) // if the user's choice is a three display the students in the array list of Student objects  
				{
					c1.printTitle(); // calls college method to print the title of the college
					c1.printStudentDetails(); // calls college method to print the info about students in a formatted output
					System.out.print("\n");
					System.out.print("\n");
					
				}
				else if(choice == 4) // if the user's choice is 4 exits the loop and ends the program 
				{
					control = true; // exits the loop
				}
				else // if the user enters an integer that is not 1,2,3 or 4 then output a message informing them to try again 
				{
					System.out.println("opt: " + choice + "\nInvalid Entry... Selection options 1-4... Please try again!");
				}
				
			}
			catch(InputMismatchException nfe) // catches an error if the user enters anything but an integer, prints out an error message
			{
				System.err.print("Input Mismatch exception while reading user's choice in main menu... Please try again!\n");
				input.next(); // moves the scanner to the next input to be read 
			}
		}
		System.out.print("Goodbye... Have a nice day!");
		input.close(); // closes scanner
	}

}
