package Banco;

import JOptionPane;
import JTextArea;

public class Retirar extends Thread {

    RegistroCuentas cuentas;
    double retiro;
    int id;
    JTextArea txArea;

    public Retirar(RegistroCuentas cuentas, JTextArea txArea, double retiro, int id) {
        this.cuentas = cuentas;
        this.retiro = retiro;
        this.id = id;
        this.txArea = txArea;
    }

    @Override
    public void run() {
        int x = cuentas.getIndice(id);
        System.out.println("hilo retiro ejecutado");

        synchronized (cuentas.arregloCuentas.get(x)) {
            txArea.setText("\nrealizando retiro a la cuenta: " + cuentas.arregloCuentas.get(x).getCuentaId());

            if (retiro <= cuentas.arregloCuentas.get(x).getSaldo()) {
                txArea.append("\nsaldo anterior: " + cuentas.arregloCuentas.get(x).getSaldo());
                cuentas.arregloCuentas.get(x).retiro(retiro);
                txArea.append("\nretiro: " + retiro);
                txArea.append("\nnuevo saldo: " + cuentas.arregloCuentas.get(x).getSaldo());
            } else {
                JOptionPane.showMessageDialog(null, "La cantidad que usted a ingresado es mayor al valor de su saldo");
            }
        }
    }
}
