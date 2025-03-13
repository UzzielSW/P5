/** 
 * La Clase SubDesbordamiento crea al error del tipo SubDesbordamiento, 
 * el cual permite saber que el tanque que la ha lanzado se ha quedado sin agua.
 * Tambien permite saber cuanta agua era necesaria para suplir la necesidad.	
*   @author  Bianca Gonzalez (8-789-1920) 
*	@version 1.01
*/

public class SubDesbordamiento extends Exception
{
	/** El boolean sudesbo indica que el tanque actual se ha quedado en sequia.*/
	public boolean subdesbo;//true subdesbordado, false aun hay agua en el tanke
	/** El double galon guardara cuanta agua es necesaria para suplir la necesidad
	 * que el tanque actual no pudo.*/
	double galon;

/** El constructor de SubDesbordamiento recibe  un double que representa la cantidad
 *  de agua que el tanque en sequia no pudo suplir.
 *  @param b representa la cantidad de galones que el tanque actual no pudo suplir porque estaba vacio*/	
	SubDesbordamiento(double b)
	{
		subdesbo = true;
		galon = b;
	}
}
