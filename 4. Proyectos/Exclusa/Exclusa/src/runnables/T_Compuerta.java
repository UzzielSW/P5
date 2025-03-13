package runnables;
import modeling.Compuerta;

/**La clase T_Compuerta controla, durante toda la ejecución
 * la abertura y cierre del objeto Compuerta al cual se le haga referencia.
 */
public class T_Compuerta extends Thread
{
     /** Tiempo que dormira el objeto Thread, T_Compuerta.
    */
    public int sleep=60;
    /**Parametro que nos servira para hacer referencia a un objeto Compuerta.
     */
    public Compuerta compuerta;

     /**Construye un objeto Thread T_Compuerta con un objeto Compuerta.
     *@param compuerta objeto Compuerta al cual se le hace referencia.
     */
    public T_Compuerta(Compuerta compuerta) {
        this.compuerta = compuerta;
    }

    /**Método que esta  continuamente invocando al método  operar del Objeto Compuerta .
      * al cual se le haga referencia.
    */
    public void run()
    {
        while (true)
        {
            try
            {
                compuerta.operar();
                Thread.currentThread().sleep(sleep);
            }
            catch(InterruptedException e )
            {
            }
        }
    }
}