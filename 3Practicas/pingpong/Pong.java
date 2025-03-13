
public class Pong extends Thread {

    private final Pelota pelota;
    public Pong(Pelota p) {
        pelota = p;
    }

    @Override
    public void run() {
        int playingTime = 0;
        while (true) {
            synchronized (pelota) {
                while (pelota.isNoTengo()) {
                    System.out.println("Ping esperando...");
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
                pelota.setNoTengo(false);
            } else {
                pelota.setNoTengo(true);
                synchronized (pelota) {
                    System.out.println("\nPong");
                    pelota.notify();
                }
            }
        }
    }
}
