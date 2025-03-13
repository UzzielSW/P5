/**
 * @(#)SemaphoreExample.java
 *
 *
 * @author 
 * @version 1.00 2015/11/24
 */      
   
import java.util.concurrent.locks.*;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {

      int i = 0;

public static void main (String[] args) {

final SemaphoreExample example = new SemaphoreExample();

final Semaphore semaphore = new Semaphore (1);

final Runnable r = new Runnable () {


public void run () {

     while (true) {

          try {

               semaphore.acquire();

               //Sección crítica a proteger 

               example.printSomething ();

               Thread.sleep (1000);

               semaphore.release();

              } catch (Exception ex) {

              System.out.println (" — Interrupted…");

              ex.printStackTrace ();

             }

          }

     }

  };  // fin dela linea 26

   new Thread (r).start ();

   new Thread (r).start ();

   new Thread (r).start ();

}







public void printSomething (){

      i++;

System.out.println (" — current value of the i :"+ i);

    }

} // fiin de la clase
