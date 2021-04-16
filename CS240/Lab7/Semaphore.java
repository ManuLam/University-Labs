/* The Semaphore class below contains methods declared as 
synchronized. Java's locking mechanism will ensure that access
to its methods is mutually exclusive among threads that invoke these methods. Save the code in a file Semaphore.java */ 

class Semaphore { 
   private int value; 

   public Semaphore(int value) {  
      this.value = value; 
   }
 
   public synchronized void acquire() { 
      while (value == 0) {  
         try { 
             // Calling thread waits until semaphore is free 
             wait(); 
         } catch(InterruptedException e) {} 
      } 
   value = value - 1; 
   } 

   public synchronized void release() { 
      value = value + 1;
      notify(); 
   }
}

