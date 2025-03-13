
import javax.swing.JTextArea;
public class Persona extends Thread {

    private Caja caja;
    private int id;
    JTextArea consola;

    public Persona(Caja caja, int id, JTextArea cls) {
        this.caja = caja;
        this.id = id;
        consola = cls;
    }

    @Override
    public void run() {
        int tiempo = 0;
        while (true) {
            synchronized (caja) {
                while (!caja.isNoTengo()) {
                    try {
                        consola.append("\nPersona: " + id + " is waiting...");
                        System.out.println("Persona: " + id + " is waiting...");
                        caja.wait(1000);
                    } catch (InterruptedException e) {
                    }
                    break;
                }
            }
            
            //produccion de papel
            if (caja.getCantCajaActual() != caja.getMaxCantCajas()) {
                try {
                    tiempo = (int) (Math.random() * 200 + 1);
                    Thread.sleep(tiempo);
                } catch (InterruptedException e) {}

                if (caja.getCantPapelActual() < caja.getCantMaxPapel() && caja.getCantCajaActual() != caja.getMaxCantCajas()) {
                    caja.setNoTengo(false);
                    synchronized (caja) {
                        addPapel();
                        consola.append("\nId: " + id + " Puso papel: " + caja.getCantPapelActual());
                        System.out.println("Id: " + id + " Puso papel: " + caja.getCantPapelActual());
                        caja.notifyAll();
                    }
                }
            } else //una ves completa la cantidad de cajas, termina el ciclo
                break;
        } //fin del while
    }

    public synchronized void addPapel() {
        caja.agregarPapel();
    }
}
