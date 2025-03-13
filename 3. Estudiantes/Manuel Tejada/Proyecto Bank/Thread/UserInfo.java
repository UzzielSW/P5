/**
 * @(#)UserInfo.java
 *
 *
 * @author Manuel Tejada 8-818-1801
 * @version 1.00 2009/11/29
 */
package gui;

import javax.swing.border.TitledBorder;
import java .awt.*;
import javax.swing.*;
import java.awt.event.*;
/**This class is the panel where the new <code>Customer</code> user information is written by the user.
 *
 **/
public class UserInfo extends JPanel {

/**jp_Principal is a <code>JPanel</code> related to how is display the window*/
	private JPanel jp_Principal;
	/**jtf_fName is a <code>JTextField</code> where the first name of the new <code>Customer</code>*/
	private JTextField jtf_fName;
	/**jtf_mName is a <code>JTextField</code> where the middle name of the new <code>Customer</code>*/
	private JTextField jtf_mName;
	/**jtf_lName is a <code>JTextField</code> where the last name of the new <code>Customer</code>*/
	private JTextField jtf_lName;
	/**jtf_moName is a <code>JTextField</code> where the mother`s name of the new <code>Customer</code>*/
	private JTextField jtf_moName;
	/**jtf_id is a <code>JTextField</code> where the id of the new <code>Customer</code>*/
	private JTextField jtf_id;
	/**jtf_eMail is a <code>JTextField</code> where the e-Mail of the new <code>Customer</code>*/
	private JTextField jtf_eMail;
	/**jtf_reEMail is a <code>JTextField</code> verify the e-Mail of the new <code>Customer</code>*/
	private JTextField jtf_reEMail;
	/**jtf_password is a <code>JTextField</code> where the password of the new <code>Customer</code>*/
	private JPasswordField jpf_password;
	/**jtf_rePassword is a <code>JTextField</code> verify the password of the new <code>Customer</code>*/
	private JPasswordField jpf_rePassword;
	
/**It makes an instance of a UserInfo.*/
    public UserInfo() {
    			
		jp_Principal=new JPanel(new GridLayout(0,2,5,5));
		
		jtf_fName=new JTextField(5);
		jtf_mName=new JTextField(5);
		jtf_lName=new JTextField(5);
		jtf_moName=new JTextField(5);
		jtf_id=new JTextField(5);
		jtf_eMail=new JTextField(5);
		jtf_reEMail=new JTextField(5);
		
		jpf_password=new JPasswordField(5);
		jpf_rePassword=new JPasswordField(5);
		
		dameForma();
    }
    
    /**This method is where the main window takes its finally form.
     **/    
    public void dameForma(){
  		jp_Principal.setBorder(BorderFactory.createTitledBorder(" Informacion de cliente ")); 
  	
		JLabel jl_aux=new JLabel("Primer Nombre *");
		jp_Principal.add(jl_aux);
				
		jp_Principal.add(jtf_fName);
		
		jl_aux=new JLabel("Segundo Nombre ");
		jp_Principal.add(jl_aux);
				
		jp_Principal.add(jtf_mName);
		
		jl_aux=new JLabel("Apellido de padre *");
		jp_Principal.add(jl_aux);
				
		jp_Principal.add(jtf_lName);
		
		jl_aux=new JLabel("Apellido de madre");
		jp_Principal.add(jl_aux);
			
		jp_Principal.add(jtf_moName);

		jl_aux=new JLabel("ID *");
		jp_Principal.add(jl_aux);
				
		jp_Principal.add(jtf_id);
		
		jl_aux=new JLabel("Password *");
		jp_Principal.add(jl_aux);
				
		jp_Principal.add(jpf_password);
		
		jl_aux=new JLabel("Retype Password *");
		jp_Principal.add(jl_aux);
		
		jp_Principal.add(jpf_rePassword);
		
		jl_aux=new JLabel("E-Mail ");
		jp_Principal.add(jl_aux);
		
		jl_aux=new JLabel("Retype E-Mail ");
		jp_Principal.add(jtf_eMail);
		
		jp_Principal.add(jl_aux);
		
		jp_Principal.add(jtf_reEMail);
	
		setLayout(new BorderLayout());	
		this.add(jp_Principal,BorderLayout.CENTER);
		
		setSize(670,350);
				
	}
	
	/**This method returns the information captured in the <code>JTextField</code>s .
	 **/
	public String[] getInformation(){
		String [] info=new String[7];
		info[0]=jtf_fName.getText();
		info[1]=jtf_mName.getText();
		info[2]=jtf_lName.getText();
		info[3]=jtf_moName.getText();
		info[4]=jtf_id.getText();
		info[5]=jpf_password.getText();
		info[6]=jtf_eMail.getText();
	return info;
	
	}
	
	/**This method is where the password written into the  <code>jpf_password</code> and <code>jpf_rePassword</code> is verify.
	 **/
	public boolean isPasswordOk(){
		if(jpf_password.getText().equals(""))
		return false;
		return ((new String(jpf_password.getPassword())).equals(new String(jpf_rePassword.getPassword())));
	}
	
	/**This method is where the <code>jpf_password</code> and <code>jpf_rePassword</code> are reset.
	 **/
	public void resetPassword(){
		jpf_password.setText("");
		jpf_rePassword.setText("");
	}
	
	/**This method is where the e-Mail written into the  <code>jtf_eMail</code> and <code>jtf_reEMail</code> is verify.
	 **/	
	public boolean isEmailOk(){
	return (jtf_eMail.getText().equals(jtf_reEMail.getText()));
	}
	
	/**This method is where the first name,last name and the id written into their respectives <code>JTextField</code>s is verify.
	 **/	
	public boolean isPrincipalDataOk(){
		if(jtf_fName.getText().equals("")||jtf_lName.getText().equals("")||jtf_id.getText().equals(""))
			return false;
		return true;	
	}
		
}