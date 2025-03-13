/**
 * @(#)ConfirmAccount.java
 *
 *
 * @author Manuel Tejada 8-818-1801
 * @version 1.00 2009/11/29
 */
package gui;
import java .awt.*;
import javax.swing.*;
import java.awt.event.*;
 
import javax.swing.border.TitledBorder;

/**
 *This class handles the confirmation of the data that is introduced by the user,
 *by comparing what the user introduces against what is stored into the <code>LinkedList</code> **/

public class ConfirmAccount extends JDialog implements ActionListener{

/**jl_FirstName is a <code>JLabel</code> that shows "Nombre " indicating that in the <code>JTextField</code> next to it must be written the First name of a <code>Customer</code> */
private JLabel jl_FirstName;
/**jl_LastName is a <code>JLabel</code> that shows "Apellido " indicating that in the <code>JTextField</code> next to it must be written the Last name of a <code>Customer</code> */
private JLabel jl_LastName;
/**jl_FirstName is a <code>JLabel</code> that shows "Password " indicating that in the <code>JPasswordField</code> next to it must be written the Password of a <code>Customer</code> */
private JLabel jl_Password;
/**jtf_FirstName is a <code>JTextField</code> where the first name of a <code>Customer</code> is going to be written */
private JTextField jtf_FirstName;
/**jtf_LastName is a <code>JTextField</code> where the last name of a <code>Customer</code> is going to be written */
private JTextField jtf_LastName;
/**jpf_Password is a <code>JPasswordField</code> where the password of a <code>Customer</code> is going to be written */
private JPasswordField jpf_Password;
/**jb_Confirm is a <code>JButton</code> that handles the action of comparing ,
 *what was captured in the Fields and the information of the <code>Customer</code> stored into the <code>LinkedList</code>*/
private JButton jb_Comfirm;
/**jb_Cancel is a <code>JButton</code> that handles the action closing the window*/
private JButton jb_Cancel;
/**jp_Principal is a JPanel related with how is display the window*/
private JPanel jp_Principal;
/**jp_Center is a <code>JPanel</code> related with how is display the window*/
private JPanel jp_Center;
/**jp_South is a <code>JPanel</code> related with how is display the window*/
private JPanel jp_South;
/**panelBorderTittle holds the tittle of the <code>jp_Principal</code>*/
private String panelBorderTittle;
/**isAccountConfirmationWindow is a <code>boolean</code> that represents a flag indicatong :
 *<code>true</code> The <code>ConfirmAccount</code> is for Login
 *<code>false</code> The <code>ConfirmAccount</code> must redirect to a <code>EditarCuentaWindow</code>*/
private boolean isAccountConfirmationWindow;
/**owner is a <code>BankWindow</code> object that represents the owner of the <code>ConfirmAccount JDialog</code>*/
private BankWindow owner;
/**objetoRedireccion is a <code>JDialog</code> 
 *that is going to be shown if <code>isAccountConfirmation</code> is <code>false</code>*/ 
private JDialog objetoRedireccion;

/**It makes an instance of a confirmAccount with the following ditails.
 *@param password It is the password that is going to be putted in the <code>jpf_Password</code>
 *@param owner it is the owner of the dialog*/
    public ConfirmAccount(String password,BankWindow owner) {
    	super(owner,"...:::Login User Verification:::...",true);
    	panelBorderTittle="Validacion de cuenta ";
    	
    	jpf_Password=new JPasswordField(password);
    	initAtributos();
    	
    	isAccountConfirmationWindow=true;
    	
		this.owner=owner;
	   	dameForma();	
    }
    
/**It makes an instance of a confirmAccount when is call by the Edit account optionwith the following ditails.
  *@param owner it is the owner of the dialog
  *@param objetoRedireccion It is the EditarCuentaWindow that is going to be shown if the data enter if ok*/

    public ConfirmAccount(BankWindow owner,EditarCuentaWindow objetoRedireccion){
    	super(owner,"...:::Edit Data Customer Verification:::...",false);
    	panelBorderTittle="Enter Current Information of Client ";
    	isAccountConfirmationWindow=false;
    	jpf_Password=new JPasswordField("");
    	initAtributos();
        this.objetoRedireccion=objetoRedireccion;	
		this.owner=owner;
	   	dameForma();	
    }
    
    /**This method initialize the field 
     **/
    public void initAtributos(){
    	
    	   
    	jl_FirstName=new JLabel("Nombre ");
    	jl_LastName=new JLabel("Apellido ");
    	jl_Password=new JLabel("Password ");
    	
    	jtf_FirstName=new JTextField("");
    	jtf_LastName=new JTextField("");
    	
    	
    	jb_Comfirm=new JButton("Confirm");
    	jb_Cancel =new JButton("Cancel");
    	
    	jp_Principal=new JPanel();
    	jp_Center=new JPanel(null);
    	jp_South =new JPanel(new GridLayout(1,2));
    	
     
    }
    
    /**
     *This method take the field and arrenge them so they can be watched propertly
     **/
    public void dameForma(){
    jp_Principal.setBorder(BorderFactory.createTitledBorder(panelBorderTittle)); 
    	jp_Principal.setLayout(new BorderLayout());
    	jp_Center.add(jl_FirstName);
    	jl_FirstName.setBounds(this.getX()+10,this.getY()+15,100,10);
    	
    	jp_Center.add(jtf_FirstName);
    	jtf_FirstName.setBounds(this.getX()+150,this.getY()+10,100,20);
    	
    	jp_Center.add(jl_LastName);
    	jl_LastName.setBounds(this.getX()+10,this.getY()+45,100,10);
    	
    	jp_Center.add(jtf_LastName);
    	jtf_LastName.setBounds(this.getX()+150,this.getY()+40,100,20);
    	
    	jp_Center.add(jl_Password);
    	jl_Password.setBounds(this.getX()+10,this.getY()+75,100,10);
    	
    	jp_Center.add(jpf_Password);
    	jpf_Password.setBounds(this.getX()+150,this.getY()+75,100,20);
    	
    	jb_Comfirm.addActionListener(this);
    	jb_Cancel.addActionListener(this);
    	
    	jp_South.add(jb_Comfirm);
    	jp_South.add(jb_Cancel);
    	
    	    	
        jp_Principal.add(jp_Center,BorderLayout.CENTER);
        jp_Principal.add(jp_South,BorderLayout.SOUTH);
        
        
    	this.add(jp_Principal);
    	this.setSize(300,200);
    	this.setLocation(owner.getX()+50,owner.getY()+10);
    
    }
    
    /**This method is in charged of controling the actions of the jb_confirm and jd_Cancel JButtons
     **/ 
    public void actionPerformed(ActionEvent e){
        	if(e.getActionCommand().equals("Confirm")){
        		accountVerification();
			
			
		}
		else if(e.getActionCommand().equals("Cancel")){
		this.dispose();
		
		}	}
	
	/**This method is where the verification options ocured.
	 *here is where is decided what to do acording to what was written into the Field of the confirmationWindow 
	 **/	
	public void accountVerification(){
		String firstName=jtf_FirstName.getText();
		String lastName=jtf_LastName.getText();
		String password=new String(jpf_Password.getPassword());
		
		if(firstName.equals("ADMIN")&&lastName.equals("ADMIN")){
			if(password.equals("ADMINKEY")){
				if(isAccountConfirmationWindow){
				 owner.adminMenuBar(true);
				 JOptionPane.showMessageDialog(this,"Welcome Master","Account Verification : Pass",JOptionPane.INFORMATION_MESSAGE);
				 owner.setLoginState(true);
				 this.dispose();
				}
				else{
					 JOptionPane.showMessageDialog(this,"Is not posible to edit the Administrator Data","Edit Account Verification : Not Pass",JOptionPane.ERROR_MESSAGE);
					 jtf_FirstName.setText("");
					 jtf_LastName.setText("");
					 jpf_Password.setText("");
				}
			}
			else
			{
				JOptionPane.showMessageDialog(this,"Administrator Password not valid","Account Verification : Not Pass",JOptionPane.ERROR_MESSAGE);
				jtf_FirstName.setText("");
				jtf_LastName.setText("");
			}
		}
		else{
			int customerIndex=owner.checkCustomer(0,firstName,lastName,password);
			
			if(customerIndex==-1){
				JOptionPane.showMessageDialog(this,"User information not valid","Account Verification : Not Pass",JOptionPane.ERROR_MESSAGE);
				jtf_FirstName.setText("");
				jtf_LastName.setText("");
				jpf_Password.setText("");
				
			}
			else if(!owner.getCustomer(customerIndex).getState()&&isAccountConfirmationWindow){
				 		 JOptionPane.showMessageDialog(this,"The account you tried to acces is not available","Account Verification : Not Pass",JOptionPane.ERROR_MESSAGE);
				 		 jtf_FirstName.setText("");
				 		 jtf_LastName.setText("");
				 		 jpf_Password.setText("");
				 		 return ;
			}
			else{
			
				 owner.setCurrentCustomer(customerIndex);
				 this.dispose();
				 try{
				 	objetoRedireccion.setVisible(true);
				 }catch(Exception ex){			
				 		 JOptionPane.showMessageDialog(this,"Welcome "+firstName+" "+lastName,"Account Verification : Pass",JOptionPane.INFORMATION_MESSAGE);
				 		 owner.setLoginState(true);
				 		  owner.enableBankButtons(true);
				  }
				 
			}
		}
	}
    
  
}