
import java.awt.TextArea;

public class MyFabrica {

    private ThreadGroup g1;
    private Caja caja;
    private Supervisor supervisor;

    public MyFabrica(int cantCajas, int papeXCaja, TextArea textArea, TextArea textArea2) {

        caja = new Caja();

        g1 = new ThreadGroup("Grupo 1");
        Thread[] threadArray = new Thread[3];

        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i] = new Thread(g1, new Trabajador(caja, textArea, i), (i + 1) + "");
        }

        new Thread(g1, new Supervisor(caja, cantCajas, papeXCaja, textArea2, 1), 4 + "").start();

        for (int i = 0; i < threadArray.length; i++) {
            threadArray[i].start();
        }

    }
}
