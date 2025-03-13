
import java .awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

/**
 * @(#)ViewAccounts.java
 *
 *
 * @author  Ronnie Rodríguez
 * @version 1.00 2009/10/16
 */

public class ViewAccounts extends JDialog implements Serializable
{
        
   
     	private String[] encabezado;
     	private JTable table;
     	private Object[][] data;
     	private Create_User crea;
     	private Customer cli;
     	private static int w;
        private LinkedList <Customer> lits;
     
   	        	
    //* Constructor*/	
    public ViewAccounts(LinkedList <Customer> lita ) 
    	{
    	lits=lita;
        encabezado=new String[]{"First Name","Last Name","ID","Saldo","Type Account"};
    	data=new Object[lits.size()][1];
		loadData();
		table=new JTable(data,encabezado);	
	  	this.add(new JScrollPane(table));
    	
    	setSize(600,200);
    	setLocationRelativeTo(null);
    	setVisible(true);
    	
    	
    	}
        
 
     //* Metodo para cargar los datos en la tabla*/
    public void loadData()
    	{
    	  
    	  String h,g;
    	
    	for(int i=0;i<lits.size();i++)
    		{
    //Incorporacion de datos llamados de las lista
    		
    		String[] customerData=new String[10];
    		Customer cli=lits.get(i);
    		customerData[0]=cli.getFirstName();
    		customerData[1]=cli.getLastName();
    		customerData[2]= ""+cli.getIdCustomer();
    		customerData[3]= ""+cli.getAccount().getBalance();
    		customerData[4]=""+cli.getTCuenta();
    		
    	    data[i]=customerData;	
    	    }
      } 
      	

    
}
