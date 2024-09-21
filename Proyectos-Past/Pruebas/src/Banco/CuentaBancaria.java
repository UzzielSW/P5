package Banco;

import java.io.Serializable;
import java.util.Objects;

public class CuentaBancaria implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nombre;
    private int cuentaId;
    private double saldo;
    private String tipo;
    private String clave;
    private String fechaInicio;
    private Boolean verificar;

    public CuentaBancaria(String nombre, int cuentaId, double saldo, String tipo, String clave, String fechaInicio) {
        this.nombre = nombre;
        this.cuentaId = cuentaId;
        this.saldo = saldo;
        this.tipo = tipo;
        this.clave = clave;
        this.fechaInicio = fechaInicio;
        this.verificar = true;
    }

    public CuentaBancaria() {
    }

    public CuentaBancaria(int cuentaId, String clave) {
        this.cuentaId = cuentaId;
        this.clave = clave;
        this.verificar = false;
        this.nombre = "";
        this.saldo = 0;
        this.tipo = "";
        this.fechaInicio = "";
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CuentaBancaria other = (CuentaBancaria) obj;
        if (this.cuentaId != other.cuentaId) {
            return false;
        }
        return Objects.equals(this.clave, other.clave);
    }

    public void deposito(double cantidad) {
        this.saldo += cantidad;
    }

    public void retiro(double cantidad) {
        this.saldo -= cantidad;
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

    public String gettipo() {
        return tipo;
    }

    public String getclave() {
        return clave;
    }

    public String getFechaInicio() {
        return fechaInicio;
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

    public void settipo(String tipo) {
        this.tipo = tipo;
    }

    public void setclave(String clave) {
        this.clave = clave;
    }

    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Boolean getVerificar() {
        return verificar;
    }

    public void setVerificar(Boolean verificar) {
        this.verificar = verificar;
    }
    
    public String toString2() {
        return nombre + "\t" + saldo + "\t" + tipo + "\n";
    }

    @Override
    public String toString() {
        return nombre + "\t" + cuentaId + "\t" + saldo + "\t" + clave + "\t" + tipo + "\n";
    }
}
