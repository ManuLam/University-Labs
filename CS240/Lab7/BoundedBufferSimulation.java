public class BoundedBufferSimulation {
   public static void main (String args[]) {
      Buffer buffer = new Buffer();

      // Create one producer and one consumer process
      Thread producer1 = new Thread(new Producer(buffer, 1));
      Thread consumer1 = new Thread(new Consumer(buffer, 2));

      Thread producer2 = new Thread(new Producer(buffer, 3));
      Thread consumer2 = new Thread(new Consumer(buffer, 4));

      producer1.start();
      consumer1.start();
      producer2.start();
      consumer2.start();
   }
}

