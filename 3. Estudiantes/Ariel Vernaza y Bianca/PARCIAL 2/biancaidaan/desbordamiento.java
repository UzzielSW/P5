import java.lang.Throwable.*; 

public class Desbordamiento extends Exception
{
	public boolean desbo;//true desbordado, false aun hay espacio en el tanke
	public double galon;
	
	Desbordamiento(double galones)
	{
		desbo = true;
		galon = galones;
		
	}
}

