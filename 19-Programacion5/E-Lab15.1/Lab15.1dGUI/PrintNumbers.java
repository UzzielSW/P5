import javax.swing.*;
import java.awt.*;


public class PrintNumbers  implements Runnable
{
	public boolean keepGoing;

	public JTextArea resultado;
	public String output="";
 


	
  	public PrintNumbers(JTextArea texto)
	{
        resultado=texto;
		System.out.println("entro al PrintNumbers");
		keepGoing = true;
	
		

	}

	public void stopPrinting()
	{
		keepGoing = false;
	}

	public void run()
	{

		int counter = 1;
		while(keepGoing)
		{
			System.out.println(counter);
			resultado.setText(resultado.getText()+"\n"+counter);
			// Calcula y despliega El numero de Fibonacci
       /* JOptionPane.showMessageDialog(null,counter++,
                                     "Ejemplo de Output PrintNumber",JOptionPane.INFORMATION_MESSAGE );
        */
            output +=  counter++ +"\n";





			try
			{
				Thread.sleep(1000);
			}catch(InterruptedException e)
			{}
		}
		//JOptionPane.showMessageDialog(null, new JScrollPane(new JTextArea(output)),"PrintNumbers Demo",JOptionPane.INFORMATION_MESSAGE,null);
	}
}