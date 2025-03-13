import java.util.Timer;

import javax.print.attribute.standard.JobImpressions;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Phone extends JFrame {
	private boolean ringing;
	private PhoneRinger task;
	private Timer timer;
	JButton btnIniciar;

	public Phone() {
		timer = new Timer(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		btnIniciar = new JButton("Iniciar(i)");
		btnIniciar.setMnemonic('i');
		btnIniciar.addActionListener(e -> {
			startRinging();
			btnIniciar.setEnabled(false);
			try {
				System.out.println("Phone started ringing...");
				Thread.sleep(33000);
			} catch (InterruptedException e) {
			}

			System.out.println("Answering the phone...");
			phone.answer();
		});
		getContentPane().add(btnIniciar);
		setVisible(true);
		this.pack();
	}

	public boolean isRinging() {
		return ringing;
	}

	public void startRinging() {
		ringing = true;
		task = new PhoneRinger();
		timer.scheduleAtFixedRate(task, 0, 1000);
	}

	public void answer() {
		ringing = false;
		System.out.println("Phone rang " + task.getRingCount() + " times");
		task.cancel();
		btnIniciar.setEnabled(true);
	}

	public static void main(String[] args) {
		Phone phone = new Phone();
		// phone.startRinging();

		// try {
		// System.out.println("Phone started ringing...");
		// Thread.sleep(33000);
		// } catch (InterruptedException e) {
		// }

		// System.out.println("Answering the phone...");
		// phone.answer();
	}
}
