
import java.io.*;
import java.net.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class BankAtmSwing extends JFrame implements ActionListener, Runnable {
  private int l, ll, i = 0, claveid, vcuenta, cuenta, acciontype = 0;

  private String monto;
  private int b1 = 0, b2 = 0;
  private static int pos = 0, pos1 = 0, valor_posicion = 0;
  private static String clavee;
  private JTextArea jtA;
  private JPasswordField jtfDataE;
  private JTextField jtfMsn;
  private JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7;
  private JButton jb8, jb9, jb0, jbEnter, jbClear;
  private JButton jbDisplay;
  private JButton jbDeposit;
  private JButton jbWithdraw;
  private JFrame Ventana = new JFrame("Banco A&B");
  private JDialog JD;
  public Create_User crea_usuario;
  public ViewAccounts ver;

  JLabel jlUser, jlPassword;
  JTextField jtUser;
  JPasswordField jtPassword;
  JButton jbLogin, jbCancel;
  String clave;
  String amount;
  static String cambia_nombrea, cambia_apellidoa;
  private Cliente Cliente;
  private boolean first, test;
  boolean isValido = false;
  private static String codeC = null;

  public BankAtmSwing() {
    Cliente = new Cliente();
    crea_usuario = new Create_User();
    setTitle("BankATM");
    jtA = new JTextArea(10, 75);
    jtfDataE = new JPasswordField(10);
    jtfDataE.setHorizontalAlignment(JTextField.RIGHT);
    jtfMsn = new JTextField(75);
    jbDisplay = new JButton("Display account balance");
    jbDeposit = new JButton("Make a deposit");
    jbWithdraw = new JButton("Make a withdrawal");

    jbDisplay.setEnabled(false);
    jbDeposit.setEnabled(false);
    jbWithdraw.setEnabled(false);

    jb0 = new JButton("0");
    jb1 = new JButton("1");
    jb2 = new JButton("2");
    jb3 = new JButton("3");
    jb4 = new JButton("4");
    jb5 = new JButton("5");
    jb6 = new JButton("6");
    jb7 = new JButton("7");
    jb8 = new JButton("8");
    jb9 = new JButton("9");
    jbEnter = new JButton("Enter");
    jbClear = new JButton("Clear");
    first = true;
    test = false;
  }

  /** Metodo para cargar el entorno de BankAtmSwing */
  public void launchFrame() {
    JPanel pn = new JPanel(new GridLayout(4, 3));
    pn.add(jb1);
    pn.add(jb2);
    pn.add(jb3);
    pn.add(jb4);
    pn.add(jb5);
    pn.add(jb6);
    pn.add(jb7);
    pn.add(jb8);
    pn.add(jb9);
    pn.add(jb0);
    pn.add(jbClear);
    pn.add(jbEnter);

    JPanel psw = new JPanel(new GridLayout(1, 1));
    psw.add(pn);

    JPanel psda = new JPanel(new GridLayout(1, 1));
    psda.add(jtfDataE);

    JPanel pbot = new JPanel(new GridLayout(3, 1));
    pbot.add(jbDisplay);
    pbot.add(jbDeposit);
    pbot.add(jbWithdraw);

    JPanel pwest = new JPanel(new BorderLayout());
    pwest.add(pbot, BorderLayout.CENTER);
    pwest.add(psda, BorderLayout.SOUTH);

    JPanel psnot = new JPanel(new GridLayout(2, 1));
    psnot.add(pwest);
    psnot.add(psw);

    JPanel peast = new JPanel(new BorderLayout());

    jtA.setEnabled(false);
    jtfMsn.setEnabled(false);

    peast.add(jtA, BorderLayout.CENTER);
    peast.add(jtfMsn, BorderLayout.SOUTH);

    this.add(peast, BorderLayout.CENTER);
    this.add(psnot, BorderLayout.WEST);

    this.setSize(600, 250);
    this.setVisible(true);
    this.setResizable(false);

    // Agregar escuchas a los botones de numeracion y de operacion
    jb0.addActionListener(this);
    jb1.addActionListener(this);
    jb2.addActionListener(this);
    jb3.addActionListener(this);
    jb4.addActionListener(this);
    jb5.addActionListener(this);
    jb6.addActionListener(this);
    jb7.addActionListener(this);
    jb8.addActionListener(this);
    jb9.addActionListener(this);

    jbEnter.addActionListener(this);
    jbClear.addActionListener(this);

    jbDisplay.addActionListener(this);
    jbDeposit.addActionListener(this);
    jbWithdraw.addActionListener(this);
  }

  /** Ventana de permiso del Administrador */
  public void Login() {
    JD = new JDialog();
    JD.setTitle("Login");
    JD.setLayout(new FlowLayout());
    jbLogin = new JButton("Login");
    jbCancel = new JButton("Cancel");
    jlUser = new JLabel("Username");
    jlPassword = new JLabel("Password");
    jtUser = new JTextField(10);
    jtPassword = new JPasswordField();

    jbLogin.addActionListener(this);
    jbCancel.addActionListener(this);

    JPanel p1 = new JPanel(new GridLayout(2, 2));
    p1.add(jlUser);
    p1.add(jtUser);
    p1.add(jlPassword);
    p1.add(jtPassword);

    JPanel p2 = new JPanel(new FlowLayout());
    p2.add(jbLogin);
    p2.add(jbCancel);

    JD.add(p1, BorderLayout.SOUTH);
    JD.add(p2, BorderLayout.SOUTH);

    JD.setSize(250, 125);
    JD.setVisible(true);
    JD.setResizable(false);
    JD.setLocationRelativeTo(null);
  }

  public void run() {
    try {
      if (acciontype == 1) {
        jtA.setText(
            jtA.getText() + "\nDisplay account balance: " + Cliente.Client("balance", clavee, null, null, null, null));
      }
      if (acciontype == 2) {
        try {
          amount = JOptionPane.showInputDialog(null, "How much do you want to deposit?", "Deposit",
              JOptionPane.QUESTION_MESSAGE);
          Cliente.Client("deposit", amount, clavee, null, null, null);
          jtA.setText(jtA.getText() + "\nMake a deposit:  " + amount);
          jtfMsn.setText("deposit Sussesful !");
        } catch (RuntimeException e1) {
          jtfMsn.setText("Type numeric character into the Data Entry ");
          JOptionPane.showMessageDialog(this,
              "Please type numeric character into the Data Entry and Press deposit Button", "Information",
              JOptionPane.INFORMATION_MESSAGE);
          return;
        }
      }
      if (acciontype == 3) {

        try {
          amount = JOptionPane.showInputDialog(null, "Make a Withdrawal", "Withdrawal", JOptionPane.QUESTION_MESSAGE);
          monto = Cliente.Client("withdraw", amount, clavee, null, null, null);
          System.out.println("" + monto);

          if (monto != "no se puede") {

            jtA.setText(jtA.getText() + "\nMake a withdrawal:  " + amount);
            jtfMsn.setText("Withdraw Succsesful !");
          }

        } catch (NumberFormatException e1) {
          jtfMsn.setText("Type numeric character into the Data Entry");
          JOptionPane.showMessageDialog(null,
              "Please type numeric character into the Data Entry and Press Withdraw Button", "Information",
              JOptionPane.INFORMATION_MESSAGE);
          return;
        }
      }

      Thread.sleep(1000);
    } catch (InterruptedException e) {
      System.out.println("Interrupted Exception operation");
    }
  }

  /** Empleo de los eventos para los botones */
  public void actionPerformed(ActionEvent e) {

    // Evento de permiso del Administrador
    if (e.getSource().equals(jbLogin)) {
      String passuser;
      String passkey;
      String pass;

      passuser = jtUser.getText();
      passkey = (String.valueOf(jtPassword.getPassword()));
      pass = crea_usuario.Key1();

      if (passuser.equals("Admin") && passkey.equals(pass)) {
        if (b2 == 1) // llave para verificar de donde procede el llamado, si es para ver clientes o
                     // para ver la ventana de agregar clientes
        {
          ver = new ViewAccounts();
          ver.setVisible(true);
          JD.setVisible(false);
          b1 = 0;
        }

        else {

          crea_usuario.LaunchFrame();

          JD.setVisible(false);
          b1 = 0;
        }

      }

      else {
        JOptionPane.showMessageDialog(null, "Incorrect ID or Password", "Information", JOptionPane.INFORMATION_MESSAGE);
        jtUser.setText("");
        jtPassword.setText("");

      }

    } else if (e.getSource().equals(jbCancel)) {
      JD.setVisible(false);
    }

    // else if (e.getSource().equals(menuLogout)) {
    //
    // // Configuracion de la pantalla una vez terminada la sesion del cliente
    //
    // jbDisplay.setEnabled(false);
    // jbDeposit.setEnabled(false);
    // jbWithdraw.setEnabled(false);
    // jtfDataE.setText("");
    // jtfMsn.setText("");
    // test = false;
    // first = true;
    // isValido = false;
    // }

    String buttonStr = e.getActionCommand();
    String menuIt = e.getActionCommand();

    // Manejo de los eventos de los botones

    if (e.getSource() instanceof JButton) {
      // Evento para desplazar el balance
      if ("Display account balance".equals(buttonStr)) {
        acciontype = 1;
        run();
      }

      else
      // Evento para realizar un deposito
      if ("Make a deposit".equals(buttonStr)) {
        acciontype = 2;
        run();

      } else
      // Evento para realizar un retiro
      if ("Make a withdrawal".equals(buttonStr)) {
        acciontype = 3;
        run();

      } else
      // Evento para hacer posible la escritura con los botones numericos
      if (buttonStr.equals("0") || buttonStr.equals("1") || buttonStr.equals("2") || buttonStr.equals("3") ||
          buttonStr.equals("4") || buttonStr.equals("5") || buttonStr.equals("6") || buttonStr.equals("7") ||
          buttonStr.equals("8") || buttonStr.equals("9")) {

        jtfDataE.setText(jtfDataE.getText() + buttonStr);
        first = false;

      } else if (buttonStr.equals("Enter")) {
        // algoritmo de busqueda que debe encontrar al i- esimo cliente con el Id dado

        if (isValido == false) {

          clave = new String(jtfDataE.getPassword()); // Captura de la clave introducida en pantalla
          clavee = clave;
          Cliente.Client("search", clave, null, null, null, null);
          jtA.setText(jtA.getText() + "\nWelcome " + Cliente.Client("client_info", null, null, null, null, null));

          jbDisplay.setEnabled(true);
          jbDeposit.setEnabled(true);
          jbWithdraw.setEnabled(true);
          jtfDataE.setText("");
          jtfMsn.setText("");
          isValido = true;

        } else {
          if (new String(jtfDataE.getPassword()) != "") {
            jtfMsn.setText("Please Select Deposit or Withdraw Button");
          }
        }

      }

      else if (buttonStr.equals("Clear")) // Evento para limpiar la pantalla de las transacciones realizadas
      {
        if (isValido == false) {
          jtfDataE.setText("");
          jtfMsn.setText("");
        } else {
          jtfDataE.setText("");
          jtfMsn.setText("");
        }
      }
    }
  }

  /** Metodo Principal */
  public static void main(String[] args) {
    BankAtmSwing batm = new BankAtmSwing();
    batm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    batm.launchFrame();
    batm.setLocationRelativeTo(null);
  }
}
