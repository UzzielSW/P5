/**
 * @(#)Sesion.java
 *
 *
 * @author
 * @version 1.00 2010/9/3
 */

public class Sesion {

    /**
     * Creates a new instance of <code>Sesion</code>.
     */
    public Sesion() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        ParesThread pares = new ParesThread("pares");
        ImparesThread impares = new ImparesThread("impares");
        Termina23Thread termina23  = new Termina23Thread("termina23");

        pares.start();
        impares.start();
        termina23.start();

    }
}
