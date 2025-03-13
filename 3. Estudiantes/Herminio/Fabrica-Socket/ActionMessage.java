/**
 * @(#)ActionMessage.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/12/31
 */
 
import java.io.*;
import javax.swing.*;

/**
 * <code>ActionMessage</code> es una clase abstracta usada para la comunicacion entre los clientes (Persona y Supervisor)
 * y la clase <code>ManejaHilos</code>, al ser abstracta no es usada directamente, solo se usa
 * como plantilla para unificar los mensajes producidos por una Persona y un Servidor
 *
 * @see PersonaMessage
 * @see SupervisorMessage
 * @see ManejaHilos
 */
public abstract class ActionMessage implements Serializable
{
	/**
	 * Ejecuta una accion en la caja
	 *
	 * @param caja La caja donde se ejecutara la accion
	 * @param jtArea Un area de texto donde se mostraran mensajes
	 */
	public abstract void doAction(Caja caja, JTextArea jtArea);
}