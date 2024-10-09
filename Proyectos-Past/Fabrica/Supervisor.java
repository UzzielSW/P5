
import javax.swing.JTextArea;

public class Supervisor extends Thread {

    private Caja caja;
    private int id;
    private int i = 0;
    private JTextArea texto; //nuevo

    public Supervisor(Caja caja, int id, JTextArea texto) {
        this.caja = caja;
        this.id = id;
        this.texto = texto;
    }

    @Override
    public void run() {
        int tiempo;
        
        while (true) {
            synchronized (caja) {
                while (caja.isNoTengo()) {
                    if (caja.getCantCajaActual() != caja.getMaxCantCajas()) {
                        try {
                            texto.append("\nSupervisor: " + id + " is waiting...");//nuevo
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
                // System.out.println("Supervisor Verify if the box full");
                tiempo = (int) (Math.random() * 1 + 1);
                Thread.sleep(tiempo);
            } catch (InterruptedException e) {}
            
            //Supervisor Verificar si la caja está llena
            if (caja.getCantPapelActual() == caja.getCantMaxPapel()) {
                caja.setNoTengo(false);
                synchronized (caja) {
                    if (caja.getCantCajaActual() != caja.getMaxCantCajas()) {
                        quitarCaja();
                        texto.append("\nSupervisor: " + id + " Quita la Cajeta:" + caja.getCantCajaActual());//nuevo
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
