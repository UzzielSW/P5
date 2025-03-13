class Productor extends Thread {

    private Buffer buffer;
    private int num;
    private boolean suspendido = false;

    public Productor(Buffer b, int n) {
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

    public synchronized void iniciar() {
        buffer = null;
    }

    public synchronized void parar() {
        System.gc();
    }

    public void run() {
        for (int i = 1; i <= 25; i++) {
            // si suspendemos el hilo...
            try {
                synchronized (this) {
                    while (suspendido) {
                        wait();
                    }
                }
            } catch (InterruptedException e) {
            }

            // escribimos...
            if (buffer != null) {
                buffer.escribe(i);
                BufferFrame.textpro.setText(" - Productor " + this.num
                        + " pone: " + i);
            } else {
                parar();
                break;
            }

            try {
                sleep((int) (Math.random() * 700));
            } catch (InterruptedException e) {
            }
        }

        BufferFrame.suspenderBoton.setEnabled(false);
    }
}
