import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
/*
 * Esta clase genera las acciones de relasion entre el grafico y el sql solo de la interfas BankClientH e inicon
 * @author David Rodríguez
 * */
public class envio {
	private static String tem = null;
	public static String nombre=null;
	public static String apellido=null;
	 /*
     * Metodo verifica que pass exista si exsiste establece el pass como elemento fijo para su utilizasion en las metodos posteriores.
     * */
	public  synchronized static int busca(String tems) {
		int R = 1;
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/userbank", "root", null);
			Statement st = conexion.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM userbank");
			while (rs.next()) {
				if (rs.getObject("pass").toString().compareTo(""+tems) == 0) {
					tem = tems;
					nombre = rs.getObject("nombre").toString();
					apellido =rs.getObject("apellido").toString();
					R = 0;
				}
			}
			rs.close();
			st.close();
			conexion.close();
		} catch (Exception t) {
			System.out.println(t.getMessage());
		}
		return R;
	}
	 /*
     * Metodo encargado de enviar el balance a la pantalla.
     * */
	public synchronized static double balance() {
		double balance = 0;
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
						balance = Double.parseDouble(rs.getObject(TCuenta).toString());
					}
				}
				rs.close();
				st.close();
				conexion.close();
			} catch (Exception t) {
				System.out.println(t.getMessage());
			}
		}
		return balance;
	}
	 /*
     * Metodo encargado de haser los ingresos.
     * */
	public synchronized static String I_Cu(double dep) {
		double tes = 0;
		String arg = null;
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
						tes = Double.parseDouble(rs.getObject(TCuenta).toString());
						tes = tes + dep;
						st.executeUpdate("UPDATE userbank SET " + TCuenta+ "=\"" + tes + "\" WHERE pass=\"" + tem+ "\";");
						arg = "balance actual: "+ tes;
					}
				}
				rs.close();
				st.close();
				conexion.close();
			} catch (Exception t) {
				System.out.println(t.getMessage());
			}
		}
		return arg;
	}
	 /*
     * Metodo encaragaddo de haser los retiros.
     * */
	public synchronized static String R_Cu(double dep) {
		double tes = 0;
		String arg = null; 
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
						if (Double.parseDouble(rs.getObject(TCuenta).toString()) != 0) {
							tes = Double.parseDouble(rs.getObject(TCuenta).toString());
							tes = tes - dep;
							if (tes >= 0) {
								st.executeUpdate("UPDATE userbank SET "+ TCuenta + "=\"" + tes+ "\" WHERE pass=\"" + tem + "\";");
								arg ="balance actual: " + tes;
							} else {
								arg ="su balance actual es inferior al mondo que desea retirar";
							}
						} else {
							arg ="su saldo es 0";
						}
					}
				}
				rs.close();
				st.close();
				conexion.close();
			} catch (Exception t) {
				System.out.println(t.getMessage());
			}
		}
		return arg;
	}
}