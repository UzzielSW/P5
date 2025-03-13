package modelo;

import java.io.Serializable;
import java.util.LinkedList;



/**
 * La clase Vuelo tiene los atributos necesarios de un vuelo, lo cual le permitirá 
 * guardar los datos de un vuelo en especifico e implementa la interface Serializable ya que al crear un ejemplar de esta clase
 * sera serializado y guardado en archivo.
 * @author Boris Caraballo.
 *
 */
public class Vuelo implements Serializable {

	private String nombreAerolinea;
	private String numeroVuelo;
	private String origenVuelo;
	private String tipoDeVuelo;
	private String horaSalida;
	private String fecha;
	
	public  LinkedList<Rutas> listaRutas = new LinkedList<>();
	

	private static final long serialVersionUID = 3L;
	
	
	public Vuelo(){
		
	}
	
	
	public Vuelo(String nombreAerolinea, String numeroVuelo, String origenVuelo, String tipoDeVuelo, String horaSalida,
			String fecha) {
		super();
		this.nombreAerolinea = nombreAerolinea;
		this.numeroVuelo = numeroVuelo;
		this.origenVuelo = origenVuelo;
		this.tipoDeVuelo = tipoDeVuelo;
		this.horaSalida = horaSalida;
		this.fecha = fecha;
	}

	public String getTipoDeVuelo() {
		return tipoDeVuelo;
	}

	public void setTipoDeVuelo(String tipoDeVuelo) {
		this.tipoDeVuelo = tipoDeVuelo;
	}



	public String getNumeroVuelo() {
		return numeroVuelo;
	}

	public void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}

	public String getOrigenVuelo() {
		return origenVuelo;
	}

	public void setOrigenVuelo(String origenVuelo) {
		this.origenVuelo = origenVuelo;
	}

	public String getHoraSalida() {
		return horaSalida;
	}

	public void setHoraSalida(String horaSalida) {
		this.horaSalida = horaSalida;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getNombreAerolinea() {
		return nombreAerolinea;
	}

	public void setNombreAerolinea(String nombreAerolinea) {
		this.nombreAerolinea = nombreAerolinea;
	}


	
	
}
