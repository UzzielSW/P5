// Soluci�n al problema de Lectores-Escritores con monitores:
//
// Este problema se puede enfocar desde varias perspectivas.
// A continuaci�n se plantean algunas de ellas:
//
// 1) El monitor se emplea para adquirir los derechos para
// leer o escribir. Se lee o escribe desde fuera del monitor.
// Este enfoque puede ser �til cuando el tiempo necesario para realizar la
// la operaci�n de lectura o escritura es demasiado alto. Entonces,
// en el monitor se adquiere el permiso para leer o escribir
// y estas operaciones se realizan desde fuera.
//
// El problema de esta soluci�n es que hay que seguir un protocolo
// para leer o escribir: primero se pide permiso para operar
// sobre los datos y luego se realizar la operaci�n. Si alg�n proceso
// no siguiera este esquema, no se cumplir�an los requisitos del
// problema para leer o escribir.

public class ejecutarLectorEscritor {


	public static void main(String[] args) {
		
		final int nLectores     = 10;
		final int nEscritores   = 4;
		gestorOperaciones  elGestor  = new gestorOperaciones();
		lector[]   losLectores   = new lector[10];
		escritor[] losEscritores = new escritor[4];
				
		for (int i = 0; i < nEscritores; i++ ) {
			losEscritores[i] = new escritor(elGestor, i);
			losEscritores[i].start();
		}
		for (int i = 0; i < nLectores; i++ ) {
			losLectores[i] = new lector(elGestor, i);
			losLectores[i].start();
		}
	}
}
