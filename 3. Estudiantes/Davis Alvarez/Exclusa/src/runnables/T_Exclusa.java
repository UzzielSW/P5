package runnables;

import modeling.Exclusa;
/**La clase T_Exclusa controla, durante toda la ejecución el 
 * llenado y vaciado del objeto Exclusa al que se le haga referencia.
 */
public class T_Exclusa extends Thread//Thread para las exclusas.
{
    /** Tiempo que dormira el objeto Thread , T_Exclusa.
    */
    public int sleep=60;
    
   /**Parametro que nos servira para hacer referencia a un objeto Exclusa.
     */
    public Exclusa exclusa;
    /**Construye un objeto Threads ,T_Exclusa ,con un Exclusa.
     *@param exclusa Objeto exlcusa al  cual se le hace referencia.
     */
    public T_Exclusa(Exclusa exclusa) { 
        this.exclusa = exclusa;
    }
    
     /**Método que esta  continuamente invocando el método  fluir del Objeto Exlusa 
      * al cual se le haga referencia.
    */
    
    public void run() 
    {
        while (true )
        {
            try
            {
                exclusa.fluir();
                Thread.currentThread().sleep(sleep);
            }
            catch(InterruptedException e )
            {
            }
        }
    }
}