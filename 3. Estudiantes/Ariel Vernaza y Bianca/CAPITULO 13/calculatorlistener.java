import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CalculatorListener implements ActionListener{
	private JLabel seteable;
	private int resultado;
	private int oper=0,oper1=0,oper2=0;
	String temp;
	int tiempoc;
	public CalculatorListener(JLabel temp){
	seteable=temp;
	resultado=0;
	tiempoc=0;
	}	
	public void actionPerformed(ActionEvent e){
		JButton component =(JButton) e.getSource();		
		if(tiempoc==0){
			temp=new String();
		tiempoc=1;
		}
		else	
		  temp=seteable.getText();				
		
		if(component.getActionCommand()=="0"){
		temp=temp+Integer.toString(0);	
		seteable.setText(temp);	
		}
		else if(component.getActionCommand()=="1"){		
		temp=temp+Integer.toString(1);
		seteable.setText(temp);	
		}
		else if(component.getActionCommand()=="2"){
			temp=temp+Integer.toString(2);
			seteable.setText(temp);		
		}
		else if(component.getActionCommand()=="3"){
			temp=temp+Integer.toString(3);
			seteable.setText(temp);		
		}
		else if(component.getActionCommand()=="4"){
			temp=temp+Integer.toString(4);
			seteable.setText(temp);		
		}
		else if(component.getActionCommand()=="5"){
			temp=temp+Integer.toString(5);
			seteable.setText(temp);		
		}
		else if(component.getActionCommand()=="6"){
			temp=temp+Integer.toString(6);
			seteable.setText(temp);		
		}
	    else if(component.getActionCommand()=="7"){
	    	temp=temp+Integer.toString(7);
			seteable.setText(temp);	
		}
	    else if(component.getActionCommand()=="8"){
	    	temp=temp+Integer.toString(8);
			seteable.setText(temp);	
		}
	    else if(component.getActionCommand()=="9"){
	    	temp=temp+Integer.toString(9);
			seteable.setText(temp);	
		}
	    else if(component.getActionCommand()=="."){
	    	temp=temp+Integer.toString(9);
			seteable.setText(temp);	
		}
	      else if(component.getActionCommand()=="+"){
	    	  oper1=Integer.parseInt(seteable.getText());
	    	  tiempoc=0;
	    	  oper=1;
	    	  }
	      else if(component.getActionCommand()=="-"){
	    	  oper1=Integer.parseInt(seteable.getText());
	    	  tiempoc=0;
	    	  oper=2;
	    	  }
	      else if(component.getActionCommand()=="X"){
	    	  oper1=Integer.parseInt(seteable.getText());
	    	  tiempoc=0;
	    	  oper=3;
	    	  }
	      else if(component.getActionCommand()=="/"){
	    	  oper1=Integer.parseInt(seteable.getText());
	    	  tiempoc=0;
	    	  oper=4;
	    	  }
	      else if(component.getActionCommand()=="="){
	    	  oper2=Integer.parseInt(seteable.getText());
	    	  switch(oper){
	    	  case 1:
	    	         resultado=oper1+oper2;
	    	         break;
	    	  case 2:
	    	         resultado=oper1-oper2;
	    	         break;
	    	  case 3:
	    	         resultado=oper1*oper2;
	    	         break;
	    	  case 4:
	    		     if(oper2==0)
	    		      JOptionPane.showMessageDialog(null,"Error, no se puede dividir con cero");	 
	    		     else
	    		     resultado=oper1/oper2;
	    	         break;
	    	  }	  	
	    	  seteable.setText(Integer.toString(resultado));
	    	  oper=0;
	    	 }
	      }
	    	   
							
		
}
