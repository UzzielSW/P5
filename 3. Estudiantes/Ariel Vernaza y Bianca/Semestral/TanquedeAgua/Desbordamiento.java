/** 
 * La Clase Desbordamiento crea al error del tipo Desbordamiento, 
 * el cual permite saber que el tanque que la ha lanzado ha llegado a su capacidad
 * maxima de agua.Tambien permite saber cuanta agua excede de la capacidad del tanque que 
 * la lanzo.	
*   @author  Bianca Gonzalez (8-789-1920) 
*	@version 1.01
*/

public class Desbordamiento extends Exception
{
	/** El boolean desbo indica que el tanque actual ha llegado a su capacidad maxima de agua.*/
	public boolean desbo;//true desbordado, false aun hay espacio en el tanke
	/** El double galon guardara cuanta agua no se pudo guardar en el tanque porque este ya estaba
	 * en su maxima capacidad*/
	public double galon;
	
	/** El constructor de SDesbordamiento recibe  un double que representa la cantidad
	 *  de agua que el tanque no pudo almacenar porque habia llegado a su maxima capacidad.
	 *  @param galones representa la cantidad de galones que exceden de la capacidad de tanque lanzo la execpecion*/
	Desbordamiento(double galones)
	{
		desbo = true;
		galon = galones;
		
	}
}

