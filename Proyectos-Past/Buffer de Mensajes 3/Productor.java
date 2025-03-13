/**
 * Clase Productor: Esta clase representa el hilo que se encarga de producir
 * elementos y colocarlos en un buffer. El buffer es compartido con un
 * consumidor que se encarga de extraer los elementos del buffer y procesarlos.
 */

class Productor extends Thread {
    private final Buffer buffer;
    private final int id;

    public Productor(Buffer b, int n) {
        buffer = b;
        this.id = n;
    }

    /**
     * El metodo run() es el que se encarga de producir los elementos y
     * colocarlos en el buffer. El productor produce 25 elementos que van
     * desde el 1 hasta el 25. Despues de cada produccion, el productor
     * duerme un tiempo aleatorio entre 0 y 700 milisegundos.
     */
    @Override
    public void run() {
        for (int i = 1; i <= 25; i++) {
            System.out.println("\n Productor " + this.id + " | Pone: " + i);
            buffer.escribe(i);
            try {
                sleep((int) (Math.random() * 700));
            } catch (InterruptedException e) {
                System.out.println("Interrupcion del hilo...");
            }
        }
    }
}