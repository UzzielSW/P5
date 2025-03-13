/**
 * @(#)DosThreadDemo1.java
 *
 *
 * @author
 * @version 1.00 2010/8/29
 */

public class DosThreadRunnableDemo {

    /**
     * Creates a new instance of <code>DosThreadDemo1</code>.
     */
    public DosThreadRunnableDemo() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        SimpleThreadRunnable hilo1 = new SimpleThreadRunnable("Hilo1");
        SimpleThreadRunnable hilo2 = new SimpleThreadRunnable("Hilo2");

        Thread h1 = new Thread(hilo1);
        Thread h2 = new Thread(hilo2);

        h1.start();
        h2.start();


    }
}
