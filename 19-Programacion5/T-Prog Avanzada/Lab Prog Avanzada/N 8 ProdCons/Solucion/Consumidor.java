
/**
 * @(#)Consumidor.java
 *
 * Modificado por Prof. Alvaro Pino N.
 *  18/10/2010
 * @author
 * @version 1.00 2010/10/5
 */
/** *************************************************
 * Clase Consumidor
 *************************************************** */
class Consumidor extends Thread {

    private Buffer buffer;
    private int num;
    private boolean suspendido = false;

    public Consumidor(Buffer b, int n) {
        buffer = b;
        this.num = n;
    }

    public void suspender() {
        suspendido = true;
    }

    public synchronized void reanudar() {
        suspendido = false;
        notify();
    }

    public void iniciar() {
        buffer = null;
    }

    public synchronized void parar() {
        System.gc();
    }

    public void run() {
        for (int i = 1; i <= 25; i++) {
            //si suspendemos el hilo...
            try {
                sleep(100);
                synchronized (this) {
                    while (suspendido) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
            }

            //leemos...
            if (buffer != null) {
                int val = buffer.lee();
                BufferFrame.textcon.setText(" - Consumidor " + this.num
                        + " toma: " + val);
            } else {

                parar();
                break;
            }

            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
            }
        }

        BufferFrame.reanudarBoton.setEnabled(false);
    }
}
