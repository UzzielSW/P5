/*
 * InterfaceRemota.java
 *
 * Created on 27 de abril de 2004, 21:17
 */

package chuidiang.ejemplos.rmi.suma;

import java.rmi.*;
import java.io.Serializable;

/**
 * Interface remota con los métodos que se podrán llamar en remoto
 * @author  Javier Abellán
 */
public interface InterfaceRemota extends Remote {
    public int suma (int a, int b) throws RemoteException; 
}
