public class ImplPendDistSocket {

	public double calcula_pendiente(Punto p1, Punto p2) {
		return ((p2.y - p1.y) / (p2.x - p1.x));
	}

	public double distancia(Punto p1, Punto p2) {
		return (Math.sqrt(Math.pow((p2.y - p1.y), 2.0) + Math.pow((p2.x - p1.x), 2.0)));
	}
}