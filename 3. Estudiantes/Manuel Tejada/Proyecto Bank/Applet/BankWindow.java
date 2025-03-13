/**
 * @(#)BankWindow.java
 *
 *
 * @author Manuel Tejada 8-818-1801
 * @version 1.00 2009/11/29
 */
package gui;

 import java.awt.*;
 import java.awt.event.*;
 import javax.swing.*;
 import esqueleto.*;

public class BankWindow extends JApplet{
	/**Jtf_Data_entry is a JPasswordField where the password is going to be written
	 *Whien its time for verification*/
private JPasswordField 	jpf_Data_entry;
/**jtf_Messsage is a JTextField where the corrent accion made are indicated:such as Login,Making a Deposit,etc.*/
private JTextField 		jtf_Message;
/**jb_Display is a JButton that handels the accion of displaying the amount of money of an account*/
private JButton 		jb_Display;
/**jb_Deposit is a JButton that handels the accion of Adding money to an account*/
private JButton 		jb_Deposit;
/**jb_withdrawal is a JButton that handels the accion of substracting money to an account*/
private JButton 		jb_Withdrawal;
/**jb_num is a JButton[] that representds the keyPad*/
private JButton[]		jb_num;
/**jp_Image is a MpontImagePanel who is a Jpanel for polymorphism it holds the image that is display*/
private MountImagePanel jp_Imagen;
/**jmb_barra is a JMenuBar that represents the Menu Bar of the main window*/
private JMenuBar	 	jmb_barra;
/**jm_Close is a JMenu that only has the option of closing the aplication*/
private JMenu			jm_Close;
/**jm_Account is a JMenu that has the option related with creating,editing and viewing the accounts*/
private JMenu 			jm_Account;
/**jmi_Login is a JmenuItem that handels the action of creating a window dialog where a user must identified himself by entereing the necesary data*/
private JMenuItem 		jmi_Login;
/**jmi_Logout is a JMenuItem that handels the oposit action of jmi_Login */
private JMenuItem 		jmi_Logout;
/**jmi_Close is a JMenuItem that handels the action of closing the aplication */
private JMenuItem 		jmi_Close;
/**jp_center_a is the JPanel is related to how is display the window*/
private JPanel 			jp_center_a;
/**jp_west_a is the JPanel is related to how is display the window*/
private JPanel 			jp_west_a;
/**jp_west_a_top is the JPanel is related to how is display the window*/
private JPanel 			jp_west_a_top;
/**jp_west_a_bottom is the JPanel is related to how is display the window*/
private JPanel 			jp_west_a_botton;

/**mainWindow is a BankWindow that represents a reference of this window so it can be manipulated for the inner classes*/
private BankWindow mainWindow;
/*miBanco is a Banco that handels all of the necesary actions that a bank needs*/
private Banco 			miBanco;
/**currentCustomer is an int that represents the position in the Linkedlist that the customer that is been treated has*/
private int 			currentCustomer;
/**isLogIn is a boolean that indocates the state of the current customer that is been treated*/
private boolean 		isLogIn;


/**This methos launches the <code>Applet</code>
 **/
    public void init() {
    	

   	  	miBanco=new Banco(); 
   	   	
   	    mainWindow=this; //the referense of the object that is currently in use is pass to mainWindow so the inner classes can manipulate it
       	jpf_Data_entry=new JPasswordField();
       	jpf_Data_entry.setEnabled(false);
    	jtf_Message=new JTextField("Welcome to Wardmatc Bank");
    	
    	jb_Display=new JButton("Display account balance");
    	jb_Deposit=new JButton("Make a deposit");
    	jb_Withdrawal=new JButton("Make a withdrawal");
    	
    	jb_num=new JButton[12];
    	
    	jp_center_a=new JPanel(new BorderLayout());
    	jp_west_a=new JPanel(new GridLayout(0,1));
    	jp_west_a_top=new JPanel(new GridLayout(0,1));
    	jp_west_a_botton=new JPanel(new GridLayout(4,3));
   
    
    	jmb_barra =new JMenuBar();
    	jm_Close=new JMenu("Close");
    	jm_Account=new JMenu("Account");
    	
    	creaMenuNormal();
    	dameForma();
       	isLogIn=false;
    }
    
    
    /**This method is where the main window takes its finally form.
     **/    

    public void dameForma(){
    	jb_Deposit.setEnabled(false);
    	jb_Deposit.setActionCommand("Deposit");
    	jb_Display.setEnabled(false);
    	jb_Display.setActionCommand("Display");
    	jb_Withdrawal.setEnabled(false);
    	jb_Withdrawal.setActionCommand("Withdraval");
    	   
    	   customerAction();
    	    
    	jp_west_a_top.add(jb_Display);
    	jp_west_a_top.add(jb_Deposit);
    	jp_west_a_top.add(jb_Withdrawal);
    	
    	jp_west_a_top.add(jpf_Data_entry);
    	
    	for(int i=0;i<=9;i++){
    		int j=i;
    		if(i==9) j=-1;
    		jb_num[i]=new JButton(""+(j+1));
    		jb_num[i].addActionListener(new ActionListener(){
    			
    			public void actionPerformed(java.awt.event.ActionEvent e){
    				jpf_Data_entry.setText(""+jpf_Data_entry.getText()+e.getActionCommand());
    			}
    			
    			});
    		jp_west_a_botton.add(jb_num[i]);
    	}
    	
    		jp_west_a_botton.add(jb_num[9]);
    		
    		jb_num[10]=new JButton("Clear");
    		jp_west_a_botton.add(jb_num[10]);
    		jb_num[10].addActionListener(new ActionListener(){
    			
    			public void actionPerformed(java.awt.event.ActionEvent e){
    				jpf_Data_entry.setText("");
    			}});
    	
    		jb_num[11]=new JButton("Enter");
    		jp_west_a_botton.add(jb_num[11]);
    		
    		
    		jb_num[11].addActionListener(new ActionListener(){
    			
    			public void actionPerformed(java.awt.event.ActionEvent e){
    				// llama aconfirm cuenta
    				mainWindow.jp_Imagen.cargaNombre("lo logre");
    				ConfirmAccount ventana =new ConfirmAccount(jpf_Data_entry.getText(),mainWindow);
    				ventana.show();
    			}});
    
    
    		jp_west_a.add(jp_west_a_top);
    		jp_west_a.add(jp_west_a_botton);
    		try{
    			jp_Imagen=new MountImagePanel("imagenes/Banco.jpg",250,150);    	        	    	
    	   	jp_center_a.add(jp_Imagen,BorderLayout.CENTER);
    		}catch(Exception ex){
    			jp_center_a.add(new JTextArea("Error cargando imagen"),BorderLayout.CENTER);
    		}
    			
    		jp_center_a.add(jtf_Message,BorderLayout.SOUTH);
    		
    		this.add(jp_west_a,BorderLayout.WEST);
    		this.add(jp_center_a,BorderLayout.CENTER);
    		
              		
        	this.setSize(450,200);

    
    }
       
    /**This methods is where the menu bar of the main window is created.
     *by ordering the elements that are part of it,and giving them the appropriate behaviour*/    	
    public void creaMenuNormal(){
		
		this.setJMenuBar(jmb_barra);
		
		JMenu jm_Log=new JMenu("Log");
				
		jm_Log.setMnemonic('L');
		jm_Account.setMnemonic('A');
		jm_Close.setMnemonic('C');
				
		jmb_barra.add(jm_Log);
		jmb_barra.add(jm_Account);
		jmb_barra.add(jm_Close);
			
		JMenuItem jmi_CreateAccount=new JMenuItem("Create ",'C');
		JMenuItem jmi_EditAccount=new JMenuItem("Edit ",'E');
		JMenuItem jmi_ViewAccount=new JMenuItem("View ",'V');
		
		jm_Log.add(jmi_Login =new JMenuItem("Login",'I'));
		jm_Log.add(jmi_Logout =new JMenuItem("Logout",'O'));
		jm_Account.add(jmi_ViewAccount);
		jm_Account.add(jmi_CreateAccount);
		jm_Account.add(jmi_EditAccount);
		jm_Account.setVisible(false);
		jm_Close.add(jmi_Close=new JMenuItem("Close",'C'));
		
				
		jmi_Login.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
    	jmi_Logout.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
    	jmi_Close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
    	jmi_ViewAccount.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
    	jmi_CreateAccount.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
    	jmi_EditAccount.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
      
		jmi_Login.addActionListener(new ActionListener(){
    			public void actionPerformed(java.awt.event.ActionEvent e){
    				// An instance of ConfirmAccount is created passing a string(the password) and a BankWindow(the owner) 
    				
    				ConfirmAccount ventana =new ConfirmAccount(jpf_Data_entry.getText(),mainWindow);
    				ventana.setVisible(true);
    				jtf_Message.setText("Loggingin");
    				
    				}});
    				
    	jmi_Logout.addActionListener(new ActionListener(){
    			public void actionPerformed(java.awt.event.ActionEvent e){
    				mainWindow.enableBankButtons(false);
    				jpf_Data_entry.setText("");
    				mainWindow.adminMenuBar(false);
    				mainWindow.isLogIn=false;
    				    	jtf_Message.setText("Logout went well");
    				}});
    
    	jmi_CreateAccount.addActionListener(new ActionListener(){
    			public void actionPerformed(java.awt.event.ActionEvent e){
    				// an instance of CrearCuentaWindow is created passing a BankWindow as an argumend that represents the owner of the CrearCuentaWindow
    				CrearCuentaWindow ventana =new CrearCuentaWindow(mainWindow);
    				ventana.setVisible(true);
    				jtf_Message.setText("Creating a new account");
    				}});
    				
		jmi_ViewAccount.addActionListener(new ActionListener(){
    			public void actionPerformed(java.awt.event.ActionEvent e){
    				// an instance of ViewAccount is created passing a BankWindow as an argumend that represents the owner of the ViewAccount
    				ViewAccounts ventana =new ViewAccounts(mainWindow);
    				
    				jtf_Message.setText("Viewing the data of all the customers");
    				}});
		
		jmi_EditAccount.addActionListener(new ActionListener(){
    			public void actionPerformed(java.awt.event.ActionEvent e){
    				// An instance of ConfirmAccount is created passing an EditarCuentaWindow instance and a BankWindow(the owner) 
    			ConfirmAccount ventana =new ConfirmAccount(mainWindow,new EditarCuentaWindow(mainWindow));
    				ventana.setVisible(true);
    				jtf_Message.setText("Editing customer");
    				}});
		
		
		jmi_Close.addActionListener(new ActionListener(){
    			public void actionPerformed(java.awt.event.ActionEvent e){
    				if(!mainWindow.isLogIn){

    			mainWindow.destroy();
    				}
    				else
    					JOptionPane.showMessageDialog(null,"Primero debe Cerrar sesion","Posible lost of information : Correct it",JOptionPane.OK_OPTION);
    				}});
		

	}
	
	/**This method has the function of giving the Customer actions to the respective JButtons such as:
	 * jb_Deposit That handles the Deposit that a customer can make to his/her balance
	 *jb_Display That handles the Displaying of a customer balance
	 *jb_Withdrawal that handles the withdrawal a customer can make to his/her balance*/
	public void customerAction(){
		
    	jb_Deposit.addActionListener(new ActionListener(){
   		public void actionPerformed(ActionEvent e){
    		
    	String deposit= JOptionPane.showInputDialog(mainWindow,"Enter The amount of money that is gonig to be added to the balance : ");
    	esqueleto.Customer client=mainWindow.getCustomer(mainWindow.getCurrentCustomer());
    	try{
    		if(deposit!=null){
    		client.deposit(Double.parseDouble(deposit));
    		jtf_Message.setText("A Deposit of "+deposit+" has been made succesfully");
    		}
    		else{
    			jtf_Message.setText("The Deposit has Been Canceled");
    		}
    	}catch(Exception ex) {
    		JOptionPane.showMessageDialog(null,"Please enter a valid amount","Error while trying to deposit",JOptionPane.ERROR_MESSAGE);
    		jtf_Message.setText("Wrong entry : amount entered not valid");
    		actionPerformed(e);
    	}   		
    		   	}});
    			
    	jb_Display.addActionListener(new ActionListener(){
   		public void actionPerformed(ActionEvent e){
   			String balance=mainWindow.getCustomerInfo(mainWindow.getCurrentCustomer(),7);
   			String fullName=mainWindow.getCustomerInfo(mainWindow.getCurrentCustomer(),0);
    		fullName=fullName+mainWindow.getCustomerInfo(mainWindow.getCurrentCustomer(),2);
    		JOptionPane.showMessageDialog(mainWindow,"Your balance is : "+balance,"Displaing "+fullName+" Balance",JOptionPane.INFORMATION_MESSAGE);
    	
    		jtf_Message.setText("Your Balance is "+balance);
    	}  })	;
    			
    	jb_Withdrawal.addActionListener(new ActionListener(){
   		public void actionPerformed(ActionEvent e){
   			
    	String withdrawal= JOptionPane.showInputDialog(mainWindow,"Enter The amount of money that is gonig to be substracted to the balance : ");
    	esqueleto.Customer client=mainWindow.getCustomer(mainWindow.getCurrentCustomer());
    	try{
    		if(withdrawal!=null){
    		client.withdraw(Double.parseDouble(withdrawal));
    		jtf_Message.setText("Withdrawal does well :");
    		}
    	
    	}catch(OverdraftException ex) {
    			JOptionPane.showMessageDialog(null,"Please enter a smaller amount : \n You have a deficit of "+ex.getDeficit(),"Error while trying to withdrawal",JOptionPane.ERROR_MESSAGE);
    			jtf_Message.setText("Withdrawal not valid :"+withdrawal+" of withdrawal produces an Overdraft");
    		actionPerformed(e);	
    	}catch(Exception ex) {
    		JOptionPane.showMessageDialog(null,"Please enter a valid amount","Error while trying to withdrawal",JOptionPane.ERROR_MESSAGE);
    		jtf_Message.setText("Wrong entry : amount entered not valid");
    		actionPerformed(e);
    	}   		   			
   			
    		 }});

	}
	
	/**This method according to the argument given can Enable /Disable the JButtons that handles the customer actions
	 *@param enable Represents the Enabling state the buttons are going to have
     **/
    public void enableBankButtons(boolean enable){
    	jb_Display.setEnabled(enable);
    	jb_Deposit.setEnabled(enable);
    	jb_Withdrawal.setEnabled(enable);
    }
    
	/**This method sets the IsLogIn field value
	 *@param state It is the value that is going to be assing to the field isLogin 
	 **/
	public void setLoginState(boolean state){
		   	isLogIn=state;
		   } 
    
    /**This methods according to the fact (the administrator is /is not loging) can enable/disable the Account menu
     *@param state It is the state of the Account menu
     **/
    public void adminMenuBar(boolean state){
    	jm_Account.setVisible(state);
    }
      
    /**This method assign the value of the field currentCustomer,that represents the position of the customer that is currently been use
     *@param currentCustomer It has the value that is going to be assigned to the field currentCustomer*/
    
    public void setCurrentCustomer(int currentCustomer){
    	jtf_Message.setText("Current Customer : "+this.getCustomer(currentCustomer).getFirstName()+" "+this.getCustomer(currentCustomer).getLastName());
    	this.currentCustomer=currentCustomer;
    }
    
    /**This method returns the position of the customer that is currently been use by accesing the field currentCustomer `s value*
     */
    public int getCurrentCustomer(){
    	return currentCustomer;
    }
    
    /**This method returns a customer in a specified position of the list
     *@param position is the position of the customer that is into the Linkedlist*/
    public Customer getCustomer(int position){
    return miBanco.getCustomer(position);
    }
  
    /**This method returns the especified customer data,according to the number that is been given as an argument
     *@param costumerIndex Is the position into the linkedlist of a customer 
     *@param infoNum Is the number that is going to be compare inside the method to see using a switch statement whath option is to be returned
     **/
    public String getCustomerInfo(int customerIndex,int infoNum){
    	Customer cliente =miBanco.getCustomer(customerIndex);
    	String info;
    	switch(infoNum){
    		case 0:
    			info= cliente.getFirstName();
    			break;
    		case 1:
    			info= cliente.getMiddleName();
    			break;
    		case 2:
    			info= cliente.getLastName();
    			break;
    		case 3:
    			info= cliente.getMothersName();
    			break;
    		case 4:
    			info= cliente.getId();
    			break;
    		case 5:
    			info= cliente.getEmail();
    			break;
    		case 6:
    			info= new String(cliente.getPasswordCustomer());
    			break;
    		case 7:
    			info=""+cliente.getBalance();
    			break;
    		case 8:
    			info=cliente.getAccountType();
    				break;
    		default:
    			if(cliente.getState())
    				info="Habilitado";
    			else
    				info="Desabilitado";
    			break;
    			
    	}
    	
    	return info;
    }
  
     
   /**This method returns the number of <code>Customer</code>s that are currently been save into the <code>Banco --> Linkedlist</code> 
    *by callig the <code>Banco --> getNumOfCustomers()</code>  method that returns the size of the <code>Linkedlist</code> that stores the <code>Customer</code> objects. */
    public int getNumOfCustomers(){
     	return miBanco.getNumOfCustomers();
     }
     
    /**This method Verifies a customer data agains the values given that where captured in a verification window
     *@param startFrom It is represents the star position of the comparing
     *@param firstName It is the first name that is going to be compare
     *@param lastName It is the last name that is going to be compare
     **/    
    public int checkCustomer(int startFrom,String firstName,String lastName,String password){
    	return miBanco.checkCustomer(startFrom,firstName,lastName,password);
    }
    
    /**This method is used to save a customer once it has been modified
     *@param position it is the position into the Linkedlist where the customer is going to be save
     *@param client It is the customer that is going to be save*/
    public void saveCustomer(int position,Customer client){
    
    	    	miBanco.addCustomer(position,client);
    	}
    
    /**This method is call to save the Linkedlist to a file,by calling the guardaLista() method of the Banco class
     **/
    	
    
    
	
}
