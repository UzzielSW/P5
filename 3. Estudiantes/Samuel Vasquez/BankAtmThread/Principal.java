/**
 * @(#)Principal.java
 *
 *
 * @author Samuel Vásquez 9-720-1392
 * @version 1.00 2009/9/19
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;

public class Principal
{
	/**
	 * @param args
	 */
	private boolean validar;
	private JPanel P_principal, P_izq , P_der, P_incluye_P_izq_P_der, P_ima, P_bot;
	private JLabel user, pass, err;
	private JButton sesion, imagen;
	private JTextField usuario;
	private JPasswordField contraseña;
	Icon icono = new ImageIcon("Imagen/cancer.gif") ;
	private JDialog vent;
	
	public Principal()
	{
		vent = new JDialog();
		vent.setModal(true);			
		P_principal = new JPanel(new GridLayout(3,1));
		P_incluye_P_izq_P_der = new JPanel();
		P_izq = new JPanel(new GridLayout(2,1));
		P_der = new JPanel(new GridLayout(2,1));
		
		user = new JLabel("User Name");
		P_izq.add(user);
		usuario = new JTextField(10);
		P_der.add(usuario);
		
		pass = new JLabel(" Password");
		P_izq.add(pass);
		contraseña = new JPasswordField(10);
		P_der.add(contraseña);
		
		P_incluye_P_izq_P_der.add(P_izq, BorderLayout.EAST);
		P_incluye_P_izq_P_der.add(P_der, BorderLayout.WEST);
		P_principal.add(P_incluye_P_izq_P_der);
		
		P_bot = new JPanel();
		sesion = new JButton("Iniciar Sesion");
		P_bot.add(sesion);
		sesion.addActionListener(new E_Aceptar());
		P_principal.add(P_bot);
		
		err = new JLabel("");
		err.setHorizontalAlignment(JLabel.CENTER);
		P_principal.add(err);
		
		vent.getContentPane().add(P_principal, BorderLayout.EAST);
		
		imagen = new JButton("",icono);
		vent.getContentPane().add(imagen, BorderLayout.CENTER);
		vent.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		vent.setResizable(false);
		vent.setBounds(275,175,375,175);	
		vent.setVisible(true);
	}
	
	public Principal(JFrame fra)
	{
		vent = new JDialog(fra, "Datos del Administrador");
		vent.setModal(true);			
		P_principal = new JPanel(new GridLayout(3,1));
		P_incluye_P_izq_P_der = new JPanel();
		P_izq = new JPanel(new GridLayout(2,1));
		P_der = new JPanel(new GridLayout(2,1));
		
		user = new JLabel("User Name");
		P_izq.add(user);
		usuario = new JTextField(10);
		P_der.add(usuario);
		
		pass = new JLabel(" Password");
		P_izq.add(pass);
		contraseña = new JPasswordField(10);
		P_der.add(contraseña);
		
		P_incluye_P_izq_P_der.add(P_izq, BorderLayout.EAST);
		P_incluye_P_izq_P_der.add(P_der, BorderLayout.WEST);
		P_principal.add(P_incluye_P_izq_P_der);
		
		P_bot = new JPanel();
		sesion = new JButton("Iniciar Sesion");
		P_bot.add(sesion);
		sesion.addActionListener(new E_Aceptar());
		P_principal.add(P_bot);
		
		err = new JLabel("");
		err.setHorizontalAlignment(JLabel.CENTER);
		P_principal.add(err);
		
		vent.getContentPane().add(P_principal, BorderLayout.EAST);
		
		imagen = new JButton("",icono);
		vent.getContentPane().add(imagen, BorderLayout.CENTER);
		vent.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		vent.setResizable(false);
		vent.setBounds(275,175,375,175);	
		vent.setVisible(true);
	}
	
	class E_Aceptar implements ActionListener
	{
		public void actionPerformed(ActionEvent eve)
		{
			String us = usuario.getText();
			char passArray[] = contraseña.getPassword();
			String pas = new String(passArray);
			if(us.equals("")||pas.equals(""))
			{
				err.setText("Por favor complete los campos");	
			}
			else
			{
				err.setText("");
				String path = "";
				String linea = "";
				BufferedReader salida = null;
				try
				{
					path="Clave/Clave.Samuel";
					salida = new BufferedReader(new FileReader(path)) ;
					while ((linea = salida.readLine ()) != null)
					{
						if(linea.equals(us+" "+pas))
						{
							vent.dispose();
							validar = true;
						}else
						{
							err.setText("Olvido el user o password");
							contraseña.setText("");
						}
					}
					salida.close ();
				}
				catch(IOException IOE)
				{
					JOptionPane.showMessageDialog(P_principal, "Servidor no disponible.", "Disculpe",JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
	public boolean Validar()
	{
		return validar;
	}	
}	

