package modelo;

import java.io.Serializable;
import java.util.LinkedList;


/**La clase Rutas tiene como próposito el nombre de destino de un vuelo o rutas y tarifa que tiene un vuelo en especifico, 
 * ya que la clase Vuelo tiene un LinkedList de tipo Rutas.
 * Esta clase implementa la interface Serializable, lo cual será guardada en archivo con el objeto Vuelo. 
 * 
 * @author Boris Caraballo.
 *
 */
public class Rutas implements Serializable {
	
	private String nombre_Destino;
	private String tarifa_ruta;

	
	private static final long serialVersionUID = 2L;
	
	public Rutas(){
		
	}
	
	
	public Rutas(String nombre_Destino, String tarifa_ruta) {
	
		this.nombre_Destino = nombre_Destino;
		this.tarifa_ruta = tarifa_ruta;
	}


	public String getNombre_Destino() {
		return nombre_Destino;
	}


	public void setNombre_Destino(String nombre_Destino) {
		this.nombre_Destino = nombre_Destino;
	}


	public String getTarifa_ruta() {
		return tarifa_ruta;
	}


	public void setTarifa_ruta(String tarifa_ruta) {
		this.tarifa_ruta = tarifa_ruta;
	}


	@Override
	public String toString() {
		return "Rutas [nombre_Destino=" + nombre_Destino + ", tarifa_ruta=" + tarifa_ruta + "]";
	}


	
}
