/**
 * @(#)Caja.java
 *
 *
 * @author 
 * @version 1.00 2010/12/17
 */


public class Caja 
{

    private boolean isFull;
    private boolean isRetired;
    private int hojas;
    
    public Caja() 
    {
    	isFull = false;
    	isRetired = false;
    	hojas = 0;
    }
    
    public void setNumberOfPages(int pages)
    {
    	hojas = pages;
    }
    
    public int getNumberOfPages()
    {
    	return hojas;
    }
    
    public boolean getFull()
    {
    	return isFull;
    }
    
    public void setFull(boolean state)
    {
    	isFull = state;
    }
    
    public boolean getRetired()
    {
    	return isRetired;
    }
    
    public void setRetired(boolean state)
    {
    	isRetired = state;
    }
    
   
    public static synchronized void addAPage(Caja caja) throws CajaLlenaException, NoHayCajaException, InterruptedException
    {
    	Thread.sleep(100);
    	if(caja.getRetired()) 
    	{
    		throw new NoHayCajaException();
    	}
    	else if(caja.getFull()) 
    	{
    		throw new CajaLlenaException();
    	}
    	else
    	{
    		int temporal = caja.getNumberOfPages()+1;
    		if(temporal == 100) caja.setFull(true);
    		Thread.sleep(5);
    		caja.setNumberOfPages(temporal);
    	}
    }
}