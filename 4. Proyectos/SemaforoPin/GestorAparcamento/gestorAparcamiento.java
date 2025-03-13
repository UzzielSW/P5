
public class gestorAparcamiento {
	
	private int capacidad = 10;

    private int nCoches = 0;
    private int nCochesEsperandoNorte = 0;
    private int nCochesEsperandoSur = 0;
    private boolean turnoSur = true; 
    private boolean turnoNorte = true; 
    
    public synchronized void entrarAparcamientoSur(int idCoche)
       	throws InterruptedException{    

    	nCochesEsperandoSur++;	    	
    	System.out.println("---- El coche " + idCoche + 
    			" intenta entrar en el aparcamiento por el sur, " 
    			+ nCochesEsperandoSur);
    	
    	while(nCoches == capacidad || !turnoSur) {wait();} 	
    	nCochesEsperandoSur--;	    	
    	
       	nCoches ++;
		System.out.println("---- El coche " + idCoche + 
				" entra en el aparcamiento por el sur, " +
				nCoches);
    	
    	if (nCoches == capacidad){
            turnoSur = false;
            turnoNorte = true;	
    	}
    }
    
    public synchronized void entrarAparcamientoNorte(int idCoche) 
    	throws InterruptedException{

    	nCochesEsperandoNorte++;	    	
    	System.out.println("++++ El coche " + idCoche + 
    			" intenta entrar en el aparcamiento por el norte, " + 
    			nCochesEsperandoNorte);

    	while(nCoches == capacidad || !turnoNorte) {wait();} 
    	nCochesEsperandoNorte--;	    	
        
    	nCoches ++;
		System.out.println("++++ El coche " + idCoche + 
				" entra en el aparcamiento por el norte, " +
				nCoches);

		if (nCoches == capacidad){
            turnoSur   = true;
            turnoNorte = false;	
    	}
    }

    public synchronized void salirAparcamiento(int idCoche){
      
    	if (nCoches < capacidad ||
            (nCoches == capacidad
              && (nCochesEsperandoNorte == 0 || 
                  nCochesEsperandoSur == 0 )))   {
             turnoNorte = true;
             turnoSur = true;
          }

        nCoches --;
    	
    	System.out.println("**** El coche " + idCoche + 
    			" sale del aparcamiento, " +
    			nCoches);

    	notifyAll();
    }
}