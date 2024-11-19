// TODO: Adaptar a la version con mas items
import java.awt.*;
import javax.swing.*;

public class UIStyles extends JFrame {

    public String[] formas = {
        "com.sun.java.swing.plaf.windows.WindowsLookAndFeel",
        "javax.swing.plaf.metal.MetalLookAndFeel",
        "javax.swing.plaf.nimbus.NimbusLookAndFeel",
        "com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel"
    };

    int style;
    JComboBox<String> comBox;
    JProgressBar bar;
    JSlider slider;

    public UIStyles() {
        this.setTitle("DefaultUI");
        style = 0;

        this.setLayout(new FlowLayout());
        JButton changes = new JButton("Next (n)");
        changes.setMnemonic('n');
        changes.addActionListener(e -> {
            if (style == formas.length) {
                style = 0;
            }
            cambiarEstilo(style++);
        });

        this.add(changes);
        this.add(new JCheckBox("Pick me", true));

        bar = new JProgressBar(1, formas.length);
        bar.setValue(7);
        this.add(bar);

        this.add(new JRadioButton("Click here", true));

        slider = new JSlider(1, formas.length, 1);
        this.add(slider);

        this.add(new JPasswordField("mypassword"));

        comBox = new JComboBox<>(formas);
        comBox.addActionListener(e -> {
            String selecteStyle = (String) comBox.getSelectedItem();
            for (int i = 0; i < formas.length; i++) {
                if (selecteStyle.equals(formas[i])) {
                    cambiarEstilo(i);
                    break;
                }
            }
        });

        this.add(comBox);

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.pack();
    }

    public void cambiarEstilo(int s) {
        try {
            this.setTitle(s + ": " + formas[s]);
            comBox.setSelectedIndex(s);
            bar.setValue(s + 1);
            slider.setValue(s + 1);
            UIManager.setLookAndFeel(formas[s]);
            SwingUtilities.updateComponentTreeUI(this);
            this.pack();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException e) {
            System.out.println("No se pudo configurar la apariencia");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { //runnable lambda
            UIStyles v = new UIStyles();
            v.setVisible(true);
        });
    }
}
