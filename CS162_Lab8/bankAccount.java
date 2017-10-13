public class bankAccount {
String accountHolder;
double balance;
static int accountID = 100001;


    public bankAccount(String a, int b) {
    	this.setBalance();
    	accountHolder = a;
    	balance = b;
    	accountID++;


    }

    public void setBalance(){
    	if(this.balance<=0) {
    		this.balance = 1;
    	}
    }

    public String getAccountHolder() {
    	return this.accountHolder;
    }

    public void setAccountHolder(String a) {
    	this.accountHolder = a;
    }

    public double getBalance() {
    	return this.balance;
    }

    public void setBalance(double a){
    	if(this.balance<=0) {
    		this.balance = 1;
    	}
    	this.balance = a;
    }

    public void deposit(double a) {
    	this.balance += a;
    }

    public void withdrawal(double a) {
    	if(this.balance>a) {
    	this.balance -= a;
    	}
    }

    public void print() {
    	System.out.println("Name: "+this.accountHolder+"\n\nBalance: "+this.balance+"\n\nAccount ID: "+this.accountID);
    }

}