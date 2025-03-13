import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class logout extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	private static int Y=0;
	private static	ListaS lisC=null;
	private JLabel Lnic;
	private JLabel Lpas;
	private JTextField nic;
	private JTextField pas;
	private JPanel pal1;
	private JButton AC;
	private JButton CL;

public logout() {
	super("login");
	Lnic= new JLabel("Username:", SwingConstants.CENTER);
	Lpas= new JLabel("Password:", SwingConstants.CENTER);
	nic = new JTextField();
	pas = new JTextField();
	pal1 = new JPanel(new GridLayout(3,3));
	AC = new JButton("Login");
	CL = new JButton("Cancel");
	AC.addActionListener(this);
	CL.addActionListener(this);
	pal1.add(Lnic);
	pal1.add(nic);
	pal1.add(Lpas);
	pal1.add(pas);
	pal1.add(AC);
	pal1.add(CL);
	
	this.setLayout(new BorderLayout());
	this.add(pal1);
	
	}

	public static void main(ListaS lis,int X) {
		if(lisC==null){lisC=lis;}
		Y = X;
		logout run = new logout();
		run.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		run.setSize(250, 100);
		run.setResizable(false);
		run.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand()=="Login"){
			if(nic.getText().equals("admin")){
				if(Y==0){addcustomer.main(lisC);}
				else if(Y==2){write.main(lisC);}
				else{VerTablas.main(lisC);}
				
				this.hide();}
			else{JOptionPane.showMessageDialog(null,"No Encuentra en el archivo!","Information",JOptionPane.WARNING_MESSAGE);}
			}
		else if(e.getActionCommand()=="Cancel"){this.hide();}
		
	}

}
