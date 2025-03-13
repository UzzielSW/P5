// Fig. 14.1: DemoAreaTexto.java
// Cómo copiar texto seleccionado de un área de texto a otra. 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DemoAreaTexto extends JFrame {
   private JTextArea areaTexto1, areaTexto2;
   private JButton botonCopiar;

   // configurar GUI
   public DemoAreaTexto() 
   {
      super( "Demostración de JTextArea" );

      Box cuadro = Box.createHorizontalBox();

      String cadena = "Ésta es una cadena de\ndemostración para\n" + 
         "ilustrar cómo copiar texto\nde un área de texto a \n" +
         "otra, utilizando un\nevento externo\n";

      // establecer areaTexto1
      areaTexto1 = new JTextArea( cadena, 10, 15 );
      cuadro.add( new JScrollPane( areaTexto1 ) );

      // establecer botonCopiar
      botonCopiar = new JButton( "Copiar >>>" );
      cuadro.add( botonCopiar );
      botonCopiar.addActionListener(

         new ActionListener() {  // clase interna anónima 

            // establecer en areaTexto2 el texto seleccionado de areaTexto1
            public void actionPerformed( ActionEvent evento )
            {
               areaTexto2.setText( areaTexto1.getSelectedText() );
            }

         } // fin de la clase interna anónima
 
      ); // fin de la llamada a addActionListener

      // establecer areaTexto2
      areaTexto2 = new JTextArea( 10, 15 );
      areaTexto2.setEditable( false );
      cuadro.add( new JScrollPane( areaTexto2 ) );

      // agregar cuadro al panel de contenido
      Container contenedor = getContentPane();
      contenedor.add( cuadro );   // colocar en in BorderLayout.CENTER

      setSize( 425, 200 );
      setVisible( true );

   } // fin del constructor de DemoAreaTexto

   public static void main( String args[] )
   {
      DemoAreaTexto aplicacion = new DemoAreaTexto();
      aplicacion.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
   }

} // fin de la clase DemoAreaTexto

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
