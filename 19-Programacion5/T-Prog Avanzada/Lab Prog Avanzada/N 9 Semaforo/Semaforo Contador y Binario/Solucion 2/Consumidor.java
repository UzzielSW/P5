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
Sitios Concurrencia\N 9\Semaforo Contador y Binario\Solucion 2
******************************************************************************/
import java.util.concurrent.*;

public class Consumidor extends Thread {

         private Buffer buffer;

         private int num;

         private Semaphore sbPone;
         private Semaphore sbCoge;

         public Consumidor(Buffer b, int n, Semaphore sb1, Semaphore sb2)
         	{

                 this.buffer= b;

                 this.num = n;

                 this.sbPone =sb1;
                 this.sbCoge = sb2;

         }

         public void run() {


                 for (int i = 0; i < 10; i++)
                 	{
                 		try{
                           sbCoge.acquire();
                       }catch(InterruptedException e) {}


                          int val = buffer.lee();

                          sbPone.release(); // SIGNAL

                          System.out.println(" --Consumidor "+this.num+" toma: "+val);

                          try {

                                    sleep((int)(Math.random() * 1000));

                          } catch (InterruptedException e) {

                                    System.out.println("Interrupción del hilo..." );

                          }

                 }

         }

}



