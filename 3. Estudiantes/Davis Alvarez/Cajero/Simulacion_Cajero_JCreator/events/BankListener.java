package events;

import infocustomer.*;
import messages.*;
import runnables.*;
import view.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class BankListener implements ActionListener,Messages{
	
	
		
	private String nombre;
	private String id;
	private String direccion;
	private String deposito;
	private String retiro;
	private int indice;//el indice del cliente encontrado
	private int numeroDeCuenta;
	private int contadorDeClientes;//contador de clientes registrados
	
	
	
	//Para hacer referencia a los componentes del panel 1 de Bank
	private JTextField tNombrePanel1 ;
	private JTextField tIdPanel1 ;
	private JTextField tDireccionPanel1;
	private JTextField tDepositoPanel1 ;
	private	JTextArea tSalidaPanel1;
	private JButton bAceptarPanel1;
	
	
	
	//Para hacer referencia a los arreglos de objetos Customer y Account creados en Bank, 
	private Customer customers[];
	private Account accounts[];
	
	
	//Para hacer referencia al objeto ViewTransaction que recibio Bank 
	ViewTransaction transaccion;
	

	
	
	
	//Para hacer referencia a los componentes del panel 2 de Bank
	private JTextField tCuentaPanel2;
	private JButton bEncuentraPanel2;
	private JTextField tNombrePanel2;
	private JTextField tIdPanel2 ;
	private JTextField tDireccionPanel2;
	private JTextField tDepositoPanel2; 
	private JTextField tRetiroPanel2;
	private JTextField tBalancePanel2;
	private JRadioButton rDepositoPanel2;
	private	JRadioButton rRetiroPanel2;
	private JButton bAceptarPanel2;
	
	
	
	public BankListener (JTextField tNombrePanel1,JTextField tIdPanel1,JTextField tDireccionPanel1,JTextField tDepositoPanel1,
	JTextArea tSalidaPanel1, JButton bAceptarPanel1,JTextField tCuentaPanel2,JButton bEncuentraPanel2,JTextField tNombrePanel2,
	JTextField tIdPanel2,JTextField tDireccionPanel2,JTextField tDepositoPanel2,JTextField tRetiroPanel2,
	JTextField tBalancePanel2, JRadioButton rDepositoPanel2, JRadioButton rRetiroPanel2 ,JButton bAceptarPanel2,Customer customers[],
	Account accounts[],ViewTransaction transaccion){
		
		
		
		this.tNombrePanel1 = tNombrePanel1;
		this.tDireccionPanel1 = tDireccionPanel1;
		this.tIdPanel1=tIdPanel1;
		this.tDepositoPanel1 = tDepositoPanel1;
		this.tSalidaPanel1=tSalidaPanel1;
		this.bAceptarPanel1= bAceptarPanel1;
		

		
		this.tCuentaPanel2=tCuentaPanel2;
		this.bEncuentraPanel2=bEncuentraPanel2;
		this.tNombrePanel2=tNombrePanel2;
		this.tIdPanel2 =tIdPanel2;
		this.tDireccionPanel2=tDireccionPanel2;
		this.tDepositoPanel2=tDepositoPanel2; 
		this.tRetiroPanel2=tRetiroPanel2;
		this.tBalancePanel2=tBalancePanel2;
		this.rDepositoPanel2=rDepositoPanel2;
		this.rRetiroPanel2=rRetiroPanel2 ;
		this.bAceptarPanel2=bAceptarPanel2;
		
		this.customers = customers;
		this.accounts = accounts;
		this.transaccion=transaccion;
		
		
		//Contador de los clientes
		contadorDeClientes =0;
		
		
		//Desactivar los componentes del segundo panel de Bank
		tNombrePanel2.setEnabled(false);
		tIdPanel2.setEnabled(false);
		tDepositoPanel2.setEnabled(false);
		tDireccionPanel2.setEnabled(false);
		tRetiroPanel2.setEnabled(false);
		tBalancePanel2.setEnabled(false);
		rDepositoPanel2.setEnabled(false);
		rRetiroPanel2.setEnabled(false);
		bAceptarPanel2.setEnabled(false);
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent e)  {
		
			
		nombre = tNombrePanel1.getText();
		id= tIdPanel1.getText();
		direccion =tDireccionPanel1.getText();	
		deposito = tDepositoPanel1.getText();
			
			
			
			if(contadorDeClientes<10){//Solo podemos tener 10 clientes en ejecucion
			
			tSalidaPanel1.setText("");//Limpiamos el cuadro de texto
			
			if(e.getSource()==bAceptarPanel1){//Queremos ingresar un nuevo cliente
				
				//Nos aseguramos que ningun campo de entrada este vacio
				if(nombre.length()==0||id.length()==0||direccion.length()==0||deposito.length()==0){
					
					 
					 mensajeDeError( EMPTY_TEXTFIELD);
					
				}
			
				//Implementamos expreciones regulares para verificar que los datos de entrada
				//estan correctos
				else if(!nombre.matches(("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)"))){
					
					mensajeDeError(INCORRECT_NAME );
						
					
				}
				
				else if(!direccion.matches(("([a-zA-Z]+|[a-zA-Z]+\\s[a-zA-Z]+)"))){
					
					mensajeDeError(INCORRECT_DIRECTION);
					
				}
				
				else if(!id.matches(("([1-9]-[1-9]\\d{2,3}-[1-9]\\d{2,3})"))){
					
					mensajeDeError(INCORRECT_ID);
					
				}
				
				else if(!deposito.matches(("([0-9]+[.][0-9]+)"))){
					
					mensajeDeError(INCORRECT_DEPOSIT );
					
				}
				
				
				
				else{//Si no se produjo ningun error en la entrada de datos 
					//Creamos un nuevo cliente con su cuenta
					
						generaNumero();
						accounts[contadorDeClientes]=new Account(Double.parseDouble(deposito),numeroDeCuenta,transaccion);
					
						customers[contadorDeClientes]=new Customer(nombre,id,direccion,accounts[contadorDeClientes]);
			
			
						tNombrePanel1.setText("");
						tIdPanel1.setText("");
						tDireccionPanel1.setText("");
						tDepositoPanel1.setText("");
						
						tSalidaPanel1.setText("Cliente Agregado\n Nombre:"+customers[contadorDeClientes].getName()+
						"\nCedula :"+customers[contadorDeClientes].getId()+"\n"+"Direccion: "+customers[contadorDeClientes].getDireccion()+
						"\n Número de Cuenta: "+customers[contadorDeClientes].getAccount().getNumeroDeCuenta());
						
						contadorDeClientes++;
					}
				
				}
				
			}
				
				
				
			//Si estamos buzcando un cliente	
			if(e.getSource()==bEncuentraPanel2){
					
					
					String ncuenta =tCuentaPanel2.getText(); 
					//La entrada del numero de la cuenta
					//no deve de estar vacio
					if(ncuenta.length()==0){
						
						mensajeDeError(INCORRECT_ACCOUNT);
					}
					//Exprecion regular que acepta solo 4 digitos, que no inicie con 0
					else if(!ncuenta.matches(("([1-9]\\d{3})"))){
						
						mensajeDeError(INCORRECT_ACCOUNT);
						
					}
					
					
					//Si en contramos al cliente
					else if(encuentraCliente(Integer.parseInt(tCuentaPanel2.getText()))){
						
							tNombrePanel2.setText(customers[indice].getName());
							tIdPanel2.setText(customers[indice].getId());
							tDireccionPanel2.setText(customers[indice].getDireccion());
							tBalancePanel2.setText(customers[indice].getAccount().getBalance()+"");
							
							//Habilitamos los de raidioButton rDepositoPanel2 y rRetiroPanel2
							rDepositoPanel2.setEnabled(true);
							rRetiroPanel2.setEnabled(true);
							
						
					}
					
					else{//No existe el cliente
						
						mensajeDeError(NOT_REGISTERED);
					}
					
					
			}
					
					
					
			//Si seleccionamos hacer deposito		
			if(e.getSource() ==rDepositoPanel2){
					
				tRetiroPanel2.setEnabled(false);
				tDepositoPanel2.setEnabled(true);
				bAceptarPanel2.setEnabled(true);
					
				
				
			}
			
			//Si seleccionamos hacer retiro
			if(e.getSource() ==rRetiroPanel2){
					
			
				tDepositoPanel2.setEnabled(false);
				tRetiroPanel2.setEnabled(true);
				bAceptarPanel2.setEnabled(true);
				
			}
					
					
			//Hacemos la transaccion
			if(e.getSource()==bAceptarPanel2){
					
					//Si hemos escogido hacer un deposito		
					if(tDepositoPanel2.isEnabled()){
								
							
						deposito=tDepositoPanel2.getText();
							 
						if(!deposito.matches(("([0-9]+[.][0-9]+)"))){
								
							mensajeDeError(INCORRECT_DEPOSIT );
						}
						
						else{
							
							 
							customers[indice].getAccount().deposit(Double.parseDouble(deposito));
							estadoDeCuenta();
							limpia();
							desabilita();
								
							
						}
							
					}
						
					else{//Hemos escogido hacer un retiro
							
						retiro=tRetiroPanel2.getText();
							 
						if(!retiro.matches(("([0-9]+[.][0-9]+)"))){
								
							mensajeDeError(INCORRECT_RETIRO );
							
						}
						
						else{
								
							
							
							if(customers[indice].getAccount().withdraw(Double.parseDouble(retiro))){
								
								mensajeDeError(INSSUFFICIENT_FOUNDS);
							}
							else {
								
								estadoDeCuenta();
								limpia();
								desabilita();
							}
						}
							
						}
					}
				
				
				
				
				
		}//end actionPerformed
				
				
			
					
		public void generaNumero(){//Genera un numero de cuenta aleatorio
				
			
			boolean stop = true;
			int aleatorio =0;
			
			
			if(contadorDeClientes==0){
				
				numeroDeCuenta = 2000+(int)( Math.random()*100);
			}
			
			
			
			else {
					
				while(stop!=false){
						
						
					aleatorio= 2000+(int)( Math.random()*100);
						
					for(int i=0;i<contadorDeClientes;i++){
					
						if(accounts[i].getNumeroDeCuenta()==aleatorio){
							
								stop=true;
							 
								break;
						}
							
						else{
								
							stop =false;
								
						}
							
					}
						
				}
				
				numeroDeCuenta=aleatorio;
			}	
			
			
			
		}	
			
			
				
		//Muestra los mensajes de error			
		public void mensajeDeError(String mensaje){
				
			JOptionPane.showMessageDialog(null,mensaje,"Error",
			JOptionPane.INFORMATION_MESSAGE);
				
		}
		
			
			
		//Buzcando un cliente	
		public boolean encuentraCliente(int clave){
					
			int key;
			key=clave;
			boolean stop = false;
			int i =1;
					
			while(i<=contadorDeClientes&& contadorDeClientes>0){
				
				
				if(accounts[i-1].getNumeroDeCuenta()==key){
					
					stop=true;
					indice=i-1;
				}	
					i++;
			}
				
			return(stop);
				
		}
		
		public int getIndiceCliente(){
			
			return indice;
		}	
			
		//Desabilitando los componentes del  segundo panel		
		public void desabilita(){
			
			tNombrePanel2.setEnabled(false);
			tIdPanel2.setEnabled(false);
			tDepositoPanel2.setEnabled(false);
			tDireccionPanel2.setEnabled(false);
			tRetiroPanel2.setEnabled(false);
			tBalancePanel2.setEnabled(false);
			rDepositoPanel2.setEnabled(false);
			rRetiroPanel2.setEnabled(false);
			bAceptarPanel2.setEnabled(false);
			
		}
			
		//Limpiando campos de entrada de datos del primer panel	
		public void limpia(){
				
			tNombrePanel2.setText("");
			tIdPanel2.setText("");
			tDepositoPanel2.setText("");
			tDireccionPanel2.setText("");
			tRetiroPanel2.setText("");
				
		}
			
		//Muestra el estado de cuenta	
		public void estadoDeCuenta(){
				
			String mensaje ="Nombre: "+customers[indice].getName()+"\n"+
			"Cedula: "+customers[indice].getId()+"\n"+"Balance: "+customers[indice].getAccount().getBalance();
				
			JOptionPane.showMessageDialog(null,mensaje,"Balance",
			JOptionPane.INFORMATION_MESSAGE);
				
		}
		
		
		//Nos dice cuantos clientes tengo registrado
		public int getNumberOfAccounts(){
		
			return contadorDeClientes;
		}
	

					
	}
	