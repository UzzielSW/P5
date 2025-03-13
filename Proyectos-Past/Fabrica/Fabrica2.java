
import javax.swing.JTextArea;
public class Fabrica2 extends Thread {

    boolean done;
    Caja cajita;
    Thread[] thread;
    Persona persona[];
    ThreadGroup g1;
    Supervisor supervisor;
    Thread consumer2;
    int cantPapel = 0;
    int cantCajas = 0;
    private JTextArea texto;

    public Fabrica2(JTextArea texto, int nCa, int nPa) {

        try {
            this.texto = texto;
            cantCajas = nCa;
            valida(cantCajas);
            cantPapel = nPa;
            valida(cantPapel);
        } catch (NumberFormatException e) {
            System.out.println("Tiene que ingresar un valor entero");
            System.exit(0);
        } catch (MayorQueCeroException e) {}
    }

    @Override
    public void run() 
    {
        cajita = new Caja(cantCajas, cantPapel);
        g1 = new ThreadGroup("t");
        thread = new Thread[3];
        persona = new Persona[3];
        
        try {
            for (int i = 0; i < 3; i++) {
                persona[i] = new Persona(cajita, i + 1, this.texto);
                thread[i] = new Thread(g1, persona[i], "t");
                thread[i].start();
                thread[i].join(200);
            }
        } catch (InterruptedException e) {}
        supervisor = new Supervisor(cajita, 4, this.texto);
        consumer2 = new Thread(g1, supervisor, "t");
        consumer2.setDaemon(true);
        consumer2.start();
    }

    public static void valida(int cant) throws MayorQueCeroException {
        if (cant <= 0) {
            throw new MayorQueCeroException(cant);
        }
    }
}

class MayorQueCeroException extends Exception {
    private static final long serialVersionUID = 1L;
    MayorQueCeroException(int cant) {
        System.out.println("La cantidad es incorrecta! ");
        System.out.println("Ingrese una cantidad mayor que cero");
        System.exit(0);
    }
}
