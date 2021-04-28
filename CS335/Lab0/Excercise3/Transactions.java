package atm;
import javax.swing.JOptionPane;
/**
*This class gives us commands to use onto the Bank Account detail.
*It includes 2 methods for Bank depositing and Bank withdrawal
*@author Manu Lam
*@version 1.0
*@since 07 Feb 2016
*/
public class Transactions
{	
	/**
	*Variables for different dialogs
	*/
	public int answer1, answer2, amount;
	
	/**
	*withdrawOK if user has enough in their bank account
	*/
	public boolean withdrawOK = true;
	/**
	*Constructs a 
	*/	
	public BankAccount ba;
	
	/**
	*Default details for our bank account once created with 1000 amount
	*/
	public Transactions() {
    	answer1 = 0;
    	answer2 = 0;
    	amount = 0;
    	ba = new BankAccount(1000);

    }
    
	/**
	*Main method asks user if they wanted to withdraw money or deposit
	*Then asks the user to input a value 
	*then displays the bank account amount after transaction
	*/
	public static void main(String[] args)	{
	  Transactions transaction = new Transactions();
	  transaction.getInput();
	  System.exit(0);
		  
	  }

	/**
	*Takes in an input for option to Deposit money or Withdraw money
	*/
   public void getInput() {	   
	   answer1 = JOptionPane.showConfirmDialog(null,
	                "Make a Depoist?", null, JOptionPane.YES_NO_OPTION);
	   
		/**
		*If yes to deposit, user enters amount for deposit
		*then displays bank details
		*/
	   
	   if (answer1 == JOptionPane.YES_OPTION){
	    	  String depString =
	    		         JOptionPane.showInputDialog(
	    		                               "Enter amount:");
	    	  amount = Integer.parseInt(depString);
	    	 
	    	  ba.deposit(amount);
	    	
	    		     
	      }
	 
		/**
		*If no to deposit, asks user if withdrawal is needed
		*/ 
	   else if (answer1 == JOptionPane.NO_OPTION){
		   answer2 = JOptionPane.showConfirmDialog(null,
	                "Make a Withdraw?", null, JOptionPane.YES_NO_OPTION);
		
		/**
			*If yes to withdrawal, asks user for withdrawal amount
		*/ 
		   if (answer2 == JOptionPane.YES_OPTION){
		    	  String withString =
		    		         JOptionPane.showInputDialog(
		    		                               "Enter amount:");
		    	  amount = Integer.parseInt(withString);
		    	  
		    	  ba.withdraw(amount);  
		   }
	   }
	   
		/**
		*If withdrawOK is not possible, it will tell the user that not enough money is seen
		*/ 
	   if (!withdrawOK)
		   JOptionPane.showMessageDialog(
			         null, "Your Balance  = " + ba.getBalance()+ " which is not enough for this withdraw ");
		/**
		*If withdrawOK is possible, it will give the bank amount detail
		*/ 
	   else
		   JOptionPane.showMessageDialog( 
				     null, " Your balance is " + ba.getBalance());
      }
   
}