/**
 * @(#)EditarCuentaWindow.java
 *
 *
 * @author Manuel Tejada 8-818-1801
 * @version 1.00 2009/11/30
 */


import java .awt.*;
import javax.swing.*;
import java.awt.event.*;
import esqueleto.Customer;
/**This class define a window where a user can edit the infotmation of the <code>Customer</code>*/
public class EditarCuentaWindow extends JDialog implements ActionListener ,ItemListener{
	/**owner is a <code>BankWindow</code> object that represents the owner of the <code>EditarCuentaWindow JDialog</code>*/
	private Server owner;
	/**jp_Centro is a <code>JPanel</code> related with how is display the window*/
	private JPanel	jp_Centro;
	/**jp_CheckBoxes is a <code>JPanel</code> related with how is display the window*/
	private JPanel jp_CheckBoxes;
	/**jp_Botones is a <code>JPanel</code> related with how is display the window*/
	private JPanel jp_Botones;
	/**jb_Aceptar is a <code>JButton</code> that handlesthe action of sending the new data to the 
	 *respectives methods of the <code>Customer</code> so the fields can be edited*/
	private JButton jb_Aceptar;
	/**jb_Cancel is a<code> JButton</code> that handels the action of canceling the edition of a <code>Customer</code>.*/
	private JButton jb_Cancel;
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
	/**jtf_password is a <code>JTextField</code> where the password of the new <code>Customer</code>*/
	private JPasswordField jpf_password;
	/**jchb_Aux is an array of <code>JCheckBox</code>s that are used to enable the <code>JTextField</code>*/
	private JCheckBox[] jchb_Aux;
	/**client is a <code>Customer</code> object that is going to represent the customer which information is going to be edited*/
	private Customer client;
	/**jchb_Enable is a <code>JCheckBox</code> that represents that a <code>Customer</code> is Enabled*/
	private JCheckBox jchb_Enable;
	/**jchb_Disable is a <code>JCheckBox</code> that represents that a <code>Customer</code> is Disabled*/
	private JCheckBox jchb_Disable;

/**This method creates a new instance of a <code>EditarCuentaWindow
 *@param owner is a <code>BankWindow</code> object that represents the owner of the <code>CrearCuentaWindow JDialog</code>*/
	public EditarCuentaWindow(Server owner){
		super(owner,"...:::Edit Account:::...",true);
		this.owner=owner;
	
	jp_Centro=new JPanel(new BorderLayout());	
	jp_Botones=new JPanel(new GridLayout(1,1));	
	jp_CheckBoxes=new JPanel(new GridLayout(0,1));	
	
	jb_Aceptar=new JButton("Aceptar");
	jb_Cancel=new JButton("Cancelar");	
		
	jchb_Enable=new JCheckBox("Enable",owner.getCustomer(owner.getCurrentCustomer()).getState());
	jchb_Disable=new JCheckBox("Disable",!owner.getCustomer(owner.getCurrentCustomer()).getState());
	
	jtf_fName=new JTextField(5);
	jtf_mName=new JTextField(5);
	jtf_lName=new JTextField(5);
	jtf_moName=new JTextField(5);
	jtf_id=new JTextField(5);
	jtf_eMail=new JTextField(5);
				
	jpf_password=new JPasswordField(5);
		
	
	jchb_Aux=new JCheckBox[8];
	for(int i=0;i<8;i++) {
		jchb_Aux[i]=new JCheckBox("");
	
		}
	enableTextField();	
	Crear();	
	}
	
	/**This method is where the <code>EditarCuentaWindow</code> takes its finally form.
     **/    	
	public void  Crear(){
	setLayout(new BorderLayout());
		
	JPanel jp_Labels =new JPanel(new GridLayout(0,1));
	JPanel jp_TextField =new JPanel(new GridLayout(0,1,0,25));
	
	jp_CheckBoxes.add(jchb_Aux[0]);
	jp_Labels.add(new JLabel("Primer Nombre "));
	jp_TextField.add(jtf_fName);
	jchb_Aux[0].addItemListener(this);
	
	
	jp_CheckBoxes.add(jchb_Aux[1]);
	jp_Labels.add(new JLabel("Segundo Nombre "));
	jp_TextField.add(jtf_mName);
	jchb_Aux[1].addItemListener(this);
	
	
	jp_CheckBoxes.add(jchb_Aux[2]);
	jp_Labels.add(new JLabel("Apellido de padre "));
	jp_TextField.add(jtf_lName);
	jchb_Aux[2].addItemListener(this);
	
	jp_CheckBoxes.add(jchb_Aux[3]);
	jp_Labels.add(new JLabel("Apellido de madre"));
	jp_TextField.add(jtf_moName);
	jchb_Aux[3].addItemListener(this);
		
	jp_CheckBoxes.add(jchb_Aux[4]);
	jp_Labels.add(new JLabel("ID"));
	jp_TextField.add(jtf_id);
	jchb_Aux[4].addItemListener(this);
		
	jp_CheckBoxes.add(jchb_Aux[5]);
	jp_Labels.add(new JLabel("E-mail"));
	jp_TextField.add(jtf_eMail);
	jchb_Aux[5].addItemListener(this);
		
	jp_CheckBoxes.add(jchb_Aux[6]);
	jp_Labels.add(new JLabel("Password "));
	jp_TextField.add(jpf_password);
	jchb_Aux[6].addItemListener(this);
	
	JPanel aux=new JPanel(new BorderLayout());
	ButtonGroup h=new ButtonGroup();
	h.add(jchb_Disable);
	h.add(jchb_Enable);
	aux.add(jchb_Enable,BorderLayout.WEST);
	aux.add(jchb_Disable,BorderLayout.EAST);
	
	jp_CheckBoxes.add(jchb_Aux[7]);
	jp_Labels.add(new JLabel("Enable "));
	jp_TextField.add(aux);
	jchb_Aux[7].addItemListener(this);
	
	
	jp_Centro.add(jp_Labels,BorderLayout.WEST)	;
	jp_Centro.add(jp_TextField,BorderLayout.CENTER)	;
	
	jb_Aceptar.addActionListener(this);
	jb_Cancel.addActionListener(this);
	
	jp_Botones.add(jb_Aceptar);
	jp_Botones.add(jb_Cancel);
	
	this.add(jp_CheckBoxes,BorderLayout.WEST);
	this.add(jp_Centro,BorderLayout.CENTER);
	this.add(jp_Botones,BorderLayout.SOUTH);
	
	setSize(400,400);
	setLocation((owner.getX()+owner.getWidth())/2,(owner.getY()+owner.getHeight())/2);

	}

	/**This method handles the action of checkBoxs
	 **/
	public void itemStateChanged(ItemEvent e){
	enableTextField();
			}
	
	/**This method handles the action the <code>JButtons : jb_Aceptar , jb_Cancel</code> 
	 **/
	public void actionPerformed(ActionEvent e){
		if(e.getActionCommand().equals("Aceptar")){
			checkData();
			makeChanges();
			JOptionPane.showMessageDialog(this,"Changes have been made","Changing Window",JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
		}
		else if(e.getActionCommand().equals("Cancelar")){
		this.dispose();
		
		}
	}    
    
    /**This method is where the action of enabling and disabling the JTextField are done
     **/
    public void enableTextField(){
    	
		jtf_fName.setEditable(jchb_Aux[0].isSelected());
		jtf_mName.setEditable(jchb_Aux[1].isSelected());
		jtf_lName.setEditable(jchb_Aux[2].isSelected());
		jtf_moName.setEditable(jchb_Aux[3].isSelected());
		jtf_id.setEditable(jchb_Aux[4].isSelected());
		jtf_eMail.setEditable(jchb_Aux[5].isSelected());
				
		jpf_password.setEditable(jchb_Aux[6].isSelected());
		jchb_Enable.setEnabled(jchb_Aux[7].isSelected());	
		jchb_Disable.setEnabled(jchb_Aux[7].isSelected());	
	
    }
    
    /**This method is where the <code>JTextField</code>s are Disable if they have no data
     **/
    public void checkData(){
    	if(jchb_Aux[0].isSelected()&&jtf_fName.getText().equals("")){
    		 jtf_fName.setEditable(false);
    		 jchb_Aux[0].setSelected(false);}
    		 
    	if(jchb_Aux[1].isSelected()&&jtf_mName.getText().equals("")){
    		 jtf_mName.setEditable(false);
    		 jchb_Aux[1].setSelected(false);}
    		 
    	if(jchb_Aux[2].isSelected()&&jtf_lName.getText().equals("")){
    		 jtf_lName.setEditable(false);
    		 jchb_Aux[2].setSelected(false);}
    		 
    	if(jchb_Aux[3].isSelected()&&jtf_moName.getText().equals("")){ 
    		jtf_moName.setEditable(false);
    		jchb_Aux[3].setSelected(false);}
    		
    	if(jchb_Aux[4].isSelected()&&jtf_id.getText().equals("")) {
    		jtf_id.setEditable(false);
    		jchb_Aux[4].setSelected(false);}
    		
    	if(jchb_Aux[5].isSelected()&&jtf_eMail.getText().equals("")){ 
    		jtf_eMail.setEditable(false);
    		jchb_Aux[5].setSelected(false);}
    		
    	if(jchb_Aux[6].isSelected()&&jpf_password.getText().equals("")) {
    		jpf_password.setEditable(false);
    		jchb_Aux[6].setSelected(false);}
    }
    
    /**This method is the one that according to what <code>JCheckBox</code>s are enable the changes are made
     **/
    public void makeChanges(){
    	client=owner.getCustomer(owner.getCurrentCustomer());
    	if(jchb_Aux[0].isSelected())
    		client.setFirstName(jtf_fName.getText());
    		 
    	if(jchb_Aux[1].isSelected())
    		client.setMiddleName(jtf_mName.getText());
    		
    	if(jchb_Aux[2].isSelected())
    		client.setLastName(jtf_lName.getText());
    		 
    	if(jchb_Aux[3].isSelected())
    		client.setMothersName(jtf_moName.getText());
    		
    	if(jchb_Aux[4].isSelected())
    		client.setId(jtf_id.getText());
    		
    	if(jchb_Aux[5].isSelected())
    		client.setEmail(jtf_eMail.getText());
    		
    	if(jchb_Aux[6].isSelected())
    		client.setPasswordCustomer(new String(jpf_password.getPassword()));
    	if(jchb_Aux[7].isSelected())
    		client.setState(jchb_Enable.isSelected());
       
    	owner.guardaLista();
    	owner.changeCustomerInTable(owner.getCurrentCustomer(),client);
    }
    
}
