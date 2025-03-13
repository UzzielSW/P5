
public class barberiaOrden {
//	 Suposiciones:
	// - El barbero corta el pelo fuera del objeto protegido
	//   Si lo cortara dentro, seria menos realista la simulacion
	//   del tiempo en que se tarda en hacer esta operacion. Si
	//   no se hace este retardo, es decir si el tiempo de corte
	//   de pelo fuera practicamente 0, no habria casi nunca
	//   procesos esperando.
	// - Se simula la silla del barbero y las sillas de la sala
	//   de espera.

	// En esta versi—n se respeta el orden de entrada 
	// a la barber’a para cortarse el pelo. En la versi—n
	// anterior, el orden depende de la gesti—n de las colas
	// de procesos.

	private int nSillasEspera;
	private int nSillasEsperaOcupadas = 0;
	private boolean sillaBarberoOcupada = false;
	private boolean finCorte = false;
	private boolean barberoDormido = false;
	
	//Implementar la cola de espera
	  int[] Caja;  
	  int Primero, Ultimo, Numero;
	
	//JAVA: s—lo puede haber N_Sillas_Espera_max hebras 
	//esperando dentro del monitor a que le toque.

	  public barberiaOrden(int nSillasEspera) {
		  this.nSillasEspera = nSillasEspera;
		  Caja= new int[nSillasEspera];
		  Primero = 0;
		  Ultimo = 0;
		  Numero = 0;
	  }
		    
	    private void Pon(int X)  {
	    	Caja[Ultimo] = X; 
	    	Ultimo = (Ultimo + 1) % Caja.length;
	    	++Numero;
	    }
	    
	    private int Primero(){
	    	return Caja[Primero];
	    }
	    
	    private void Quita()  {
//	    	int X = Caja[Primero]; 
	    	Primero = (Primero + 1) % Caja.length;
	    	--Numero;
//	    	return X;
	    } 
	    
	  public synchronized boolean entrar(int clienteId)
	      throws InterruptedException {
		  
	   if (nSillasEsperaOcupadas == nSillasEspera) {
		   // Si no hay sillas libres, me voy sin cortar el pelo
			System.out.println
				(":(:( El cliente " + clienteId + " se va sin cortarse el pelo");
		   return false; }
	   else { 
		   //Me quedo esperando si la silla del barbero está
		   //ocupada
		   nSillasEsperaOcupadas ++;
		   Pon(clienteId);
  		   System.out.println
  		   		("**** El cliente " + clienteId + " se sienta en la silla de espera");
		   while (sillaBarberoOcupada || (Primero() != clienteId)) {wait();}
	
		   //Desocupo la silla de espera 
		   nSillasEsperaOcupadas --;
		   Quita();

		   //Me siento en la silla del barbero 
		   sillaBarberoOcupada = true;
		   finCorte = false;
		   
		   //Si el barbero está dormido le despierto
		   if (barberoDormido) {
			   notifyAll();}
		   
		   //Espero a que me corte el pelo
		   System.out.println
		   	    ("<<<< El cliente " + clienteId + " en la silla de barbero");
		   while (!finCorte) {wait();}
		   
		   sillaBarberoOcupada = false;

		   //Que pase el siguiente
		   notifyAll();
		   
		   System.out.println
		       (":)!! El cliente " + clienteId + " se va con el pelo cortado");
		   return true;
	   }

	  }

	   public synchronized void esperarCliente()
	      throws InterruptedException {

		   //El barbero espera a que llegue un cliente
		   //Se supone que le corta el pelo fuera del 
		   //monitor
		   barberoDormido = true;
		   while(!sillaBarberoOcupada) {
			   System.out.println("++++ Barbero esperando cliente");
			   wait();
			   }
		   barberoDormido = false;		   
		   System.out.println("++++ Barbero cortando el pelo");
	   }
	   
	   public synchronized void acabarCorte(){
		   finCorte = true;
		   System.out.println("++++ Barbero termina de cortar el pelo");
		   notifyAll();
	   }

}

