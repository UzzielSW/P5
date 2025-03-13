/**
 * Clase que implementa la interfaz en donde se definen los metodos
 */

public class ImplPendInterSocket implements IntPenInterSocket {

    public ImplPendInterSocket() {
        super();
    }

    public void validaPuntos(Punto p1, Punto p2) throws PuntosIgualesException {
        if (p1.equals(p2) == true) throw new PuntosIgualesException(p1, p2);

    }

    public double calcula_pendiente(Punto p1, Punto p2) {

        return ((p2.y - p1.y) / (p2.x - p1.x));
    }

    public double calcula_pendiente(Linea lin) {

        return ((lin.p2.y - lin.p1.y) / (lin.p2.x - lin.p1.x));
    }

    public double calculaB(Linea lin) {
        return (lin.p1.y - lin.m * lin.p1.x);
    }

    public double calculaB(Punto p1, double m) {
        return (p1.y - m * p1.x);
    }

    public Punto calIntersecEjeX(Linea lin) {
        /*  Punto temp = null;
   
 	String infinitom =String.valueOf(m);
    String infinitob =String.valueOf(b);
        
if( !( ( infinitom.equals("Infinity"))&& (infinitob.equals("Infinity") ) ) )
   {  
 */

        double x = -lin.b / lin.m;

        Punto temp = new Punto(x, 0.0);

        return (temp);

    }

    public Punto calIntersecEje2X(Linea lin) {

        Punto tempX = new Punto(lin.p1.x, 0.0);

        return (tempX);

    }

    public Punto calIntersecEjeY(Linea lin) {

        double y = lin.b;

        Punto temp = new Punto(0.0, y);

        return (temp);

    }

    /*  public Punto calcula_interseccion(Linea a,Linea b) throws java.rmi.RemoteException
    {
    Punto temp=new Punto();
		temp.y=(-(a.p2.x-a.p1.x)*((-(b.p2.y-b.p1.y)-b.m)/(b.p2.x-b.p1.x))-a.m)/(a.p2.y-a.p1.y);
		temp.x=(-(a.p2.y-a.p1.y)*((-(b.p2.x-b.p1.x)-b.m)/(b.p2.y-b.p1.y))-a.m)/(a.p2.x-a.p1.x);
		return(temp);	
    }
    */

}

class PuntosIgualesException extends Exception {
    private Punto p1;
    private Punto p2;

    PuntosIgualesException(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;

        System.out.println("\nLos puntos: " + p1.display() + " y " + p2.display() + "son iguales ");
        System.out.println("\nNo forman una recta ingrese puntos distintos !");
        System.exit(0);
    }
}