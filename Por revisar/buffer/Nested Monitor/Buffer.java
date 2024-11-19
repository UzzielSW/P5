/*
 * Buffer.java
 *@author  j.n.magee 20/04/98
*
* Modificado por Prof. Álvaro Pino N.
 * Fecha: 19/09/2021
*/


//package concurrency.buffer;

public interface Buffer {
    public void put(Object o)
       throws InterruptedException; //put object into buffer
    public Object get()
       throws InterruptedException;       //get an object from buffer
}