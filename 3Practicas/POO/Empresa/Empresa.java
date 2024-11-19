/*
Una empresa tiene maximo de 3 empleados, pueden ser:

    - tipo
            - Vendedores
                    > mantienen informacion sobre el volumen de ventas en el mes.
            - Administrativo
                    > guardan informacion sobre las horas extras trabajadas.

    - atributos
            - codigo de empleado
            - nombre
            - sueldo fijo
                    - Vendedores
                            > 	(comisiones por ventas) = (ventas * 0.1) =>[10%]
                                    (sueldo fijo) += (comisiones por ventas)
                    - Administrativo
                            > 	(horas extras) *= 30.00 
                                    (sueldo fijo) += (horas extras)


En el main() cree un objeto de la clase Nomina para el mes de Diciembre;
utilizando el polimorfismo cree dos objetos Vendedor y un Administrador;
Añada cada uno de estos invocando el metodo agregarEmpleado.

	- incremente sus ventas y numero de horas extras 
	- despliegue un resumen de la nomina  del mes de Diciembre con metodo toString() 
	- el total de sueldos pagados durante dicho mes invocando el metodo getTotalMes().


Salida:

Diciembre
Vendedor: Ana Gonzales
Ventas del mes: 1000.00  Codigo ID: 222222  Salario Mes: 1400.00
Vendedor: Pepe Perez
Ventas del mes: 800.00  Codigo ID: 111111  Salario Mes: 1280.00
Administrador: Juan Carrete
Horas Extras: 20  Codigo ID: 333333  Salario Mes: 2100.00
Total: 4780.00

 */

public class Empresa {

	public static void main(String[] args) {

		// Objetos
		Nomina diciembre = new Nomina("Diciembre");
		Vendedor em1 = new Vendedor("Ana Gonzales", "222222", 1300);
		Vendedor em2 = new Vendedor("Pepe Perez", "111111", 1200);
		Administrativo em3 = new Administrativo("Juan Carrete", "333333", 1500);

		// incremento ventas y horas extras
		em1.setVentas_mes(1000.00);
		em2.setVentas_mes(800.00);
		em3.setHora_extra(20);

		// agregando empleados
		diciembre.agregarEmpleado(em1);
		diciembre.agregarEmpleado(em2);
		diciembre.agregarEmpleado(em3);

		// resumen de la nomina del mes de diciemnbre
		diciembre.tostring();

		// total de sueldos pagados durante diciembre
		System.out.printf("\nTotal del mes %s: %.2f", diciembre.getMes(), diciembre.getTotalMes());
	}
}