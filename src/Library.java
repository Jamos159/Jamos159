import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * The library class is responsible for handling all the functions a regular library would do
 * such as adding new users whether it be staff or members, signing out books for members using
 * their member ID, having books being returned and applying fee charges to members account if
 * they returned the books late and finally display a members book list or all the
 * members in the system. This class is also able to read new members and add them to the
 * system from files.
 * 
 * @author Jared Amos
 *
 */
public class Library {
	/**
	 * Represents the name of the library
	 */
	private String name;
	/**
	 * List of users in the library system
	 */
	private ArrayList<User> users = new ArrayList<User>();
	/**
	 * list of members in the library, ID will be the key and member object will correlate to the key(ID)
	 */
	private HashMap<Integer,Member> members = new HashMap<Integer,Member>();
	
	/**
	 * This is constructor for the the class and takes a input parameter of type string
	 * and sets the object class variable name equal to what was inputted.
	 * 
	 * @param name of the library
	 */
	public Library(String name)
	{
		this.name = name; // sets name of class to the input parameter
	}
	
	/**
	 * The purpose of this method is to read new users to the system and determine what type of user
	 * they are and all the info about them, if they are a member they will be added to the member
	 * hashmap and their ID will be used as the key
	 * 
	 * @param input Scanner to read inputs
	 */
	public void readUserInfo(Scanner input)
	{
		int choice; // to store users input choice
		boolean control = true; // boolean to control while loop
		while(control) // while loop to ensure proper inputs, if exception is thrown loop continues
		{
			input = new Scanner(System.in); // creates new scanner based on the one passed in
			try {
				System.out.print("\nWhat type of user are you adding\n1. Staff\n2. Member\nPlease input your choice: ");
				choice = input.nextInt(); // reads user choice for adding a user
				if(choice != 1 && choice != 2) // if the choice is not 1 or 2 outputs an error message informing the user to try again
				{
					System.out.print("Invalid input, choices are either a 1 for a staff addition or 2 for member\nPlease try again! \n");
					continue; // goes back to top of loop
				}
				if(choice==1) // if user entered a 1
				{
					Staff staff = new Staff(); // create new Staff object
					staff.readInfo(input); // read details of Staff object
					users.add(staff); // add the Staff object to the arraylist of Users
					control = false; // exit loop
				}
				else if(choice == 2) // if user entered 2
				{
					Member member = new Member(); // create new Member object
					member.readInfo(input); // read object info
					// if the user entered an ID that is already in hashmap output a message to try again
					if(members.containsKey(member.getID())) 
						
					{
						System.out.print("That ID is already in use please try again! ");
					}
					else
					{
						users.add(member); // add member object to array list of users
						members.put(member.getID(), member); // puts the member in the hashmap with the ID as the key
					}
					
					
					control = false; // exit loop
				}
					
		}
			catch(InputMismatchException ime) // if user entered the wrong type, exception caught, outputs error message
			{
				System.err.print("Input mismatch exception please try entering User info in again!\n");
			}
			
	
		}
	}
	
	/**
	 * The purpose of this method is to display a specific members list of books, User
	 * will be prompted to enter the ID of the members whose list they wish to see
	 * if the member has no books to display or the member does not exist outputs
	 * a message informing the user of that
	 * 
	 * @param input Scanner that will read inputs
	 */
	public void displayMemberBooks(Scanner input)
	{
		int testID = 0; // holds the ID from the user input
		boolean control = true; // boolean used to control while loop
		if(users.size() == 0) // if the array list has no members to display output a message
		{
			System.out.print("\nThere are no members in the library system");
		}
		else {
			while(control) // loop to control proper user input
			{
				input = new Scanner(System.in);
				try {
					// prompts for user input of member ID
					System.out.print("to view a members list of books please enter the ID of the member: ");
					testID = input.nextInt(); // reads ID input from User
					if(members.get(testID) == null) // if the ID is not in hashmap, output a message
					{
						System.out.print("That member ID is not in our system, please try again\n");
						control = false; // exit loop
					}
					else {
						members.get(testID).getBook(); // displays the books of that member
						System.out.print("\n");
						control = false; // exit loop
					}
				}
				catch(InputMismatchException ime) // if exception is caught, loop continues, outputs error message
				{
					System.err.print("Input mismatch exception, please try entering the member ID again!\n");
				}
			}
			
		}
	}
	
	/**
	 * The purpose of this method is to allow a member to sign a book out of the library system,
	 * the user will be prompted to enter the ID of the member whose is signing out the book,
	 * if the member already has 5 books signed then they cannot sign another one out, also
	 * if the member doesn't exist or the the library system has no members then a message will
	 * be displayed informing the user of that. The method will determine the type of book the 
	 * member is signing out and then create the proper object and call the right method
	 * 
	 * @param input Scanner that read inputs 
	 */
	public void bookSignOut(Scanner input)
	{
		boolean control = true; // boolean to control loop
		int testID = 0; // holds the member ID for input from the user
		if(users.size() == 0) // if there are no members in the array list, output a message
		{
			System.out.print("\nThere are no members in the library system\n");
		}
		else // if there are members asks for ID
		{
		while(control) // loop to ensure proper data input
		{
			input = new Scanner(System.in);
				try {
					// prompts user to enter ID of the member
					System.out.print("Please enter the ID of member who is signing out a book: ");
					testID = input.nextInt(); // reads ID from user input
					if(members.get(testID) == null) // if the ID is not in hashmap, output message
					{
						System.out.print("That member ID is not in our system, please try again\n");
						control = false; // exit loop
					}
					else {
						// shows options of novels to user, prompts them to enter which one they are signing out
						System.out.print("What type of novel is being checked out\n");
						System.out.print("1. Comic\n2. Fantasy\n3. History\n4. Science\n5. Biography\n");
						System.out.print("Please enter the number of the book being signed out: ");
						int choice = input.nextInt(); // reads user input
						
						// depending on the users input, will prompt and read details form user about the
						// book they are signing out, creates new object, adds object to members book list
						switch(choice)
						{
						case 1: // if users entered a 1, create comic, prompt user for details, read details, add book to member list
							Comic comic = new Comic();
							comic.readBookDetails(input);
							members.get(testID).addBook(comic);
							control = false; // exits loop
							break; // exits break statement
							
						case 2: // if users entered a 2, create Fantasy book, prompt user for details, read details, add book to member list
							Fantasy fan = new Fantasy();
							fan.readBookDetails(input);
							members.get(testID).addBook(fan);
							control = false; // exit loop
							break; // exit case statement
						case 3: // if users entered a 3, create History book, prompt user for details, read details, add book to member list
							History his = new History();
							his.readBookDetails(input);
							members.get(testID).addBook(his);
							control = false; // exit loop
							break;
						case 4: // if users entered a 4, create Science book, prompt user for details, read details, add book to member list
							Science sci = new Science();
							sci.readBookDetails(input);
							members.get(testID).addBook(sci);
							control = false; // exit loop
							break; // exit case statement
						case 5: // if users entered a 5, create Biography, prompt user for details, read details, add book to member list
							Biography bio = new Biography();
							bio.readBookDetails(input);
							members.get(testID).addBook(bio);
							control = false; // exit loop
							break; // exit case statement
						default: // if user entered anything but 1,2,3,4,5, outputs message for them to try again
							System.out.print("\nPlease enter a valid book choice, option are 1-5\n");
						}
						
						
					}
				}
				catch(InputMismatchException ime) // catches exception form improper input, outputs error message
				{
					System.err.print("\nInput mismatch exception, please try entering the sign out information again!\n");
				}
			}
		}
		
	}

	/**
	 * This method is responsible for when a member would like to return the book, asks the user
	 * to enter the member ID of the user who is returning a book, it then displays all the books
	 * that member has signed out and asks for the name of the book they returning, method will 
	 * check if it is past the due date and apply charges to their balance and then remove that book
	 * from the members list, if there are no members with that ID or no members in the system
	 * outputs a message informing the user of that
	 * 
	 * @param input Scanner to grab inputs
	 */
	public void bookSignIn(Scanner input)
	{
		boolean control = true; // boolean to control loop
		int testID = 0; // for member ID input
		if(users.size() == 0) // if there are no members, output message
		{
			System.out.print("\nThere are no members in the library system\n");
		}
		else
		{
			while(control) // while loop to ensure proper user input
			{
				input = new Scanner(System.in); //creates new scanner object from the passed through one
				try {
					System.out.print("Please enter the ID of member who is returning a book: ");
					testID = input.nextInt(); // reads the ID from the user input 
					if(members.get(testID) == null) // if there are no ID's in hashmap that match, output message
					{
						System.out.print("That member ID is not in our system, please try again\n");
						control = false; // exits loop
					}
					else if(members.get(testID).getList() == 0) // if the member has no books in there list of books, output message
					{
						System.out.print("This member has no books to return\n");
						control = false; // exits loop
						continue; // goes back to beginining of loop
					}
					else // if member exists and has books checked out, display books, and call the bookReturn method from member class
					{
						
						System.out.print("\nThese are the books that " + members.get(testID).getName() + " has singned out" );
						members.get(testID).getBook(); // displays books
						members.get(testID).bookReturn(input); // returns the book
						control = false; // exits loop
						
					}
					
				}
				catch(InputMismatchException ime) // if user entered a invalid input that throws exception, loop continues, output message
				{
					System.err.println("Input mismatch exception please enter the member ID again!/n");
				}
			}
		}
	}
	
	/**
	 * This method will display all the members and staff that are currently in the library system
	 * and their specific characteristics. If there are no members will output a message informing the
	 * user of that 
	 * 
	 */
	public void displayMembers()
	{
		if(users.size() > 0) // if there are users in the library system, display them
		{
			for(int i = 0; i < users.size(); i++) // iterates through the list of users
			{
				System.out.print("\n"); 
				users.get(i).printInfo(); // prints that users info 
			}
		}
		else // is there are no users in the list of users, display message
		{
			System.out.print("\nNo members to display \n");
		}
	}
	
	/**
	 * The purpose of this method is to open the file in src folder, if the file
	 * can be opened and read with no issues or exceptions the method returns true
	 * 
	 * @param input Scanner that will read the file
	 * @return true if file can be read, false if exceptions are thrown
	 */
	public boolean openFile(Scanner input)
	{
		try { // opens the file using a scanner 
			input = new Scanner(Paths.get("src\\users"));  // opens the students text file in the src folder using the a scanner
			return true; 
		}
		catch(FileNotFoundException ife) // if the file is not found or accessible catches the error and outputs an error message 
		{
			System.err.print("\nFile not found or file not accesible\n");
			return false;
		}
		catch(IOException ioe) 
		{
			System.err.print(ioe);
			return false;
		}
	}
	
	/**
	 * This method will read from the file in the src folder and add users to the library system
	 * based on the data in the file 
	 * 
	 * @param input Scanner that will read file info
	 */
	public void readFromFile(Scanner input)
	{
		try { // used to ensure file can be opened and read and that that the data in the file does not throw any errors 
			input = new Scanner(Paths.get("src\\users")); // opens file using scanner
			
			while(input.hasNext()) // while there is something to read in the file read the file info
			{
				// reads all the student info off of one line 
				String memberType = input.next();
				String fName = input.next();
				String lName = input.next();
				String email = input.next();
				long phoneNum = input.nextLong();
				if(memberType.contains("s")) // if the student type is a f creates a full time student object, using a constructor and adds it to array list
				{
					int staffID = input.nextInt();
					int floor = input.nextInt();
					String section = input.next();
					Staff staff = new Staff(fName, lName, email, phoneNum, staffID, floor, section);
					users.add(staff); //adds to array list
				}
				// if the student type is a p creates a part time student object, using a constructor and adds it to array list
				else if(memberType.contains("m"))
				{
					int ID = input.nextInt();
					int age = input.nextInt();
					int fees = input.nextInt();
					Member member = new Member(fName, lName, email, phoneNum, ID, age, fees);
					users.add(member); // adds to array list
					members.put(member.getID(), member);
					
				}
			
			}
			if(input != null) // if the input is not equal to null close it as it is no longer needed
			{
				input.close();
			}
		}
		catch(InputMismatchException ime) // catches any bad data from file and outputs an error message 
		{
			System.err.println("\nInput Mismatch Exception while reading from file\n");
		}
		catch(IOException ioe) // catches any fileIO errors and outputs the error message 
		{
			System.err.print(ioe);
		}
	}
	
	
}
