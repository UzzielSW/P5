/**
 * @(#)CerrarVentana.java
 *
 *
 * @author 
 * @version 1.00 2020/10/23
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CerrarVentana {
        
    /**
     * Creates a new instance of <code>CerrarVentana</code>.
     */
    public CerrarVentana() {
    }
    
    /**
     * @param args the command line arguments
     */
    
        
        public static void main(String[] args) {
        	// TODO code application logic here
        	
        final JFrame frame = new JFrame("Test Frame");

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        frame.setSize(800, 600);

        frame.addWindowListener(new WindowAdapter() {
            //I skipped unused callbacks for readability

            @Override
            public void windowClosing(WindowEvent e) {
                if(JOptionPane.showConfirmDialog(frame, "Are you sure ?") == JOptionPane.OK_OPTION){
                    frame.setVisible(false);
                    frame.dispose();
                }
            }
        });

        frame.setVisible(true);
    }
        
    }

