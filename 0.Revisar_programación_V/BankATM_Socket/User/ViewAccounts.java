
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;


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
		this.setSize(600, 200);
		this.setLocationRelativeTo(null);
		this.setVisible(true);

	}

}
