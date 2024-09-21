import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.Buffer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

/******************************************************************************
 * Clase BufferTest
 * 
 * Creamos un hilo productor y otro consumidor que comparten
 * el recurso compartido de tipo buffer de mensajes Buffer.
 * 
 ******************************************************************************/

public class BufferTest extends JFrame implements ActionListener {

	public static void main(String[] args) {
		BufferTest bt = new BufferTest();
		// bt.mensaje();
	}

	private ThreadGroup g1;
	private boolean done;
	private Buffer buf;
	private Thread[] thread = new Thread[2];
	public JTextField jtfProductor, jtfBuffer, jtfConsumidor;
	public JButton btnIniciar, btnParar, btnSuspender, btnReanudar, btnClear;

	public BufferTest() {
		initComponents();
		configJFrame();
	}

	private void configJFrame() {
		this.setTitle("Productor - Consumidor");

		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
			SwingUtilities.updateComponentTreeUI(this);
		} catch (Exception e) {
			System.out.println("No se pudo configurar la apariencia");
		}

		this.setResizable(false);
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private void initComponents() {
		JPanel panel = new JPanel(new BorderLayout());
		EmptyBorder padding = new EmptyBorder(5, 5, 5, 5);
		panel.setBorder(padding);

		JPanel jpanelC = new JPanel();
		JPanel jpanelS = new JPanel();

		JLabel titulo = new JLabel("- Productor/Consumidor con Buffer -");

		JLabel jlProductor = new JLabel("Productor: ");
		JLabel jlBuffer = new JLabel("Buffer: ");
		JLabel jlConsumidor = new JLabel("Consumidor: ");

		jtfProductor = new JTextField(10);
		jtfBuffer = new JTextField(10);
		jtfConsumidor = new JTextField(10);

		btnIniciar = new JButton("Iniciar");
		btnIniciar.setMnemonic('i');
		btnIniciar.addActionListener(this);

		btnParar = new JButton("Parar");
		btnParar.setMnemonic('p');
		btnParar.addActionListener(this);

		btnSuspender = new JButton("Suspender");
		btnSuspender.setMnemonic('s');
		btnSuspender.addActionListener(this);

		btnReanudar = new JButton("Reanudar");
		btnReanudar.setMnemonic('r');
		btnReanudar.addActionListener(this);

		btnClear = new JButton("Clear");
		btnClear.setMnemonic('c');
		btnClear.addActionListener(this);

		// LAYOUTS

		// panel central
		jpanelC.add(jlProductor);
		jpanelC.add(jtfProductor);

		jpanelC.add(jlBuffer);
		jpanelC.add(jtfBuffer);

		jpanelC.add(jlConsumidor);
		jpanelC.add(jtfConsumidor);

		// panel Sur
		jpanelS.add(btnIniciar);
		jpanelS.add(btnParar);
		jpanelS.add(btnSuspender);
		jpanelS.add(btnReanudar);
		jpanelS.add(btnClear);

		// panel principal
		panel.add(titulo, BorderLayout.NORTH);
		panel.add(jpanelC, BorderLayout.CENTER);
		panel.add(jpanelS, BorderLayout.SOUTH);
		// this.getContentPane().add(Jpanel);
		this.add(panel);
	}

	private void Iniciar() {
		Thread tmp = new Thread(() -> {
			g1 = new ThreadGroup("group");
			done = false;

			buf = new Buffer();

			// Productor p1 = new Productor(buf, 1);
			thread[0] = new Thread(g1, new Productor(buf, 1), "t");
			thread[0].start();
			// Consumidor c1 = new Consumidor(buf, 1);
			thread[1] = new Thread(g1, new Consumidor(buf, 1), "t");
			thread[1].start();
			while (!done)
				if (g1.activeCount() == 0)
					done = true;
		}).start();
	}

	public void mensaje() {
		System.out.println("\n\nTodos los hilos han terminado, fin del main() ");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnIniciar) {
			// Iniciar();
		} else if (e.getSource() == btnParar) {
			System.out.println("Parar");
		} else if (e.getSource() == btnSuspender) {
			System.out.println("Suspender");
		} else if (e.getSource() == btnReanudar) {
			System.out.println("Reanudar");
		} else if (e.getSource() == btnClear) {
			System.out.println("Clear");
		}
	}
}
