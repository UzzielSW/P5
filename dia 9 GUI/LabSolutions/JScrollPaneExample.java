/**
 * https://stackoverflow.com/questions/53486852/how-to-add-a-vertical-and-horizontal-scroll-bar-in-a-jtextarea-to-view-complete
 * @(#)ScrollPaneExample.java
 *
 *
 * @author 
 * @version 1.00 2023/10/15
 *  Modificado por MSc. Álvaro Pino N.
 *  Date 15/10/2023
 */


    import java.awt.BorderLayout;
    import javax.swing.*;
   

public class JScrollPaneExample {

	public JScrollPaneExample() {
		JTextArea textArea = new JTextArea();
		textArea.setText("Indice TIOBE");
		textArea.append("\n*************");
		textArea.append("\n 1 - Java");
		textArea.append("\n 2 - C");
		textArea.append("\n 3 - Phyton");
		textArea.append("\n 4 - C++");
		textArea.append("\n 5 - Visual Basic .NET");
		textArea.append("\n 6 - JavaScript");
		textArea.append("\n 7 - C#");
		textArea.append("\n 8 - PHP");
		textArea.append("\n 9 - SQL");
	//	textArea.append("\n 10 - Objective - C");
		textArea.append("\n 10 -  Facultad de Informatica, Electronica y Comunicacion");
        textArea. setWrapStyleWord(true);
		JScrollPane scrollBar = new JScrollPane(textArea);

scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		JFrame frame = new JFrame("Ejemplo JScrollPane");
		
		frame.getContentPane().add(scrollBar, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(300, 180);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		new JScrollPaneExample();
	}

}

