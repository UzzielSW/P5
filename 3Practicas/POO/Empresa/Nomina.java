
import java.util.ArrayList;

public class Nomina {
    private String mes;
    private ArrayList<Empleado> nom;
    private int numEmpleados;
    private static int max = 3;

    public Nomina(String mes) {
        this.mes = mes;
        this.numEmpleados = 0;
        nom = new ArrayList<>();
    }

    public String getMes() {
        return mes;
    }

    public void agregarEmpleado(Empleado emp) {
        if (numEmpleados == max)
            System.out.println("La cantidad de empleados esta en el limite");
        else {
            nom.add(emp);
            numEmpleados++;
        }
    }

    public double getTotalMes() {
        double sum = 0;

        if (nom.isEmpty())
            System.out.println("Sin empleados");
        else
            for (Empleado empleado : nom)
                sum += empleado.getSueldo();
            
        return sum;
    }

    public void tostring() {
        nom.forEach(t -> System.out.println("\n -: " + t.toString()));
    }
}