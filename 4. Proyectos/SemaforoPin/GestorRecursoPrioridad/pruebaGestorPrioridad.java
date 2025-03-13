
public class pruebaGestorPrioridad {

	public static void main(String[] args) {
	
		int nUsuarios = 6;
		GestorRecursoPrioridad gestorRecurso = new GestorRecursoPrioridad();
		
		usuarioRecurso[] usuarios  = new usuarioRecurso[nUsuarios];	
		Thread[] usuariosT         = new Thread[nUsuarios];
		
		for (int i = 0; i < nUsuarios; i=i+3){
			usuarios[i] = new usuarioRecurso(i, Prioridad.alta, gestorRecurso);
			usuariosT[i]= new Thread(usuarios[i]);
			usuariosT[i].start();
			}
	
		for (int i = 1; i < nUsuarios; i=i+3){
			usuarios[i] = new usuarioRecurso(i, Prioridad.media, gestorRecurso);
			usuariosT[i]= new Thread(usuarios[i]);
			usuariosT[i].start();
			}

		for (int i = 2; i < nUsuarios; i=i+3){
			usuarios[i] = new usuarioRecurso(i, Prioridad.baja, gestorRecurso);
			usuariosT[i]= new Thread(usuarios[i]);
			usuariosT[i].start();
			}
	}

}
