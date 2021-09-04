/**
 * This is the checking class which is a subclass of Account and inherits its methods and class variables
 * has a method that updates balance by subtracting the checking fees form the balance
 * 
 * @author Jared Amos
 * @version 1.0
 * @see Bank
 * @see Account
 * @see Savings 
 * 
 */
public class Checking extends Account{
	
	private double fees; // creates a class variable called fees 
	
	/**
	 * This is the default constructor which automatically sets the class variable fees to
	 * 13.50
	 */
	public Checking()
	{
		this.fees = 13.50; // sets the class variable fees to 13.50
	}


	/**
	 * The purpose of this method is subtract the accounts balance by the checking fees every time its called
	 */
	@Override
	public void updateBalance() {
		this.balance -= 13.50; // takes the balance of this account and subtracts 13.50 from it
		
	}

}
