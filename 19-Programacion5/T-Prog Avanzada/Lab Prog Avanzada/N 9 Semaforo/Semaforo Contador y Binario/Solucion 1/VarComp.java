/**
 * @(#)VarComp.java
 *
 *
 * @author
 * @version 1.00 2010/10/5
 */


/******************************************************************************

Clase VarComp

Recurso compartido por los procesos. Sección Crítica.
C:\Documents and Settings\Administrador\Mis documentos\Java 2010\Thread
   \Sitios Concurrencia\N 9\Semaforo Contador y Binario\Solucion
******************************************************************************/

public class VarComp {

         private int contenido;

         public int get() {

                 return contenido;

         }

         public  void put(int valor) {

                 contenido = valor;

         }

}