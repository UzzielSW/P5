import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.awt.image.BufferedImage;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Restaurante extends JFrame {

  private JTextArea facturaTextArea;
  private double total;
  private JButton botonLimpiar; // Agregar una variable miembro para el botón de limpiar
  private Factura factura;
  final String HOST = "localhost";
  final int PUERTO = 9999;

  public Restaurante() {
    super("Sistema de Pedidos");

    factura = new Factura();

    facturaTextArea = new JTextArea(20, 40);
    facturaTextArea.setEditable(false);

    botonLimpiar = new JButton("Limpiar Pantalla"); // Inicializar el botón de limpiar
    botonLimpiar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        limpiarPantalla();
      }
    });

    JButton botonGenerarFactura = new JButton("Generar Factura");
    botonGenerarFactura.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        generarFactura();
      }
    });

    JPanel panelBotones = new JPanel();
    panelBotones.setLayout(new GridLayout(3, 4));
    panelBotones.add(botonLimpiar); // Agregar el botón de limpiar al panel de botones

    // Agregar comidas
    agregarComida("Pizza", 10.99, "pizza.jpg", panelBotones);
    agregarComida("Hamburguesa", 8.99, "hamburguesa.jpg", panelBotones);
    agregarComida("Ensalada", 5.99, "ensalada.jpg", panelBotones);

    // Agregar bebidas
    agregarBebida("Refresco", 1.99, "refresco.jpg", panelBotones);
    agregarBebida("Agua", 0.99, "agua.jpg", panelBotones);
    agregarBebida("Cerveza", 4.99, "cerveza.jpg", panelBotones);

    // Botón para generar factura
    panelBotones.add(botonGenerarFactura);

    // Diseño del Frame
    setLayout(new BorderLayout());
    add(new JScrollPane(facturaTextArea), BorderLayout.CENTER);
    add(panelBotones, BorderLayout.SOUTH);

    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setLocationRelativeTo(null);
    setVisible(true);
  }

  private void agregarComida(String nombre, double precio, String imagen, JPanel panel) {
    Plato plato = new Plato(nombre, imagen);
    JButton botonComida = new JButton(
        new ImageIcon(plato.getImagen().getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
    botonComida.setText(nombre + " - $" + precio); // Agregar nombre y precio como texto en el botón
    botonComida.setVerticalTextPosition(SwingConstants.BOTTOM); // Posicionar el texto abajo del ícono
    botonComida.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
    botonComida.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        agregarPedidoConCantidad(nombre, precio);
      }
    });

    panel.add(botonComida);
  }

  private void agregarBebida(String nombre, double precio, String imagen, JPanel panel) {
    Plato plato = new Plato(nombre, imagen);
    JButton botonBebida = new JButton(
        new ImageIcon(plato.getImagen().getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
    botonBebida.setText(nombre + " - $" + precio); // Agregar nombre y precio como texto en el botón
    botonBebida.setVerticalTextPosition(SwingConstants.BOTTOM); // Posicionar el texto abajo del ícono
    botonBebida.setHorizontalTextPosition(SwingConstants.CENTER); // Centrar el texto horizontalmente
    botonBebida.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        agregarPedidoConCantidad(nombre, precio);
      }
    });

    panel.add(botonBebida);
  }

  private void agregarPedidoConCantidad(String nombre, double precio) {
    String cantidadStr = JOptionPane.showInputDialog("Ingrese la cantidad de " + nombre + ":");
    try {
      int cantidad = Integer.parseInt(cantidadStr);
      agregarPedido(nombre, precio, cantidad);
    } catch (NumberFormatException ex) {
      JOptionPane.showMessageDialog(this, "Ingrese un número válido para la cantidad.", "Error",
          JOptionPane.ERROR_MESSAGE);
    }
  }

  private void agregarPedido(String nombre, double precio, int cantidad) {

    facturaTextArea
        .append(nombre + "\t$" + precio + "\tCantidad: " + cantidad + "\tTotal: $" + (precio * cantidad) + "\n");
    total += precio * cantidad;

    Pedido nuevoPedido = new Pedido(nombre, cantidad, precio * cantidad);
    factura.setPedidos(nuevoPedido);

    // Iniciar un hilo para simular la preparación del plato
    Plato plato = new Plato(nombre, "");
    Thread chefThread = new Thread(new Chef(plato, facturaTextArea));
    chefThread.start();
  }

  private void generarFactura() {
    try {
      Socket socket = new Socket(HOST, PUERTO);
      ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
      ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());

      toServer.writeObject(factura); // envio de factura

      factura = (Factura) fromServer.readObject();

      facturaTextArea.append(factura.mensaje);

      socket.close();
      toServer.close();
      fromServer.close();
    } catch (IOException ex) {
      facturaTextArea.append("error en el envio al servidor");
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(Restaurante.class.getName()).log(Level.SEVERE, null, ex);
    }

    // Desactivar botones después de generar la factura, excepto el botón de limpiar
    Component[] components = getContentPane().getComponents();
    for (Component component : components) {
      if (component instanceof JPanel) {
        Component[] buttons = ((JPanel) component).getComponents();
        for (Component button : buttons) {
          if (button instanceof JButton && button != botonLimpiar) {
            ((JButton) button).setEnabled(false);
          }
        }
      }
    }
  }

  private void limpiarPantalla() {
    facturaTextArea.setText(""); // Limpiar el contenido del JTextArea
    total = 0; // Reiniciar el total
    // Volver a activar los botones
    Component[] components = getContentPane().getComponents();
    for (Component component : components) {
      if (component instanceof JPanel) {
        Component[] buttons = ((JPanel) component).getComponents();
        for (Component button : buttons) {
          if (button instanceof JButton) {
            ((JButton) button).setEnabled(true);
          }
        }
      }
    }
  }

  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        new Restaurante();
      }
    });
  }
}

// Clase Plato
class Plato {

  private String nombre;
  private ImageIcon imagen;

  public Plato(String nombre, String imagePath) {
    this.nombre = nombre;
    try {
      System.out.println("Intentando cargar imagen desde: " + imagePath);
      BufferedImage img = ImageIO.read(new File(imagePath));

      if (img == null) {
        System.err.println("Error al cargar la imagen: " + imagePath);
        // Puedes proporcionar una imagen de respaldo aquí
        this.imagen = obtenerImagenDeRespaldo();
      } else {
        this.imagen = new ImageIcon(img.getScaledInstance(100, 100, Image.SCALE_SMOOTH));
      }
    } catch (IOException e) {
      e.printStackTrace();
      // Puedes proporcionar una imagen de respaldo aquí
      this.imagen = obtenerImagenDeRespaldo();
    }
  }

  private ImageIcon obtenerImagenDeRespaldo() {
    // Proporciona una imagen de respaldo o muestra un mensaje de error
    // en lugar de devolver null.
    return new ImageIcon("C:\\Users\\bryan\\Escritorio\\Bryan03\\Restaurante\\refresco.jpg");
  }

  public ImageIcon getImagen() {
    return imagen;
  }

  public String getNombre() {
    return nombre;
  }

  public void preparar(JTextArea outputArea) {
    outputArea.append("Preparando " + nombre + "\n");
    try {
      Thread.sleep(3000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    outputArea.append(nombre + " listo!\n");
  }
}

// Clase Chef
class Chef implements Runnable {

  private Plato plato;
  private JTextArea outputArea;

  public Chef(Plato plato, JTextArea outputArea) {
    this.plato = plato;
    this.outputArea = outputArea;
  }

  @Override
  public void run() {
    plato.preparar(outputArea);
  }
}
