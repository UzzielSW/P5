public class simulaAparcamiento {
	
	public static void main(String[] args) {

		java.util.Random generador = new java.util.Random(System.currentTimeMillis());
		int paraEmpezar     = 7;
		int nCoches         = 60;
		int idCoche         = 0;
		long retardoInicial;
		long maxRetardoInicial = 4000; //milisegundos
		gestorAparcamiento elGestor = new gestorAparcamiento();
		
		//creo unos cuantos coches para empezar
		for (int i = 0; i < paraEmpezar; i++) {
			
			retardoInicial = (long) (maxRetardoInicial * generador.nextFloat());
		    new    cocheNorte(elGestor, idCoche, retardoInicial); 
		    idCoche++;
		    
			retardoInicial = (long) (maxRetardoInicial * generador.nextFloat());
			new    cocheSur(elGestor, idCoche, retardoInicial);
			idCoche++;
		}
		//Luego voy creando poco a poco
		
		try{

			for (int i = paraEmpezar; i < nCoches; i++){
				
				retardoInicial = (long)(maxRetardoInicial * generador.nextFloat());
				new cocheSur(elGestor, idCoche, retardoInicial);
				idCoche++;
				
				retardoInicial = (long)(maxRetardoInicial * generador.nextFloat());
				new cocheNorte(elGestor, idCoche, retardoInicial);
				idCoche++;
				
				Thread.sleep(1000);
				retardoInicial = (long)(maxRetardoInicial * generador.nextFloat());
				new cocheSur(elGestor, idCoche, retardoInicial);
				idCoche++;
			}
		}
		catch (InterruptedException e) {}	
	}
}
