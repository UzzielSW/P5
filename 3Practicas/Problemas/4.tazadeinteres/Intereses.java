/*
 * Taza de interes
    Datos:
        C: Capital o prestamo
        S: monto o valor acumulado de C
        i: interes

    formulas: 
        I = S - C
        i = I/C
        i = (S/C) - 1

 * Interes simple: cuando unicamente el capital gana intereses por todo el tiempo que 
    dura la transaccion al interes vencida al final del plaso.
    
    T: tiempo o año
    i: taza

    formulas:
        I = C * i * T
        S = C + I
        i = (S/C*T) - 1/T
    
 * Interes exacto: el interes exacto se calcula sobre la base de 365 dias.
    donde T = dias/365
 * Interes ordinario: se calcula en base a 360 dias.
    donde T = dias/360
 */

import java.util.Scanner;

public class Intereses {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int opc;
        Double capital, Smonto, interes;
        Double tiempo, taza, timeOrdinario, timeExacto;

        System.out.println("1).Calcular Taza de interes");
        System.out.println("2).Calcular interes Simple y monto acumulado");
        System.out.println("3).Calcular interes exacto y ordinario");
        System.out.println("other).exit");
        do {
            System.out.print("\n>> ");
            opc = in.nextInt();
            if (opc == 1) {
                System.out.println("\nIngrese Datos: ");
                System.out.print("Capital: ");
                capital = in.nextDouble();
                System.out.print("monto o valor acumulado de C: ");
                Smonto = in.nextDouble();
                System.out.print("Tiempo en base a años: ");
                tiempo = in.nextDouble();
                taza = (Smonto / (capital * tiempo)) - (1 / tiempo);
                taza *= 100;
                System.out.print("\nTaza de interes: " + taza.intValue() + "%");
            } else if (opc == 2) {
                System.out.println("\nIngrese Datos: ");
                System.out.print("Capital: ");
                capital = in.nextDouble();
                System.out.print("Taza de interes [%]: ");
                taza = in.nextDouble();
                taza = taza / 100;
                System.out.print("Tiempo en base a años: ");
                tiempo = in.nextDouble();

                interes = capital * taza * tiempo;
                Smonto = capital + interes;

                System.out.printf("\nInteres simple: %.2f", interes);
                System.out.printf("\nMonto acumulado: %.2f", Smonto);
            } else if (opc == 3) {
                System.out.println("\nIngrese Datos: ");
                System.out.print("Capital: ");
                capital = in.nextDouble();
                System.out.print("Taza de interes [%]: ");
                taza = in.nextDouble();
                taza = taza / 100;
                System.out.print("Tiempo en dias: ");
                tiempo = in.nextDouble();
                timeOrdinario = tiempo / 360;
                timeExacto = tiempo / 365;

                interes = capital * taza * timeOrdinario;
                System.out.printf("\nInteres Ordinario: %.2f", interes);

                interes = capital * taza * timeExacto;
                System.out.printf("\nInteres Exacto: %.2f", interes);
            } else
                break;

            in.nextLine();
        } while (true);

        in.close();
    }
}