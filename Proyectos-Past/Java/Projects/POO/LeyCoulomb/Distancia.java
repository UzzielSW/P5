
public class Distancia {
    private Punto p1;
    private Punto p2;
    private double dis;

    public Distancia(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
        calcDistancia();
    }

    public void calcDistancia() {
        double dx = p2.getx() - p1.getx();
        double dy = p2.gety() - p1.gety();
        dis = (Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));
    }

    public double getDistancia() {
        return dis;
    }

    public String getDetails() {
        return ("La Distancia entre los puntos\n" + "P1" + p1.getDetails() + " y " + "P2" + p2.getDetails() + "\n"
                + "Distancia: " + dis + "\n");
    }
}