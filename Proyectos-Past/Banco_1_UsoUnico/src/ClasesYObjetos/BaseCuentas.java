package ClasesYObjetos;

import java.util.ArrayList;
import JOptionPane;

public class BaseCuentas {

    ArrayList<CuentaBancaria> arregloCuentas;

    public BaseCuentas() {
        arregloCuentas = new ArrayList<>();
    }

    public void agregarCuenta(CuentaBancaria cuenta) {
        arregloCuentas.add(cuenta);
    }

    public int getIndice(int id) {
        int resultado = 0;

        for (int x = 0; x < arregloCuentas.size(); x++) {

            if (arregloCuentas.get(x).getCuentaId() == id) {
                resultado = x;
            }
        }
        return resultado;
    }

    public boolean buscaCuentaID(int id) {
        boolean resultado = false;

        for (int x = 0; x < arregloCuentas.size(); x++) {
            if (arregloCuentas.get(x).getCuentaId() == id) {
                resultado = true;
            }
        }
        return resultado;
    }

    public boolean vacio() {
        boolean valor;
        if (arregloCuentas == null || arregloCuentas.isEmpty()) {
            valor = true;
        } else {
            valor = false;
        }
        
        return valor;
    }

    public void setCuenta(CuentaBancaria cuenta, int x) {
        arregloCuentas.set(x, cuenta);
    }

    public CuentaBancaria obtenerCuenta(int id) {
        CuentaBancaria cuenta = null;

        for (int x = 0; x < arregloCuentas.size(); x++) {
            if (arregloCuentas.get(x).getCuentaId() == id) {
                cuenta = arregloCuentas.get(x);
            }
        }
        
        if (cuenta == null) {
            JOptionPane.showMessageDialog(null, "Cuenta no existe");
        }
        
        return cuenta;
    }

}//fin de clase
