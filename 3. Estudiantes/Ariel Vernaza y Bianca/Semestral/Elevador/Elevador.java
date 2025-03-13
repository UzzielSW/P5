import javax.swing.*;
import java.awt.*;
import java.awt.Robot;
import java.awt.event.*;

/**
 * <p>FIEC</p><p>Escuela de Informática</p>
 * <p>Crea e implementa un sistema de Elevador. Posee funciones que le permite al elevador recorrer los pisos.
 * <p>
 * <strong>Cuidado:</strong>
 * Al Instancias la clase elevador se debe manejar la execption provocada por el constructor de Robot, una AWTExcecption.
 * @version 2.0 10/12/2006
 * @author Bianca Gonzalez  8-789-1920
 * @author Ariel Vernaza    8-795-2332
 */

public class Elevador extends Robot implements Runnable, ActionListener{
	
public puertas control;//Puerta que se Encuentran en el elevador
private int piso_a; //Piso en el que se encuentra actualmente el elevador
public boolean subiendo,usando;//Estado del elevador true para subiendo, false para bajando
public JButton[] temp;//botones que crean al elevador
private int destino;
public boolean activo;
public Panel primero,segundo,plantabaja;
private Thread hilo1,hilo2,hilo3;
public double peso;

public Elevador(String piso) throws AWTException 
{
 //Constructor que Recibe una indicacion en String.	
 this(0);//le Asigna el valor de numerico de la planta baja
}


public Elevador(int piso) throws AWTException  
{
  super();//Convoca al constructor de Robot
  peso=20.00;
  this.activo=false;
  this.usando=false;
  control=new puertas();  //Instancia las puertas del elevador
  temp=new JButton[7];//prepara el arreglo de botones
  temp[6]=new JButton(new ImageIcon("PisoGeneral.png"));//El fondo del edificio emulado
  temp[6].setBackground(Color.DARK_GRAY);
  temp[6].setBorderPainted(false);
  this.destino=0;
  this.plantabaja=new Panel(0,this);
  hilo1=new Thread(this.plantabaja);
  temp[0]=new JButton(new ImageIcon("ElevadorAC2.png"));//El fondo del edificio emulado
  temp[0].setBackground(Color.lightGray);
  temp[0].addActionListener(this);
  primero=new Panel(1,this);
  hilo2=new Thread(primero);
  temp[1]=new JButton(new ImageIcon("ElevadorAC2.png"));//Piso1
  temp[1].setBackground(Color.lightGray);
  temp[1].addActionListener(this);
  segundo=new Panel(2,this);
  hilo3=new Thread(segundo);
  temp[2]=new JButton(new ImageIcon("ElevadorAC2.png"));//PISO2
  temp[2].setBackground(Color.lightGray);
  temp[2].addActionListener(this);
  this.setDisbale();  
  for(int i=3;i<temp.length-1;i++)
  {
	if(piso==0)
	  temp[i]=new JButton("PB");//SEÑALADOR DE PISO	
	else
	temp[i]=new JButton(Integer.toString(piso));//SEÑALADOR DE PISO
	temp[i].setBackground(Color.BLACK);
    temp[i].setForeground(Color.RED);
		
  }    
  this.piso_a=piso;
  temp[piso].setEnabled(true);
  subiendo=true;
 }	
 
 public int getPiso()
 {
  return this.piso_a;
 }
 
 public void setDestino(int a)
 {	 	 
	 this.destino=a;
 }
 
 
 public void actionPerformed(ActionEvent e)
 {
  JButton temp=(JButton)e.getSource();  
  if(temp.hashCode()==this.temp[0].hashCode())
  {
	if(this.usando)
	  this.plantabaja.openWindows();	 	 	 
  }
  else if(temp.hashCode()==this.temp[1].hashCode())
  {	  
	  if(this.usando)
	  this.primero.openWindows();
  }
  else if(temp.hashCode()==this.temp[2].hashCode())
  {
	  if(this.usando)
	  this.segundo.openWindows();  	  
  }
   
 }
 
 public void run()
 {	
	   this.hilo1.start();	
	   this.hilo2.start();
	   this.hilo3.start();
	  	  	   
   if(this.activo==false)	   
	 while(true)
	 {
	  this.delay(500);
	  if(this.peso<=50.00) 
	     this.irAlPiso(this.destino);
	  else
		  JOptionPane.showMessageDialog(null,"Demasiadas personas en el elevador");
	  this.delay(1000);	  
	 }	 
  /*    
  while(true)
  {
   this.delay(500);
   int a=(int) (Math.random()*3);   
   switch(a){
             case 1:
            	   this.irAlPiso(0);            	  
            	   break;
             case 2:            	 
          	        this.irAlPiso(1);
             case 3:            
          	       this.irAlPiso(2);
          	        break;
          	}
    this.delay(1000);
  }*/
 }
 
 
 public JButton prepararElevador()
 {    
  temp[6].setLayout(new GridLayout(3,2));
  temp[2].setLayout(new BorderLayout());
  temp[2].add(temp[5],BorderLayout.NORTH);  
  temp[6].add(new JButton().add(temp[2]));  
  temp[1].setLayout(new BorderLayout());  
  temp[1].add(temp[4],BorderLayout.NORTH);  
  temp[6].add(new JButton().add(temp[1]));    
  temp[0].setLayout(new BorderLayout());
  temp[0].add(temp[3],BorderLayout.NORTH);  
  temp[6].add(new JButton().add(temp[0]));      
  return temp[6];
 }
 
 
 public void setDisbale()
 {	 
  temp[0].setEnabled(false); 
  temp[1].setEnabled(false);
  temp[2].setEnabled(false);
 }
 
 public void subirAlPiso(int a)
 {  		 
   int i=0;   
   if(a!=this.piso_a)
   {	  	   	   	
   	for(i=this.piso_a;i<a;i++)
   	 {   		
   		this.control.cierraPuerta(temp[this.piso_a]);   	
   	  this.delay(500);
   	  this.setDisbale();   	  
   	  this.temp[i+1].setEnabled(true);   	     	  
   	  if((i+1)!=0)
   	  {
   		this.temp[3].setText(Integer.toString(i+1));
   		this.temp[4].setText(Integer.toString(i+1));
   		this.temp[5].setText(Integer.toString(i+1));   		
   	  }
   	  else{
   		this.temp[3].setText("PB");
   		this.temp[4].setText("PB");
   		this.temp[5].setText("PB");  
   	   }   	  
   	   this.plantabaja.setPiso(i+1);
	   this.primero.setPiso(i+1);
	   this.segundo.setPiso(i+1);
   	  }
   	
   	this.piso_a=i;  
   	this.control.abrirPuerta(temp[piso_a]);   	
   	this.delay(2500);
   	this.control.cierraPuerta(temp[piso_a]);  
   	} 	
 }
 
 public void bajarAlPiso(int a)
 {   
   int i=0;
  if(a!=this.piso_a)
  {   
    for(i=this.piso_a;i>a;i--)
    {
      this.control.cierraPuerta(temp[this.piso_a]);
      this.delay(500);	
      this.setDisbale();
	  this.temp[i-1].setEnabled(true);		
      if((i-1)!=0)
      {
	    this.temp[3].setText(Integer.toString(i-1));
		this.temp[4].setText(Integer.toString(i-1));
		this.temp[5].setText(Integer.toString(i-1));		
	   }
	   else{
		this.temp[3].setText("PB");
		this.temp[4].setText("PB");
		this.temp[5].setText("PB");  
		}		  	  
      this.plantabaja.setPiso(i-1);
 	   this.primero.setPiso(i-1);
 	   this.segundo.setPiso(i-1);
	  }
	  this.piso_a=i;  
	  this.control.abrirPuerta(this.temp[piso_a]);   	
	  this.delay(2500);
	  this.control.cierraPuerta(this.temp[piso_a]);  
    }		 	
} 
 
 
 public void irAlPiso(int a)
 {	  	  	 
      if(this.piso_a> a)
      {  
    	  this.activo=true;
  	    this.bajarAlPiso(a);  	
  	    this.subiendo=false;   	
      }
      else if(this.piso_a < a)
     {   	  
    	  this.activo=true;
    	System.out.println("Entro al else de ir al piso");
  	   this.subirAlPiso(a);  	   
  	   this.subiendo=true;
      }
      else
    	  this.activo=false;
 }		
  
}