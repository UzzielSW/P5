/**
 * @(#)Prioridades.java
 *
 *
 * @author
 * @version 1.00 2010/8/29
 */

public class Prioridades {

	public static Animal tortuga;
	public static Animal liebre;
	public static Animal guepardo;

    /**
     * Creates a new instance of <code>Prioridades</code>.
     */
    public Prioridades() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        tortuga = new Animal(1, "T");
        liebre  = new Animal(5, "L");
        guepardo = new Animal(10,"G");

        tortuga.start();
        liebre.start();
        guepardo.start();

    }
}
