import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/*
 * Esta clase genera la subventana perteneciente a los administrador
 * @author David Rodríguez
 * */
public class addcustomer extends JFrame implements ActionListener , Runnable{

	private static final long serialVersionUID = 1L;
	/*
	 * Variables Primera ventana ficha1
	 */
	private JTabbedPane Fichas;
	private Panel panel1;

	private JLabel etiqueta1;
	private JLabel etiqueta2;
	private JLabel etiqueta3;
	private JLabel etiqueta4;
	private JLabel etiqueta5;

	private JTextField recuadro1;
	private JTextField recuadro2;
	private JTextField recuadro3;

	private ButtonGroup btg;
	private JRadioButton Corriente;
	private JRadioButton ahorro;

	private JButton add;
	private JButton cancel;
	
	/*
	 * Variables Segunda ventana ficha2
	 */
	private Panel panel4;
	private Panel panel5;

	private JLabel etiquetaf21;
	private JLabel etiquetaf22;
	private JLabel etiquetaf23;
	private JLabel etiquetaf24;

	private JTextField recuadrof21;
	private JTextField recuadrof22;
	private JTextField recuadrof23;

	private JButton ok;
	private JButton listo;

	public void run() {
	//	super("customer");
		/*
		 * Primera ventana ficha1
		 */

		Fichas = new JTabbedPane();
		panel1 = new Panel(new GridLayout(6, 2));
		etiqueta1 = new JLabel("Nombre", SwingConstants.CENTER);
		etiqueta2 = new JLabel("Apellido", SwingConstants.CENTER);
		etiqueta3 = new JLabel("N° de cuenta", SwingConstants.CENTER);
		etiqueta4 = new JLabel("Apertura", SwingConstants.CENTER);
		etiqueta5 = new JLabel("0000", SwingConstants.CENTER);

		recuadro1 = new JTextField();
		recuadro2 = new JTextField();
		recuadro3 = new JTextField();

		btg = new ButtonGroup();
		Corriente = new JRadioButton("Corriente", true);
		ahorro = new JRadioButton("ahorro", false);

		btg.add(ahorro);
		btg.add(Corriente);
		add = new JButton("add");
		cancel = new JButton("cancel");

		panel1.add(etiqueta1);
		panel1.add(recuadro1);
		panel1.add(etiqueta2);
		panel1.add(recuadro2);
		panel1.add(etiqueta3);
		panel1.add(etiqueta5);
		panel1.add(etiqueta4);
		panel1.add(recuadro3);
		panel1.add(Corriente);
		panel1.add(ahorro);
		panel1.add(add);
		panel1.add(cancel);
		Fichas.addTab("add customer", null, panel1, "Ventana1");
		/*
		 * Eventos Primera ventana ficha1
		 */
		ahorro.setActionCommand("Ahorro");
		Corriente.setActionCommand("Corriente");
		add.addActionListener(this);
		cancel.addActionListener(this);

		/*
		 * Segunda ventana ficha2
		 */
		panel4 = new Panel(new BorderLayout());
		panel5 = new Panel(new GridLayout(4, 2));

		etiquetaf21 = new JLabel("INTRODUZCA EL CODIGO DE CUENTA",
				SwingConstants.CENTER);
		etiquetaf22 = new JLabel("Correccion de nombre:");
		etiquetaf23 = new JLabel("Correccion de apellido:");
		etiquetaf24 = new JLabel("Requiere salvar despues de salir",
				SwingConstants.CENTER);

		recuadrof21 = new JTextField();
		recuadrof22 = new JTextField();
		recuadrof23 = new JTextField();

		ok = new JButton("Ok");
		ok.addActionListener(this);

		listo = new JButton("Listo");
		listo.addActionListener(this);
		panel5.add(recuadrof21);
		panel5.add(ok);
		panel5.add(etiquetaf22);
		panel5.add(recuadrof22);
		panel5.add(etiquetaf23);
		panel5.add(recuadrof23);
		panel5.add(listo);

		panel4.add(etiquetaf21, BorderLayout.NORTH);
		panel4.add(panel5, BorderLayout.CENTER);
		panel4.add(etiquetaf24, BorderLayout.SOUTH);
		Fichas.addTab("setting", null, panel4, "Ventana2");

		/*
		 * Panel principal
		 */
		this.setLayout(new BorderLayout());
		this.add(Fichas);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(400, 220);
		this.setResizable(false);
		this.setVisible(true);
	}

//	public void busca(String Nc, String Ac) {
		//recuadrof22.setText(Nc);
	//	recuadrof23.setText(Ac);
//	}
	 /*
     * Metodo acciones.
     * */
	public void actionPerformed(ActionEvent e) {
		long tem = envio_A.pass(Math.round(Math.random() * 9999 + 1000));
		if (e.getActionCommand() == "add") {
			if (btg.getSelection().getActionCommand() == "Corriente") {
				etiqueta5.setText("" + tem);
				envio_A.addclient(tem, recuadro1.getText(),	recuadro2.getText(), -1, Double.parseDouble(recuadro3.getText().toString()));
			} else if (btg.getSelection().getActionCommand() == "Ahorro") {
				etiqueta5.setText("" + tem);
				envio_A.addclient(tem, recuadro1.getText(),	recuadro2.getText(), Double.parseDouble(recuadro3.getText().toString()), -1);
			}
		} else if (e.getActionCommand() == "Ok") {
			envio_A.busnoap(recuadrof21.getText());
			recuadrof22.setText(envio_A.nombre);
			recuadrof23.setText(envio_A.apellido);
		} else if (e.getActionCommand() == "Listo") {
			envio_A.upclient(recuadrof22.getText(), recuadrof23.getText(),recuadrof21.getText());
		} else if (e.getActionCommand() == "cancel") {
			System.exit(0);
		}
	}
}
