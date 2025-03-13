import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Email extends JFrame {
	JTextField user_name, host_name, password;
	public boolean correcto;

	public Email() {
		super("Hosting Email Kanbate kudasae");// Un poco de clase pasada
		JLabel usuario = new JLabel("Usuario");// algo de lo del api
		JLabel hosting = new JLabel("correo");
		JLabel pass = new JLabel("pass");
		JButton signin = new JButton("Sign In");
		signin.addActionListener(// jajaja otro actionListener...un poco adelantado
				new ActionListener() {
					public void actionPerformed(ActionEvent Evento) {
						entrada_validar();
					}
				});
		user_name = new JTextField(15);// comos siempre se crean los elementos
		host_name = new JTextField(15);
		password = new JTextField(15);
		JPanel principal = new JPanel();// los paneles que los contendran
		JPanel secundario = new JPanel();
		JPanel terceario = new JPanel();
		principal.add(usuario);// se mete todo en sus contenedres
		principal.add(user_name);
		secundario.add(hosting);
		secundario.add(host_name);
		terceario.add(pass);
		terceario.add(password);
		JPanel botones = new JPanel();
		botones.add(signin);
		Container ventana = getContentPane();// la ventana al fin
		ventana.setLayout(new GridLayout(6, 1));// estilo de ventana
		ventana.add(principal);// y todo adentro
		ventana.add(secundario);
		ventana.add(terceario);
		ventana.add(botones);
		setSize(300, 230);
		setVisible(true);
	}

	public void entrada_validar() {
		if (user_name.getText().equals("") || host_name.getText().equals("") || password.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Debe llenar todos las casillas");
			return;
		} else if (!user_name.getText().matches("([a-zA-Z]*+(\\.[a-zA-Z]+))+|[a-zA-Z]*")) {
			// algo de expresiones regulares basicas...
			JOptionPane.showMessageDialog(this, "Nombre de usuario Invalido");
			return;
		} else if (!host_name.getText().matches("\\@+[a-zA-Z]*+\\.[a-z]+")) {
			// y pensar que me tomo toda la maana pensar en esa logica...
			JOptionPane.showMessageDialog(this, "Host Invalido");
			return;
		} // un toque de teorica... bestia!!!!
		correcto = true;
		JOptionPane.showMessageDialog(this, "Expresion bien formada");
		JOptionPane.showMessageDialog(this, user_name.getText() + host_name.getText());
		return;
	}

}
