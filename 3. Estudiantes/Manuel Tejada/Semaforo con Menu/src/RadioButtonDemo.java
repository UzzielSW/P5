/**
 *Programa del semaforo con menu
 *Creado por :
 *Manuel Tejada
 *8-818-1801
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RadioButtonDemo extends JFrame implements ItemListener,ActionListener{
	
	private JRadioButton jrb_Red;
	private JRadioButton jrb_Yellow;
	private JRadioButton jrb_Green;
	private ButtonGroup  jbg_Grupo;
	private Light light;
	private JPanel jp_Sur,jp_Norte; 
	private JMenuItem jmi_Red,jmi_Yellow,jmi_Green,jmi_Exit;
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
	
	creaMenu();
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
				
		setSize(220,180);
	}
	
	
	public void creaMenu(){
		JMenuBar jmb_barra =new JMenuBar();
		setJMenuBar(jmb_barra);
		
		JMenu jm_Semaforo=new JMenu("Semaforo");
		jm_Semaforo.setMnemonic('S');
		
		jmb_barra.add(jm_Semaforo);
		
		JMenu jm_Exit=new JMenu("Exit");
		jm_Exit.setMnemonic('E');
		
		jmb_barra.add(jm_Exit);
		
		jm_Semaforo.add(jmi_Red =new JMenuItem("Turn Red",'R'));
		jm_Semaforo.add(jmi_Yellow =new JMenuItem("Turn Yellow",'Y'));
		jm_Semaforo.add(jmi_Green =new JMenuItem("Turn Green",'G'));
		
		jm_Exit.add(jmi_Exit=new JMenuItem("Close",'C'));
		
		jmi_Red.setAccelerator(
      KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
		jmi_Yellow.setAccelerator(
      KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		jmi_Green.setAccelerator(
      KeyStroke.getKeyStroke(KeyEvent.VK_G, ActionEvent.CTRL_MASK));
      
      jmi_Red.addActionListener(this);
      jmi_Yellow.addActionListener(this);
      jmi_Green.addActionListener(this);
      
      jmi_Exit.addActionListener(this);
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
	
	public void actionPerformed(ActionEvent e){
	
	if(e.getSource().equals(jmi_Exit)){
		System.exit(0);
	}
		else if(e.getSource().equals(jmi_Red)){
			light.turnOnRed();
		}
			else if(e.getSource().equals(jmi_Yellow)){
		light.turnOnYellow();
		}
			else if(e.getSource().equals(jmi_Green)){
		light.turnOnGreen();
		}	
		
		
	}
	
}