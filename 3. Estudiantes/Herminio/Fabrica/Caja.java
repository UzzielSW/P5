/**
 * @(#)Caja.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/12/17
 */

/**
 * <p>La clase <code>Caja</code> se encarga de la seccion critica del programa, la misma simula una caja la cual es llenada con papeles hasta alcanzar la cifra de 100 papeles</p>
*/
public class Caja
{

    private boolean isFull;
    private boolean isRetired;
    private int hojas;

    /**
     * Constructor de la clase
     */
    public Caja()
    {
    	isFull = false;
    	isRetired = false;
    	hojas = 0;
    }

    /**
     * Coloca un nuevo numero de paginas en la caja
     * @param pages  el nuevo valor de las paginas
     */
    public synchronized void setNumberOfPages(int pages)
    {
    	hojas = pages;
    }

    /**
     * Retorna el numero de paginas guardadas actualmente en la caja
     * @return el numero actual de paginas
     */
    public int getNumberOfPages()
    {
    	return hojas;
    }

    /**
     * Informa sobre el estado de la caja
     * @return <code>true</code> si la caja esta llena <code>false</code> en caso contrario
     */
    public boolean getFull()
    {
    	return isFull;
    }

    /**
     * Establece el estado de la caja (si esta llena o no)
     * @param state el estado de la caja
     */
    public void setFull(boolean state)
    {
    	isFull = state;
    }

    /**
     * Informa si la caja ha sido retirada por un supervisor
     *
     * @return <code>true</code> si la caja ha sido retirada
     */
    public boolean getRetired()
    {
    	return isRetired;
    }







    /**
     * Permite a un usuario (el supervisor) retirar la caja
     *
     * @param state <code>true</code> si la caja ha de ser retirada
     * @see Supervisor
     */
    public void setRetired(boolean state)
    {
    	isRetired = state;
    }

    /**
     * Agrega una pagina a la caja especificada
     *
     * @param caja La caja a la cual se le agregara una pagina
     * @exception CajaLlenaException si la caja esta llena
     * @exception NoHayCajaException si la caja ha sido retirada
     * @exception InterruptedException si la ejecucion del hilo ha sido interrumpida por otro hilo
     */
    public static synchronized void addAPage(Caja caja) throws CajaLlenaException, NoHayCajaException, InterruptedException
    {
    	if(caja.getRetired()) throw new NoHayCajaException();
    	else if(caja.getFull()) throw new CajaLlenaException();
    	else
    	{
    		int temporal = caja.getNumberOfPages()+1;
    		if(temporal > 100) caja.setFull(true);
    		else
    		{
    			Thread.sleep(5);
    			caja.setNumberOfPages(temporal);
    		}
    	}
    }
}