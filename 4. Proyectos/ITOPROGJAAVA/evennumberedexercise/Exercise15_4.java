// Exercise15_4.java: 100 threads, each adds 1 to a variable sum
import java.awt.*;

public class Exercise15_4 {
  private Integer sum = new Integer(0);
  private Thread[] thread = new Thread[1000];

  public static void main(String[] args) {
    Exercise15_4 test = new Exercise15_4();
    System.out.println("What is sum ? " + test.sum);
  }

  public Exercise15_4() {
    ThreadGroup g1 = new ThreadGroup("group");
    boolean done = false;

    for (int i=0; i<1000; i++) {
      thread[i] = new Thread(g1, new SumThread(), "t");
      thread[i].start();
    }

    while(!done)
      if (g1.activeCount() == 0)
        done = true;
  }

  class SumThread extends Thread {
    public void run() {
      int value = sum.intValue()+1;
      sum = new Integer(value);
    }
  }
}