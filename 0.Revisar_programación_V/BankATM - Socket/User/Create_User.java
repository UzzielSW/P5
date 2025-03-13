
import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Create_User extends JDialog implements ActionListener, ItemListener {
  JTabbedPane jtbadduser, jtbsett;
  JPanel pnladd, pnlsetadm, pnlsetus, pnldat, pnlsetadm2, pnlsetadm1, pnlsetus2;
  JLabel jlnombre, jlapellido, jlncuenta, jlapertura, jluser, jlkey, jlkey2, jlcod, jlcorrnom, jlcorap, jltext;
  JTextField jtxtnombre, jtxtapellido, jtxtncuenta, jtxtapertura, jtxtuser, jtxtnombre2, jtxtapellido2,
      jtxtcodcuenta2;
  JPasswordField jptxtkey, jptxtkey2;
  JRadioButton rbcorr, rbahorro;
  JButton jbtnagregar, jbtncancelar, jbtncambiar, jbtnok, jbtnlisto;
  String TCuenta;
  private Cliente Cliente;

  private BankAtmSwing bank;

  private int a = 0, h, s;
  private int cuenta, vcuenta, x = 0;
  private int p;
  private long tem;
  private static String cambia_nombre, cambia_apellido;
  String passkey;

  public Create_User() {
    passkey = "AdminKey";
    Cliente = new Cliente();
    tem = Math.round(Math.random() * 999 + 100);
  }

  public void LaunchFrame() {

    setTitle("Adding Customer");
    Container contenedor = getContentPane();
    jtbadduser = new JTabbedPane();
    jtbsett = new JTabbedPane();
    jtbsett.setTabPlacement(JTabbedPane.LEFT);

    pnladd = new JPanel(new GridLayout(6, 2));
    pnlsetadm = new JPanel(new BorderLayout());
    pnlsetadm2 = new JPanel(new GridLayout(4, 1));
    pnlsetadm1 = new JPanel();
    pnlsetus = new JPanel(new BorderLayout());
    pnlsetus2 = new JPanel(new BorderLayout());

    pnldat = new JPanel(new GridLayout(2, 2));

    // Creacion de los Labels

    jlnombre = new JLabel(" Name ");
    jtxtnombre = new JTextField(20);
    jlapellido = new JLabel(" Last Name ");
    jtxtapellido = new JTextField(20);
    jlncuenta = new JLabel(" Number Account ");
    jtxtncuenta = new JTextField(20);
    jlapertura = new JLabel(" Opening ");
    jtxtapertura = new JTextField(20);
    jluser = new JLabel(" Change User to: ");
    jtxtuser = new JTextField(20);
    jlkey = new JLabel(" Password ");
    jptxtkey = new JPasswordField(20);
    jlkey2 = new JLabel(" New Password: ");
    jptxtkey2 = new JPasswordField(20);
    jlcod = new JLabel(" Introduce Number Account ");
    jtxtcodcuenta2 = new JTextField(20);
    jlcorrnom = new JLabel(" Change Name: ");
    jtxtnombre2 = new JTextField(20);
    jtxtapellido2 = new JTextField(20);
    jlcorap = new JLabel(" Change Last Name: ");
    jltext = new JLabel(" Please save before exit ");

    rbcorr = new JRadioButton(" Regular Account ", true);

    rbahorro = new JRadioButton(" Saving Account ", false);

    jbtnagregar = new JButton("Add");
    jbtncancelar = new JButton("Cancel");
    jbtncambiar = new JButton("Change");
    jbtnok = new JButton("OK");
    jbtnlisto = new JButton("Ready");

    pnladd.add(jlnombre);
    pnladd.add(jtxtnombre);

    pnladd.add(jlapellido);
    pnladd.add(jtxtapellido);

    pnladd.add(jlncuenta);
    pnladd.add(jtxtncuenta);

    pnladd.add(jlapertura);
    pnladd.add(jtxtapertura);

    // Incorporacion de los paneles

    JPanel RBott = new JPanel(new FlowLayout());
    RBott.add(rbcorr);
    RBott.add(rbahorro);

    JPanel Bott = new JPanel(new FlowLayout());
    Bott.add(jbtnagregar);
    Bott.add(jbtncancelar);

    JPanel Botts = new JPanel(new BorderLayout());
    Botts.add(RBott, BorderLayout.NORTH);
    Botts.add(Bott, BorderLayout.CENTER);

    JPanel Complete = new JPanel(new BorderLayout());

    Complete.add(pnladd, BorderLayout.NORTH);
    Complete.add(Botts, BorderLayout.CENTER);

    JPanel F1 = new JPanel(new GridLayout(1, 2));
    F1.add(jluser);
    F1.add(jtxtuser);

    JPanel F2 = new JPanel(new GridLayout(1, 2));
    F2.add(jlkey);
    F2.add(jptxtkey);

    JPanel F3 = new JPanel(new GridLayout(1, 2));
    F3.add(jlkey2);
    F3.add(jptxtkey2);

    pnlsetadm2.add(F1);
    pnlsetadm2.add(F2);
    pnlsetadm2.add(F3);

    pnlsetadm1.add(jbtncambiar);

    JPanel top2 = new JPanel(new FlowLayout());
    top2.add(jtxtcodcuenta2);
    top2.add(jbtnok);

    JPanel textnom = new JPanel(new FlowLayout());
    textnom.add(jtxtnombre2);
    JPanel textap = new JPanel(new FlowLayout());
    textap.add(jtxtapellido2);
    JPanel textre = new JPanel(new FlowLayout());
    textre.add(jbtnlisto);

    JPanel Med = new JPanel(new GridLayout(8, 1));

    Med.add(jlcod);
    Med.add(top2);
    Med.add(jlcorrnom);
    Med.add(textnom);
    Med.add(jlcorap);
    Med.add(textap);
    Med.add(textre);
    Med.add(jltext);

    pnlsetus2.add(Med, BorderLayout.NORTH);

    pnlsetadm.add(pnlsetadm2, BorderLayout.NORTH);
    pnlsetadm.add(pnlsetadm1, BorderLayout.CENTER);

    pnlsetus.add(jlcod, BorderLayout.NORTH);
    pnlsetus.add(pnlsetus2, BorderLayout.CENTER);

    ButtonGroup grupo = new ButtonGroup();
    grupo.add(rbcorr);
    grupo.add(rbahorro);

    jtbadduser.addTab(" Add Customer ", Complete);
    jtbsett.addTab("User Settings ", pnlsetus);
    jtbsett.addTab("Administrator Settings ", pnlsetadm);
    jtbadduser.addTab(" Settings ", jtbsett);
    contenedor.add(jtbadduser);

    setSize(500, 350);
    setLocation(440, 200);
    setResizable(true);
    setVisible(true);

    // Implantacion de los Escuchas

    jbtnagregar.addActionListener(this);
    jbtncancelar.addActionListener(this);
    jbtncambiar.addActionListener(this);

    rbcorr.addItemListener(this);
    rbahorro.addItemListener(this);
    jbtnlisto.addActionListener(this);
    jbtnok.addActionListener(this);

    jbtnlisto.setEnabled(false);
    jtxtnombre2.setEnabled(false);
    jtxtapellido2.setEnabled(false);

    jtxtncuenta.setText("" + tem);
    jtxtncuenta.setEnabled(false);

    jtxtnombre.setText("");
    jtxtapellido.setText("");

    jtxtapertura.setText("");
    jtxtapellido2.setText("");
    jtxtnombre2.setText("");

    jtxtuser.setText("");
    jptxtkey.setText("");
    jptxtkey2.setText("");

  }

  // * Metodo para retornar la clave de administrador*/
  public String Key1() {
    return passkey;
  }

  // * Metodo de evento para los ItemListener*/
  public void itemStateChanged(ItemEvent r) {

    if (r.getSource().equals(rbcorr)) {

      p = 0;
    } else if (r.getSource().equals(rbahorro)) {

      p = 1;
    }
  }

  // * Metodo de eventos para los botones */
  public void actionPerformed(ActionEvent e) {

    if (e.getSource().equals(jbtnok)) {
      // Metodo de busqueda del usuario n para cambiar datos
      Cliente.Client("search", jtxtcodcuenta2.getText(), null, null, null, null);

      jtxtnombre2.setText(Cliente.Client("client_info", jtxtcodcuenta2.getText(), null, null, null, null));
      jtxtapellido2.setText(Cliente.Client("client_info", jtxtcodcuenta2.getText(), null, null, null, null));
      jtxtnombre2.setEnabled(true);
      jtxtapellido2.setEnabled(true);
      jbtnlisto.setEnabled(true);

    }

    // evento para cambiar contrasea de administrador

    if (e.getSource().equals(jbtncambiar)) {

      passkey = (String.valueOf(jptxtkey2.getPassword()));
      JOptionPane.showMessageDialog(this, "  Administrator Password changed ", "Information",
          JOptionPane.INFORMATION_MESSAGE);
      this.setVisible(false);

    }
    // evento para editar datos del usuario n
    if (e.getSource().equals(jbtnlisto)) {

      cambia_nombre = jtxtnombre2.getText();
      cambia_apellido = jtxtapellido2.getText();
      String Change = Cliente.Client("update_client", jtxtcodcuenta2.getText(), cambia_nombre, cambia_apellido,
          null, null);
      JOptionPane.showMessageDialog(null, "Change user info: " + Change, "Information",
          JOptionPane.INFORMATION_MESSAGE);
      this.setVisible(false);

    }

    if (e.getSource().equals(jbtncancelar)) {
      this.setVisible(false);

    }

    // Evento para aadir un nuevo cliente o usuario a la lista
    if (e.getActionCommand().equals("Add"))

    {
      if (p == 0) {
        TCuenta = "Corriente";
      } else {
        TCuenta = "Ahorro";
      }
      Cliente.Client("add_client", "" + tem, jtxtnombre.getText(), jtxtapellido.getText(), TCuenta,
          jtxtapertura.getText());
      JOptionPane.showMessageDialog(this, "  Customer Added: " + jtxtnombre.getText());

      long tem1 = Math.round(Math.random() * 999 + 100);
      jtxtncuenta.setText("" + tem1);

      this.setVisible(false);
    }
  }

  public static void main(String[] args) {
    Create_User user = new Create_User();
    user.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    user.LaunchFrame();
    user.setLocationRelativeTo(null);
  }
}
