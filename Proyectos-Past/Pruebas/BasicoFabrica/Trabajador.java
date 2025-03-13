
import java.awt.TextArea;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Trabajador extends Thread {

    private Caja caja;
    private TextArea textArea;
    private int id = 0;

    public Trabajador(Caja caja, TextArea textArea, int id) {
        this.caja = caja;
        this.textArea = textArea;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (caja) {
                if (caja.getcajasLlenas() < caja.getCantCajas()) {
                    if (caja.getPapelActual() < caja.getPapelXcaja()) {

                        caja.setPapelActual(caja.getPapelActual() + 1);
                        textArea.append("trabajador " + (id + 1) + " llenando caja\n");

                        try {
                            sleep(600);
                        } catch (InterruptedException ex) {
                        }
                        caja.notifyAll();
                        try {
                            caja.wait();
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Trabajador.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        textArea.append("Trabajador " + (id + 1) + " avisa a supervisor\n");
                        caja.notifyAll();
                        try {
                            caja.wait();
                        } catch (InterruptedException ex) {
                        }

                    }

                } else {
                    textArea.append("Trabajador " + (id + 1) + " termino su trabajo \n");
                    break;
                }
            }
        }

    }

}