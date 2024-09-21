package cajero;

import JButton;

public class InicioGUI extends JFrame{

    public InicioGUI() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelSuperior = new JPanel();
        titulo = new JLabel();
        logo = new JLabel();
        panelCenter = new JPanel();
        jLabel3 = new JLabel();
        tnombre = new JTextField();
        jLabel4 = new JLabel();
        tapellido = new JTextField();
        jLabel5 = new JLabel();
        tcedula = new JTextField();
        jLabel6 = new JLabel();
        tclave = new JTextField();
        btnInicio = new JButton();

        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        panelSuperior.setLayout(new java.awt.BorderLayout());

        titulo.setBackground(new java.awt.Color(253, 253, 253));
        titulo.setHorizontalAlignment(SwingConstants.CENTER);
        titulo.setText("BANCO INTERNACIONAL");
        titulo.setMaximumSize(new java.awt.Dimension(16, 16));
        titulo.setMinimumSize(new java.awt.Dimension(16, 16));
        titulo.setPreferredSize(new java.awt.Dimension(50, 16));
        panelSuperior.add(titulo, java.awt.BorderLayout.NORTH);

        logo.setIcon(new ImageIcon(getClass().getResource("/imagenes/banco.png"))); // NOI18N
        panelSuperior.add(logo, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelSuperior, java.awt.BorderLayout.NORTH);

        panelCenter.setBackground(new java.awt.Color(255, 255, 255));
        panelCenter.setLayout(new java.awt.GridLayout(4, 2));

        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("Nombre:");
        panelCenter.add(jLabel3);
        panelCenter.add(tnombre);

        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setText("Apellido:");
        panelCenter.add(jLabel4);
        panelCenter.add(tapellido);

        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("Cedula:");
        panelCenter.add(jLabel5);
        panelCenter.add(tcedula);

        jLabel6.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel6.setText("Clave:");
        panelCenter.add(jLabel6);
        panelCenter.add(tclave);

        getContentPane().add(panelCenter, java.awt.BorderLayout.CENTER);

        btnInicio.setText("iniciar sesion");
        getContentPane().add(btnInicio, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public JButton getBtnInicio() {
        return btnInicio;
    }

    public boolean Validar() {

        if (tnombre.getText().isEmpty() || tapellido.getText().isEmpty() || tcedula.getText().isEmpty() || tclave.getText().isEmpty()) {
            return false;
        }

        return true;
    }

    public Cuenta getDataClient() {
//        Miguel, López, 5-5555-5555, 6159
        return new Cuenta(tnombre.getText().trim(), tapellido.getText().trim(), tcedula.getText().trim(), tclave.getText().trim());
    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(InicioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InicioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InicioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InicioGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InicioGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnInicio;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel logo;
    private JPanel panelCenter;
    private JPanel panelSuperior;
    private JTextField tapellido;
    private JTextField tcedula;
    private JTextField tclave;
    private JLabel titulo;
    private JTextField tnombre;
    // End of variables declaration//GEN-END:variables
}
