// Fig. 14.11: DemoAparienciaVisual.java
// Cambio de la apariencia visual.
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DemoAparienciaVisual extends JFrame {
   private final String cadenas[] = { "Metal", "Motif", "Windows" };
   private UIManager.LookAndFeelInfo apariencias[];
   private JRadioButton opcion[];
   private ButtonGroup grupo;
   private JButton boton;
   private JLabel etiqueta;
   private JComboBox cuadroCombinado;

   // configurar la GUI
   public DemoAparienciaVisual()
   {
      super( "Demo de apariencia visual" );

      Container contenedor = getContentPane();

      // establecer panel para región NORTH de esquema BorderLayout
      JPanel panelNorte = new JPanel();
      panelNorte.setLayout( new GridLayout( 3, 1, 0, 5 ) );

      // establecer etiqueta para panel NORTH
      etiqueta = new JLabel( "Ésta es la apariencia visual Metal seleccionada",
         SwingConstants.CENTER );
      panelNorte.add( etiqueta );

      // establecer botón para panel NORTH
      boton = new JButton( "JButton" );
      panelNorte.add( boton );

      // establecer cuadro combinado para panel NORTH
      cuadroCombinado = new JComboBox( cadenas );
      panelNorte.add( cuadroCombinado );
     
      // crear arreglo para botones de opción
      opcion = new JRadioButton[ cadenas.length ];

      // establecer panel para región SOUTH de esquema BorderLayout
      JPanel panelSur = new JPanel();
      panelSur.setLayout( new GridLayout( 1, opcion.length ) );

      // establecer botones de opción para panel SOUTH
      grupo = new ButtonGroup();
      ManejadorEventos manejador = new ManejadorEventos();

      for ( int cuenta = 0; cuenta < opcion.length; cuenta++ ) {
         opcion[ cuenta ] = new JRadioButton( cadenas[ cuenta ] );
         opcion[ cuenta ].addItemListener( manejador );
         grupo.add( opcion[ cuenta ] );
         panelSur.add( opcion[ cuenta ] );
      }

      // adjuntar paneles NORTH y SOUTH al panel de contenido
      contenedor.add( panelNorte, BorderLayout.NORTH );
      contenedor.add( panelSur, BorderLayout.SOUTH );

      // obtener información de la apariencia visual instalada
      apariencias = UIManager.getInstalledLookAndFeels();

      setSize( 300, 200 );
      setVisible( true );

      opcion[ 0 ].setSelected( true );

   } // fin del constructor de DemoAparienciaVisual

   // usar UIManager para cambiar la apariencia visual de la GUI
   private void cambiarLaAparienciaVisual( int valor )
   {
      // cambiar la apariencia visual
      try {
         UIManager.setLookAndFeel( apariencias[ valor ].getClassName() );
         SwingUtilities.updateComponentTreeUI( this );
      }

      // procesar problemas al cambiar la apariencia visual
      catch ( Exception excepcion ) {
         excepcion.printStackTrace();
      }
   }

   public static void main( String args[] )
   {
      DemoAparienciaVisual aplicacion = new DemoAparienciaVisual();
      aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

   // clase interna privada para manejar eventos de botones de opción
   private class ManejadorEventos implements ItemListener {

      // procesar selección de apariencia visual del usuario
      public void itemStateChanged( ItemEvent evento )
      {
         for ( int cuenta = 0; cuenta < opcion.length; cuenta++ )

            if ( opcion[ cuenta ].isSelected() ) {
               etiqueta.setText( "Ésta es la apariencia visual " +
                  cadenas[ cuenta ] + " seleccionada" );
               cuadroCombinado.setSelectedIndex( cuenta );
               cambiarLaAparienciaVisual( cuenta );
            }
      }

   } // fin de la clase interna privada ManejadorEventos

} // fin de la clase DemoAparienciaVisual



/**************************************************************************
 * (C) Copyright 1992-2003 by Deitel & Associates, Inc. and               *
 * Prentice Hall. All Rights Reserved.                                    *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
