/**
 * @(#)VerificaHilosNormales.java
 *
 *
 * @author
 * @version 1.00 2010/8/29
 */

/* Verificación de la existencia de thredas en toda aplicación Java
 * aunque nohayan sido creados explicitamente
 */

public class VerificaHilosNormales {

    /**
     * Creates a new instance of <code>VerificaHilosNormales</code>.
     */
    public VerificaHilosNormales() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        Thread hiloPrincipal = Thread.currentThread();

        System.out.println("----------------------------------------------");
        System.out.println(hiloPrincipal.getName());
        System.out.println(hiloPrincipal.toString());
        System.out.println(hiloPrincipal.activeCount());
        System.out.println("----------------------------------------------");
    }
}
