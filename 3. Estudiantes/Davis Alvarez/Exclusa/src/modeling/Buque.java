package modeling;

import exception.E_EnPosicionException;
/** La clase Buque es utilizada para crear las funcionalidades de un nuevo Buque,
 *el cual transitara los objetos Exclusa.
 */
public class Buque {
    
   
   
    /**El campo max_velocidad indica la maxima velocidad del objeto Buque.  */
    
    public int max_velocidad;
    /**El campo velocidad indica la velocidad del objeto Buque.
     */
    public int velocidad;
    /**El campo p_inicial indica la posición inicial del objeto Buque.
     */
    public int p_inicial;
     /**El campo p_final indica la posición final del objeto Buque. */
    public int p_final;
     /**El campo posicion indica la posición del objeto Buque.*/
    public int posicion;
   /**El campo altura indica la altura que tome el objeto Buque cuando se estan llenando los objetos Exlcusa  de agua.
     */
    public int altura=0;
    
    /** Crea un nuevo objeto Buque.
     */
    
    public Buque() {
        
        max_velocidad=1;//Inicializando parametros
        velocidad=0;
        p_inicial=-45;
        p_final=0;
        posicion=p_inicial;
        altura=0;
        
    }
    
    /**Método que mueve el objeto Buque durante su transcurso por los obejtos  Exclusa.*/
    public void mover()
    {                   
        try
        {
            if(posicion<p_final){
                posicion += velocidad;
              
            }
            else{
                throw new E_EnPosicionException(); 
            }
        }catch(E_EnPosicionException e)
        {
            velocidad=0;
        }               
                        
    }    
    
    /**Método que actualiza la altura del objeto Buque mientras esta dentro de un objeto Exclusa.*/
    public void setAltura()
    {
        altura+=1;
    }
    /**
     * Méto que retorna la altura que tome el objeto Buque dentro de un objeto Exclusa.
     * @return La altura 
     */
    public int getAltura()
    {
        return altura;
    }
    /**Método que cambia  la posición final del objeto Buque
     @param p_final Nueva posición final hasta donde se desplazara el objeto Buque.*/
     public void cambiarDestino(int p_final)
    {
        velocidad=max_velocidad;//se reinicializa la velocidad
        this.p_final=p_final;//nueva posición final
    }
     /**Método que retorna la posicón donde se encuentre el objeto Buque.
      @return Posición del buque*/
    public int getPosicion()
    {
        return posicion;
    
    }
    /**Método que restaura todos los valores iniciales de los campos del objeto Buque.*/
    public void reset()//Restaurando los valores iniciales
    {
        max_velocidad=1;
        velocidad=0;
        p_inicial=-45;
        p_final=p_inicial;
        posicion=p_inicial;
        altura=0;
    }
  
}
