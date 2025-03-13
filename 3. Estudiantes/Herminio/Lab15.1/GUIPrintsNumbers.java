import javax.swing.*;
import java.awt.*;

public class GUIPrintsNumbers extends JFrame implements Runnable {
	private boolean keepGoing;
	private JTextArea textArea;
	private JScrollPane scroll;

	public GUIPrintsNumbers() {
		super("Print Numbers");
		keepGoing = true;
		textArea = new JTextArea(15, 15);
		textArea.setEditable(false);
		scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
		getContentPane().add(scroll);
		pack();
		setVisible(true);
	}

	public void stopPrinting() {
		keepGoing = false;
	}

	public void run() {
		int i = 0;
		while (keepGoing) {
			try {
				i = i + 1;
				textArea.setText(textArea.getText() + "\n" + i);
				Thread.sleep(1000);
			} catch (InterruptedException ie) {
			}
		}
	}
}
