/**
 * @(#)ClientButton.java
 *
 *
 * @author 
 * @version 1.00 2010/1/2
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ClientButton extends JButton implements ActionListener {

		/**jpm_Options is a JPopupMenu that holds the obtion Buttons of a ClientsButton*/
		private JPopupMenu jpm_Options;
		/**jb_CloseSesssion is a JButton that handles the action of closing the conection */
		private JButton jb_CloseSesssion;
		/**jb_Edit is a JButton that handles the action of calling the <code>EditarCuentaWindow</code>*/
		private JButton jb_Edit;
		/**tittle is a String that represents the tittle of the JButton*/
		private String tittle;

		private int clientNumber;
		/**owner is a Server that represents the owner of this object*/
		private Server owner;
		/**thread is a Thread that is the Thread associated to the conection*/
		private ClientsThread thread ;
	
	/**This method is where a new instance of ClientButton is created
	 *@param tittle Is the Tittle  of the JButton
	 *@param owner Is the owner of the JButton
	 **/
 	public ClientButton(String tittle,Server owner) {
    	super(tittle);
    	this.tittle=tittle;
    	this.owner=owner;
    	
    	jpm_Options=new JPopupMenu("Client´s option");
    	
    	jb_CloseSesssion=new JButton("Close Conection");
    	jb_Edit=new JButton("Edit Account");
    	
    	jpm_Options.add(jb_Edit);
    	
    	jpm_Options.add(jb_CloseSesssion);
    	
    	this.addActionListener(this);
    	this.jb_Edit.addActionListener(this);
    	this.jb_CloseSesssion.addActionListener(this);
    	
    	this.jb_CloseSesssion.setEnabled(false);
    		this.setFont(new Font("Kristen ITC",Font.BOLD,14));
	    	this.setForeground(Color.WHITE);
			this.setBackground(Color.BLUE);
    	
    }

	/**This method is called to set the thread associated with the JButton
	 *@param Thread Is the thread associated with the JButton
	 **/
	public void setThread(ClientsThread thread){
	
		this.thread=thread;
		this.jb_CloseSesssion.setEnabled(!thread.equals(null));
		this.setConectionColor();
	}
	
	/**This method is called to get the thread associated with the JButton
	 *@return ClientsThread Is the thread associated with the JButton
	 **/
	public ClientsThread getThread(){
		return thread;
	}
	
	/**This method is called to Close The connection to a specified Client
	 **/
	public void stopThread(){
		
			
		owner.regresaAreaDatos().setText(owner.regresaAreaDatos().getText()+"\n Coneccion con --> ** "+ thread.getSocket().getInetAddress().getHostAddress()+
      				" **  ha sido terminada por el administrador \n");  
    	
    	this.thread.closeConection();
		this.thread.stop();
		this.jb_CloseSesssion.setEnabled(false);
		this.setConectionColor();
		System.out.println ("Esta vivo --> "+thread.isAlive());
	}
	
	/**This method is called to set the JButton Color
	 **/
	public void setConectionColor(){
		boolean conected;
		
		try{
		 conected= thread.isAlive();
		 
		}catch(Exception ex){
			conected=false;
			}
		
		if(conected){
				this.setBackground(Color.RED);
		}else{
				this.setBackground(Color.BLUE);
		}
	}
	
	/**This Method is called to show the JButton that represents the options of a customer
	 **/
    public void showPupUpMenu(){
    	int x=this.getWidth();
    	int y=0;
    	jpm_Options.show(this,x,y);    	
    }
    
    /**This method is called to set the Client number associated with the JButton
     *
     **/
    public void setClientNumber(int  num){
    	clientNumber=num;
    }
    
    /**This method is where the action events are first handle
     **/
    public void actionPerformed(ActionEvent e){
    	String source=e.getActionCommand();
    	
    	if(source.equals(this.tittle)){
    		showPupUpMenu(); 
    	}
    	else if(source.equals("Edit Account")){
    		owner.setCurrentCustomer(clientNumber);
    			new EditarCuentaWindow(owner).setVisible(true);
    	}	
    	else if(source.equals("Close Conection")){
    		thread.closeConection();
    		this.stopThread();
    	}	
   	}
}