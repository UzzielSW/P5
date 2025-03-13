/**
 * @(#)SuspenderHilos.java
 *
 * Programa que crea 2 hilos de distinto tipo. El Hilo 1, comienza, duerme 5 segundos y termina.
 * El hilo 2 comienza y queda suspendido. SuspenderHilos espera a que termine el hilo 1 y entonces
 * reanuda la ejecución del hilo 2. Finalmente, SuspenderHilos espera a que el segundo hilo termine
 * antes de terminar también él.
 * @author
 * @version 1.00 2010/9/29
 */


public class SuspenderHilos {

    public SuspenderHilos() {
    }


    public static void main (String[] args) {

                 TipoHilo1 hilo1 = new TipoHilo1();

                 TipoHilo2 hilo2 = new TipoHilo2();

                 hilo1.start();

                 hilo2.start();



                 try {

                          System.out.println("Esperamos a que el hilo1 termine...");

                          hilo1.join();

                          System.out.println("Despertamos al hilo2...");

                          synchronized (hilo2) {

                                    hilo2.notify();

                          }

                          System.out.println("Esperamos a que el hilo2 termine...");

                          hilo2.join();

                 } catch (InterruptedException e) {

                          System.out.println("Interrupción del hilo....." );

                 }

                 System.out.println("Terminamos el programa...");

         }



}