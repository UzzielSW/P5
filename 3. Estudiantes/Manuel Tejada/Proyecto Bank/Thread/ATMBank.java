/**
 * @(#)ATMBank.java
 *
 * ATMBank application
 *
 * @author Manuel Tejada 8-818-1801
 * @version 1.00 2009/11/28
 */
 package 	gui;
public class ATMBank extends Thread{
    
   
    public ATMBank(){
 
    }
    
    public void run(){
    	BankWindow j=new BankWindow();
    	Boton_Crear crear=new Boton_Crear(j);
   	Boton_Cerrar t =new Boton_Cerrar(j,this);
    }
    
    public static void main(String[] args) {
    		BankWindow j=new BankWindow();
    		j. 	setDefaultCloseOperation(javax.swing.JFrame.EXIT_ON_CLOSE);
    		Boton_Crear crear=new Boton_Crear(j);
    	}
    
}
