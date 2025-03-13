package view;

import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.util.LinkedList;

import javax.swing.*;
import javax.swing.text.MaskFormatter;



/**
 * La clase VistaAgenciaViajes extiende de JFrame ya que es la encargada de crearnos el marco y todos los componentes
 * que tiene el sistema Agencia de Viajes.
 * 
 * @author Boris Caraballo.
 *@author Oloninikinya Castro
 */

public class VistaAgenciaViajes extends JFrame{
	
	public JTabbedPane pestañas;
	public ButtonGroup migrupo2;
	
	public JMenuBar miBarra;
	public JMenu archivo, salir;
	public JMenuItem guardar, exit, guardarTodo;
	public JPanel panelReserva, panelDeleteReservacion, panelEditarReservacion, panelBuscar ;
	public JPanel panelAgregarVuelo, panelEliminaVuelo, panelListasVuelos,panelBuscarVuelos;
	
	//Componentes de AgregarVuelo/Ruta
	public JLabel txtLineaArea, txtNumeroVuelo, txtOrigenVuelo;
	public JTextField campoLineaAerea, campoNumeroVuelo, campoOrigenVuelo;
	public JTextField campoRutaDestino, campoFecha, campoTarifa, campoHoraSalida; 
	
	public JComboBox comboBoxOrigen, comboBoxDestino;
	public JRadioButton rNacional, rInternacional;
	public JRadioButton rAm, rPm;
	
	
	public JComboBox comboDias, comboMeses, comboAños;
	public JComboBox comboHoras, comboMinutos;
	public JButton btnAgregar, btnAgregarRuta, btnLimpiar;
	
	
	//Componentes para pestaña de Eliminar/agregar vuelo / o Ruta
	public JComboBox comboVuelos, comboRutas;
	public JTextArea miAreaDetalleVuelo, miAreaDetalleRutas;
	public JTextField campoVuelo, campoRuta, campoAgregarRuta1, campoAgregarRuta2, campoAgregarRuta3 ;
	public JButton btnEliminarVuelo, btnEliminarRuta, btnAgregarRuta2;
	
	
	//Componentes para la pestaña de Reserva
	public JTextField campoNombre, campoApellido, campoPasaporte, campoVueloR, campoRutaR, campoAsiento;

	public JComboBox comboVueloR, comboRutasR, comboAsientosR;
	public JButton btnReservarVuelo;
	
	
	//Componentes para la pestaña de Listas de Vuelo
	public JTextArea areaDetalleVuelos, areaDetalleRuta, areaDetalleReser;
	public JList listVuelos, listRutas, listReservaciones;
	
	

	//Componentes de la pestaña de Busqueda y Edicion
	public JTextField campoEditPasaporte, campoEditNombre, campoEditApellido, campoEditClase, campoEditNVuelo;
	public JTextField campoDeBusquedaCliente;
	public JTable tablaCliente;
	public JButton btnBusquedaCliente, btnEditar, btnOK, btnEliminarCliente;
	
	
	//Componentes para Busqueda de Vuelos
	public JTable tablaVuelos;
	public JTextField cmBusquedaLinea, cmBusquedaNumero, cmBusquedaOrigen, cmBusquedaTipo,
	                  cmBusquedaHora, cmBusquedaFecha, campoBusquedaVuelo;
	public JButton btnBusquedaVuelo;
	public JComboBox comboLineaAerea, comboOrigen, comboTipo;
	public JButton refrescar;
	
	
	public  VistaAgenciaViajes() {
		
		setTitle("Agencia de Viajes");
		setSize(700,500);
		setIconImage(Toolkit.getDefaultToolkit().getImage("iconos/2.png"));
		setLocationRelativeTo(null);
		setResizable(false);
		
		
		pestañas = new JTabbedPane();
		creacionBarra();

		pestañaReservaVuelo();
		
		pestañaBuscar();
		pestañaAgregarVuelo();
		pestañaEliminarVuelo();
		pestañaListaDeVuelos();
		pestañaBuscarVuelos();
		
	}
	
	
	/**
	 * Este método se encarga de crear la barra de menu que tiene  el sistema.
	 */
	
	private void creacionBarra(){
		
		
		miBarra = new JMenuBar();

		archivo = new JMenu("Archivo");
		salir = new JMenu("Salir");
		
		guardar = new JMenuItem("Guardar", new ImageIcon("iconos/guardar1.png"));
		guardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		
		guardarTodo = new JMenuItem("Guardar todo", new ImageIcon("iconos/guardarTodoAzul.png"));
		guardarTodo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.ALT_MASK));
		
		exit = new JMenuItem("Salir", new ImageIcon("iconos/SignOut3.png"));
		exit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				
			System.exit(0);
			}
			
		});
		
		miBarra.add(archivo);
		miBarra.add(salir);
		
		archivo.add(guardar);
		archivo.add(guardarTodo);
		
		salir.add(exit);
		
		setJMenuBar(miBarra);
	}

	/**
	 * Este método tiene como propósito crear objetos de tipo JLabel, JComboBox, JRadioButton, JTextField 
	 * lo cual serán agregado a un objeto de tipo JPanel para una de las pestañas del sistema Agencia De Viajes.
	 * Los componente estan agregado con un Layout de tipo Box.
	 */
	
	private void pestañaAgregarVuelo(){

		
		panelAgregarVuelo = new JPanel();
		
		txtLineaArea = new JLabel("Linea Aerea: ");
		campoLineaAerea = new JTextField(20);
		
		Box caja1 = Box.createHorizontalBox();
		caja1.add(txtLineaArea);
		caja1.add(campoLineaAerea);
		panelAgregarVuelo.add(caja1);
		
		
		txtNumeroVuelo = new JLabel("Numero de vuelo");
		campoNumeroVuelo = new JTextField(20);
		
		Box caja2 = Box.createHorizontalBox();
		caja2.add(txtNumeroVuelo);
		caja2.add(campoNumeroVuelo);
		panelAgregarVuelo.add(caja2);
		
		
		txtOrigenVuelo = new JLabel("Origen de vuelo: ");
		campoOrigenVuelo = new JTextField(10);
		campoOrigenVuelo.setEditable(false);
		comboBoxOrigen = new JComboBox(paisesOrigen);
		
		Box caja3 = Box.createHorizontalBox();
		caja3.add(txtOrigenVuelo);
		caja3.add(campoOrigenVuelo);
		caja3.add(comboBoxOrigen);
		panelAgregarVuelo.add(caja3);
		
		
		JLabel txtTipoVuelo = new JLabel("Tipo de vuelo");
		rNacional = new JRadioButton("Nacional");
		rInternacional = new JRadioButton("Internacional");
		
		ButtonGroup migrupo1=new ButtonGroup();
		migrupo1.add(rNacional);
		migrupo1.add(rInternacional);
		
		
		Box caja4 = Box.createHorizontalBox();
		caja4.add(txtTipoVuelo);
		caja4.add(rNacional);
		caja4.add(rInternacional);
		
		panelAgregarVuelo.add(caja4);
		
		
		JLabel titulo = new JLabel("Rutas o paradas de este vuelo", JLabel.RIGHT);
		titulo.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel txRuta = new JLabel("Rutas Destino");
		campoRutaDestino = new JTextField(20);
		campoRutaDestino.setEditable(false);
		comboBoxDestino = new JComboBox(rutasDestino);
		
		Box caja5 = Box.createHorizontalBox();
		caja5.add(txRuta);
		caja5.add(campoRutaDestino);
		caja5.add(comboBoxDestino);
		panelAgregarVuelo.add(caja5);
		
		
		
		JLabel tarifa = new JLabel("Tarifa");
		campoTarifa = new JTextField(10);
		campoTarifa.setMaximumSize(campoTarifa.getPreferredSize());
		Box caja6 = Box.createHorizontalBox();
		caja6.add(tarifa);
		caja6.add(Box.createHorizontalStrut(10));
		caja6.add(campoTarifa);
		panelAgregarVuelo.add(caja6);
		
		
		JLabel txtFecha = new JLabel("Fecha");
		comboDias = new JComboBox(dias);
		comboMeses = new JComboBox(meses);
		comboAños = new JComboBox(años);
	
		campoFecha = new JTextField(10);
		campoFecha.setEditable(false);
		campoFecha.setMaximumSize(campoTarifa.getPreferredSize());
		
		Box caja7 = Box.createHorizontalBox();
		caja7.add(txtFecha);
		caja7.add(Box.createHorizontalStrut(10));
		caja7.add(comboDias);
		caja7.add(comboMeses);
		caja7.add(comboAños);
		caja7.add(campoFecha);
		panelAgregarVuelo.add(caja7);
		
		JLabel txtHora = new JLabel("Hora de Salida");
		comboHoras = new JComboBox(horas);	
		comboMinutos = new JComboBox(minutos);

		rAm = new JRadioButton("am");
		rPm = new JRadioButton("pm");
		
		
		migrupo2=new ButtonGroup();
		migrupo2.add(rAm);
		migrupo2.add(rPm);
		
		campoHoraSalida = new JTextField(7);
		campoHoraSalida.setEditable(false);
		campoHoraSalida.setMaximumSize(campoHoraSalida.getPreferredSize());
		
		Box caja8 = Box.createHorizontalBox();
		caja8.add(txtHora);
		caja8.add(Box.createHorizontalStrut(10));
		caja8.add(comboHoras);
		caja8.add(comboMinutos);
		caja8.add(rAm);
		caja8.add(rPm);
		caja8.add(campoHoraSalida);
		panelAgregarVuelo.add(caja8);
		
		
		btnAgregar = new JButton("Agregar Vuelo",  new ImageIcon("iconos/mas1.png"));
		//btnAgregarRuta = new JButton("Agregar ruta");
		btnLimpiar = new JButton("Borrar campos", new ImageIcon("iconos/clean.png"));
		
		Box caja9 = Box.createHorizontalBox();
		caja9.add(btnAgregar);
		//caja9.add(btnAgregarRuta);
		caja8.add(Box.createHorizontalStrut(10));
		caja9.add(btnLimpiar);
		panelAgregarVuelo.add(caja9);
		
		
		Box cajaVertical = Box.createVerticalBox();
		cajaVertical.add(Box.createVerticalStrut(20));
		cajaVertical.add(caja1);
		cajaVertical.add(caja2);
		cajaVertical.add(caja3);
		cajaVertical.add(caja4);
		cajaVertical.add(Box.createVerticalStrut(50));
		cajaVertical.add(titulo);
		cajaVertical.add(caja5);
		cajaVertical.add(caja6);
		cajaVertical.add(caja7);
		cajaVertical.add(caja8);
		cajaVertical.add(Box.createVerticalStrut(10));
		cajaVertical.add(caja9);
		panelAgregarVuelo.add(cajaVertical);
		//panelAgregarVuelo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(), "Hola"));
	
		
		pestañas.add("Agregar Vuelo / Ruta", panelAgregarVuelo);
		

	}
		
	/**
	 * Este método crea la pestaña "Elimar vuelo" del sistema, lo cual esta conformado por objeto de tipo
	 * JTextArea, JComboBox, JButton y JTextField.
	 */
	
	private void pestañaEliminarVuelo(){
		
		panelEliminaVuelo =new JPanel();
		
		comboVuelos = new JComboBox();
		
		comboRutas = new JComboBox();
		
		Box caja1 = Box.createHorizontalBox();
		caja1.add(comboVuelos);
		caja1.add(Box.createHorizontalStrut(10));
		caja1.add(comboRutas);
		panelEliminaVuelo.add(caja1);
		
		
		miAreaDetalleRutas = new JTextArea(10,15);
		miAreaDetalleRutas.setEditable(false);
		
		miAreaDetalleVuelo = new JTextArea(10,15);
		miAreaDetalleVuelo.setEditable(false);
		
		Box caja2 = Box.createHorizontalBox();
		caja2.add(new JScrollPane(miAreaDetalleVuelo));
		caja2.add(Box.createHorizontalStrut(10));
		caja2.add(new JScrollPane(miAreaDetalleRutas));
		panelEliminaVuelo.add(caja2);
		
		
		campoVuelo = new JTextField(10);
		campoVuelo.setEditable(false);
		campoRuta = new JTextField(10);
		campoRuta.setEditable(false);
		campoVuelo.setMaximumSize(campoVuelo.getPreferredSize());
		campoRuta.setMaximumSize(campoRuta.getPreferredSize());
		Box caja3 = Box.createHorizontalBox();
		caja3.add(campoVuelo);
		caja3.add(Box.createHorizontalStrut(10));
		caja3.add(campoRuta);
		panelEliminaVuelo.add(caja3);
		
		
		btnEliminarVuelo = new JButton("Eliminar Vuelo");
		btnEliminarRuta = new JButton("Eliminar Ruta");
		Box caja4 = Box.createHorizontalBox();
		caja4.add(btnEliminarVuelo);
		caja4.add(Box.createHorizontalStrut(10));
		caja4.add(btnEliminarRuta);
		panelEliminaVuelo.add(caja4);
		
		
		JLabel nuemroVuelo = new JLabel("Nº Vuelo");
		JLabel rutaV = new JLabel("Nueva Ruta");
		JLabel tarifa = new JLabel("Tarifa");
		
		campoAgregarRuta1 = new JTextField(10);
		campoAgregarRuta1.setEditable(false);
		campoAgregarRuta2 = new JTextField(10);
		campoAgregarRuta3 = new JTextField(10);
		Box caja5 = Box.createHorizontalBox();
		caja5.add(nuemroVuelo);
		caja5.add(campoAgregarRuta1);
		caja5.add(rutaV);
		caja5.add(campoAgregarRuta2);
		caja5.add(tarifa);
		caja5.add(campoAgregarRuta3);
		panelEliminaVuelo.add(caja5);
		
		btnAgregarRuta2 = new JButton("Agregar Ruta");
		Box caja6 = Box.createHorizontalBox();
		caja6.add(btnAgregarRuta2);
		panelEliminaVuelo.add(caja6);
		
		Box cajaVertical = Box.createVerticalBox();
		cajaVertical.add(caja1);
		cajaVertical.add(Box.createVerticalStrut(10));
		cajaVertical.add(caja2);
		cajaVertical.add(caja3);
		cajaVertical.add(caja4);
		cajaVertical.add(Box.createVerticalStrut(10));
		cajaVertical.add(caja5);
		cajaVertical.add(caja6);
		panelEliminaVuelo.add(cajaVertical);
		
		
		pestañas.add("Eliminar/ Agreagr Vuelo y/o Ruta", panelEliminaVuelo);
		
	}
	
	
	/**
	 * 
	 */
	
	private void pestañaReservaVuelo(){
		
		panelReserva = new JPanel();
		
		
		JLabel txtNombre = new JLabel("Nombre:");
		txtNombre.setFont(new Font("Arial", Font.BOLD, 12));
		campoNombre = new JTextField(20);
		
		Box caja1 = Box.createHorizontalBox();
		caja1.add(txtNombre);
		caja1.add(Box.createHorizontalStrut(10));
		caja1.add(campoNombre);
		panelReserva.add(caja1);
		
		JLabel txtApellido = new JLabel("Apellido:");
		txtApellido.setFont(new Font("Arial", Font.BOLD, 12));
		campoApellido = new JTextField(20);
		
		Box caja2 = Box.createHorizontalBox();
		caja2.add(txtApellido);
		caja2.add(Box.createHorizontalStrut(10));
		caja2.add(campoApellido);
		panelReserva.add(caja2);
		
		JLabel txtPasaporte = new JLabel("Pasaporte:");
		txtPasaporte.setFont(new Font("Arial", Font.BOLD, 12));
		campoPasaporte = new JTextField(20);
		

		Box caja3 = Box.createHorizontalBox();
		caja3.add(txtPasaporte);
		caja3.add(Box.createHorizontalStrut(10));
		caja3.add(campoPasaporte);
		panelReserva.add(caja3);
		

		JLabel txtSeleccionarV = new JLabel("Seleccionar vuelo:");
		txtSeleccionarV.setFont(new Font("Arial", Font.BOLD, 12));
		comboVueloR = new JComboBox();
	
		
		campoVueloR = new JTextField(5);
		campoVueloR.setEditable(false);
		Box caja4 = Box.createHorizontalBox();
		caja4.add(txtSeleccionarV);
		caja4.add(Box.createHorizontalStrut(10));
		caja4.add(comboVueloR);
		caja4.add(campoVueloR);
		panelReserva.add(caja4);
		
		
		JLabel txtSeleccionarRuta = new JLabel("Seleccionar ruta");
		txtSeleccionarRuta.setFont(new Font("Arial", Font.BOLD, 12));
		comboRutasR = new JComboBox();
		comboRutasR.addItem("Rutas");
		
		campoRutaR = new JTextField(5);
		campoRutaR.setEditable(false);
		Box caja5 = Box.createHorizontalBox();
		caja5.add(txtSeleccionarRuta);
		caja5.add(Box.createHorizontalStrut(10));
		caja5.add(comboRutasR);
		caja5.add(campoRutaR);
		panelReserva.add(caja5);
		
		
		JLabel txtAsiento = new JLabel("Asiento");
		txtAsiento.setFont(new Font("Arial", Font.BOLD, 12));
		
		comboAsientosR = new JComboBox(clases);

		campoAsiento = new JTextField(8);
		campoAsiento.setEditable(false);
		btnReservarVuelo = new JButton("Reservar Vuelo");
		
		Box caja6 = Box.createHorizontalBox();
		caja6.add(txtAsiento);
		caja6.add(Box.createHorizontalStrut(10));
		caja6.add(comboAsientosR);
		caja6.add(campoAsiento);
		caja6.add(btnReservarVuelo);
		panelReserva.add(caja6);
		
	
		Box cajaVertical = Box.createVerticalBox();
		cajaVertical.add(Box.createVerticalStrut(25));
		cajaVertical.add(caja1);
		cajaVertical.add(Box.createVerticalStrut(30));
		cajaVertical.add(caja2);
		cajaVertical.add(Box.createVerticalStrut(30));
		cajaVertical.add(caja3);
		cajaVertical.add(Box.createVerticalStrut(30));
		cajaVertical.add(caja4);
		cajaVertical.add(Box.createVerticalStrut(30));
		cajaVertical.add(caja5);
		cajaVertical.add(Box.createVerticalStrut(30));
		cajaVertical.add(caja6);
		panelReserva.add(cajaVertical);
		
	
		pestañas.add("Reservar vuelo", panelReserva);

		
		add(pestañas);
	}
	
	/**
	 * 
	 */
	
	private void pestañaBuscar(){
		
		panelBuscar = new JPanel();
		panelBuscar.setLayout(new BorderLayout());
		
		JPanel superior = new JPanel();
		JPanel inferior = new JPanel();
		inferior.setLayout(new BorderLayout());
		JPanel superiorDe = new JPanel();

		
		JLabel nombre = new JLabel("Nombre: ");
		campoEditNombre = new JTextField(20);
		campoEditNombre.setEditable(false);
		
		JLabel apellido = new JLabel("Apellido: ");
		campoEditApellido = new JTextField(20);
		campoEditApellido.setEditable(false);
		
		JLabel asiento = new JLabel("Asiento");
		campoEditClase = new JTextField(20);
		campoEditClase.setEditable(false);
		
		JLabel labelvuelo = new JLabel("Vuelo: ");
		campoEditNVuelo = new JTextField(20);
		campoEditNVuelo.setEditable(false);
		

		JLabel txtPasaporte = new JLabel("Nº Pasaporte:");
		txtPasaporte.setFont(new Font("Arial", Font.BOLD, 12));
		campoEditPasaporte = new JTextField(20);
		campoEditPasaporte.setEditable(false);
		
		Box caja1 = Box.createHorizontalBox();
		caja1.add(nombre);
		caja1.add(campoEditNombre);
		
		
		Box caja2 = Box.createHorizontalBox();
		caja2.add(apellido);
		caja2.add(campoEditApellido);
	
		Box caja3 = Box.createHorizontalBox();
		caja3.add(txtPasaporte);
		caja3.add(campoEditPasaporte);
	
		
		Box caja4 = Box.createHorizontalBox();
		caja4.add(asiento);
		caja4.add(campoEditClase);
	
		Box caja5 = Box.createHorizontalBox();
		caja5.add(labelvuelo);
		caja5.add(campoEditNVuelo);
	
		
		tablaCliente = new JTable(datosFila,nombreColumnas);
		tablaCliente.setPreferredScrollableViewportSize(new Dimension(400, 150));
		JScrollPane barra = new JScrollPane(tablaCliente);
		inferior.add(barra);
	
		
		JLabel txtBuscar = new JLabel("Buscar: ");
		campoDeBusquedaCliente = new JTextField(20);
		btnBusquedaCliente = new JButton("Buscar Cliente", new ImageIcon("iconos/buscarUsuario1.png"));
		
		btnOK = new JButton("OK", new ImageIcon("iconos/ok5.png"));
		btnOK.setEnabled(false);
		btnEditar = new JButton("Editar Cliente", new ImageIcon("iconos/e1.png"));
		btnEditar.setEnabled(false);
		

		btnEliminarCliente = new JButton("Eliminar Cliente", new ImageIcon("iconos/removeClient2.png"));
		btnEliminarCliente.setEnabled(false);
		
		
		Box caja8Derecha = Box.createVerticalBox();
		caja8Derecha.add(txtBuscar);
		caja8Derecha.add(campoDeBusquedaCliente);
		caja8Derecha.add(btnBusquedaCliente);
		caja8Derecha.add(Box.createVerticalStrut(25));
		caja8Derecha.add(btnEditar);
		caja8Derecha.add(btnOK);
		caja8Derecha.add(Box.createVerticalStrut(13));
		caja8Derecha.add(btnEliminarCliente);
		superiorDe.add(caja8Derecha);
	
		Box cajaVerticalDe = Box.createVerticalBox();
		cajaVerticalDe.add(Box.createVerticalStrut(25));
		superiorDe.add(cajaVerticalDe);
		

		Box cajaVertical = Box.createVerticalBox();
		cajaVertical.add(Box.createVerticalStrut(25));
		cajaVertical.add(caja1);
		cajaVertical.add(caja2);
		cajaVertical.add(caja3);
		cajaVertical.add(caja4);
		cajaVertical.add(caja5);
		superior.add(cajaVertical);
		

		panelBuscar.add(superior, BorderLayout.WEST);
		panelBuscar.add(superiorDe, BorderLayout.EAST);
		panelBuscar.add(inferior, BorderLayout.SOUTH);

		
		pestañas.add("Buscar y Editar Reservaciones", panelBuscar);
	
		
	}

	/**
	 * 
	 */
	private void pestañaListaDeVuelos(){
		
		panelListasVuelos = new JPanel();
		//panelListasVuelos.setLayout(new GridLayout(2,3));
		panelListasVuelos.setLayout(new BorderLayout());
		
		JLabel txtVuelos = new JLabel("Vuelos");
		txtVuelos.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel txtRutas = new JLabel("Rutas");
		txtRutas.setFont(new Font("Arial", Font.BOLD, 14));
		JLabel txtReservacion = new JLabel("Reservaciones");
		txtReservacion.setFont(new Font("Arial", Font.BOLD, 14));
		
		JLabel txtDetallesVuelo = new JLabel("Detalles del Vuelo");
		txtDetallesVuelo.setFont(new Font("Arial", Font.BOLD, 13));
		JLabel txtDetallesRuta = new JLabel("Detalles de la Ruta");
		txtDetallesRuta.setFont(new Font("Arial", Font.BOLD, 13));
		JLabel txxDetallesReservacion = new JLabel("Detalle de la Reservacion");
		txxDetallesReservacion.setFont(new Font("Arial", Font.BOLD, 13));
		
		listVuelos = new JList();
		listVuelos.setFixedCellWidth(10);
		listRutas= new JList();
		listRutas.setFixedCellWidth(10);
		listReservaciones = new JList();
		listReservaciones.setFixedCellWidth(10);
		
		
		areaDetalleVuelos = new JTextArea(10,10);
		areaDetalleVuelos.setEditable(false);
		areaDetalleRuta = new JTextArea(10,10);
		areaDetalleRuta.setEditable(false);
		areaDetalleReser= new JTextArea(10,10);
		areaDetalleReser.setEditable(false);
	
//		panelListasVuelos.add(areaDetalleVuelos);
//		panelListasVuelos.add(areaDetalleRuta);
//		panelListasVuelos.add(areaDetalleReser);
//		
//		
		Box caja1 = Box.createVerticalBox();
		caja1.add(txtVuelos);
		caja1.add(new JScrollPane(listVuelos));
		
		Box caja2 = Box.createVerticalBox();
		caja2.add(txtRutas);
		caja2.add(new JScrollPane(listRutas));
		
		Box caja3 = Box.createVerticalBox();
		caja3.add(txtReservacion);
		caja3.add(new JScrollPane(listReservaciones));
		
		Box cajaHorizontal1 = Box.createHorizontalBox();
		cajaHorizontal1.add(caja1);
		cajaHorizontal1.add(caja2);
		cajaHorizontal1.add(caja3);
		
		Box caja4 = Box.createVerticalBox();
		caja4.add(txtDetallesVuelo);
		caja4.add(areaDetalleVuelos);
		
		Box caja5 = Box.createVerticalBox();
		caja5.add(txtDetallesRuta);
		caja5.add(areaDetalleRuta);
		
		Box caja6 = Box.createVerticalBox();
		caja6.add(txxDetallesReservacion);
		caja6.add(areaDetalleReser);
		
		
		Box cajaHorizontal2 = Box.createHorizontalBox();
		cajaHorizontal2.add(caja4);
		cajaHorizontal2.add(caja5);
		cajaHorizontal2.add(caja6);
		
		Box caja = Box.createVerticalBox();
		caja.add(cajaHorizontal1);
		caja.add(cajaHorizontal2);
		
		panelListasVuelos.add(caja);
		
		pestañas.add("Lista Vuelos", panelListasVuelos);
		
	}
		
	/**
	 * 
	 */
	private void pestañaBuscarVuelos(){
		
		panelBuscarVuelos= new JPanel();
		panelBuscarVuelos.setLayout(new BorderLayout());
		
		JPanel superior = new JPanel();
		JPanel inferior = new JPanel();
		inferior.setLayout(new BorderLayout());
		JPanel superiorDe = new JPanel();
		
		
		JLabel txt_aeroLinea = new JLabel("Aerolinea: ");
		cmBusquedaLinea = new JTextField(20);
		cmBusquedaLinea.setEditable(false);
		
		JLabel txt_numero_ = new JLabel("Nº de Vuelo: ");
		cmBusquedaNumero = new JTextField(20);
		cmBusquedaNumero.setEditable(false);
		
		JLabel txt_origen_ = new JLabel("Origen del Vuelo: ");
		cmBusquedaOrigen = new JTextField(20);
		cmBusquedaOrigen.setEditable(false);
		
		JLabel txt_tipo = new JLabel("Tipo de vuelo: ");
		cmBusquedaTipo = new JTextField(20);
		cmBusquedaTipo.setEditable(false);
		
		JLabel txt_hora = new JLabel("Hora de Salida: ");
		cmBusquedaHora = new JTextField(20);
		cmBusquedaHora.setEditable(false);
		
		JLabel txt_fecha = new JLabel("Fecha: ");
		cmBusquedaFecha = new JTextField(20);
		cmBusquedaFecha.setEditable(false);
		
		
		Box caja1 = Box.createHorizontalBox();
		caja1.add(txt_aeroLinea);
		caja1.add(cmBusquedaLinea);
		
		Box caja2 = Box.createHorizontalBox();
		caja2.add(txt_numero_);
		caja2.add(cmBusquedaNumero);
		
		Box caja3 = Box.createHorizontalBox();
		caja3.add(txt_tipo);
		caja3.add(cmBusquedaTipo);
		
		Box caja6 = Box.createHorizontalBox();
		caja6.add(txt_origen_);
		caja6.add(cmBusquedaOrigen);
		
		
		Box caja4 = Box.createHorizontalBox();
		caja4.add(txt_hora);
		caja4.add(cmBusquedaHora);
		
		Box caja5 = Box.createHorizontalBox();
		caja5.add(txt_fecha);
		caja5.add(cmBusquedaFecha);
		
		
		
		JLabel txtBuscar = new JLabel("Buscar por Nº de vuelo: ");
		campoBusquedaVuelo = new JTextField();
		btnBusquedaVuelo = new JButton("Buscar", new ImageIcon("iconos/avionViva.png"));
		
		
		JLabel txtOpciones = new JLabel("Mas opciones de busqueda");
		
		
		comboLineaAerea = new JComboBox(lienasAereas);
		
		comboOrigen = new JComboBox(paisesOrigen);
		
		comboTipo = new JComboBox();
		
		comboTipo.addItem("Internacional");
		comboTipo.addItem("Nacional");
		
		refrescar = new JButton("Restablecer Tabla");
		
		
		Box cajaCombo = Box.createHorizontalBox();
		cajaCombo.add(comboLineaAerea);
		cajaCombo.add(comboOrigen);
		cajaCombo.add(comboTipo);
		
		Box caja8Derecha = Box.createVerticalBox();
		caja8Derecha.add(txtBuscar);
		caja8Derecha.add(campoBusquedaVuelo);
		caja8Derecha.add(btnBusquedaVuelo);
		caja8Derecha.add(Box.createVerticalStrut(30));
		caja8Derecha.add(txtOpciones);
		caja8Derecha.add(cajaCombo);
		caja8Derecha.add(Box.createVerticalStrut(30));
		caja8Derecha.add(refrescar);
		superiorDe.add(caja8Derecha);
	
		

		Box cajaVertical = Box.createVerticalBox();
		cajaVertical.add(Box.createVerticalStrut(25));
		cajaVertical.add(caja1);
		cajaVertical.add(caja2);
		cajaVertical.add(caja6);
		cajaVertical.add(caja3);
		cajaVertical.add(caja4);
		cajaVertical.add(caja5);
		superior.add(cajaVertical);
	
		
		
		tablaVuelos = new JTable(datosVuelos,columnasVuelos);
		tablaVuelos.setPreferredScrollableViewportSize(new Dimension(400, 150));
		JScrollPane barra = new JScrollPane(tablaVuelos);
		inferior.add(barra);
		
		
		panelBuscarVuelos.add(superior, BorderLayout.WEST);
		panelBuscarVuelos.add(inferior, BorderLayout.SOUTH);
		panelBuscarVuelos.add(superiorDe, BorderLayout.EAST);
		
		pestañas.add("Buscar Vuelos",panelBuscarVuelos );
		
	}
	
	
	private Object[][] datosFila= {	
			{null, null	,null, null}
	};
	
	private Object[][] datosVuelos={
			{null,null,null,null,null,null}
	};
	
	private String[] lienasAereas={"Copa Airlines", "Iberia", "Fly Emirates", "Avianca"};
	
	private String[] clases = {"Primera Clase", "Business", "Turistica"};
	
	public String [] nombreColumnas= {"Nombre","Apellido", "Pasaporte", "Vuelo", "Clase"};
	
	public String[] columnasVuelos={"Linea Aerea", "Nº Vuelo", "Origen de Vuelo","Tipo de Vuelo", "Fecha", "Hora de salida"};

	public String[] dias= {"01","02","03","04","05","06","07","08", "09", "10", "11", "12", 
			"13", "14", "15", "16", "17", "18", "19", "20", "21",
			"22", "23", "24", "25", "26","27","28", "29", "30", "31"};
	
	public String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};

	public String[] años ={"2018", "2019","2020","2021"};
	
	public String[] horas = {"1", "3", "4", "6", "9", "10", "11"};
	public String[] minutos = {"00", "15", "30", "45"};
	
	private String[] paisesOrigen = {"Panamá", "Colombia", "Argentina", "USA", "México", "España", "Canada","Holanda","Italia","Brasil", "Portugal"};
	
	private String[] rutasDestino ={"USA", "Francia", "Italia", "México", "Portugal", "Rusia", "China","Canada", "España", "Italia", "Brasil","Sudafrica"};
}
