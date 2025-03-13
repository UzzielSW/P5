/**
 * @(#)SincSemTest2.java
 *
 *
 * @author
 * @version 1.00 2010/10/5
 */


/******************************************************************************
C:\Documents and Settings\Administrador\Mis documentos\Java 2010\Thread\
  Sitios Concurrencia\N 9\Semaforo Contador y Binario\Semaforo 2
Clase SincSemTest2

Creamos dos hilos y los sincronizamos mediante un semáforo binario.

******************************************************************************/

import java.util.concurrent.*;

public class SincSemTest2 {

    /**
     * @param args the command line arguments
     */

         public static void main(String[] args) {

           // TODO code application logic here
                 Semaphore sb = new Semaphore(0);

                 Hilo ha = new Hilo("A", sb);

                 Hilo hb = new Hilo("B", sb);

                 hb.start();

                 ha.start();

         }

}

