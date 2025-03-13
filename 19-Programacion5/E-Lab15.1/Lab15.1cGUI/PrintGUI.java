/*
 * Modificado por Prof. Alvaro Pino N.
 * y Ariel Vernaza
 * Date: 23/09/2010
 * Date: 24/09/2010
 */

import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PrintGUI extends JFrame //implements ActionListener

{
        public JFrame ventana;
		public JTextArea texto;
		public JButton inicio;;
	//	ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		public JPanel  nuevo;
        private JScrollPane scroll;
        public Container contenedor;
        
	public PrintGUI()
	{

		ventana= new JFrame("Print Number by DSA");
		 texto= new JTextArea("");
		 scroll = new JScrollPane(texto);
    	scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    	scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        contenedor = getContentPane();
    	contenedor.add(scroll, BorderLayout.CENTER);
		inicio = new JButton("Inicio");
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		nuevo= new JPanel();
		ventana.getContentPane().add(nuevo);
		nuevo.setLayout(new BorderLayout());
		nuevo.add(texto,BorderLayout.CENTER);
		ventana.add(inicio,BorderLayout.SOUTH);

	//	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	  //  ventana.setLocation((d.width - ventana.getSize().width) / 2, (d.height - ventana.getSize().height)/2);
		ventana.setSize(400,400);
        //ventana.pack();

		ventana.setVisible(true);
	}
	public static void main(String [] args)
	{
		int time= 0;

         PrintGUI p = new PrintGUI();

		String	text;
		int resp=0;
		do
        {
        PrintNumbers	printNumbers;

		 printNumbers = new PrintNumbers(p.texto);


	        p.texto.setText("");

       try{

		   text = (String) JOptionPane.showInputDialog(p.ventana,"Ingrese un numero entero positivo en milisegundos: ",
                     "Laboratorio 15.1GUI",JOptionPane.QUESTION_MESSAGE );

                 //sale si se escoje cancelar o cerrar

       if(text == null ) System.exit(0);

		   time = Integer.parseInt(text);

           p.valida( time);

	//	int time = Integer.parseInt(args[0]);




		Thread t1 = new Thread(printNumbers);
		t1.start();

		try
		{
			Thread.sleep(time);
		}catch(InterruptedException m) 	{}

		printNumbers.stopPrinting();

     // Display  a message dialog box




          }catch(NumberFormatException e)
		       {
		       	JOptionPane.showMessageDialog(p.ventana,"Su Entrada es incorrecta !","Ejemplo de Output ERROR",
                                   JOptionPane.ERROR_MESSAGE);

			   // return;
		       }
	      catch(GUIMenorQueCeroException e){
	      	/*JOptionPane.showMessageDialog(null,"Ingrese Numeros positivos en milisegundos!",
                        	"Ejemplo de Output ERROR ",JOptionPane.ERROR_MESSAGE ); */
	      	}
      resp= JOptionPane.showConfirmDialog(p.ventana,
      "Desea Continuar: confirme?",
      "YES_NO_OPTION", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

	}while (resp == 0);

	System.out.println("main() is ending");
    p.ventana.setVisible(false);
    System.exit(0);
	}

public void valida( int i ) throws GUIMenorQueCeroException
	 {
	 	if (  i < 0 )
	 	  throw new GUIMenorQueCeroException(i,ventana);

	 }


}



class GUIMenorQueCeroException extends Exception
{
  private int i;
  private JFrame ventana;

  GUIMenorQueCeroException( int i, JFrame ventana)
   {
	this.i = i;
	this.ventana = ventana;
	JOptionPane.showMessageDialog(ventana,"Ingrese Numeros positivos en milisegundos!",
	"Ejemplo de Output ERROR ",JOptionPane.ERROR_MESSAGE );
   }
}


