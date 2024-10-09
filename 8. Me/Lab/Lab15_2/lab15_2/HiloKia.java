import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class HiloKia implements Runnable {

    JProgressBar barraKia;
    int i;
    public static boolean finalizado = false;
    JTextField message;
    JButton inicio;
    
    public HiloKia(JProgressBar barraKia, JTextField m, JButton i) {
        this.barraKia = barraKia;
        message = m;
        this.inicio = i;
    }

    @Override
    public void run() {
        for (i = 0; i <= 100; i++) {
            if (finalizado == true) {
                break;
            }
            barraKia.setValue(i);
            System.out.println("proceso" + Thread.currentThread().getName() + "ejecutandose");
            
            int time = (int) (Math.random() * 300);
            try {
                Thread.sleep(time);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloToyota.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (barraKia.getValue() == 100) {
            Ventana.posicion++;
            message.setText("Kia #" + Ventana.posicion);
            barraKia.setForeground(Color.GREEN);
            if(Ventana.posicion == 3) inicio.setEnabled(true);
        }else{
            barraKia.setForeground(Color.BLACK);
            barraKia.setValue(0);
        }

        finalizado = false;
        System.out.println("proceso" + Thread.currentThread().getName() + "finalizado");
    }
}
