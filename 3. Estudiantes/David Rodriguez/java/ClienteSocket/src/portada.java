import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class portada extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void run(){
		
		ImageIcon imagen = new ImageIcon("examen.png");
		JLabel etiqueta = new JLabel(imagen);
		this.add(etiqueta);
		this.setResizable(false);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		
	}	
}
