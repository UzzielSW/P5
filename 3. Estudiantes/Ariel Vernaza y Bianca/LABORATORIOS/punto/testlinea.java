import javax.swing.JOptionPane;
public class TestLinea{
	public static void main(String arg[]){		
		linea a=new linea(new Punto(0.0,0.0),new Punto(0.0,0.0));
		linea b=new linea(new Punto(0.0,0.0),new Punto(0.0,0.0));
		 JOptionPane.showMessageDialog(null,"La linea es de: "+a.imprime_linea());
		 JOptionPane.showMessageDialog(null,"nLa linea es de: "+b.imprime_linea());
		 Punto c=new Punto();
		 c=a.calcula_interseccion(b);
		 JOptionPane.showMessageDialog(null,"La intereseccion es: "+c.display());
		 		
	}
	
}