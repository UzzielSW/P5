import java.io.*;
/*
 * Esta clase generar el archivo de texto
 * @author David Rodríguez
 * */
public class write {
	private static	ListaS lisC=null;
	private static	Nodo nodoactual = null;

	public static void main(ListaS lis) {
		if(lisC==null){lisC=lis;
		nodoactual =lisC.total();
		}
		java.io.PrintStream ps;
		 try {
		 ps = new java.io.PrintStream( new java.io.FileOutputStream("archivo.txt"));
		 for(int i=0;i<lisC.tamT();i++){
		 ps.println(""+nodoactual.CCuenta);
		 ps.println(""+nodoactual.Nombre);
		 ps.println(""+nodoactual.Apellido);
		 ps.println(""+nodoactual.SaldoA);
		 ps.println(""+nodoactual.SaldoC);
		 nodoactual=nodoactual.nodoDer;
		 }
		 
		 ps.close();
		 } catch (FileNotFoundException e) {
		 e.printStackTrace();
		 }
	}

}
