import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*
 * Esta clase genera la ventana principal y distribuye segun sea su uso las actividades para mayor eficasia y menos consumo
 * @author David Rodríguez
 * */
public class inicon extends JFrame implements Runnable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Runnable n;
	private static Thread go;

	public void run() {
		
		n = new portada();
		Thread go = new Thread(n);
		go.start();
		
		String res = JOptionPane.showInputDialog(null, "Codigo de usuario:");
		String tem = Cliente.Client("busca", res, null, null, null, null);
		if (res.compareTo(tem) == 0) {
			n = new BankClientH(tem);
			go = new Thread(n);

			go.start();
		} else if (res.equals("admin")) {
			n = new addcustomer();
			go = new Thread(n);
			go.start();
		} else if (res.equals("adver")) {
			n = new VerTabla();
			go = new Thread(n);
			go.start();
		} else {
			JOptionPane.showMessageDialog(null,
					"Codigo incorrecto intente de nuevo:", null,
					JOptionPane.WARNING_MESSAGE);
		}
	}

	public static void main(String[] args) {
		n = new inicon();
		go = new Thread(n);
		go.start();
	}
}
