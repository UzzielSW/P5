import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class PowerRainbowButtonExample extends JFrame {

    public PowerRainbowButtonExample() {
        setTitle("Power Rainbow Button Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);

        PowerRainbowButton powerButton = new PowerRainbowButton(40);
        panel.add(powerButton);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PowerRainbowButtonExample().setVisible(true);
        });
    }
}

class PowerRainbowButton extends JToggleButton {
    private float hue = 0;
    private final int size;
    private boolean isRainbowActive = false;
    private Timer rainbowTimer;

    public PowerRainbowButton(int size) {
        this.size = size;
        setPreferredSize(new Dimension(size, size));
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);

        rainbowTimer = new Timer(50, e -> {
            if (isRainbowActive) {
                hue += 0.01f;
                if (hue > 1) hue = 0;
                repaint();
            }
        });
        rainbowTimer.start();

        addActionListener(e -> {
            isRainbowActive = isSelected();
            if (!isRainbowActive) {
                hue = 0;
            }
            repaint();
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Dibujar el círculo exterior
        g2d.setColor(isRainbowActive ? Color.getHSBColor(hue, 1, 1) : Color.GRAY);
        g2d.fillOval(0, 0, size - 1, size - 1);

        // Dibujar el símbolo de encendido
        g2d.setColor(Color.WHITE);
        g2d.setStroke(new BasicStroke(size / 10f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
        int centerX = size / 2;
        int centerY = size / 2;
        int radius = size / 4;
        g2d.drawArc(centerX - radius, centerY - radius, radius * 2, radius * 2, -60, 300);
        g2d.drawLine(centerX, size / 5, centerX, centerY);

        g2d.dispose();
        super.paintComponent(g);
    }
}