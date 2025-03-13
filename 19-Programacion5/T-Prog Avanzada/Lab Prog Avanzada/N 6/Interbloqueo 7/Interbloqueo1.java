/**
 * @(#)Interbloqueo1.java
 *
 *
 * @author
 * @version 1.00 2010/8/29
 */

/* Problema del Interbloqueo de threads con el método join():
 * En este ejemplo, el thread t1 espera a que termine t2 para continuar ejecutando,
 * pero éste a su vez tiene que esperar a que termine t1.
 * Se produce un "Abrazo Mortal" (deadlock) o interbloqueo.
 *Observar con el administrador de tareas , que no consumen CPU.
 **/

public class Interbloqueo1 {

    public static Thread1 t1 = new Thread1("uno");
    public static Thread1 t2 = new Thread1("dos");

    public static void main(String [] args)
    {
    	t1.espera(t2);
    	t2.espera(t1);

    	t1.start();
    	t2.start();

    	System.out.println("Fin del Programa Principal");
    }

}