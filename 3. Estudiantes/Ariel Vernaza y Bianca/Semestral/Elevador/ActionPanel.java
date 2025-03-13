import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class ActionPanel implements ActionListener
{   
 private Elevador Controlado;
 private String a; 

  
 public ActionPanel(Elevador a)
 {	 	 
	Controlado=a;           	
 } 
 
 public void actionPerformed(ActionEvent e)
 { 
   
  JButton b=(JButton)e.getSource();  
   a= b.getActionCommand();      
   if(a=="SALIR"){	   
	   this.Controlado.usando=false;
	   this.Controlado.activo=true;	   	   			   
	 this.Controlado.plantabaja.ventana.setVisible(false);
     this.Controlado.primero.ventana.setVisible(false);
	 this.Controlado.segundo.ventana.setVisible(false);			 		   
	  } 
   else if(a=="ABRIR"){   
	  b.setBackground(Color.BLUE);
      this.Controlado.control.abrirPuerta(this.Controlado.temp[this.Controlado.getPiso()]);
      b.setBackground(Color.ORANGE);
  }  
  else if(a=="CERRAR")
  {     	    
	  b.setBackground(Color.BLUE);	  	  
      this.Controlado.control.cierraPuerta(this.Controlado.temp[this.Controlado.getPiso()]);
      b.setBackground(Color.ORANGE);
  }
  else if(a=="HELP"){	  
       b.setBackground(Color.RED);       
       JOptionPane.showMessageDialog(null,"AUXILIO ELEVADOR","PROBLEMAS",JOptionPane.ERROR_MESSAGE);
       b.setBackground(Color.ORANGE);
       }
  else if(a=="PB"){	  
       b.setBackground(Color.BLUE);    
       this.Controlado.setDestino(0);
    }
  else if((Integer.parseInt(a)>0) && (Integer.parseInt(a)<3)){
    	this.Controlado.setDestino(Integer.parseInt(this.a));//orden abrir
        b.setBackground(Color.ORANGE);
        }
  else{
	  this.Controlado.setDestino(this.Controlado.getPiso());
  }
	  
  }
}