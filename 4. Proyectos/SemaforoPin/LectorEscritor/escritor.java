public class escritor extends Thread{
	
	gestorOperaciones elGestor;
	int escritorId;
	
	public escritor(gestorOperaciones elGestor, int escritorId){
		this.elGestor = elGestor;
		this.escritorId = escritorId;
	}
	
	public void run(){
		try {
			while(true) {
				Thread.sleep(3000);
				System.out.println
			   		("---- El escritor " + escritorId + " intenta escribir");
				elGestor.permisoEscribir(escritorId);
				System.out.println
				    ("---- El escritor " + escritorId + " escribe");
				Thread.sleep(1000);
				System.out.println
     		   		("---- El escritor " + escritorId + " termina de escribir");
				elGestor.finEscribir(escritorId);
			}	
		}catch(InterruptedException ie){}
	}

}
