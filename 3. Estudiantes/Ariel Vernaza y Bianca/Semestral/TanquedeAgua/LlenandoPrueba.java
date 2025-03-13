import javax.swing.*;
import java.awt.*;

/** 
 *  La Clase LlenandoPrueba 
*   @author  Ariel Vernaza (8-795-2332) 
*	@version 10.9
*/

public class LlenandoPrueba extends JComponent implements Runnable
{
 /** este es el rectangulo que aparece en pantalla*/
 public Rectangle este; 
 /** llenando comienzo e y son enteros que se refieren */ 
 public int llenando,comienzo,y; 
 /** fin y finInv son las variables de dibujo del rectangulo*/
 private volatile int fin,finInv; 
 /** MAX_DELAY es el tiempo maximo de delay que es permitido. 60000 representa
  *un minuto*/
 private static final int MAX_DELAY = 60000;
 
 /** El construtor recibe la capacidad, el volumen actual y la posicion de pintado
  *@param fin representa la capacidad del tanque, que tan grande va a ser.
  *@param inicio representa, el volumen que se va a dibujar en un principio.
  *@param y reprsenta la posicion de pintado del dibujo 
  **/
 public LlenandoPrueba(int fin,int inicio,int y)
 {
   super();      
   llenando=0;       
   this.y=y;
   comienzo=0;   
   this.finInv=fin;   
   this.fin=fin-inicio;
   this.setBounds(20,20,100,this.finInv);
   este=new Rectangle(100,fin);   
   Thread evento=new Thread(this);
   evento.setDaemon(true);
   evento.start();   
 }

/** La funcion setCondicion permite que mientras el demonio corre se puedan setear los valores
 *del tanque, y que estos cambien de forma automatica
 *@param i reprsenta la condicion de estar llenando en 1 y vaciando en 2, en 0 no hace nada
 *@param comienzo indica el nuevo volumen que r*/
 public synchronized void setCondicion(int i,int comienzo)
 {
  llenando=i;	 
  this.comienzo=comienzo;
 }
 
 /**es la implementacion para correr el demonio */
 public void run()
 {	
 while(true)	 
  switch(llenando)
  {
     case 1:
    	    aumentar(this.comienzo);    	        	    
    	    setCondicion(0,0);    	  
    	    break;
     case 2:	    
            disminuir(this.comienzo);    	        	    
	        setCondicion(0,0);    	  
	        break;
  }	 
 }
/** Es la implementacion que permite el pintado del tanque
 * @param g es la grafica que va a ser pintada*/  
public void paint(Graphics g)
 { 	 	
	g.setColor(Color.blue);  
	g.fill3DRect(63,y,100,this.finInv,true);
	g.setColor(Color.gray);
	g.fill3DRect(63,y,100,this.fin,false);//este es el rectangulo de la salvacion
	
}

 /** permite obtener la imagen del elevador dependiendo del valor numerico
  * @param a representa el tipo de elevador
  * @return un JButton con la figura del tanque correspondiente*/
public synchronized JButton devuelve(int a)
 {
	JButton j;	
	if(a==1){
	j=new JButton(new ImageIcon("tanque2d1.PNG"));
	}
	else{
	j=new JButton(new ImageIcon("tanque2d2.png"));
	 }	
	j.setBorderPainted(false);	
	j.add(this);
	return(j);
	
 }
/** hace la funcion de llenado de tanque
 * @param comiezo dice hasta donde se llenara el tanque*/

 public synchronized void aumentar(int comienzo)
 {  	 	  
  int a = this.fin-comienzo;
  while(this.fin>a){   
     this.fin--;
     this.repaint();   
     this.delay(30);
   }  
   this.fin=a;   
 }
 
 /** hace la funcion de vaciado del tanque
  * @param comiezo dice hasta donde se vaciara el tanque*/ 
 public synchronized void disminuir(int comienzo)
 { 
	int a=comienzo+this.fin;
   while(this.fin<a){         	 
     this.fin++;
     this.repaint();   
     this.delay(30);
   }   
   this.fin=a;
 }

 /** permite pausar la ejecucion durante un periodo de tiempo
  * @param ms es el tiempo en milisegundo en que se detendra la ejecucion*/
public synchronized void delay(int ms) {
	checkDelayArgument(ms);
	try {
	    Thread.sleep(ms);
	} catch(InterruptedException ite) {
	    ite.printStackTrace();
	}
    }
/** observa si el delay no supera el tiempo maximo de delay
 * @param ms es el tiempo en milisegundo en que se detendra la ejecucion*/
private void checkDelayArgument(int ms) {
	if (ms < 0 || ms > MAX_DELAY) {
	    throw new IllegalArgumentException("Delay must be to 0 to 60,000ms");
	}
   }
}
