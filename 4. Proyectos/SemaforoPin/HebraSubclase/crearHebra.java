import java.util.*;

public class crearHebra {
    
	public static void main(String[] args) {
		
		String mensaje = "bien";
		
        Trabaja trabajador = new Trabaja(mensaje);
        trabajador.start();
        
        try{
            Thread.sleep(2000);
            trabajador.join();
        } catch(InterruptedException ie){}
        
        System.out.println("Terminada hebra con resultado "
                           + trabajador.despedida());
        

	}

}
