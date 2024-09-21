package cajero;

import java.io.Serializable;
import java.util.Objects;

public class Cuenta implements Serializable{
    private static final long serialVersionUID = 1L;
    private String nombre, apellido, cedula, sexo, clave, edad;
    private double sueldo, saldo;

    public Cuenta(String nombre, String apellido, String cedula, String sexo, String clave, String edad, double sueldo, double saldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.sexo = sexo;
        this.clave = clave;
        this.edad = edad;
        this.sueldo = sueldo;
        this.saldo = saldo;
    }

    public Cuenta(String nombre, String apellido, String cedula, String clave) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.clave = clave;
        
        this.sexo = "";
        this.edad = "";
        this.sueldo = 0.00;
        this.saldo = 0.00;
    }

    @Override
    public String toString() {
        return "Cuenta{" + "nombre=" + nombre + ", apellido=" + apellido + ", cedula=" + cedula + ", clave=" + clave + '}';
    }
    
    public void deposito(double cant){
        saldo += cant;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Cuenta other = (Cuenta) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.cedula, other.cedula)) {
            return false;
        }
        return Objects.equals(this.clave, other.clave);
    }
    
    public void retiro(double cant){
        if(cant>0 && cant <= saldo) 
            saldo -= cant;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public String getSexo() {
        return sexo;
    }

    public String getClave() {
        return clave;
    }

    public String getEdad() {
        return edad;
    }

    public double getSueldo() {
        return sueldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
