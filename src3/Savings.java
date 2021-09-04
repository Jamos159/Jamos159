/**
 * This is the savings class which is a subclass of the aqccounts class and inherits all of
 * its class variables, the main purpose of this class is to update the balance by adding 
 * interest to the balance of the account 
 * 
 * @author Jared Amos
 * @version 1.0
 * @see Bank
 * @see Account
 * @see Checking
 * 
 */
public class Savings extends Account {
	
	private double interestRate; // creates a class variable called interestRate
	
	/**
	 * This is the default constructor which automatically sets the class variable interest rate
	 * to 3.99 which is a yearly interest rate 
	 */
	public Savings()
	{
		this.interestRate = 3.99; // sets the interest rate to 3.99 when default constructor is called
	}
	
	/**
	 * The purpose of this class is to update the balance of the account by adding the monthly 
	 * interest rate to the balance 
	 */
	@Override
	public void updateBalance() {
		this.balance += (this.balance * ((this.interestRate/12)/100)); // adds the monthly interest onto the account balance
		
	}

}
