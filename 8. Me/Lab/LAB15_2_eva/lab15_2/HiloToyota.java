import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import JButton;
import JProgressBar;
import JTextField;

public class HiloToyota implements Runnable {

    JProgressBar barraToyota;
    int i;
    public static boolean finalizado = false;
    JTextField message;
    JButton inicio;

    public HiloToyota(JProgressBar barraToyota, JTextField m, JButton i) {
        this.barraToyota = barraToyota;
        this.message = m;
        this.inicio = i;
    }

    @Override
    public void run() {
        for (i = 0; i <= 100; i++) {

            if (finalizado == true) {
                break;
            }
            barraToyota.setValue(i);
            System.out.println("proceso" + Thread.currentThread().getName() + "ejecutandose");
            
            int time = (int) (Math.random() * 300);
            try {
                Thread.sleep(time);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloToyota.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (barraToyota.getValue() == 100) {
            Ventana.posicion++;
            message.setText("Toyota #" + Ventana.posicion);
            barraToyota.setForeground(Color.GREEN);
            if(Ventana.posicion == 3) inicio.setEnabled(true);
        }else
        {
            barraToyota.setForeground(Color.BLACK);
            barraToyota.setValue(0);
        }

        finalizado = false;
        System.out.println("proceso" + Thread.currentThread().getName() + "finalizado");
    }
}
