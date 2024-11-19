import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class EjemploFuenteBase {
    public static void main(String[] args) {
        // Establecer la fuente base
        Font fuenteBase = new Font("Arial", Font.PLAIN, 54);
        UIManager.put("Label.font", fuenteBase);
        UIManager.put("Button.font", fuenteBase);
        UIManager.put("TextField.font", fuenteBase);
        
        // Crear un marco
        JFrame frame = new JFrame("Ejemplo de Fuente Base");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // Agregar componentes
        JLabel label = new JLabel("Este es un label");
        JButton button = new JButton("Este es un botón");
        JTextField textField = new JTextField(15);

        frame.add(label);
        frame.add(button);
        frame.add(textField);

        // Configurar el tamaño y mostrar el marco
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}