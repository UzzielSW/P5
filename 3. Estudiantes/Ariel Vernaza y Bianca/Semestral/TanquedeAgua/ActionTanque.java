import java.awt.event.*;
import javax.swing.*;
public class ActionTanque implements ActionListener
{
 public Idaan v,u;
 public boolean lleno,vacio;
 
 public ActionTanque(Idaan v,Idaan u)
 { 
  this.v=v;
  this.u=u;
  this.lleno=false;
  this.vacio=false;
 }
 
 public void actionPerformed(ActionEvent e)
 {
   String source =e.getActionCommand();   
    if(source=="LLENAR TANQUE")
	{	
      if(v.getArriba().getEstado() && lleno == false){
	  String nuevo=JOptionPane.showInputDialog("PERMITIR ENTRAR");	  
       try
	    {
		 v.anadirAgua(Double.parseDouble(nuevo));		
	     }catch(Desbordamiento resource)
	      {	    	
			try
			   {
				JOptionPane.showMessageDialog(null,"Se lleno el tanque 1 ^o^...Llenando al tanque dos");
				u.anadirAgua(resource.galon);
			    }catch(Desbordamiento a)
			     {
			    	JOptionPane.showMessageDialog(null,"Ambos Tanques están Llenos");
			     }
	      }		
	}else
		if(lleno)
			JOptionPane.showMessageDialog(null,"Debe vaciar los tanques");
		else
			JOptionPane.showMessageDialog(null,"Debe abrir la llave de arriba");
      v.getArriba().cierra(); 
      }
	else if(source=="VACIAR TANQUE")
	{
		
	  if(v.getAbajo().getEstado() && vacio == false)
	  {	
	   String nuevo=JOptionPane.showInputDialog("Ingrese cuantos Galones se necesitan");	  	
	 	try
	    {
		 v.quitarAgua(Double.parseDouble(nuevo));		
	     }catch(SubDesbordamiento resource)
	      {	    	
			try
			   {
				JOptionPane.showMessageDialog(null,"Se vacio el tanque 1 ^o^...Vaciando al tanque dos");
				u.quitarAgua(resource.galon);
			    }catch(SubDesbordamiento a)
			     {
			    	JOptionPane.showMessageDialog(null,"Ambos Tanque están Vacios, FUTURO CIERRE DE CALLES");
			     }
	        }      
	 
      }else
      {
    	  if(vacio==true)
    	  {
    		  JOptionPane.showMessageDialog(null,"No hay agua en los tanques");
    	  }
    	  else
    		  JOptionPane.showMessageDialog(null,"Debe abrir la llave de abajo");
      }
	  v.getAbajo().cierra();	  
     }
	else if(source=="LLAVE DE ARRIBA"){
		v.getArriba().abre();
	}
	else if(source=="LLAVE DE ABAJO"){
		v.getAbajo().abre();
	}
    }
	 
}
