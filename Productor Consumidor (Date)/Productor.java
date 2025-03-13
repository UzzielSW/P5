import java.text.SimpleDateFormat;
import java.util.Date;

public class Productor extends Thread {
    private Buffer buffer;
    final static int NAP_TIME = 5;

    public Productor(Buffer b) {
        buffer = b;
    }

    public void run() {
        while (true) {
            dormir();
            SimpleDateFormat formatoFecha = new SimpleDateFormat("hh:mm:ss a | dd/MM/yy");
            Date mens = new Date(); // Actualizar la fecha después de formatearla
            String mensFormateado = formatoFecha.format(mens);
            System.out.println("Productor quiere producir: " + mensFormateado);
            // System.out.println("Producido " + mens);
            buffer.poner(mens);
        }
    }

    public static void dormir() { // para suspenderse
        try {
            Thread.sleep((int) (NAP_TIME * Math.random()) * 1000);
        } catch (InterruptedException e) {
        }
    }
}
