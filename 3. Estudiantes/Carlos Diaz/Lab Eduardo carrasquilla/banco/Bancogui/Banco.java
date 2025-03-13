 import java.awt.*;
 import javax.swing.*;
 import java.awt.event.*;
 
 
public class Banco implements  ActionListener {
	
	JFrame f;
	JButton dis,dep,with;
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
	Panel p_i,p_i_s,p_i_i,p_d;
	JTextArea ta;
    JTextField tf_1,tf_2; 	
    
    	public Banco(){
    		f=new JFrame ("First Java Bank ATM");
    		dis=new JButton ("Display Account Balance ");
    		dis.addActionListener(this);
    		dep=new JButton ("Make a Deposit");
    		dep.addActionListener(this);
    		with=new JButton ("Make a Withdrawal");
    		with.addActionListener(this);
    		b1=new JButton ("1");
    		b1.addActionListener(this);
    		b2=new JButton ("2");
    		b2.addActionListener(this);
    		b3=new JButton ("3");
    		b3.addActionListener(this);
    		b4=new JButton ("4");
    		b4.addActionListener(this);
    		b5=new JButton ("5");
    		b5.addActionListener(this);
    		b6=new JButton ("6");
    		b6.addActionListener(this);
    		b7=new JButton ("7");
    		b7.addActionListener(this);
    		b8=new JButton ("8");
    		b8.addActionListener(this);
    		b9=new JButton ("9");
    		b9.addActionListener(this);
    		b10=new JButton ("0");
    		b10.addActionListener(this);
    		b11=new JButton (".");
    		b11.addActionListener(this);
    		b12=new JButton ("ENTER");
    		b12.addActionListener(this);
    		ta=new JTextArea (12,50);
    		ta.setEnabled(false);
    		tf_1=new JTextField(10);
    		tf_1.addActionListener(this);
    		tf_2=new JTextField(35);
    		tf_2.addActionListener(this);
    		p_i=new Panel();    		
    		p_i_s=new Panel ();
    		p_i_i=new Panel ();
    		
    		p_d=new Panel ();
    	    	 		
    	}
    	    public void ventana(){
    		
    		f.setSize(775,240);
    		p_i_s.setLayout(new GridLayout(4,1,1,1));
    		p_i_s.add(dis);
    		p_i_s.add(dep);
    		p_i_s.add(with);
    		p_i_s.add(tf_1);
    		
    		p_i_i.setLayout(new GridLayout(4,3,1,1));
    		p_i_i.add(b1);
    		p_i_i.add(b2);
    		p_i_i.add(b3);
    		p_i_i.add(b4);
    		p_i_i.add(b5);
    		p_i_i.add(b6);
    		p_i_i.add(b7);
    		p_i_i.add(b8);
    		p_i_i.add(b9);
    		p_i_i.add(b10);
    		p_i_i.add(b11);
    		p_i_i.add(b12);
    	    
    	    p_d.setLayout(new BorderLayout());
    	    p_d.add (ta,BorderLayout.NORTH);
    	    p_d.add(tf_2,BorderLayout.SOUTH);

    	    p_i.setLayout(new BorderLayout());
    		p_i.add(p_i_s,BorderLayout.NORTH);
    		p_i.add(p_i_i,BorderLayout.SOUTH);
    		
    	
    		f.add(p_i,BorderLayout.WEST);
    		f.add(p_d,BorderLayout.EAST);
    		f.setResizable(false);
    		f.setVisible(true);
    		
    	}
    
    public void actionPerformed(ActionEvent e){
    		String x = e.getActionCommand();
    		Object a = e.getSource();
    		if(x.equals("1")){
    		tf_1.setText("1");
    		//ta.append(tf_1.getText());	
    		}
    		else if (x.equals("2")){
    		tf_1.setText("2");	
    		}
    		else if (x.equals("3")){
    		tf_1.setText("3");	
    		}
            else if (x.equals("4")){
    		tf_1.setText("4");	
    		}
    		else if (x.equals("5")){
    		tf_1.setText("5");	
    		}
    		else if (x.equals("6")){
    		tf_1.setText("6");	
    		}
    		else if (x.equals("7")){
    		tf_1.setText("7");	
    		}
    		else if (x.equals("8")){
    		tf_1.setText("8");	
    		}
    		else if (x.equals("9")){
    		tf_1.setText("9");	
    		}
            else if (x.equals("0")){
    		tf_1.setText("0");	
    		}
    		else if (x.equals(".")){
    		tf_1.setText(".");	
    		}
    		else if(x.equals("ENTER")){
    		  ta.append( "\n");
    		  ta.append(tf_1.getText());
    		  }  	    	    
    		  else if (a.equals(tf_2)){
    		  	ta.append( "\n");
    		  	ta.append(tf_2.getText());
    		  }	
    	    }
    public static void main(String[] args) 
    	{
    	
    Banco grafico=new Banco();
    grafico.ventana();	
       }
}
