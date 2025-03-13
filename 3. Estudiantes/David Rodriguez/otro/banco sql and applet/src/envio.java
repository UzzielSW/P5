import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class envio {
	private static String tem = null;

	public static int busca(String tems) {
		int R = 1;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/userbank", "root", null);
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM userbank");
			while (rs.next()) {
				if (rs.getObject("pass").toString().compareTo(tems) == 0) {
					tem = tems;
					R = 0;
				}
			}
			st.close();
			conexion.close();
		} catch (Exception t) {
			System.out.println(t.getMessage());
		}
		return R;
	}
	public static void balance() {
		if (tem != null) {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/userbank", "root", null);
				Statement st = conexion.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM userbank");
				while (rs.next()) {
					if (rs.getObject("pass").toString().compareTo("" + tem) == 0) {
						String TCuenta = "cuentaC";
						if (Double.parseDouble(rs.getObject(TCuenta).toString()) == -1) {
							TCuenta = "cuentaA";
						}
						JOptionPane.showMessageDialog(null, "balance actual: "+ Double.parseDouble(rs.getObject(TCuenta).toString()));
					}
				}
				st.close();
				conexion.close();
			} catch (Exception t) {
				System.out.println(t.getMessage());
			}
		}
	}
	public static void I_Cu() {
		if (tem != null) {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/userbank", "root", null);
				Statement st = conexion.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM userbank");
				while (rs.next()) {
					if (rs.getObject("pass").toString().compareTo("" + tem) == 0) {
						String ans;
						String TCuenta = "cuentaC";
						double tes = 0;
						ans = JOptionPane.showInputDialog(null,"Ingrese la cantidad a depositar:");
						double dep = Double.parseDouble(ans);
						if (Double.parseDouble(rs.getObject(TCuenta).toString()) == -1) {
							TCuenta = "cuentaA";
						}
						tes = Double.parseDouble(rs.getObject(TCuenta).toString());
						tes = tes + dep;
						st.executeUpdate("UPDATE userbank SET " + TCuenta+ "=\"" + tes + "\" WHERE pass=\"" + tem+ "\";");
						JOptionPane.showMessageDialog(null, "balance actual: "+ tes);
					}
				}
				st.close();
				conexion.close();
			} catch (Exception t) {
				System.out.println(t.getMessage());
			}
		}
	}
	public static void R_Cu() {
		if (tem != null) {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
				Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/userbank", "root", null);
				Statement st = conexion.createStatement();
				ResultSet rs = st.executeQuery("SELECT * FROM userbank");
				while (rs.next()) {
					if (rs.getObject("pass").toString().compareTo("" + tem) == 0) {
						String ans;
						String TCuenta = "cuentaC";
						double tes = 0;ans = JOptionPane.showInputDialog(null,"Ingrese la cantidad a retirar:");
						double dep = Double.parseDouble(ans);
						if (Double.parseDouble(rs.getObject(TCuenta).toString()) == -1) {
							TCuenta = "cuentaA";
						}
						if (Double.parseDouble(rs.getObject(TCuenta).toString()) != 0) {
							tes = Double.parseDouble(rs.getObject(TCuenta).toString());
							tes = tes - dep;
							if (tes >= 0) {
								st.executeUpdate("UPDATE userbank SET "+ TCuenta + "=\"" + tes+ "\" WHERE pass=\"" + tem + "\";");
								JOptionPane.showMessageDialog(null,"balance actual: " + tes);
							} else {
								JOptionPane.showMessageDialog(null,"su balance actual es inferior al mondo que desea retirar");
							}
						} else {
							JOptionPane.showMessageDialog(null, "su saldo es 0");
						}
					}
				}
				st.close();
				conexion.close();
			} catch (Exception t) {
				System.out.println(t.getMessage());
			}
		}
	}
}