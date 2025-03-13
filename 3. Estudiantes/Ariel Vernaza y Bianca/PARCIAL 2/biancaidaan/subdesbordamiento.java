import java.lang.Throwable.*; 

public class SubDesbordamiento extends Exception
{
	public boolean subdesbo;//true subdesbordado, false aun hay agua en el tanke
	double galon;
	
	SubDesbordamiento(double b)
	{
		subdesbo = true;
		galon = b;
	}
}
