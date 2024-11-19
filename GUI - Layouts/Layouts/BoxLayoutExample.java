import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BoxLayoutExample extends JFrame implements ActionListener {

	public JTextField txF;
	public JButton btn;
	public JCheckBox check;

	public BoxLayoutExample(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		panel.add(new JLabel("Enter your name:"));
		txF = new JTextField(10);
		panel.add(txF);
		check = new JCheckBox("Check here");
		panel.add(check);
		btn = new JButton("Click here to continue");
		btn.setMnemonic('c');
		btn.addActionListener(this);
		panel.add(btn);

		getContentPane().add(panel);
		pack();
		setVisible(true);
	}

	public static void main(String[] args) {
		BoxLayoutExample f = new BoxLayoutExample("BoxLayoutDemo");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn) {
			String tx = txF.getText();
			if (check.isSelected())
				tx = tx.toUpperCase();
			JOptionPane.showMessageDialog(this, tx);
		}
	}
}
