

/* Triangulo.java
 * @author: MSc. Álvaro Pino N.
 *  Date: 26/10/2021
 *  Prueba Formativa
 */

import java.io.*;

public class Triangulo  implements Serializable{
	public double base;
	public double altura;
	public double area;
	
	public Triangulo(double base, double altura){

		this.base = base;
		this.altura = altura;
	//	area = calcArea();
		System.out.println("inside triangle constructor");
	}
	public String toString() {
		return("triangulo with base: "+ base +
			" and altura: "+ altura +" area: "+area );
	}
	public double getArea() {
		return area;
	}
	public double getBase() {
		return base;
	}
	public double getAltura() {
		return altura;
	}
	public double calcArea() {
		return area = (1.0/2.0) *base * altura;
	}
}
