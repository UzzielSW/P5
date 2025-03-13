package runnables;
import modeling.Buque;
/**La clase T_Buque controla, durante toda la ejecuci�n el
 * recorrido del Objeto Buque al cual se le haga referencia.
 */
public class T_Buque extends Thread
{
    /** Tiempo que dormira el objeto Thread, T_Buque.
    */
    public int sleep=60;

    /**Parametro que nos servira para hacer referencia a un objeto Buque.
     */
    public Buque buque;

     /**Construye un objeto Thread ,T_Buque con un objeto Buque.
     *@param buque objeto Buque al cual se le hace referencia.
     */
   public  T_Buque(Buque buque) {
        this.buque = buque;
    }
     /**M�todo que esta  continuamente invocando el m�todo  mover del Objeto Buque
      * al cual se le haga referencia.
    */
    public void run()
    {
        while (true)
        {
            try
            {
                buque.mover();
                Thread.currentThread().sleep(sleep);
            }
            catch(InterruptedException e )
            {
            }
        }
    }
}