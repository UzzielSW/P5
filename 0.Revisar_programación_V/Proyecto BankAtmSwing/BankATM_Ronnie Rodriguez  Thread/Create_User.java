


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

/**
 * @(#)Create_User.java
 *
 *
 * @author  Ronnie Rodríguez
 * @version 1.00 2009/10/16
 */
public class Create_User extends JDialog  implements ActionListener, ItemListener, Serializable
{
	JTabbedPane jtbadduser, jtbsett;
	JPanel pnladd, pnlsetadm, pnlsetus, pnldat, pnlsetadm2, pnlsetadm1,pnlsetus2;
	JLabel jlnombre, jlapellido,jlncuenta,jlapertura, jluser, jlkey,jlkey2, jlcod, jlcorrnom,jlcorap,jltext;
	JTextField jtxtnombre, jtxtapellido, jtxtncuenta, jtxtapertura,jtxtuser,jtxtnombre2,jtxtapellido2, jtxtcodcuenta2;
	JPasswordField jptxtkey, jptxtkey2;
 	JRadioButton rbcorr, rbahorro;
	JButton jbtnagregar, jbtncancelar, jbtncambiar, jbtnok,jbtnlisto;
    
    private LinkedList lista;
	private Customer cust;
    private Customer cust1;
    private Customer cust2,custa;
    
  
	private int  aa=0,a=0,h,s;
	private int cuenta,vcuenta,x=0;
	private static int p;
	private static String cambia_nombre,cambia_apellido;
	String passkey;
	
	
	//* Constructor*/
    public Create_User() 
    {
    	
      lista=new LinkedList();
      cust1=new Customer();
      custa=new Customer();	
      passkey="AdminKey";
      		
     	
    }
  
 
    // Metodo para levantar la interface
    public void LaunchFrame()
     {
     	
     	if(aa==0)
     	{
     		aa=1;
     	setTitle("Adding Customer");
    	Container contenedor = getContentPane();
    	jtbadduser= new JTabbedPane();
    	jtbsett= new JTabbedPane();
   		jtbsett.setTabPlacement(JTabbedPane.LEFT);
    	
    	pnladd= new JPanel(new GridLayout(6,2));
    	pnlsetadm= new JPanel(new BorderLayout());
    	pnlsetadm2=new JPanel(new GridLayout(4,1));
    	pnlsetadm1=new JPanel();
    	pnlsetus= new JPanel(new BorderLayout());
    	pnlsetus2= new JPanel(new BorderLayout());
    	
    	
    	pnldat= new JPanel(new GridLayout(2,2));
    	
    	//Creacion de los Labels
    	
    	jlnombre= new JLabel(" Name ");
    	jtxtnombre= new JTextField(20);
        jlapellido= new JLabel(" Last Name ");
    	jtxtapellido= new JTextField(20);
      	jlncuenta= new JLabel(" Number Account ");
    	jtxtncuenta= new JTextField(20);
    	jlapertura= new JLabel(" Opening ");
    	jtxtapertura= new JTextField(20);
       	jluser= new JLabel(" Change User to: ");
    	jtxtuser= new JTextField(20);
       	jlkey= new JLabel(" Password ");
    	jptxtkey= new JPasswordField(20);
       	jlkey2= new JLabel(" New Password: ");
    	jptxtkey2= new JPasswordField(20);
      	jlcod=new JLabel(" Introduce Number Account ");
       	jtxtcodcuenta2= new JTextField(20);
       	jlcorrnom=new JLabel(" Change Name: ");
       	jtxtnombre2= new JTextField(20);
       	jtxtapellido2= new JTextField(20);
     	jlcorap=new JLabel(" Change Last Name: ");
       	jltext=new JLabel(" Please save before exit ");
       		
    	rbcorr= new JRadioButton(" Regular Account ", true);
    	
     	rbahorro= new JRadioButton(" Saving Account ", false);
    	
    	jbtnagregar= new JButton("Add");
    	jbtncancelar=new JButton("Cancel");
    	jbtncambiar= new JButton("Change");
    	jbtnok= new JButton("OK");
    	jbtnlisto= new JButton("Ready");
    
    	
    
    	pnladd.add(jlnombre);
    	pnladd.add(jtxtnombre);
    	
    	pnladd.add(jlapellido);
    	pnladd.add(jtxtapellido);
    	
    	pnladd.add(jlncuenta);
    	pnladd.add(jtxtncuenta);
 		
 		pnladd.add(jlapertura);
 		pnladd.add(jtxtapertura);  
 			
 	// Incorporacion de los paneles
    	
    	JPanel RBott = new JPanel(new FlowLayout());
    	RBott.add(rbcorr);
        RBott.add(rbahorro);
        
    	JPanel Bott = new JPanel(new FlowLayout());
    	Bott.add(jbtnagregar);
    	Bott.add(jbtncancelar);
    	
    	JPanel Botts = new JPanel(new BorderLayout());
    	Botts.add(RBott,BorderLayout.NORTH);
    	Botts.add(Bott,BorderLayout.CENTER);
    	
    
    	JPanel Complete = new JPanel(new BorderLayout());
    	
    	Complete.add(pnladd,BorderLayout.NORTH);
    	Complete.add(Botts,BorderLayout.CENTER);
    	    	
    	
    	JPanel F1 =new JPanel(new GridLayout(1,2));
    	F1.add(jluser);
    	F1.add(jtxtuser);
    	
    	JPanel F2 =new JPanel(new GridLayout(1,2));
    	F2.add(jlkey);
    	F2.add(jptxtkey);
    	
    	JPanel F3 =new JPanel(new GridLayout(1,2));
    	F3.add(jlkey2);
    	F3.add(jptxtkey2);
    	
    	pnlsetadm2.add(F1);
    	pnlsetadm2.add(F2);
    	pnlsetadm2.add(F3);
    	
    	pnlsetadm1.add(jbtncambiar);
    	
    	
  
     	JPanel  top2 = new JPanel(new FlowLayout());
    	top2.add(jtxtcodcuenta2);
    	top2.add(jbtnok);
    	
   
    	JPanel  textnom = new JPanel(new FlowLayout());
    	textnom.add(jtxtnombre2);
    	JPanel  textap = new JPanel(new FlowLayout());
    	textap.add(jtxtapellido2);
    	JPanel  textre = new JPanel(new FlowLayout());
    	textre.add(jbtnlisto);
    	
    	JPanel  Med = new JPanel(new GridLayout(8,1));
    	
    	Med.add(jlcod);
    	Med.add(top2);
    	Med.add(jlcorrnom);
    	Med.add(textnom);
    	Med.add(jlcorap);
    	Med.add(textap);
    	Med.add(textre);
    	Med.add(jltext);
    	
    
    	pnlsetus2.add(Med,BorderLayout.NORTH);
    		
    	pnlsetadm.add(pnlsetadm2,BorderLayout.NORTH);
    	pnlsetadm.add(pnlsetadm1,BorderLayout.CENTER);
    	
    	pnlsetus.add(jlcod, BorderLayout.NORTH);
    	pnlsetus.add(pnlsetus2,BorderLayout.CENTER);
    	
    	ButtonGroup grupo= new ButtonGroup();
    	grupo.add(rbcorr);
    	grupo.add( rbahorro);
    	
    	jtbadduser.addTab(" Add Customer ", Complete);
    	jtbsett.addTab("User Settings ", pnlsetus);
    	jtbsett.addTab("Administrator Settings ", pnlsetadm);
    	jtbadduser.addTab(" Settings ", jtbsett);
    	contenedor.add(jtbadduser);
  
    	
    	setSize(500, 350);
    	setLocation(440,200);
    	setResizable(true);
    	setVisible(true);
    	
    	
    // Implantacion de los Escuchas
    
	  	jbtnagregar.addActionListener(this);
	  	jbtncancelar.addActionListener(this);
	  	jbtncambiar.addActionListener(this);
	  	
	  	rbcorr.addItemListener(this);
	  	rbahorro.addItemListener(this);
	  	jbtnlisto.addActionListener(this);
	  	jbtnok.addActionListener(this);
	  	
	  	jbtnlisto.setEnabled(false);
	 	jtxtnombre2.setEnabled(false);
	  	jtxtapellido2.setEnabled(false);
 	
	  		  	
	  	
	  	
     }
  	else
		{
			this.setVisible(true);
			jtxtnombre.setText("");
			jtxtapellido.setText("");
			jtxtncuenta.setText("");
			jtxtapertura.setText("");
			
			jtxtapellido2.setText("");
			jtxtnombre2.setText("");
			jtxtncuenta.setText("");
			jtxtuser.setText("");
			jptxtkey.setText("");
			jptxtkey2.setText("");
		}
     	
    }
    
     //* Metodo para solicitar al usuario de la posicion n*/
    
    public Customer getCustomer(int ID)
    {
    	Customer cust1= (Customer) lista.get(ID);
    	return (cust1);
    }
    public LinkedList get_lista()
    {
    	return lista;
    }
    
   	public synchronized  void Archivos(LinkedList lista)
	{
		this.lista = lista;
		Archivo archivo = new Archivo();
			try
			{
				a = archivo.sizeLista();
				
			}catch( Exception i)
			{
			i.printStackTrace();
			}
	}
   
    //* Metodo para solicitar el tamaño de la lista*/
    public int valor()
    {
    	System.out.println(a);
    	return a;
    }
    
   //* Metodo para retornar la clave de administrador*/
    public String Key1()
    {
    	return passkey;
    }
    
   //* Metodo de evento para los ItemListener*/
    public void itemStateChanged(ItemEvent r)
     {
     	
		if(r.getSource().equals(rbcorr))
		{
			
			p=0;
		} 
		else if(r.getSource().equals(rbahorro))
		{
		
			p=1;
		}
	 }
   
  
   //* Metodo de eventos para los botones */
    public void actionPerformed(ActionEvent e)
    	 {
    	 	
    	 	
        if(e.getSource().equals(jbtnok))
        {
            // Metodo de busqueda del usuario n para cambiar datos
        	cuenta=Integer.parseInt(jtxtcodcuenta2.getText());
        	int f=0;
        	x=valor();
           for(h=0;h<x;h++)
           {
           	 Customer cust=(Customer) lista.get(h);
             vcuenta=getCustomer(h).getIdCustomer();
      	   if(vcuenta==cuenta)
      	    {
      	    	s=h;
      	      jbtnlisto.setEnabled(true);
	  	      jtxtnombre2.setText(getCustomer(h).getFirstName());
	  	      jtxtnombre2.setEnabled(true);
	  	      jtxtapellido2.setText(getCustomer(h).getLastName());
	  	      jtxtapellido2.setEnabled(true);
	  	      f=1;
	  	      custa=cust;
	  	      
      	    }
           }
      	    if(f==0)
   			{
   				JOptionPane.showMessageDialog(null,"  Account no found!");		
   			}
      	 
        }    
        	
           // evento para cambiar contraseña de administrador
        
        if (e.getSource().equals(jbtncambiar))
        {
        	
        	passkey=(String.valueOf(jptxtkey2.getPassword()));
        	JOptionPane.showMessageDialog(this,"  Administrator Password changed ","Information",JOptionPane.INFORMATION_MESSAGE);	
        	this.setVisible(false);
        
        	
        }	
        	 // evento para editar datos del usuario n
        if(e.getSource().equals(jbtnlisto))	
        {      	
        	
        	 custa.setFirstName(jtxtnombre2.getText());
        	 custa.setLastName(jtxtapellido2.getText());
             JOptionPane.showMessageDialog(this,"  Customer Saved:  "+custa.getFirstName()); // notificacion de la operacion realizada
             this.setVisible(false);
        	 
        	 
          
        }
        
        
       	if (e.getSource().equals(jbtncancelar))
          {
	    	this.setVisible(false);
	    	return ;

		  } 	
		  	
  
    	 // Evento para añadir un nuevo cliente o usuario a la lista	
    	if(e.getActionCommand().equals("Add"))
    	 
    	 {
    	 	cust = new Customer();
    	 	cust.setFirstName(jtxtnombre.getText());
    	 	cust.setLastName(jtxtapellido.getText());
    	 	   	 	
    	 	Account acct=new Account(Double.parseDouble(jtxtapertura.getText()));
    	 	cust.setIdCustomer(Integer.parseInt(jtxtncuenta.getText()));
    	 	cust.setAccount(acct);
    	    if(p==1)
    	    {
    	    	cust.setTCuenta("Savings");
    	    }	
    	    if(p==0)
    	    {
    	    	cust.setTCuenta("Current");
    	    }
    	 	
    	 	lista.add(a,cust);
    	
    	    a++;
    	 	JOptionPane.showMessageDialog(this,"  Customer Added: "+cust.getFirstName());	
    	 	Archivo archivo = new Archivo();
   	 		archivo.Escritura(lista);
            System.out.println(""+a); 
            valor();    	 		
    	    this.setVisible(false);
    	 }
    	 
    	 	
    }

    
  }