
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Semaforo extends JApplet implements ActionListener {
	private Light light;
	private JButton jbRed, jbYellow, jbGreen;

	public void init() {
		light = new Light();
		jbRed = new JButton("R");
		jbYellow = new JButton("Y");
		jbGreen = new JButton("G");

		jbRed.setMnemonic('r');
		jbYellow.setMnemonic('y');
		jbGreen.setMnemonic('g');

		jbRed.addActionListener(this);
		jbYellow.addActionListener(this);
		jbGreen.addActionListener(this);

		JPanel jpanel = new JPanel();

		jpanel.add(jbRed);
		jpanel.add(jbYellow);
		jpanel.add(jbGreen);

		JPanel jpCentro = new JPanel();
		jpCentro.add(light);

		add(jpCentro, BorderLayout.CENTER);
		add(jpanel, BorderLayout.SOUTH);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == jbRed) {
			light.turnOnRed();
			jbRed.setEnabled(false);
			jbYellow.setEnabled(true);
			jbGreen.setEnabled(true);
		} else if (e.getSource() == jbYellow) {
			light.turnOnYellow();
			jbRed.setEnabled(true);
			jbYellow.setEnabled(false);
			jbGreen.setEnabled(true);
		} else if (e.getSource() == jbGreen) {
			light.turnOnGreen();
			jbRed.setEnabled(true);
			jbYellow.setEnabled(true);
			jbGreen.setEnabled(false);
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("Semaforo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		Semaforo applet = new Semaforo();
		frame.add(applet);
		applet.init();
		frame.pack();
		frame.setVisible(true);
	}
}