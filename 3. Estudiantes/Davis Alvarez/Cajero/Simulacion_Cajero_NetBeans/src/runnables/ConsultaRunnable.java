
package runnables;

import view.*;
import javax.swing.*;
import java.awt.*;


/**
 * Clase que muestra en la pantalla del cajero una consulta de saldo.
 */
public class ConsultaRunnable extends Thread{
	
        /**El campo indice almacena el indice en que se encuentra un cliente dentro del arreglo de objetos 
         Customer o el de cuentas Account.*/
	public int indice;//Ubicación del cliente
	
	 /**El campo tPantallaRunnable cambia el estado de la pantalla del cajero. */
	public PantallaRunnable tPantallaRunnable;
	
        /**El campo DELAY almacena el tiempo que dormira el Thread.*/
	public  final int DELAY =3000;
        
        /**El campo resultadoConsulta almacena el resultado de la consulta de balance
         de la cuenta de un cliente.*/
        public String resultadoConsulta;
        
	/**El campo bank hace referencia al objeto bank creado en la clase Simulación Cajero.*/
	public Bank bank;
        
        
	//Para haceer referencia a los paneles de la pantalla
	private JPanel pCenterPantalla;
	private JPanel pantalla;
        //Hacer referencia al JLabel de la pantalla del cajero
	private JLabel showImage;
	//Hacer referencia a jArea 
	private JTextArea jArea ;
	
	
	
        /**Crea una nueva instancia de ConsultaRunnable.
         @param showImage JLabel que muestra la pantalla del cajero.
         @param tPantallaRunnable Thread que da inicio al funcionamiento de la pantalla del cajero.
         @param pCenterPantalla Panel del centro de la pantalla del  cajero.
         @param pantalla Panel donde se encuentra la pantalla del cajero.
         @param indice Indice de la cuenta del cliente en el arreglo de objetos Account.
         @param bank Banco de la simulación.
         @param jArea Área donde se  mostrara la consulta.*/
	public ConsultaRunnable(JLabel showImage,PantallaRunnable  tPantallaRunnable,JPanel pCenterPantalla,JPanel pantalla ,int indice, Bank bank, 
	JTextArea jArea){
		
		
		this.tPantallaRunnable=  tPantallaRunnable;
		this.showImage=showImage;
		this.pCenterPantalla=pCenterPantalla;
		this.pantalla=pantalla;
		this.indice=indice;
		this.bank = bank;
		
		this.jArea=jArea;
	
	}
	

    /**
     * Método sobreescrito donde se da la consulta de saldo de un cliente.
     */
	public synchronized void run(){
		
			
			
			try{
		
		
			
		
				resultadoConsulta="\n\n\t SISTEMA CLAVE\n\n";
				resultadoConsulta+="             BANCO NACIONAL DE PANAMA\n";
				resultadoConsulta+="           ---------------------------------------------";
				resultadoConsulta+="\n\n\n\n         CONSULTA DE SALDO";
				resultadoConsulta+="\n\n         DISP.:";
			
			
				
				jArea.setEditable(false);
			
				jArea.setBackground(new java.awt.Color(0, 0, 255));
				jArea.setForeground(new java.awt.Color(255, 255, 51));
                                jArea.setFont(new java.awt.Font("Arial", 1, 14));
                                jArea.setColumns(20);
                                jArea.setRows(18);
                                jArea.setText(resultadoConsulta+"\n\n         "+bank.getAccounts(indice).getBalance()+"\n\n"+
                                "           ---------------------------------------------\n"+"                GRACIAS POR SU VISITA");
        	
                                showImage.setIcon(new javax.swing.ImageIcon(""));	
                                pCenterPantalla.add(jArea,BorderLayout.CENTER);
                                pantalla.add(pCenterPantalla, BorderLayout.CENTER);
				
                                Thread.sleep(DELAY);
			
			
			}catch(InterruptedException e){
			
				e.printStackTrace();
			}
		

	tPantallaRunnable.setPriority(Thread.MAX_PRIORITY);
	tPantallaRunnable.start(); 

	
		}
		
	}