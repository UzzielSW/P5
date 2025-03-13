/**
 * @(#)ATMBank.java
 *
 * ATMBank application
 *
 * @author Manuel Tejada 8-818-1801
 * @version 1.00 2009/11/28
 */
 package 	gui;
public class ATMBank {
    
    public static void main(String[] args) {
    	javax.swing.JFrame.setDefaultLookAndFeelDecorated(true);
    	// TODO, add your application code
    	System.out.println("Hello World!");
    	BankWindow j=new BankWindow();
    	j.init();
    }
}
