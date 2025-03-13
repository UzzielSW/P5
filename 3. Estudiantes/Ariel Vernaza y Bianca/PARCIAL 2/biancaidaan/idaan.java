
public class Idaan 
{
	double capacidad;
	double volumen;
	
	public Idaan(double maximo, double actual)
	{
		capacidad = maximo;
		volumen = actual;
	}
	public double getVolumen()
	{
		return volumen;
	}
	
	public void anadirAgua(double galones) throws Desbordamiento
	{
		if((this.volumen + galones) > this.capacidad)
		{
		 double a = (this.volumen + galones) - this.capacidad;
		 System.out.println("Se ha anadido satistactoriamente "+(galones-a)+"Galones al tanque 1");
		 volumen += galones - a;
		 throw new Desbordamiento(a);	//llama a la ecepcion
		}
		else
		{
		this.volumen += galones;
		System.out.println(" Se ha anadido satisfactoriamente "+galones+" Galones (*o*)");
		}
	}
	
	public void quitarAgua(double galones)throws SubDesbordamiento
	{
		if((this.volumen - galones) > 0)
		{
		volumen -= galones;	
		System.out.println("Se ha quitado satisfactoriamente "+galones+" Galones (*o*)");
		}
		
		else
		{
		double b = galones - this.volumen;
		System.out.println("Se ha quitado satisfactoriamente "+(galones - b)+" Galones  del tanque 1 (*o*)");
		volumen -= galones - b;
		throw new SubDesbordamiento(b);
		}
	}
	
}
