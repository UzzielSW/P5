package modelo;

import java.io.Serializable;


/**
 * La clase Datos tiene los atributos de un cliente para la reservación de un Vuelo e implementa la interface Serializable
 * para que los datos del cliente se guarden en un archivo.
 * 
 * @author Boris Caraballo.
 *
 */
public class Datos implements Serializable {

	private String nombreCliente;
	private String apellidoCliente;
	private String pasaporte;
	private String numeroAsiento;
	private String numeroVuelo;
	private String rutaReservada;
	
	private static final long serialVersionUID = 1L;
	
	public Datos() {
		
	}

	
	
	public Datos(String nombreCliente, String apellidoCliente, String pasaporte, String numeroAsiento,
			String numeroVuelo, String rutaReservada) {
		super();
		this.nombreCliente = nombreCliente;
		this.apellidoCliente = apellidoCliente;
		this.pasaporte = pasaporte;
		this.numeroAsiento = numeroAsiento;
		this.numeroVuelo = numeroVuelo;
		this.rutaReservada = rutaReservada;
	}



	public String getNombreCliente() {
		return nombreCliente;
	}

	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}

	public String getApellidoCliente() {
		return apellidoCliente;
	}

	public void setApellidoCliente(String apellidoCliente) {
		this.apellidoCliente = apellidoCliente;
	}

	public String getPasaporte() {
		return pasaporte;
	}

	public void setPasaporte(String pasaporte) {
		this.pasaporte = pasaporte;
	}

	public String getNumeroAsiento() {
		return numeroAsiento;
	}

	public void setNumeroAsiento(String numeroAsiento) {
		this.numeroAsiento = numeroAsiento;
	}

	@Override
	public String toString() {
		return "Datos [nombreCliente=" + nombreCliente + ", apellidoCliente=" + apellidoCliente + ", pasaporte="
				+ pasaporte + ", numeroAsiento=" + numeroAsiento + "]";
	}

	public String getNumeroVuelo() {
		return numeroVuelo;
	}

	public void setNumeroVuelo(String numeroVuelo) {
		this.numeroVuelo = numeroVuelo;
	}

	public String getRutaReservada() {
		return rutaReservada;
	}

	public void setRutaReservada(String rutaReservada) {
		this.rutaReservada = rutaReservada;
	}
	
	
	
	
	
	
}
