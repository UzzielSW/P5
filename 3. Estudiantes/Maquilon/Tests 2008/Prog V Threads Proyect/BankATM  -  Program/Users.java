

/**
 * @(#)Users.java
 *
 * @author Maquilón S.
 * @version 3.00 2008/12/18
 */

package clases;

import java.awt.*;

import java.io.*;

import java.util.*;

import javax.swing.*;

 /**
  *Esta es mi clase para el control de la Impresión de Usuarios
 *@version 1.0
 */

public class Users extends JFrame
{	
	String referencia;
	
	JTextArea textArea;
	
	/**
	 *Constructor de la Clase Usuarios
	 *En el se controla de una forma detallada la impresion de cada usuario registrado en el programa
	 *@version 1.0
	 */
	
	public Users()
	{	
			LinkedList Lista = new LinkedList();
			
			try{
			
			ObjectInputStream sacar = new ObjectInputStream(new FileInputStream(new File("clientes.txt"))); 			
        	
        	Lista = (LinkedList) sacar.readObject();
        	
        	JPanel cabecera = new JPanel();
        	
        	int cantidad = Lista.size();
        	
        	Vector search = new Vector();
     		
     		JLabel n = new JLabel("Nombre             ");
        	
        	JLabel a = new JLabel("Apellido             ");
        	
        	JLabel c = new JLabel("Cedula               ");
			
			n.setForeground(Color.white);
			
			a.setForeground(Color.white);
			
			c.setForeground(Color.white);
        	
        	cabecera.add(n);
        	
        	cabecera.add(a);
        	
        	cabecera.add(c);
         
       	cabecera.setBackground(Color.black);
       	
       	
       	////////////	IMPRESION DE USUARIOS     ////////////
       	
		
		Container contentPane = this.getContentPane();
		
		textArea = new JTextArea();
		
		textArea .append("\n\n");
		
		for(int x=0;x<Lista.size();x++)
        {
   		
   		search = (Vector) Lista.get(x);
   		
   		String name = search.get(0).toString();
       	
       	String last_n = search.get(1).toString();
       	
       	String id = search.get(2).toString();
   		
   		textArea.append("                              "+name+"                   "+last_n+"                   "+id+"\n\n");
        
        }
        
        textArea.setBackground(Color.white);
		
		JScrollPane pane = new JScrollPane(textArea,
		
					ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
		
					ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		contentPane.add(cabecera,BorderLayout.NORTH);
		
		contentPane.add(pane, BorderLayout.CENTER);
		
		this.setBounds(350,336,462,200);
		
		this.setVisible(true);
        
        	}catch(Exception e){}
	}
	
}
