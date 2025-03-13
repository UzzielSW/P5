public class Llave
{
	public boolean estado;//true abierto, false cerrado
	
	public Llave()
	{
	estado = false;//llave inicia cerrada
	}
	
	public boolean getEstado()
	{
		return estado;
	}
	
	public void abre()
	{
	if(estado)
		System.out.println("La llave ya esta abierta");
	else
		estado = true;
	
	}
	
	public void cierra()
	{
		if(estado)
			estado = false;
		else
			System.out.println("La llave ya esta cerrada");
	}
}
	
