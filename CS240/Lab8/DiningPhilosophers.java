// This is the file DiningPhilosophers.java
// Study the class Semaphore and the class Philosopher given below.
// A Semaphore object maintains a private integer which can only be accessed by the
// operations P and V. These are declared as synchronized which means the procedures
// (methods) execute indivisibly on the semaphore's value when they are invoked by
// different threads. The Philosopher class extends the Thread class and defines a new 
// run() method for it which is executed when the thread is started.
// Methods of the same name as the class in which they are defined are known as
// constructors. These are used to initialise instances of objects when they are first
// created.
// The class DiningPhilosophers contains the main program and this is where execution
// begins.

class DiningPhilosophers {
	public static void main(String args[]) {
		Semaphore chopSticks[];
		Philosopher workerThread[];

		// Create an array of five Semaphore Object Reference Handles
		chopSticks = new Semaphore[5];

		// Create five Binary Semaphore Objects and assign to the array
		for (int i=0; i<5; i++)
			chopSticks[i] = new Semaphore(1); // Semaphore initial value=1

		// Create an array of five Philosopher Thread Object Reference Handles
		workerThread = new Philosopher[5];

		// Create and initiate five Philosopher Thread Objects
		for (int i=0; i<5; i++) {
			workerThread[i] = new Philosopher(i, chopSticks);
			workerThread[i].start();
		}
	}
}





// The Philosopher class implements a run() method defining the behaviour of a Philosopher thread

class Philosopher extends Thread {
	private int myName;
	private Semaphore chopSticks[];
	//
	// This is the constructor function which is executed when a Philosopher
	// thread is first created
	//
	public Philosopher(int myName, Semaphore chopSticks[]) {
		this.myName = myName; // 'this' distinguishes the local private variable from the parameter
		this.chopSticks = chopSticks;
	}

	//
	// This is what each philosopher thread executes
	//
	public void run() {
		while (true) {
			System.out.println("Philosopher "+myName+" thinking.");
			try {
				sleep ((int)(Math.random()*20000));
			} catch (InterruptedException e) {}

			System.out.println("Philosopher "+myName+" hungry.");
			chopSticks[myName].acquire(); // Acquire left
			chopSticks[(myName+1)%5].acquire(); // Acquire right
			
			System.out.println("Philosopher "+myName+" eating.");
			try { // Simulate eating activity for a random time
				sleep ((int)(Math.random()*10000));
			} catch (InterruptedException e) {}

			chopSticks[myName].release(); // Release left
			chopSticks[(myName+1)%5].release(); // Release right
		}
	}
}
