import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/*
 * Esta clase genera la subventana perteneciente al super administrador, es la encargada de desplegar los clientes en la tabla sql
 * @author David Rodríguez
 * */
public class VerTabla extends JFrame implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public void run() {
		try {
				Cliente.Client("vertabla", null, null, null, null, null);
				final String[][] data =Cliente.data;

				String[] columnNames = { "Nombre", "Apellido", "ID", "Balance","Tipo de cuenta" };

				final JTable table = new JTable(data, columnNames);
				table.setEnabled(false);
				table.setPreferredScrollableViewportSize(new Dimension(500,500));

				JScrollPane scrollPane = new JScrollPane(table);

				this.add(scrollPane);
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				this.pack();
				this.setResizable(false);
				this.setVisible(true);
				
				Thread.sleep(10000);
			
		} catch (InterruptedException e) {
			System.out.println("Interrupted Exception caught");
		}
	}
}
