import java.io.Serializable;

public class Customer
    implements Serializable
{
  private String nombre;
    private String apellido;
    private String Contrasenia;
    private String cuenta;
    private String apertura;
    private Account account;
    private String Tcuenta;
    public Customer(String s, String s1, String s2, String s4, String s5)
    {
        nombre = s;
        apellido = s1;
        Contrasenia = s2;
        apertura = s4;
        double d = Double.parseDouble(s4);
        account = new Account(d);
        Tcuenta = s5;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String s)
    {
        nombre = s;
    }

    public String getApellido()
    {
        return apellido;
    }

    public void setApellido(String s)
    {
        apellido = s;
    }

    public String getContrasenia()
    {
        return Contrasenia;
    }

    public void setContrasenia(String s)
    {
        Contrasenia = s;
    }


    public String getapertura()
    {
        return apertura;
    }

    public void setapertura(String s)
    {
        apertura = s;
    }

    public Account getAccount()
    {
        return account;
    }

    public void setAccount(Account account1)
    {
        account = account1;
    }

    public String getTcuenta()
    {
        return Tcuenta;
    }

    public void setTcuenta(String s)
    {
        Tcuenta = s;
    }

  
}
