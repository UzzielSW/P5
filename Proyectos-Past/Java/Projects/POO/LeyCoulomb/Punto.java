
public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getx() {
        return x;
    }

    public double gety() {
        return y;
    }

    public String getDetails() {
        return ("(" + x + ", " + y + ")");
    }

    public double calcDistancia(Punto p) {
        double dx = this.getx() - p.getx();
        double dy = this.gety() - p.gety();
        return (Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));
    }
}