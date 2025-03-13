/*
	simplemente ingrese las coordenadas del punto (x,y), pero |x|,|y|<=n, donde x,y pertenece a R 
	(conjunto de números reales) 
	actualmente n es 8, puede cambiarlo 4 mayor coordenadas

 * Ejemplo: -1.9  3
*/

import java.util.Scanner;

public class Graficar {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    double x = 0, y = 0, n = 8;
    try {
      System.out.print("Introduzca las coordenadas del punto (x,y): ");
      x = sc.nextDouble();
      y = sc.nextDouble();
    } catch (Exception e) {
      showMessage();
    }

    System.out.print("\n Ha ingresado las coordenadas del punto como(" + x + " , " + y
        + ")\n(La distancia del punto al origen(0,0) ::: "
        + (double) ((int) ((Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2))) * 1000)) / 1000
        + " unidades\n\n");

    showGraph(retRound(x), retRound(y), (int) n);
  }

  static void showMessage() {
    System.out.print("Seguir las intrucciones para las entradas\n");
    System.exit(0);
  }

  static void showGraph(int x, int y, int n) {
    for (int a = 1; a <= 2 * n + 1; a++) {
      for (int b = 1; b <= 2 * n + 1; b++)
        System.out.print(((x >= 0 && y >= 0 && b == n + 1 + x && a == n - y + 1)
            || (x < 0 && y < 0 && a == n + 1 - y && b == n + x + 1)
            || (x < 0 && y > 0 && a == n - y + 1 && b == n + 1 + x)
            || (x > 0 && y < 0 && a == n + 1 - y && b == n + x + 1)) ? " * "
                : (a == n + 1) ? " - " : (b == n + 1) ? " ! " : "   ");
      System.out.println();
    }
  }

  static int retRound(double a) {
    return (int) Math.round(a);
  }
}