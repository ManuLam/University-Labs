package cs265;

public class CS265_Lab_Week11_Order {

	public static String orderProcess(int quantity, Boolean credit_worthy, int inventory){
		String output;
		if ((quantity <= 1000) && (credit_worthy))
			if (quantity < inventory)
				output = "Accept order";
			else
				output = "Defer order";
		else
			output = "Reject order";
		return output;
	}
	
}