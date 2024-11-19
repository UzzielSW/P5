
public class Ping extends Thread {
    private final Pelota pelota;

    public Ping(Pelota p) {
        pelota = p;
    }

    @Override
    public void run() {
        int playingTime = 0;
        while (true) {
            synchronized (pelota) {
                while (!pelota.isNoTengo()) {
                    if(playingTime != 0)
                        System.out.println("Pong esperando...");
                    else 
                        System.out.println("Ping inicia el juego");
                    try {
                        pelota.wait();
                    } catch (InterruptedException ex) {}
                }
            }

            try {
                //jugando
                playingTime = (int) (Math.random() * 300);
                Thread.sleep(playingTime);
            } catch (InterruptedException e) {}

            if (playingTime < 1) {
                pelota.setNoTengo(true);
            } else {
                pelota.setNoTengo(false);
                synchronized (pelota) {
                    System.out.println("\nPing");
                    pelota.notify();
                }
            }
        }
    }
}
