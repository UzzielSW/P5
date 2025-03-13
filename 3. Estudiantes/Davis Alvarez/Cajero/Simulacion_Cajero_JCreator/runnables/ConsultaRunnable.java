//Clase que muestra en la pantalla del cajero una consulta de saldo

package runnables;

import view.*;
import javax.swing.*;
import java.awt.*;


public class ConsultaRunnable extends Thread{
	
	//Hacer referencia al JLabel de la pantalla del cajero
	private JLabel showImage;
	private int indice;//Ubicación del cliente
	
	//Para hacer referencia a un nuevo objeto PantallaRunnable
	private PantallaRunnable tPantallaRunnable;
	
	//Para haceer referencia a los paneles de la pantalla
	private JPanel pCenterPantalla;
	private JPanel pantalla;
	
	
	private String resultadoConsulta;
	//Hacer referencia al banco creado en Bank
	private Bank bank;
	
	//Hacer referencia a jArea 
	private JTextArea jArea ;
	
	//Tiempo que dormira el Thread
	private  final int DELAY =3000;
	
	public ConsultaRunnable(JLabel showImage1,PantallaRunnable  tPantallaRunnable,JPanel pCenterPantalla,JPanel pantalla ,int indice, Bank bank, 
	JTextArea jArea){
		
		
		this.tPantallaRunnable=  tPantallaRunnable;
		this.showImage=showImage1;
		this.pCenterPantalla=pCenterPantalla;
		this.pantalla=pantalla;
		this.indice=indice;
		this.bank = bank;
		
		this.jArea=jArea;; 
	
	}
	

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
	