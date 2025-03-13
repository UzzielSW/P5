public class TestIdaan
{
	public static void main(String[] Args)
	{
		Idaan tanque1 = new Idaan(10, 1);
		Llave llave1 = new Llave();//anade a tanque 1
		Llave llave2 = new Llave();//saca agua
		Llave llave3 = new Llave();//saca agua del 2 y anade al 1 
		Idaan tanque2 = new Idaan(5, 5);
		
		try
		{
			tanque1.anadirAgua(1);
			/*llave1.abre();			
			llave1.cierra();
			llave2.abre();
			*/tanque1.quitarAgua(4);
			/*llave2.cierra();
			llave1.abre();
			tanque1.anadirAgua(9);
			llave1.cierra();
			tanque1.anadirAgua(1);*/
			
		}
		catch(Desbordamiento e)
		{
			System.out.println("Se lleno el tanque 1 ^o^...Anadiendo al tanque dos");
			try{tanque2.anadirAgua(e.galon);
			}catch(Desbordamiento a){}
		}
		
		catch(SubDesbordamiento e)
		{
			System.out.println("Ya esta vacio el tanque 1 ^o^...Anadiendo al tanque 1 del tanque dos");
			
			try
			{
			tanque1.anadirAgua(tanque2.volumen);
			System.out.println("Vaciando el tanque 2... ");	
			tanque2.volumen=0;
			tanque1.quitarAgua(e.galon);
			}
			catch(Desbordamiento a){}
											
			catch(SubDesbordamiento w){}
			
		}
	}
}
