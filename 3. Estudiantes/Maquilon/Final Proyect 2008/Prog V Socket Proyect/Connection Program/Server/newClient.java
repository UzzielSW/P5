

package clases;

import java.net.*;

import javax.swing.*;

import java.io.*;

import java.util.*;

import java.awt.*;

public class newClient extends Thread
{
	private Socket client;
	
	int numberC;
	
	Methods sesionData;
	
	JFrame here;
	
	File dataFile = new File("clientes.txt") ;
	
	public newClient(Socket socket,int numberC)
	{ 
      	client = socket;
      	
      	this.numberC = numberC;
	}
	
	public void run()
	{		
		sesion();
	}
	
	public void sesion()
	{
		try
		{
			while(true)
			{		
				/////////////////////////////////////////////////////////////////////////////
				
				String option;
				
				do
				{	
				
				InputStream take = client.getInputStream();
				
				ObjectInputStream Toclient = new ObjectInputStream(take);
				
				option = Toclient.readObject().toString();
				
				////////////////////////////////////////////////////////////////////
				
				if(option.equals("nuevo Usuario"))
				{
					System.out.println("\ncreacion de nuevo usuario en proceso\n");
					
					ObjectInputStream recieveAccess = new ObjectInputStream(client.getInputStream());
					
					String access = recieveAccess.readObject().toString(); 
	
					if(access.equals("proceso de registro Cancelado"))
					{
						System.out.println("\nregistro Cancelado\n");
					}
					
					else
					{
						
					System.out.println("\nRegistro en proceso\n");
				
					ObjectInputStream recieveRegisterData = new ObjectInputStream(client.getInputStream());
					
					String name = recieveRegisterData.readObject().toString();
					
					String lastName = recieveRegisterData.readObject().toString();
					
					String Id = recieveRegisterData.readObject().toString();
					
					String Password = recieveRegisterData.readObject().toString();
					
					String M = recieveRegisterData.readObject().toString();
					
					Accounts addClient = new Accounts(name,lastName,Id,Password,M);
					
					System.out.println("\nFin de Registro\n");			
					
					}
				}
				
				/////////////////////////////////////////////////////////////////////
		
				else if(option.equals("iniciar Sesion"))
				{
					System.out.println("\nIniciando Sesion en proceso\n");
					
					ObjectInputStream recieveAccess = new ObjectInputStream(client.getInputStream());
					
					String access = recieveAccess.readObject().toString(); 
	
					if(access.equals("inicio de sesion Cancelado"))
					{
						System.out.println("\nInicio de Sesion cancelado\n");
					}
					
				else
					
				try
				{
					
				ObjectInputStream recieveSesionData = new ObjectInputStream(client.getInputStream());
				
				String name = recieveSesionData.readObject().toString();
				
				String lastName = recieveSesionData.readObject().toString();
				
				sesionData = new Methods();
				
				sesionData.sesion(name,lastName);
				
				/////////////////////////////////////////////////////////
				
				ObjectOutputStream sendAnswer = new ObjectOutputStream(client.getOutputStream());
				
				String answer = sesionData.permitir;
				
				sendAnswer.writeObject(answer);
				
				if(answer.equals("si"))
				{	
					ObjectOutputStream sendData = new ObjectOutputStream(client.getOutputStream());
				
					String Id = sesionData.cedul;
				
					String m = sesionData.sald;
				
					sendData.writeObject(answer);
				
					sendData.writeObject(name);
				
					sendData.writeObject(lastName);
				
					sendData.writeObject(Id);
				
					sendData.writeObject(m);
				}
				
				else if(answer.equals("no"))
				{	
					ObjectOutputStream sendData = new ObjectOutputStream(client.getOutputStream());
				
					sendData.writeObject(answer);
				}
				
				else if(answer.equals("no hay clientes"))
				{
					ObjectOutputStream sendData = new ObjectOutputStream(client.getOutputStream());
				
					sendData.writeObject(answer);
				}
				
				} catch(Exception e){}
				
				}
				
				//////////////////////////////////////////////////////////////////////
		
				else if(option.equals("realizar un Deposito"))
				{
					System.out.println("Depositar en proceso\n");
	
					ObjectInputStream recieveAccess = new ObjectInputStream(client.getInputStream());
					
					String access = recieveAccess.readObject().toString(); 
	
					if(access.equals("deposito Cancelado"))
					{
						System.out.println("\nDeposito cancelado\n");
					}
					
					else
					{
						
					ObjectInputStream recieveDeposit = new ObjectInputStream(client.getInputStream());
				
					String Deposit = recieveDeposit.readObject().toString();
					
					sesionData.Depositar(Deposit);
					
					ObjectOutputStream sendAnswer = new ObjectOutputStream(client.getOutputStream());
					
					sendAnswer.writeObject(sesionData.permitirDepo);
					
					}
				}
				
				//////////////////////////////////////////////////////////////////////
		
				else if(option.equals("realizar un Retiro"))
				{
				
					System.out.println("Retirar en proceso\n");
					
					ObjectInputStream recieveAccess = new ObjectInputStream(client.getInputStream());
					
					String access = recieveAccess.readObject().toString();
					
					if(access.equals("retiro Cancelado"))
					{
						System.out.println("\nretiro Cancelado\n");
					}
					
					else
					{
						
					ObjectInputStream recieveWithdraw = new ObjectInputStream(client.getInputStream());
				
					String Withdraw = recieveWithdraw.readObject().toString();
					
					sesionData.Retirar(Withdraw);
					
					ObjectOutputStream sendAnswer = new ObjectOutputStream(client.getOutputStream());
					
					sendAnswer.writeObject(sesionData.permitirWith);
					
					}
				}
				
				else if(option.equals("Visualizar Clientes"))
				{
					System.out.println("\nVisualizacion de Clientes en proceso\n");
					
					ObjectOutputStream sendData = new ObjectOutputStream(client.getOutputStream());
				
					LinkedList clientsList = new LinkedList();
					
					if(dataFile.exists())
					{
					
					ObjectInputStream extract = new ObjectInputStream(new FileInputStream(new File("clientes.txt"))); 			
        	
        			clientsList = (LinkedList) extract.readObject();
				
					sendData.writeObject(clientsList);	
					
					}
					
					else
					{
						
					sendData.writeObject(clientsList);
					
					}
				}
				
				//////////////////////////////////////////////////////////////////////
				
				else if(option.equals("End Program !"))
				{
					System.out.println("\nFinalizando en proceso\n");
					
					try
					{
					
					Thread.sleep(2000);
					
					}  catch(InterruptedException s){   }
				}
				
				else if(option.equals("Consultar Balance"))
				{
						System.out.println("\nConsulta de Balance en proceso\n");
					
						ObjectOutputStream sendactualBalance = new ObjectOutputStream(client.getOutputStream());
						
						sesionData.seeBalance();
						
						sendactualBalance.writeObject(sesionData.Balance);
				}
				
				//////////////////////////////////////////////////////////////////////////////
				
				} while(!option.equals("End Program !"));
				
				JDialog desconnection = new JDialog(here,"Attention...!",false);
				
				BorderLayout in = new BorderLayout();
				
				JLabel message = new JLabel("The Client # " + numberC + " has been disconnected !");
				
				message.setForeground(Color.white);
				
				JPanel panel = new JPanel();
				
				panel.setSize(400,200);
				
				panel.setBackground(Color.black);
				
				panel.add(message,in.CENTER);
				
				desconnection.add(panel,in.WEST);
				
				desconnection.setSize(400,200);
				
				desconnection.setLocationRelativeTo(null);
				
				desconnection.setVisible(true);
				
    	    	//////////////////////////////////////////////////////////////////////
			}
			
			}catch(SocketTimeoutException s)
			{
				System.out.println("Socket timed out!");
			}
			
			catch(IOException e)
			{
				e.printStackTrace();
			}
			
			catch(Exception d){	}
	}	
}