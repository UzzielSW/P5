/**
 * @(#)GUIPrintsNumbers.java
 *
 *
 * @author Herminio Vargas
 * @version 1.00 2010/9/22
 * @version 2.00 2010/9/24
 */
import javax.swing.*;
import java.awt.*;

public class GUIPrintsNumbers extends JFrame implements Runnable 
{
	private boolean keepGoing;
	private JTextArea textArea;
	private JScrollPane scroll;
	
    public GUIPrintsNumbers() 
    {
    	super("Print Numbers");
    	keepGoing = true;
    	textArea = new JTextArea(20, 20);
    	textArea.setEditable(false);
    	scroll = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	//scroll.add(textArea);
    	getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER));
    	getContentPane().add(scroll);
    	pack();
    	setVisible(true);
    }
    public void stopPrinting()
    {
    	keepGoing = false;
    }
    public void run()
    {
    	int i = 0;
    	while(keepGoing)
    	{
    		try
    		{
    			i = i+1;
    	textArea.setText(textArea.getText()+"\n"+i);
    			Thread.sleep(1000);
    		} catch(InterruptedException ie){}
    		
    	}
    }
    
    
}