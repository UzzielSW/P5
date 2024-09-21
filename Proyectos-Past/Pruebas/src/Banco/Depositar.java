package Banco;

import JTextArea;

public class Depositar extends Thread {

    RegistroCuentas cuentas;
    double deposito;
    int id;
    JTextArea txArea;

    public Depositar(RegistroCuentas cuentas, JTextArea txArea, double deposito, int id) {
        this.id = id;
        this.cuentas = cuentas;
        this.deposito = deposito;
        this.txArea = txArea;
    }

    @Override
    public void run() {
        int x = cuentas.getIndice(id);
        System.out.println("hilo deposito ejecutado");

        synchronized (cuentas.arregloCuentas.get(x)) {
            txArea.setText("\nrealizando deposito a la cuenta: "+ cuentas.arregloCuentas.get(x).getCuentaId());
            txArea.append("\nsaldo anterior: " + cuentas.arregloCuentas.get(x).getSaldo());
            cuentas.arregloCuentas.get(x).deposito(deposito);
            txArea.append("\ndeposito: " + deposito);
            txArea.append("\nnuevo saldo: " + cuentas.arregloCuentas.get(x).getSaldo());
        }
    }
}
