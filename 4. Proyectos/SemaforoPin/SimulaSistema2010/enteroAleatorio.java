
public class enteroAleatorio {

	java.util.Random generador = new java.util.Random(System.currentTimeMillis());	
	
	public int otroEntero() {

		return generador.nextInt();
	}
	
}
