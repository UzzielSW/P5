/**
 *Programa del semaforo
 *Creado por :
 *Manuel Tejada
 *8-818-1801
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonDemo extends JFrame implements ItemListener{
	
	private JRadioButton jrb_Red;
	private JRadioButton jrb_Yellow;
	private JRadioButton jrb_Green;
	private ButtonGroup  jbg_Grupo;
	private Light light;
	private JPanel jp_Sur,jp_Norte; 
	public RadioButtonDemo()
	{
		super("Semaforo");
		jrb_Red  	= new JRadioButton("Red    ",false);
 		jrb_Yellow 	= new JRadioButton("Yellow ",false);
		jrb_Green  	= new JRadioButton("Green  ",true);
	    jbg_Grupo 	= new ButtonGroup ();
	    light       = new Light();
	    jp_Sur		= new JPanel(new FlowLayout());
	    jp_Norte	= new JPanel(null);
	    
	}
	
	public void pintame(){
	
		
		jbg_Grupo.add(jrb_Red);
		jbg_Grupo.add(jrb_Yellow);
		jbg_Grupo.add(jrb_Green);
		
		jp_Sur.add(jrb_Red);
		jp_Sur.add(jrb_Yellow);
		jp_Sur.add(jrb_Green);
		
		jrb_Green.addItemListener(this);
		jrb_Red.addItemListener(this);
		jrb_Yellow.addItemListener(this);
		
		add(jp_Sur,BorderLayout.SOUTH);	
		
		light.setBounds(85,0,100,100);
		jp_Norte.add(light);
		add(jp_Norte,BorderLayout.CENTER);
				
		setSize(220,160);
	}
	
	
	public void itemStateChanged(ItemEvent e){

		if(e.getSource().equals(jrb_Red)){
		
			light.turnOnRed();
				}
		else if(e.getSource().equals(jrb_Yellow)){
		
			light.turnOnYellow();
			}
			else if(e.getSource().equals(jrb_Green)){
		
			light.turnOnGreen();
			}
	}
	
}