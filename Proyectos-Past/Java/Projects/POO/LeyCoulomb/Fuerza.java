
public class Fuerza {
    private Carga q1;
    private Carga q2;
    private double F12;
    private static final float k = 9000000000f;
    private double dis;

    public Fuerza(Carga q1, Carga q2) {
        this.q1 = q1;
        this.q2 = q2;
        this.dis = q1.getPunto().calcDistancia(q2.getPunto());
        calcFuerza();
    }

    public void calcFuerza() {
        F12 = k * (q1.getCarga() * q2.getCarga() / Math.pow(dis, 2.0));
    }

    public double getFuerza() {
        return (F12);
    }

    public double getK() {
        return k;
    }

    public String getDetails() {
        return ("\nFuerza entre las cargas:\n" +
                q1.getDetails() + " y\n" + q2.getDetails() + "\n" +
                "es: " + F12);
    }
}