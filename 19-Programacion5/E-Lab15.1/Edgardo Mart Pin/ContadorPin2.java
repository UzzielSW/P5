/**
 * @(#)Contador2.java
 *
 *
 * @Edgardo Martínez
 * @version 1.40 2016/8/6
 */


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.*;

@SuppressWarnings("serial")
class NumeroNegativoException extends Exception { NumeroNegativoException(){ } }

public class ContadorPin2 extends JFrame implements ActionListener,  Runnable{
	private static final long serialVersionUID = 1L;
	
	public JButton go;
	public Button suspenderBoton = new Button("Suspender");
    public Button reanudarBoton = new Button("Reanudar");
    public Button stopBoton = new Button("Stop");
	public JTextField camp;
	public JTextArea area;
	public int time;
	public JScrollPane scrone;
	public JPanel down,center;
	public JLabel warning;
	
	public boolean suspendido = true;
	private boolean stop = false;

	
  //---------------------------------------------------------------CONSTRUCTOR
	public ContadorPin2(){
		time=0;
		
		center=new JPanel (new BorderLayout());
		down=new JPanel (new GridLayout(1,5));
		go = new JButton("GO!");	
		camp= new JTextField();
		area= new JTextArea();
		scrone=new JScrollPane(area);
		warning=new JLabel("Escribir el tiempo en milisegundos.");
	}
	
	public synchronized void apagar() {

                 stop=false;

                 notifyAll();

         }

         public synchronized void iniciar() {

                 stop = true;

         }
	
  //----------------------------------------------------------METODO PARA LANZAR INTERFAZ
	public void lanzador(){
		area.setEditable(false);
		area.setBackground(Color.WHITE);
		center.add(warning,BorderLayout.SOUTH);
		center.add(scrone,BorderLayout.CENTER);
		down.add(camp);
		down.add(go);
		down.add(suspenderBoton);
		down.add(reanudarBoton);
		down.add(stopBoton);
		
		this.add(center,BorderLayout.CENTER);
		this.add(down, BorderLayout.SOUTH);
		
		go.addActionListener(this);
		suspenderBoton.addActionListener(this);
		
		
		reanudarBoton.addActionListener(this);
	    stopBoton.addActionListener(this);
	    suspenderBoton.setEnabled(false);
		reanudarBoton.setEnabled(false);
		stopBoton.setEnabled(false);
		
		
		this.setTitle("Contador");
		this.setSize(400,400);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
  //=-------------------------------------------------------------------------METODO RUN
    public void run(){
    	
    		long t= System.currentTimeMillis();
    	
    		go.setEnabled(false);
    		suspenderBoton.setEnabled(true);
		reanudarBoton.setEnabled(true);
		stopBoton.setEnabled(true);
    		 
    		area.setText(""); 
    		
    		long end = t+time; 
    		int next=1;
    		
    		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    		while(suspendido) 
    		{
    				area.setText(area.getText()+next+"\n");
    				scrone.getVerticalScrollBar().setValue(scrone.getVerticalScrollBar().getMaximum());	
    			 
    		    next++;
    		    try { 
    		    
    		    Thread.sleep(1000); 
    		    
    		 /*   synchronized(this) {

                 while(suspendido) wait();
                        
                        } */

    		    
    		    
    		    } catch (InterruptedException e) { e.printStackTrace(); }
    	    }
    		// - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - 
    		
    		  if (time>0){
    			
    			  if (JOptionPane.showConfirmDialog(this,"¿Desea continuar?", "Mensaje",JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION)
    			  {
    				  JOptionPane.showMessageDialog(null, "Main() ha terminado");    
    				  System.exit(0);  
    			  }
    			  else{
    				  area.setText("");
    				  camp.setText("");
    			  }
    			 }
    		  go.setEnabled(true);
    		  suspenderBoton.setEnabled(false);
		      reanudarBoton.setEnabled(false);
		      stopBoton.setEnabled(false);  
    				
    }//FIN RUN
    //----------------------------------------------------------------------EVENTOS
  
  
  
   	public void actionPerformed(ActionEvent e) {
   	
		time=0;
		String cad=camp.getText(); 
		try{
	      time = Integer.parseInt(cad);
	      if (time <= 0){ throw new NumeroNegativoException(); }
		}
		catch(java.lang.NumberFormatException e1){
			JOptionPane.showMessageDialog(null, "Campo no puede estar vacio o contener letas");} 
		catch (NumeroNegativoException e1) {
			JOptionPane.showMessageDialog(null, "No se permite menores o iguales que cero"); }
	
		Thread hiloX = new Thread(this);
		hiloX.start();
   	}
   	
   	public void suspender() {

          suspendido = true;

           }

    public synchronized void reanudar() {

           suspendido = false;

           notify();

          }
  
}///////FIN CLASE\\\\\\\\

class Maine {
	
	public static void main(String []args){
		Contador obj= new Contador();
		obj.lanzador();
	}

}
