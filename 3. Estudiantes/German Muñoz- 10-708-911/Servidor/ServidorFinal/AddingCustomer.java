
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

/**
 *Clase para agregar los clientes y configuracion de los clientes
 *
 */
public class AddingCustomer extends JFrame implements ActionListener {
		public JTextField JTFNombre   ;  
		public JTextField JTFApellido ;  
		public JTextField JTFApertura ;
		public JTextField JTFNName,JTFLname,JTFChangeuser,JTFKeycurrent,JTFChangeto;
		public JPasswordField JTFNumeroC,JTFCoduser,JTFNcod;
		public JRadioButton JRBCorriente,JRBAhorro,JRBScorriente;
		public JTextArea muestra;
		Customer_R customer;
			Customer Cliente;
		ButtonGroup GBRgrupo;
		LinkedList cargado ;
		String num,password;
		LinkedList list;
		boolean mira;
		public static File customer_file = new File("Usuario.txt");
		
		/**
		 *Muestra el panel principal para agregar y modificar clientes
		 *
		 *
		 **/
	public AddingCustomer(){
		
		super("Adding Customer");
	
		JTabbedPane jtppanel1 = new JTabbedPane ();
		JTabbedPane jtppanel2 = new JTabbedPane ();
	
    	jtppanel1.addTab("Add Customer",null,Addcustomerpane(),"Add Customer");
		jtppanel1.addTab("Setting",null,SettingUser(),"Setting");
		
		getContentPane().add(jtppanel1);
		setLocationRelativeTo( null );
		pack();
		setVisible(true);
	}
	
	/**
	 *Contiene el panel para agregar los clientes 
	 *@return EL panel para agregarse en el panel principal
	 */
	public JPanel  Addcustomerpane (){
		
		ButtonGroup GBRgrupo = new ButtonGroup ();
		
		JLabel JLNombre     = new JLabel ( "Nombre:" );
		JLabel JLApellido   = new JLabel ( "Apellido:" );
		JLabel JLNumeroC    = new JLabel ( "Contraseña:" );
		JLabel JLApertura   = new JLabel ( "Apertura:" );	
			
		JTFNombre    = new JTextField ( 20 );
		JTFApellido  = new JTextField ( 20 ); 
		JTFApertura  = new JTextField ( 20 );
		JTFNumeroC   = new JPasswordField ( 20 );	
		
		JRBCorriente  = new JRadioButton ("CORRIENTE",true);
		JRBAhorro    = new JRadioButton ("AHORRO");
			
		JButton JBAdd    = new JButton ("ADD");
		JButton JBCancel = new JButton ("Cancel");
		
		JPanel Panel1 = new JPanel ();
		JPanel Panel2 = new JPanel ();
		JPanel Panel3 = new JPanel ();
		JPanel Panel4 = new JPanel ();
		JPanel Panel5 = new JPanel ();	
		JPanel Panel6 = new JPanel ();	
		JPanel PPrincipal = new JPanel (new GridLayout(6,2));
		JPanel TOTAL = new JPanel ();
		
		Panel1.add(JLNombre, BorderLayout.WEST);
		Panel1.add(JTFNombre, BorderLayout.EAST);
		Panel2.add(JLApellido, BorderLayout.WEST);
		Panel2.add(JTFApellido, BorderLayout.EAST);
		Panel3.add(JLNumeroC, BorderLayout.WEST);
		Panel3.add(JTFNumeroC, BorderLayout.EAST);
		Panel4.add(JLApertura, BorderLayout.WEST);
		Panel4.add(JTFApertura, BorderLayout.EAST);
		Panel5.add(JRBCorriente, BorderLayout.WEST);
		Panel5.add(JRBAhorro, BorderLayout.EAST);
		Panel6.add(JBAdd, BorderLayout.WEST);
		Panel6.add(JBCancel, BorderLayout.EAST);
		
		PPrincipal.add(Panel1);
		PPrincipal.add(Panel2);
		PPrincipal.add(Panel3);
		PPrincipal.add(Panel4);
		PPrincipal.add(Panel5);
		PPrincipal.add(Panel6);
		
		GBRgrupo.add(JRBCorriente);
		GBRgrupo.add(JRBAhorro);
				
		TOTAL.add( PPrincipal,BorderLayout.CENTER );
		
		JBAdd.addActionListener ( this );
		JBCancel.addActionListener ( this );
		
		return TOTAL;
		}
		
		/**
		 *Contiene el panel para configuracion de los clientes
		 *@return El panel para agregarse al panel principal
		 *
		 */
	public JPanel SettingUser(){
		JLabel JLCoduser = new JLabel ("Introduzca el Codigo del usuario:");
		JLabel JLNName   = new JLabel ("Nuevo Nombre:  ");
		JLabel JLNLname  = new JLabel ("Nuevo Apellido:");
		JLabel JLNCod    = new JLabel ("Nuevo Codigo:  ");
		JLabel JLNTipo   = new JLabel ("Tipo de Cuenta:");
		JTFCoduser = new JPasswordField (5);
		JTFNName   = new JTextField (10);
		JTFLname   = new JTextField (10);
		JTFNcod    = new JPasswordField (10);
		JButton JBbuscar = new JButton("Buscar");
		JButton JBChange = new JButton ("Cambiar");
		JButton JBCancel = new JButton ("Cancel");
		JRadioButton JRBSahorro = new JRadioButton ("AHORRO");
		JRBScorriente = new JRadioButton ("CORRIENTE",true);
		ButtonGroup grupobotn = new ButtonGroup (); 
			JPanel nuevot = new JPanel (new GridLayout (1,2));
			nuevot.add(JLCoduser);
			nuevot.add(JTFCoduser);
		JPanel nuevo1 = new JPanel ();
			nuevo1.add(nuevot);
			nuevo1.add(JBbuscar);
		JPanel nuevo = new JPanel (new GridLayout (3,2));
			nuevo.add(JLNName);
			nuevo.add(JTFNName);
			nuevo.add(JLNLname);
			nuevo.add(JTFLname);
			nuevo.add(JLNCod);
			nuevo.add(JTFNcod);
		JPanel pgrupo = new JPanel (new GridLayout (1,3));
			pgrupo.add(JLNTipo);
			pgrupo.add(JRBScorriente);
			pgrupo.add(JRBSahorro);	
		JPanel pbotones = new JPanel ();
		pbotones.add(JBChange,BorderLayout.EAST);
		pbotones.add(JBCancel,BorderLayout.WEST);
		
		muestra = new JTextArea (2,2);
		muestra.setText("Nombre\tApellido\tID\tSaldo\tTipo de Cuenta");
		muestra.setEditable(false);
		
		JPanel TODO = new JPanel(new GridLayout (5,1));
		TODO.add(nuevo1);
		TODO.add(muestra);
		TODO.add(nuevo);
		TODO.add(pgrupo);
		TODO.add(pbotones);
		grupobotn.add(JRBSahorro);
		grupobotn.add(JRBScorriente);
		JBCancel.addActionListener(this);
		JBbuscar.addActionListener(this);
		JBChange.addActionListener(this);
		
		return TODO;		
	}
	
	/**
	 *Contiene los eventos de todo el panel de agregar y configuracion de clientes.
	 */

	public void actionPerformed (ActionEvent e){
		String AC = e.getActionCommand();
		String FirstName,LastName,Pass;
		String	to;
		boolean ta= true,a=false;
		Double Acc=0.0;
		/******************************AGREGA UN USUARIO Y ENVIAAL METODO CUSTOMER PARA AGREGAR A LA LISTA********/
		if (AC.equals( "ADD" )){
			if (JTFNombre.getText().equals("")){  a = true;			}
			if (JTFApellido.getText().equals("")){a = true;			}
			if (JTFApertura.getText().equals("")){a = true;			}
			if (JTFNumeroC.getText().equals("")){ a = true;			}
		
			if (a == true){
				JOptionPane.showMessageDialog(null,"campo vacio","Error",JOptionPane.ERROR_MESSAGE);
			}
			else {
				
			if (JRBCorriente.isSelected()==true){
						to = "Corriente";
					}else {
						to = "Ahorro";
					}
				FirstName = JTFNombre.getText().trim();
				LastName  = JTFApellido.getText().trim();
				Pass 	  = JTFNumeroC.getText().trim();
				try{					
				Acc       = Double.parseDouble(JTFApertura.getText().trim());
						System.out.printf("VOY X AKI  " + ta+"n " +FirstName);
				customer = new Customer_R(FirstName, LastName, JTFApertura.getText().trim() , Pass ,to);					
			}catch (NumberFormatException ex){
				JOptionPane.showMessageDialog(null,"Introduzca el Monto Correctamente","Error",JOptionPane.ERROR_MESSAGE);
			}catch (Exception zx ){
			}
			hide();
			}	
		}
		///////////////////*****************BUSCA EL USUARIO A MODIFICAR **************************************////////////////////////
		if (AC.equals("Buscar")){
				try{
	 		num = JTFCoduser.getText().trim();
	 		LinkedList Lista = new LinkedList ();
	 		if (!customer_file.exists()){
	 		JOptionPane.showMessageDialog(null,"No hay clientes registrados","Error",JOptionPane.WARNING_MESSAGE);	
	 		}else{
	 			
	 			try {
            	ObjectInputStream in = new ObjectInputStream(new FileInputStream(new File("Usuario.txt")));
		    	LinkedList lista = new LinkedList();
			    lista = (LinkedList)in.readObject();
			    list=lista;
			    Iterator iterator=lista.iterator();
			    		    
	    		while(iterator.hasNext())
     	        {
     	        	Customer usuario = (Customer)(iterator.next());
     	            if(usuario.getContrasenia().equals(num))
     		        {
     		        
     			        String getn = usuario.getNombre(); 
     			        
            		  muestra.setText(muestra.getText()+"\n"+usuario.getNombre()+"\t"+usuario.getApellido()+"\t"+usuario.getContrasenia()+"\t"+usuario.getAccount().getBalance()+"\t"+usuario.getTcuenta());
            		            mira = true;  
            		            Cliente = usuario; 		
     		        }
     		        
     	        }

//                        JTarea.setText(JTarea.getText()+"El cliente no existe en el archivo!");	
                       
                    
     	        
     	    }catch(Exception w) { 
     	    	      //  JTarea.setText(JTarea.getText()+"\nProblemas cargando la base de datos!!");	
     	    	        
     	    	}
	 		}
	 					
	 			JTFCoduser.setText( "" );
	 			}catch(NumberFormatException ex){
        	System.out.println( "No es un numero" );
        	JTFCoduser.setText( "" ); 
    	}catch (Exception s){}
		}
		/***********************************************CAMBIA O ACTUALIZA LA CUENTA*************************/
		if (AC.equals("Cambiar")){
			String nuevo_nom,nuevo_ap,nueva_cod;
			
			if (mira == true){
				if ( JTFNName.getText().equals("")) {	a=true;				}
				if ( JTFLname.getText().equals("")) {	a=true;				}
				if ( JTFNcod.getText().equals(""))  {	a=true;				}
				if (a == true){
					JOptionPane.showMessageDialog(null,"campo vacio","Error",JOptionPane.ERROR_MESSAGE);
				}else {
					nuevo_nom = JTFNName.getText().trim();
					nuevo_ap  = JTFLname.getText().trim();
					nueva_cod = JTFNcod.getText().trim();
	
					if (JRBScorriente.isSelected()==true){
						to = "Corriente";
					}else {
						to = "Ahorro";
					}
					try{
						
					
						Cliente.setNombre(nuevo_nom);
						Cliente.setApellido(nuevo_ap);
						Cliente.setContrasenia(nueva_cod);
						Cliente.setTcuenta(to);
						ObjectOutput escribe=new ObjectOutputStream(new FileOutputStream("Usuario.txt"));
		    	 		escribe.writeObject(list);
		    	 		System.out.print("BIEN"+Cliente.getNombre());
					}catch(Exception ex){System.out.print("MAL");}
					
				}
			}
			else {
				
			}
		}
		
		/************************************************CANCEL*******************************************/
		if (AC.equals ( "Cancel" )){
			hide();
		}
		
	}
	
		/*
		 *Inicio del Main
		 ***********************/	
	
	public static void main (String arg[]){
		AddingCustomer p = new AddingCustomer();
	}	

}