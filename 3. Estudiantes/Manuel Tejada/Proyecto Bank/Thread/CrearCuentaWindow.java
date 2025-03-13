/**
 * @(#)CrearCuentaWindow.java
 *
 *
 * @author Manuel Tejada 8-818-1801
 * @version 1.00 2009/11/29
 */
package gui;
import java .awt.*;
import javax.swing.*;
import java.awt.event.*;
import esqueleto.*;

/**This clase represents code behind the windows where all the data is captured so a new instance of <code>Customer</code> can be created and stored into the <code>LinkedList</code>
 *
 **/
public class CrearCuentaWindow extends JDialog implements ActionListener {
	/**owner is a <code>BankWindow</code> object that represents the owner of the <code>CrearCuentaWindow JDialog</code>*/
	private BankWindow owner;
	/**jp_principal is a JPanel related with how is display the window*/
	private JPanel jp_principal;
	/**jp_Botones is a JPanel related with how is display the window*/
	private JPanel jp_Botones;
	/**jp_Aceptar is a JButton that handels the accion of adding a new <code>Customer</code> to the <code>LinkedList</code>*/
	private JButton jb_Aceptar;
	/**jp_Cancel is a JButton that handels the accion of canceling the creation of a new <code>Customer</code>*/
	private JButton jb_Cancel;
	/**infUser is a JPanel that holds all the necesary field for making the tab where a new <code>Customer</code> user iinformation is going to be captured*/
	private UserInfo infUser;
	/**infAccount is a JPanel that holds all the necesary field for making the tab where a new <code>Customer</code> account information is going to be captured*/
	private AccountInfo infAccount;
	
	/**This methos is call to create a new instance of <code>CrearCuentaWindow</code> 
	 *with the following details.
	 *@param owner is a <code>BankWindow</code> object that represents the owner of the <code>CrearCuentaWindow JDialog</code>
	 **/
	public CrearCuentaWindow(BankWindow owner){
		super(owner,"...:::New Account:::...",false);
	this.owner=owner;
	jp_principal=new JPanel();	
		jp_Botones=new JPanel(new GridLayout(1,2));
		jb_Aceptar=new JButton("Aceptar");
		jb_Cancel=new JButton("Cancelar");	
		Crear();	
	}
	
/**This method is where the <code>CrearCuentawindow</code> takes its finally form.
     **/    	
	public void  Crear(){
	infUser=new UserInfo();
	infAccount=new AccountInfo();
	
	JTabbedPane jtp_tab=new JTabbedPane();
	jtp_tab.addTab("User Information",infUser);
	jtp_tab.addTab("Account Information",infAccount);
	jp_principal.add(jtp_tab);
	
	jp_Botones.add(jb_Aceptar);
	jp_Botones.add(jb_Cancel);
	
	jb_Aceptar.addActionListener(this);
		
	final JDialog mainWindow=this;
	jb_Cancel.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
		mainWindow.dispose();
		}
		});
	this.setLayout(new BorderLayout());
	add(jp_principal,BorderLayout.CENTER);
	add(jp_Botones,BorderLayout.SOUTH);
	
	setSize(670,380);
	setLocation(owner.getX()+owner.getWidth(),owner.getY()+owner.getHeight());
	//	setVisible(true);
	}
	
	/**This method is Invoked when an action(coming from the <code>jb_Aceptar</code>) occurs. 
	 *@param e This object contains all the information of the action that has just occured.
	 */
	public void actionPerformed(ActionEvent e){
		if(!infUser.isPrincipalDataOk()){
			JOptionPane.showMessageDialog(this,"The fields with -> * <- Must be filled","Data missing",JOptionPane.OK_OPTION);
		}
		else if(!infUser.isEmailOk()){
			JOptionPane.showMessageDialog(this,"Retype E-mail please","Email Verification : Not Pass",JOptionPane.OK_OPTION);
		}
		else if(!infUser.isPasswordOk()){
			JOptionPane.showMessageDialog(this,"Retype Password please","Password Verification : Not Pass",JOptionPane.OK_OPTION);
			infUser.resetPassword();
		}
		else if(!infAccount.isMontoOk()){
			JOptionPane.showMessageDialog(this,"Rewrite the account balance please","Amount Not Permited",JOptionPane.OK_OPTION);
			infAccount.resetMonto();
		}
		else if(!infAccount.isAccountTypeSelected()){
			JOptionPane.showMessageDialog(this,"select The Account Type please","Account Type Not Permited",JOptionPane.OK_OPTION);
		}
		else{
			createCustomer();
			this.dispose();
		}
	}    
    
    /**This method is where the data is captured from the <code>JTextFiel`s ,JcheckBoxes</code> , etc an the new <code>Customer</code>
     *is created an stored to the <code>LinkedList</code>.
     **/
    public void createCustomer(){

    	String[] dataU=infUser.getInformation();
    	String[] dataA=infAccount.getInformation();
    Customer client=new Customer(dataU[0],dataU[2],dataU[4],dataU[5],dataA[1],Double.parseDouble(dataA[0]));
    	client.setMiddleName(dataU[1]);
    	client.setMothersName(dataU[3]);
    	client.setEmail(dataU[6]);
    	
    		
   	owner.saveCustomer(owner.getNumOfCustomers(),client);
   	owner.save();
    }
    
    
}

