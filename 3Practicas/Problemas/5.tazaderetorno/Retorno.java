
/*
 * Recuperacion de inversion
   Taza interna de retorno: es la taza de interes a la cual se le debe de contar
    los flujos de efectivos generados por el proyecto atraves de su vida 
    economica para que esto se iguales a la inversion.

Problema: Un proyecto cuyo valor es de 35000 y que gana flujos anuales de 15000
           por 3 años lo cual conduce a una taza interna de retorno del 15%.
*/
import java.util.Scanner;

public class Retorno {
    public static void main(String[] args) {
        double valor, flujoYear, tazaInterna;
        double interes, recuperacion, flujo;
        int tiempo;
        double[][] registro;

        Scanner in = new Scanner(System.in);

        System.out.println("TAZA INTERNA DE RETORNO\n");
        System.out.println("Datos del proyecto:");
        System.out.print("Valor: ");
        valor = in.nextDouble();
        System.out.print("Gana flujos anuales de: ");
        flujoYear = in.nextDouble();
        System.out.print("Durante(tiempo en años): ");
        tiempo = in.nextInt();
        System.out.print("Taza interna de retorno (%): ");
        tazaInterna = in.nextDouble();

        in.close();

        tazaInterna /= 100;
        recuperacion = 0;
        // inicializando registro
        registro = new double[tiempo][4];
        // calculando registro
        for (int i = 0; i < tiempo; i++) {
            // cant.recuperar
            registro[i][0] = valor - recuperacion;
            valor = registro[i][0];
            // interes
            registro[i][1] = registro[i][0] * tazaInterna;

            // recuperacion de inversion
            recuperacion = flujoYear - registro[i][1];
            registro[i][2] = recuperacion;

            registro[i][3] = flujoYear;
        }

        // calculando totales y validando recuperacion
        // validar {(total de interes + total de recuperacion) = total flujo anuales}
        recuperacion = 0;
        interes = 0;
        flujo = 0;
        // intereses
        for (int f = 0; f < registro.length; f++)
            interes += registro[f][1];
        // recuperacion
        for (int f = 0; f < registro.length; f++)
            recuperacion += registro[f][2];
        // flujos anuales
        for (int f = 0; f < registro.length; f++)
            flujo += registro[f][3];

        if ((interes + recuperacion) == flujo) {
            System.out.println("\n Se realizo la recuperacion con exito");
            System.out.println("No. | cant. recuper. \t| interes | recuper. de inver. \t| flujos anuales |");
            for (int i = 0; i < registro.length; i++)
                System.out.printf("%d   | %.2f  \t| %.2f |\t%.2f \t|\t%.2f |\n", i + 1, registro[i][0], registro[i][1],
                        registro[i][2], registro[i][3]);
        } else
            System.out.println("\nNo se recupero la inversion");
    }
}