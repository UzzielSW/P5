/**
 * @(#)TestPunto.java
 *
 *
 * @author 
 * @version 1.00 2021/9/6
 */

public class TestPunto {
        
    /**
     * Creates a new instance of <code>TestFuerza</code>.
     */
    public TestPunto() {
    }
    
    /**
     * @param args the command line arguments
     */
    
        
  	public static void main(String[] args) 
  		{
  			
		Punto p1 = new Punto(0.0, 0.0);
		Punto p2 = new Punto(1.0, 0.0);
		
		  p1.x = p1.x + 2;
		  p1.y = p1.y + 3;
		
		System.out.println("(" + p1.x + "," + p1.y + ")");
		System.out.println("(" + p2.x + "," + p2.y + ")");
	
		System.out.println("P1" + p1.getDetails());
		System.out.println("P2" + p2.getDetails());
	
	/*	
		System.out.println("La distancia entre estos es: " + p1.calcDistancia(p2) + " ms.\n");
		System.out.println("La distancia entre estos es: " + p2.calcDistancia(p1) + " ms.\n");
	*/	
	}

        
        
    
}
