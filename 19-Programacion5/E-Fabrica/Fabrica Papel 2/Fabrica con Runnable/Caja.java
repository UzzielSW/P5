public class Caja
{
    boolean noTengo=false;
    private static int cantPapel;
    private static int cantCaja;
    
    public synchronized boolean isNoTengo()
    {
       return noTengo;
    }

    public synchronized void setNoTengo(boolean b)
    {
       noTengo = b;
    }
    
    public synchronized void agregarPapel()
    {
       cantPapel++;
    }
    
    public synchronized int getCantPapel()
    {
       return(cantPapel);
    }
    
     public synchronized void setCantPapel(int cant)
    {
       this.cantPapel=cant;
    }
    
    public synchronized int getCantCaja()
    {
       return(cantCaja);
    }
    
    public synchronized void setCantCaja(int cantCaja)
    {
       this.cantCaja=cantCaja;
    }
}

