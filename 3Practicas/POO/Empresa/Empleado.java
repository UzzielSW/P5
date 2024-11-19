
public class Empleado {
    private String nombre;
    private String cod_emp;
    protected double sueldoFijo;

    public Empleado() {
        this.nombre = "";
        this.cod_emp = "";
        this.sueldoFijo = 0.0;
    }

    public Empleado(String nombre, String cod_emp, double sueldoFijo) {
        this.nombre = nombre;
        this.cod_emp = cod_emp;
        this.sueldoFijo = sueldoFijo;
    }

    public String toString() {
        return ("Empleado " + nombre + " con codigo ID: " + cod_emp + " tiene un Sueldo Fijo de " + sueldoFijo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCod_emp() {
        return cod_emp;
    }

    public void setCod_emp(String cod_emp) {
        this.cod_emp = cod_emp;
    }

    public double getSueldo() {
        return sueldoFijo;
    }

    public void setSueldo(double sueldoFijo) {
        this.sueldoFijo = sueldoFijo;
    }
}