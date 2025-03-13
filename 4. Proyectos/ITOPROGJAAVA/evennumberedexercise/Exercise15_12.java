public class Exercise15_12 {
  private PiggyBank bank = new PiggyBank();
  private Thread[] thread = new Thread[100];

  public static void main(String[] args) {
    Exercise15_12 test = new Exercise15_12();
    System.out.println("What is balance ? " +
      test.bank.getBalance());
  }

  public Exercise15_12() {
    ThreadGroup g = new ThreadGroup("group");
    boolean done = false;

    // Create and launch 100 threads
    for (int i=0; i<100; i++) {
      thread[i] = new Thread(g, new AddAPennyThread(), "t");
      thread[i].start();
    }

    // Check if all the threads are finished
    while(!done)
      if (g.activeCount() == 0)
        done = true;
  }


  // A thread for adding a penny to the piggy bank
  class AddAPennyThread extends Thread {
    public void run() {
      synchronized (bank) {
        int newBalance = bank.getBalance() + 1;

        try {
          Thread.sleep(5);
        }
        catch (InterruptedException ex) {
          System.out.println(ex);
        }

        bank.setBalance(newBalance);
      }
    }
  }
}