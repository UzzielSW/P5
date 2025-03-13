/**
 * @(#)ThreadJoinDemo2.java
 *
 *
 * @author
 * @version 1.00 2010/8/29
 */

public class ThreadJoinDemo2 {

    /**
     * Creates a new instance of <code>DosThreadDemo1</code>.
     */
    public ThreadJoinDemo2() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        System.out.println("Inicio - Main");

        ThreadJoin1 hilo1 = new ThreadJoin1("Hilo1");


        try{
    	     	hilo1.join();
                System.out.println( "Fin - Main   ");
        }catch(InterruptedException e){}

    }
}
