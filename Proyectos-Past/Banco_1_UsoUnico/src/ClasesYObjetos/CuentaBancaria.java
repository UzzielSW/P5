package ClasesYObjetos;

import JOptionPane;

public class CuentaBancaria {

    private String nombre; //Nombre del Cliente o propieratio de la cuenta.
    private int cuentaId; //Numero unico de 4 digitos de la cuenta.
    private double saldo; //Saldo del dinero que existe en la cuenta, de tipo flotante.
    private String tipoCuenta; //Tipo de Cuenta del usuario.
    private String claveAlfaNum; //Contrasena Alfanumerica.
    private String fechaInicio; //Fecha de Creacion de la cuenta.
    private String fechaCierre; //Fecha de cierre de la cuenta.

    public CuentaBancaria(String nombre, int cuentaId, double saldo, String tipoCuenta, String claveAlfaNum, String fechaInicio) {
        this.nombre = nombre;
        this.cuentaId = cuentaId;
        this.saldo = saldo;
        this.tipoCuenta = tipoCuenta;
        this.claveAlfaNum = claveAlfaNum;
        this.fechaInicio = fechaInicio;
    }

    public void deposito(double cantidad) {
        this.saldo = saldo + cantidad;
    }

    public void retiro(double cantidad) {
        if (cantidad <= saldo) {
            this.saldo = saldo - cantidad;
        } else {
            JOptionPane.showMessageDialog(null, "La cantidad que usted a ingresado es mayor al valor de su saldo");
        }
    }

    public String getNombre() {
        return nombre;
    }

    public int getCuentaId() {
        return cuentaId;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public String getClaveAlfaNum() {
        return claveAlfaNum;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }

    public String getFechaCierre() {
        return fechaCierre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCuentaId(int cuentaId) {
        this.cuentaId = cuentaId;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public void setClaveAlfaNum(String claveAlfaNum) {
        this.claveAlfaNum = claveAlfaNum;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public void setFechaCierre(String fechaCierre) {
        this.fechaCierre = fechaCierre;
    }
}
