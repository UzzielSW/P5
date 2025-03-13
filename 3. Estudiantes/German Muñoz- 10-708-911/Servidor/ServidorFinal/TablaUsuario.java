import java.io.File;
import java.io.FileInputStream;
/**
 *La clase TablaUsuario es la clase utilizada para crear la tabla
 *en la que se mostrara todos lo usuarios registrados.
 */

import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.*;
import java.io.*;

public class TablaUsuario extends JFrame
{
	Object Columnas[]={"Nombre.","Apellido","Contraseña","Saldo","Apertura"};
    Object datos[][];
    private static LinkedList list=new LinkedList();
    JTable table;
  
/**
 *Contructor de la Clase TablaUsuario.
 */
 
public TablaUsuario()
{
   	JFrame frame = new JFrame();
   	
    try{
    	
    /*Lectura de los datos del Archivo "Usuarios.txt", para colocarlos en una Tabla*/
    ObjectInputStream lee= new ObjectInputStream(new FileInputStream(new File("Usuario.txt")));
    LinkedList lista=new LinkedList();
    lista=(LinkedList)lee.readObject();
    
    list=lista;//Luego asignamos a LinkedList al objeto que realizar la lectura de nuestro archivo
    
    Iterator iterator=lista.iterator();
    datos=new Object[lista.size()][5];
    int j=0;
    
    while(iterator.hasNext())
	{
		Customer usuarios=(Customer)(iterator.next());
				
		datos[j][0]=usuarios.getNombre();
        datos[j][1]=usuarios.getApellido();
        datos[j][2]=usuarios.getContrasenia(); 
//        datos[j][3]=usuarios.getCuenta();
        datos[j][3]=usuarios.getAccount().getBalance();
        datos[j][4]=usuarios.getTcuenta(); 
        j++;         
    }   
    
	}catch(Exception w)
        {
			w.printStackTrace();
			System.out.println(w);
		}
    
    table=new JTable(datos,Columnas);

    JScrollPane scrollPane = new JScrollPane(table);
    frame.add(scrollPane, BorderLayout.CENTER);
    frame.setBounds(80,250,900,400);
    frame.setVisible(true);
  }
}