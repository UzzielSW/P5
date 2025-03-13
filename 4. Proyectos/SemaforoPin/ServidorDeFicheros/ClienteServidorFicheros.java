import java.io.*; 
import java.rmi.*;

public class ClienteServidorFicheros {
   public static void main(String argv[]) {
      if(argv.length != 2) {
        System.out.println("Usar ClienteServidorFicheros: nombreFichero nombreMaquina");
        System.exit(0);
      }
      try {
         String nombre = "//" + argv[1] + "/ServidorFicheros";
         ServidorFicheros fs = (ServidorFicheros) Naming.lookup(nombre);
	 File fi=fs.open(argv[0]);
	 for (int i=0; i < 5; i++) {
           byte[] datos=fs.read(fi,10);
	   System.out.println("datos de "+argv[0]+" "+(new String(datos)));
	   Thread.sleep(2000);
	 }
      } catch(Exception e) {
         System.err.println("FileServer exception: "+ e.getMessage());
         e.printStackTrace();
      }
   }
}