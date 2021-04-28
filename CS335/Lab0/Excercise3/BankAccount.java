package atm;
/**
*This class gives us details in our Bank Account.
*It includes 2 methods that updates after a Bank deposit or Bank deposit
*@author Manu Lam
*@version 1.0
*@since 07 Feb 2016
*/
public class BankAccount {

    private double balance;

	//Constructors
	public BankAccount()	{
		balance = 0;
	}
	
	public BankAccount(double initialBalance)	{
		balance = initialBalance;
	}
	
	// Methods
	public void deposit(double amount)	{      
		balance += amount; 
	    }
	
	public boolean withdraw(double amount)    { 
		if (balance>= amount)	{
			balance = balance - amount;
			return true;
			}
		else	return false;
        
    } 
	
	public double getBalance() { 
		return balance;
	}
	
}
