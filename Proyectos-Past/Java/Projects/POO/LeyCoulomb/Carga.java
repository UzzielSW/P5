
public class Carga {
    private double carga;
    private Punto p;

    public Carga(double carga, Punto p) {
        this.carga = carga;
        this.p = p;
    }

    public double getCarga() {
        return (carga);
    }

    public Punto getPunto() {
        return p;
    }

    public String getDetails() {
        return ("Carga: " + carga + "C" + " esta en el Punto" + p.getDetails());
    }
}