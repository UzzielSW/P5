import java.rmi.Remote;
import java.rmi.RemoteException;
import java.io.File;

public interface ServidorFicheros extends Remote {
	   public File open(String nombreFichero) throws
	   RemoteException;
	   public byte[] read(File in, int numBytes) throws
	   RemoteException;
	}
