/**
 * @(#)DosThreadDemo1.java
 *
 *
 * @author
 * @version 1.00 2010/8/29
 */

public class DosThreadDemo3 {

    /**
     * Creates a new instance of <code>DosThreadDemo1</code>.
     */
    public DosThreadDemo3() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        SimpleThread3 hilo1 = new SimpleThread3("Hilo1");
        SimpleThread3 hilo2 = new SimpleThread3("Hilo2");

        hilo1.start();
        hilo2.start();


    }
}
