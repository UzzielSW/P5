class Consumidor extends Thread {

    private final Buffer buffer;
    private final int id;

    public Consumidor(Buffer b, int n) {
        buffer = b;
        this.id = n;
    }

    /**
     * El metodo run() es el que se encarga de consumir los elementos del
     * buffer. El consumidor consume 25 elementos que van desde el 1 hasta
     * el 25. Despues de cada consumo, el consumidor duerme un tiempo
     * aleatorio entre 0 y 1000 milisegundos.
     */
    public void run() {
        for (int i = 1; i <= 25; i++) {
            System.out.println("\n Consumidor " + this.id + " | Quito: " + buffer.lee());
            try {
                sleep((int) (Math.random() * 1000));
            } catch (InterruptedException e) {
                System.out.println("Interrupcion del hilo... ");
            }
        }
    }
}
