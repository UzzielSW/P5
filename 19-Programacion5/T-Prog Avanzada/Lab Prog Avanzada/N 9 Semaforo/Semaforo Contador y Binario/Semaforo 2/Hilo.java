/**
 * @(#)Hilo.java
 *
 *
 * @author
 * @version 1.00 2010/10/5
 */

/******************************************************************************
C:\Documents and Settings\Administrador\Mis documentos\Java 2010\Thread\
Sitios Concurrencia\N 9\Semaforo Contador y Binario\Semaforo 2
Clase Hilo

******************************************************************************/
import java.util.concurrent.*;

class Hilo extends Thread {

         Semaphore sb;

         Hilo(String nombre, Semaphore sb) {

                 super(nombre);

                 this.sb=sb;

         }

         public void run() {

                 if (getName().equals("B")) {

                          System.out.println(getName()+" - wait ");

                          try {sb.acquire();} catch (InterruptedException e){}

                 }

                 for (int i=1;i<=10;i++) {

                          System.out.println(getName()+" - contador: "+i);

                          yield();

                 }

                 System.out.println("Fin "+getName()+"...");

                 if (getName().equals("A")) {

                          System.out.println(getName()+" - signal ");

                          sb.release();                           //SIGNAL
                 }
         }
}


