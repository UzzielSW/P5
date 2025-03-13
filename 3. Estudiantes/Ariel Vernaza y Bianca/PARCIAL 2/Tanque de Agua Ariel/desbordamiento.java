import java.lang.Throwable.*;

public class Desbordamiento extends Exception{
 boolean desbordado;
 double galones;
	public Desbordamiento(double desbordado){
		this.desbordado=true;
		this.galones=desbordado;
	}
}
