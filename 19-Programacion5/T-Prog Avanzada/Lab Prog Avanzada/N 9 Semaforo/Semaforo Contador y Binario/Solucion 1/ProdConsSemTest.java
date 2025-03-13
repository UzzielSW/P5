/**
 * @(#)ProdConsSemTest.java
 *
 * Creamos un hilo productor y otro consumidor que comparten el
 * recurso compartido VarComp.
 * Utilizamos semáforos Binarios.
 * C:\Documents and Settings\Administrador\Mis documentos\Java 2010\Thread\
 * Sitios Concurrencia\N 9\Semaforo Contador y Binario\Solucion
 *
 * @author
 * @version 1.00 2010/10/7
 */

import java.util.concurrent.*;

public class ProdConsSemTest {

    /**
     * Creates a new instance of <code>ProdConsSemTest</code>.
     */
    public ProdConsSemTest() {
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        VarComp vc = new VarComp();

        Semaphore sbPone = new Semaphore(1);
        Semaphore sbCoge = new Semaphore(0);

        Productor  p1  = new Productor(vc, 1, sbPone, sbCoge);
        Consumidor c1 = new Consumidor(vc, 1, sbPone, sbCoge);

        p1.start();
        c1.start();
    }
}
