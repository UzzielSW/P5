/**
 * @(#)BufferTest.java
 *
 *
 * @author
 * @version 1.00 2010/10/5
 */

//Programa que implementa un buffer de mensajes:

/******************************************************************************
C:\Documents and Settings\Administrador\Mis documentos\Java 2010\Thread\
Sitios Concurrencia\N 8\Buffer de Mensajes
Clase BufferTest

Creamos un hilo productor y otro consumidor que comparten

el recurso compartido de tipo buffer de mensajes Buffer.

******************************************************************************/

public class BufferTest {

         public static void main(String[] args) {

                 Buffer buf = new Buffer();

                 Productor p1 = new Productor(buf, 1);

                 Consumidor c1 = new Consumidor(buf, 1);

                 p1.start();

                 c1.start();

         }

}








