
import javax.swing.JTextArea;


public class Supervisor extends Thread {

    private Caja caja;
    private int id;
    private int i = 0;
    JTextArea consola;

    public Supervisor(Caja caja, int id, JTextArea csl) {
        this.caja = caja;
        this.id = id;
        consola = csl;
    }

    public void run() {
        int tiempo = 0;
        while (true) {
            synchronized (caja) {
                while (caja.isNoTengo()) {
                    if (caja.getCantCajaActual() != caja.getMaxCantCajas()) {
                        try {
                            consola.append("\nSupervisor: " + id + " is waiting...");
                            System.out.println("Supervisor: " + id + " is waiting...");
                            caja.wait(100);
                        } catch (InterruptedException e) {
                        }
                    }
                    break;
                }
            }
            
            //El consumidor intenta tomar la caja.
            try {
                tiempo = (int) (Math.random() * 1 + 1);
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {}
            
            //Supervisor Verificar si la caja está llena
            if (caja.getCantPapelActual() == caja.getCantMaxPapel()) {
                caja.setNoTengo(false);
                synchronized (caja) {
                    if (caja.getCantCajaActual() != caja.getMaxCantCajas()) {
                        quitarCaja();
                        consola.append("\nSupervisor: " + id + " Quita la Cajeta:" + caja.getCantCajaActual());
                        System.out.println("Supervisor: " + id + " Quita la Cajeta:" + caja.getCantCajaActual());
                        caja.notifyAll();
                        caja.setNoTengo(true);
                    } else {
                        caja.notifyAll();
                        break;
                    }
                }
            }
        }
    }

    public synchronized void quitarCaja() {
        caja.setCantPapelActual(0);
        caja.setCantCajaActual(++i);
    }
}
