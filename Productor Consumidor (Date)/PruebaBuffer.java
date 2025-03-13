public class PruebaBuffer
{
    public static void main(String args[]) {
        Buffer sr = new Buffer();
        Productor pt = new Productor(sr);
        Consumidor ct = new Consumidor(sr);
        pt.start();  ct.start();               
    }
}
