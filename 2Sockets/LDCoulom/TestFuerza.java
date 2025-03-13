/**
 * @(#)TestFuerza.java
 *
 *
 * @author 
 * @version 1.00 2021/9/6
 */

public class TestFuerza  {
        
    /**
     * Creates a new instance of <code>TestFuerza</code>.
     */
    public TestFuerza() {
    }
    
    /**
     * @param args the command line arguments
     */
    
        
  	public static void main(String[] args) 
  		{
		Punto p1 = new Punto(0.0, 0.0);
		Punto p2 = new Punto(1.0, 0.0);
		System.out.println("Distacia:" + p1.calcDistancia(p2));
	
	/*	System.out.println("P1" + p1.getDetails());
		System.out.println("P2" + p2.getDetails());
		
		Distancia d = new Distancia(p1, p2);
		System.out.println(d.getDetails());
	*/	
		Carga q1 = new Carga(1.0, p1);
		Carga q2 = new Carga(1.0, p2);
		
		System.out.println(q1.getDetails());
		System.out.println(q2.getDetails());
		
		Fuerza f = new Fuerza(q1, q2);
			System.out.println(" K = " +Fuerza.K);
		System.out.println(" K = " +f.getK());
		System.out.println(" Fueraz = " + f.getDetails());
	}

        
        
    
}
