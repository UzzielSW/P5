/*
 * Estudios financieros
Cuando una empresa inicia operaciones por primera vez necesita recursos economicos en bienes
o efectivo para producir bienes y servicios que generan ganancias.

Ingresos: son los recursos economiecos que recibira la empresa o el proyecto especifico de 
un estudio por la actividad a la que se dedica. Pueden ser ingresos al contado o por cobrar.

el estudio financiero es un intrumento en el cual se establece si el proyecto es rentable 
porque la ganancica esperada se puede lograr. Indica si es conveniente o no invertir en el 
proyecto.

Incluyen la siguientes informaciones:
1. Aporte de los accionistas
2. La proporcion de la inversion financiera con prestamo
3. La taza de interes bancaria
4. los costos operativos
5. El periodo de recuperacion de la inversion
6. Punto de equilibrio
7. El flujo de efectivo
8. El balance general

El estudio financiero mide el rendimiento de la inversion pero necesita de otros 
informes como:

A) Estudio de mercado: Determina y cuantifica la oferta y demanda. Analiza los precios
y el analisis de los costos.

B) Estudio tecnico: Estudia su localizacion, el proceso productivo y el analisis
de los costos.
Define la tecnologia, el plan de produccion cubriendo todas las fases del proyecto como son:
    * planeacion
    * ejecucion
    * operacion

C) Estudio de organizacion: Se consideran todas las etapas del proyecto. Debe determinarse
la jerarquia y la responsabilidad del capital humano.

Elaboracion del plan de amortizacion de la deuda.

El plan de amortizacion incluye el abono al capital mas los intereses de un prestamo
a una taza de interes en el tiempo determinado.

Problema:
Una empresa desarrollara un proyecto cuyo costo de inversion asciende a los 10 mil dolares.
Los socios aportan 3 mil y perdiran prestado a un banco el resto (7 mil).
El banco otorga el capital a una taza de interes del 12% anual durante 10 años.

Ecuacion:  R = (A * i)/(1 - (1+i)^-n)

donde: 
A = 7000        -> prestamo
i = 12% = 0.12  -> taza interes
n = 10          -> años
 */

import java.util.Scanner;

public class Amortizacion {
    public static double CalcularFlujo(Double A, Double i, Integer n)
    {
        return (A * i)/(1-Math.pow(1+i, n*-1));
    }
    
    public static void main(String[] args) {
        Double prestamo, interes, pagoPeriodico, itemp;
        Integer tiempo;
        
        Double saldoI, saldoF, amortiza, inter;
        
        Scanner in = new Scanner(System.in);
        System.out.println("Plan de amortizacion:\n");
        System.out.print("Ingrese Prestamo: ");
        prestamo = in.nextDouble();
        System.out.print("Taza de interes [%]: ");
        itemp = in.nextDouble();
        interes = itemp/100;
        System.out.print("Años: ");
        tiempo = in.nextInt();
        
        pagoPeriodico = CalcularFlujo(prestamo, interes, tiempo);
        saldoF = prestamo;
        
        System.out.println("\nAño\tPrestamos\t\tAmortizacion\t\tIntereses\t\tPago\t\tSaldo");
        for (int i = 0; i < tiempo; i++) {
            saldoI = saldoF;
            inter = saldoI * interes;
            amortiza = pagoPeriodico - inter;
            saldoF = saldoI - amortiza;
            System.out.printf("\n%d\t%.2f\t\t\t%.2f\t\t\t%.2f\t\t\t%.2f\t\t%.2f",i+1, saldoI, amortiza, inter, pagoPeriodico, saldoF);
        }
    }
}