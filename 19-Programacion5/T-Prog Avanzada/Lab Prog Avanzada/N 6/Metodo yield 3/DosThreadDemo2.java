/**
 * @(#)DosThreadDemo2.java
 *
 *
 * @author
 * @version 1.00 2010/8/29
 */

public class DosThreadDemo2 {

    /**
     * Creates a new instance of <code>DosThreadDemo1</code>.
     */
    public DosThreadDemo2() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        SimpleThread2 hilo1 = new SimpleThread2("Hilo1");
        SimpleThread2 hilo2 = new SimpleThread2("Hilo2");

        hilo1.start();
        hilo2.start();


    }
}
