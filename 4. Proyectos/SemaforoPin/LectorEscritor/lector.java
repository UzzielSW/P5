
public class lector extends Thread{
	
	gestorOperaciones elGestor;
	int lectorId;
	
	public lector(gestorOperaciones elGestor, int lectorId){
		this.elGestor = elGestor;
		this.lectorId = lectorId;
	}
	
	public void run(){
		try {
			while(true) {
				Thread.sleep(3000);
				System.out.println
     		   		("---- El lector " + lectorId + " intenta leer");
				elGestor.permisoLeer(lectorId);
				System.out.println
    		   		("---- El lector " + lectorId + " lee");
				Thread.sleep(1000);
				System.out.println
 		   		    ("---- El lector " + lectorId + " termina de leer");

				elGestor.finLeer(lectorId);
			}	
		}catch(InterruptedException ie){}
	}

}
