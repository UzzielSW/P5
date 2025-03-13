/**
 * @(#)Buffer.java
 *
 *
 * @author
 * @version 1.00 2010/10/5
 */

/******************************************************************************
C:\Documents and Settings\Administrador\Mis documentos\Java 2010\Thread\
  Sitios Concurrencia\N 9\Semaforo Contador y Binario\Solucion 2
Clase Buffer

Recurso compartido por los procesos. Sección Crítica.

******************************************************************************/

class Buffer {

         private int capacidad = 10;

         private int pila[] = new int[capacidad];

         private int puntero = -1;


         public int lee() {

                 int num = pila[puntero];

                 pila[puntero]=0;

                 puntero--;

                 System.out.print("\n-- Pila:");

                 for (int i=0;i<capacidad;i++) System.out.print(" "+pila[i]);



                 return num;

         }


         public void escribe(int num) {

                 //System.out.println("ESCRIBE - ptro: "+puntero+" - lleno: "+estaLleno );

                 puntero++;

                 pila[puntero]=num;

                 System.out.print("\n-- Pila:");

                 for (int i=0;i<capacidad;i++) System.out.print(" "+pila[i]);


         }

}
