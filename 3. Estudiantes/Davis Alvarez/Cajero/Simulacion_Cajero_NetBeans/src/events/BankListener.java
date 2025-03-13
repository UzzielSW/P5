
package events;

import infocustomer.*;
import messages.*;
import runnables.*;
import view.*;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


/**
 * Esta clase es la encargada de manejar los eventos de los componentes de  la interfaz gráfica de la  clase Bank
 */
public class BankListener implements ActionListener,Messages{
	
	
    //Para hacer referencia a los componentes del panel 1 de Bank
	private JTextField tNombrePanel1 ;
	private JTextField tIdPanel1 ;
	private JTextField tDireccionPanel1;
	private JTextField tDepositoPanel1 ;
	private	JTextArea tSalidaPanel1;
	private JButton bAceptarPanel1;
        
        
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
        
        
	/**El campo nombre almacena el nombre de un cliente*/	
	public String nombre;
        /**El campo id almacena la identificación personal de un cliente*/
	public String id;
        /**El campo dirección almacena la dirección residencial de un  cliente*/
	public String direccion;
        /**El campo deposito almacena el deposito que haga u un cliente a su cuenta*/
	public String deposito;
        /**El campo retiro almacena el retiro que haga un cliente ha su cuenta*/
	public String retiro;
        /**El campo indice almacena el indice en que se encuentra un cliente dentro del arreglo de objetos 
         Customer o el de cuentas Account*/
	public int indice;//el indice del cliente encontrado
	/**El campo numeroDeCuenta almacena el núemero de la cuenta de un cliente*/
        public int numeroDeCuenta;
        /**El campo contadorDeClientes almacena la cantidad de clientes que tengamos*/
	public int contadorDeClientes;//contador de clientes registrados
	
	/**El campo customers hace referencia al arreglo de objetos customer
         creado en Bank*/
        public Customer customers[];
        
        /**El campo accounts hace referencia al arreglo de objetos accounts
         creado en Bank*/
	public Account accounts[];
	
	
	/**El campo transaccion hace referencia al objeto transaccion creado en la clase 
         SimulacionCajero*/
	public ViewTransaction transaccion;
	

	
	/**Crea un nuevo BankListener
         @param tNombrePanel1 Campo de entrada del nombre de un nuevo cliente.
         @param tIdPanel1 Campo de entrada de la identificación personal de un cliente.
         @param tDireccionPanel1 Campo de entrada de la dirección residencial de un cliente.
         @param tDepositoPanel1 Campo de entrada del deposito inicial  de un cliente.
         @param tSalidaPanel1 Campo de salida de los datos de un cliente aceptado.
         @param bAceptarPanel1 Boton para aceptar ingresar los datos de un cliente.
         @param tCuentaPanel2 Campo de entrada del número de cuenta de un cliente.
         @param bEncuentraPanel2 Botón para encontrar la existencia de un cliente.
         @param tNombrePanel2 Campo de salida del nombre de un cliente encontrado.
         @param tIdPanel2 Campo de salida de la identificación personal de un cliente.
         @param tDireccionPanel2 Campo de salida de la dirección residencial de un cliente.
         @param tBalancePanel2 Campo de salida del balance en la cuenta  de un cliente.
         @param tDepositoPanel2 Campo de entrada para un deposito .
         @param tRetiroPanel2 Campo de entrada para un retiro .
         @param rDepositoPanel2 Selecionar hacer un deposito.
         @param rRetiroPanel2 Seleccionar hacer un retiro.
         @param bAceptarPanel2 Botón para aceptar hacer alguna transacción.
         @param customers Arreglo de objetos Customer.
         @param accounts Arreglo de objetos Account.
         @param transaccion Objeto ViewTransaction*/
        
	public BankListener (JTextField tNombrePanel1,JTextField tIdPanel1,JTextField tDireccionPanel1,JTextField tDepositoPanel1,
	JTextArea tSalidaPanel1, JButton bAceptarPanel1,JTextField tCuentaPanel2,JButton bEncuentraPanel2,JTextField tNombrePanel2,
	JTextField tIdPanel2,JTextField tDireccionPanel2,JTextField tBalancePanel2,JTextField tDepositoPanel2,JTextField tRetiroPanel2,
	JRadioButton rDepositoPanel2, JRadioButton rRetiroPanel2 ,JButton bAceptarPanel2,Customer customers[],
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
	
        /**Método sobrescrito, que nos permite manejar el funcionamiento de la clase Bank.
         *@param e ActionListener a ser escuchado
         */
	public void actionPerformed(ActionEvent e)  {
		
			
		nombre = tNombrePanel1.getText();
		id= tIdPanel1.getText();
		direccion =tDireccionPanel1.getText();	
		deposito = tDepositoPanel1.getText();
			
			
			
			if(contadorDeClientes<10){//Solo podemos tener 10 clientes en ejecución
			
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
					
					
					//Si encontramos al cliente
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
				
				
			
		/**Método que genera un número aleatorio de cuatro dígitos para
                 la cuenta de un cliente*/			
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
			
			
				
		/**Método que muestra los mensajes de error más comunes que se puedan dar 
                 al tratar de hacer alguna operación en el banco.
                 @param mensaje Mensaje de error.*/			
		public void mensajeDeError(String mensaje){
				
			JOptionPane.showMessageDialog(null,mensaje,"Error",
			JOptionPane.INFORMATION_MESSAGE);
				
		}
		
			
			
		/**
     * Método que encuentra un la existencia de la cuenta de un cliente.
     * @param clave Número de la cuenta.
      @return True si se encuentra el cliente false en caso contrario.
     */	
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
		
                /**Método que retorna el indice de la ubicación de la cuenta de un cliente en el arreglo
                 de objetos Account.
                 @return indice Indice de la cuenta del cliente.*/
		public int getIndiceCliente(){
			
			return indice;
		}	
			
		/**Metodo que desabilita los componentes del segundo panel de Bank*/		
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
			
		/**Método que limpia la entrada de datos del primer panel de Bank.*/
		public void limpia(){
				
			tNombrePanel2.setText("");
			tIdPanel2.setText("");
			tDepositoPanel2.setText("");
			tDireccionPanel2.setText("");
			tRetiroPanel2.setText("");
				
		}
			
		/**Método que muestra el estado de la cuenta de un cliente.*/
		public void estadoDeCuenta(){
				
			String mensaje ="Nombre: "+customers[indice].getName()+"\n"+
			"Cedula: "+customers[indice].getId()+"\n"+"Balance: "+customers[indice].getAccount().getBalance();
				
			JOptionPane.showMessageDialog(null,mensaje,"Balance",
			JOptionPane.INFORMATION_MESSAGE);
				
		}
		
		
		/**Método que nos informa la cantidad de clinetes que tengamos registrados.
                 @return contadorDeClientes Cantidad de clientes registrados.*/
		public int getNumberOfAccounts(){
		
			return contadorDeClientes;
		}
	

					
	}
	