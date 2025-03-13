import java.text.DecimalFormat;

public class Fuerza {
    // cargas, distrancia, fuerza
    private static final float k = 9000000000f;
    private Carga q1;
    private Carga q2;
    private Distancia dis;
    private float F12;
    private float base;
    private byte exp = 0;

    public Fuerza(Carga q1, Carga q2, Distancia dis) {
        this.q1 = q1;
        this.q2 = q2;
        this.dis = dis;
        calcFuerza();
        if (F12 < 1)
            IpowI();
    }

    private void calcFuerza() {
        F12 = (float) (k * (Math.abs(q1.getValue() * q2.getValue()) / Math.pow(dis.getDistancia(), 2)));
    }

    public double getFuerza() {
        return (F12);
    }

    public void getDetails() {

        if (q1.getBase() < 0 || q2.getBase() < 0)
            if (F12 > 0)
                F12 *= -1;
        DecimalFormat formato = new DecimalFormat("0.###E0");
        if (exp == 0)
            System.out.printf("\n Fuerza entre las cargas: %s N\n", formato.format(F12));
        else
            System.out.printf("\n Fuerza entre las cargas: %.2fx10^%d N \n", F12, exp);
    }

    public void IpowI() {
        while (F12 < 1 && F12 > 0) {
            F12 *= 10;
            exp--;
        }
    }

}