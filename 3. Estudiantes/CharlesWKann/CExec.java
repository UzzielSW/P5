/**
 * @(#)CExec.java
 *
 *
 * @author Prof. Alvaro Pino N.
 * @version 1.00 2007/1/7
 */

public class CExec implements Runnable{
        
    /**
     * Creates a new instance of <code>CExec</code>.
     */
    public CExec() {
    }
        
    public void run(){
    	
    	int counter = 0;
    	System.out.println("In run, counter = " + counter);
    	counter++;
    	System.out.println("In run, counter = " + counter);
    	return;
    }
    
        	    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        CExec ce = new CExec();
        
        Thread t1 = new Thread(ce);
        t1.start();
        System.out.println("in main");
        return;
        
    }
}
