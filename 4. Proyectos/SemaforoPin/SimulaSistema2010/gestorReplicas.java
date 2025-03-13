
public class gestorReplicas {

	private int nMaxRŽplicas = 20;
	private int nActualRŽplicas = nMaxRŽplicas;
//	private int Periodo = 60;	
//	private int idPrincipal = 1;
	private estado elEstado;
	private int nReplicasEspera = 0;
	private boolean hayNuevoEstado = false;
	
//	public synchronized void finTemporizaci—n() throws InterruptedException
//	{
//		idPrincipal ++;
//		elEstado.idPrincipal = idPrincipal;
//	}
	
	public synchronized void falloPrincipal() {}
	
//	public synchronized void estoyViva() {}
	
	public synchronized void nuevoEstado(estado nuevoEstado)
	throws InterruptedException

	{
		elEstado = nuevoEstado;
		
		while (nReplicasEspera < nActualRŽplicas) wait();
		
		hayNuevoEstado = true;
		
		notifyAll();
	}
	
	public synchronized estado esperarEstado() 
		throws InterruptedException
	{
		while(hayNuevoEstado) wait();
		nReplicasEspera ++;
		if (nReplicasEspera == nActualRŽplicas) notifyAll();
		while (!hayNuevoEstado) wait();
		nReplicasEspera --;
		
		if (nReplicasEspera == 0) hayNuevoEstado = false;
		
		return elEstado;
	}
	
}
