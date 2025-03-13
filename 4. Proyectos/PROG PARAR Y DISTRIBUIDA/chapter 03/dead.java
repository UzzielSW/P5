class Deadlock implements Runnable {
  public static void main(String [] args) {
        Deadlock d1 = new Deadlock();
        Deadlock d2 = new Deadlock();
        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        d1.grabIt = d2;
        d2.grabIt = d1;
        t1.start();
        t2.start();
  }
  Deadlock grabIt;
  public synchronized void run() {
        try { 
        for(int i=0;i<15;i++){
          System.out.println("one " + i);
          grabIt.sync_method();
        Thread.sleep(200);} 
         } catch(InterruptedException e) { }
     }
  public synchronized void sync_method() {
        try {  for(int j=0;j<5;j++){
                System.out.println("two " + j);
        Thread.sleep(200);}} catch(InterruptedException e) { }
        System.out.println("in sync_method");
  }
}
