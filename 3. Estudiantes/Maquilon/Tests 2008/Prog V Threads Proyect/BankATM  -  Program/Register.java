 
 
/**
 * @(#)Register.java
 *
 * @author Maquilón S.
 * @version 3.00 2008/12/18
 */
 
package clases;
 
import java.awt.*;

import javax.swing.*;

import java.awt.event.*;

import javax.swing.border.*;

import java.io.*;


	/**
	 *Esta es la Clase Register
	 *En ella se ejerce el control de registro de Usuarios(nuevos clientes).
	 *@version 1.0
	 */

public class Register
{
	
	String nombre, apellido, cedula, contrasena;
	
	double dep;
	
	int c;
	
	JDialog registro;
	
	JFrame f;
	
	JTextField name1, pass1, last_name, id, inicio;
	
	JButton accept1, cancel1, clear1;
	
	double m;
	
	String na, ap, ce, pa;
	
 	boolean validanom, validaape, validaced, validamonto1,validamonto2;
	
	/**
	 *Constructor de la Clase Register
	 *En el se ejecuta el control de registro de usuarios, tambien se crea la Interfaz 
	 *gráfica en donde interactuará el correspondiente Usuario.
	 *@param d Trae una referencia de La Clase Principal, la cual extiende de JFrame(un JFrame)
	 */
	
	public Register(JFrame d)
	{
			f = d;		
			
			registro = new JDialog(f,"Welcome! - Register System",true);
			
			registro.setBounds(350,285,462,415);
			
			name1 = new JTextField(15);
			
			JLabel username1  = new JLabel("Name");
			
			username1.setBounds(25,50,50,30);
			
			name1.setBounds(110,55,150,20);
			
			last_name = new JTextField(15);
			
			JLabel Last_name  = new JLabel("Last Name");
			
			Last_name.setBounds(25,80,100,30);
			
			last_name.setBounds(110,85,150,20);
			
			id = new JTextField();
			
			JLabel ID  = new JLabel("ID");
			
			ID.setBounds(25,118,15,20);
			
			id.setBounds(110,118,150,20);
			
			pass1 = new JPasswordField();
			
			JLabel password1  = new JLabel("Insert your new Password");
			
			password1.setBounds(25,150,150,20);
			
			pass1.setBounds(180,150,80,20);
			
			inicio = new JTextField(15);
			
			JLabel monto  = new JLabel("Monto Inicial");
			
			monto.setBounds(25,240,150,20);
			
			inicio.setBounds(180,240,80,20);
			
			JPanel title_Border = new JPanel();
			
			title_Border.setLayout(null);
		
			title_Border.setBounds(68,30,310,278);
			
			title_Border.setBorder(BorderFactory.createTitledBorder("Personal Data"));
			
			title_Border.add(username1);
			
			title_Border.add(name1);
			
			title_Border.add(Last_name);
			
			title_Border.add(last_name);
			
			title_Border.add(ID);
			
			title_Border.add(id);
			
			title_Border.add(password1);
			
			title_Border.add(pass1);
			
			title_Border.add(monto);
			
			title_Border.add(inicio);
			
			title_Border.setBackground(Color.white);
			
			JLabel terms1 = new JLabel("Bienvenidos a Capital Bank, para iniciar una cuenta ");
			
			JLabel terms2 = new JLabel("en este Banco su monto inicial debe ser mayor a 10.00");
    		
    		Font sistema = new Font("Times new Roman",Font.PLAIN,12); 
    		
    		terms1.setFont(sistema);
    		
    		terms2.setFont(sistema);
    		
			accept1 = new JButton("Submit");
			
			JButton cancel1 = new JButton("Cancel");
			
			JButton clear1 = new JButton("Clear");
			
			terms1.setBounds(25,140,250,100);
			
			terms2.setBounds(25,160,305,100);
			
			accept1.setBounds(73,318,95,25);
			
			cancel1.setBounds(176,318,94,25);
			
			clear1.setBounds(278,318,95,25);
			
			////////////////////////////////////////////////
			
			cancel1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					String boton = e.getActionCommand();
					
					if(boton.equals("Cancel"))
					
					registro.hide();
				}
			});
			
			///////////////////////////////////////////////
			
			clear1.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					String boton = e.getActionCommand();
					
					if(boton.equals("Clear"))
					
					name1.setText("");
					
					last_name.setText("");
					
					id.setText("");
					
					pass1.setText("");
					
					inicio.setText("");
					
				}
			});
			
			///////////////////////////////////////////////
			
			accept1.addActionListener(new ActionListener()
			{
			public void actionPerformed(ActionEvent e)
			{	
				if(name1.getText().equals("") || last_name.getText().equals("") || id.getText().equals("") || pass1.getText().equals("") ||			
			
				inicio.getText().equals(""))
				{
			
				JOptionPane.showMessageDialog(f,
    		
    			"Llene todos los campos, por favor",
    		
    			"Inane warning",
    		
    			JOptionPane.WARNING_MESSAGE);
			
			}		   
				 else
	  		     {								   					
							na = name1.getText();
			
							ap = last_name.getText();
								
							ce = id.getText();
					
							pa = pass1.getText();
								
					try {
								
					Integer.parseInt(na);}catch(NumberFormatException error){validanom=true;}
								
					try{
								
					Integer.parseInt(ap);}catch(NumberFormatException error){validaape=true;}
								
					try{
								
					Integer.parseInt(ce);}catch(NumberFormatException error){validaced=true;}
								
					try{
					
					validamonto1=true;
					
					m = Double.parseDouble(inicio.getText());
					
					if(m<10 || m==0.0){JOptionPane.showMessageDialog(f,
    									
    									"Debe iniciar con un monto mayor a 10.00",
    									
    									"Ingrese",
    									
    									JOptionPane.ERROR_MESSAGE); registro.hide(); 
    		
    									validamonto1=false;}
    																
    									}catch(NumberFormatException s){
			
										JOptionPane.showMessageDialog(f,
    							
    									"El Monto depositado no es correcto!, sea serio",
   	
   										"Inane error",
    				
    									JOptionPane.ERROR_MESSAGE);}
    					try{		
    								
    					m = Double.parseDouble(inicio.getText());
									
						validamonto2=true;
							
							}catch(Exception u){JOptionPane.showMessageDialog(f,
   								
   												"El Monto depositado no es correcto!, sea serio",
    						
    											"Inane error",
    	
    											JOptionPane.ERROR_MESSAGE);validamonto2=false;}
								
						if(validanom==true && validaape==true && validaced==true && validamonto1==true && validamonto2==true)
						{
							try{								
							
								JOptionPane.showMessageDialog(f,
    						
    							"Bienvenido a este Banco",
    						
    							"Inane warning",
    						
    							JOptionPane.WARNING_MESSAGE);
    						
    							Accounts cuentas = new Accounts(na,ap,ce,pa,m);
    						
    							registro.hide();}catch(Exception clase){}
    						
    							}
							
								else
								{
									
									JOptionPane.showMessageDialog(f,
    								
    								"Algun campo es erroneo!, increible, sea serio compa!",
    								
    								"Inane error",
    								
    								JOptionPane.ERROR_MESSAGE); registro.hide();
								}
							}
						}	
			});
			
			
			JPanel background = new JPanel();
			
			background.setLayout(null);
			
			title_Border.add(terms1);
			
			title_Border.add(terms2);
			
			accept1.setBackground(Color.black);
			
			cancel1.setBackground(Color.black);
			
			clear1.setBackground(Color.black);
			
			accept1.setForeground(Color.white);
			
			cancel1.setForeground(Color.white);
			
			clear1.setForeground(Color.white);
			
			background.add(accept1);
			
			background.add(cancel1);
			
			background.add(clear1);
			
			background.add(title_Border);  
			
			background.setBorder(BorderFactory.createLineBorder(Color.black));
			
			background.setBackground(Color.white); 
			
			registro.add(background);
			
			registro.show();
		}	  
}      	