import java.util.*;

public class Trabaja implements Runnable{
	
	String mDespedida = "erróneo";
    String mensaje;
	
	public Trabaja(String mensaje) {
        this.mensaje = mensaje;
	}
	
    public String despedida() {
        return mDespedida;
    }

    public void run(){
		
        try{
            System.out.println("Arrancada hebra con argumento " 
                               + mensaje);
            Thread.sleep(4000);
            
        } catch(InterruptedException ie){}
        mDespedida = "correcto";
		
	}
}
