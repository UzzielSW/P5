
public class IncrementarValor {
  
	public synchronized void Incrementar() 
	{C --; }

	public synchronized int ObtenerValor() 
	{return C;}
	 
	private int C = 0;
}
