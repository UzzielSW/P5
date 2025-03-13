package modeling;

import exception.E_EnNivelException;
/**Esta clase controla al objeto Exclusa, encargándose principalmente del llenado y 
 * vaciado de la misma.*/

public class Exclusa {
    
    /**El campo n_max representa el nivel máximo de agua del objeto Exclusa.*/
    public  int n_max;
    /**El campo n_max representa el nivel minimo de agua del objeto Exclusa.*/
    public int n_min;
    /**El campo nivel representa el nivel de agua del objeto Exclusa.*/
    public  int nivel;
    /**El campo status representa el estado  en que se encuentra el objeto Exclusa ya 
     se "llenando" o "vaciando".*/
    public  String status;
    /**El campo c_posterior nos servira para hacer referencia a  la compuerta posterior del 
     *objeto Exclusa.
     */
    public Compuerta c_posterior;
    /**El campo c_posterior nos servira para hacer referencia a  la compuerta delantera del
     * objeto Exclusa.
     */
    public Compuerta c_delantera;
    /**El campo buque nos servira para hacer referencia al objeto Buque que este pasando
     *por el objeto Exclusa.
     */
    public Buque buque;
    
     /**Construye un objeto Exclusa .
     *@param n_min Nivel mínimo de agua del objeto Exclusa.
      *@param n_max Nivel máximo de agua del objeto Exclusa.
      *@param c_posterior Compuerta posterior del objeto Exclusa.
      *@param c_delantera Compuerta delantera del objeto Exclusa.
      *@param buque Buque que pasa por el objeto Exclusa. 
     */
    public Exclusa(int n_min, int n_max,Compuerta c_posterior, Compuerta c_delantera,Buque buque) {
        
        this.n_max=n_max;
        this.n_min=n_min;
        this.nivel=this.n_max;
        this.c_posterior=c_posterior;
        this.c_delantera=c_delantera;
        this.buque = buque;
        
    }
    
    /**Método que decide  vaciar o llenar el objeto Exclusa.
     */
    public void fluir()
    {   
        if(this.status=="llenar")
            this.llenar();
        if(this.status=="vaciar")
            this.vaciar();
    }
    /**Método que vacia el objeto Exclusa.
     */
     
    public void vaciar()
    {
        try
        {
         
            if(nivel>n_min)
            {
               
                nivel-=1;//Vaciando la exclusa
            }
            else
                throw new E_EnNivelException();//Lanzando la excepcion ya se vacio
            
            Thread.currentThread().sleep(60);
        }
        catch(InterruptedException e)
        {} 
        catch(E_EnNivelException e)
        { 
            c_posterior.habilitar();
            status="standby";
        }         
      
    }
    /**Método que llena el objeto Exclusa.
     */
    public void llenar()
    {
        try
        {
           if(nivel<n_max)
            {
              
                nivel+=1;//Se esta llenando la exclusa de agua
                buque.setAltura();//el buque deve flotar
               
                
            }
            else
                throw new E_EnNivelException();//Lanzando la excepcion ya se lleno
                 
            Thread.currentThread().sleep(60);
        }
        catch(InterruptedException e)
        {} 
        catch(E_EnNivelException e)
        {   //Como se lleno la exclusa se habilita la compuerta delantera
            c_delantera.habilitar();
            this.status="standby";
        }               
    }
    
    /**Método accesor para el nivel del agua.
     *@return El nivel del agua
     */
    public int getNivel()//Nivel del agua en la exclusa
    {
        return nivel;
    }
    
    /**Método que cambia el estado del objeto exclusa.
     @param status Estado del objeto Exclusa "llenar", "vaciar" o "standby"*/
    public void setStatus(String status)//Estado de la exclusa
    {
        this.status=status;
    }
}