// Exercise19_2.java: Use synchronized set to avoid exception
import java.util.*;

public class Exercise19_2 {
  Set hashSet =
    Collections.synchronizedSet(new HashSet());

  class Thread1 extends Thread {
    public void run() {
      for (int i=0; i<100; i++) {
        System.out.println("Thread 1");
        hashSet.add(new Integer(i));
        try { Thread.sleep(1000); } catch (Exception ex) {
          ex.printStackTrace();
        }
      }
    }
  }

  public void xMethod() {
    synchronized (this) {
      // method body
    }
  }

  class Thread2 extends Thread {
    public void run() {
      while (true) {
        System.out.println("Thread2");
        try { Thread.sleep(1000); } catch (Exception ex) {
          ex.printStackTrace();
        }

        synchronized (hashSet) { // Must synchronize it 
          Iterator iterator = hashSet.iterator();

          while (iterator.hasNext()) {
            System.out.println(iterator.next());
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    new Exercise19_2();
  }

  Exercise19_2() {
    Thread1 thread1 = new Thread1();
    Thread2 thread2 = new Thread2();
    thread1.start();
    thread2.start();
  }
}