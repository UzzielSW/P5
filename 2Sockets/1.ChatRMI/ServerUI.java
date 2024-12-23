
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Insets;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.text.DefaultCaret;

/**
 * @version 2.0 Chat con RMI
 * @author Brayan Puyol y Ashly Mendieta
 * @Fecha
 */
public class ServerUI extends javax.swing.JFrame {

    public ServerUI() {
        messages = new java.util.concurrent.ConcurrentLinkedQueue<>();
        initComponents();
        setLocationRelativeTo(null);

        jListUsers.addListSelectionListener((ListSelectionEvent e) -> {
            jFieldName.setText(jListUsers.getSelectedValue());
        });
        
        DefaultCaret caret = (DefaultCaret) jEditorChat.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    private void initComponents() {//GEN-BEGIN:initComponents

        jPanelL = new JPanel();
        jScrollChat = new JScrollPane();
        jEditorChat = new JEditorPane();
        jS2 = new JSeparator();
        jTextChat = new JTextArea();
        jPanelC = new JPanel();
        jLabelName = new JLabel();
        jFieldName = new JTextField();
        jButtonDesconectar = new JButton();
        jS1 = new JSeparator();
        jLabelUsers = new JLabel();
        jScrollList = new JScrollPane();
        jListUsers = new JList<>();
        jButtonFinalizar = new JButton();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new Dimension(600, 390));
        setMinimumSize(new Dimension(600, 390));
        setPreferredSize(new Dimension(600, 390));
        setResizable(false);

        jPanelL.setPreferredSize(new Dimension(380, 380));
        jPanelL.setLayout(new BoxLayout(jPanelL, BoxLayout.Y_AXIS));

        jScrollChat.setBackground(new Color(40, 42, 44));
        jScrollChat.setToolTipText("");
        jScrollChat.setAutoscrolls(true);
        jScrollChat.setFocusable(false);
        jScrollChat.setPreferredSize(new Dimension(100, 340));
        jScrollChat.setViewportView(jEditorChat);

        jEditorChat.setEditable(false);
        jEditorChat.setContentType("text/html"); // NOI18N
        jEditorChat.setText("");
        jEditorChat.setFocusable(false);
        jEditorChat.setMargin(new Insets(0, 0, 0, 0));
        jEditorChat.setPreferredSize(new Dimension(80, 320));
        jScrollChat.setViewportView(jEditorChat);

        jPanelL.add(jScrollChat);

        jS2.setPreferredSize(new Dimension(30, 5));
        jPanelL.add(jS2);

        jTextChat.setColumns(20);
        jTextChat.setRows(1);
        jTextChat.setToolTipText("");
        jTextChat.setMargin(new Insets(5, 5, 5, 5));
        jTextChat.setMaximumSize(new Dimension(2147483647, 26));
        jPanelL.add(jTextChat);

        getContentPane().add(jPanelL, BorderLayout.LINE_START);

        jPanelC.setFocusable(false);
        jPanelC.setPreferredSize(new Dimension(220, 380));
        jPanelC.setLayout(new BoxLayout(jPanelC, BoxLayout.Y_AXIS));

        jLabelName.setHorizontalAlignment(SwingConstants.LEFT);
        jLabelName.setText("Desconectar a");
        jLabelName.setAlignmentX(0.5F);
        jLabelName.setHorizontalTextPosition(SwingConstants.CENTER);
        jLabelName.setMaximumSize(new Dimension(185, 18));
        jLabelName.setMinimumSize(new Dimension(185, 18));
        jLabelName.setPreferredSize(new Dimension(185, 18));
        jPanelC.add(jLabelName);

        jFieldName.setEditable(false);
        jFieldName.setHorizontalAlignment(JTextField.LEFT);
        jFieldName.setMargin(new Insets(-1, 3, -1, 3));
        jFieldName.setMaximumSize(new Dimension(185, 25));
        jFieldName.setMinimumSize(new Dimension(185, 25));
        jFieldName.setPreferredSize(new Dimension(185, 25));
        jPanelC.add(jFieldName);

        jButtonDesconectar.setBackground(new Color(255, 228, 146));
        jButtonDesconectar.setForeground(new Color(0, 0, 0));
        jButtonDesconectar.setMnemonic('d');
        jButtonDesconectar.setToolTipText("");
        jButtonDesconectar.setAlignmentX(0.5F);
        jButtonDesconectar.setBorderPainted(false);
        jButtonDesconectar.setFocusable(false);
        jButtonDesconectar.setHorizontalTextPosition(SwingConstants.CENTER);
        jButtonDesconectar.setLabel("Desconectar");
        jButtonDesconectar.setMargin(new Insets(0, 0, 0, 0));
        jButtonDesconectar.setMaximumSize(new Dimension(185, 25));
        jButtonDesconectar.setMinimumSize(new Dimension(185, 25));
        jButtonDesconectar.setPreferredSize(new Dimension(185, 25));
        jPanelC.add(jButtonDesconectar);

        jS1.setMaximumSize(new Dimension(100, 5));
        jS1.setMinimumSize(new Dimension(185, 5));
        jS1.setPreferredSize(new Dimension(185, 5));
        jPanelC.add(jS1);

        jLabelUsers.setHorizontalAlignment(SwingConstants.CENTER);
        jLabelUsers.setText("Users Online");
        jLabelUsers.setAlignmentX(0.5F);
        jLabelUsers.setFocusable(false);
        jLabelUsers.setHorizontalTextPosition(SwingConstants.CENTER);
        jLabelUsers.setMaximumSize(new Dimension(185, 25));
        jLabelUsers.setMinimumSize(new Dimension(185, 25));
        jLabelUsers.setPreferredSize(new Dimension(185, 25));
        jPanelC.add(jLabelUsers);

        jScrollList.setMaximumSize(new Dimension(185, 220));
        jScrollList.setMinimumSize(new Dimension(185, 220));
        jScrollList.setPreferredSize(new Dimension(185, 220));

        jListUsers.setMaximumSize(new Dimension(185, 220));
        jListUsers.setMinimumSize(new Dimension(185, 220));
        jListUsers.setPreferredSize(new Dimension(185, 240));
        jScrollList.setViewportView(jListUsers);

        jPanelC.add(jScrollList);

        jButtonFinalizar.setBackground(new Color(255, 77, 78));
        jButtonFinalizar.setMnemonic('s');
        jButtonFinalizar.setAlignmentX(0.5F);
        jButtonFinalizar.setBorderPainted(false);
        jButtonFinalizar.setFocusable(false);
        jButtonFinalizar.setHorizontalTextPosition(SwingConstants.CENTER);
        jButtonFinalizar.setLabel("Terminar Sesiones y Salir");
        jButtonFinalizar.setMargin(new Insets(0, 0, 0, 0));
        jButtonFinalizar.setMaximumSize(new Dimension(185, 25));
        jButtonFinalizar.setPreferredSize(new Dimension(185, 25));
        jPanelC.add(jButtonFinalizar);

        getContentPane().add(jPanelC, BorderLayout.CENTER);

        pack();
    }//GEN-END:initComponents

    public void setjListUsers(String[] Users) {
        DefaultListModel<String> modeloLista = new DefaultListModel<>();

        for (String elemento : Users) {
            modeloLista.addElement(elemento);
        }

        jListUsers.setModel(modeloLista);
    }

    public void setMessageChat(Message s) {
        messages.add("<div style='border:1px solid #ccc; padding:5px; margin:3px; border-radius:10px; font-family:arial;'>" +
            "<b style='color:red;'>" + s.name + "</b><br/>" +
            "<span style='color:#333;'>" + s.text + "</span>" +
            "</div>");
        viewMessages();
    }

    private void viewMessages() {
        StringBuilder sb = new StringBuilder("<html><body>");
        
        for (String message : messages) {
            sb.append(message);
        }

        sb.append("</body></html>");
        jEditorChat.setText(sb.toString());
    }

    public void removeUser(String u) {
        
        DefaultListModel<String> modelo = (DefaultListModel<String>) jListUsers.getModel();
        int pos = modelo.indexOf(u);
        
        if (pos != -1) {
            modelo.remove(pos);
        } else {
            System.out.println("Usuario no se encuentra en la lista");
        }
        
        jListUsers.setModel(modelo);
    }

    public JButton getjButtonDesconectar() {
        return jButtonDesconectar;
    }

    public JButton getjButtonFinalizar() {
        return jButtonFinalizar;
    }

    public JTextField getjFieldName() {
        return jFieldName;
    }

    public JTextArea getjTextChat() {
        return jTextChat;
    }

    public static void main(String args[]) {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ServerUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ServerUI().setVisible(true);
            }
        });
    }

    private final java.util.concurrent.ConcurrentLinkedQueue<String> messages;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton jButtonDesconectar;
    private JButton jButtonFinalizar;
    private JEditorPane jEditorChat;
    private JTextField jFieldName;
    private JLabel jLabelName;
    private JLabel jLabelUsers;
    private JList<String> jListUsers;
    private JPanel jPanelC;
    private JPanel jPanelL;
    private JSeparator jS1;
    private JSeparator jS2;
    private JScrollPane jScrollChat;
    private JScrollPane jScrollList;
    private JTextArea jTextChat;
    // End of variables declaration//GEN-END:variables
}
