import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class VerTablas extends JFrame {
	private static final long serialVersionUID = 1L;
	private String data[][];

	public VerTablas() {
		super("Ejemplo 1");

		CreateData();

		String[] columnNames = { "Nombre", "Apellido", "ID", "Balance",
				"Tipo de cuenta" };

		final JTable table = new JTable(data, columnNames);
		table.setEnabled(false);
		table.setPreferredScrollableViewportSize(new Dimension(500, 500));

		JScrollPane scrollPane = new JScrollPane(table);

		getContentPane().add(scrollPane, BorderLayout.CENTER);
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.pack();
		this.setResizable(false);
		this.setVisible(true);

	}

	public String cuenta(int res) {
		String Res;
		if (res == 0) {
			Res = "Ahorro";
		} else {
			Res = "Corriente";
		}
		return Res;
	}

	public void CreateData() {
		data = new String[cantidad()][5];
		int t = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/userbank", "root", null);
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM userbank");
			while (rs.next()) {
				data[t][0] = rs.getObject("nombre").toString();
				data[t][1] = rs.getObject("apellido").toString();
				data[t][2] = rs.getObject("pass").toString();
				if (Double.parseDouble(rs.getObject("cuentaA").toString()) == -1) {
					data[t][3] = rs.getObject("cuentaC").toString();
					data[t][4] = "corriente";
				} else {
					data[t][3] = rs.getObject("cuentaA").toString();
					data[t][4] = "ahorro";
				}
				t++;
			}
			st.close();
			conexion.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static int cantidad() {
		int R = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/userbank", "root", null);
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM userbank");
			while (rs.next()) {
				R++;
			}
			st.close();
			conexion.close();
		} catch (Exception e) {
			R = 0;
		}
		return R;
	}
}
