 package 	gui;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**This is an inner class that represents the <code>JButton</code> used to close the <code>ViewAccount</code> window
  **/
  public class Boton_Crear extends JDialog implements ActionListener,Runnable{
    	/**jb_Cerrar is a <code>JButton</code> that handleas the action of closing the <code>ViewAccount</code> window*/
    	private JButton jb_Cerrar;
    	/**ownerInner is a <code>JDialog</code> object that represents the owner of the <code>Boton_CancelaJDialog</code>*/
    	private BankWindow owner;
    	/**t is a <code>Thread</code> used to repaint the <code>jb_Cerrar</code>*/
    	private Thread t;
    	
    	/**
     * Creates a new instance of <code>Boton_Cancela</code>.
     */ 	
    	public Boton_Crear(BankWindow owner)
    	{	super(owner,false);
    		this.owner=owner;
    		this.setLayout(new BorderLayout());
    		
    		JPanel jp_aux=new JPanel();
    		jb_Cerrar=new JButton("CREAR");
    		jp_aux.add(jb_Cerrar);
    		this.add(jp_aux,BorderLayout.CENTER);
    		jb_Cerrar.addActionListener(this);
    		
    		this.setUndecorated(true);
    		this.setSize(130,30);
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
    	
     public void paint(Graphics g){
    	super.paint(g);
    	this.setLocation(owner.getX()+owner.getWidth(),owner.getY());
    	
        }
        
    
     public void actionPerformed(ActionEvent e){
     	t.stop();
		ATMBank u=new ATMBank();
		u.start();
    	this.dispose();
    
      }
      }
      
      
      
      
      
      
      
      ////////////////////////////////////////////////////////////
      
