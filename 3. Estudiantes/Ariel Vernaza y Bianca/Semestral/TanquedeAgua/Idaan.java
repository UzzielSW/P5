import javax.swing.*;
import java.awt.*;

/** 
 * La Clase Idaan se refiere al tanque y controla todas las actividades que realiza. 
 * Tiene metodo pra controlar el llenado y vaciado del tanque, junto con su entorno 
 * grafico.
*   @author  Bianca Gonzalez (8-789-1920) - Ariel Vernaza (8-795-2332) 
*	@version 2.00
*/
public class Idaan 
{
	
 /**volumen es a cantidad de agua que se encuentra actualmente en el tanque */
 public int volumen;
 /**height se refiere a la capacidad del tanque.*/
 public int height;
 /**Llave arriba y abajo, son las llaves que permiten introducir agua y sacarle agua al tanque*/
 private Llaves arriba,abajo;  
 /**agua2 de LlenandoPrueba es la interfaz grafica q se observa sobre el tanque*/
 private LlenandoPrueba agua2;
 /**cantidad es un JButton que nos permite visualizar cuanta agua hay en el tanque*/
 private JButton cantidad;
 
 /** El constructor debe recibir como argumentos, la capacidad del tanque, el volumen deltanque
  * y la posicion y en la cual se debe empezar a dibujar...
  *@param height representa a la capacidad del tanque
  *@param volumen representa a la cantidad de agua que cotiene
  *@param y representa la posicion en el eje y en que agua2 va a dibujar el tanque */ 
 public Idaan(int height,int volumen,int y)
 { 	 	
  	arriba=new Llaves(new ImageIcon("arriba.jpg"));
  	abajo=new Llaves(new ImageIcon("abajo.jpg"));  	
  	this.volumen=volumen;  	  	
  	this.height=height;  	
  	cantidad=new JButton(Integer.toString(this.volumen)+".0");
  	cantidad.setAlignmentX(JButton.CENTER_ALIGNMENT);
  	cantidad.setEnabled(false);
  	cantidad.setForeground(Color.WHITE);
  	cantidad.setBackground(Color.BLACK);
    agua2=new LlenandoPrueba(height,volumen,y);    
    
 }
 
 /** La funcion sincronizada returna la llave que permite la entrada de agua
  *@return la llave que permite la entrada del agua*/
public synchronized Llaves getArriba()
 { 
	return (this.arriba);
 }

/** La funcion retorna el boton que contiene la imagen del tanque.
 *@param a representa el tipo de tanque que se va a dibujar. 1 principal 2 secundario
 *@return retorna la imagen del tanque dentro de un JButton*/
public synchronized JButton getTanque(int a)
{	
  return(agua2.devuelve(a));
	
}

/** El metodo retorna el JButton que posee el valor del volumen actual en el tanque.
 *@return retorna unaa vista del volumen actual*/
public synchronized JButton getVolumen()
{
 return(this.cantidad);
}

/** La funcion sincronizada returna la llave que permite la salida de agua
  *@return la llave que permite la salida del agua*/
public synchronized Llaves getAbajo()
 {
  
  return (this.abajo);
 }


        
 public synchronized void anadirAgua(double galones) throws Desbordamiento
	{	   
	   if((this.volumen + galones) >= this.height)
	    {		 		 		 
		 if(this.volumen!=this.height)
		 {
		 double a = (this.volumen + galones) - this.height;
		 double c=galones-a;
		 agua2.setCondicion(1,(int)c);
		 this.volumen+=c;
		 this.cantidad.setText(Double.toString(this.volumen));
		 throw new Desbordamiento(a);	//llama a la ecepcion
		 }
		 else{
		  throw new Desbordamiento(galones);
		  }
		}
		else
		{
		 this.volumen += galones;		 
		 agua2.setCondicion(1,(int)galones);
		 this.cantidad.setText(Double.toString(this.volumen));
		}
			  
	}

    public synchronized void quitarAgua(double galones) throws SubDesbordamiento
	{	   
	    if((this.volumen - galones) > 0)
		{		
		volumen -= galones;		
		agua2.setCondicion(2,(int)galones);
		this.cantidad.setText(Double.toString(this.volumen));
		}		
		else 
		{		 		 
		double b = galones - this.volumen;				
		volumen = 0;
		agua2.setCondicion(2,(int)(galones-b));
		this.cantidad.setText(Double.toString(this.volumen));
		throw new SubDesbordamiento(b);		
		}	  
	}
	
					    	     
}