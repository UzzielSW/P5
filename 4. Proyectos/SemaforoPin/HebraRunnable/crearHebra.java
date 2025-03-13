import java.util.*;

public class crearHebra {
		
	public static void main(String[] args) {
		
		String mensaje = "bien";
		
        Trabaja trabajador = new Trabaja(mensaje);
        Thread trabajadorT = new Thread(trabajador);
        
        trabajadorT.start();
        try{
            Thread.sleep(2000);
            trabajadorT.join();
        } catch(InterruptedException ie){}

        System.out.println("Terminada hebra con resultado "
                           + trabajador.despedida());
	}}
