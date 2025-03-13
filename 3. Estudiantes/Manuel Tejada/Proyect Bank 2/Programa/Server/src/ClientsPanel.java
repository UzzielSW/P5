/**
 * @(#)ClientsPanel.java
 *
 *
 * @author 
 * @version 1.00 2010/1/1
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import esqueleto.*;
import javax.swing.table.*;

public class ClientsPanel extends JPanel{

	  /**lkl_ClientsButton is a LinkedList that store all the clients JButtons*/	 
	  private java.util.LinkedList<ClientButton> lkl_ClientsButton;
   	  /**MiBanco is a Banco object that handles the real operation of the bank*/
	  private Banco miBanco;
     /**headings is an array of <code>String</code> that represents the headings of the <code>JTable</code>.*/
	  private String[] headings;
	  /** table is a AbstractTableModel*/
	  private javax.swing.table.AbstractTableModel table;
	  /**table is a <code>JTable</code> where the information of the customers are goingto be shown.*/
	  private JTable jt_Table;
	  /**data is an array of <code>Object</code> that represents the information shown into the <code>JTable</code>.*/
   	  private Object[][] data;
   	  /** jp_Botones is a JPanel where the Client´s JButtons are store*/
   	  private JPanel jp_Botones;
   	  /**owner is a Server that represents the owner of this object*/
      private Server owner;
      /**jta_AreaData is a JTextArea where the Server Activity is going to be show*/
      private JTextArea jta_AreaData;
      static int i;
	
	/**This method creates a new instance of <code>ClientsPanel</code> is created
	 **/
    public ClientsPanel(Server owner) {
    	this.owner=owner;
    	this.miBanco=owner.getBanco();
    	jta_AreaData=new JTextArea();
   
    	lkl_ClientsButton=new java.util.LinkedList();
    	
		this.setLayout(new BorderLayout(10,10));
    	loadData();
    	
    }
    
    /**This method is where the data showed in the JTable is loaded
     **/
    public void loadData(){
    
    	jp_Botones=new JPanel(new java.awt.GridLayout(0,1,5,5));
    	
    	headings=new String[]{"First Name","Middle Name","Last Name","Mother`s Name","ID","E-mail     .","Password","Balance","Account Type","State"};
    	data=new Object[miBanco.getNumOfCustomers()+5][1];
    	        	
    	for(i=0;i<miBanco.getNumOfCustomers();i++){
    	
    		Object[] customerData=new Object[10];
    		Customer client=miBanco.getCustomer(i);
    		
    		lkl_ClientsButton.add(i,new ClientButton(""+client.getFirstName(),owner));
    		
    		lkl_ClientsButton.get(i).setClientNumber(i);
    		
    		jp_Botones.add(lkl_ClientsButton.get(i));
    		
    		customerData[0]=client.getFirstName();
    		customerData[1]=client.getMiddleName();
    		customerData[2]=client.getLastName();
    		customerData[3]=client.getMothersName();
    		customerData[4]=client.getId();
    		customerData[5]=client.getEmail();
    		customerData[6]=client.getPasswordCustomer();
    		customerData[7]=""+client.getBalance();
    		customerData[8]=client.getAccountType();
    		customerData[9]=""+client.getState();
    
    	
    	data[i]=customerData;	
    	}
    	data[miBanco.getNumOfCustomers()]=new Object[]{"","","","","","","","","",""};
    	data[miBanco.getNumOfCustomers()+1]=new Object[]{"","","","","","","","","",""};
    	data[miBanco.getNumOfCustomers()+2]=new Object[]{"","","","","","","","","",""};
    	data[miBanco.getNumOfCustomers()+3]=new Object[]{"","","","","","","","","",""};
    	data[miBanco.getNumOfCustomers()+4]=new Object[]{"","","","","","","","","",""};
    	
    	
    	JPanel jp_Aux=new JPanel(new GridLayout(2,1));
    		/////////////////////////
    	table=new javax.swing.table.AbstractTableModel() {
    public String getColumnName(int col) {  return headings[col].toString();    }
    
    public int getRowCount() { return data.length; }
    
    public int getColumnCount() { return headings.length; }
    
    public Object getValueAt(int row, int col) {   return data[row][col];    }
    
    public boolean isCellEditable(int row, int col)        { return true; }
    
    public void setValueAt(Object value, int row, int col) {
        data[row][col] = value;
        fireTableCellUpdated(row, col);    }
};

    	///////////////
    	
    jt_Table=	new JTable(table);
	  	jp_Aux.add(new JScrollPane(jt_Table));
	  	jp_Aux.add(new JScrollPane(jta_AreaData));
	  	
	  	this.add(jp_Aux,java.awt.BorderLayout.CENTER);
	
	  	this.add(jp_Botones,java.awt.BorderLayout.WEST);
    
    	
    	
    }
    
    /**This method is called to set the JButton Color
	 **/
    public void setClientsConectionColor(){
    	for(int i=0;i<lkl_ClientsButton.size();i++){
    		lkl_ClientsButton.get(i).setConectionColor();
    	}
    }
    
    /**This method is called to set the thread associated with the JButton
	 *@param Thread Is the thread associated with the JButton
	 **/
    public void setButtonThread(int pos,ClientsThread thread){
    	this.lkl_ClientsButton.get(pos).setThread(thread);
    	
    }
    
    	/**This method is called to get the thread associated with the JButton
	 *@return ClientsThread Is the thread associated with the JButton
	 **/
	public ClientsThread getThread(int pos){
		return lkl_ClientsButton.get(pos).getThread();
	}
    
    /**This method is called to get the <code>JTextArea</code> where the <code>Server</code> activity is going to be display
     **/
    public JTextArea regresaAreaDatos(){
    	return jta_AreaData;
    }
    
    /**This method is called to edit a <code>Customer</code> Info into the table
     *@param position Is the row number that is going to be edited
     *@param client Is the client with the new data that must be display into the Jtable*/
    public void changeCustomerInTable(int position,Customer client){
    	
    	table.setValueAt(client.getFirstName(),position,0);
    	table.setValueAt(client.getMiddleName(),position,1);
    	table.setValueAt(client.getLastName(),position,2);
    	table.setValueAt(client.getMothersName(),position,3);
    	table.setValueAt(client.getId(),position,4);
    	table.setValueAt(client.getEmail(),position,5);
    	table.setValueAt(client.getPasswordCustomer(),position,6);
    	table.setValueAt(""+client.getBalance(),position,7);
    	table.setValueAt(client.getAccountType(),position,8);
    	table.setValueAt(""+client.getState(),position,9);
    	
    	table.fireTableDataChanged();
    	
    }
    
    /**This methods is called so the new <code>Customer</code> information is showed into the <code>LinkedList</code>
     *@param client is the new new <code>Customer</code> whose information is going to be showed into the <code>LinkedList</code>
     **/
    public void addCustomerToTable(Customer client){
    	
    	//changeCustomerInTable(owner.getBanco().getNumOfCustomers()-1,client);
    		changeCustomerInTable(i,client);
    		addButton(client.getFirstName());
    		owner.repaint();
    		i++;
    }
    
    /**This method is called to add a new JButton that represents a new Customer
     **/
    public void addButton(String tittle){
    	lkl_ClientsButton.add(lkl_ClientsButton.size(),new ClientButton(tittle,owner));
    	jp_Botones.add(lkl_ClientsButton.get(lkl_ClientsButton.size()-1));
    }
    /**This method is called to update the JTable*/
    public void actualizarTabla(){
    	for(int j=0;j<owner.getBanco().getNumOfCustomers();j++){
    		
    		Customer client = owner.getBanco().getCustomer(j);
    		int position=j;
    	table.setValueAt(client.getFirstName(),position,0);
    	table.setValueAt(client.getMiddleName(),position,1);
    	table.setValueAt(client.getLastName(),position,2);
    	table.setValueAt(client.getMothersName(),position,3);
    	table.setValueAt(client.getId(),position,4);
    	table.setValueAt(client.getEmail(),position,5);
    	table.setValueAt(client.getPasswordCustomer(),position,6);
    	table.setValueAt(""+client.getBalance(),position,7);
    	table.setValueAt(client.getAccountType(),position,8);
    	table.setValueAt(""+client.getState(),position,9);
    	
    	}
    	
    	table.fireTableDataChanged();
    }
    
}