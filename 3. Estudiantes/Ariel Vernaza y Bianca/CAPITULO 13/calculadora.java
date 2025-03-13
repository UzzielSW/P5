import java.awt.*;
import javax.swing.*;

public class Calculadora {
  private JLabel resultado;
  private JButton cero, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, punto, igual, mas, menos, por, entre;

  public Calculadora() {
    resultado = new JLabel("0.0", JLabel.RIGHT);
    resultado.setBackground(Color.BLUE);
    cero = new JButton("0");
    uno = new JButton("1");
    dos = new JButton("2");
    tres = new JButton("3");
    cuatro = new JButton("4");
    cinco = new JButton("5");
    seis = new JButton("6");
    siete = new JButton("7");
    ocho = new JButton("8");
    nueve = new JButton("9");
    igual = new JButton("=");
    igual.setBackground(Color.pink);
    mas = new JButton("+");
    menos = new JButton("-");
    por = new JButton("X");
    entre = new JButton("/");
    punto = new JButton(".");
  }

  public void launchframe() {
    JFrame windows = new JFrame("Calculadora");
    windows.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    Container f = windows.getContentPane();
    f.setLayout(new BorderLayout());
    f.add(resultado, BorderLayout.NORTH);
    CalculatorListener action = new CalculatorListener(this.resultado);
    JPanel p1 = new JPanel();
    p1.setLayout(new GridLayout(5, 4));
    siete.addActionListener(action);
    p1.add(siete);
    ocho.addActionListener(action);
    p1.add(ocho);
    nueve.addActionListener(action);
    p1.add(nueve);
    mas.addActionListener(action);
    p1.add(mas);
    cuatro.addActionListener(action);
    p1.add(cuatro);
    cinco.addActionListener(action);
    p1.add(cinco);
    seis.addActionListener(action);
    p1.add(seis);
    menos.addActionListener(action);
    p1.add(menos);
    uno.addActionListener(action);
    p1.add(uno);
    dos.addActionListener(action);
    p1.add(dos);
    tres.addActionListener(action);
    p1.add(tres);
    por.addActionListener(action);
    p1.add(por);
    cero.addActionListener(action);
    p1.add(cero);
    punto.addActionListener(action);
    p1.add(punto);
    igual.addActionListener(action);
    p1.add(igual);
    entre.addActionListener(action);
    p1.add(entre);
    windows.add(p1, BorderLayout.CENTER);
    windows.pack();
    windows.setVisible(true);
  }
  public static void main(String args[]) {
    Calculadora test = new Calculadora();
    test.launchframe();
  }
}