import javax.swing.*;
import java.awt.Robot;
import java.awt.*;
/** Esta clase es hija de Robot se utiliza para controlar las puertas 
 * y todos sus procedimientos
 * @author Bianca Gonzalez (8-789-1920) - Ariel Vernaza (8-795-2332) */
public class puertas extends Robot
{
	/**Abierta es un boolean que representa el estado de las llaves true es abierta false es cerrada */	
 public boolean abierta;
 
 /**Construcctor inicia con las puertas cerradas*/
 public puertas() throws AWTException 
    {
 	this.abierta=false;
 	}
 
 /**Este metodo abre la puerta
  * @param temp es el boton que contiene la puerta*/
  public void abrirPuerta(JButton temp)
  {	 	 
	 this.abierta=false;
	 if(abierta){ 	 
 	}
 	else{
 	 this.abierta=true;
 	 this.delay(500);
 	 temp.setIcon(new ImageIcon("ElevadorAC1.png"));
 	 this.delay(500);
 	 temp.setIcon(new ImageIcon("Elevador.png"));
 	 this.delay(500);
 	}
 	}
  /**Este metodo cierra la puerta
   * @param temp es el boton que contiene la puerta*/
 public void cierraPuerta(JButton temp)
 {
 	if(abierta){
 	 this.abierta=false;
 	this.delay(500); 	
 	temp.setIcon(new ImageIcon("ElevadorAC1.png"));
 	this.delay(500);
 	temp.setIcon(new ImageIcon("ElevadorAC2.png"));
 	this.delay(500);
 	} 	
  } 
}