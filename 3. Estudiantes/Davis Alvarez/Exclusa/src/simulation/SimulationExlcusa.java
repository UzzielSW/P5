package simulation;

import modeling.Buque;
import modeling.Compuerta;
import modeling.Exclusa;
import runnables.T_Buque;
import runnables.T_Compuerta;
import runnables.T_Exclusa;
import view.View;
/**Esta clase da inicio la simulación.
*/
public class SimulationExlcusa {

   /**Método estático que da inicio  a la simulación
    *contiene todas las intancias de los objetos Buque , 
    *Compuerta, Exclusa y los objetos Threads T_Buque,T_Exlusa, T_Compuerta, con inicialización.
    */
    
    public static void main(String[] args) {
     
        //Instanciando objetos  
        final Buque buque = new Buque();
        Compuerta c1 = new Compuerta(buque, 90);
        Compuerta c2 = new Compuerta(buque, 230);
        Compuerta c3 = new Compuerta(buque, 360);
        Compuerta c4 = new Compuerta(buque, 550);
        Exclusa e1 = new Exclusa(26,52,c1,c2,buque);
        Exclusa e2 = new Exclusa(26,52,c2,c3,buque);
        Exclusa e3 = new Exclusa(26,52,c3,c4,buque);
       
        
        //Instanciando los Threads 
        T_Buque tBuque = new T_Buque(buque);
        T_Exclusa tExclusa1 = new T_Exclusa(e1);        
        T_Exclusa tExclusa2 = new T_Exclusa(e2);        
        T_Exclusa tExclusa3 = new T_Exclusa(e3);        
        Thread tCompuerta1 = new T_Compuerta(c1);       
        Thread tCompuerta2 = new T_Compuerta(c2); 
        Thread tCompuerta3 = new T_Compuerta(c3); 
        Thread tCompuerta4 = new T_Compuerta(c4); 
        
        
        final Exclusa[] exclusas_array = {e1,e2,e3};
        final Compuerta[] compuertas_array = {c1,c2,c3,c4};
        
       
       
       java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new View(buque, exclusas_array, compuertas_array).setVisible(true);
            }
        });
     
        //Iniciando los threads
        tBuque.start();
        tExclusa1.start();
        tExclusa2.start();
        tExclusa3.start();
        tCompuerta1.start();
        tCompuerta2.start();
        tCompuerta3.start();
        tCompuerta4.start();
      
    }
    
}


