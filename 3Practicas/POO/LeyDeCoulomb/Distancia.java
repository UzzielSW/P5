
public class Distancia {
    private Punto p1;
    private Punto p2;
    private float r;

    public Distancia(float dis, Punto p1, Punto p2) {
        this.r = dis;
        this.p1 = p1;
        this.p2 = p2;

        if (this.r == 0)
            calcDistancia();
    }

    public void calcDistancia() {
        float dx = (float) (p2.getx() - p1.getx());
        float dy = (float) (p2.gety() - p1.gety());
        r = (float) (Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2)));
    }

    public double getDistancia() {
        return (r);
    }
}