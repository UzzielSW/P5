/**Programa de valor futuro
 *Creado por:
 *Manuel Tejada
 *8-818-1801
 *
  */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JOptionPane;


public class FutureValue extends JFrame  implements ActionListener{
	
private JLabel jl_InvAmt,jl_Years,jl_AnIntRat,jl_FutVal;
private JTextField jtf_InvAmt,jtf_Years,jtf_AnIntRat,jtf_FutVal;
private JButton jb_Calculate;
private JPanel jp_Center,jp_Weast,jp_East;


    public FutureValue(String nombre) {
    	super(nombre);
    	
    	jl_InvAmt =new JLabel("  Investment Amount");
    	jl_Years=new JLabel("  Years");
    	jl_AnIntRat=new JLabel("  Annual Interest Rate");
    	jl_FutVal=new JLabel("  Future Value");
    		
    	jtf_InvAmt=new JTextField();
    	jtf_Years=new JTextField();
    	jtf_AnIntRat=new JTextField();
    	jtf_FutVal=new JTextField();
    	
    	jb_Calculate=new JButton("Calculate");
    	
    	jp_Center=new JPanel(new GridLayout(1,2));
    	jp_East=new JPanel(new GridLayout(0,1));
    	jp_Weast=new JPanel(new GridLayout(0,1));
    	 
   }
    
    public void dameForma(){
    	creaMenu(); 	 
    	
    	jtf_FutVal.setEnabled(false);
    	
       	jp_Weast.add(jl_InvAmt);
    	jp_Weast.add(jl_Years);
    	jp_Weast.add(jl_AnIntRat);
    	jp_Weast.add(jl_FutVal);
    	
    	jp_East.add(jtf_InvAmt);
    	jp_East.add(jtf_Years);
    	jp_East.add(jtf_AnIntRat);
    	jp_East.add(jtf_FutVal);
    	
    	jp_Center.add(jp_Weast);
    	jp_Center.add(jp_East);
    	
    	jb_Calculate.addActionListener(this);
    	
    	add(jp_Center,BorderLayout.CENTER);
    	add(jb_Calculate,BorderLayout.SOUTH);
    	setSize(315,160);
    	setResizable(false);
    }
    
    public void creaMenu(){
			JMenuBar jmb_barra =new JMenuBar();
		setJMenuBar(jmb_barra);
		
		JMenu jm_Oper=new JMenu("Operaciones");
		jm_Oper.setMnemonic('O');
		
		jmb_barra.add(jm_Oper);
		
		JMenu jm_Help=new JMenu("Help");
		jm_Help.setMnemonic('H');
		
		jmb_barra.add(jm_Help);
	
		}
    
    
    public void actionPerformed(ActionEvent e){
    	try{
    	
    	if(e.getActionCommand().equals("Calculate"));
    	{
    		double invest_amount=Double.parseDouble(jtf_InvAmt.getText());
    		double years=Double.parseDouble(jtf_Years.getText());
    		double interest=Double.parseDouble(jtf_AnIntRat.getText());
    		double valorFuturo,aux;
    		valorFuturo=invest_amount*Math.pow(1+(interest/1200),years*12);
    		aux=(double )Math.round(valorFuturo);
    		aux=valorFuturo-aux;
    		valorFuturo=(double )Math.round(valorFuturo);
    		aux=aux*100;
    		aux=(double )Math.round(aux);
    		valorFuturo=valorFuturo+aux/100;
    		
    		jtf_FutVal.setText(""+valorFuturo);
    	}
    	}
    	catch(Exception r){
    		jtf_AnIntRat.setText("");
    		jtf_FutVal.setText("");
    		jtf_InvAmt.setText("");
    		jtf_Years.setText("");
    	}
    }
}