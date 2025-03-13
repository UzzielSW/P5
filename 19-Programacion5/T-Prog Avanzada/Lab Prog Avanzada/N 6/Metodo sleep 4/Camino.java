/**
 * @(#)Camino.java
 *
 *
 * @author
 * @version 1.00 2010/8/28
 */


public class Camino extends Thread {

    public Camino() {
    }



    public Camino(String str) {
        super(str);
    }
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Km " + i + " : " + getName());
            try {
                sleep((long)(Math.random() * 2500));
            } catch (InterruptedException e) {}
        }
        System.out.println("Llego a la meta! " + getName());
    }




}