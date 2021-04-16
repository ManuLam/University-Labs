public class ReadersWritersSimulation {
	public static void main (String args[]) {
		DataAccessPolicyManager2 lockManager = new DataAccessPolicyManager2();
		Reader r1 = new Reader(lockManager, 1);
		Reader r2 = new Reader(lockManager, 2);
		Writer w1 = new Writer(lockManager, 2);

		r1.start();
		r2.start();
		w1.start();
		}	
		
}
