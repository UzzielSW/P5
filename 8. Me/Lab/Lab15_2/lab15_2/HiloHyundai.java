import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JProgressBar;
import javax.swing.JTextField;


public class HiloHyundai implements Runnable {

    JProgressBar barraHyundai;
    int i;
    public static boolean finalizado = false;
    JTextField message;
    JButton inicio;

    public HiloHyundai(JProgressBar barraHyundai, JTextField m, JButton i) {
        this.barraHyundai = barraHyundai;
        this.message = m;
        this.inicio = i;
    }

    @Override
    public void run() {
        for (i = 0; i <= 100; i++) {
            if (finalizado == true) {
                break;
            }
            barraHyundai.setValue(i);
            System.out.println("proceso" + Thread.currentThread().getName() + "ejecutandose");
            
            int time = (int) (Math.random() * 300);
            try {
                Thread.sleep(time);
            } catch (InterruptedException ex) {
                Logger.getLogger(HiloHyundai.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        if (barraHyundai.getValue() == 100) {
            Ventana.posicion++;
            message.setText("Hyundai #" + Ventana.posicion);
            barraHyundai.setForeground(Color.GREEN);
            if(Ventana.posicion == 3) inicio.setEnabled(true);
        }else{
            barraHyundai.setForeground(Color.BLACK);
            barraHyundai.setValue(0);
        }
        
        finalizado = false;
        System.out.println("proceso" + Thread.currentThread().getName() + "finalizado");
    }
}
