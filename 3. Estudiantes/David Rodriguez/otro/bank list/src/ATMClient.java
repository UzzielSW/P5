import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
/*
 * Esta clase genera el ventana principal
 * @author David Rodríguez
 * */
public class ATMClient extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	/*
	 * Variables de referencia de la Lista
	 * */
	private static	ListaS lisC=null;
	private	Nodo nodoactual = null;
	
	/*
	 * Variables Panel Lateral Izquierdo
	 * */
	private JPanel LateralIz;
	private JPanel LateralIzSuper;
	private JPanel LateralIzinfer;
	private JButton opc1;
	private JButton opc2;
	private JButton opc3;
	private JPasswordField DataEntry;
	private Button Nboton[];
	private static int pass;
	/*
	 * Variables Panel Lateral derecho
	 * */
	private JPanel LateralDe;
	private JTextArea Atex;
	//private JScrollPane JSc;
	private JTextField Txfi;
	/*
	 * Variables Panel superior
	 * */
	private JMenuBar SBar;
	private JMenu Menu1;
	private JMenu Menu2;
	private JMenu Menu3;
	private JMenuItem MItem1_1;
	private JMenuItem MItem1_2;
	private JMenuItem MItem1_3;
	private JMenuItem MItem2_1;
	private JMenuItem MItem3_1;
	
	public ATMClient(){
		super("FIRST java BANK ATM");
		/*
		 * Panel Lateral Izquierdo
		 * */
		LateralIz = new JPanel(new GridLayout(2,1));
		LateralIzSuper = new JPanel(new GridLayout(4,1));
		LateralIzinfer = new JPanel(new GridLayout(4,3));
		opc1 = new JButton("Display account balance");
		opc2 = new JButton("Make a deposit");
		opc3 = new JButton("Make a Withdrawal");
		opc1.setVisible(false);
		opc2.setVisible(false);
		opc3.setVisible(false);
		
		DataEntry = new JPasswordField();
		DataEntry.setEchoChar('#');
		DataEntry.setHorizontalAlignment(JTextField.CENTER);
		DataEntry.setEditable(false);
		
		Nboton = new Button[12];
		for(int i=0;i<9;i++){
		 Nboton[i]= new 	Button(""+(1+i));
		}
		Nboton[9]= new 	Button("0");
		Nboton[10]= new 	Button("Delete");
		Nboton[11]= new 	Button("Enter");
		
		LateralIzSuper.add(opc1);
		LateralIzSuper.add(opc2);
		LateralIzSuper.add(opc3);
		LateralIzSuper.add(DataEntry);
		for(int r=0;r<12;r++){
		LateralIzinfer.add(Nboton[r]);}
		
		LateralIz.add(LateralIzSuper);
		LateralIz.add(LateralIzinfer);
		
		/*
		 * Panel Lateral Izquierdo eventos
		 * */
		opc1.addActionListener(this);
		opc2.addActionListener(this);
		opc3.addActionListener(this);
		Nboton[0].addActionListener(this);
		Nboton[1].addActionListener(this);
		Nboton[2].addActionListener(this);
		Nboton[3].addActionListener(this);
		Nboton[4].addActionListener(this);
		Nboton[5].addActionListener(this);
		Nboton[6].addActionListener(this);
		Nboton[7].addActionListener(this);
		Nboton[8].addActionListener(this);
		Nboton[9].addActionListener(this);
		Nboton[10].addActionListener(this);
		Nboton[11].addActionListener(this);

		/*
		 * Panel Lateral Derecho
		 * */
		LateralDe = new JPanel(new BorderLayout()); 
		Atex = new JTextArea();
		//JSc = new JScrollPane(Atex,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		Txfi = new JTextField();
		LateralDe.add(Atex,BorderLayout.CENTER);
		LateralDe.add(Txfi,BorderLayout.SOUTH);
		
		/*
		 * Panel superior
		 * */
		SBar = new JMenuBar();
		Menu1 = new JMenu("File");
		Menu2 = new JMenu("See");
		Menu3 = new JMenu("Logout");
		MItem1_1 = new JMenuItem("addcustomer");
		MItem1_2 = new JMenuItem("salve");
		MItem1_3 = new JMenuItem("close");
		MItem2_1 = new JMenuItem("ver");
		MItem3_1 = new JMenuItem("Logout");
		
		Menu1.add(MItem1_1);
		Menu1.add(MItem1_2);
		Menu1.add(MItem1_3);
		Menu2.add(MItem2_1);
		Menu3.add(MItem3_1);
		
		SBar.add(Menu1);
		SBar.add(Menu2);
		SBar.add(Menu3);
		
		/*
		 * Panel superior eventos
		 * */
		MItem1_1.addActionListener(this);
		MItem1_2.addActionListener(this);
		MItem1_3.addActionListener(this);
		MItem2_1.addActionListener(this);
		MItem3_1.addActionListener(this);
		/*
		 * Panel principal
		 * */
		this.setLayout(new BorderLayout());
		this.setJMenuBar(SBar);
		this.add(LateralIz,BorderLayout.WEST);
		this.add(LateralDe,BorderLayout.CENTER);
	}
	
	public static void main(ListaS lis) {
		if(lisC==null){lisC=lis;}
		ATMClient run = new ATMClient();
		run.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		run.setSize(500, 250);
		run.setResizable(false);
		run.setVisible(true);
	}
	
	/*
	 * Manejador de eventos
	 * */
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {
		
		if(e.getActionCommand()=="addcustomer"){
			logout.main(lisC,0);
			Atex.setText(Atex.getText()+"event: "+e.getActionCommand()+"\n");}
		
		else if(e.getActionCommand()=="ver"){
			logout.main(lisC,1);
		Atex.setText(Atex.getText()+"event: "+e.getActionCommand()+"\n");
		}
		
		else if(e.getActionCommand()=="Logout"){
			nodoactual=null;
			DataEntry.setText("");
			opc1.setVisible(false);
			opc2.setVisible(false);
			opc3.setVisible(false);
			Atex.setText(Atex.getText()+"event: "+e.getActionCommand()+"\n");}
		
		else if(e.getActionCommand()=="Display account balance"){
			Double tes=0.00;
			if(nodoactual.SaldoA==-1){tes=nodoactual.SaldoC;}
			else {tes=nodoactual.SaldoA;}
			
			JOptionPane.showMessageDialog(null, "balance actual: " + tes);
			Atex.setText(Atex.getText()+"event: "+e.getActionCommand()+"\n");}
		
		else if(e.getActionCommand()=="Make a deposit"){
			String ans;
				double tes=0;
					ans = JOptionPane.showInputDialog(null, "Ingrese la cantidad a depositar:");
						double dep = Double.parseDouble(ans);
						if(nodoactual.SaldoA==-1){nodoactual.SaldoC+=dep;
						tes=nodoactual.SaldoC;}
						else {nodoactual.SaldoA+=dep;
						tes=nodoactual.SaldoA;}
						write.main(lisC);
						opc2.show(false);
						opc3.show(false);
						JOptionPane.showMessageDialog(null, "balance actual: " + tes);
			Atex.setText(Atex.getText()+"event: "+e.getActionCommand()+"\n");}
		
		else if(e.getActionCommand()=="Make a Withdrawal"){

			String ans;
		  	double tes=0;
		  	ans = JOptionPane.showInputDialog(null, "Ingrese la cantidad a retirar:");
	        	double dep = Double.parseDouble(ans);
	        	if(nodoactual.SaldoA==-1){tes=nodoactual.SaldoC;}
				else {tes=nodoactual.SaldoA;}

	        	if(tes!=0){
	        			tes-=dep;
	        		if(tes>=0){
	        			if(nodoactual.SaldoA==-1){nodoactual.SaldoC-=dep;
						tes=nodoactual.SaldoC;}
						else {nodoactual.SaldoA-=dep;
						tes=nodoactual.SaldoA;}
	        			write.main(lisC);
	        			opc2.show(false);
						opc3.show(false);
				  	JOptionPane.showMessageDialog(null, "balance actual: " + tes);
	        		}else{
				  JOptionPane.showMessageDialog(null, "su balance actual es inferior al mondo que desea retirar");}
	        		}
	        	else {JOptionPane.showMessageDialog(null, "su saldo es 0");}

			Atex.setText(Atex.getText()+"event: "+e.getActionCommand()+"\n");}
		else if(e.getActionCommand()=="Enter"){
				pass=Integer.parseInt( DataEntry.getText());
			if(nodoactual==null){
				nodoactual=lisC.busca(pass);}
			if(nodoactual!=null){
				opc1.setVisible(true);
				opc2.setVisible(true);
				opc3.setVisible(true);}
			
			Atex.setText(Atex.getText()+"event: "+e.getActionCommand()+"\n");}
		
		else if(e.getActionCommand()=="cerrar"){
		Atex.setText(Atex.getText()+"event: "+e.getActionCommand()+"\n");
		System.exit(0);
		}
		else if(e.getActionCommand()=="salve"){
			MItem1_2.show(false);
			Nboton[11].show(false);
			logout.main(lisC,2);}
		else if(e.getActionCommand()=="Delete"){DataEntry.setText("");}
		else{DataEntry.setText(DataEntry.getText()+e.getActionCommand());}	
	}//1661 6381

}
