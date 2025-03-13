import java.lang.Throwable.*;

public class SubDesbordamiento extends Exception {

	public boolean subdevolv;
	public double galones;
public SubDesbordamiento(double desbordado){
	this.subdevolv=true;
	this.galones=desbordado;	
	}
}
