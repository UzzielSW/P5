/*
 * Esta clase genera el nodo
 * @author David Rodríguez
 * */
public class Nodo {
    int CCuenta;
    String Nombre;
    String Apellido;
    double SaldoA;
    double SaldoC;
    Nodo nodoDer;
   
    /*
     * Este metodo ingresa los valores al nodo y evalua que tipo de cuenta es
     * */
    public Nodo(int CC, String nombre, String apellido, int TC, double IoR) {
    	System.out.println("aceptado");
    		this.CCuenta = CC;
    	    this.Nombre = nombre;
    	    this.Apellido = apellido;
    	    if(TC==0){
    	    	this.SaldoA = IoR;
    	    	this.SaldoC = -1;
    	    	}
    	    else if(TC==1){
    	    	this.SaldoC = IoR;
    	    	this.SaldoA = -1;
    	    	}
    	    this.nodoDer = null;
    }
}

