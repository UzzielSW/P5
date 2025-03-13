package view;

import events.*;
import runnables.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**Clase encargada de crear la interfaz gráfica del cajero.*/
public class Cashier extends JPanel{
	
	 private JPanel pPrincipal;
	 private JPanel pPantalla;
	 private JPanel pTeclado;
	 
	 private JButton bInsertaTarjeta;
	
	 private JPasswordField jContrasenia;
 
	 //subpaneles del panel del teclado
	 private JPanel pCenterTeclado;
         private JPanel pEastTeclado;
         private JPanel pWestTeclado;
         private JPanel pNorthTeclado;
         private JPanel pSouthTeclado; 
     
        //botones del teclado
         private JButton botones[];	
     
	 
	 
	 //subpaneles principales de la pantalla
	 private JPanel pEastPantalla;
         private JPanel pCenterPantalla;
         private JPanel pWestPantalla;
     
        //Botones de la pantalla 
    
	 private JButton bPrimeroOeste;
	 private JButton bSegundoOeste;
	 private JButton bTerceroOeste;
	 private JButton bCuartoOeste;
	 
	 private JButton bPrimeroEste;
	 private JButton bSegundoEste;
	 private JButton bTerceroEste;
	 private JButton bCuartoEste;
	 
	 //Paneles dentro del panel del este de la pantalla
         private JPanel pNorthIntoEastPantalla ;
         private JPanel pCenterIntoEastPantalla ; 
         private JPanel pSouthIntoEastPantalla ;
      	
      	
         //Paneles dentro del del oeste de la pantalla
         private JPanel pNorthIntoWestPantalla ;
         private JPanel pCenterIntoWestPantalla ; 
         private JPanel pSouthIntoWestPantalla ;
     
     	 
        //Label que nos muestra las imagenes de la pantalla del cajero
	 private JLabel showImage ;
	 
         /**El parametro nombreCajero almacena el del cajero.*/
         public String nombreCajero;
         
         /**El parametro manejador hara una instancia de la clase CashierListener.*/
         public CashierListener manejador;
         
         /**El parametro bank hara referencia al objeto Bank creado en la clase SimulacionCajero.*/
	 public Bank bank;
         
         /**Crea un nuevo Cashier.
         @param bank Objeto Bank .
         @param nombreCajero Nombre del Cashier.*/
	 public Cashier(Bank bank, String nombreCajero){
		
		this.bank=bank;
		this.nombreCajero=nombreCajero;
		
		pPrincipal = new JPanel(new BorderLayout());
	
		showImage = new JLabel();
		
	
		addPantalla();
		addTeclado();

		
	 	//principal.add(centro, BorderLayout.CENTER);
	 	this.setBackground(new java.awt.Color(0, 0, 0));
	 	this.add(pPrincipal);
	 	
	 
	 	//Escucha del cajero
	 	
	 	manejador= new  CashierListener(bPrimeroOeste,bSegundoOeste,bTerceroOeste,bCuartoOeste,
		bPrimeroEste,bSegundoEste,bTerceroEste,bCuartoEste,jContrasenia,bInsertaTarjeta,
		showImage, bank, nombreCajero,pCenterPantalla,pPantalla);
	 	
	 	bInsertaTarjeta.addActionListener(manejador);
	 	
	 
	 	for(int i =0;i<16;i++){
      		
      		botones[i].addActionListener(manejador);
        
      	}
      	
      	bPrimeroOeste.addActionListener(manejador);
      	bSegundoOeste.addActionListener(manejador);
      	bTerceroOeste.addActionListener(manejador);
      	bCuartoOeste.addActionListener(manejador);
      	
      	bPrimeroEste.addActionListener(manejador);
      	bSegundoEste.addActionListener(manejador);
      	bTerceroEste.addActionListener(manejador);
      	bCuartoEste.addActionListener(manejador);
      	
      	
	 
	 	
      }
      
      /**Método que adiciona todos los componentes de la 
       pantalla del Cashier.*/
      public void addPantalla(){
      	
      	pPantalla= new JPanel(new BorderLayout());
      	pEastPantalla= new JPanel(new BorderLayout());
      	pCenterPantalla= new JPanel(new BorderLayout());
      	pWestPantalla= new JPanel(new BorderLayout());
      	
      
      
      	//Paneles dentro del panel del este de la pantalla
      	JPanel pNorthIntoEastPantalla = new JPanel();
      	JPanel pCenterIntoEastPantalla = new JPanel(new GridLayout(4,1,3,3)); 
      	JPanel pSouthIntoEastPantalla = new JPanel();
      	
      	
      	//Paneles dentro del del oeste de la pantalla
      	JPanel pNorthIntoWestPantalla = new JPanel();
      	JPanel pCenterIntoWestPantalla = new JPanel(new GridLayout(4,1,3,3)); 
      	JPanel pSouthIntoWestPantalla = new JPanel();
      	
      	
      	//Botones que estan a la derecha del cajero      	
      	bPrimeroEste=new JButton("<<");
      	bSegundoEste=new JButton("<<");
      	bTerceroEste=new JButton("<<");
      	bCuartoEste=new JButton("<<");	
      	
      	pCenterIntoEastPantalla.add(bPrimeroEste);
      	pCenterIntoEastPantalla.add(bSegundoEste);
      	pCenterIntoEastPantalla.add(bTerceroEste);
      	pCenterIntoEastPantalla.add(bCuartoEste);
      	
      	//Botones que estan a la izquierda del cajero
      	bPrimeroOeste=new JButton(">>");
      	bSegundoOeste=new JButton(">>");
      	bTerceroOeste=new JButton(">>");
      	bCuartoOeste=new JButton(">>");	
      	
      	pCenterIntoWestPantalla.add(bPrimeroOeste);
      	pCenterIntoWestPantalla.add(bSegundoOeste);
      	pCenterIntoWestPantalla.add(bTerceroOeste);
      	pCenterIntoWestPantalla.add(bCuartoOeste);
      	
      	    	
      
      	//Organizando el panel del este 
      
      	pEastPantalla.add(pNorthIntoEastPantalla,BorderLayout.NORTH);
      	pEastPantalla.add(pCenterIntoEastPantalla,BorderLayout.CENTER);
      	pEastPantalla.add(pSouthIntoEastPantalla,BorderLayout.SOUTH);
      	
      
      	
      	//Organizando el panel del oeste
      	pWestPantalla.add(pNorthIntoWestPantalla,BorderLayout.NORTH);
      	pWestPantalla.add(pCenterIntoWestPantalla,BorderLayout.CENTER);
      	pWestPantalla.add(pSouthIntoWestPantalla,BorderLayout.SOUTH);
      	
      	
      	//Nos muestra la contarseña
      	jContrasenia=new JPasswordField();
      	jContrasenia.setEditable(false);
      	jContrasenia.setHorizontalAlignment(JTextField.CENTER);
      	
      	
      	//Primera imagen que muestra la pantalla del cejero
     	showImage.setIcon(new javax.swing.ImageIcon("Images\\image1.jpg"));
     	
     	
      	
      	//Organizando el panel del centro
      	pCenterPantalla.add(showImage,BorderLayout.CENTER);
      	pCenterPantalla.add(jContrasenia,BorderLayout.SOUTH);
      	
      	//Organizando el panel de la pantalla
      	pPantalla.add(pEastPantalla, BorderLayout.EAST);
      	pPantalla.add(pWestPantalla, BorderLayout.WEST);
      	pPantalla.add(pCenterPantalla, BorderLayout.CENTER);
      	
      	
      	//adicionando la pantalla al panel principal
      	pPrincipal.add(pPantalla,BorderLayout.NORTH);
      	
      	 	
      }
      
 
      /**Método que adiciona el teclado a Cashier.*/
      public void addTeclado(){//metodo para adicionar los componentes del teclado del cajero
      	
      	String cadenas[] ={"1","2","3","Borrar","4","5","6","Cancelar","7","8","9","Anotación","0","","",""};
      	
      	botones = new JButton[16];
      	bInsertaTarjeta = new JButton("Insertar Tarjeta");
      	
      	
      
      	pCenterTeclado = new JPanel(new GridLayout(4,4,3,3));
      	pEastTeclado = new JPanel();
      	pWestTeclado = new JPanel();
      	pWestTeclado = new JPanel();
      	pSouthTeclado = new JPanel(); 
      	
      	
      	pTeclado = new JPanel(new BorderLayout());
      	
      	pEastTeclado.setBackground(new java.awt.Color(0, 0, 0));
      	pWestTeclado.setBackground(new java.awt.Color(0, 0, 0));
      	pWestTeclado.setBackground(new java.awt.Color(0, 0, 0));
      	pSouthTeclado.setBackground(new java.awt.Color(0, 0, 0));
      	
      	pSouthTeclado.add(bInsertaTarjeta, BorderLayout.CENTER);
      	
      	
      	for(int i =0;i<16;i++){
      		
      		botones[i]=new JButton(cadenas[i]);
      		pCenterTeclado.add(botones[i]);
      		botones[i].setFont(new java.awt.Font("Arial", 0, 14));
      		botones[i].setMaximumSize(new Dimension(4,4));
      		
        
      		
      	}
      	
      	botones[3].setForeground(new java.awt.Color(204, 0, 51));
      	botones[7].setForeground(new java.awt.Color(255, 150, 51));
      	botones[11].setForeground(new java.awt.Color(51, 102, 0));
      	
      	
      	pTeclado.add(pWestTeclado,BorderLayout.NORTH);
      	pTeclado.add(pCenterTeclado,BorderLayout.CENTER);
      	pTeclado.add(pSouthTeclado,BorderLayout.SOUTH);
      	pTeclado.add(pWestTeclado,BorderLayout.WEST);
      	pTeclado.add(pEastTeclado,BorderLayout.EAST);
      	
      
      	pPrincipal.add(pTeclado,BorderLayout.SOUTH);
      	
      }
      
      
      /**Método que retorna un objeto PantallaRunnable.
       @return pantallaRunnable Thread de la pantalla del cajero.*/
      public PantallaRunnable getPantallaRunnable(){
		
            return manejador.getPantallaRunnable();
		
      }
		
     /**Método que retorna el JLabel de la pantalla del cajero.
      @return showImage JLabel que muestra los mensajes en la pantalla del cajero.*/
       public JLabel getImage(){
			
		return  showImage;
       }
	
}