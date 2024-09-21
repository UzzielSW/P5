import java.awt.*;
import *;
public class Gridl {
 
    public static void main(String[] args) {
        int cant = 4;
        JButton []boton = new JButton[cant];
        for (int i = 0; i < cant; i++ ) {
            if(i % 2 == 0) boton[i] = new JButton("O");
            else boton[i] = new JButton("X");
        }
        JFrame marco = new JFrame();
        marco.setTitle("GridLayout");
        marco.setSize(300,300);
        marco.setLocationRelativeTo(null);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.setVisible(true);
       
        //GridLayout()(int rows, int cols, int hgap, int vgap)
        marco.setLayout(new GridLayout(3, 3, 5, 10));
        for (int i = 0; i < cant; i++) {
            marco.add(boton[i]);
        }
    }
}
