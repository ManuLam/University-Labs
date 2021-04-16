public class Reader extends Thread {
DataAccessPolicyManager2 lockManager;
int id;

	public Reader (DataAccessPolicyManager2 lockManager, int id) {
		this.lockManager = lockManager;
		this.id = id;
	}

	public void run() {

		while (true) {
			try {
				sleep ((int)(Math.random()*50));
			} catch (InterruptedException e) {}

			System.out.println("Reader " + id + " has been aquired");
			lockManager.acquireReadLock();

			try {
				sleep ((int)(Math.random()*50));
			} catch (InterruptedException e) {}	

			System.out.println("Reader " + id + " has been released");
			lockManager.releaseReadLock();

		}
		
	}
}
