package ClasesYObjetos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ImageIcon;
import JButton;
import JFrame;
import JLabel;
import JPanel;
import JTextArea;
import JTextField;

public class VentanaUsuario extends JFrame implements ActionListener {

    private JPanel panelFondo;
    private JTextField caja1;
    private JButton btDepositar, btRetirar, btEstado, btTransferir;
    private JTextArea area1;
    private BaseCuentas base;
    private int id;

    public VentanaUsuario(BaseCuentas base, int id) {
        this.id = id;
        this.base = base;
        this.setBounds(50, 50, 1000, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("                                                                                                                      BANCO ESTUDIANTIL FIEC");
        panelFondo = new JPanel();
        panelFondo.setLayout(null);
        this.getContentPane().add(panelFondo);

        colocarComponentes();

    }

    public void colocarComponentes() {
        colocarPanel();
        colocarBotones();

        colocarCajaTexto();
        colocarAreaTexto();
    }

    public void colocarPanel() {
        ImageIcon foto = new ImageIcon("imagenFondo.jpg");
        JLabel etiqueta = new JLabel();
        etiqueta.setBounds(0, 0, this.getWidth(), this.getHeight());
        etiqueta.setIcon(new ImageIcon(foto.getImage().getScaledInstance(this.getWidth(), etiqueta.getHeight(), Image.SCALE_SMOOTH)));
        panelFondo.add(etiqueta);
    }

    private void colocarBotones() {
        btDepositar = new JButton("Depositar");
        btDepositar.setBounds(145, 200, 150, 60);
        btDepositar.setEnabled(true);
        btDepositar.setFont(new Font("arial", Font.BOLD, 14));
        btDepositar.addActionListener(this);
        panelFondo.add(btDepositar);

        btRetirar = new JButton("Retirar");
        btRetirar.setBounds(145, 334, 150, 60);
        btRetirar.setEnabled(true);
        btRetirar.setFont(new Font("arial", Font.BOLD, 14));
        btRetirar.addActionListener(this);
        panelFondo.add(btRetirar);

        btEstado = new JButton("Estado");
        btEstado.setBounds(684, 200, 150, 60);
        btEstado.setEnabled(true);
        btEstado.setFont(new Font("arial", Font.BOLD, 14));
        btEstado.addActionListener(this);
        panelFondo.add(btEstado);

        btTransferir = new JButton("Transferir");
        btTransferir.setBounds(684, 334, 150, 60);
        btTransferir.setEnabled(false);
        btTransferir.setFont(new Font("arial", Font.BOLD, 14));
        panelFondo.add(btTransferir);
    }

    private void colocarCajaTexto() {
        caja1 = new JTextField();
        caja1.setBounds(230, 440, 539, 60);
        panelFondo.add(caja1);
    }

    public void colocarAreaTexto() {
        area1 = new JTextArea();
        area1.setBounds(300, 180, 380, 190);
        area1.setEditable(false);//perimte que se edite el texto que aparecia al principo 
        panelFondo.add(area1);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btDepositar) {
            area1.setText("");
            System.out.println("Deposito es cliqueado");
            area1.append("\nSaldo Anterio" + base.arregloCuentas.get(base.getIndice(id)).getSaldo());
            Thread hiloDeposita = new HiloDeposita(base, Double.parseDouble(caja1.getText()), id);
            hiloDeposita.start();
            area1.append("\nDeposito: " + caja1.getText());
            area1.append("\nNuevo saldo" + base.arregloCuentas.get(base.getIndice(id)).getSaldo());

        }//btDepositar
        if (e.getSource() == btRetirar) {
            area1.setText("");
            System.out.println("Retiro es cliqueado");
            area1.append("\n  Saldo Anterior: " + base.arregloCuentas.get(base.getIndice(id)).getSaldo());
            Thread hiloRetira = new HiloRetira(base, Double.parseDouble(caja1.getText()), id);
            hiloRetira.start();
            area1.append("\nDeposito: " + caja1.getText());
            area1.append("\nNuevo saldo" + base.arregloCuentas.get(base.getIndice(id)).getSaldo());
        }//btRetirar

        if (e.getSource() == btEstado) {
            area1.setText("");
            area1.append("Estado de cuenta ");
            area1.append("\nNombre:  " + base.arregloCuentas.get(base.getIndice(id)).getNombre() + "Cuenta: " + base.arregloCuentas.get(base.getIndice(id)).getCuentaId() + "  Tipo:  " + base.arregloCuentas.get(base.getIndice(id)).getTipoCuenta() + "    Saldo:  " + base.arregloCuentas.get(base.getIndice(id)).getSaldo());
        }//btEstado
    }

}
