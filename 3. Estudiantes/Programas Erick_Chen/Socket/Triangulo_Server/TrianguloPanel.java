import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;
public class TrianguloPanel extends JPanel{
    JTextField jtfbase=new JTextField(20);
    JTextField jtfaltura=new JTextField(20);
    JTextField jtfarea=new JTextField(20);
    Triangulo t;
    public TrianguloPanel(){
        setBorder(new BevelBorder(BevelBorder.RAISED));
        JPanel p1=new JPanel();
        p1.setLayout(new GridLayout(3,1));
        p1.add(new JLabel("Base"));
        p1.add(new JLabel("Altura"));
        p1.add(new JLabel("Area"));
        JPanel p2=new JPanel();
        p2.setLayout(new GridLayout(3,1));
        p2.add(jtfbase);
        p2.add(jtfaltura);
        p2.add(jtfarea);
        setLayout(new BorderLayout());
        add(p1,BorderLayout.WEST);
        add(p2,BorderLayout.CENTER);
    }
    public Triangulo getTriangulo(){
        t= new Triangulo(Integer.parseInt(jtfbase.getText().trim()),Integer.parseInt(jtfaltura.getText().trim()));
        return t;
    } 
    
   public void setTriangulo(Triangulo t){
        jtfarea.setText(String.valueOf(t.getArea()));
    }
    public void setClearTriangulo(){
        jtfbase.setText("");
        jtfaltura.setText("");
        jtfarea.setText("");
    }
}
