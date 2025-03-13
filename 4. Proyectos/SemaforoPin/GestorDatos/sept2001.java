public class sept2001 {

	public static void main(String[] args) {

		int periodoMuestreo = 1500;
		int nMuestras       =   50;
		
		gestorDatos   elGestor  = new gestorDatos(nMuestras);
		new lectorPresion     (periodoMuestreo ,elGestor);
		new lectorTemperatura (periodoMuestreo ,elGestor);
		new procesadorDatos   (3*periodoMuestreo, elGestor);
		
	}

}
