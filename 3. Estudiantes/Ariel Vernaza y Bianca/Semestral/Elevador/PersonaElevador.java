import java.awt.event.*;
import javax.swing.*;

/** Esta clase implementa ActionListener tiene todos los metodos que controlan a las personas
 * en el edificio
 * @author Bianca, Ariel
 * @version 1.0*/


public class PersonaElevador implements ActionListener
 {        
  /**dentro nos indica en que piso se encuenra la persona*/
  public int dentro;
  /**Elevador son los dos elevadores donde la persona entra*/
  public Elevador uno,dos;
  /**Persona es la persona*/
  public Persona a;
  
/**Construcctor que recibe dos elevadores y una persona
 * @param q es uno de los elavdores
 * @param j es el otro elevador
 * @param a es la prsona*/
  public PersonaElevador(Elevador q, Elevador j,Persona a)
  {  			
	this.uno=q;
	this.dos=j;			
	this.a=a;
  }
  
	public void actionPerformed(ActionEvent e)
	{			
     String event=e.getActionCommand();
     
     if(event=="IR ELEVADOR DERECHA")
     {   
    	if(this.a.piso==this.uno.getPiso()){ 
    	this.uno.control.abrirPuerta(this.uno.temp[this.uno.getPiso()]);    	    	
    	this.uno.usando=true;
    	this.dos.usando=false;
    	dentro=this.uno.hashCode();
    	}
    	else
    		JOptionPane.showMessageDialog(null,"Debes llamar al elevador");
     }
     else
    	 if(event=="IR ELEVADOR IZQUIERDA")    	 
    	 {
    		 if(this.a.piso==this.dos.getPiso()){
    		 this.dos.control.abrirPuerta(this.dos.temp[this.dos.getPiso()]);    	    	    	    	
    		 this.dos.usando=true;
    		 this.uno.usando=false;
    		 dentro=this.dos.hashCode();
    		 }
    		 else
    			 JOptionPane.showMessageDialog(null,"Debes llamar al elevador");
    	 }
	}

 }
