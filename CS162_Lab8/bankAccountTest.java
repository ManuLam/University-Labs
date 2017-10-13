public class bankAccountTest {
public static void main(String[]args){
	bankAccount b1 = new bankAccount("Mary Bloggs",500);
	bankAccount b2 = new bankAccount("Joe Spot",1000);

	System.out.println("Balance is "+ b1.getBalance());
	b2.print();



    }
}