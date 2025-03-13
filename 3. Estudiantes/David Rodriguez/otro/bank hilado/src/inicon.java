import javax.swing.JOptionPane;
/*
 * Esta clase genera la ventana principal y distribuye segun sea su uso las actividades para mayor eficasia y menos consumo
 * @author David Rodríguez
 * */
public class inicon extends Thread {

	public void run() {
			String res = JOptionPane.showInputDialog(null, "Codigo de usuario:");
			if (envio.busca(res) == 0) {
				Runnable n = new BankClientH();
				Thread go = new Thread(n);
				go.start();
			} else if (res.equals("admin")) {
				Runnable n = new addcustomer();
				Thread go = new Thread(n);
				go.start();
			} else if (res.equals("adver")) {
				Runnable n = new VerTabla();
				Thread go = new Thread(n);
				go.start();
			} else {
				JOptionPane.showMessageDialog(null, "Codigo incorrecto intente de nuevo:",null, JOptionPane.WARNING_MESSAGE);
			}
	}

	public static void main(String[] args) {
		inicon ras = new inicon();
		ras.start();
	}
}
