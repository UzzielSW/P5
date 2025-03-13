import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadioButtonDemo extends JFrame implements ItemListener 
{
	private JRadioButton jrbred;
	private JRadioButton jrbyellow;
	private JRadioButton jrbgreen;
	private ButtonGroup btg;
	private JPanel jpanelButton,jpanelSemaforo;
	private Light Semaforo;

	
	public RadioButtonDemo()
	{
		jrbred=new JRadioButton("Red");
		jrbyellow=new JRadioButton("Yellow");
		jrbgreen=new JRadioButton("Green");
		btg=new ButtonGroup();
		jpanelButton=new JPanel();
		jpanelSemaforo=new JPanel();
		Semaforo=new Light();
		


	
	
	
	jpanelButton.add(jrbred);
	jpanelButton.add(jrbyellow);
	jpanelButton.add(jrbgreen);
	jpanelSemaforo.add(Semaforo);
	
	btg.add(jrbred);
	btg.add(jrbyellow);
	btg.add(jrbgreen);
	
	jrbred.addItemListener(this);
	jrbyellow.addItemListener(this);
	jrbgreen.addItemListener(this);
	
	
	this.add(jpanelButton,BorderLayout.SOUTH);
	this.add(jpanelSemaforo,BorderLayout.CENTER);

	}
	public static void main(String[] args)
	{
		RadioButtonDemo nombre=new RadioButtonDemo();
		nombre.pack();
		nombre.setVisible(true);
		
	}
	
	public void itemStateChanged(ItemEvent e)
	{
		if(e.getSource().equals(jrbgreen))
		{
			Semaforo.turnOnGreen();
		}
		else if(e.getSource().equals(jrbred))
		{
			Semaforo.turOnRed();
		}
		else if(e.getSource().equals(jrbyellow))
		{
			Semaforo.turOnYellow();
		}
	}
}

