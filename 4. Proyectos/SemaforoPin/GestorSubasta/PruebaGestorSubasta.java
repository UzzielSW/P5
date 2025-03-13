
public class PruebaGestorSubasta {

		/**
		 * @param args
		 */
		public static void main(String[] args) {

		   int n = 5;
		   GestorSubasta unMonitorSubasta = new GestorSubasta();
		   HebraGestora laHebraGestora = new HebraGestora(unMonitorSubasta);
		   laHebraGestora.start();
		   HebraCliente unaHebra;
	    
	       for (int i=0; i < n; i++){
	    	   if (i < 1) {
		    	   unaHebra = new HebraCliente(i, unMonitorSubasta, -1);	    		
	     	   } else if (i > 3){
		       	   unaHebra = new HebraCliente(i, unMonitorSubasta, 1);
	    	   } else {
		    	   unaHebra = new HebraCliente(i, unMonitorSubasta, 0);	    		
	    	   }
	           unaHebra.start();
	       } 
	    }
}
