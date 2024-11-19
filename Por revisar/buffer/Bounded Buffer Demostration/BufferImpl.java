/*
 * BufferImpl.java
 *@author  j.n.magee 20/04/98
*
* Modificado por Prof. Álvaro Pino N.
 * Fecha: 19/09/2021
*/


//package concurrency.buffer;

/*********************BUFFERImpl*****************************/

public class BufferImpl implements Buffer {

    protected Object[] buf;
    protected int in = 0;
    protected int out= 0;
    protected int count= 0;
    protected int size;

    public BufferImpl(int size) {
        this.size = size;
        buf = new Object[size];
    }

    public synchronized void put(Object o) throws InterruptedException {
        while (count==size) wait();
        buf[in] = o;
        ++count;
        in=(in+1) % size;
        notify();
    }

    public synchronized Object get() throws InterruptedException {
        while (count==0) wait();
        Object o =buf[out];
        buf[out]=null;
        --count;
        out=(out+1) % size;
        notify();
        return (o);
    }
}
