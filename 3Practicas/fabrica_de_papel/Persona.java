package com.mycompany.fabrica_de_papel;

import JTextArea;

public class Persona extends Thread {

    private Caja caja;
    private int id;
    private JTextArea texto; //nuevo

    public Persona(Caja caja, int id, JTextArea texto) {
        this.caja = caja;
        this.id = id;
        this.texto = texto;
    }

    public void run() {
        int tiempo;
        
        while (true) {
            synchronized (caja) {
                while (!caja.isNoTengo()) {
                    try {
                        texto.append("\nPersona: " + id + " is waiting..."); //nuevo
                        System.out.println("Persona: " + id + " is waiting...");
                        caja.wait(1000);
                    } catch (InterruptedException e) {}
                    break;
                }
            }
            
            //Produce the paper
            if (caja.getCantCajaActual() != caja.getMaxCantCajas()) {
                try {
                    //	System.out.println("Persona: " + id+ " Busca papel");
                    tiempo = (int) (Math.random() * 200 + 1);
                    Thread.sleep(tiempo);
                } catch (InterruptedException e) {
                }

                if (caja.getCantPapelActual() < caja.getCantMaxPapel() && caja.getCantCajaActual() != caja.getMaxCantCajas()) {
                    caja.setNoTengo(false);
                    synchronized (caja) {
                        addPapel();
                        texto.append("\nId: " + id + " Puso papel: " + caja.getCantPapelActual());//nuevo
                        System.out.println("Id: " + id + " Puso papel: " + caja.getCantPapelActual());
                        caja.notifyAll();
                    }
                }
            } else {
                break;
            }
        } //fin del while

    }

    public synchronized void addPapel() {
        caja.agregarPapel();
    }
}
