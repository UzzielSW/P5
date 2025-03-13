import java.awt.BorderLayout;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
/*
 * Esta clase genera la subventana perteneciente al super administrador, es la encargada de desplegar los clientes en la tabla sql
 * @author David Rodríguez
 * */
public class VerTabla extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	private String data[][];

	public void run() {
		try {
			while (true) {
				CreateData();

				String[] columnNames = { "Nombre", "Apellido", "ID", "Balance","Tipo de cuenta" };

				final JTable table = new JTable(data, columnNames);
				table.setEnabled(false);
				table.setPreferredScrollableViewportSize(new Dimension(500,500));

				JScrollPane scrollPane = new JScrollPane(table);

				getContentPane().add(scrollPane, BorderLayout.CENTER);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.pack();
				this.setResizable(false);
				this.setVisible(true);
				Thread.sleep(3000);
			}
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception caught");
		}

	}
	 /*
     * Metodo verifica que tipo de cuenta es.
     * */
	public String cuenta(int res) {
		String Res;
		if (res == 0) {
			Res = "Ahorro";
		} else {
			Res = "Corriente";
		}
		return Res;
	}
	 /*
     * Metodo utilisado para ingresar los datos de la tabla en una matriz n*5.
     * */
	public void CreateData() {
		data = new String[cantidad()][5];
		int t = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/userbank", "root", null);
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
	 /*
     * Metodo verifica la cantidad de datos en la tabla sql.
     * */
	public static int cantidad() {
		int R = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conexion = DriverManager.getConnection(
					"jdbc:mysql://localhost/userbank", "root", null);
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
