
import java.io.File;
import java.io.FileInputStream;
import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import java.util.Map;
import java.util.HashMap;

public class ServidorFicherosImpl extends UnicastRemoteObject
  implements ServidorFicheros {

   private java.util.Map<File,FileInputStream> ficheros;
   protected String nombre;

   public ServidorFicherosImpl(String s) throws RemoteException{
      super();
      nombre = s;
      ficheros = new HashMap<File,FileInputStream>();
   }

   public synchronized File open(String nombreFichero) {
     System.out.println("open "+nombreFichero);
     try {
       File key=new File(nombreFichero);
       FileInputStream input=new FileInputStream(key);
       ficheros.put(key,input);
       return key;
     } catch (Exception e) {
       System.err.println("Error haciendo open de : "+nombreFichero);
       e.printStackTrace();
       return null;
     }
   }

   public synchronized byte[] read(File in, int numBytes) {
     System.out.println("read");
     if (in == null) {
       System.err.println("Error haciendo read sobre un fichero no inicializado");
       return null;
     }
     try {
       byte[] buf=new byte[numBytes];
       FileInputStream input=ficheros.get(in);
       if (input == null) {
         System.err.println("Error haciendo read de : "+in.getName());
         return null;
       }
       input.read(buf);
       return buf;
     } catch (Exception e) {
       System.err.println("Error haciendo read de : "+in.getName());
       e.printStackTrace();
       return null;
     }
   }

   public static void main(String argv[]) {
      if(System.getSecurityManager() == null) {
         System.setSecurityManager(new RMISecurityManager());
      }
      try {
         ServidorFicheros fi = new ServidorFicherosImpl("ServidorFicheros");
         Naming.rebind("//127.0.0.1/ServidorFicheros", fi);
      } catch(Exception e) {
         System.out.println("ServidorFicheros: "+e.getMessage());
         e.printStackTrace();
      }
   }
}

