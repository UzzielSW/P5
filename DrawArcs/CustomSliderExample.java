
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSlider;
import javax.swing.SwingUtilities;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.basic.BasicSliderUI;

public class CustomSliderExample extends JFrame {

    public CustomSliderExample() {
        setTitle("Custom Slider Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(230, 120);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);

        CustomSlider customSlider = new CustomSlider(0, 100, 50);
        panel.add(customSlider);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CustomSliderExample().setVisible(true));
    }
}

class CustomSlider extends JPanel {

    private JSlider slider;
    private JProgressBar progressBar;

    public CustomSlider(int min, int max, int value) {
        setBorder(new TitledBorder("Speed Slider"));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        slider = new JSlider(min, max, value) {
            @Override
            public void updateUI() {
                setUI(new CustomSliderUI(this));
            }
        };
        slider.setPaintTicks(true);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);

        progressBar = new JProgressBar(min, max) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

                // Color de fondo
                g2.setColor(new Color(230, 230, 230));
                g2.fillRect(0, 0, getWidth(), getHeight());

                // Color de la barra de progreso
                g2.setColor(new Color(255, 140, 0)); // Naranja como el slider
                int width = (int) ((getWidth() - 4) * getPercentComplete());
                g2.fillRect(2, 2, width, getHeight() - 4);

                // Configurar la fuente más pequeña
                Font originalFont = g2.getFont();
                Font smallerFont = originalFont.deriveFont(10f); // Ajusta este valor según necesites
                g2.setFont(smallerFont);

                // Dibujar el texto del porcentaje
                String text = getString();
                FontMetrics fm = g2.getFontMetrics();
                int textWidth = fm.stringWidth(text);
                int textHeight = fm.getHeight();
                g2.setColor(Color.BLACK);
                g2.drawString(text, (getWidth() - textWidth) / 2, (getHeight() + textHeight) / 2 - fm.getDescent());

                g2.dispose();
            }
        };

        progressBar.setPreferredSize(new Dimension(progressBar.getPreferredSize().width, 15)); // Altura reducida
        progressBar.setBorderPainted(false);
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(255, 140, 0)); // Color naranja
        progressBar.setBackground(new Color(230, 230, 230)); // Color de fondo claro
        progressBar.setValue(slider.getValue());

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;
        gbc.insets = new Insets(0, 0, 5, 0);
        add(slider, gbc);

        gbc.gridy = 0;
        add(progressBar, gbc);

        slider.addChangeListener(e -> {
            progressBar.setValue(slider.getValue());
            progressBar.setString(slider.getValue() + "%");
        });
    }
}

class CustomSliderUI extends BasicSliderUI {

    public CustomSliderUI(JSlider slider) {
        super(slider);
    }

    @Override
    public void paintTrack(Graphics g) {
        super.paintTrack(g);
        Rectangle trackBounds = trackRect;
        int cy = (trackBounds.height / 2) - 2;
        int w = trackBounds.width;

        g.setColor(new Color(255, 140, 0)); // Color naranja para la barra
        g.fillRect(trackRect.x, trackRect.y + cy, w, 4);
    }

    @Override
    public void paintThumb(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Rectangle thumbBounds = thumbRect;
        int w = thumbBounds.width;
        int h = thumbBounds.height;

        g2d.setColor(new Color(255, 140, 0)); // Color naranja para el thumb
        g2d.fillRoundRect(thumbBounds.x, thumbBounds.y, w - 1, h - 1, 10, 10);

        g2d.setColor(Color.WHITE);
        int triangleSize = 8;
        int[] xPoints = {thumbBounds.x + w / 2, thumbBounds.x + w / 2 - triangleSize / 2, thumbBounds.x + w / 2 + triangleSize / 2};
        int[] yPoints = {thumbBounds.y + h / 2 - triangleSize / 2, thumbBounds.y + h / 2 + triangleSize / 2, thumbBounds.y + h / 2 + triangleSize / 2};
        g2d.fillPolygon(xPoints, yPoints, 3);
    }
}
