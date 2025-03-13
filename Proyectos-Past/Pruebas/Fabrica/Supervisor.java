
public class Supervisor extends Thread {

    private Caja caja;
    private int id;
    private int i = 0;

    public Supervisor(Caja caja, int id) {
        this.caja = caja;
        this.id = id;
    }

    public void run() {
        int tiempo = 0;
        while (true) {
            synchronized (caja) {
                while (caja.isNoTengo()) {
                    if (caja.getCantCajaActual() != caja.getMaxCantCajas()) {
                        try {
                            System.out.println("Supervisor: " + id
                                    + " is waiting...");
                            caja.wait(100);
                        } catch (InterruptedException e) {
                        }
                    }
                    break;
                }
            } // end synchronized
            //Consumer try to take  the box
            try {
// System.out.println("Supervisor Verify if the box full");
                tiempo = (int) (Math.random() * 1 + 1);
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {
            }

            if (caja.getCantPapelActual() == caja.getCantMaxPapel()) {
                caja.setNoTengo(false);
                synchronized (caja) {
                    if (caja.getCantCajaActual() != caja.getMaxCantCajas()) {
                        quitarCaja();
                        System.out.println("Supervisor: " + id
                                + " Quita la Cajeta:" + caja.getCantCajaActual());
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
