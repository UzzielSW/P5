import java.text.DecimalFormat;

public class Coulomb {

    public static void main(String[] args) {
        Punto p1 = new Punto(0.0, 0.0);
        Punto p2 = new Punto(3.0, 4.0);

        System.out.println("\nP1: " + p1.getDetails());
        System.out.println("\nP2: " + p2.getDetails());

        Distancia d = new Distancia(p1, p2);
        System.out.println("\n" + d.getDetails());

        Carga q1 = new Carga(1.0, p1);
        Carga q2 = new Carga(1.0, p2);

        System.out.println(q1.getDetails());
        System.out.println(q2.getDetails());

        Fuerza f = new Fuerza(q1, q2);
        System.out.println(f.getDetails());
        DecimalFormat form = new DecimalFormat("0.####E0");
        System.out.printf("%s", form.format(f.getFuerza()));
    }
}