/*
hay dos comportamientos:
1. Que al acortar la ventana estos se acomoden en la ventana hacia abajo lo que seria los correcto. Esto pasa por defecto al usar los JPanel y sin importar la clase de FlowLayout. Tambien pasa si le asignas al JFrame el FlowLayout y pones los elementos encima del frame. pero si los pones dentro de los JPanel estos como que entran en conflicto y pasa el siguiente comportamiento.
2. al acortar la ventana estos no se acomodan sino que dejan de verse. esto pasa cuando importas la clase de FlowLayout y agregar los elementos al panel.
*/
import java.awt.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FlowLayoutDemo extends JFrame {
	JPanel panel;

	public FlowLayoutDemo(String t) {
		super(t);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		panel = new JPanel();

		panel.add(new JLabel("Enter name here:"));
		panel.add(new JTextField(20));
		panel.add(new JCheckBox("Pick me", true));

		panel.add(new JButton("Red"));
		panel.add(new JButton("Blue"));
		panel.add(new JButton("White"));

		List list = new List();
		for (int i = 0; i < 10; i++) {
			list.add("Item" + i);
		}
		panel.add(list);
		getContentPane().add(panel);

		pack();
	}

	public static void main(String[] args) {
		FlowLayoutDemo f = new FlowLayoutDemo("FlowLayout demo");
		f.setVisible(true);
	}
}
