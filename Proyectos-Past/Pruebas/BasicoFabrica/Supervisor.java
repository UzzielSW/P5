
import java.awt.TextArea;

public class Supervisor extends Thread {

    private Caja caja;
    private int cajasLlenas;
    private int cantCajas;
    private TextArea textArea;
    private int id;

    public Supervisor(Caja caja, int cantCajas, int papelCaja, TextArea textArea, int id) {
        this.caja = caja;
        this.cantCajas = cantCajas;
        this.id = id;
        this.textArea = textArea;
        caja.setCajas(cantCajas);
        caja.setPapelCaja(papelCaja);
    }

    @Override
    public void run() {
        while (true) {
            synchronized (caja) {
                if (caja.getcajasLlenas() < cantCajas) {
                    if (caja.getPapelActual() == caja.getPapelXcaja()) {

                        textArea.append("El supervisor tiene caja " + (caja.getcajasLlenas() + 1) + "\n");
                        caja.setCajasActuales(caja.getcajasLlenas() + 1);
                        caja.setPapelActual(0);

                        try {
                            sleep(600);
                        } catch (InterruptedException ex) {
                        }

                        caja.notifyAll();

                    } else {
                        textArea.append("Supervisor esperando caja " + (caja.getcajasLlenas() + 1) + "\n");
                        try {
                            caja.notifyAll();
                            caja.wait();
                        } catch (InterruptedException ex) {
                        }
                    }

                } else {
                    textArea.append("supervisor " + id + " tiene todas las cajas");
                    caja.notifyAll();
                    break;
                }
            }
        }
    }
}
