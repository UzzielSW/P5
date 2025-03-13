package events;

import media.*;
import view.*;
import runnables.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.applet.*;


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
	 //subpanel de la pantalla del cajero
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
	 
	 
	 //Hilos 
	 private MensajeRunnable tMensajeRunnable;
	 private RetiroRunnable tRetiroRunnable;
	 private PantallaRunnable tPantallaRunnable;
	 private ConsultaRunnable tConsultaRunnable;
	 
	 private Bank bank;
	 
	 
	 private String changeClave;
	 private String entradaDeClave;
	 private String nombreCajero;
	
	
	
	private boolean cancelar;//presione el boton cancelar
	private boolean entrandoClave;//estoy ingresando la clave
	private boolean controlador;//controla la entrada de la clave
	private boolean encontrado;//encontre al cliente
	private boolean enretiro;//estoy en un retiro
	private boolean aretirar;//voy a retirar	
	private boolean consulta;//estoy en una consulta de saldo
	 
	
	private int clave;//clave digitada por el cliente
	private int contadorDeEntradaDeClave;//cuenta la cantidad de digito de la clave
	
 	
 	
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
	
	
	
	//Se inicializa el audio
	 private void initializeAudio(){
      	
      	SoundEffects sounds = new SoundEffects();
      	sounds.setPathPrefix( "sounds/" );
      	
      	button1Clip = sounds.getAudioClip( button1Sound );
      	button2Clip = sounds.getAudioClip( button2Sound );
      	
      }
      
      
     //Se inicilizan todos los componentes y variables
	 private void inicializa(){
	
		
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
	
	
	//Retornar un objeto PantallaRunnable
	public PantallaRunnable getPantallaRunnable(){
		
		return tPantallaRunnable;
		
	}
		
		
		
}