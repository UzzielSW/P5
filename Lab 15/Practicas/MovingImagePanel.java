import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovingImagePanel extends JFrame {

    public MovingImagePanel() {
        setTitle("Panel con Imagen en Movimiento");
        setSize(660, 316);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImagePanel panel = new ImagePanel();
        add(panel);

        // Timer para mover la imagen cada 100 milisegundos
        Timer timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.moveImage();
                panel.repaint();
            }
        });
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            MovingImagePanel frame = new MovingImagePanel();
            frame.setVisible(true);
        });
    }
}

class ImagePanel extends JPanel {
    private Image backgroundImage;
    private Image movingImage;
    private int movingImageX = 0;
    private int movingImageY = 0;
    private int dx = 2; // Velocidad horizontal
    private int dy = 2; // Velocidad vertical

    public ImagePanel() {
        backgroundImage = new ImageIcon("pista.jpg").getImage();
        movingImage = new ImageIcon("award1.png").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Dibujar imagen de fondo
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        // Dibujar imagen en movimiento
        g.drawImage(movingImage, movingImageX, movingImageY, 50, 50, this);
    }

    public void moveImage() {
        // Mover la imagen
        movingImageX += dx;
        movingImageY += dy;

        // Rebotar en los bordes
        if (movingImageX <= 0 || movingImageX >= getWidth() - 50) {
            dx = -dx;
        }
        if (movingImageY <= 0 || movingImageY >= getHeight() - 50) {
            dy = -dy;
        }
    }
}