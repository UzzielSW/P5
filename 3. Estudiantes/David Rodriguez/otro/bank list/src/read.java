import java.io.*;
/*
 * Esta clase es la encargada de recargar la lista
 * @author David Rodríguez
 * */
public class read {
	private static	ListaS lisC = new ListaS();
	private static  int tol=1;
	private static String tem[];

	public static void main(String []arg) {
		tem =new String [5];
		
		java.io.BufferedReader reader;
		try {
			reader = new java.io.BufferedReader(new java.io.InputStreamReader(new java.io.FileInputStream("archivo.txt")));
			String linea=null;
			while (null!=(linea=reader.readLine())){
			tem[tol-1]=linea;
			System.out.println(""+(tol-1)+" Linea:" + tem[tol-1]);
			tol+=1;
			if(tol==6){
				tol=1;
				System.out.println(tem[3].compareTo("0"));
					lisC.carga(Integer.parseInt(tem[0]), tem[1], tem[2], Double.parseDouble(tem[3]), Double.parseDouble(tem[4]));
				
			}
			} 
			}
			
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	ATMClient.main(lisC);		
	}
}
