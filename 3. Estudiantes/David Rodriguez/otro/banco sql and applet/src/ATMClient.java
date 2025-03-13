import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class ATMClient extends JApplet implements ActionListener {

	private static final long serialVersionUID = 1L;

	/*
	 * Variables Panel Lateral Izquierdo
	 */
	private JPanel LateralIz;
	private JPanel LateralIzSuper;
	private JPanel LateralIzinfer;
	private JButton opc1;
	private JButton opc2;
	private JButton opc3;
	private JPasswordField DataEntry;
	private Button Nboton[];
	/*
	 * Variables Panel Lateral derecho
	 */
	private JPanel LateralDe;
	private TextArea Atex;
	// private JScrollPane JSc;
	private JTextField Txfi;
	/*
	 * Variables Panel superior
	 */
	private JMenuBar SBar;
	private JMenu Menu1;
	private JMenu Menu2;
	private JMenu Menu3;
	private JMenuItem MItem1_1;
	private JMenuItem MItem1_2;
	private JMenuItem MItem2_1;
	private JMenuItem MItem3_1;

	public void init() {
		//super("FIRST java BANK ATM");
		/*
		 * Panel Lateral Izquierdo
		 */
		LateralIz = new JPanel(new GridLayout(2, 1));
		LateralIzSuper = new JPanel(new GridLayout(4, 1));
		LateralIzinfer = new JPanel(new GridLayout(4, 3));
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
		for (int i = 0; i < 9; i++) {
			Nboton[i] = new Button("" + (1 + i));
		}
		Nboton[9] = new Button("0");
		Nboton[10] = new Button("Delete");
		Nboton[11] = new Button("Enter");

		LateralIzSuper.add(opc1);
		LateralIzSuper.add(opc2);
		LateralIzSuper.add(opc3);
		LateralIzSuper.add(DataEntry);

		for (int r = 0; r < 12; r++) {
			LateralIzinfer.add(Nboton[r]);
		}

		LateralIz.add(LateralIzSuper);
		LateralIz.add(LateralIzinfer);

		/*
		 * Panel Lateral Izquierdo eventos
		 */
		opc1.addActionListener(this);
		opc2.addActionListener(this);
		opc3.addActionListener(this);

		for (int w = 0; w < 12; w++) {
			Nboton[w].addActionListener(this);
		}

		/*
		 * Panel Lateral Derecho
		 */
		LateralDe = new JPanel(new BorderLayout());
		Atex = new TextArea();

		Txfi = new JTextField();
		LateralDe.add(Atex, BorderLayout.CENTER);
		LateralDe.add(Txfi, BorderLayout.SOUTH);

		/*
		 * Panel superior
		 */
		SBar = new JMenuBar();
		Menu1 = new JMenu("File");
		Menu2 = new JMenu("See");
		Menu3 = new JMenu("Login");
		MItem1_1 = new JMenuItem("addcustomer");
		MItem1_2 = new JMenuItem("cerrar");
		MItem2_1 = new JMenuItem("ver");
		MItem3_1 = new JMenuItem("Login");

		Menu1.add(MItem1_1);
		Menu1.add(MItem1_2);
		Menu2.add(MItem2_1);
		Menu3.add(MItem3_1);

		SBar.add(Menu1);
		SBar.add(Menu2);
		SBar.add(Menu3);

		/*
		 * Panel superior eventos
		 */
		MItem1_1.addActionListener(this);
		MItem1_2.addActionListener(this);
		MItem2_1.addActionListener(this);
		MItem3_1.addActionListener(this);
		/*
		 * Panel principal
		 */
		this.setLayout(new BorderLayout());
		this.setJMenuBar(SBar);
		this.add(LateralIz, BorderLayout.WEST);
		this.add(LateralDe, BorderLayout.CENTER);
	//	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(500, 250);
		//this.setResizable(false);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new ATMClient();
	}
	
	/*
	 * Manejador de eventos
	 */
	@SuppressWarnings("deprecation")
	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand() == "addcustomer") {
			if (JOptionPane.showInputDialog(null, "codigo administrativo: ").equals("admin")) {
				new addcustomer();
			}
			Atex.setText(Atex.getText() + "event: " + e.getActionCommand()+"\n");
		}
		else if (e.getActionCommand() == "ver") {
			if (JOptionPane.showInputDialog(null, "codigo administrativo: ").equals("admin")) {
				new VerTablas();
			}
			Atex.setText(Atex.getText() + "event: " + e.getActionCommand()+"\n");
		}
		else if (e.getActionCommand() == "Login") {
			Atex.setText(Atex.getText() + "event: " + e.getActionCommand()+"\n");
		}
		else if (e.getActionCommand() == "Display account balance") {
			envio.balance();
			Atex.setText(Atex.getText() + "event: " + e.getActionCommand()+"\n");
		} else if (e.getActionCommand() == "Make a deposit") {
			envio.I_Cu();
			Atex.setText(Atex.getText() + "event: " + e.getActionCommand()+"\n");
		} else if (e.getActionCommand() == "Make a Withdrawal") {
			envio.R_Cu();
			Atex.setText(Atex.getText() + "event: " + e.getActionCommand()+"\n");
		} else if (e.getActionCommand() == "Enter") {
			if (envio.busca(DataEntry.getText()) == 0) {
				opc1.setVisible(true);
				opc2.setVisible(true);
				opc3.setVisible(true);
				Nboton[11].show(false);
			}
		}

		else if (e.getActionCommand() == "cerrar") {
			Atex.setText(Atex.getText() + "event: " + e.getActionCommand()+"\n");
			System.exit(0);
		} else if (e.getActionCommand() == "Delete") {
			DataEntry.setText("");
		} else {
			DataEntry.setText(DataEntry.getText() + e.getActionCommand());
		}
	}
}
