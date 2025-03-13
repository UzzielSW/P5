/**
 * @(#)Productor.java
 *
 *
 * @author
 * @version 1.00 2010/10/5
 */



/******************************************************************************

Clase Productor
C:\Documents and Settings\Administrador\Mis documentos\Java 2010\Thread\
Sitios Concurrencia\N 9\Semaforo Contador y Binario\Solucion
******************************************************************************/

import java.util.concurrent.*;

public class Productor extends Thread {

         private VarComp varc;

         private int num;

         private Semaphore sbPone;
         private Semaphore sbCoge;

         public Productor(VarComp p_vc, int p_num, Semaphore sb1, Semaphore sb2)
          {

                 this.varc = p_vc;
                 this.num = p_num;
                 this.sbPone =sb1;
                 this.sbCoge = sb2;

         }

         public void run() {

                 for (int i = 0; i < 10; i++)
                 	{
                       try{
                           sbPone.acquire();
                       }catch(InterruptedException e) {}

                          varc.put(i);

                          sbCoge.release();

                          System.out.println("Productor " + this.num + " pone: " + i);

                          try {

                                    sleep((int)(Math.random() * 100));

                          } catch (InterruptedException e) {

                                    System.out.println("Interrupción del hilo..." );

                          }

                 }

         }

}


