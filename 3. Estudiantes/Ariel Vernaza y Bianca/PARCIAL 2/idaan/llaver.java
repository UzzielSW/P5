
public class Llaver {
	public boolean abierta;
	
	public Llaver(){
	abierta=false;
	}
	void abre_llave()
	{
	if(abierta)
	System.out.println("Ya esta abierta");
	else
	 abierta=true;		
	} 
	void cierraLlave()
	{
	if(abierta)
	abierta=false;
	else
		System.out.println("Ya esta cerrada");
	}

}
