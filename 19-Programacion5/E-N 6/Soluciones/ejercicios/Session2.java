/**
 * @(#)Session2.java
 *
 *
 * @author
 * @version 1.00 2010/9/5
 */

public class Session2 {

    /**
     * Creates a new instance of <code>Session2</code>.
     */
    public Session2() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  throws InterruptedException{
        // TODO code application logic here

        HiloHijo hijo = new HiloHijo(5);
        hijo.start();
        hijo.join();

    }
}
