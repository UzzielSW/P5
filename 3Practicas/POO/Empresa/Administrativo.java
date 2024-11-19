
public class Administrativo extends Empleado {
    private int hora_extra;
    final double PRECIO_HORA;

    public Administrativo(String nombre, String cod_emp, double sueldoFijo) {
        super(nombre, cod_emp, sueldoFijo);
        this.PRECIO_HORA = 30.0;
        this.hora_extra = 0;
    }

    public String toString() {
        return super.toString() + ". Tipo: Administrador, Horas Extras: " + hora_extra + ", Sueldo del Mes: " + getSueldo();
    }

    public int getHora_extra() {
        return hora_extra;
    }

    public void setHora_extra(int hora_extra) {
        this.hora_extra = hora_extra;
    }

    public double getSueldo() {
        return super.getSueldo() + (hora_extra * PRECIO_HORA);
    }
}
