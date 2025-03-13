package controlador;

import java.awt.event.*;
import java.io.*;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import modelo.*;
import view.VistaAgenciaViajes;


/**
 * Esta clase se encarga de gestionar los eventos del sistema.
 * @author Boris Caraballo 
 * @author Oloninikinya Castro
 *
 */
public class ControladorVista implements ActionListener, ListSelectionListener{
	
	JFileChooser chooser;
	JFileChooser chooser2;
	
	LinkedList<Datos> listaDatosCliente;
	LinkedList<Vuelo> listaVuelo;
	
	 VistaAgenciaViajes vistaAgencia;
 
	 String tipoDeVuelo = "";
	 String turno="";
	
	public ControladorVista(VistaAgenciaViajes v){
		
		vistaAgencia = v;
		listaDatosCliente = new LinkedList<>();
		listaVuelo = new LinkedList<>();
		
	
		lea();
		leerVueloDesdeArchivo();
		
		//Registros de evento para los botones
		vistaAgencia.btnReservarVuelo.addActionListener(this);
		vistaAgencia.btnLimpiar.addActionListener(this);
		vistaAgencia.btnAgregar.addActionListener(this);
		vistaAgencia.btnBusquedaCliente.addActionListener(this);
		vistaAgencia.btnEditar.addActionListener(this);
		vistaAgencia.btnOK.addActionListener(this);
		vistaAgencia.btnEliminarVuelo.addActionListener(this);	
		vistaAgencia.btnEliminarRuta.addActionListener(this);	
		vistaAgencia.btnEliminarCliente.addActionListener(this);
		vistaAgencia.btnAgregarRuta2.addActionListener(this);
		vistaAgencia.btnBusquedaVuelo.addActionListener(this);
		vistaAgencia.refrescar.addActionListener(this);
		
		//Registro para los comboBox de Eliminar Vuelos o ruta
		vistaAgencia.guardar.addActionListener(this);
		vistaAgencia.guardarTodo.addActionListener(this);
		
		vistaAgencia.comboVuelos.addActionListener(this);
		
		//Registro de evento para los comboBox de Agregar vuelo:
		vistaAgencia.comboAños.addActionListener(this);
		vistaAgencia.comboDias.addActionListener(this);
		vistaAgencia.comboMeses.addActionListener(this);
		vistaAgencia.comboHoras.addActionListener(this);
		vistaAgencia.comboMinutos.addActionListener(this);
		vistaAgencia.comboBoxOrigen.addActionListener(this);
		vistaAgencia.comboBoxDestino.addActionListener(this);
		vistaAgencia.comboVueloR.addActionListener(this);
		vistaAgencia.comboRutasR.addActionListener(this);
		vistaAgencia.comboAsientosR.addActionListener(this);
		vistaAgencia.comboLineaAerea.addActionListener(this);
		vistaAgencia.comboOrigen.addActionListener(this);
		vistaAgencia.comboRutas.addActionListener(this);
		vistaAgencia.comboTipo.addActionListener(this);
		
		vistaAgencia.rInternacional.addActionListener(this);
		vistaAgencia.rNacional.addActionListener(this);
		vistaAgencia.rAm.addActionListener(this);
		vistaAgencia.rPm.addActionListener(this);
		
		
		//Registro de evento para los JList
		vistaAgencia.listVuelos.addListSelectionListener(this);
		vistaAgencia.listRutas.addListSelectionListener(this);
		vistaAgencia.listReservaciones.addListSelectionListener(this);
		

	
	}
	
	
	/**
	 * Métoodo encargadode leer desde archivo los datos de los clientes.
	 */
	
	private void lea() {
		
		FileInputStream archivo=null;
		try{

			 archivo = new FileInputStream("c:/Users/Boris_2/Desktop/datos2/datos.dat");
		
		}catch(Exception e){
			
			int opc = JOptionPane.showConfirmDialog(null, "¡ No se ha encontrado el archivo datos !" + "\n" + "¿ Desea elegir un archivo ?",
					"Aviso Importante", 2);
			
			if(opc != 0) System.exit(0);
	
			
			chooser = new JFileChooser();
			
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "Archivos de textos", "dat");
		    
		    chooser.setFileFilter(filter);
		    
		    int returnVal = chooser.showOpenDialog(null);
		    
		    if(returnVal == JFileChooser.CANCEL_OPTION) {
		    	System.exit(0);
		    }
		    
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    	
		    	try {
		    		archivo=new FileInputStream(chooser.getSelectedFile().getAbsolutePath());
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
		       
		    }
		    
			
			
		}
		
		try{
		ObjectInputStream obj = new ObjectInputStream(archivo);

		listaDatosCliente = (LinkedList<Datos>)obj.readObject();
		
		vistaAgencia.tablaCliente.setModel(liste());
		
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	/**
	 * 	Método encargado de guardar en archivo los datos de los clientes cuando han reservado un vuelo.
	 */

	public void guarda(){
		
		FileOutputStream archivo=null;
		try{

			archivo = new FileOutputStream ("c:/Users/Boris_2/Desktop/datos2/datos.dat");
			
		}catch(Exception e){
	
			try {
				archivo = new FileOutputStream (chooser.getSelectedFile().getAbsolutePath());
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
			
		}
		

		try {
			
			ObjectOutputStream obj = new ObjectOutputStream(archivo);

			obj.writeObject(listaDatosCliente);
		} catch (IOException e) {
			
			e.printStackTrace();
		} 

		
	}
	
	/**
	 * Este método se encarga de establecer los datos del cliente en una JTable en la pestaña "Buscar y Editar Reservaciones"
	 * @return DefaultTableModel 
	 */
	private DefaultTableModel liste() {
		
		DefaultTableModel modelo;

		modelo = new DefaultTableModel(new Object[]{vistaAgencia.tablaCliente.getColumnName(0), 
				vistaAgencia.tablaCliente.getColumnName(1), vistaAgencia.tablaCliente.getColumnName(2), 
				vistaAgencia.tablaCliente.getColumnName(3), vistaAgencia.tablaCliente.getColumnName(4)}, 0);

		for(int i = 0; i< listaDatosCliente.size(); i++){

			modelo.addRow(new Object[]{listaDatosCliente.get(i).getNombreCliente(),
										listaDatosCliente.get(i).getApellidoCliente(),
										listaDatosCliente.get(i).getPasaporte(), 
										listaDatosCliente.get(i).getNumeroVuelo(), 
										listaDatosCliente.get(i).getNumeroAsiento() });
		}

		return modelo;
	}
	
	/**
	 * Este método es el encargado de obtener los datos del cliente de los JTextField para crear un objeto de tipo Datos y
	 * despues agregarlo en la lista de tipo LinkedList Datos  e actualiza la JTable de la pestaña "Buscar y Editar Reservaciones".
	 * 
	 */
	
	public void validaReservarVuelo(){
				
		String nombre = vistaAgencia.campoNombre.getText();
		String apellido = vistaAgencia.campoApellido.getText();
		String pasaport = vistaAgencia.campoPasaporte.getText();
		String asiento = vistaAgencia.campoAsiento.getText();
		String numeroVuelo = vistaAgencia.campoVueloR.getText();
		String rutaReservacion = vistaAgencia.campoRutaR.getText();
			
		if(nombre.isEmpty() || apellido.isEmpty() || pasaport.isEmpty()
				|| asiento.isEmpty() ||numeroVuelo.isEmpty() || rutaReservacion.isEmpty())
		{
			
			JOptionPane.showMessageDialog(null, "Por favor, rellene todos los campos.", "Error", 0);
			
		}else{
	
			listaDatosCliente.add(new Datos (nombre, apellido, pasaport, asiento, numeroVuelo, rutaReservacion));
			
			JOptionPane.showMessageDialog(null, "Se ha reservado con éxito\n Cliente: "+nombre+" "+apellido, "Éxito",1,  new ImageIcon("iconos/usuarioListo.png"));
			vistaAgencia.tablaCliente.setModel(liste());
			limpiarCampos();
			
		}
		
	}
	
	/**
	 * Este método se encarga de establecer en el JComboBox las rutas especificas de un Vuelo
	 * @param vueloSeleccionado: es vuelo que ha sido seleccionado del JComboBox de vuelo en la pestaña "Eliminar/Agregar Ruta/"
	 */
	private void estableceComboRutas(String vueloSeleccionado) {
		// TODO Auto-generated method stub
		Vuelo tem = new Vuelo();
		
		for(int i=0; i < listaVuelo.size(); i++){
			
			if(vistaAgencia.comboVueloR.getItemAt(i).equals(vueloSeleccionado)){
				tem = listaVuelo.get(i);
				vistaAgencia.comboRutasR.removeAllItems();
				 break;
			}
		}
		
		for(int i=0; i<tem.listaRutas.size(); i ++){
			vistaAgencia.comboRutasR.addItem(tem.listaRutas.get(i).getNombre_Destino());
		}
		
	}
	
	/**
	 * Método que obtiene desde un JTextField el número de pasaporte de un cliente de la pestaña "Buscar y Editar Reservaciones",
	 * para despues recorrer la lista Cliente y establecer los datos que hemos modificado.
	 */
	private void editarCliente(){
		
		String id_a_Buscar = vistaAgencia.campoDeBusquedaCliente.getText();
		
		for(int i=0; i < listaDatosCliente.size(); i++){

			if(listaDatosCliente.get(i).getPasaporte().equals(id_a_Buscar)){

				listaDatosCliente.get(i).setNombreCliente(vistaAgencia.campoEditNombre.getText());
				listaDatosCliente.get(i).setApellidoCliente(vistaAgencia.campoEditApellido.getText());
				listaDatosCliente.get(i).setPasaporte(vistaAgencia.campoEditPasaporte.getText());
				break;
			}
		}
		
	}

	/**
	 * Método encargado de buscar un cliente en específico y mostrarselo al usuario desde los JTextField.
	 */
	private void busque() {
		
		boolean esta = false;
		String id_a_Buscar = vistaAgencia.campoDeBusquedaCliente.getText();
		Datos temporal = new Datos();
		
		if(id_a_Buscar.isEmpty()){
			JOptionPane.showMessageDialog(null, "Por favor, debe de introducir en el campo el Nº de Pasaporte", "Aviso", 2);

		}else{
			
		for(int i=0; i < listaDatosCliente.size(); i++){

			if(listaDatosCliente.get(i).getPasaporte().equals(id_a_Buscar)){
				esta = true;
				temporal = listaDatosCliente.get(i);
				break;
			}
		}

		if(esta){
			
			vistaAgencia.campoEditNombre.setText(temporal.getNombreCliente());
			vistaAgencia.campoEditApellido.setText(temporal.getApellidoCliente());
			vistaAgencia.campoEditPasaporte.setText(temporal.getPasaporte());
			vistaAgencia.campoEditClase.setText(temporal.getNumeroAsiento());
			vistaAgencia.campoEditNVuelo.setText(temporal.getNumeroVuelo());
			vistaAgencia.btnEditar.setEnabled(true);
			vistaAgencia.btnEliminarCliente.setEnabled(true);
			
		}else{
			JOptionPane.showMessageDialog(null, "El cliente no exitse.", "Aviso",0, new ImageIcon("iconos/usuarioError.png"));
		}
		
		}
		
	}
	
	
	/**
	 * Este método sólo cumpreba si los campos de la pestaña "Buscar y Editar Reservaciones" no esten vacio y habilita 
	 * los campos "JTextField" para poder editar los datos de un cliente.
	 */
	private void habilitaLosCamposEditar(){
		if(!vistaAgencia.campoEditNombre.getText().isEmpty() || !vistaAgencia.campoEditApellido.getText().isEmpty() ||
				!vistaAgencia.campoEditPasaporte.getText().isEmpty() || !vistaAgencia.campoEditClase.getText().isEmpty())
	
		{
			vistaAgencia.campoEditNombre.setEditable(true);
			vistaAgencia.campoEditApellido.setEditable(true);
			vistaAgencia.campoEditPasaporte.setEditable(true);
			vistaAgencia.campoEditClase.setEditable(true);
			vistaAgencia.btnOK.setEnabled(true);
			vistaAgencia.btnEditar.setEnabled(false);
			vistaAgencia.btnEliminarCliente.setEnabled(false);
			
		}
	}
	
	private void validaClienteEditable(){
		
		if(vistaAgencia.campoEditNombre.getText().isEmpty() || vistaAgencia.campoEditApellido.getText().isEmpty() ||
				vistaAgencia.campoEditPasaporte.getText().isEmpty() || vistaAgencia.campoEditClase.getText().isEmpty())
	
		{
			
			JOptionPane.showMessageDialog(null, "Por favor, todos los campos son requeridos.", "Aviso",0);
		
		}else{
			
			editarCliente();
			vistaAgencia.tablaCliente.setModel(liste());
			JOptionPane.showMessageDialog(null, "Los datos del cliente se han editado correctamente.", "Éxito",1, new ImageIcon("iconos/ok2.png"));
			vistaAgencia.btnOK.setEnabled(false);
			limpiarCampos();
			vistaAgencia.campoEditNombre.setEditable(false);
			vistaAgencia.campoEditApellido.setEditable(false);
			vistaAgencia.campoEditPasaporte.setEditable(false);
			vistaAgencia.campoEditClase.setEditable(false);
			vistaAgencia.btnEliminarCliente.setEnabled(false);
			
		}
		
	}
	
	/**
	 * Método que se encarga de eliminar un cliente de la lista.
	 * @param numeroPass número de pasaporte de cliente que se utiliza como identificador para poder ser eliminado de la lista.
	 */

	private void eliminarCliente(String numeroPass){
		
		for(int i =0; i < listaDatosCliente.size(); i++){
			
			if(listaDatosCliente.get(i).getPasaporte().equals(numeroPass)){
				
				int respuesta= JOptionPane.showConfirmDialog(null, "¿ Quieres eliminar el cliente con número de pasaporte: "+listaDatosCliente.get(i).getPasaporte()+" ?");
				if(respuesta == 0){
					listaDatosCliente.remove(i);
					limpiarCampos();
					vistaAgencia.campoDeBusquedaCliente.setText("");
					vistaAgencia.tablaCliente.setModel(liste());
					vistaAgencia.btnEditar.setEnabled(false);
					vistaAgencia.btnEliminarCliente.setEnabled(false);
					break;
				}	
			
			}
			
		}
		
		
	}
	
	
	//Métodos para el registro de vuelos o rutas
	
	
	/**
	 * Método encargado de establecer la Tabla de los vuelos.
	 * @return DefaulTableModel retorna un modelo para la tabla de pestaña "Buscar Vuelos"
	 */
	
	private DefaultTableModel listaTablaVuelos(){
		
		DefaultTableModel modelo;

		modelo = new DefaultTableModel(new Object[]{vistaAgencia.tablaVuelos.getColumnName(0), 
				vistaAgencia.tablaVuelos.getColumnName(1), vistaAgencia.tablaVuelos.getColumnName(2), 
				vistaAgencia.tablaVuelos.getColumnName(3), vistaAgencia.tablaVuelos.getColumnName(4), 
				vistaAgencia.tablaVuelos.getColumnName(5)}, 0);

		for(int i = 0; i< listaVuelo.size(); i++){

			modelo.addRow(new Object[]{listaVuelo.get(i).getNombreAerolinea(),
										listaVuelo.get(i).getNumeroVuelo(),
										listaVuelo.get(i).getOrigenVuelo(), 
										listaVuelo.get(i).getTipoDeVuelo(), 
										listaVuelo.get(i).getFecha(),
										listaVuelo.get(i).getHoraSalida()
										
											});
		}

		return modelo;
		
	}

	/**
	 * Método encargado de leer desde archivo la lista Vuelos y establecerlos en los componente JTable, JList y JComboBox 
	 */
	
 	private void leerVueloDesdeArchivo(){
 		FileInputStream archivo = null;
		try{

			archivo = new FileInputStream("c:/Users/Boris_2/Desktop/datos2/vuelos.dat");
			
		}catch(Exception e){


			int opc =	JOptionPane.showConfirmDialog(null, "¡ No se ha encontrado el archivo Vuelos !" + "\n" + "¿ Desea elegir un archivo ?");
			
			if(opc != 0){
				return;
			}
			
			chooser2 = new JFileChooser();
			
		    FileNameExtensionFilter filter = new FileNameExtensionFilter(
		        "Archivos de textos", "dat");
		    
		    chooser2.setFileFilter(filter);
		    
		    int returnVal = chooser2.showOpenDialog(null);
		    
		    
		    if(returnVal == JFileChooser.CANCEL_OPTION) {
		    	return;
		    }
		    
		    
		    if(returnVal == JFileChooser.APPROVE_OPTION) {
		    	
		    	try {
		    		archivo=new FileInputStream(chooser2.getSelectedFile().getAbsolutePath());
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
		       
		    }
			
			
			
			
		}
		
		
		try{
			ObjectInputStream obj = new ObjectInputStream(archivo);

			listaVuelo = (LinkedList<Vuelo>)obj.readObject();

			for(int i =0; i<listaVuelo.size(); i++){
				
				vistaAgencia.comboVuelos.addItem(listaVuelo.get(i).getNumeroVuelo());
				vistaAgencia.comboVueloR.addItem(listaVuelo.get(i).getNumeroVuelo());
		}
		
			vistaAgencia.tablaVuelos.setModel(listaTablaVuelos());
		
			vistaAgencia.listVuelos.setModel(listaDeVuelos());
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
	}
 	
 /**
  * Este método guarda en un archivo la lista de vuelos.
  */
	
	private void guardaVuelos(){
		FileOutputStream archivo=null;
		
		try{

			archivo = new FileOutputStream("c:/Users/Boris_2/Desktop/datos2/vuelos.dat");
			
			
		}catch(Exception e){
			
			
			try {
				archivo = new FileOutputStream(chooser2.getSelectedFile().getAbsolutePath());
			} catch (FileNotFoundException e1) {
			
				e1.printStackTrace();
			}
			
		}
		
		
		try{
			
			ObjectOutputStream obj = new ObjectOutputStream(archivo);

			obj.writeObject(listaVuelo);  
			
		}catch(Exception e){
			
			e.printStackTrace();
		}

	}

	/**
	 * Método encargado de agregar a la lista un nuevo Vuelo.
	 * Obtiene los datos del nuevo vuelo desde los JTextField para poder crear un objeto Vuelo y se crea un objeto Rutas
	 * ya que un vuelo tiene diferentes rutas.
	 *Luego cuando hemos creado el objeto Rutas, poder agregar la ruta en la lista de tipo LinkedList<Rutas> que se encuentra
	 *en el objeto Vuelo que hemos creado.
	 *
	 * 
	 */
	
	private void agregaVuelo(){
		
		String lineaArea = vistaAgencia.campoLineaAerea.getText();
		String numeroV = vistaAgencia.campoNumeroVuelo.getText();
		String origen = vistaAgencia.campoOrigenVuelo.getText();
		String fecha = vistaAgencia.campoFecha.getText();
		String horaSalida = vistaAgencia.campoHoraSalida.getText();
		
		String ruta = vistaAgencia.campoRutaDestino.getText();
		String tarifa = vistaAgencia.campoTarifa.getText();
		
		
		
		if(lineaArea.isEmpty() || numeroV.isEmpty() || origen.isEmpty() || fecha.isEmpty() || horaSalida.isEmpty() || 
				ruta.isEmpty() || tarifa.isEmpty() || tipoDeVuelo.isEmpty())
		{
			
			JOptionPane.showMessageDialog(null, "Por favor, debe de rellenar todos los campos.", "Error",0);
		}
		else
		{
			if(turno.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Por favor debe elegir el turno del vuelo");
				return;
			}
			

			Vuelo v = new Vuelo(lineaArea, numeroV, origen, tipoDeVuelo, horaSalida, fecha);
			Rutas r = new Rutas(ruta, tarifa);
			listaVuelo.add(v);
			v.listaRutas.add(r);

			vistaAgencia.comboVuelos.addItem(listaVuelo.getLast().getNumeroVuelo());
			vistaAgencia.comboVueloR.addItem(listaVuelo.getLast().getNumeroVuelo());
			
			vistaAgencia.tablaVuelos.setModel(listaTablaVuelos());
			vistaAgencia.listVuelos.setModel(listaDeVuelos());
			
			JOptionPane.showMessageDialog(null, "El vuelo se ha registrado correctamente.", "Éxito",1,new ImageIcon("iconos/avion12.png"));
			
			limpiarCampos();
			
		}
		
		
		
	}
	
	/**
	 * Este método muestra los detalles en los JTextArea de un vuelo en específico que ha sido seleccionado desde el JComboBox de la pestaña
	 * "Eliminar/ Agregar vuelo o/ ruta" 
	 * @param seleccionado
	 */
	
	private void muestraDetalles(String seleccionado) {


		boolean esta = false;

		Vuelo vueloTemp = new Vuelo();
		Rutas rutaTemp = new Rutas();
		
		if(seleccionado == null){
			return;
		}
	
		for(int i=0; i < listaVuelo.size(); i++){

			if(listaVuelo.get(i).getNumeroVuelo().equals(seleccionado)){
				esta = true;
				vueloTemp = listaVuelo.get(i);
				break;
			}
		}
		

		if(esta){
			
			vistaAgencia.comboRutas.removeAllItems();
			
			vistaAgencia.miAreaDetalleVuelo.setText("Numero: "+vueloTemp.getNumeroVuelo()+
													"\nAerolínea: "+vueloTemp.getNombreAerolinea()+
													"\nFecha salida: "+vueloTemp.getFecha()+
													"\nHora: "+vueloTemp.getHoraSalida()+
													"\nOrigen: "+vueloTemp.getOrigenVuelo());
			
			vistaAgencia.campoVuelo.setText(vueloTemp.getNumeroVuelo());
			
			vistaAgencia.miAreaDetalleRutas.setText("RUTA         TARIFA\n");
			
			if(vueloTemp.listaRutas.isEmpty()){
				
				JOptionPane.showMessageDialog(null, "Este vuelo no contiene ninguna ruta de destino.", "Aviso", 2);
				
			}else{
		
			for(int j=0; j < vueloTemp.listaRutas.size(); j++){
				
				vistaAgencia.comboRutas.addItem(vueloTemp.listaRutas.get(j).getNombre_Destino());
				
				vistaAgencia.miAreaDetalleRutas.append(vueloTemp.listaRutas.get(j).getNombre_Destino()+"         "+
						vueloTemp.listaRutas.get(j).getTarifa_ruta()+"\n");
 
			}
	
			}	
			vistaAgencia.campoAgregarRuta1.setText(vueloTemp.getNumeroVuelo());
			
			
		}

	}
	
	
	/**
	 * Este método se encarga de eliminar de la lista Vuelo el vuelo correspodiente que hemos escogido del JComboBox.
	 * @param vuelo: el cual almacena en una cadena el número de vuelo que ha sido seleccionado en el JComboBox.
	 */
	
	private void eliminaVuelo(String vuelo) {
		
		if(vuelo.isEmpty()){
			JOptionPane.showMessageDialog(null, "Debe seleccionar un vuelo para poder ser eliminado","Error",1);
		}else{
			
			
			for(int i =0; i < listaVuelo.size(); i++){
				
				if(listaVuelo.get(i).getNumeroVuelo().equals(vuelo)){
					
					int respuesta= JOptionPane.showConfirmDialog(null, "¿ Quieres eliminar el vuelo: "+listaVuelo.get(i).getNumeroVuelo()+" ?");
					if(respuesta == 0){
						listaVuelo.remove(i);
						vistaAgencia.miAreaDetalleVuelo.setText("");
						vistaAgencia.miAreaDetalleRutas.setText("");
						vistaAgencia.campoAgregarRuta1.setText("");
						vistaAgencia.campoVuelo.setText("");
						vistaAgencia.comboVuelos.removeItem(vuelo);
						vistaAgencia.comboVueloR.removeItem(vuelo);
						break;
					}	
				
				}
				
			}
			
			
		}
		
	}	

	/**
	 * Método que elimina la ruta de un vuelo correspondiente que hemos seleccionado en el JComboBox
	 * @param ruta
	 */
	private void eliminaRuta(String ruta) {
		
		Vuelo vueloT = new Vuelo();
		boolean esta = false;
		
		if(ruta.isEmpty()){
			JOptionPane.showMessageDialog(null, "Error", "Error",0);
		}else{
			
			
			for(int i = 0; i < listaVuelo.size(); i++){
				
				if(listaVuelo.get(i).getNumeroVuelo().equals(vistaAgencia.campoAgregarRuta1.getText()))
				{
					vueloT = listaVuelo.get(i);
					esta= true;
					break;
				}
				
			}
			
			 vistaAgencia.miAreaDetalleRutas.setText("RUTA         TARIFA\n");
			if(esta){
				for(int i=0; i < vueloT.listaRutas.size(); i++){
					if(vueloT.listaRutas.get(i).getNombre_Destino().equals(ruta)){
						
						int respuesta= JOptionPane.showConfirmDialog(null, "¿ Deseas eliminar la ruta: "+vueloT.listaRutas.get(i).getNombre_Destino()+" ?");
						if(respuesta == 0){
							vueloT.listaRutas.remove(i);
							vistaAgencia.campoRuta.setText("");
							vistaAgencia.comboRutas.removeItem(ruta);
							break;
						}	
					
					}
					vistaAgencia.miAreaDetalleRutas.append(vueloT.listaRutas.get(i).getNombre_Destino()+"         "+
							vueloT.listaRutas.get(i).getTarifa_ruta()+ "\n");

					
				}
				
			}			
		}
		
	}
	
	/**
	 * Método que se encarga de agregar una nueva ruta a un vuelo en específico.
	 */
	
	private void agregarNuevaRuta(){
		
		boolean esta = false;
		Vuelo vueloTemp = new Vuelo();
		
		String numero = vistaAgencia.campoAgregarRuta1.getText();
		String rutaNueva = vistaAgencia.campoAgregarRuta2.getText();
		String tarifa = vistaAgencia.campoAgregarRuta3.getText();
		
		if(numero.isEmpty()){
			JOptionPane.showMessageDialog(null, "Por favor, debe seleccionar un numero de vuelo","Aviso",2);
			
		}else{
			
			if(rutaNueva.isEmpty() || tarifa.isEmpty()){
				JOptionPane.showMessageDialog(null, "Debe rellenar los campos");
			}else{
				
				for(int i=0; i<listaVuelo.size(); i++){
					if(listaVuelo.get(i).getNumeroVuelo().equals(numero)){
						esta = true;
						vueloTemp = listaVuelo.get(i);
						break;	
					}	
				}
				
				if(esta){
				
				vueloTemp.listaRutas.add(new Rutas(rutaNueva, tarifa));
				
				JOptionPane.showMessageDialog(null, "Se agregó una nueva ruta al vuelo: "+numero, "Éxito",1, new ImageIcon("iconos/addVuelo1.png"));
				
				 vistaAgencia.comboRutas.removeAllItems();  
				 vistaAgencia.campoAgregarRuta2.setText("");
				 vistaAgencia.campoAgregarRuta3.setText("");
				 vistaAgencia.miAreaDetalleRutas.setText("");
				 vistaAgencia.miAreaDetalleRutas.setText("RUTA         TARIFA\n");
				 
				for(int i=0; i<vueloTemp.listaRutas.size();i++)
				{
					vistaAgencia.comboRutas.addItem(vueloTemp.listaRutas.get(i).getNombre_Destino());
					
						vistaAgencia.miAreaDetalleRutas.append(
							vueloTemp.listaRutas.get(i).getNombre_Destino()+"          "+
							vueloTemp.listaRutas.get(i).getTarifa_ruta()+ "\n");

				}
	
				
				}
				
			}
			
		}
		
		
		
	}

	/**
	 *Este método permite al usuario buscar un vuelo en específico, ya que tiene opciones de busqueda en 3 como "Internacional o Nacional"
	 * "Origen del vuelo" y por "Aerolíneas"
	 */
	private void busquedaDeVueloEspecifico() {
		// TODO Auto-generated method stub
		
		Vuelo vueloTemp = new Vuelo();
		boolean flag=false;
		
		String numero = vistaAgencia.campoBusquedaVuelo.getText();
		
		if(numero.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "Por favor, debe de ingresar el numero de vuelo", "Aviso",2);
		}
		else
		{
			
			for(int i=0; i < listaVuelo.size(); i++)
			{
				if(listaVuelo.get(i).getNumeroVuelo().equals(numero)){
					flag = true;
					vueloTemp = listaVuelo.get(i);
					break;
				}
			}
			
			if(flag){
				
				vistaAgencia.cmBusquedaLinea.setText(vueloTemp.getNombreAerolinea());
				vistaAgencia.cmBusquedaNumero.setText(vueloTemp.getNumeroVuelo());
				vistaAgencia.cmBusquedaOrigen.setText(vueloTemp.getOrigenVuelo());
				vistaAgencia.cmBusquedaTipo.setText(vueloTemp.getTipoDeVuelo());
				vistaAgencia.cmBusquedaHora.setText(vueloTemp.getHoraSalida());
				vistaAgencia.cmBusquedaFecha.setText(vueloTemp.getFecha());
				
				
				
			}else{
				limpiarCampos();
				JOptionPane.showMessageDialog(null, "Este número de vuelo no existe.");
			
			}
			
			
		}
		
	}
	
	/**
	 * 
	 * @return DefaultListModel retorna un modelo JList que se establecerá en la pestaña "Listas de Vuelos"
	 */
	
	private DefaultListModel listaDeVuelos(){
		
		DefaultListModel modelo = new DefaultListModel<>();
		
		for(int i=0; i < listaVuelo.size(); i++){
			
			modelo.addElement(listaVuelo.get(i).getNumeroVuelo());
		}
		
		return modelo;
	}
	
	
	/**
	 * 
	 * @param vuelo
	 * @return
	 */
	private DefaultTableModel buscaVuelo(String vuelo) {
		// TODO Auto-generated method stub
		
		DefaultTableModel modelo=null;
		
		modelo = new DefaultTableModel(new Object[]{vistaAgencia.tablaVuelos.getColumnName(0), 
				vistaAgencia.tablaVuelos.getColumnName(1), vistaAgencia.tablaVuelos.getColumnName(2), 
				vistaAgencia.tablaVuelos.getColumnName(3), vistaAgencia.tablaVuelos.getColumnName(4), 
				vistaAgencia.tablaVuelos.getColumnName(5)}, 0);
		
		
		for(int i=0; i < listaVuelo.size(); i++)
		{
			if(listaVuelo.get(i).getNombreAerolinea().equals(vuelo)){

				modelo.addRow(new Object[]{listaVuelo.get(i).getNombreAerolinea(),
						listaVuelo.get(i).getNumeroVuelo(),
						listaVuelo.get(i).getOrigenVuelo(), 
						listaVuelo.get(i).getTipoDeVuelo(), 
						listaVuelo.get(i).getFecha(),
						listaVuelo.get(i).getHoraSalida()
						
							});
				
			}
			
			if(listaVuelo.get(i).getOrigenVuelo().equals(vuelo)){

				modelo.addRow(new Object[]{listaVuelo.get(i).getNombreAerolinea(),
						listaVuelo.get(i).getNumeroVuelo(),
						listaVuelo.get(i).getOrigenVuelo(), 
						listaVuelo.get(i).getTipoDeVuelo(), 
						listaVuelo.get(i).getFecha(),
						listaVuelo.get(i).getHoraSalida()
						
							});
			}
			
			if(listaVuelo.get(i).getTipoDeVuelo().equals(vuelo)){

				modelo.addRow(new Object[]{listaVuelo.get(i).getNombreAerolinea(),
						listaVuelo.get(i).getNumeroVuelo(),
						listaVuelo.get(i).getOrigenVuelo(), 
						listaVuelo.get(i).getTipoDeVuelo(), 
						listaVuelo.get(i).getFecha(),
						listaVuelo.get(i).getHoraSalida()
						
							});
			
		      }
	}
		
			
		return modelo;	
	
}

	/**
	 * Establece en un JTextArea todos los detalles de un cliente en específico que ha sido seleccionado en el JList Reservaciones 
	 * de la pestaña "Lista de vuelos"
	 * @param cliente
	 */
	
	private void detallesDelCliente(String cliente) {
		// TODO Auto-generated method stub
		
		Datos datos = new Datos();
		boolean esta= false;
		
		for(int i=0; i < listaDatosCliente.size(); i++){
			
			if(listaDatosCliente.get(i).getNombreCliente().equals(cliente)){
				datos = listaDatosCliente.get(i);
				esta=true;
				break;
			}
			
		}
		
		if(esta){
			
			vistaAgencia.areaDetalleReser.setText("\nNombre: "+datos.getNombreCliente()
													+"\nApellido: "+datos.getApellidoCliente()
													+"\nPasaporte: "+datos.getPasaporte()
													+"\nAsiento: "+datos.getNumeroAsiento());
		}
		
		
	}

	/**
	 * Establece los detalles de una ruta en específica que ha sido seleccionada del JList Rutas de la pestaña "Lista de Vuelos"
	 * 
	 * @param ruta: contiene una cadena del nombre de la ruta que ha sido seleccionado en el JList Rutas.
	 * @param numeroVuelo: se utiliza como identificador para saber que vuelo en concreto debe de prestar las rutas.
	 */
	
	private void detallesDeRutas(String ruta, String numeroVuelo) {
		// TODO Auto-generated method stub
		
		DefaultListModel modelo = new DefaultListModel<>();
		Vuelo v = new Vuelo();
		Rutas r = new Rutas();
		Datos datos = new Datos();
		boolean esta = false;
		
		for(int i =0; i<listaVuelo.size(); i++){
			if(listaVuelo.get(i).getNumeroVuelo().equals(numeroVuelo)){
			v = listaVuelo.get(i);
			break;
			}
		}
			for(int i=0; i < v.listaRutas.size(); i++){
				if(v.listaRutas.get(i).getNombre_Destino().equals(ruta)){
		
					r = v.listaRutas.get(i);
					esta= true;
					break;
				}
			}
			
		
			for(int i =0; i< listaDatosCliente.size(); i++){
				
				if(( listaDatosCliente.get(i).getRutaReservada().equals(ruta)) && (listaDatosCliente.get(i).getNumeroVuelo().equals(numeroVuelo)) ){
					modelo.addElement(listaDatosCliente.get(i).getNombreCliente());
				}
				
			}
			
			
			if(esta){
			vistaAgencia.areaDetalleRuta.setText("\nDestino: "+r.getNombre_Destino()+"\nTarifa: "+
					r.getTarifa_ruta());
			
			vistaAgencia.listReservaciones.setModel(modelo);
			}
			
			vistaAgencia.areaDetalleReser.setText("");
		
	}

	/**
	 * Muestra los detalles de un vuelo en específico en un JTextArea en la pestaña de "Listas de vuelo"
	 * @param selec: es una cadena que contiene el número del vuelo que ha sido selccionado en el JList
	 */

	private void detallesVuelo(String selec) {
		// TODO Auto-generated method stub
		Vuelo vuelo = new Vuelo();
		boolean esta = false;
		
		for(int i =0; i < listaVuelo.size(); i++){
			if(listaVuelo.get(i).getNumeroVuelo().equals(selec)){
				vuelo = listaVuelo.get(i);
				esta = true;
				break;
			}
			
		}
		
		if(esta){
			
			vistaAgencia.areaDetalleVuelos.setText("\nNumero: "+vuelo.getNumeroVuelo()+
					"\nAerolínea: "+vuelo.getNombreAerolinea()+
					"\nFecha salida: "+vuelo.getFecha()+
					"\nHora: "+vuelo.getHoraSalida()+
					"\nOrigen: "+vuelo.getOrigenVuelo());
			
			vistaAgencia.listRutas.setModel(estableceListRutas(vuelo));
			
			vistaAgencia.areaDetalleRuta.setText("");
			vistaAgencia.areaDetalleReser.setText("");
			vistaAgencia.listReservaciones.setListData(new Object[]{null});
			
		}
			
	}

	/**
	 * Establece el JList de Rutas en la pestaña de "Listas Rutas" cuando un vuelo en específico ha sido seleccionado.
	 * @param vuelo: Es un Objeto de tipo Vuelo que ya contiene la información del vuelo seleccionado.
	 * @return DefaultListModel retorna un modelo JList que será establecido en el JList de Rutas.
	 */
	
	private DefaultListModel estableceListRutas(Vuelo vuelo) {
		// TODO Auto-generated method stub
		
		DefaultListModel modelo = new DefaultListModel<>();
		
		for(int i =0; i < vuelo.listaRutas.size(); i++){
			
			modelo.addElement(vuelo.listaRutas.get(i).getNombre_Destino());
		}
		return modelo;
	}
	
	
	/**
	 * Limpia los campos de los JTextField de todo el programa.
	 */
	
	private void limpiarCampos(){
		
		vistaAgencia.campoLineaAerea.setText("");
		vistaAgencia.campoNumeroVuelo.setText("");
		vistaAgencia.campoRutaDestino.setText("");
		vistaAgencia.campoTarifa.setText("");
		vistaAgencia.campoFecha.setText("");
		vistaAgencia.campoHoraSalida.setText("");
		vistaAgencia.campoOrigenVuelo.setText("");
		
		vistaAgencia.campoNombre.setText("");
		vistaAgencia.campoApellido.setText("");
		vistaAgencia.campoPasaporte.setText("");
		vistaAgencia.campoVueloR.setText("");
		vistaAgencia.campoRutaR.setText("");
		vistaAgencia.campoAsiento.setText("");
		
		vistaAgencia.campoEditNombre.setText("");
		vistaAgencia.campoEditApellido.setText("");
		vistaAgencia.campoEditPasaporte.setText("");
		vistaAgencia.campoEditClase.setText("");
		vistaAgencia.campoEditNVuelo.setText("");
		
		vistaAgencia.cmBusquedaLinea.setText("");
		vistaAgencia.cmBusquedaNumero.setText("");
		vistaAgencia.cmBusquedaOrigen.setText("");
		vistaAgencia.cmBusquedaTipo.setText("");
		vistaAgencia.cmBusquedaHora.setText("");
		vistaAgencia.cmBusquedaFecha.setText("");
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == vistaAgencia.rInternacional) tipoDeVuelo = "Internacional";
		if(e.getSource() == vistaAgencia.rNacional) tipoDeVuelo = "Nacional";
		if(e.getSource() == vistaAgencia.rAm)turno = "am";
		if(e.getSource() == vistaAgencia.rPm)turno = "pm";

		
		if(e.getSource() == vistaAgencia.btnLimpiar) limpiarCampos();
		
		if(e.getSource() == vistaAgencia.guardarTodo){
			guarda();
			guardaVuelos();
		}
		
		if(e.getSource() == vistaAgencia.guardar){
			
			int i = vistaAgencia.pestañas.getSelectedIndex();
			
			//System.out.println(i);
			
			if(i == 0 || i ==1){
				guarda();
			}else{
				guardaVuelos();
			}
			
		}
		
		
		if(e.getSource() == vistaAgencia.btnReservarVuelo){
			
			validaReservarVuelo();
		}
		
		if(e.getSource()  == vistaAgencia.btnBusquedaCliente){
			busque();
		}
		
		if(e.getSource() == vistaAgencia.btnEditar){
			
			habilitaLosCamposEditar();		
		}
		
		if(e.getSource() == vistaAgencia.btnOK){
		
			validaClienteEditable();
		}		
		
		if(e.getSource() == vistaAgencia.btnEliminarCliente){
			eliminarCliente(vistaAgencia.campoDeBusquedaCliente.getText());
		}
		
		if(e.getSource() == vistaAgencia.refrescar){
			vistaAgencia.tablaVuelos.setModel(listaTablaVuelos());
		}
			
		
		//Evento para los botones de Vuelos y rutas:
		
		if(e.getSource() == vistaAgencia.btnAgregar){
			agregaVuelo();
		}
		
		
		if(e.getSource() == vistaAgencia.btnEliminarVuelo){
			eliminaVuelo(vistaAgencia.campoVuelo.getText());
		}
		
		if(e.getSource() == vistaAgencia.btnEliminarRuta){
			eliminaRuta(vistaAgencia.campoRuta.getText());
		}
		
		if(e.getSource() == vistaAgencia.btnAgregarRuta2){
			agregarNuevaRuta();
		}
		
		if(e.getSource() == vistaAgencia.btnBusquedaVuelo){
			busquedaDeVueloEspecifico();
		}
		
		
		//Evento para los comboBox...
		
		if((e.getSource() == vistaAgencia.comboDias)
				|| (e.getSource() ==vistaAgencia.comboMeses) 
				||(e.getSource() == vistaAgencia.comboAños))
		{
			
			String dia = (String) vistaAgencia.comboDias.getSelectedItem();
			String mes = (String)vistaAgencia.comboMeses.getSelectedItem();
			String año = (String)vistaAgencia.comboAños.getSelectedItem();
			
			vistaAgencia.campoFecha.setText(dia+"/"+mes+"/"+año);
		}
	
		
		if((e.getSource() == vistaAgencia.comboHoras) || (e.getSource() == vistaAgencia.comboMinutos) 
				||(e.getSource()==vistaAgencia.rPm) || (e.getSource() == vistaAgencia.rAm))
		{
			String hora = (String)vistaAgencia.comboHoras.getSelectedItem();
			String minuto = (String) vistaAgencia.comboMinutos.getSelectedItem();
			String t = turno;
			vistaAgencia.campoHoraSalida.setText(hora+":"+minuto+" "+t);
		}
		
	
		if(e.getSource() == vistaAgencia.comboVuelos){
			
			String seleccionado = (String)vistaAgencia.comboVuelos.getSelectedItem();
			muestraDetalles(seleccionado);
		}
		
		
		if(e.getSource() == vistaAgencia.comboBoxOrigen){
			String paisO = (String)vistaAgencia.comboBoxOrigen.getSelectedItem();
			vistaAgencia.campoOrigenVuelo.setText(paisO);
		}
		
		if(e.getSource() == vistaAgencia.comboBoxDestino){
			String paisD = (String)vistaAgencia.comboBoxDestino.getSelectedItem();
			vistaAgencia.campoRutaDestino.setText(paisD);
		}
		
		//JComboBox de Pestaña de Reservar
		if(e.getSource() == vistaAgencia.comboVueloR){
			String vueloSeleccionado = (String) vistaAgencia.comboVueloR.getSelectedItem();
			estableceComboRutas(vueloSeleccionado);
			vistaAgencia.campoVueloR.setText(vueloSeleccionado);
		}
		
		if(e.getSource() == vistaAgencia.comboRutasR){
			String rutaSelecc = (String)vistaAgencia.comboRutasR.getSelectedItem();
			vistaAgencia.campoRutaR.setText(rutaSelecc);
		}
		
		if(e.getSource() == vistaAgencia.comboAsientosR){
			vistaAgencia.campoAsiento.setText((String) vistaAgencia.comboAsientosR.getSelectedItem());
		}
		
		if(e.getSource() == vistaAgencia.comboLineaAerea){
			String linea = (String)vistaAgencia.comboLineaAerea.getSelectedItem();
			vistaAgencia.tablaVuelos.setModel(buscaVuelo(linea));
		}
		
		if(e.getSource() == vistaAgencia.comboOrigen){
			String origen = (String)vistaAgencia.comboOrigen.getSelectedItem();
			vistaAgencia.tablaVuelos.setModel(buscaVuelo(origen));
		}
		
		if(e.getSource() == vistaAgencia.comboTipo){
			String tipoDeVuelo = (String)vistaAgencia.comboTipo.getSelectedItem();
			vistaAgencia.tablaVuelos.setModel(buscaVuelo(tipoDeVuelo));
		}
		
		if(e.getSource() == vistaAgencia.comboRutas){
			String eliminarR = (String)vistaAgencia.comboRutas.getSelectedItem();
			vistaAgencia.campoRuta.setText(eliminarR);
		}
		
	}
	



	//Método de evento para los JList.
	
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource() == vistaAgencia.listVuelos) {
			String selec = (String) vistaAgencia.listVuelos.getSelectedValue();
			detallesVuelo(selec);
		}
		if(e.getSource() == vistaAgencia.listRutas) {
			String vuelo = (String) vistaAgencia.listVuelos.getSelectedValue();
			String ruta = (String) vistaAgencia.listRutas.getSelectedValue();
			detallesDeRutas(ruta, vuelo);
			
		}
		
		if(e.getSource() == vistaAgencia.listReservaciones){
			String cliente = (String) vistaAgencia.listReservaciones.getSelectedValue();
			detallesDelCliente(cliente);
		}
		
	
		
	}

	
	
	
}





