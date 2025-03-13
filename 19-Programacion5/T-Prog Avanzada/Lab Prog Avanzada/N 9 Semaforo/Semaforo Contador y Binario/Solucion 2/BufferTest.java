/**
 * @(#)BufferTest.java
 *
 *
 * @author
 * @version 1.00 2010/10/5
 */

//Programa que implementa un buffer de mensajes:

/******************************************************************************

Clase BufferTest

Creamos un hilo productor y otro consumidor que comparten

el recurso compartido de tipo buffer de mensajes Buffer.
Utilizamos semáforos con contador.

******************************************************************************/

import java.util.concurrent.*;

public class BufferTest {

         public static void main(String[] args) {

                 Buffer buf = new Buffer();

                 Semaphore sbPone = new Semaphore(10);
                 Semaphore sbCoge = new Semaphore(0);

                 Productor p1 = new Productor(buf, 1, sbPone,sbCoge);

                 Consumidor c1 = new Consumidor(buf, 1, sbPone, sbCoge);

                 p1.start();

                 c1.start();

         }

}








