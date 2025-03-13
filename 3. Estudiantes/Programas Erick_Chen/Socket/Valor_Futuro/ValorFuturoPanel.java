import java.awt.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;

public class ValorFuturoPanel extends JPanel {
    JTextField jtfmonto = new JTextField(20);
    JTextField jtfanos = new JTextField(20);
    JTextField jtfinteres = new JTextField(20);
    JTextField jtfvalfuture = new JTextField(20);
    Valor_Futuro t;

    public ValorFuturoPanel() {

        setBorder(new BevelBorder(BevelBorder.RAISED));
        JPanel p1 = new JPanel();
        p1.setLayout(new GridLayout(4, 1));
        p1.add(new JLabel("Monto"));
        p1.add(new JLabel("years"));
        p1.add(new JLabel("Interes Acumulado"));
        p1.add(new JLabel("valor Futuro"));
        JPanel p2 = new JPanel();
        p2.setLayout(new GridLayout(4, 1));
        p2.add(jtfmonto);
        p2.add(jtfanos);
        p2.add(jtfinteres);
        p2.add(jtfvalfuture);
        setLayout(new BorderLayout());
        add(p1, BorderLayout.WEST);
        add(p2, BorderLayout.CENTER);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public Valor_Futuro getValorFuturo() {
        t = new Valor_Futuro(Integer.parseInt(jtfmonto.getText().trim()), Integer.parseInt(jtfanos.getText().trim()),
                Double.parseDouble(jtfinteres.getText().trim()));
        return t;
    }

    public void setValorFuturo(Valor_Futuro t) {
        jtfvalfuture.setText(String.valueOf(t.getvalorfuturo()));
    }

    public void setClearTriangulo() {
        jtfmonto.setText("");
        jtfanos.setText("");
        jtfinteres.setText("");
        jtfvalfuture.setText("");
    }
}
