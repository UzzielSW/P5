/*   Producer.java
 * 
 *@author  j.n.magee 20/04/98
*
* Modificado por Prof. Álvaro Pino N.
 * Fecha: 19/09/2021
*/
//package concurrency.buffer;

//import concurrency.display.*;

/*******************PRODUCER************************/

class Producer implements Runnable {

    Buffer buf;
    String alphabet= "abcdefghijklmnopqrstuvwxyz";

    Producer(Buffer b) {buf = b;}

    public void run() {
      try {
        int ai = 0;
        while(true) {
            ThreadPanel.rotate(12);
            buf.put(new Character(alphabet.charAt(ai)));
            ai=(ai+1) % alphabet.length();
            ThreadPanel.rotate(348);
        }
      } catch (InterruptedException e){}
    }
}
