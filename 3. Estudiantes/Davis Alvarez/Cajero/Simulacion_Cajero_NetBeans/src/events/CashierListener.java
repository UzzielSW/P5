package events;

import media.*;
import view.*;
import runnables.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.applet.*;


/**
 * Esta clase es la encargada de manejar los eventos de los componentes de  la interfaz gráfica del 
 * cajero de la clase Cahier.
 */
   public class CashierListener implements ActionListener{
	
	
	 private JButton bInsertaTarjeta;
	 private JPasswordField jContrasenia;
	 
         
	 //Botones del oeste de la pantalla del cajero
	 private JButton bPrimeroOeste;
	 private JButton bSegundoOeste;
	 private JButton bTerceroOeste;
	 private JButton bCuartoOeste;
	 
	 //Botones del este de la pantalla del 
	 private JButton bPrimeroEste;
	 private JButton bSegundoEste;
	 private JButton bTerceroEste;
	 private JButton bCuartoEste;
	 
	 
	 //Panel de la pantalla del cajero
	 private JPanel pPantalla;
	 //Subpanel de la pantalla del cajero
	 private JPanel pCenterPantalla;
         
	 private JTextArea jArea ;
	 
	 //Nos muestra las imagenes de la pantalla
	 private JLabel showImage ;
	 
	 
	 //clip de audio
	 private AudioClip button1Clip;
	 private AudioClip button2Clip;
	 
	 //nombre de los archivvos de audio a reproducir
	 private static final String button1Sound = "button.wav";
	 private static final String button2Sound = "notify.wav";
	 
	 
         
	 /**El campo tMensajeRunnable muestra un mensaje cuando no hay una cuenta registrada.*/
	 public MensajeRunnable tMensajeRunnable;
         /**El campo tRetiroRunnable permite al cajero hacer un retiro.*/
	 public RetiroRunnable tRetiroRunnable;
         /**El campo tPantallaRunnable cambia el estado de la pantalla del cajero. */
	 public PantallaRunnable tPantallaRunnable;
         /**El campo tConsultaRunnable permite al cajero hacer una consulta.*/
	 public ConsultaRunnable tConsultaRunnable;
	 
        /**El campo bank hace referencia al objeto bank creado en la clase Simulación Cajero.*/
        public Bank bank;
	 
	/**El campo changeClave cambia la contraseña, cuando se borra un dígito de la misma.*/ 
	public String changeClave;
        /**El campo entradaDeClave almacena la entrada de la clave.*/
	public String entradaDeClave;
	/**El campo nombreCajero almacena el nombre del cajero.*/
        public String nombreCajero;
        /**El campo cancelar indica cuando se presiona el botón Cancelar.*/
	public boolean cancelar;
        /**El campo entrandoClave indica cuando estoy ingresando la clave.*/
	public boolean entrandoClave;
        /**El campo controlador controla la entrada de la clave.*/
	public boolean controlador;
        /**El campo encontrado  indica si la cuenta de un cliente esta o no registrada.*/
	public boolean encontrado;
        /**El campo aretirar indica  que voy hacer un retiro.*/
        public boolean aretirar;
        /**El campo enretiro indica que estoy haciendo un retiro.*/
	public boolean enretiro;
	/**El campo consulta indica que estoy haciendo una consulta.*/	
	public boolean consulta;
	/**El campo clave almacena la clave de la cuenta digitada por un cliente.*/
	public int clave;
        /**El campo contadorDeEntradaDeClave cuenta la cantidad de dígitos
         ingresados por un cliente.*/
	public int contadorDeEntradaDeClave;
	
 	
 	/**Crea un nuevo CshierListener
         @param bPrimeroOeste Primer botón del oeste de la pantalla del cajero.
         @param bSegundoOeste Segundo botón del oeste de la pantalla del cajero.
         @param bTerceroOeste Tercer botón del oeste de la pantalla del cajero.
         @param bCuartoOeste Cuarto botón del oeste de la pantalla del cajero.
         @param bPrimeroEste Primer botón del este de la pantalla del cajero.
         @param bSegundoEste Segundo botón del este de la pantalla del cajero.
         @param bTerceroEste Tercer botón del este de la pantalla del cajero.
         @param bCuartoEste Cuarto botón del este de la pantalla del cajero.
         @param jContrasenia Campo donde se mostrara la contraseña ingresada.
         @param bInsertaTarjeta Botón para ingresar la tarjeta.
         @param showImage JLabel que muestra la pantalla del cajero.
         @param bank Banco de la simulación.
         @param nombreCajero Nombre del cajero.
         @param pCenterPantalla Panel del centro de la pantalla del  cajero.
         @param pPantalla Panel donde se encuentra la pantalla del cajero .*/
        
        
	public CashierListener(JButton bPrimeroOeste,JButton bSegundoOeste,JButton bTerceroOeste,JButton bCuartoOeste,
	JButton bPrimeroEste,JButton bSegundoEste,JButton bTerceroEste,JButton bCuartoEste,JPasswordField jContrasenia,
	JButton bInsertaTarjeta,JLabel showImage, Bank bank,String nombreCajero,JPanel pCenterPantalla,JPanel pPantalla){
		
		
		
		//Haciendo referencia a componentes creados en Cashier
		this.bPrimeroOeste=bPrimeroOeste;
		this.bSegundoOeste=bSegundoOeste;
		this.bTerceroOeste=bTerceroOeste;
		this.bCuartoOeste=bCuartoOeste;
		
		this.bPrimeroEste=bPrimeroEste;
		this.bSegundoEste=bSegundoEste;
		this.bTerceroEste=bTerceroEste;
		this.bCuartoEste=bCuartoEste;
		
		this.jContrasenia=jContrasenia;
		this.bInsertaTarjeta=bInsertaTarjeta;
		this.showImage=showImage;
		this.bank = bank;
		this.nombreCajero=nombreCajero;
		this.pCenterPantalla=pCenterPantalla;
		this.pPantalla=pPantalla;
		
		
		jArea = new JTextArea();
		//Inicializando variables
		cancelar=false;
		entrandoClave=false;
		controlador=false;
		encontrado =false;
		enretiro =false;
		aretirar=false;
		consulta=false;
		entradaDeClave="";	
		changeClave="";
		contadorDeEntradaDeClave=0;
		
			
		//Se inicializan los archivos de audio
		initializeAudio();
		
		//Hilo de la pantalla
		tPantallaRunnable = new PantallaRunnable(showImage);		
		tPantallaRunnable.start();
		
		
	} 
	
	
	/**Método sobrescrito, que nos permite manejar el funcionamiento de la clase Cashier.
         *@param e ActionListener a ser escuchado
         */
	public void actionPerformed(ActionEvent e){
	

		String button = e.getActionCommand();
		
		
		//Si he ingresado la tarjeta	
		if(e.getSource()==bInsertaTarjeta){
				
				button1Clip.play();
				tPantallaRunnable.setBandera(1);//Hace que muera el hilo tPantallaRunnable
				bInsertaTarjeta.setEnabled(false);
				showImage.setIcon(new javax.swing.ImageIcon("Images\\image3.jpg"));
				
				
		}
		
		//Cancelo cualquiera operacion luego de haber ingresado la tarjeta
		if(button.equals("Cancelar")&&	!(bInsertaTarjeta.isEnabled())){
				
				button2Clip.play();
				cancelar=true;
				inicializa();
				
		}
		
		//Escogiendo el idioma español
		if(e.getSource()==bCuartoEste&&!(bInsertaTarjeta.isEnabled())&&controlador==false){
				
				button1Clip.play();
				tPantallaRunnable.setBandera(1);
				showImage.setIcon(new javax.swing.ImageIcon("Images\\image5.jpg"));
				entrandoClave =true;
				controlador=true;
		}
		
		
		//Estoy ingresando la clave
		if(("0123456789".indexOf(button) != -1)&&!(bInsertaTarjeta.isEnabled())&&entrandoClave==true){
			
			 button1Clip.play();
			if(entradaDeClave.length()<4){
				
				entradaDeClave+=button;
				jContrasenia.setText(entradaDeClave);
				contadorDeEntradaDeClave++;
				
			}
			
			if(entradaDeClave.length()==4){//Ya se ingreso la clave
				
				
				
				if(bank.encuentraCliente(Integer.parseInt(entradaDeClave))){
				
					jContrasenia.setText("");
					
					showImage.setIcon(new javax.swing.ImageIcon("Images\\image4.jpg"));
					entrandoClave=false;
					encontrado=true;//se encontro cliente
					
					
				}
				
				
				else{
						
					tPantallaRunnable.setBandera(1);//Acabamos la vida del Thread tPantallaRunnable
					tPantallaRunnable=new PantallaRunnable(showImage);//Hacemos instancia a otro PantallaRunnable
					//Hilo que nos muestra el mensaje que no se encuentra  cuenta
					tMensajeRunnable=new MensajeRunnable(showImage,tPantallaRunnable );
					tMensajeRunnable.setPriority(Thread.MAX_PRIORITY);
					tMensajeRunnable.start();	
				 	inicializa();
				 	
				}
				
			}
			
			
				
		}
		
		//Escogi hacer una consulta
		if(e.getSource()==bSegundoEste&&!(bInsertaTarjeta.isEnabled())
			&&encontrado==true&&enretiro==false&&consulta==false){
			
		
		
			tPantallaRunnable.setBandera(1);
			tPantallaRunnable = new PantallaRunnable(showImage);
			//Hilo que muestra la consulta de saldo
			tConsultaRunnable = new ConsultaRunnable(showImage,tPantallaRunnable, pCenterPantalla,pPantalla,bank.getIndiceCliente(),bank,jArea);
			tConsultaRunnable.setPriority(Thread.MAX_PRIORITY);
			tConsultaRunnable.start();
				
			consulta=true;
			cancelar=false;
			inicializa();
			
			
		}
		
		//Boy a seleccionar hacer retiro
		if(entradaDeClave.length()==4&&e.getSource()==bPrimeroEste&&!(bInsertaTarjeta.isEnabled())
			&&encontrado==true&&enretiro==false&&consulta==false){
				
				button1Clip.play();

				showImage.setIcon(new javax.swing.ImageIcon("Images\\image7.jpg"));
				enretiro=true;
				bPrimeroEste.setEnabled(false);
		}
		
		
		
		//Estoy haciendo un retiro
		if(enretiro==true&&(e.getSource()==bPrimeroOeste||e.getSource()==bSegundoOeste||e.getSource()==bTerceroOeste
		||e.getSource()==bPrimeroEste||e.getSource()==bSegundoEste)){
			
			
		 	button1Clip.play();
			tPantallaRunnable.setBandera(1);
			
		
			//Seleccionamos la cantidad a retirar
			tPantallaRunnable=new PantallaRunnable(showImage);
			
			if(e.getSource()==bPrimeroOeste){
				
				//Hilo para hacer un retiro
				tRetiroRunnable =new RetiroRunnable(showImage,bank,bank.getIndiceCliente(),10.00,nombreCajero,tPantallaRunnable,0);
				
				tRetiroRunnable.start();
				
				inicializa();
			}
			
			if(e.getSource()==bSegundoOeste){
				
				tRetiroRunnable  =new RetiroRunnable(showImage,bank,bank.getIndiceCliente(),20.00,nombreCajero,tPantallaRunnable,0);
				tRetiroRunnable .start();
				
				inicializa();
			}
			
			if(e.getSource()==bTerceroOeste){
				
				tRetiroRunnable  =new RetiroRunnable(showImage,bank,bank.getIndiceCliente(),50.00,nombreCajero,tPantallaRunnable,0);
				tRetiroRunnable .start();
				
				inicializa();
			}
			
			
			if(e.getSource()==bPrimeroEste&&bPrimeroEste.isEnabled()){
				
				
				tRetiroRunnable  =new RetiroRunnable(showImage,bank,bank.getIndiceCliente(),100.00,nombreCajero,tPantallaRunnable,0);
				tRetiroRunnable .start();
				
				inicializa();
			}
			
			if(e.getSource()==bSegundoEste){
				
				tRetiroRunnable  =new RetiroRunnable(showImage,bank,bank.getIndiceCliente(),500.00,nombreCajero,tPantallaRunnable,0);
				tRetiroRunnable .start();
				
				inicializa();
			}
			
			bPrimeroEste.setEnabled(true);
			
			
		}
			
		//Borrar entrada de la clave
		if(button.equals("Borrar")&&entrandoClave==true){
			
			button1Clip.play();
			
			if(contadorDeEntradaDeClave>=0){
			
				for(int i=0;i<contadorDeEntradaDeClave-1;i++){
				
					changeClave+=entradaDeClave.charAt(i);
				}
				
				entradaDeClave="";
				entradaDeClave+=changeClave;
				jContrasenia.setText(entradaDeClave);
				contadorDeEntradaDeClave--;
				changeClave="";
				
			}
			
		}
	}
	
	
	
	/**Método que inicializa los archivos de audio.*/
	 public void initializeAudio(){
      	
      	SoundEffects sounds = new SoundEffects();
      	sounds.setPathPrefix( "sounds/" );
      	
      	button1Clip = sounds.getAudioClip( button1Sound );
      	button2Clip = sounds.getAudioClip( button2Sound );
      	
      }
      
      
        /**Método que inicializa todos los campos a su valor original.*/
	 public  void inicializa(){
	
		
		if(cancelar==true){
			
			
			tPantallaRunnable=new PantallaRunnable(showImage);
			tPantallaRunnable.start();
		
			enretiro=false;
			
		}	
		
		bInsertaTarjeta.setEnabled(true);
		entrandoClave =false;
		jContrasenia.setText("");
		entradaDeClave="";
		contadorDeEntradaDeClave=0;
		entrandoClave=false;
		controlador=false;
		encontrado=false;
		enretiro=false;
		aretirar=false;
		cancelar = false;
		consulta=false;
	 }
	
	
	/**Método que retorna un objeto PantallaRunnable.
       @return pantallaRunnable Thread de la pantalla del cajero.*/
	public PantallaRunnable getPantallaRunnable(){
		
		return tPantallaRunnable;
		
	}
		
		
		
}