import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/*
 * Esta clase genera las acciones de relasion entre el grafico y el sql solo de la interfas addcustomer
 * @author David Rodríguez
 * */
public class envio_A {
	public static String nombre=null;
	public static String apellido=null;
	/*
	 * Esta clase genera las acciones de relasion entre el grafico y el sql solo de la interfas addcustomer
	 * 
	 * */
	public static String addclient(long pass,String nombre,String apellido,double cuentaA,double cuentaC) {
		try{
				  Class.forName("com.mysql.jdbc.Driver").newInstance();
				  Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/userbank","root",null);
				  Statement st = conexion.createStatement();
				  st.executeUpdate("INSERT INTO userbank VALUES(\""+pass+"\",\""+nombre+"\",\""+apellido+"\",\""+cuentaA+"\",\""+cuentaC+"\");");		 
				  st.close();
				  conexion.close();
			}catch(Exception e){
				  System.out.println(e.getMessage());
				}
		return "Tu Numero de cuenta es: "+pass;  
		}
	 /*
     * Metodo verifica que el pass no exista y retornar un pass libre si existe.
     * */
	public static long pass(long pass) {
		long X=0;
		try{
				  Class.forName("com.mysql.jdbc.Driver").newInstance();
				  Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/userbank","root",null);
				  Statement st = conexion.createStatement();
				  ResultSet rs = st.executeQuery("SELECT * FROM userbank");
				  while (rs.next()){	
				  if(rs.getObject("pass").toString().compareTo(""+pass)==0){
					  pass(Math.round(Math.random()*9999+1000));	  
				  }
				  else{X = pass;}
				 }
				  st.close();
				  conexion.close();
				  
			}catch(Exception e){
				  System.out.println(e.getMessage());
				}  
			if (X==0){X=Math.round(Math.random()*9999+1000);}
			return X;
		}
	 /*
     * Metodo encargado de actualizar la cuenta del cliente.
     * */
	public static String upclient(String nombre, String apellido, String pass){
	 	try{
	 		Class.forName("com.mysql.jdbc.Driver").newInstance();
			  Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/userbank","root",null);
			  Statement st = conexion.createStatement();
			  st.executeUpdate("UPDATE userbank SET nombre=\""+nombre+"\" WHERE pass=\""+pass+"\";");
			  st.executeUpdate("UPDATE userbank SET apellido=\""+apellido+"\" WHERE pass=\""+pass+"\";");

			  st.close();
					 conexion.close();
					  
				}catch(Exception t){
					  System.out.println(t.getMessage());
					}
		return "Cliente Actualizado";
	}
	
	 /*
     * Metodo utilizado para buscar el nombre y apellido para su posterior edision.
     * */
	public static void busnoap(String pass){
		try{
			  Class.forName("com.mysql.jdbc.Driver").newInstance();
			  Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/userbank","root",null);
			  Statement st = conexion.createStatement();
			  ResultSet rs = st.executeQuery("SELECT * FROM userbank");
			 // st.executeUpdate("UPDATE userbank SET nombre="+recuadrof22.getText()+" WHERE pass="+recuadrof21.getText()+";");
			  while (rs.next()){	
			  if(rs.getObject("pass").toString().compareTo(""+pass)==0){
				 nombre = rs.getObject("nombre").toString();
				 apellido =rs.getObject("apellido").toString();	  
			  }
			  
			 }
			  st.close();
			  conexion.close();
			  
		}catch(Exception t){
			  System.out.println(t.getMessage());
			}  
	}
	
	public static String[][] CreateData() {
		String	data[][] = new String[cantidad()][5];
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
		return data;
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

