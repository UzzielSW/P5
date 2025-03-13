import java.io.*;
import java.awt.GridLayout;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class cursos extends JFrame implements ActionListener{
              JButton b1 =new JButton("Crear Curso");
	          JButton b2 =new JButton("Cancelar");
	          JLabel l1= new JLabel("Nombre del Curso");
	          JTextField nombre_curso = new JTextField(20);
	          JLabel l2= new JLabel("Codigo de Asignatura");
	          JTextField asginatura_codigo = new JTextField(20);
	          JLabel l3= new JLabel("Codigo de Horario");
	          JTextField horario_codigo = new JTextField(20);
	          JLabel l4= new JLabel("Abreviatura del Curso");
	          JTextField abreviatura = new JTextField(6);
	          JLabel l5= new JLabel("Nombre del Profesor");
	          JTextField nombre_profesor = new JTextField(15);
	          JLabel l6= new JLabel("Segundo Nombre del Profesor");
	          JTextField seg_nombre_profesor = new JTextField(15);
	          JLabel l7= new JLabel("Apellido del Profesor");
	          JTextField apellido_profesor = new JTextField(15);
			  JLabel l8= new JLabel("Segundo Apellido del Profesor");
	          JTextField seg_apellido_profesor = new JTextField(15);
	          JLabel l9= new JLabel("Cedula del Profesor");
	          JTextField cedula_prof = new JTextField(15);	          
	          JLabel l10= new JLabel("Costo del Curso");
	          JTextField costo = new JTextField(5);	 
	          JPanel contendor = new JPanel();
	         
public cursos(){
	          b1.addActionListener(this);
	          b2.addActionListener(this);
	           contendor.setLayout( new GridLayout(6,2,10,10));
	          contendor.add(l1);
	          contendor.add(nombre_curso);  
	          contendor.add(l2);
	          contendor.add(asginatura_codigo);  
	          contendor.add(l3);
	          contendor.add(horario_codigo);  
	          contendor.add(l4);
	          contendor.add(abreviatura);  
	          contendor.add(l5);
	          contendor.add(nombre_profesor);
	          contendor.add(l6);
	          contendor.add(seg_nombre_profesor);
	          contendor.add(l7);
	          contendor.add(apellido_profesor);
	          contendor.add(l8);
	          contendor.add(seg_apellido_profesor);
	          contendor.add(l9);
	          contendor.add(cedula_prof);
	          contendor.add(l10);
	          contendor.add(costo);
	          contendor.add(b1);
	          contendor.add(b2);
	          setContentPane(contendor);
	}
public static void main(String arg[]){
	JFrame frame = new cursos();
	WindowListener a1 = new WindowAdapter(){
	 public void windowClosing(WindowEvent e){
	  System.exit(0);
	 }	 	
	 };
	 frame.addWindowListener(a1);
	 frame.pack();
	 frame.setVisible(true); 
	}	
public void actionPerformed(ActionEvent evt){
	Object source = evt.getSource();
	if(source==b1){
	setTitle("Creador de Documentos");
	try{
		File archivo= new File("c: ariel.li3");
		FileWriter fw= new FileWriter(archivo,true);
		BufferedWriter out=new BufferedWriter(fw);
		out.write("\n");
		out.write(nombre_curso.getText());
		out.write("?");
		out.write(asginatura_codigo.getText());
		out.write("?");
		out.write(horario_codigo.getText());
		out.write("?");
		out.write(abreviatura.getText());
		out.write("?");
		out.write(nombre_profesor.getText());
		out.write("?");
		out.write(seg_nombre_profesor.getText());
		out.write("?");
		out.write(apellido_profesor.getText());
		out.write("?");
		out.write(seg_apellido_profesor.getText());
		out.write("?");
		out.write(cedula_prof.getText());
		out.write("?");
		out.write(costo.getText());
		out.close();
		JOptionPane.showMessageDialog(null,"El Achivo ha sido creado"); 
	   }catch(IOException e){
	   	System.out.println("Error -"+ e.toString());
	   }
	}	  
	 else if(source == b2)
	   System.exit(0); 
	 repaint();   
	}

} 