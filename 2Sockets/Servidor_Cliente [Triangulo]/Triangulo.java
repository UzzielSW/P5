import java.io.Serializable;

public class Triangulo implements Serializable {
	public double base;
	public double altura;
	public double area;

	public Triangulo(double base, double altura) {
		this.base = base;
		this.altura = altura;
	}

	public String toString() {
		return ("Triangulo con base: " + base + " y altura: " + altura);
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
		return area = (1.0 / 2.0) * base * altura;
	}
}
