/*
 * InterfaceRemota.java
 *
 * Created on 27 de abril de 2004, 21:17
 */

package chuidiang.ejemplos.rmi.suma;

import java.rmi.*;
import java.io.Serializable;

/**
 * Interface remota con los m�todos que se podr�n llamar en remoto
 * @author  Javier Abell�n
 */
public interface InterfaceRemota extends Remote {
    public int suma (int a, int b) throws RemoteException; 
}
