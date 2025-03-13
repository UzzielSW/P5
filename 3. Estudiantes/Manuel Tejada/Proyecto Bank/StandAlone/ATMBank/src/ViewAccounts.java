/**
 * @(#)ViewAccounts.java
 *
 *
 * @author Manuel Tejada 8-818-1801
 * @version 1.00 2009/11/30
 */
package gui;

import java .awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
/**This class is where allthe customer info is shown in a <code>JTable</code>
 **/
public class ViewAccounts extends JDialog {
        
    /**owner is a <code>BankWindow</code> object that represents the owner of the <code>ViewAccount JDialog</code>*/
     	private BankWindow owner;
     	/**headings is an array of <code>String</code> that represents the headings of the <code>JTable</code>.*/
     	private String[] headings;
     	/**table is a <code>JTable</code> where the information of the customers are goingto be shown.*/
     	private JTable table;
     	/**data is an array of <code>Object</code> that represents the information shown into the <code>JTable</code>.*/
     	private Object[][] data;
     	/**boton is a <code>JDialog</code> that represents the <code>JButton</code> used to close the window*/
     	private Boton_Cancela boton;
     	        	
    /**
     * Creates a new instance of <code>ViewAccounts</code>.
     */ 	
    public ViewAccounts(BankWindow owner) {
    	super(owner,"...:::Wardmatc Bank : Data Base :::...",true);
    	this.owner=owner;
    	headings=new String[]{"First Name","Middle Name","Last Name","Mother`s Name","ID","E-mail     .","Password","Balance","Account Type","State"};
    	data=new Object[owner.getNumOfCustomers()][1];
		loadData();
		
		//table=new JTable(data,headings);	
		table=new JTable(data,headings);	
	  	this.add(new JScrollPane(table));
    	
    	boton=new Boton_Cancela(this);
    	    	
    	setSize(750,150);
    	setVisible(true);
    	
    	    	
    }
    
    /**This methods is called to repaint the <code>JComponents</code> of the window
     **/
    public void paint(Graphics g){
    	super.paint(g);
    	this.boton.repaint();
        }  
        
        /**This method is where the information of every <code>Customer</code> of the bank if putted into the <code>Object</code>
         * array data*/	
    public void loadData(){
    	//recorrolista
        	
    	for(int i=0;i<owner.getNumOfCustomers();i++){
    		
    		Object[] customerData=new Object[10];
    			System.out.print("Numero de clientes es "+owner.getNumOfCustomers()+"\n");
    		customerData[0]=owner.getCustomerInfo(i,0);
    		customerData[1]=owner.getCustomerInfo(i,1);
    		customerData[2]=owner.getCustomerInfo(i,2);
    		customerData[3]=owner.getCustomerInfo(i,3);
    		customerData[4]=owner.getCustomerInfo(i,4);
    		customerData[5]=owner.getCustomerInfo(i,5);
    		customerData[6]=owner.getCustomerInfo(i,6);
    		customerData[7]=owner.getCustomerInfo(i,7);
    		customerData[8]=owner.getCustomerInfo(i,8);
    		customerData[9]=owner.getCustomerInfo(i,9);
    
    	
    	data[i]=customerData;	
    	}
    }
 
 /**This is an inner class that represents the <code>JButton</code> used to close the <code>ViewAccount</code> window
  **/
    private class Boton_Cancela extends JDialog implements ActionListener,Runnable{
    	/**jb_Cerrar is a <code>JButton</code> that handleas the action of closing the <code>ViewAccount</code> window*/
    	private JButton jb_Cerrar;
    	/**ownerInner is a <code>JDialog</code> object that represents the owner of the <code>Boton_CancelaJDialog</code>*/
    	private JDialog ownerInner;
    	/**t is a <code>Thread</code> used to repaint the <code>jb_Cerrar</code>*/
    	private Thread t;
    	
    	/**
     * Creates a new instance of <code>Boton_Cancela</code>.
     */ 	
    	public Boton_Cancela(JDialog ownerInner)
    	{	super(ownerInner,false);
    		this.ownerInner=ownerInner;
    		this.setLayout(new BorderLayout());
    		
    		JPanel jp_aux=new JPanel();
    		jb_Cerrar=new JButton("Cerrar");
    		jp_aux.add(jb_Cerrar);
    		this.add(jp_aux,BorderLayout.CENTER);
    		jb_Cerrar.addActionListener(this);
    		
    		this.setUndecorated(true);
    		this.setSize(70,70);
    		this.setVisible(true);
    		
    		t=new Thread(this);
    		t.start();
    		
    	}
    	
    	/**This method is invoked by the thread when its start() method is invoked
    	 **/
    	public void run(){
    		while(true){
    			this.repaint();
    		}
    	}
    	
    	/**This method is invoked every time <code>JComponeds</code> needs to be repaint
    	 **/
    public void paint(Graphics g){
    	super.paint(g);
    	this.setLocation(ownerInner.getX()+ownerInner.getWidth(),ownerInner.getY());
    	
        }
        
        /**This method handles the action of  the <code>JButton jb_Cerrar</code>
         **/
     public void actionPerformed(ActionEvent e){
     	t.stop();
    	ownerInner.dispose();
    	this.dispose();
    
      }	
  	}
  	}
