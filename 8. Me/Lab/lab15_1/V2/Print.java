import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.DefaultCaret;

public class Print extends JFrame {

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> {
            Print app = new Print();
        });
    }
//suspender, reasumir, stop
//
//top: pones el hilo a null
    private JTextArea JTArea;
    private JButton btnIniciar, btnClear, btnStop;
    private JLabel label;
    private JScrollPane JScroll;
    private JTextField JTField;
    private Thread process;

    public Print() {
        this.setTitle("Lab 1 - Print");
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
            SwingUtilities.updateComponentTreeUI(this);
        } catch (Exception e) {
            System.out.println("No se pudo configurar la apariencia");
        }

        initComponents();
    }

    private void initComponents() {

        JPanel Jpanel = new JPanel(new BorderLayout());
        EmptyBorder padding = new EmptyBorder(5, 5, 5, 5);
        Jpanel.setBorder(padding);
        JPanel jpanelS = new JPanel();

        JTArea = new JTextArea("", 6, 30);
        JTArea.setEditable(false);
        DefaultCaret caret = (DefaultCaret) JTArea.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        JScroll = new JScrollPane(JTArea, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        JScroll.setViewportView(JTArea);

        JTField = new JTextField(10);
        JTField.requestFocusInWindow();
        JTField.selectAll();
        label = new JLabel("Milisegundos:");

        double inc = 1; //tamaño de la imagen, seria como el % en css
        // ImageIcon imagen = new ImageIcon("Icon.png");

        btnIniciar = new JButton("Run (r)");
        // btnIniciar.setIcon(new ImageIcon(imagen.getImage().getScaledInstance((int) (imagen.getIconWidth() * inc), (int) (imagen.getIconHeight() * inc), Image.SCALE_SMOOTH)));

        btnIniciar.setMnemonic('r');
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inicioActionPerformed(evt);
            }
        });

        btnClear = new JButton();
        btnClear.setText("Clear (c)");
        btnClear.setMnemonic('c');
        btnClear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limpiarActionPerformed(evt);
            }
        });

        btnStop = new JButton("Stop (s)");
        btnStop.setMnemonic('s');
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
							// process.;
            }            
        });

        Jpanel.add(JScroll, BorderLayout.CENTER);

        jpanelS.add(label);
        jpanelS.add(JTField);
        jpanelS.add(btnIniciar);
        jpanelS.add(btnClear);
        jpanelS.add(btnStop);
        Jpanel.add(jpanelS, BorderLayout.SOUTH);
        this.getContentPane().add(Jpanel);

        this.setResizable(false);
        this.setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    private void inicioActionPerformed(java.awt.event.ActionEvent evt) {
        JTArea.setText(""); //limpiando campo texto

        Thread tmp = new Thread(() -> {
            int time = 0;
            String text = JTField.getText();

            try {
                time = Integer.parseInt(text);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un numero");
                JTField.setText("");
            }

            if (time <= 0) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor mayor que cero");
                JTField.setText("");
            } else if (time > 0) {
                btnIniciar.setEnabled(false);
                btnClear.setEnabled(false);
                PrintNumbers printNumbers = new PrintNumbers(this);
                //iniciando hilo
                // Thread t1 = new Thread(printNumbers);
                process = new Thread(printNumbers);
                process.start();
                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                }

                printNumbers.stopPrinting();
            }
        });

        tmp.start();
    }

    public JTextArea getArea() {
        return JTArea;
    }

    public JButton getInicio() {
        return btnIniciar;
    }

    public JButton getLimpiar() {
        return btnClear;
    }

    private void limpiarActionPerformed(java.awt.event.ActionEvent evt) {
        JTField.setText("");
        JTArea.setText("");
    }
}
