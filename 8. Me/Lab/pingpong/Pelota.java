
public class Pelota
{
    boolean noTengo;

    public synchronized boolean isNoTengo()
    {
       return noTengo;
    }

    public synchronized void setNoTengo(boolean resp)
    {
       noTengo = resp;
    }
}

