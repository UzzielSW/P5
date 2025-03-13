/**
 * @(#)AccountInfo.java
 *
 *
 * @author Manuel Tejada 8-818-1801
 * @version 1.00 2009/11/29
 */
package gui;

import java .awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
/**This class is the panel where the new <code>Customer</code> Account information is written by the user.
 *
 **/
public class AccountInfo extends JPanel implements ActionListener,MouseListener{

/**jl_Monto is a <code>JLabel</code> related to the appearance of the <code>AccountInfo JPanel</code>*/
private JLabel jl_Monto;
/**jl_TipoCuenta is a <code>JLabel</code> related to the appearance of the <code>AccountInfo JPanel</code>*/
private JLabel jl_TipoCuenta;
/**jtf_Monto is the <code>JTextField</code> where a amount of money of the new <code>Customer</code> */
private JTextField jtf_Monto;
/**jb_TipoCuenta isa <code>JButton</code> that holds the action of showing the <code>JPopupMenu</code> where
 *the accounttypeof the new <code>Customer</code> is going to be choose*/ 
private JButton jb_TipoCuenta;
/**jpm_TipoCuenta is a <code>JPopupMenu</code> that let the user choose the <code>Account</code> type of the new <code>Customer</code> */
private JPopupMenu jpm_TipoCuenta;
/**jp_Capturar*/
private JPanel jp_Capturar;
private JPanel jp_Informacion;
private String AccountType;

    public AccountInfo() {
    	jl_Monto=new JLabel("Ingrese el monto de apertura");
    	jl_TipoCuenta=new JLabel("Escoja un tipo de cuenta");
    	jtf_Monto=new JTextField();
    	jb_TipoCuenta=new JButton("Press me to choose");
    	jpm_TipoCuenta=new JPopupMenu("Account Type");
    	jp_Capturar=new JPanel(null);
    	jp_Informacion=new JPanel();
    	dameForm();
    }
    public void dameForm(){
    	creaPanelAccountChooser();
    	creaPanelAccountInfo();
    
    		JTabbedPane d=new JTabbedPane(JTabbedPane.LEFT);
    		d.addTab("Capturar cuenta",jp_Capturar);
    		d.addTab("Informacion de las cuentas",jp_Informacion);
    		
    	add(d);
    }
    
  /**This method is the one incharge of making the <code>JPopUpMenu</code> where the user is going to choose
   **/
  public void creaPanelAccountChooser(){
  	jl_Monto.setBounds(this.getX()+10,this.getHeight()+15,220,20);
    	jp_Capturar.add(jl_Monto);
    	
    	jtf_Monto.setBounds(this.getX()+200,this.getHeight()+15,150,20);
    	jp_Capturar.add(jtf_Monto);
    	
    	jl_TipoCuenta.setBounds(this.getX()+10,this.getHeight()+55,220,20);
    	jp_Capturar.add(jl_TipoCuenta);
    	
    	jb_TipoCuenta.setBounds(this.getX()+200,this.getHeight()+55,150,20);
    	jp_Capturar.add(jb_TipoCuenta);
    	jb_TipoCuenta.addActionListener(this);
    	
    
    	
    	ButtonGroup bg_Grupo=new ButtonGroup();
    	
    	JRadioButton jrb_CheckAccount=new JRadioButton("CheckAccount",false);
		bg_Grupo.add(jrb_CheckAccount);
		
    	JRadioButton jrb_RetirementAccount=new JRadioButton("RetirementAccount",false);
    	bg_Grupo.add(jrb_RetirementAccount);
    	
    	JRadioButton jrb_SavingAccount=new JRadioButton("SavingAccount",false);
    	bg_Grupo.add(jrb_SavingAccount);
    	
    	JRadioButton jrb_StockMarketAccount=new JRadioButton("StockMarketAccount",false);
    	bg_Grupo.add(jrb_StockMarketAccount);
    	
    	jpm_TipoCuenta.add(jrb_CheckAccount);
    	jpm_TipoCuenta.add(jrb_RetirementAccount);
    	jpm_TipoCuenta.add(jrb_SavingAccount);
    	jpm_TipoCuenta.add(jrb_StockMarketAccount);
    	 	
    	jrb_CheckAccount.setActionCommand("Check"); 	
    	jrb_RetirementAccount.setActionCommand("Retirement");
    	jrb_SavingAccount.setActionCommand("Saving");
    	jrb_StockMarketAccount.setActionCommand("StockMarket");
    	
    	
    	jrb_CheckAccount.addActionListener(this);
    	jrb_RetirementAccount.addActionListener(this);
    	jrb_SavingAccount.addActionListener(this);
    	jrb_StockMarketAccount.addActionListener(this);
    	
  }
  
  /**This method create the <code>JPanel</code> where the <code>Account</code> information is going to be captured
   **/ 
    public void creaPanelAccountInfo(){
    	
    	try{
    		


    	JTabbedPane jtp_AccountInfo=new JTabbedPane();
    	
    	JPanel jp_AccountInfo=new JPanel();
    	JTextArea jta_AccountInfo=new JTextArea();
    	ObjectInputStream lista=new ObjectInputStream(new FileInputStream("CheckAccount.obj"));
    	jta_AccountInfo.setText(""+(String)lista.readObject());
    	lista.close();
        jp_AccountInfo.add(jta_AccountInfo);
    	jtp_AccountInfo.addTab("CheckAccount",jp_AccountInfo);
    	
    	jp_AccountInfo=new JPanel();
    	jta_AccountInfo=new JTextArea();
    	lista=new ObjectInputStream(new FileInputStream("RetirementAccountt.obj"));
    	jta_AccountInfo.setText(""+(String)lista.readObject());
    	lista.close();
        jp_AccountInfo.add(jta_AccountInfo);
    	jtp_AccountInfo.addTab("RetirementAccountt",jp_AccountInfo);
    	
    	
    	jp_AccountInfo=new JPanel();
    	jta_AccountInfo=new JTextArea();
    	lista=new ObjectInputStream(new FileInputStream("SavingAccount.obj"));
    	jta_AccountInfo.setText(""+(String)lista.readObject());
    	lista.close();
        jp_AccountInfo.add(jta_AccountInfo);
    	jtp_AccountInfo.addTab("SavingAccount",jp_AccountInfo);
    	
    	
    	jp_AccountInfo=new JPanel();
    	jta_AccountInfo=new JTextArea();
    	lista=new ObjectInputStream(new FileInputStream("StockMarketAccount.obj"));
    	jta_AccountInfo.setText(""+(String)lista.readObject());
    	lista.close();
        jp_AccountInfo.add(jta_AccountInfo);
    	jtp_AccountInfo.addTab("StockMarketAccount",jp_AccountInfo);
    	
    	jp_Informacion.add(jtp_AccountInfo);
  	}catch(Exception es){
	
}
  }
  
  /**This method is the one that is called to get the information abaut the <code>Account</code>that was entered by the user
   **/
    public String[] getInformation(){
    	String[] info=new String[2];
    	
    	info[0]=jtf_Monto.getText();
    	   	
    	info[1]=AccountType;
    		return info;
    	}
    
    /**This method controles the action of displaying the <code>JPopUpMenu</code> where the Account type is chosse
     **/
	public void actionPerformed(ActionEvent e){
	if(e.getActionCommand().equals("Press me to choose")){
	JButton a=(JButton)e.getSource();
	jpm_TipoCuenta.show(a,a.getX()/2,a.getY()/2);
	}
	else{
	
	AccountType=e.getActionCommand();

		
	}
}

	/**This method handles the action of putting the <code>JPopUpMenu</code> where the <code>Account</code>
	 *Information into the correct coordinates*/
     public void mouseClicked(MouseEvent e){
         	
     	 }
     	 /**This method handles the action of putting the <code>JPopUpMenu</code> where the <code>Account</code>
	 *Information into the correct coordinates*/
     public void mousePressed(MouseEvent e){
     		if(e.isPopupTrigger()){
     		jpm_TipoCuenta.show(e.getComponent(),e.getX(),e.getY());
     	} }
     	/**This method is not used but it must be written cause this class implements a MouseListener*/
     public void mouseReleased(MouseEvent e){     	 }
     /**This method is not used but it must be written cause this class implements a MouseListener*/
     public void mouseEntered(MouseEvent e) {  }
     /**This method is not used but it must be written cause this class implements a MouseListener*/
     public void mouseExited(MouseEvent e){ }
     
     /**This method is call by the owner of the <code>AccountInfo</code> to check if the amount introduced by the user is ok
      **/
	 public boolean isMontoOk(){
		try
		{
			double a=Double.parseDouble(jtf_Monto.getText());
			return true;
		}
		catch(Exception ex){
			return false;
		}
	}
	
/**This method is called by the owner of <code>AccountInfo</code> reset the amount introduced by the user 
 **/
	public void resetMonto(){
		jtf_Monto.setText("");
	}
			
	/**This method is call by the owner of the <code>AccountInfo</code> to check if the <code>Account</code> type introduced by the user was chossen.
      **/
	public boolean isAccountTypeSelected(){
		try{
		
			if(AccountType.equals(""))
				return false;
		}
		catch(Exception ex){
			return false;
		}
				
			return true;
		
		
	}

}






























