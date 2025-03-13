/*
 * Muestra la informacion de las inversiones antes de iniciar el proyecto
   los egresos e ingresos de operaciones, el valor de salbamento y la recuperacion
   del capital de trabajo.
*/

import java.util.Scanner;

public class FlujoNeto {
    public static String cuentas[] = { "Ventas Activos", "Egresos\t", "Depreciacion",
            "Valor en libros", "Utilidad antes de impuestos", "Impuesto",
            "Utilidad Neta", "Depreciacion", "Valor en libros", "Inversion", "Flujo de Caja"
    };

    public static void main(String[] args) {
        int year;
        double valorInicial, valorFinal, costoOperaciones, impuestosUtilidad, depreciacion, valDepreciacion;
        double precioEquipoInicial, precioEquipoFinal, disminucionCostoOpe;
        int tiempoUso = 5;
        double egresos, valorLibros;
        Double[][] registro;

        Scanner in = new Scanner(System.in);

        // entrada de datos
        System.out.println("Flujo de fondo neto");
        System.out.print("## Datos de equipo actual ##\n");
        System.out.print("Tiempo del equipo: ");
        year = in.nextInt();

        System.out.print("Se compro en: ");
        valorInicial = in.nextDouble();

        System.out.print("Se podria vender en: ");
        valorFinal = in.nextDouble();

        System.out.print("Costos de operaciones de la empresa con el equipo: ");
        costoOperaciones = in.nextDouble();

        System.out.print("Impuestos de utilidad (%): ");
        impuestosUtilidad = in.nextDouble();

        System.out.print("Depreciacion del equipo (%): ");
        valDepreciacion = in.nextDouble();

        System.out.print("\n## Datos de equipo nuevo ##\n");
        System.out.print("Se compro en: ");
        precioEquipoInicial = in.nextDouble();

        System.out.print("Tiempo de uso: ");
        tiempoUso = in.nextInt();

        System.out.print("Se podria vender en: ");
        precioEquipoFinal = in.nextDouble();

        System.out.print("Disminucion del costo de operaciones: ");
        disminucionCostoOpe = in.nextDouble();

        in.close();

        // Calculos
        // porcentajes
        impuestosUtilidad /= 100;
        valDepreciacion /= 100;
        // egresos
        egresos = costoOperaciones - disminucionCostoOpe;
        // depreciacion
        depreciacion = precioEquipoInicial * valDepreciacion;
        // valor en libros
        valorLibros = valorInicial - (year * valorInicial * valDepreciacion);

        // inicializando matriz(registro)
        registro = new Double[cuentas.length][tiempoUso + 1];
        for (int i = 0; i < registro.length; i++) {
            for (int k = 0; k < registro[i].length; k++)
                registro[i][k] = 0.0;
        }

        // operaciones en el registro
        double temp = 0;
        for (int i = 0; i < registro.length; i++) {
            if (i == 0) // venta de activos
            {
                registro[i][0] = valorFinal;
                registro[i][tiempoUso] = precioEquipoFinal;
            } else if (i == 1) // egresos
            {
                for (int k = 1; k < registro[i].length; k++)
                    registro[i][k] = -1 * egresos;
            } else if (i == 2) // depreciacion
            {
                for (int k = 1; k < registro[i].length; k++)
                    registro[i][k] = -1 * depreciacion;
            } else if (i == 3) // valor en libros
            {
                registro[i][0] = -1 * valorLibros;
            } else if (i == 4) // utilidad antes del impuesto
            {
                for (int c = 0; c < registro[i].length; c++) {
                    temp = 0;
                    for (int f = 0; f < 4; f++)
                        temp += registro[f][c];

                    registro[i][c] = temp;
                }
            } else if (i == 5) // impuestos
            {
                for (int c = 0; c < registro[i].length; c++)
                    registro[i][c] = Math.abs(registro[4][c]) * impuestosUtilidad;
            } else if (i == 6) // utilidad neta
            {
                for (int c = 0; c < registro[i].length; c++) {
                    if (registro[4][c] >= 0)
                        registro[i][c] = registro[4][c] - registro[5][c];
                    else
                        registro[i][c] = registro[4][c] + registro[5][c];
                }
            } else if (i == 7) // depreciacion
            {
                for (int c = 1; c < registro[i].length; c++)
                    registro[i][c] = depreciacion;
            } else if (i == 8) // valor en libros
            {
                registro[i][0] = valorLibros;
            } else if (i == 9) // Inversion
            {
                registro[i][0] = -1 * precioEquipoInicial;
            } else if (i == 10) // flujo de caja
            {
                for (int c = 0; c < registro[i].length; c++) {
                    temp = 0;
                    for (int f = 6; f < registro.length; f++)
                        temp += registro[f][c];

                    registro[i][c] = temp;
                }
            }
        }

        // imprimir datos
        System.out.print("\n\n  Cuentas\t\t\t| ");
        for (int i = 0; i <= tiempoUso; i++)
            System.out.printf("   %d   |", i);
        System.out.println("");

        for (int i = 0; i < registro.length; i++) {
            // datos de cuentas
            if (cuentas[i].length() <= 15)
                System.out.print(cuentas[i] + "\t\t\t| ");
            else
                System.out.print(cuentas[i] + "\t| ");
            // datos del registro
            for (int k = 0; k < registro[i].length; k++) {
                if (registro[i][k] != 0)
                    System.out.print(registro[i][k] + " | ");
                else
                    System.out.print("\t | ");
            }
            System.out.println("");
        }
    }
}