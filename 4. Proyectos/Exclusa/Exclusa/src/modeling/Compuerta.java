package modeling;
import exception.E_EnPosicionException;
/**Esta clase esta encargada del funcionmiento de la Compuerta.
 */
public class Compuerta {
  /**El campo ready  habilita el funcionamiento del objeto Compuerta.
   */
    public int ready;
    /**El campo coordenada  indica al objeto Buque  hasta donde moverse cuando se abre la Compuerta.
     */
    public int coordenada;
    /**El campo posicion indica la posicióm del Buque.*/
    public int posicion;
    /**El campo p_cerrado  indica cuando se cierra el objeto Compuerta.*/
    public int p_cerrado;
    /**El campo p_abierto  indica cuando se abre el objeto Compuerta.*/
    public int p_abierto;
    /**El campo velocidad  indica la velocidad de apertura o cierre del objeto Compuerta. */
    public int velocidad;
    /**El campo operation indica la operacion a realizar por el objeto Compuerta.*/
    public String operation="StandBy";
    /**El campo buque nos servira para hacer referencia al objeto Buque que este pasando
     *por el objeto Compuerta.
     */
    public Buque buque;

     /**Construye un objeto Compuerta .
     *@param coordenada Indica hasta donde deve moverse el objeto Buque cuando se abre el objeto Compuerta.
      *@param buque Buque que pasa por la Compuerta.
     */
    public Compuerta(Buque buque, int coordenada) {
        this.buque=buque;
        this.coordenada=coordenada;
        ready=0;
        posicion=0;
        p_cerrado=0;
        p_abierto=20;
        velocidad=1;
    }
     /**Método que decide  abrir o cerrar el obejto Compuerta.
     */
    public void operar(){

        if(this.operation=="abrir")
            this.abrir();
        if(this.operation=="cerrar")
            this.cerrar();
    }
    /**Método que abre el objeto Compuerta.
     */
    public void abrir(){
        try
        {
            ready=0;
            if(posicion<p_abierto)
            {
                this.posicion+=velocidad;
            }
            else{
                throw new E_EnPosicionException();//LLa se abrio la comopuerta
            }
            Thread.currentThread().sleep(60);
        }catch(InterruptedException e){}
        catch(E_EnPosicionException e)
        {
            ready=1;//Estado abierta
            buque.cambiarDestino(coordenada);//Nuevo destino del buque
            operation="StandBy";//operación de la compuerta
        }
    }










    /**Método que cierra el objeto Compuerta.
     */
    public void cerrar()
    {
        try
        {
            this.ready=0;

           if(posicion>p_cerrado)
            {
                posicion-=velocidad;

            }
            else
                throw new E_EnPosicionException();

            Thread.currentThread().sleep(60);
        }
        catch(InterruptedException e)
        {}
        catch(E_EnPosicionException e)
        {
            this.ready=1;
            this.operation="StandBy";
        }

    }

    /**Método que habilita el objeto Compuerta.
     */
    public void habilitar()
    {
        ready=1;
    }
     /**Método que  permite conocer la posicion del objeto Compuerta
      *mientras se abre o se cierra.
      *@return La posicion de la puerta.
     */
    public int getPosicion()//Posición de la compuerta mientras se abra o se cierre
    {
        return posicion;
    }

     /**Método que  permite conocer el estado del objeto Compuerta.
      *@return el esatdo de la compuerta.
     */
    public int getStatus()
    {
        return ready;
    }

     /**Método que permite establecer la operación a realizar por el objeto Compuerta, "abrir" o "cerrar"
      *@param operation Operación a relizar
     */

    public void setOperation(String operation)//Operación a realizar "abrir"o"cerrar"
    {
        this.operation=operation;
    }



}


