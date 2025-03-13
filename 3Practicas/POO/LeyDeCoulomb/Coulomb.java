import java.util.Scanner;

public class Coulomb {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        float base;// cargas
        byte exp;// exponencial
        float dis;// distancia r
        byte opc; // opcion(metros/centimetros)
        Distancia r = null;

        System.out.print(" carga q1: ");
        base = cin.nextFloat();
        System.out.print(" q1x10^");
        exp = cin.nextByte();

        Carga q1 = new Carga(base, exp);

        System.out.print(" carga q2: ");
        base = cin.nextFloat();
        System.out.print(" q2x10^");
        exp = cin.nextByte();

        Carga q2 = new Carga(base, exp);
        //
        System.out.print("\n leer distancia en: ");
        System.out.print("\n 1.metros cuadrados(m^2)");
        System.out.print("\n 2.metros");
        System.out.print("\n 3.centimetros");
        System.out.print("\n 4.Puntos en el plano");
        System.out.print("\n opcion? ");
        opc = cin.nextByte();

        if (opc == 4) {
            System.out.print("\n puntos en el plano de q1: P(x,y) ");
            Punto p1 = new Punto(cin.nextFloat(), cin.nextFloat());
            System.out.print("\n puntos en el plano de q2: P(x,y) ");
            Punto p2 = new Punto(cin.nextFloat(), cin.nextFloat());

            r = new Distancia(0, p1, p2);
        } else {
            System.out.print("\n distancia = ");
            dis = cin.nextFloat();

            if (opc == 1)   dis = (float) Math.sqrt(dis);
            else if (opc == 3)  dis /= 100; // convirtiendo de centimetros a metros

            r = new Distancia(dis, null, null);
        }

        Fuerza F12 = new Fuerza(q1, q2, r);
        F12.getDetails();
    }
}