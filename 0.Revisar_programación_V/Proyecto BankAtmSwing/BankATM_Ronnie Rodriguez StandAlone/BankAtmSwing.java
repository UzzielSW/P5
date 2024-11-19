import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class BankAtmSwing extends JDialog implements ActionListener {

  public static void main(String[] args) {
    BankAtmSwing batm = new BankAtmSwing();
    batm.launchFrame();
  }

  private int l, ll, i = 0, claveid, vcuenta, cuenta;
  private int b1 = 0, b2 = 0;
  private static int pos = 0, pos1 = 0, valor_posicion = 0;
  private JTextArea jtA;
  private JPasswordField jtfDataE;
  private JTextField jtfMsn;
  private JButton jb1, jb2, jb3, jb4, jb5, jb6, jb7;
  private JButton jb8, jb9, jb0, jbEnter, jbClear;
  private JButton jbDisplay;
  private JButton jbDeposit;
  private JButton jbWithdraw;
  private JMenuItem menuCrear, menuSalir, menuSave, menuSee, menuLogout;
  private JFrame Ventana = new JFrame("Stark BankATM");

  public Create_User crea_usuario;
  public Customer co = new Customer();
  public ViewAccounts ver;

  JLabel jlUser, jlPassword;
  JTextField jtUser;
  JPasswordField jtPassword;
  JButton jbLogin, jbCancel;
  static String cambia_nombrea, cambia_apellidoa;
  private LinkedList<Customer> lista;
  private boolean first, test;
  boolean isValido = false;

  // * Constructor*/

  public BankAtmSwing() {
    lista = new LinkedList();
    crea_usuario = new Create_User(lista);

    // Creacion de la Barra de menu

    JMenuBar menuBar = new JMenuBar();
    JMenu menuClientes = new JMenu("File");
    JMenu menuVer = new JMenu("See");
    JMenu menuLog = new JMenu("Logout");
    JMenu menuExit = new JMenu("Exit");

    menuCrear = new JMenuItem("Create_Customer");
    menuSalir = new JMenuItem("Exit BankATM ");
    menuSave = new JMenuItem("Save");
    menuSee = new JMenuItem("See");
    menuLogout = new JMenuItem("Logout");

    menuClientes.add(menuCrear);
    menuClientes.add(menuSave);

    menuLog.add(menuLogout);
    menuVer.add(menuSee);
    menuExit.add(menuSalir);

    menuBar.add(menuClientes);
    menuBar.add(menuVer);
    menuBar.add(menuLog);
    menuBar.add(menuExit);

    // Escuchas de los MenuItems
    menuCrear.addActionListener(this);
    menuSalir.addActionListener(this);
    menuSee.addActionListener(this);
    menuSave.addActionListener(this);

    Ventana.setJMenuBar(menuBar);
    menuLogout.addActionListener(this);

    jtA = new JTextArea(10, 75);
    jtA.setText(
        "                                             Stark BankATM" + "                         Ro4_Corporation");
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
    // formacion de los de la interface de BankAtmSwing

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

    Ventana.add(peast, BorderLayout.CENTER);
    Ventana.add(psnot, BorderLayout.WEST);

    Ventana.setSize(600, 250);
    Ventana.setVisible(true);
    Ventana.setResizable(false);
    Ventana.setLocation(400, 200);

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
    // Creacion del panel

    Container contentPanel = this.getContentPane();
    contentPanel.setLayout(new FlowLayout());
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

    contentPanel.add(p1, BorderLayout.SOUTH);
    contentPanel.add(p2, BorderLayout.SOUTH);
    // Configuracion del tamaño

    this.setSize(250, 125);
    this.setLocation(590, 300);
    this.setVisible(true);
    this.setResizable(false);
  }

  /**
   * Metodo para recopilar infomacion del usuario a realizar cambios en la lista
   */
  public void Save_Client(String cambia_nombre, String cambia_apellido, int h) {
    valor_posicion = h;
    cambia_nombrea = cambia_nombre;
    cambia_apellidoa = cambia_apellido;
    System.out.println("" + cambia_nombre + "" + cambia_apellido + "" + valor_posicion);
  }

  /** Metodo para guardar los cambios en los usuarios */
  public void Guarda_Edita() {
    crea_usuario.getCustomer(valor_posicion).setFirstName(cambia_nombrea); // Se incorpora el primer nombre editado
    crea_usuario.getCustomer(valor_posicion).setLastName(cambia_apellidoa); // Se incorpora el apellido editado
    JOptionPane.showMessageDialog(this,
        "  Customer Saved:  " + crea_usuario.getCustomer(valor_posicion).getFirstName()); // notificacion de la
  }

  /** Empleo de los eventos para los botones */
  public void actionPerformed(ActionEvent e) {
    // Evento de add Customer
    if (e.getSource().equals(menuCrear)) {
      b2 = 0;
      if (b1 == 0) // Llave para evitar abrir la ventana 2 veces
      {
        Login();
        b1 = 1;

      } else {
        jtUser.setText("");
        jtPassword.setText("");
        this.setVisible(true);
      }
    }

    // Evento para ver el registro de los usuarios
    if (e.getSource().equals(menuSee)) {
      b2 = 1;
      if (b1 == 0) // Llave para evitar abrir la ventana 2 veces
      {
        Login();
        b1 = 1;
      } else {
        jtUser.setText("");
        jtPassword.setText("");
        this.setVisible(true);
      }
    }

    // Evento de guardar cambios
    else if (e.getSource().equals(menuSave)) {
      Guarda_Edita();
    }

    // Evento de permiso del Administrador
    else if (e.getSource().equals(jbLogin)) {
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
          ver = new ViewAccounts(lista);
          ver.setVisible(true);
          this.setVisible(false);
        } else {
          crea_usuario.LaunchFrame();
          this.setVisible(false);
        }
      }

      else {
        JOptionPane.showMessageDialog(this, "Incorrect ID or Password", "Information", JOptionPane.INFORMATION_MESSAGE);
        jtUser.setText("");
        jtPassword.setText("");

      }

    } else if (e.getSource().equals(jbCancel)) {
      this.setVisible(false);
    }

    else if (e.getSource().equals(menuSalir)) {
      System.exit(0);
    }

    else if (e.getSource().equals(menuLogout)) {
      // Configuracion de la pantalla una vez terminada la sesion del cliente
      jbDisplay.setEnabled(false);
      jbDeposit.setEnabled(false);
      jbWithdraw.setEnabled(false);
      jtA.setText(
          "                                             Stark BankATM" + "                         Ro4_Corporation");
      jtfDataE.setText("");
      jtfMsn.setText("");
      test = false;
      first = true;
      isValido = false;
    }

    String buttonStr = e.getActionCommand();
    String menuIt = e.getActionCommand();

    int clave;
    double amount;

    // Manejo de los eventos de los botones

    if (e.getSource() instanceof JButton) {
      // Evento para desplazar el balance
      if ("Display account balance".equals(buttonStr)) {
        jtA.setText(
            jtA.getText() + "\nDisplay account balance: " + crea_usuario.getCustomer(pos).getAccount().getBalance());
      } else
      // Evento para realizar un deposito
      if ("Make a deposit".equals(buttonStr)) {
        try {
          amount = Double.parseDouble(JOptionPane.showInputDialog(null, "How much do you want to deposit?", "Deposit",
              JOptionPane.QUESTION_MESSAGE));

        } catch (RuntimeException e1) {
          jtfMsn.setText("Please type numeric character into the Data Entry and Press deposit Button");
          JOptionPane.showMessageDialog(this,
              "Please type numeric character into the Data Entry and Press deposit Button", "Information",
              JOptionPane.INFORMATION_MESSAGE);
          return;
        }
        jtA.setText(
            jtA.getText() + "\nMake a deposit:  " + " " + crea_usuario.getCustomer(pos).getAccount().deposit(amount));
        jtfMsn.setText("deposit Sussesful !");
      } else
      // Evento para realizar un retiro
      if ("Make a withdrawal".equals(buttonStr)) {
        try {
          amount = Double.parseDouble(
              JOptionPane.showInputDialog(null, "Make a Withdrawal", "Withdrawal", JOptionPane.QUESTION_MESSAGE));

        } catch (RuntimeException e1) {
          jtfMsn.setText("Please type numeric character into " + "the Data Entry and Press Withdraw Button");
          return;
        }
        try {
          crea_usuario.getCustomer(pos).getAccount().withdraw(amount);
        } catch (OverdraftException e3) {
          jtfMsn.setText("Deficit: " + e3.getDeficit() + " " + e3.getMessage() + "Actual balance:  "
              + crea_usuario.getCustomer(pos).getAccount().getBalance());
          return;
        }
        jtA.setText(jtA.getText() + "\nMake a withdrawal  " + amount);
        jtfMsn.setText("Withdraw Sussesful !");
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
          try {
            clave = Integer.parseInt(new String(jtfDataE.getPassword())); // Captura de la clave introducida en pantalla
            l = crea_usuario.valor(); // Asignacion del tamaño de la lista a la variable l

            for (i = 0; i < l; i++) // recorrido de la lista
            {
              claveid = crea_usuario.getCustomer(i).getIdCustomer(); // Solicitando la clave del usuario i

              if (clave == claveid) // si coincide las claves, se accede a los botones de retirar, depositar y ver
                                    // el balance
              {
                pos = i;
                jtA.setText("");
                jtA.setText("                                             Stark BankATM"
                    + "                         Ro4_Corporation");
                jtA.setText(jtA.getText() + "\nWelcome " + crea_usuario.getCustomer(i).getFirstName() +
                    "  " + crea_usuario.getCustomer(i).getLastName());
                jbDisplay.setEnabled(true);
                jbDeposit.setEnabled(true);
                jbWithdraw.setEnabled(true);
                jtfMsn.setText("Correct Key");
                jtfDataE.setText("");
                isValido = true;
                break;

              } else if (i == l) {
                jtA.setText(jtA.getText() + "\nCustomer Id was not found");
                jbDisplay.setEnabled(false);
                jbDeposit.setEnabled(false);
                jbWithdraw.setEnabled(false);
                jtfMsn.setText("Incorrect Password");
                JOptionPane.showMessageDialog(this, "   Password No Found", "Information",
                    JOptionPane.INFORMATION_MESSAGE);
              }
            }
          } catch (RuntimeException e3) {
            jtA.setText("                                            Stark BankATM" + "\n First Login your Id user");
            jtfMsn.setText("First Login");
            return;
          }
        } else {
          if (new String(jtfDataE.getPassword()) != "") {
            jtfMsn.setText("Please Select Deposit or Withdraw Button");
          }
        }
      } else if (buttonStr.equals("Clear")) // Evento para limpiar la pantalla de las transacciones realizadas
      {
        if (isValido == false) {
          jtA.setText("                                            Stark BankATM");
          jtfDataE.setText("");
          jtfMsn.setText("");
        }
      }
    }
  }
}
