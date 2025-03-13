import java.awt.event.*;

public class ControladorDemonio extends Thread implements ActionListener
 {      
  private Elevador temp1d,temp2d;
  private int piso;
  
  public ControladorDemonio(Elevador temp1,Elevador temp2,int piso){  
	super();
	this.piso=piso;
	temp1d=temp1;
	temp2d=temp2;	
	this.setDaemon(true);
  }
  
	public void actionPerformed(ActionEvent e)
	{			
		temp1d.setDestino(piso);
		temp2d.setDestino(piso);	
	}

 }
