/**
 * @(#)Consumidor.java
 *
 *
 * @author
 * @version 1.00 2010/10/5
 */



/******************************************************************************

Clase Consumidor
C:\Documents and Settings\Administrador\Mis documentos\Java 2010\Thread\
Sitios Concurrencia\N 9\Semaforo Contador y Binario\Solucion
******************************************************************************/
import java.util.concurrent.*;

public class Consumidor extends Thread {

         private VarComp varc;

         private int num;

         private Semaphore sbPone;
         private Semaphore sbCoge;

         public Consumidor(VarComp p_vc, int p_num, Semaphore sb1, Semaphore sb2)
         	{

                 varc = p_vc;

                 this.num = p_num;

                 this.sbPone =sb1;
                 this.sbCoge = sb2;

         }

         public void run() {

                 int val = 0;

                 for (int i = 0; i < 10; i++)
                 	{
                 		try{
                           sbCoge.acquire();
                       }catch(InterruptedException e) {}


                          val = varc.get();

                          sbPone.release();

                          System.out.println("Consumidor "+this.num+" toma: "+val);

                          try {

                                    sleep((int)(Math.random() * 100));

                          } catch (InterruptedException e) {

                                    System.out.println("Interrupción del hilo..." );

                          }

                 }

         }

}



