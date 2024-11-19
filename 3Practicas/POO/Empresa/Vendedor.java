
public class Vendedor extends Empleado {
    private double ventas_mes;
    final double COMISION;

    public Vendedor(String nombre, String cod_emp, double sueldoFijo) {
        super(nombre, cod_emp, sueldoFijo);
        this.COMISION = 10.0;
        this.ventas_mes = 0;
    }

    public String toString() {
        return super.toString() + ". Tipo: Vendedor, Ventas del mes: " + ventas_mes + ", Sueldo del Mes: " + getSueldo();
    }

    public double getVentas_mes() {
        return ventas_mes;
    }

    public void setVentas_mes(double ventas_mes) {
        this.ventas_mes = ventas_mes;
    }

    public double getSueldo() {
        return super.getSueldo() + ((ventas_mes * COMISION) / 100);
    }
}