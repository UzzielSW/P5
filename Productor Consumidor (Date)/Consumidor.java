import java.util.*;

public class Consumidor extends Thread {
    private Buffer buffer;
    final static int NAP_TIME = 5;

    public Consumidor(Buffer b) {
        buffer = b;
    }

    public void run() {
        Date mens;
        while (true) {
            dormir();
            System.out.println("Consumidor quiere consumir.");
            mens = (Date) buffer.sacar();
        }
    }

    public static void dormir() { 
        try {
            Thread.sleep((int) (NAP_TIME * Math.random()) * 1000);
        } catch (InterruptedException e) {
        }
    }
}