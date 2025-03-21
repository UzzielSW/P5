
public class Race {

    public static void main(String[] args) {
        Thread[] cars = new Thread[5];
        int laps = 5;
        String[] autos = {"SSC Tuatara", "Koenigsegg Jesko", "Bugatti Chiron Super Sport 300+", "Hennessey Venom F5",
            "Rimac Nevera"};
        int N = autos.length;

        for (int i = 0; i < N; i++) {
            cars[i] = new RaceCar(laps, autos[i]);
        }

        for (int i = 0; i < N; i++) {
            cars[i].start();
        }
    }
}
