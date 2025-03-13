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

public class GUIPrintsNumbers2Pin extends JFrame implements Runnable 
{
	private boolean keepGoing;
	
	private JTextArea textArea;
	private JScrollPane scroll;
	public JButton go;
	public Button suspenderBoton = new Button("Suspender");
    public Button reanudarBoton = new Button("Reanudar");
    public Button stopBoton = new Button("Stop");
    
	public JTextField camp;
	//public JPanel down,center;
	public JPanel center=new JPanel (new BorderLayout());
	public JPanel down=new JPanel (new GridLayout(1,5));
	public JLabel warning;
	
    public GUIPrintsNumbers2Pin() 
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
    
    public void lanzador(){
		textArea.setEditable(false);
		textArea.setBackground(Color.WHITE);
		center.add(warning,BorderLayout.SOUTH);
	//	center.add(scrone,BorderLayout.CENTER);
		down.add(camp);
		down.add(go);
		down.add(suspenderBoton);
		down.add(reanudarBoton);
		down.add(stopBoton);
		
		this.add(center,BorderLayout.CENTER);
		this.add(down, BorderLayout.SOUTH);
		
	//	go.addActionListener(this);
	//	suspenderBoton.addActionListener(this);
		
		suspenderBoton.addActionListener(

                          new ActionListener() {

                          public void actionPerformed(ActionEvent e) {

                                    suspender();

                          }

                 });

                // add(suspenderBoton);

          reanudarBoton.addActionListener(

         new ActionListener() {

         public void actionPerformed(ActionEvent e) {

                                    reanudar();

                          }

                 });
	//	reanudarBoton.addActionListener(this);
	//	stopBoton.addActionListener(this);
		
		stopBoton.addActionListener(

                          new ActionListener() {

                          public void actionPerformed(ActionEvent e) {

                                    apagar();

                          }

                 });
		
		suspenderBoton.setEnabled(false);
		reanudarBoton.setEnabled(false);
		stopBoton.setEnabled(false);
		this.setTitle("Contador");
		this.setSize(400,400);
		this.setVisible(true);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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