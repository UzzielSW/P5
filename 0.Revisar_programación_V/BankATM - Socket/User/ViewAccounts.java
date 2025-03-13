
import javax.swing.*;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * Role: Administrador o Usuario
 * Clave: numero aleatorio de 4 digitos
 * Nombre: Nombre del usuario
 * # de celular: numero de 8 digitos
 * saldo: double
 * Fecha de creacion
 *
 * @author
 * @version
 */

public class ViewAccounts extends JDialog {

  private String[] encabezado;
  private JTable table;
  private Object[][] data;

  private static int w;

  // * Constructor*/
  public ViewAccounts() {
    Cliente.Client("view_accounts", null, null, null, null, null);
    data = Cliente.data;
    encabezado = new String[] { "First Name", "Last Name", "ID", "Saldo", "Type Account" };

    table = new JTable(data, encabezado);
    this.add(new JScrollPane(table));

    setSize(600, 200);
    setLocationRelativeTo(null);
    setVisible(true);
  }
}
