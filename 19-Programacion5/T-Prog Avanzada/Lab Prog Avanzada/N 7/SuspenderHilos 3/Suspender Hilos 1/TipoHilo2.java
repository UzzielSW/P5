/**
 * @(#)TipoHilo2.java
 *
 *
 * @author
 * @version 1.00 2010/9/29
 */

/******************************************************************************

Clase TipoHilo2

Este hilo muestra dos mensajes iniciales:"Hilo2 empieza..." y "Hilo2 suspendido..."

y pasa al estado suspendido inmediatamente;

cuando reciba la notificación correspondiente,

imprime un último mensaje y termina su ejecución.

******************************************************************************/






class TipoHilo2 extends Thread {

         public synchronized void run() {

                 try {

                          System.out.println("  -- 2-- Hilo 2 empieza..." );

                          System.out.println("  -- 2-- Hilo 2 suspendido..." );

                          wait();

                          System.out.println("  -- 2-- Fin, Hilo 2." );

                 } catch (InterruptedException e) {

                          System.out.println("  -- 2-- Interrupción del hilo....." );                  }

         }

}





