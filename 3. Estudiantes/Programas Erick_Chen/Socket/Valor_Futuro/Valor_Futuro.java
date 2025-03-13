import java.io.*;

public class Valor_Futuro implements Serializable {
    private int monto, anos;
    private double valorfuturo, interes;

    public Valor_Futuro() {

    }

    public Valor_Futuro(int m, int a, double i) {
        this.monto = m;
        this.anos = a;
        this.interes = i;
    }

    public int getmonto() {
        return monto;
    }

    public int getanos() {
        return anos;
    }

    public double getinteres() {
        return interes;
    }

    public double getvalorfuturo() {
        return valorfuturo;
    }

    public String toString() {// contiene la base y la altura
        return ("Monto: " + getmonto() + "\nAltura: " + getanos() + "\nInteres: " + getinteres() +
                "\nValor Futuro" + getvalorfuturo());
    }

    public void toCalculo() {
        valorfuturo = (monto * Math.pow(1 + ((interes) / 12) / 100, anos * 12));
    }
}
