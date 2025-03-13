
// TODO: organizar el codigo y la logica de la GUI
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class NewMain extends JFrame implements ActionListener {

    public static void main(String[] args) {
        NewMain frame = new NewMain();
    }

    private JPanel panelCenter, panelBottom;
    private JLabel jLabel1, jLabel2;
    private JTextField textField1, textField2;
    private TextArea textArea, textArea2;
    private JButton btnStart;
    private MyFabrica fabrica;

    public NewMain() {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(900, 400);
        setTitle("fabrica papel");

        setLayout(new BorderLayout());

        Font font = new Font("Arial Calligraphy", Font.BOLD, 18);

        panelBottom = new JPanel();
        panelBottom.setLayout(new FlowLayout(FlowLayout.LEFT));
        jLabel1 = new JLabel("cajas ");
        jLabel1.setFont(font);

        textField1 = new JTextField(10);
        textField1.setFont(font);

        jLabel2 = new JLabel("papel por caja");
        jLabel2.setFont(font);

        textField2 = new JTextField(10);
        textField2.setFont(font);

        textArea = new TextArea();
        textArea.setFont(font);
        textArea.setText("");

        textArea2 = new TextArea();
        textArea2.setFont(font);

        btnStart = new JButton("Start(s)");
        btnStart.addActionListener(this);
        btnStart.setMnemonic('s');
        btnStart.setFont(font);

        panelBottom.add(textField1);
        panelBottom.add(jLabel1);
        panelBottom.add(textField2);
        panelBottom.add(jLabel2);
        panelBottom.add(btnStart);
        panelBottom.setBackground(new Color(143, 177, 232));

        panelCenter = new JPanel(new GridLayout(1, 2));

        textArea2.setEditable(false);
        textArea.setEditable(false);
        textArea2.setFocusable(false);
        textArea.setFocusable(false);

        panelCenter.add(textArea);
        panelCenter.add(textArea2);
        add(panelCenter, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public boolean check() {
        if (textField1.getText().equals("") || textField2.getText().equals("")) {
            return false;
        }
        return true;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnStart && check()) {
            textArea.setText("");
            textArea2.setText("");
            btnStart.setEnabled(false);
            fabrica = new MyFabrica(Integer.parseInt(textField1.getText()),
                    Integer.parseInt(textField2.getText()),
                    textArea, textArea2);

            fabrica.start();

            try {
                fabrica.join();
            } catch (InterruptedException ex) {
            }

            btnStart.setEnabled(true);
        }
    }
}