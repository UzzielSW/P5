import javax.swing.*;

public class GuiPrint {

	public static void valida(int i) throws MenorQueCeroException {
		if (i < 0)
			throw new MenorQueCeroException(i);
	}

	public static void main(String[] args) {
		GUIPrintsNumbers PNumbers = new GUIPrintsNumbers();
		Thread t1 = new Thread(PNumbers);
		String captura;
		int tiempo;
		try {
			captura = JOptionPane.showInputDialog(PNumbers,
					"Introduzca el numero de milisegundos durante los cuales main dormira:", "GUIPrint",
					JOptionPane.QUESTION_MESSAGE);
			tiempo = Integer.parseInt(captura);
			GuiPrint.valida(tiempo);
			t1.start();
			Thread.sleep(tiempo);
			PNumbers.stopPrinting();
			JOptionPane.showMessageDialog(PNumbers, "Main is ending...", "GUIPrint", JOptionPane.INFORMATION_MESSAGE);

		} catch (NumberFormatException nfe) {
			JOptionPane.showMessageDialog(PNumbers, "Debe introducir un numero entero", "Error",
					JOptionPane.WARNING_MESSAGE);
		} catch (MenorQueCeroException mqce) {
			JOptionPane.showMessageDialog(PNumbers, "El numero introducido debe ser mayor que cero", "Error",
					JOptionPane.WARNING_MESSAGE);
		} catch (InterruptedException ie) {
		}
		System.exit(0);
	}
}

class MenorQueCeroException extends Exception {
	MenorQueCeroException(int i) {
		System.out.println("Su Entrada es incorrecta! ");
	}
}
