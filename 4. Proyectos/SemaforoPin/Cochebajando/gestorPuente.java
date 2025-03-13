
//NOTA: Seg�n el enunciado, puede haber varios coches en el puente
//	simult�neamente, lo que se representa en las variables N�mero_Subiendo
//	y N�mero_Bajando. Lo que no puede haber son coches subiendo y bajando
//	simultaneamente. Si s�lo pudiera haber un coche en el puente, se
//	podr�a representar mediante una variable que indicara si el puente
//	est� ocupado y con otra que indique el sentido de marcha actual

public class gestorPuente {
	
	//N�mero de coches subiendo o bajando
    private int l�miteEnEspera = 8; // Lo puede dar el constructor
	private int n�meroBajando  = 0;
	private int n�meroEsperandoBajar = 0;
	private int n�meroSubiendo = 0;
	private int n�meroEsperandoSubir = 0;

	
	public synchronized void entrarSubiendo(int idCoche)
		throws InterruptedException{
	
		n�meroEsperandoSubir++;
		System.out.println("++++ El coche que sube " + idCoche + " intenta entrar en el puente "
				           + n�meroEsperandoSubir);

		
		while (n�meroBajando > 0 || 
			   (n�meroEsperandoBajar > l�miteEnEspera &&
			    n�meroEsperandoSubir < l�miteEnEspera)) 
		{wait();}
		
		n�meroEsperandoSubir--;		
		n�meroSubiendo++;		
		
		System.out.println("++++ El coche que sube " + idCoche + " entra en el puente "
		           + n�meroEsperandoSubir + " " + n�meroSubiendo);
		
	}

	public synchronized void salirSubiendo(int idCoche){
		n�meroSubiendo--;
		System.out.println("++++ El coche que sube " + idCoche + " sale del puente "
		                   + n�meroEsperandoSubir + " " + n�meroSubiendo);

		if (n�meroSubiendo == 0 ||
			(n�meroSubiendo > 0 && 
			  (n�meroEsperandoSubir > 0 &&
			   (n�meroEsperandoSubir > l�miteEnEspera ||
			    n�meroEsperandoBajar < l�miteEnEspera)))) 
		{notifyAll();}
	}

	
	public synchronized void entrarBajando(int idCoche)
	    throws InterruptedException{

		n�meroEsperandoBajar++;
		System.out.println("---- El coche que baja " + idCoche + " intenta entrar en el puente "
				           + n�meroEsperandoBajar);
		
		while (n�meroSubiendo > 0 || 
			  (n�meroEsperandoSubir > l�miteEnEspera)) 
		{wait();}
		
		n�meroEsperandoBajar--;		
		n�meroBajando++;
		
		System.out.println("---- El coche que baja " + idCoche + " entra en el puente "
				           + n�meroEsperandoBajar + " " +n�meroBajando);
	}

	public synchronized void salirBajando(int idCoche){
		n�meroBajando--;
		System.out.println("---- El coche que baja " + idCoche + " sale del puente " 
                           + n�meroEsperandoBajar + " " + n�meroBajando);

		// No ejecuto notifyAll si no es necesario
		if (n�meroBajando == 0 || 
		    (n�meroBajando > 0        && 
		     n�meroEsperandoBajar > 0 &&
		     n�meroEsperandoSubir < l�miteEnEspera)) 
		    {notifyAll();}
	}

}
