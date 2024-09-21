package ClasesYObjetos;

import JOptionPane;

public class HiloRetira extends Thread {

    BaseCuentas base;
    double retiro;
    int id;

    public HiloRetira(BaseCuentas base, double retiro, int id) {
        this.base = base;
        this.retiro = retiro;
        this.id = id;
    }

    @Override
    public void run() {
        int x = base.getIndice(id);
        synchronized (base.arregloCuentas.get(x)) {

            if (retiro <= base.arregloCuentas.get(x).getSaldo()) {
                base.arregloCuentas.get(x).retiro(retiro);
            } else {
                JOptionPane.showMessageDialog(null, "La cantidad que usted a ingresado es mayor al valor de su saldo");
            }
        }
    }
}
