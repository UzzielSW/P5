import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class MousePositionTracker extends JFrame {
    private JLabel positionLabel;

    public MousePositionTracker() {
        // Configuración del JFrame
        setTitle("Mouse Position Tracker");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // Crear el JLabel
        positionLabel = new JLabel("Mueve el mouse dentro del frame");
        add(positionLabel);

        // Agregar el MouseListener
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                updateMousePosition(e.getX(), e.getY());
            }
        });
    }

    private void updateMousePosition(int x, int y) {
        positionLabel.setText("Posición del mouse: x=" + x + ", y=" + y);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MousePositionTracker tracker = new MousePositionTracker();
            tracker.setVisible(true);
        });
    }
}