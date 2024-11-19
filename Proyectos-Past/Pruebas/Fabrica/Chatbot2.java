
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Chatbot2 {

    private static JTextArea textArea1;
    private static JTextArea textArea2;
    private static JTextArea textArea3;
    private static JButton sendButton;
    private static JButton clearButton;

    private static final Object lock = new Object(); // Objeto de bloqueo para sincronización

    public static void main(String[] args) {
        JFrame ventana1 = new JFrame("Ventana 1");
        ventana1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana1.setLayout(new FlowLayout());
        ventana1.setLocation(250, 250);
        textArea1 = new JTextArea(10, 20);
        sendButton = new JButton("EMPEZAR");

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendButton.setEnabled(false);
                String[] lines = textArea1.getText().split("\n");
                new LineThread(lines).start();
            }
        });
        ventana1.add(textArea1);
        ventana1.add(sendButton);
        ventana1.pack();
        ventana1.setVisible(true);

        JFrame ventana2 = new JFrame("Ventana 2");
        ventana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana2.setLayout(new FlowLayout());
        ventana2.setLocation(600, 200);
        textArea2 = new JTextArea(1, 20);
        textArea2.setEditable(false);
        ventana2.add(textArea2);
        ventana2.pack();
        ventana2.setVisible(true);

        JFrame ventana3 = new JFrame("Ventana 3");
        ventana3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana3.setLayout(new FlowLayout());
        ventana3.setLocation(600, 300);
        textArea3 = new JTextArea(10, 20);
        textArea3.setEditable(false);
        ventana3.add(textArea3);

        ventana3.pack();
        ventana3.setVisible(true);
    }

    private static class LineThread extends Thread {
        private final String[] lines;

        public LineThread(String[] lines) {
            this.lines = lines;
        }

        @Override
        public void run() {
            synchronized (lock) {
                for (String line : lines) {
                    try {
                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                textArea2.setText(line);
                            }
                        });

                        lock.wait(3000); // Espera de 3 segundos

                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                textArea3.append(line + "\n");
                            }
                        });

                        SwingUtilities.invokeLater(new Runnable() {
                            @Override
                            public void run() {
                                textArea1.setText(textArea1.getText().replaceFirst(line, "").trim());
                            }
                        });

                        lock.notify(); // Notifica para que la siguiente línea pueda procesarse
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        sendButton.setEnabled(true);
                    }
                });
            }
        }
    }
}