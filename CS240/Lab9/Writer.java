public class Writer extends Thread {
DataAccessPolicyManager2 lockManager;
int id;

	public Writer (DataAccessPolicyManager2 lockManager, int id) {
		this.lockManager = lockManager;
		this.id = id; 
	}

	public void run() {

		while (true) {
			try {
				sleep ((int)(Math.random()*50));
			} catch (InterruptedException e) {}

			System.out.println("Writer " + id + " has been aquired");
			lockManager.acquireWriteLock();

			try {
				sleep ((int)(Math.random()*50));
			} catch (InterruptedException e) {}	

			System.out.println("Writer " + id + " has been released");
			lockManager.releaseWriteLock();

		}

	}
}
