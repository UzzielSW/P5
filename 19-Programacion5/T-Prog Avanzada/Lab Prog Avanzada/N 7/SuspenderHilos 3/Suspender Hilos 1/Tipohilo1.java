/**
 * @(#)Tipohilo1.java
 *
 *
 * @author
 * @version 1.00 2010/9/29
 */
 /******************************************************************************

Clase TipoHilo1

Este hilo s�lamente espera en estado dormido durante 5 segundos y a continuaci�n

imprime un mensaje indicando que ha terminado

******************************************************************************/



class TipoHilo1 extends Thread {

         public void run() {

                 System.out.println("  -- 1-- Hilo 1 empieza..." );

                 try {

                          sleep(5000);

                 } catch (InterruptedException e) {

                          System.out.println("  -- 1-- Interrupci�n del hilo....." );

                 }

                 System.out.println("  -- 1-- Fin, Hilo 1." );

         }

}




