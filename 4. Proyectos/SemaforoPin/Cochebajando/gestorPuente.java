
//NOTA: Según el enunciado, puede haber varios coches en el puente
//	simultáneamente, lo que se representa en las variables Número_Subiendo
//	y Número_Bajando. Lo que no puede haber son coches subiendo y bajando
//	simultaneamente. Si sólo pudiera haber un coche en el puente, se
//	podría representar mediante una variable que indicara si el puente
//	está ocupado y con otra que indique el sentido de marcha actual

public class gestorPuente {
	
	//Número de coches subiendo o bajando
    private int l’miteEnEspera = 8; // Lo puede dar el constructor
	private int nœmeroBajando  = 0;
	private int nœmeroEsperandoBajar = 0;
	private int nœmeroSubiendo = 0;
	private int nœmeroEsperandoSubir = 0;

	
	public synchronized void entrarSubiendo(int idCoche)
		throws InterruptedException{
	
		nœmeroEsperandoSubir++;
		System.out.println("++++ El coche que sube " + idCoche + " intenta entrar en el puente "
				           + nœmeroEsperandoSubir);

		
		while (nœmeroBajando > 0 || 
			   (nœmeroEsperandoBajar > l’miteEnEspera &&
			    nœmeroEsperandoSubir < l’miteEnEspera)) 
		{wait();}
		
		nœmeroEsperandoSubir--;		
		nœmeroSubiendo++;		
		
		System.out.println("++++ El coche que sube " + idCoche + " entra en el puente "
		           + nœmeroEsperandoSubir + " " + nœmeroSubiendo);
		
	}

	public synchronized void salirSubiendo(int idCoche){
		nœmeroSubiendo--;
		System.out.println("++++ El coche que sube " + idCoche + " sale del puente "
		                   + nœmeroEsperandoSubir + " " + nœmeroSubiendo);

		if (nœmeroSubiendo == 0 ||
			(nœmeroSubiendo > 0 && 
			  (nœmeroEsperandoSubir > 0 &&
			   (nœmeroEsperandoSubir > l’miteEnEspera ||
			    nœmeroEsperandoBajar < l’miteEnEspera)))) 
		{notifyAll();}
	}

	
	public synchronized void entrarBajando(int idCoche)
	    throws InterruptedException{

		nœmeroEsperandoBajar++;
		System.out.println("---- El coche que baja " + idCoche + " intenta entrar en el puente "
				           + nœmeroEsperandoBajar);
		
		while (nœmeroSubiendo > 0 || 
			  (nœmeroEsperandoSubir > l’miteEnEspera)) 
		{wait();}
		
		nœmeroEsperandoBajar--;		
		nœmeroBajando++;
		
		System.out.println("---- El coche que baja " + idCoche + " entra en el puente "
				           + nœmeroEsperandoBajar + " " +nœmeroBajando);
	}

	public synchronized void salirBajando(int idCoche){
		nœmeroBajando--;
		System.out.println("---- El coche que baja " + idCoche + " sale del puente " 
                           + nœmeroEsperandoBajar + " " + nœmeroBajando);

		// No ejecuto notifyAll si no es necesario
		if (nœmeroBajando == 0 || 
		    (nœmeroBajando > 0        && 
		     nœmeroEsperandoBajar > 0 &&
		     nœmeroEsperandoSubir < l’miteEnEspera)) 
		    {notifyAll();}
	}

}
