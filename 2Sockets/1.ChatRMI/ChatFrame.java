
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.text.DefaultCaret;

public class ChatFrame extends JFrame {

    protected JEditorPane output;
    protected JScrollPane scroll;
    protected JTextField input;

    public ChatFrame(String title) {
        super(title);

        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        output = new JEditorPane("text/html", "");
        output.setEditable(false);
        output.setFocusable(false);

        DefaultCaret caret = (DefaultCaret) output.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
        scroll = new JScrollPane(output, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,
                ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        add("Center", scroll);
        add("South", input = new JTextField());
        input.setPreferredSize(new Dimension(0, 30));
        input.setBorder(BorderFactory.createCompoundBorder(
                input.getBorder(),
                BorderFactory.createEmptyBorder(2, 2, 2, 2)
        ));

        setVisible(true);
        input.requestFocus();
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(() -> new ChatFrame("Chat Test"));
    }
}
