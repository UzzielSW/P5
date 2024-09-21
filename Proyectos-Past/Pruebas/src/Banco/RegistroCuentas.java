package Banco;

import java.io.Serializable;
import java.util.ArrayList;
import JOptionPane;

public class RegistroCuentas implements Serializable{
    private static final long serialVersionUID = 1L;
    ArrayList<CuentaBancaria> arregloCuentas;

    public RegistroCuentas() {
        arregloCuentas = new ArrayList<>();
    }

    public void agregarCuenta(CuentaBancaria cuenta) {
        arregloCuentas.add(cuenta);
    }

    public int getIndice(int id) {
        int resultado = -1;
        for (int x = 0; x < arregloCuentas.size(); x++) {
            if (arregloCuentas.get(x).getCuentaId() == id) {
                resultado = x;
                break;
            }
        }
        return resultado;
    }

    public boolean buscaCuentaID(int id) {
        boolean resultado = false;
        for (int x = 0; x < arregloCuentas.size(); x++) {
            if (arregloCuentas.get(x).getCuentaId() == id) {
                resultado = true;
                break;
            }
        }
        return resultado;
    }

    public boolean vacio() {
        boolean valor;
        valor = arregloCuentas == null || arregloCuentas.isEmpty();
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
                break;
            }
        }
        
        if (cuenta == null) {
            JOptionPane.showMessageDialog(null, "Esta cuenta no existe");
        }
        
        return cuenta;
    }

    @Override
    public String toString() {
        return "RegistroCuentas{" + "arregloCuentas=" + arregloCuentas.toString() + '}';
    }
    
    public CuentaBancaria VerificarCuenta(CuentaBancaria usuario) {

        for (int x = 0; x < arregloCuentas.size(); x++) {
            if (arregloCuentas.get(x).equals(usuario)) {
                usuario = arregloCuentas.get(x);
                break;
            }
        }
        
        return usuario;
    }
}
