//J
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class NewMain extends JPanel implements ActionListener {

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(900, 400);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.add(new NewMain());
        frame.setVisible(true);
        frame.setTitle("fabrica papel");
    }

    private JPanel panelBottom;
    private JLabel jLabel1, jLabel2;
    private JTextField textField1, textField2;
    private TextArea textArea, textArea2;
    private JButton btnStart;
    private MyFabrica fabrica;
    private JPanel panelCenter;

    public NewMain() {
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

        btnStart = new JButton("Start");
        btnStart.addActionListener(this);
        btnStart.setFont(font);

        panelBottom.add(textField1);
        panelBottom.add(jLabel1);
        panelBottom.add(textField2);
        panelBottom.add(jLabel2);
        panelBottom.add(btnStart);
        panelBottom.setBackground(new Color(143, 177, 232));

        panelCenter = new JPanel(new GridLayout(1, 2));
        panelCenter.add(textArea);
        panelCenter.add(textArea2);
        add(panelCenter, BorderLayout.CENTER);
        add(panelBottom, BorderLayout.SOUTH);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object objectComponent = e.getSource();
        if (objectComponent == btnStart) {
            fabrica = new MyFabrica(Integer.parseInt(textField1.getText()), Integer.parseInt(textField2.getText()), textArea, textArea2);
        }
    }

}
