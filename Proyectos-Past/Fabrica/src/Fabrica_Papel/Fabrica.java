

import javax.swing.JTextArea;
public class Fabrica extends Thread {

    boolean done;
    Caja cajita;
    Thread[] thread;
    Persona persona[];
    ThreadGroup g1;
    Supervisor supervisor;
    Thread consumer2;
    int cantPapel = 0;
    int cantCajas = 0;
    JTextArea consola;

    public Fabrica(int cajas, int papel, JTextArea csl) {
        cantCajas = cajas;
        cantPapel = papel;
        consola = csl;
    }

    @Override
    public void run() {
        cajita = new Caja(cantCajas, cantPapel);
        g1 = new ThreadGroup("t");
        thread = new Thread[3];
        persona = new Persona[3];
        
        try {
            for (int i = 0; i < 3; i++) {
                persona[i] = new Persona(cajita, i + 1, consola);
                thread[i] = new Thread(g1, persona[i], "t");
                thread[i].start();
                thread[i].join(200);
            }
        } catch (InterruptedException e) {}
        
        supervisor = new Supervisor(cajita, 4, consola);
        consumer2 = new Thread(g1, supervisor, "t");
        consumer2.setDaemon(true);
        consumer2.start();
        
        System.out.println("termino el hilo fab2");
    }
}