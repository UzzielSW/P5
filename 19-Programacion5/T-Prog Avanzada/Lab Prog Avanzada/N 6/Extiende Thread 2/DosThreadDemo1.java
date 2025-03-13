/**
 * @(#)DosThreadDemo1.java
 *
 *
 * @author
 * @version 1.00 2010/8/29
 */

public class DosThreadDemo1 {

    /**
     * Creates a new instance of <code>DosThreadDemo1</code>.
     */
    public DosThreadDemo1() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        SimpleThread1 hilo1 = new SimpleThread1("Hilo1");
        SimpleThread1 hilo2 = new SimpleThread1("Hilo2");

        hilo1.start();
        hilo2.start();


    }
}
