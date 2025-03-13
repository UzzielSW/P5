
public class laBarberiaOrden {

	public static void main(String[] args) {
		
		final int nSillas     = 4;
		final int nClientes   = 10;

		barberiaOrden  laBarberia  = new barberiaOrden(nSillas);
		barberoOrden  elBarbero   = new barberoOrden(laBarberia);
		clienteOrden[] losClientes = new clienteOrden[10];
		
		elBarbero.start();
		
		for (int i = 0; i < nClientes; i++ ) {
			losClientes[i] = new clienteOrden(laBarberia, i);
			losClientes[i].start();
		}
	}
}
