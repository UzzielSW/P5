/**
 * @(#)TestDistancia.java
 *
 *
 * @author 
 * @version 1.00 2021/9/6
 */

public class TestDistancia {
        
    /**
     * Creates a new instance of <code>TestFuerza</code>.
     */
    public TestDistancia() {
    }
    
    /**
     * @param args the command line arguments
     */
    
        
  	public static void main(String[] args) 
  		{
		Punto p1 = new Punto(0.0, 0.0);
		Punto p2 = new Punto(1.0, 0.0);
		
		System.out.println("P1" + p1.getDetails());
		System.out.println("P2" + p2.getDetails());
		
		Distancia d = new Distancia(p1, p2);
		System.out.println(d.getDetails());
		
		
	}

        
        
    
}
