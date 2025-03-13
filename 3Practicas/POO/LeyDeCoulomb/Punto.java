public class Punto {
    private float x;
    private float y;

    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getx() {
        return x;
    }

    public float gety() {
        return y;
    }

    public String getDetails() {
        return ("(" + x + "," + y + ")");
    }
}