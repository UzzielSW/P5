/*
 A) Se debe determinar el punto de equilibrio. Ocurre cuando las ventas son exactamente
    iguales a los costos operativos, en ese momento la empresa no gana ni pierde.
    
    Formula: (PV)(Q) = Cf + (Cv)(Q)
    PV: precio x unidad
    Q: cantidad de articulos a vender para tener un punto de equilibrio
    Cf: costo fijo
    Cv: costo variable

 B) Para determinar la cantidad que se tiene que vender para obtener una utilidad
    especifica, se utiliza la formula:
    
    Formula: ventas = (costos fijos + utilidad)/(1 - (costo variables/ventas x año))
    V = (Cf + U)/(1 - (Cv/Vx))
 */

import java.util.Scanner;

public class Equilibrio {

    static Double calcularEquilibrio(Double P, Double Cf, Double Cv) {
        return Cf / (P - Cv);
    }

    static Double calcularVentas(Double Cf, Double Cv, Double U, Double Vx) {
        return (Cf + U) / (1 - (Cv / Vx));
    }

    public static void main(String[] args) {
        char opc;
        Double Pv, Cf, Cv;
        Double Ut, VxA;

        Scanner in = new Scanner(System.in);
        System.out.println("A) Punto de Equilibrio");
        System.out.println("B) Obtener utilidad especifica");
        System.out.println("E) exit");

        do {
            System.out.print("\n>> ");
            opc = in.next().charAt(0);
            if (opc == 'a' || opc == 'A') {
                System.out.print("Ingrese los datos:\nPrecio producto: ");
                Pv = in.nextDouble();
                System.out.print("Costo fijo: ");
                Cf = in.nextDouble();
                System.out.print("Costo variable: ");
                Cv = in.nextDouble();

                System.out.printf("\n La cantidad de articulos para vender y tener un punto de equilibrio es de: %.2f",
                        calcularEquilibrio(Pv, Cf, Cv));

            } else if (opc == 'b' || opc == 'B') {
                System.out.print("Ingrese los datos:\nUtilidad especifica: ");
                Ut = in.nextDouble();
                System.out.print("Costo fijo: ");
                Cf = in.nextDouble();
                System.out.print("Costo variable: ");
                Cv = in.nextDouble();
                System.out.print("Ventas x año: ");
                VxA = in.nextDouble();

                System.out.printf(
                        "\n La cantidad de que se tiene que vender para obtener una utilidad de [%.2f] es de: %.2f", Ut,
                        calcularVentas(Cf, Cv, Ut, VxA));
            } else
                break;
            in.nextLine();
        } while (true);

        in.close();
    }
}