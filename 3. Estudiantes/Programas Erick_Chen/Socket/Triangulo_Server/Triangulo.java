import java.io.*;
public class Triangulo implements Serializable{
    private int base,altura;
    private double area;
    private static int BASE_SIZE=20,ALTURA_SIZE=20;
    final static int RECORD_SIZE=(BASE_SIZE+ALTURA_SIZE);
    public Triangulo(){
        
    }
    public Triangulo(int base,int altura){
        this.base=base;
        this.altura=altura;
    }
    public int getBase(){
        return base;
    }
    public int getAltura(){
        return altura;
    }
    public double getArea(){
        return area;
    }
    public String toString(){//contiene la base y la altura
        return ("Base: "+getBase()+"\nAltura"+getAltura()+
                "\n"+getArea());
    }
    public void toArea(){        
        area=(base*altura)/2.0;
    }
}
