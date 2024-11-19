/*
 *  Semaphore.java
 *@author: j.n.magee 11/11/96
//package concurrency.semaphore;
*  Modificado por Prof. Álvaro Pino N.
 * Fecha: 19/09/2021
*/
/********************************************************/
//
// The Semaphore Class
// up() is the V operation
// down() is the P operation
//
public class Semaphore {

    private int value;

    public Semaphore (int initial) {
        value = initial;
    }

    synchronized public void up() {
        ++value;
        notifyAll();  // should be notify() but does not work in some browsers
    }

    synchronized public void down() throws InterruptedException {
        while (value==0) wait();
        --value;
    }
}

