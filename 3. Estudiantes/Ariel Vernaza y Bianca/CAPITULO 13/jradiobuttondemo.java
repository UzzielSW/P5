import javax.swing.*;
import java.awt.*;
/*los radio button en swing se crean utilizanfo la clase JRadioButton, javax.swing.JRadionButton, y javax.swing.ButtonGroup
 * los parametros de su constructor son tres, un label que tiene la cadena que aperece con el nombre, un icon con el icono 
 * asociado,y un boleano que dice si esta seleccionado o no. 
 * La clase ButtonGroup solo tiene un constructor, y crea un solo objeto buttonGroup*/

/*
 * Instancie un objeto BUttonGroup, instancie un objeto radioButton, pasAR CADA RADIO BTTON AL METODO PUBLIC VOID ADD(aBSTRACTbUTTON bUTTON)
 * AbstractButton es el padre comun de JCheckButton,JRadioButton,JButton
 * */
public class JRadioButtonDemo extends JFrame
{ 
	private JRadioButton small, medium, large;
	private JButton button;

	public JRadioButtonDemo(String title)
	{
		super(title);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		Container contentPane = this.getContentPane();

		ButtonGroup group = new ButtonGroup();

		small = new JRadioButton("small");
		medium = new JRadioButton("medium");
		large = new JRadioButton("large");

		//add the radio buttons to the same group
		group.add(small);
		group.add(medium);
		group.add(large);

		button = new JButton("Click here");
		button.setBounds(50,50,100, 50);
		JPanel center = new JPanel();
		center.setLayout(null);
		center.add(button);
		contentPane.add(center, BorderLayout.CENTER);

		//add the radio buttons to the frame
		JPanel north = new JPanel();
		north.add(small);
		north.add(medium);
		north.add(large);

		contentPane.add(north, BorderLayout.NORTH);

		//register the event listener
		SwingChangeSize listener = new SwingChangeSize(button);
		small.addItemListener(listener);
		medium.addItemListener(listener);
		large.addItemListener(listener);
	}

	public static void main(String [] args)
	{
		JFrame f = new JRadioButtonDemo("JRadioButtonDemo");
		f.setSize(300,200);
		f.setVisible(true);
	}
}