import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Juego extends JFrame implements Runnable, MouseListener {
	Image imagen;
	int posicionx;
	int posiciony;
	int tamx;
	int tamy;
	int aux1;
	int aux2;

	private JTextField campopunto;
	private JTextField campovelocidad;
	private JLabel label1, label2;
	private JPanel panelsur;
	int punto = 0;
	int velocidad = 1000;
	int nuevavelocidad;

	public Juego() {
		campopunto = new JTextField(20);
		campopunto.setEditable(false);
		campovelocidad = new JTextField("Incrementar");
		campovelocidad.addActionListener(new ActionListener()

		{
			public void actionPerformed(ActionEvent e) {

			}
		});
		panelsur = new JPanel();
		label1 = new JLabel("Puntos: ");
		label2 = new JLabel("Velocidad: ");

		Container c = getContentPane();

		panelsur.add(label1);
		panelsur.add(campopunto);
		panelsur.add(label2);
		panelsur.add(campovelocidad);
		c.add(panelsur, BorderLayout.SOUTH);
		setSize(700, 500);
		setVisible(true);
	}

	public void run() {

		while (true) {

			double posx = Math.random() * 500;
			aux1 = (int) posx;

			double posy = Math.random() * 400;
			aux2 = (int) posy;

			double tamanox = Math.random() * 80;
			tamx = (int) tamanox;

			double tamanoy = Math.random() * 80;
			tamy = (int) tamanoy;

			try {
				Thread.sleep(velocidad);
			} catch (InterruptedException ie) {
			}

		}

	}

	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(Color.BLUE);
		// g.fillRect(aux1,aux2,tamx,tamy);
		g.fillRect(aux1, aux2, 80, 80);
		try {
			Thread.sleep(165);
		} catch (InterruptedException ie) {
		}
		addMouseListener(this);

		repaint();

	}

	public void mouseClicked(MouseEvent e) {
		int nuevop1 = 80 + aux1;
		int nuevop2 = aux2 + 80;
		int nuevop3 = nuevop2 + 80;

		if (((e.getX() >= aux1) && (e.getX() <= nuevop1)) || ((e.getY() >= aux2) && (e.getY() <= nuevop2)) &&
				((e.getX() >= nuevop2) && (e.getX() <= nuevop3)) || ((e.getY() >= nuevop1) && (e.getY() <= nuevop3))) {

			punto += 10;
			String aux = "" + punto;
			System.out.println("puntos:" + aux);
			campopunto.setText(aux);

		}

	}

	public void mouseDragged(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseMoved(MouseEvent e) {
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}

	public static void main(String args[]) {
		Juego juego = new Juego();
		Thread t = new Thread(juego);
		t.start();

	}

}