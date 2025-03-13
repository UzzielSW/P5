
public class validaDatos {

	   private static final int nDatos = 3;
	   private int []  valores = new int[] {0, 0, 0}; 
	   private boolean [] disponible = new boolean [] {false, false, false};
	   private boolean lleno = false;
	
	   public synchronized void insertarDato1 (int valor) 
	       throws InterruptedException {
		   while (disponible[0]) wait();
		   disponible[0] = true;
		   valores   [0] = valor;
		   lleno         = disponible [0] && disponible[1] && disponible[2];
           notifyAll();		   
	   }

	   public synchronized void insertarDato2 (int valor) 
           throws InterruptedException {
	   
		   while (disponible[1]) wait();
		   disponible[1] = true;
		   valores   [1] = valor;
		   lleno         = disponible [0] && disponible[1] && disponible[2];
		   notifyAll();		      
	   }
	   
	   public synchronized void insertarDato3 (int valor) 
           throws InterruptedException {
	   
		   while (disponible[2]) wait();
		   disponible[2] = true;
		   valores   [2] = valor;
		   lleno         = disponible [0] && disponible[1] && disponible[2];
		   notifyAll();		   
       }
	   
	   public synchronized claseError controlar ()
       throws InterruptedException {
	
		   boolean resultado     = true; 
		   procesos procesoFallo = procesos.pr1;
		   
		   while (!lleno) wait();

		   if (!((valores[0] == valores[1]) || (valores[0] == valores [2]))) {
		       resultado    = true;
		       procesoFallo = procesos.pr2;}

		   if (!((valores[0] == valores[1]) || (valores[1] == valores [2]))) {
			   resultado    = true;
			   procesoFallo = procesos.pr3;}

		   if (!((valores[0] == valores[2]) || (valores[1] == valores [2]))) {
			   resultado    = true;
			   procesoFallo = procesos.pr1;}
		   
		   if ((valores[0] == valores[2]) && (valores[1] == valores [2])) {
			   resultado    = false;           // Si no hay errores, entonces no 
			   procesoFallo = procesos.pr1;	// importa el valor de procesoFallo	   
		   }
		   
		   for (int i = 0; i<nDatos; i++) disponible [i] = false;
		   lleno = false;	
		   notifyAll();
		   return new claseError(resultado, procesoFallo);		   
  }
}
