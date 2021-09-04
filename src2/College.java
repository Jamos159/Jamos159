import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
/**
 * This is the College class it has 2 class variables a overloaded constructor and three methods.
 * The purpose of this class is to read the details of the college entered by the user, as well 
 * as read the details of students and create ParttimeStudent objects or FulltimeStudent and then add them
 * to an array, this class also print out the title and the student details in a formatted output
 * 
 * @author Jared Amos
 * @version 1.0
 *
 */

public class College {
	private String name; // class variable called name
	private ArrayList<Student> students = new ArrayList<Student>(); // creates a new arraylist that holds Student objects 
	
	/** This is the overloaded constructor for the class and uses the inputs from the user
	 * to set class variables equal to them
	 * 
	 * @param name the name of the college 
	 * @param num  the number of students at the college
	 * */
	public College(String name, int num)
	{
		this.name = name; //sets overloaded constructor input equal to the class variable 
		students = new ArrayList(num);
	}
	
	/** The purpose of this method printTitle() is to print out the title
	 * of the college and the columns for the student info  */
	public void printTitle()
	{
		if(students.size() > 0) // if the array list of students is not empty print the title and columns of the student info to be displayed 
		{
			for(int i=0; i<110; i++) // for loop to print stars in a line
			{
				System.out.print("*");
			}
			System.out.print("\n");
			for(int i =0; i<40; i++) // for loop to center the title of the bank when displayed by using spaces
			{
				System.out.print(" ");
			}
		System.out.print(name + " - List of Students\n"); //outputs name of college in a formatted way
		System.out.print("\n");
		for(int i=0; i<110; i++) // for loop to print stars in a line
		{
			System.out.print("*");
		}
		System.out.print("\n");
		System.out.printf("%3s| %10s | %15s | %15s | %15s | %5s | %10s | %5s| " , "Program" , 
				"Student#","Name", "Email", "Phone", "GPA", "Fees", "Credits"); // outputs the columns for the student characteristics
		}
		else // if the array list does not have any Students output a message telling the user that
		{
			System.out.print("\n####### No Students To Display ######\n");
		}
	}
	
	/** The purpose of this method is to read the students details by using for loops to ensure that
	 * every student has their details inputed and to make sure that the user is entering the proper
	 * inputs  
	 * 
	 * @param input Scanner to read user's input for student details
	 * */
	public void readStudentDetails(Scanner input)
	{
		
			System.out.print("1 - Fulltime student\n2 - Parttime student"); // prompts user to enter either a 1 or 2 for student type
			System.out.print("\nEnter student type: "); // prompts user to enter a student type
			boolean control = true; // boolean to control the while loop to ensure proper user input 
			while(control) // this while loop is to ensure the data entered by the user is valid, if bad data is entered loop continues until data is valid
			{
				try // try statement used to ensure an integer is entered for student type, catches any inpu mismatch exceptions
				{
						int choice = input.nextInt(); // creates int choice and sets it equal to the user input 
						while(choice != 1 && choice != 2) // while the user's choice is not 1 or 2 prompts the user to enter a 1 or a 2 until they do then exit loop
						{
							System.out.print("wrong student type"); 
							System.out.print("\n1 - Fulltime student\n2 - Parttime student");  // prompts user to enter the proper student type and the options
							System.out.print("\nEnter student type: ");
							choice = input.nextInt(); // grabs choice again from the user
						}
						if(choice == 1) // if the user entered 1 makes the student object a Full time student and adds it to the array list
						{
							FulltimeStudent ftStud = new FulltimeStudent(); // creates a full time student
							ftStud.readInfo(input); // reads all the info form the user about the full time student 
							students.add(ftStud); // adds the full time student to the array list
						}
						else{ // if user entered a 2 then the Student object at index i creates a new part time student at i
							ParttimeStudent ptStud = new ParttimeStudent(); // creates a part time student
							ptStud.readInfo(input); // reads all the info form the user about the part time student
							students.add(ptStud);
						}
						control = false; // exits the loop for reading student details
				}
				catch(InputMismatchException ife) // catches the exception of the user entering a value that is not an integer
				{
				 System.err.print("\nInput Mismatch Exception while reading student type"); // prints out error message
				 System.out.print("\n1 - Fulltime student\n2 - Parttime student");  // prompts user to enter the proper student type and the options
				 System.out.print("\nEnter student type: ");
				 input.next(); // moves the scanner of the previous input 
				}
			}
			
		
	}
	
	/** This is printStudentDetails method and its purpose is to use a for loop to print
	 * the details of every student by making calls to the parttimeStudent class
	 * or FulltimeStudent class */
	public void printStudentDetails()
	{
		if(students.size() > 0) // if the array list is not empty  print student details of Student objects in the array list
		{
			
		
			for(int i = 0; i < students.size(); i++) // for loop that goes through each student in the array and prints their info
			{
				System.out.print("\n");// cleans up the output
				students.get(i).printInfo(); // calls printInfo method which will display all student info in a formatted way
			
			}
		}
	}
	
	/** The purpose of this method is to open a file using a scanner, it will return true if no erros are caught and 
	 * will return false if errors are caught  
	 * 
	 * @param input Scanner to read user's input for student details
	 * @return boolean will return false if any errors are caught while opening the file, returns true if no errors are caught 
	 * */
	public boolean openFile(Scanner input)
	{
		try { // opens the file using a scanner 
			input = new Scanner(Paths.get("src\\students.txt"));  // opens the students text file in the src folder using the a scanner
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
	
	/** The purpose of this method is to read the file contents and create either a ParttimeStudent object or FulltimeStudent object 
	 * and then add it to the array list of students  
	 * 
	 * @param input Scanner to read user's input for student details
	 * */
	public void readFromFile(Scanner input)
	{
		try { // used to ensure file can be opened and read and that that the data in the file does not throw any errors 
			input = new Scanner(Paths.get("src\\students.txt")); // opens file using scanner
			
			while(input.hasNext()) // while there is something to read in the file read the file info
			{
				// reads all the student info off of one line 
				String StudentType = input.next();
				int studNum = input.nextInt();
				String fName = input.next();
				String lName = input.next();
				String email = input.next();
				long phoneNum = input.nextLong();
				String progName = input.next();
				double gpa = input.nextDouble();
				if(StudentType.contains("f")) // if the student type is a f creates a full time student object, using a constructor and adds it to array list
				{
					double tutionFees = input.nextDouble(); // reads the subclass specific instance variables 
					FulltimeStudent ftStud = new FulltimeStudent(studNum, fName, lName, email, phoneNum, progName, gpa,tutionFees);
					students.add(ftStud); //adds to array list
				}
				// if the student type is a p creates a part time student object, using a constructor and adds it to array list
				else if(StudentType.contains("p"))
				{
					double courseFees = input.nextDouble();  // reads the subclass specific instance variables 
					double credits = input.nextDouble();  // reads the subclass specific instance variables 
					ParttimeStudent ptStud = new ParttimeStudent(studNum, fName, lName, email, phoneNum, progName, gpa, courseFees, credits);
					students.add(ptStud); // adds to array list
					
				}
			
			}
			if(input != null) // if the input is not equal to null close it as it is no longer needed
			{
				input.close();
			}
		}
		catch(InputMismatchException ime) // catches any bad data from file and outputs an error message 
		{
			System.err.println("\nInput Mismatch Exception while reading from file");
		}
		catch(IOException ioe) // catches any fileIO errors and outputs the error message 
		{
			System.err.print(ioe);
		}
	}
}
