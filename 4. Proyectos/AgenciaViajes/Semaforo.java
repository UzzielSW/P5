import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.ItemSelectable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Semaforo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Marco m= new Marco();
		m.setVisible(true);
		m.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class Marco extends JFrame implements ActionListener{
	
	JMenuItem rojo, amarillo, verde;
	
	JRadioButton rVerde,rAmarillo,rRojo;
	
	ButtonGroup grupo;

	Light semaforo;
	
	public Marco(){
		
		setTitle("Semaforo");
		setBounds(300, 300, 500, 200);
		setLocationRelativeTo(null);
		
		semaforo = new Light();
		
		add(semaforo, BorderLayout.NORTH);

		JMenuBar barra = new JMenuBar();
		
		JMenu colores= new JMenu("Colores");
		
		rojo = new JMenuItem("Rojo");
		rojo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.ALT_MASK));
		rojo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				semaforo.turnOnRed();
			}

		});
		
		amarillo = new JMenuItem("Amarillo");
		amarillo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.ALT_MASK));
		amarillo.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				semaforo.turnOnYellow();
			}
			
		});
		
		verde = new JMenuItem("Verde");
		verde.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.ALT_MASK));
		verde.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				semaforo.turnOnGreen();
			}
			
		});
		
		
		radioTodo = new JRadioButtonMenuItem("Todos");
		radioTodo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_DOWN_MASK));
		
		
		colores.add(rojo);
		colores.add(amarillo);
		colores.add(verde);
		
		barra.add(colores);
		setJMenuBar(barra);
		
		
		JPanel laminaInferior = new JPanel();
		
		rVerde = new JRadioButton("Verde");

		rRojo = new JRadioButton("Rojo");
		rAmarillo = new JRadioButton("Amarillo");
		
		
		grupo= new ButtonGroup();
		grupo.add(rVerde);
		grupo.add(rRojo);
		grupo.add(rAmarillo);
		grupo.add(radioTodo);
		
		
		rVerde.addActionListener(this);
		rRojo.addActionListener(this);
		rAmarillo.addActionListener(this);
		radioTodo.addActionListener(this);
		
		laminaInferior.add(rVerde);
		laminaInferior.add(rRojo);
		laminaInferior.add(rAmarillo);
		laminaInferior.add(radioTodo);
		add(laminaInferior, BorderLayout.SOUTH);
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == rVerde){
			semaforo.turnOnGreen();
		}
		if(e.getSource() == rRojo){
			semaforo.turnOnRed();
		}
		if(e.getSource() == rAmarillo){
			semaforo.turnOnYellow();
		}
		if(e.getSource() == radioTodo){
			semaforo.turnTodos();
		}
	}
	
	
	
	JRadioButtonMenuItem radioTodo;
}


class Light extends JPanel 
{
	private boolean red;
	private boolean yellow;  
	private boolean green;

	public Light() //constructor
	{
		
	
	}
	
	public void turnOnRed()
	{
		red = true;
 	yellow = false;
 	green = false;
 	repaint();
	}

	public void turnOnYellow()
	{
		red = false;
 	yellow = true;
 	green = false;
 	repaint();
 }

	public void turnOnGreen() 
	{
		red = false;
 	yellow = false;
 	green = true;
 	repaint();
	}
	
	public void turnTodos(){
		red = true;
	 	yellow = true;
	 	green = true;
	 	repaint();
	}
 
		public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (red) 
			{
			g.setColor(Color.red);
   			g.fillOval(10, 10, 20, 20);
   			g.setColor(Color.black);
   			g.drawOval(10, 35, 20, 20);
   			g.drawOval(10, 60, 20, 20);
		     g.drawRect(5, 5, 30, 80);
		     }
		     
		     else if (yellow) 
		     	{
		     	g.setColor(Color.yellow);
   				g.fillOval(10, 35, 20, 20);
   				g.setColor(Color.black);
   				g.drawRect(5, 5, 30, 80);
   				g.drawOval(10, 10, 20, 20);
   				g.drawOval(10, 60, 20, 20);
   			}
   			
 		else if (green) 
 			{
 				g.setColor(Color.green);
 				g.fillOval(10, 60, 20, 20);
   				g.setColor(Color.black);
   				g.drawRect(5, 5, 30, 80);
   				g.drawOval(10, 10, 20, 20);
   				g.drawOval(10, 35, 20, 20);
   			}
   			
   		else 
   			{
   				g.setColor(Color.black);
   				g.drawRect(5, 5, 30, 80);
   				g.drawOval(10, 10, 20, 20);
   				g.drawOval(10, 35, 20, 20);
   				g.drawOval(10, 60, 20, 20);
   			}
		
		if(green && yellow && red){
			
			g.setColor(Color.red);
   			g.fillOval(10, 10, 20, 20);
   			g.setColor(Color.black);
   			g.drawOval(10, 35, 20, 20);
   			g.drawOval(10, 60, 20, 20);
		     g.drawRect(5, 5, 30, 80);
		     
		     g.setColor(Color.yellow);
				g.fillOval(10, 35, 20, 20);
				g.setColor(Color.black);
				g.drawRect(5, 5, 30, 80);
				g.drawOval(10, 10, 20, 20);
				g.drawOval(10, 60, 20, 20);
				
				
				g.setColor(Color.green);
 				g.fillOval(10, 60, 20, 20);
   				g.setColor(Color.black);
   				g.drawRect(5, 5, 30, 80);
   				g.drawOval(10, 10, 20, 20);
   				g.drawOval(10, 35, 20, 20);
   			}
		     
			
		}
		

		public Dimension getPreferredSize() {
		return new Dimension(40, 90);
	}
}
 
 

