
public class PingPong extends Thread {

    public static void main(String[] args) {
        Pelota pelota = new Pelota();

        Ping jug1 = new Ping(pelota);
        Pong jug2 = new Pong(pelota);
        
        System.out.println("Inicio de Juego\n");
        
        jug1.start();
        jug2.start();

        try {
            sleep(1000);
        } catch (InterruptedException e) {}

        jug1.stop();
        jug2.stop();
        
        System.out.println("\nfin de juego");
    }
}
