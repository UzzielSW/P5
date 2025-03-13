import javax.swing.*;
import java.awt.*;
import java.awt.Robot;
/** Esta clase es la definicion de la persona
 * @author Bianca, Ariel
 * @version 1.1*/

public class Persona extends Robot implements Runnable
{
 /** figura es un Jlabel que tiene la imagen de la persona */
 private JLabel figura;
 /**son variables enteras que permiten conocer a la persona */
 public int x,y,hashcode,piso; 
 /**es el valor numerico que representa el peso de la persona*/
 public double peso;
 /**Son las opciones de elevadores que posee la persona*/
 public Elevador uno,dos; 
 
 /** El constructor de persona recibe un hashcode del elevador y dos elevadores.
  * @param hashcode es el codigo uno de los elevadores
  * @param a es el elevador de la derecha
  * @param b es el elevador de la izquierda
  * @exception el lanza un AWTException*/
 public Persona(int hashcode, Elevador a, Elevador b)throws AWTException
 {	
	super();	
	figura=new JLabel(new ImageIcon("ccsakura07.gif"));
	setPiso(0);
	uno=a;
	dos=b;
	//figura.setBorderPainted(false);
	//figura.setBackground(Color.GRAY);
	this.x=150;
	this.y=54;
	figura.setBounds(x,y,45,48);
	this.peso=2.00;	
	this.hashcode=hashcode;
 }
 
 /**Ete metodo pregunta si el hash code es igual y de tiene el elevador
  * @param a es un entero que representa el hash code del elevador 
  */
 public void compara(int a)
 {
  if((uno.getPiso()==this.piso || dos.getPiso()==this.piso)&&(hashcode!=a)){
	  this.hashcode=a; 		 
    } 
 }
 
 /**run es una implementacion*/
 public void run()
 {
	 	  
    while(true){
    this.delay(200);
    this.x-=10;    
    if(x<=0){    
    break;
    	}
    }
    
 }
  
 /**setPiso setea el piso en el que se encuentra
  * @param a es el numero del piso*/
 public void setPiso(int a)
 {
	 this.piso=a;
 }
 
 /**getImage Devuelve la imagen*/
 public JLabel getImage(){
	 return this.figura;
 }

}
