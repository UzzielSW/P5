/*
@author  j.n.magee 14/11/96
*/
/*
Modificado por Prof. Álvaro Pino N.
 * Fecha: 19/09/2021
*/
//package concurrency.buffer;

//import concurrency.display.*;

/********************CONSUMER*******************************/

class Consumer implements Runnable {

    Buffer buf;

    Consumer(Buffer b) {buf = b;}

    public void run() {
      try {
        while(true) {
            ThreadPanel.rotate(180);
            Character c = (Character)buf.get();
            ThreadPanel.rotate(180);
        }
      } catch(InterruptedException e ){}
    }
}
