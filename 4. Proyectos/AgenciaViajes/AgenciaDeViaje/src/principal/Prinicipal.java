package principal;
import javax.swing.JFrame;
import javax.swing.UIManager;
import controlador.ControladorVista;
import view.VistaAgenciaViajes;

public class Prinicipal {

	public static void main(String[] args) {

		try {
			JFrame.setDefaultLookAndFeelDecorated(true);
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		VistaAgenciaViajes vista = new VistaAgenciaViajes();
		vista.setVisible(true);
		vista.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ControladorVista c = new ControladorVista(vista);
	}
}