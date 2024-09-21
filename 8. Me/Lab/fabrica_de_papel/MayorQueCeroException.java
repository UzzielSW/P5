package com.mycompany.fabrica_de_papel;

import java.io.*;
import JOptionPane;
import JTextArea;

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
    private JTextArea texto; //nuevo

    public Fabrica2(JTextArea texto, int nCa, int nPa) {

        try {
            this.texto = texto;
//			String cantCa = capturaEntero("Enter la cantidad de Cajas a fabricar:");
//			cantCajas = Integer.parseInt(cantCa);
            cantCajas = nCa;
            valida(cantCajas);
//			String papel = capturaEntero("Enter la cantidad de Papel Por Caja:");
//			cantPapel = Integer.parseInt(papel);
            cantPapel = nPa;
            valida(cantPapel);
        } //excepcion para cuando se lee llamando al metodo capturaEntero
        //          catch(IOException e) {
        //			return;
        //		}
        catch (NumberFormatException e) {
            System.out.println("Tiene que ingresar un valor entero");
            System.exit(0);
        } catch (MayorQueCeroException e) {
        }
    }

    public void run() 
    {
        cajita = new Caja(cantCajas, cantPapel);
        g1 = new ThreadGroup("t");
        thread = new Thread[3];
        persona = new Persona[3];
        
        try {
            for (int i = 0; i < 3; i++) {
//				persona[i] = new Persona(cajita, i + 1);
                persona[i] = new Persona(cajita, i + 1, this.texto);
                thread[i] = new Thread(g1, persona[i], "t");
                thread[i].start();
                thread[i].join(200);
            }
        } catch (InterruptedException e) {}
        //			supervisor = new Supervisor(cajita, 4);
        supervisor = new Supervisor(cajita, 4, this.texto);
        consumer2 = new Thread(g1, supervisor, "t");
        consumer2.setDaemon(true);
        consumer2.start();
    }

    /*public static void main(String[] args) {

		Fabrica2 fabr = new Fabrica2();

		fabr.start();

		try {
			sleep(1000 * Math.max(fabr.cantPapel, fabr.cantCajas));
			fabr.join();
		} catch(InterruptedException e) {}

		System.out.println("Caja Actual tiene:  " + fabr.cajita.getCantPapelActual());
		System.out.println("Cantidad de cajas llenas:  " + fabr.cajita.getCantCajaActual());
		System.out.println("Cantidad Maxima de cajas:  " + fabr.cajita.getMaxCantCajas());

		while (!fabr.done) {
			if (fabr.g1.activeGroupCount() == 0) fabr.done = true;
		}

	}
     */
    public static String capturaEntero(String mess) throws IOException {
        String text = JOptionPane.showInputDialog(mess);
        return (text);
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
