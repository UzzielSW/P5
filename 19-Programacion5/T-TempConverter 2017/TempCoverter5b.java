/*
 *Autor: Prof. Alvaro Pino N.
 *Fecha: 1/06/2017
 *
 */


import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class TempCoverter5b extends JFrame 
{

	private  JLabel  jlCel, jlFar;
	
    private  JButton [] jb;
    private  JTextField [] jt;
    
	public  TempCoverter5b(String title)
	{
		super(title);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container contentPane = this.getContentPane();
		
			 
	
		
        
        jb = new JButton[4];
        
        jb[0] = new JButton("To Farenheit");
        jb[1] = new JButton("To Celsius");
        jb[2] = new JButton("Clear");
        jb[3] = new JButton("Exit");;
        
        jlCel= new JLabel("Celsius");
        jlFar= new JLabel("Farenheit");
          	    
	    jt = new JTextField[2];
	    
	    jt[0] = new JTextField(20);
	    jt[1] = new JTextField(20);
	    
	   //add the Jlabels and TextFields  to the frame
	   
		JPanel north = new JPanel();
		north.add(jlCel);
		north.add(jt[0]);
		north.add(jlFar);
        north.add(jt[1]);
        contentPane.add(north, BorderLayout.NORTH);
        
		//add the buttons to the frame
		JPanel south = new JPanel();
		south.add(jb[0]);
		south.add(jb[1]);
		south.add(jb[2]);
		south.add(jb[3]);
		
		contentPane.add(south, BorderLayout.SOUTH);
		
		//register the event listener
	//	ColorChanger changer = new ColorChanger(this);
TempCTF5Listener CTF5Listener = new TempCTF5Listener( this,jb,jt);
	
		jb[0].addActionListener(CTF5Listener);
		jb[1].addActionListener(CTF5Listener);
		jb[2].addActionListener(CTF5Listener);
		jb[3].addActionListener(CTF5Listener);
	}
	
	
	
	

	public static void main(String [] args)
	{
		JFrame frame = new TempCoverter5b("Celsius-Farenheit-Celsius"+
		                     "\nTempCTF5Listener( this,jb,jt)");
	//	frame.setSize(300,300);
	frame.pack();
	frame.setResizable(false);
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	frame.setLocation((d.width - frame.getSize().width) / 2, (d.height - frame.getSize().height)/2);
	frame.setVisible(true);
		
	}
	
	
}