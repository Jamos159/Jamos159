import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This class is the drive class for the project and contains the main method that will
 * display the option menu and read the user inputs and call the appropriate method and create
 * proper objects 
 * 
 * @author Jared Amos
 *
 */
public class LibraryManagement {

	/**
	 * This is the scanner object that will be user for the project 
	 */
	private static Scanner input = new Scanner(System.in);
	
	/**
	 * This is the main method for the project and all the code will be executed here
	 * this method will display the option menu to the user and make the new library
	 * system and call the appropriate methods from the the users input
	 * 
	 * @param args String array for command
	 */
	public static void main(String[] args) {
		Library library = new Library(null); // creates a new library object
		String name = null; // will store the name for the library
		boolean control = false; // used to control the while loops
		boolean isNum = false; // boolean  to determine if the input library name is valid
		while(control == false) // this while loop will ensure a proper name is entered for the library
		{
			isNum = false;
			input = new Scanner(System.in); // creates new instance of scanner object every time loop iterates
			System.out.print("Please enter the name of the library: ");
			name = input.nextLine(); // reads the name of the library from the user
			for(int i = 0; i <= 10; i++) // for loop to iterate through the possible integers that must be caught 
			{
				String test = Integer.toString(i); // converts the integer of loop control variable to a string
				if(name.contains(test) || name.length() == 0 || (name.contains(" ") && name.length() < 3) ) // checks to see if the name entered contains a number or is just a space
				{
					isNum = true; // loop will continue until a valid input is entered
				}
			}
			if( isNum == false) // if a valid input is entered 
			{
				library = new Library(name); // create new library and pass through the input name
				
				control = true; // exit loop
			}
			else // if the name contained a number or was just a space , output a message 
			{
				System.out.print("Invalid input for library name, please try again! \n");
			}
		}
		System.out.println("Welcome to the " + name + " library System"); // output a welcome message
		while (control) // while loop to display the option menu and ensure proper inputs
		{
			input = new Scanner(System.in); // creates new instance of scanner
			try {
				// outputs the options to the user
				System.out.println("Here are your options");
				System.out.println("1. Add a user from keyboard\n2. Add users from file\n3. Display users\n4. Book sign out\n5. Book return\n"
						+ "6. Display a members book list\n7. Exit");
				int choice = input.nextInt(); // reads users choice
				if(choice > 7 || choice < 1) // they entered an integer but not one of the menu options, display message
				{
					System.out.print("Invalid input, menu options are 1-7, please try again!\n");
					continue; // goes back to the begining of loop
				}
				else // if the input was a valid integer 
				{
					switch(choice) {
					case 1: // if user entered 1, prompt user to enter new user info and then read info, create new user
						library.readUserInfo(input);
						break; // exits case statement
						
					case 2: // if user enters a 2, open the file, if file can be opened, read the file info, create new users from file info
						if(library.openFile(input)) // if the file can be opened 
						{
							library.readFromFile(input); // read from file, create new users
						}
						break;
						
					case 3: // if 3 entered, display all members of the library system
						System.out.print("\n"); // prints new line
						library.displayMembers(); // displays members
						System.out.print("\n");// prints new line
						break;
						
					case 4: // if 4 entered, calls book sign out method from library class, and signs a book out for a member
						library.bookSignOut(input); 
						break;
					
					case 5: // if 5 entered  call book sign in from library method, and signs a book back in for the member 
						library.bookSignIn(input);
						break;
						
					case 6: // if 6 entered, displays all a individual members books
						
						library.displayMemberBooks(input); 
						System.out.print("\n");
						break;
						
					case 7: // breaks the while loop, program ends after a farewell message
						System.out.println("Have a nice day!");
						control = false; // loop ends
						
						break;
					}
				}
				
				
			}
			catch(InputMismatchException ime) // if user entered a wrong input and exception is caught, displays message, loop continues
			{
				System.err.println("Input Mismatch Exception while reading user input, please enter an integer ");
			}
		}
		input.close(); // closes scanner
	}

}
