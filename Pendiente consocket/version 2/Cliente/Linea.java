import java.io.*;

public class Linea implements Serializable {
    Punto p1;
    Punto p2;
    public double m;
    public boolean existe;
    public double b;
    public Punto ejeX;
    public Punto ejeY;

    public Linea(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;

        //	existe=false;
        //	m=calcula_pendiente();				
    }

    public Linea(Punto p1, double m) {
        this.p1 = p1;
        this.m = m;
        // existe=true;	
    }

    public void validaPuntos(Punto p1, Punto p2) throws PuntosIgualesException {
        if (p1.equals(p2) == true)
            throw new PuntosIgualesException(p1, p2);

    }

    /*  public double calcula_pendiente(Punto p1,Punto p2) 
    {
    
		 return((p2.y-p1.y)/(p2.x-p1.x));	
    }
   */

    boolean validar_pendiente(Punto p1, Punto p2) {
        System.out.println("\n Entre a validar pendiente");
        if (!(p2.x == p1.x)) {
            return (true);
        } else
            return (false);
    }

    public double calcula_pendiente() {

        try {

            validaPuntos(p1, p2);

        } catch (PuntosIgualesException e) {

        }

        m = (p2.y - p1.y) / (p2.x - p1.x);

        return (m);

    }

    public String imprime_linea3() {
        return ("y = " + this.m + "*x +" + this.b + ": " + p1.display() + " - " + p2.display() +
            "\n Interseccion ejeX: " + ejeX.display() +
            "\n Interseccion ejeY: " + ejeY.display());
    }

    public String imprime_linea() {
        String s = null;

        if (b > 0.0 && m != 0.0)
            s = "y = " + this.m + "x " + "+ " + b + " : \n Pasa por Punto P1 : " + p1.display() + " - Punto P2: " + p2.display();
        else if (b < 0 && m != 0.0)
            s = "y = " + this.m + "x " + b + " : \nPasa por Punto P1 : " + p1.display() + " - Punto P2: " + p2.display();
        else if (b == 0.0 && m != 0.0)
            s = "y = " + this.m + "x " + " \nPasa por Punto P1: " + p1.display() + " - Punto P2: " + p2.display();
        else if (b != 0.0 && m == 0.0)
            s = "y = " + b + " \nPasa por Punto P1: " + p1.display() + " - Punto P2: " + p2.display();
        else if (b == 0.0 && m == 0.0 && p1.y == 0.0 && p2.y == 0)
            s = "y = " + p1.y + " \nPasa por Punto P1: " + p1.display() + " - Punto P2: " + p2.display();
        else if (b == 0.0 && m == 0.0 && p1.x == 0 && p2.x == 0)
            s = "x = " + p1.x + " \nPasa por Punto P1: " + p1.display() + " - Punto P2: " + p2.display();
        return (s);
    }

    public String imprime_linea2() {
        return ("x = " + p1.getx() + " : " + p1.display() + " - " + p2.display());
    }

    public String simprime_linea() {
        return ("y = " + this.m + "x + b :" + p1.display());
    }
    public Punto calcula_interseccion(Linea a) {
        Punto temp = new Punto();
        temp.y = (-(a.p2.x - a.p1.x) * ((-(this.p2.y - this.p1.y) - this.m) / (this.p2.x - this.p1.x)) - a.m) / (a.p2.y - a.p1.y);
        temp.x = (-(a.p2.y - a.p1.y) * ((-(this.p2.x - this.p1.x) - this.m) / (this.p2.y - this.p1.y)) - a.m) / (a.p2.x - a.p1.x);
        return (temp);
    }

    public void setPendiente(double m) {
        this.m = m;
    }

    public double getPendiente() {
        return (m);
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getB() {
        return (b);
    }

    public void setInterEjeX(Punto p) {
        this.ejeX = p;
    }

    public Punto getInterEjeX() {
        return (ejeX);
    }

    public void setInterEjeY(Punto p) {
        this.ejeY = p;
    }

    public Punto getInterEjeY() {
        return (ejeY);
    }

    public Punto getP1() {
        return (p1);
    }
    public Punto getP2() {
        return (p2);
    }

}

class PuntosIgualesException extends Exception {
    private Punto p1;
    private Punto p2;

    PuntosIgualesException(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;

        System.out.println("\nLos puntos: " + p1.display() + " y " + p2.display() + "son iguales ");
        System.out.println("\nNo forman una recta ingrese puntos distintos !");
        //	System.exit(0);
    }
}