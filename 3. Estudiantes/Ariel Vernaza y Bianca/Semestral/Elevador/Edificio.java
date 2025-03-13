import javax.swing.*;
import java.awt.*;

 public class Edificio implements Runnable{
 public JLabel piso1,piso2,piso3,mitad1,mitad2,mitad3; 
 public Elevador uno,dos;
 public JLabel rotulos1,rotulos2,rotulos3;
 public Thread hiloEl1,hiloEle2; 
 public JButton[] control,botonarriba,botonabajo,derecha,izquierda;
 public Persona todo1,todo2,todo3; 
 public Thread thread1,thread2,thread3,thread4,thread5;
 public ControladorDemonio pisoa,pisob,pisoc;
 public PersonaElevador a;
 
 public Edificio()
 {	 	 
  try{  
  uno=new Elevador("PB");
  uno.delay(30);
  dos=new Elevador("PB");
  todo1=new Persona(0,uno,dos);
  todo2=new Persona(0,uno,dos);
  todo3=new Persona(0,uno,dos);  
   a=new PersonaElevador(uno,dos,todo1);   
  }catch(AWTException e){}
  thread1 =new Thread(uno);
  thread2 =new Thread(dos);	 	
  thread3 =new Thread(this.todo1);
  thread4 =new Thread(this.todo2);
  thread5 =new Thread(this.todo3);
  
  this.control= new JButton[3];
  this.botonabajo=new JButton[3];
  this.botonarriba=new JButton[3];
  
  //arriba
  control[0]=new JButton();
  control[0].setLayout(new BorderLayout());
  botonabajo[0]=new JButton(new ImageIcon("botonabajo.gif"));	  
  pisoa=new ControladorDemonio(uno,dos,2);
  botonabajo[0].addActionListener(pisoa);
  this.control[0].add(botonabajo[0],BorderLayout.CENTER);
  
  //medio
  control[1]=new JButton();
  control[1].setLayout(new BorderLayout());
  botonarriba[1]=new JButton(new ImageIcon("botonarriba.gif"));
  botonabajo[1]=new JButton(new ImageIcon("botonabajo.gif"));
  pisob=new ControladorDemonio(uno,dos,1);
  botonarriba[1].addActionListener(pisob);
  botonabajo[1].addActionListener(pisob);
  this.control[1].add(botonabajo[1],BorderLayout.SOUTH);
  this.control[1].add(botonarriba[1],BorderLayout.NORTH);
  
  //abajo
  control[2]=new JButton();
  control[2].setLayout(new BorderLayout());  
  botonarriba[2]=new JButton(new ImageIcon("botonarriba.gif"));
  pisoc=new ControladorDemonio(uno,dos,0);
  botonarriba[2].addActionListener(pisoc);
  this.control[2].add(botonarriba[2],BorderLayout.CENTER);
  
  //otras cosas   
  piso1=new JLabel();
  mitad1=new JLabel();
  mitad2=new JLabel();
  mitad3=new JLabel();  
  piso1.setBackground(Color.CYAN);
  piso2=new JLabel();
  piso3=new JLabel();
  
  rotulos1=new JLabel("PB",JLabel.CENTER);  
  rotulos1.setBackground(Color.BLACK);
  rotulos1.setForeground(Color.WHITE);
  
  rotulos2=new JLabel("1",JLabel.CENTER);
  rotulos2.setBackground(Color.BLACK);
  rotulos2.setForeground(Color.WHITE);
  
  rotulos3=new JLabel("2",JLabel.CENTER);
  rotulos3.setBackground(Color.BLACK);
  rotulos3.setForeground(Color.WHITE);
  this.derecha=new JButton[3];
  this.izquierda=new JButton[3];
  for(int i=0; i < 3;i++)
  {
	this.derecha[i]=new JButton("IR ELEVADOR DERECHA");
	this.derecha[i].addActionListener(this.a);
	this.izquierda[i]=new JButton("IR ELEVADOR IZQUIERDA");
	this.izquierda[i].addActionListener(this.a);
  }
  this.setDisable();
  this.setEnable(uno.getPiso());
 }
 
 public void setDisable()
 {	 
	 mitad1.setVisible(false);	 
	 mitad2.setVisible(false);
	 mitad3.setVisible(false);
	 
	 for(int i=0; i < 3;i++)
	  {
		this.derecha[i].setVisible(false);	
		this.izquierda[i].setVisible(false);	
	  }	
 }
 
 
 
 public void setEnable(int piso)
 {
	switch(piso+1)
	{
	           case 3:
	        	    mitad1.setVisible(true);	        	    
	        	   this.derecha[0].setVisible(true);	
	       		   this.izquierda[0].setVisible(true);	       		   
	        	   break;
	           case 2:
	        	   mitad2.setVisible(true);
	        	   this.derecha[1].setVisible(true);	
	       		   this.izquierda[1].setVisible(true);
	        	   break;
	           case 1:
	        	   mitad3.setVisible(true);
	        	   this.derecha[2].setVisible(true);	
	       		   this.izquierda[2].setVisible(true);
	        	   break;
	}
	this.todo1.setPiso(piso);
	this.todo2.setPiso(piso);
	this.todo3.setPiso(piso);
 }
 
 
 public void run()
 {	 	 
	 while(true){
	   if(!this.thread1.isAlive()){   	
			  JFrame ventanas=new JFrame("EDIFICIO");  
			  JLayeredPane fondo=new JLayeredPane();
			  JLayeredPane imagen=new JLayeredPane();	  
			  Container windowspane=ventanas.getContentPane();	  
			  
			  fondo.setLayout(new GridLayout(1,5));  
			  JPanel v=new JPanel();
			  
			  v.setLayout(new GridLayout(3,1));
			  JLabel paraPiso1=new JLabel(new ImageIcon("Piso.png"));
			  JLabel paraPiso2=new JLabel(new ImageIcon("Piso.png"));
			  JLabel paraPiso3=new JLabel(new ImageIcon("Piso.png"));
			  
			  paraPiso1.setLayout(new GridLayout(2,1));
			  paraPiso2.setLayout(new GridLayout(2,1));
			  paraPiso3.setLayout(new GridLayout(2,1));
			  
			  piso1.setLayout(new GridLayout(1,5));
			  piso1.add(this.derecha[0]);
			  piso1.add(this.rotulos3);	  	  	  
			  piso1.add(this.control[0]);
			  piso1.add(new JLabel());
			  piso1.add(this.izquierda[0]);;  	   
			  paraPiso1.add(piso1);
			  mitad1.add(todo1.getImage());
			  paraPiso1.add(mitad1);  	  
			  v.add(paraPiso1);
			 
			  piso2.setLayout(new GridLayout(1,5));
			  piso2.add(this.derecha[1]);
			  piso2.add(this.rotulos2);	  	  	  
			  piso2.add(this.control[1]);
			  piso2.add(new JLabel());
			  piso2.add(this.izquierda[1]);;  	   
			  paraPiso2.add(piso2);
			  mitad2.add(todo2.getImage());
			  paraPiso2.add(mitad2);
			  
			  v.add(paraPiso2); 
			 
			  piso3.setLayout(new GridLayout(1,5));
			  piso3.add(this.derecha[2]);
			  piso3.add(this.rotulos1);	  	  	  
			  piso3.add(this.control[2]);
			  piso3.add(new JLabel());
			  piso3.add(this.izquierda[2]);;  	   
			  paraPiso3.add(piso3);
			  mitad3.add(todo3.getImage());
			  paraPiso3.add(mitad3);
			  
			  v.add(paraPiso3);
			  
			 JButton c=uno.prepararElevador();
			 JButton b=dos.prepararElevador();	  
			 fondo.add(c,BorderLayout.EAST);
			 fondo.add(v,BorderLayout.CENTER); 
			 fondo.add(b,BorderLayout.WEST);
			 JLayeredPane.putLayer(fondo,0);
			 JLayeredPane.putLayer(imagen,1);
			 windowspane.add(fondo);
			 ventanas.setVisible(true);
			 ventanas.setSize(1100,650); 
			 ventanas.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			 
	thread1.start();	 	 	 
    thread2.start();    
	thread3.start();	 
	thread4.start();
	thread5.start();
	}else		
	{
		if(this.uno.usando||this.dos.usando)
		{
		 this.setDisable();         		 
		}
		else
		{			
			if(this.a.dentro==this.uno.hashCode())
			{
			  this.setDisable();	
			  this.setEnable(this.uno.getPiso());
			  this.a.dentro=0;
			 }
			else if(this.a.dentro==this.dos.hashCode())
			{
			   this.setDisable();
			   this.setEnable(this.dos.getPiso());
			   this.a.dentro=0;
		    }
			    
		}
							
	}
		
 			 
   }
	
 }
 
 
 
 
 public static void main(String arg[])
 {
  Edificio Temp=new Edificio();
  Thread nuevo=new Thread(Temp);  
  nuevo.start();
 }  
}
