public class Airport{
	
	public void reservar(int n, Puesto x[]){
		int puesto, i;
		String nombre;
		
		for ( i=0; i < n; i++){
			System.out.println("\n\n\n modulo de reservas \n");
			System.out.println(" elija un puesto a reservar");
			
			puesto = i+1;
			
			System.out.println(" el puesto esta " + x[puesto-1].verificaPuesto() );
			while( x[puesto-1].verificaPuesto() == "ocupado"){
				System.out.println(" \n\n corrija el puesto a reservar");
				puesto = 2;
				System.out.println(" el puesto esta " + x[puesto-1].verificaPuesto() );
			}
			
			nombre = "Aristides";
			x[puesto-1].setName(nombre);
			System.out.println(" se reservo el puesto " + x[puesto-1].getNumber() );
		}
	}
	
	public int impresion(Puesto [] x, Puesto [] y){
		int i, ocupado = 0;
		
		System.out.println(" impresion de reservaciones del area no-fumador \n puestos del 1 al 5");
		for ( i=0; i<x.length; i++){
			if(x[i].verificaPuesto() == "ocupado" ) ocupado++;
			x[i].display();
		}
		System.out.println(" Area Fumador\n puesto del 6 al 10");
		for ( i=0; i<y.length; i++){
			if(y[i].verificaPuesto() == "ocupado" ) ocupado++;
			y[i].display();
		}
		return ocupado;
	}
	
		public static void main(String [] args){
		int n,i,p;
		char opcion= '1';
		
		Puesto fumadores[] = new Puesto[5]; // crea el arreglo para fumadores
		Puesto noFumadores[] = new Puesto[5]; // crea el arreglo para no fumadores
		
		for ( i = 0; i< noFumadores.length; i++) // asigna los numeros a los puestos del 1 al 5
			fumadores[i] = new Puesto ( i + 1);
		
		for ( i = 0; i< fumadores.length; i++)// asigna los numeros a los puestos del 6 al 10
			fumadores[i] = new Puesto ( i + 6);
		do{
		System.out.println(" \n\n\n\n");
		System.out.println(" \t\t\tMENU");
		System.out.println("\t1. reservacion del area de no-fumadores");
		System.out.println("\t2. reservacion del area de fumadores");
		System.out.println("\t3. impresion de reservas");
		System.out.println("\t4. Finalizar reservas");
		System.out.println("\tElija un opcion");
		opcion = JOptionPanel.show.InputDialog(" ");
			switch(opcion){
				case '1':
					System.out.println("\t establezca el numero de resrvaciones");
					n= 3;
					reservar(n,noFumadores);
					break;
				case '2':
					System.out.println("\t establezca el numero de resrvaciones");
					n= 2;
					reservar(n,fumadores);
					break;
				case '3':
					p=impresion(noFumadores, fumadores);
					System.out.println("cantidad de puestos reservados " + p);
					break;
				case '4':
					System.out.println(" fin del programa");
				default:
					System.out.println("opcion invalida - elija una entre 1 y 4");
			}
		}while(opcion != '4');
	}
}
