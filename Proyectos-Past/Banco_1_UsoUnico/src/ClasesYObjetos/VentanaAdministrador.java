package ClasesYObjetos;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ImageIcon;
import JButton;
import JFrame;
import static JFrame.EXIT_ON_CLOSE;
import JLabel;
import JOptionPane;
import JPanel;
import JTextArea;
import JTextField;

public class VentanaAdministrador extends JFrame implements ActionListener {

    private JPanel panelFondo;
    private JTextField cajaNombre;
    private JTextField cajaSaldo;
    private JTextField cajaTipoCuenta;
    private JTextField cajaClave;
    private JTextField cajaFecha;
    private JTextField cajaBusqueda;
    private JButton btAgregar;
    private JButton btBuscarCuenta;
    private JButton btVerTodo;
    private JButton btAtras;
    private JTextArea areaCentral;
    BaseCuentas base;

    public VentanaAdministrador(BaseCuentas base) {
        this.base = base;
        this.setBounds(50, 50, 1000, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setTitle("                                                                                                                      Ventana Administrador");
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
        ImageIcon foto = new ImageIcon("imagenAdministrador.jpg");
        JLabel etiqueta = new JLabel();
        etiqueta.setBounds(0, 0, this.getWidth(), this.getHeight());
        etiqueta.setIcon(new ImageIcon(foto.getImage().getScaledInstance(this.getWidth(), etiqueta.getHeight(), Image.SCALE_SMOOTH)));
        panelFondo.add(etiqueta);
    }

    private void colocarBotones() {

        btBuscarCuenta = new JButton("Buscar Cuenta");
        btBuscarCuenta.setBounds(60, 170, 158, 40);
        btBuscarCuenta.setEnabled(true);
        btBuscarCuenta.setFont(new Font("arial", Font.BOLD, 14));
        btBuscarCuenta.addActionListener(this);
        panelFondo.add(btBuscarCuenta);

        btVerTodo = new JButton("Ver cuentas");
        btVerTodo.setBounds(60, 300, 158, 40);
        btVerTodo.setEnabled(true);
        btVerTodo.setFont(new Font("arial", Font.BOLD, 14));
        btVerTodo.addActionListener(this);
        panelFondo.add(btVerTodo);

        btAtras = new JButton("Atras");
        btAtras.setBounds(12, 520, 80, 20);
        btAtras.setEnabled(true);
        btAtras.setFont(new Font("arial", Font.BOLD, 14));
        btAtras.addActionListener(this);
        panelFondo.add(btAtras);

        btAgregar = new JButton("Agregar Cuenta");
        btAgregar.setBounds(680, 500, 245, 50);
        btAgregar.setEnabled(true);
        btAgregar.setFont(new Font("arial", Font.BOLD, 16));
        btAgregar.addActionListener(this);
        panelFondo.add(btAgregar);

    }

    private void colocarCajaTexto() {
        cajaBusqueda = new JTextField();
        cajaBusqueda.setBounds(60, 227, 154, 36);
        panelFondo.add(cajaBusqueda);

        cajaNombre = new JTextField();
        cajaNombre.setBounds(700, 200, 190, 30);
        panelFondo.add(cajaNombre);

        cajaSaldo = new JTextField();
        cajaSaldo.setBounds(700, 265, 190, 30);
        panelFondo.add(cajaSaldo);

        cajaTipoCuenta = new JTextField();
        cajaTipoCuenta.setBounds(700, 330, 190, 30);
        panelFondo.add(cajaTipoCuenta);

        cajaClave = new JTextField();
        cajaClave.setBounds(700, 395, 190, 30);
        panelFondo.add(cajaClave);

        cajaFecha = new JTextField();
        cajaFecha.setBounds(700, 450, 190, 30);
        panelFondo.add(cajaFecha);
    }

    public void colocarAreaTexto() {
        areaCentral = new JTextArea();
        areaCentral.setBounds(230, 150, 350, 400);
        areaCentral.setEditable(true);//perimte que se edite el texto que aparecia al principo 
        panelFondo.add(areaCentral);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String nombre = null, tipo = null, clave = null, fecha = null;
        double saldo = 0;

        if (e.getSource() == btAgregar) {
            if (cajaNombre.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Por favor coloque el nombre");
            } else {
                nombre = cajaNombre.getText();
            }
            if (cajaSaldo.getText().length() == 0 && Double.parseDouble(cajaSaldo.getText()) < 0) {
                JOptionPane.showMessageDialog(null, "Por favor coloque el Saldo Inicial mayor que 0");
            } else {
                saldo = Double.parseDouble(cajaSaldo.getText());
            }
            if (cajaTipoCuenta.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Por favor coloque el tipo de Cuenta");
            } else {
                tipo = cajaTipoCuenta.getText();
            }
            if (cajaClave.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Por favor coloque la Clave");
            } else {
                clave = cajaClave.getText();
            }
            if (cajaFecha.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Por favor coloque la fecha de Creacion");
            } else {
                fecha = cajaFecha.getText();
            }
            agregarCuenta(nombre, saldo, tipo, clave, fecha);

        }//btAgregar

        if (e.getSource() == btVerTodo) {
            areaCentral.setText("i      nombre       Cuenta     saldo      Contrasena    tipo  \n");
            for (int x = 0; x < base.arregloCuentas.size(); x++) {
                areaCentral.append("(" + (x + 1) + ")     " + base.arregloCuentas.get(x).getNombre() + "       " + base.arregloCuentas.get(x).getCuentaId() + "      " + base.arregloCuentas.get(x).getSaldo() + "     " + base.arregloCuentas.get(x).getClaveAlfaNum() + "                  " + base.arregloCuentas.get(x).getTipoCuenta() + "\n");
            }
        }
        if (e.getSource() == btAtras) {

            this.setVisible(false);
            this.dispose();
            VentanaInicio inicio = new VentanaInicio(base);
            inicio.setVisible(true);
        }

        if (e.getSource() == btBuscarCuenta) {
            CuentaBancaria cuenta;
            if (cajaBusqueda.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Por favor coloque un numero de cuenta ");

            } else {
                int id = Integer.parseInt(cajaBusqueda.getText());
                if (base.buscaCuentaID(id) == true) {
                    cuenta = base.obtenerCuenta(id);
                    JOptionPane.showMessageDialog(null, "Cuenta encontrada ");
                    areaCentral.setText("***********Cuenta encontrada********\n");
                    areaCentral.append("nombre       Cuenta     saldo      Contrasena    tipo  \n");
                    areaCentral.append(cuenta.getNombre() + "     " + cuenta.getCuentaId() + "     " + cuenta.getSaldo() + "     " + cuenta.getClaveAlfaNum() + "     " + cuenta.getTipoCuenta());
                }
            }

        }//btBuscar
        if (e.getSource() == btAtras) {
            this.setVisible(false);
            this.dispose();

            VentanaInicio inicio = new VentanaInicio(base);
            inicio.setVisible(true);
        }

    }//fin del Action P

    public void agregarCuenta(String nombre, double saldo, String tipo, String clave, String fecha) {
        CuentaBancaria cuenta;
        int id = (int) (Math.random() * 90000) + 10000;
        if (base.vacio() == true) {
            cuenta = new CuentaBancaria(nombre, id, saldo, tipo, clave, fecha);
            base.agregarCuenta(cuenta);
        } else {
            while (base.buscaCuentaID(id) == true) {
                id = (int) (Math.random() * 90000) + 10000;
            }
            cuenta = new CuentaBancaria(nombre, id, saldo, tipo, clave, fecha);
            base.agregarCuenta(cuenta);
        }
    }

}//fin clase

