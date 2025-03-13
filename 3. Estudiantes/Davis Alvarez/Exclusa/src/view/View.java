package view;

import modeling.Buque;
import modeling.Compuerta;
import modeling.Exclusa;
/**Clase encargada de la parte gráfica de la simulación.
 */
 public class View extends javax.swing.JFrame {
    
   
    private Exclusa[] exclusas_array;
    private Compuerta[] compuertas_array;
    private Buque barco;
    
    private boolean inicio =true;
    private boolean c1 =false;
    
    private boolean controlador1 = false;
    private boolean controlador2 = false;
    private boolean controlador3=false;
    private boolean controlador4=false;
    private boolean controlador5=false;
    private boolean controlador6=false;
    private boolean controlador7=false;
    private boolean controlador8=false;
    private boolean controlador9=false;
    private boolean controlador10=false;
    
    /**Constuye un GUI.
    *@param barco objeto Buque que pasa por los objetos Exclusa.
     @param exclusas_array arreglo de objetos Exclusa.
     @param compuertas_array arreglo de objetos Compuerta.*/
    
    public View(Buque barco, Exclusa[] exclusas_array, Compuerta[] compuertas_array) {
        
        super("Exclusas de Gatún");
        this.exclusas_array = exclusas_array;
        this.compuertas_array = compuertas_array;
        this.barco = barco;
        
        initComponents();
        javax.swing.JLabel[] jLabel_array = {   buque,a_ex1,a_ex2,a_ex3,
                                                p1,p2,p3,p4};
        javax.swing.JButton[] jButton_array = { c1_abrir,c2_abrir,c3_abrir,c4_abrir,
                                                c1_cerrar,c2_cerrar,c3_cerrar,c4_cerrar,
                                                nivel1,nivel2,nivel3,nivel4};
        
        Thread t_actualizador = new T_Actualizador(barco, jLabel_array, jButton_array); // Actualizador  Thread
   
        t_actualizador.start();        
    }
    
    
    // <editor-fold defaultstate="collapsed" desc=" Generated Code ">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLayeredPane1 = new javax.swing.JLayeredPane();
        p4 = new javax.swing.JLabel();
        p3 = new javax.swing.JLabel();
        p2 = new javax.swing.JLabel();
        p1 = new javax.swing.JLabel();
        buque = new javax.swing.JLabel();
        a_ex1 = new javax.swing.JLabel();
        a_ex2 = new javax.swing.JLabel();
        a_ex3 = new javax.swing.JLabel();
        bg = new javax.swing.JLabel();
        nivel1 = new javax.swing.JButton();
        nivel2 = new javax.swing.JButton();
        nivel3 = new javax.swing.JButton();
        nivel4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        c1_abrir = new javax.swing.JButton();
        c1_cerrar = new javax.swing.JButton();
        c2_abrir = new javax.swing.JButton();
        c2_cerrar = new javax.swing.JButton();
        c3_abrir = new javax.swing.JButton();
        c3_cerrar = new javax.swing.JButton();
        c4_abrir = new javax.swing.JButton();
        c4_cerrar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        reset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);
        p4.setBackground(new java.awt.Color(0, 0, 0));
        p4.setIcon(new javax.swing.ImageIcon("Images\\negro.jpg"));
        p4.setBounds(462, 100, 5, 53);
        jLayeredPane1.add(p4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        p3.setBackground(new java.awt.Color(0, 0, 0));
        p3.setIcon(new javax.swing.ImageIcon("Images\\negro.jpg"));
        p3.setBounds(355, 100, 5, 53);
        jLayeredPane1.add(p3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        p2.setBackground(new java.awt.Color(0, 0, 0));
        p2.setIcon(new javax.swing.ImageIcon("Images\\negro.jpg"));
        p2.setBounds(221, 128, 5, 53);
        jLayeredPane1.add(p2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        p1.setBackground(new java.awt.Color(0, 0, 0));
        p1.setIcon(new javax.swing.ImageIcon("Images\\negro.jpg"));
        p1.setBounds(84, 155, 5, 53);
        jLayeredPane1.add(p1, javax.swing.JLayeredPane.DEFAULT_LAYER);
        p1.getAccessibleContext().setAccessibleName("p1");

        buque.setIcon(new javax.swing.ImageIcon("Images\\minicrucer.gif"));
        buque.setBounds(-45, 168, 140, 30);
        jLayeredPane1.add(buque, javax.swing.JLayeredPane.DEFAULT_LAYER);

        a_ex1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        a_ex1.setIcon(new javax.swing.ImageIcon("Images\\ex1.jpg"));
        a_ex1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        a_ex1.setBounds(88, 165, 140, 52);
        jLayeredPane1.add(a_ex1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        a_ex2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        a_ex2.setIcon(new javax.swing.ImageIcon("Images\\ex2.jpg"));
        a_ex2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        a_ex2.setBounds(225, 137, 130, 52);
        jLayeredPane1.add(a_ex2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        a_ex3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        a_ex3.setIcon(new javax.swing.ImageIcon("Images\\ex3.jpg"));
        a_ex3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        a_ex3.setBounds(359, 109, 110, 52);
        jLayeredPane1.add(a_ex3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        bg.setIcon(new javax.swing.ImageIcon("Images\\bg.jpg"));
        bg.setBounds(0, 40, 560, 220);
        jLayeredPane1.add(bg, javax.swing.JLayeredPane.DEFAULT_LAYER);

        nivel1.setText("Nivelar");
        nivel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivel1ActionPerformed(evt);
            }
        });

        nivel1.setBounds(90, 260, 80, 23);
        jLayeredPane1.add(nivel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        nivel2.setText("Nivelar");
        nivel2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivel2ActionPerformed(evt);
            }
        });

        nivel2.setBounds(190, 260, 80, 23);
        jLayeredPane1.add(nivel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        nivel3.setText("Nivelar");
        nivel3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivel3ActionPerformed(evt);
            }
        });

        nivel3.setBounds(320, 260, 80, 23);
        jLayeredPane1.add(nivel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        nivel4.setText("Nivelar");
        nivel4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nivel4ActionPerformed(evt);
            }
        });

        nivel4.setBounds(440, 260, 80, 23);
        jLayeredPane1.add(nivel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel1.setText("Control de Compuertas");
        jLabel1.setBounds(10, 310, 150, 14);
        jLayeredPane1.add(jLabel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jSeparator1.setBounds(0, 330, 430, 10);
        jLayeredPane1.add(jSeparator1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        c1_abrir.setText("Abrir");
        c1_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1_abrirActionPerformed(evt);
            }
        });

        c1_abrir.setBounds(20, 370, 80, 23);
        jLayeredPane1.add(c1_abrir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        c1_cerrar.setText("Cerrar");
        c1_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c1_cerrarActionPerformed(evt);
            }
        });

        c1_cerrar.setBounds(20, 400, 80, 23);
        jLayeredPane1.add(c1_cerrar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        c2_abrir.setText("Abrir");
        c2_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c2_abrirActionPerformed(evt);
            }
        });

        c2_abrir.setBounds(100, 370, 80, 23);
        jLayeredPane1.add(c2_abrir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        c2_cerrar.setText("Cerrar");
        c2_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c2_cerrarActionPerformed(evt);
            }
        });

        c2_cerrar.setBounds(100, 400, 80, 23);
        jLayeredPane1.add(c2_cerrar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        c3_abrir.setText("Abrir");
        c3_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c3_abrirActionPerformed(evt);
            }
        });

        c3_abrir.setBounds(180, 370, 80, 23);
        jLayeredPane1.add(c3_abrir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        c3_cerrar.setText("Cerrar");
        c3_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c3_cerrarActionPerformed(evt);
            }
        });

        c3_cerrar.setBounds(180, 400, 80, 23);
        jLayeredPane1.add(c3_cerrar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        c4_abrir.setText("Abrir");
        c4_abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c4_abrirActionPerformed(evt);
            }
        });

        c4_abrir.setBounds(260, 370, 80, 23);
        jLayeredPane1.add(c4_abrir, javax.swing.JLayeredPane.DEFAULT_LAYER);

        c4_cerrar.setText("Cerrar");
        c4_cerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                c4_cerrarActionPerformed(evt);
            }
        });

        c4_cerrar.setBounds(260, 400, 80, 23);
        jLayeredPane1.add(c4_cerrar, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel2.setText("#1");
        jLabel2.setBounds(50, 350, 20, 14);
        jLayeredPane1.add(jLabel2, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel3.setText("#2");
        jLabel3.setBounds(130, 350, 20, 14);
        jLayeredPane1.add(jLabel3, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel4.setText("#3");
        jLabel4.setBounds(210, 350, 20, 14);
        jLayeredPane1.add(jLabel4, javax.swing.JLayeredPane.DEFAULT_LAYER);

        jLabel5.setText("#4");
        jLabel5.setBounds(290, 350, 20, 14);
        jLayeredPane1.add(jLabel5, javax.swing.JLayeredPane.DEFAULT_LAYER);

        reset.setText("Reset");
        reset.setEnabled(false);
        reset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resetActionPerformed(evt);
            }
        });

        reset.setBounds(440, 380, 80, 23);
        jLayeredPane1.add(reset, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 554, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLayeredPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 438, Short.MAX_VALUE)
                .addContainerGap())
        );
        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void nivel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivel1ActionPerformed
        //Vaciando la primera exclusa
        exclusas_array[0].setStatus("vaciar");
    }//GEN-LAST:event_nivel1ActionPerformed

    
   
    private void nivel2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivel2ActionPerformed
        
        //Vaciando la segunda exclusa y llenando la primera
        exclusas_array[0].setStatus("llenar");
        exclusas_array[1].setStatus("vaciar");
    }//GEN-LAST:event_nivel2ActionPerformed

    private void nivel3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivel3ActionPerformed
       
        //Llenando la segunda exclusa y vaciando la tercera
        exclusas_array[1].setStatus("llenar");
        exclusas_array[2].setStatus("vaciar");
    }//GEN-LAST:event_nivel3ActionPerformed

    private void nivel4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nivel4ActionPerformed
        //llenando la tercera exclusa
        exclusas_array[2].setStatus("llenar");
    }//GEN-LAST:event_nivel4ActionPerformed

    private void c1_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c1_abrirActionPerformed
        //abriendo la primera compuerta
        compuertas_array[0].setOperation("abrir");
    }//GEN-LAST:event_c1_abrirActionPerformed

    private void c1_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c1_cerrarActionPerformed
        //cerrando la primera compuerta
        compuertas_array[0].setOperation("cerrar");
    }//GEN-LAST:event_c1_cerrarActionPerformed

    private void c2_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c2_abrirActionPerformed
        
        //abriendo la segunda compuerta
        compuertas_array[1].setOperation("abrir");
    }//GEN-LAST:event_c2_abrirActionPerformed

    private void c2_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c2_cerrarActionPerformed
        
        //cerrando la segunda compuerta
        compuertas_array[1].setOperation("cerrar");
    }//GEN-LAST:event_c2_cerrarActionPerformed

    private void c3_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c3_abrirActionPerformed
        //abriendo la tercera compuerta
        compuertas_array[2].setOperation("abrir");
    }//GEN-LAST:event_c3_abrirActionPerformed

    private void c3_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c3_cerrarActionPerformed
        //cerrando la tercera compuerta
        compuertas_array[2].setOperation("cerrar");
    }//GEN-LAST:event_c3_cerrarActionPerformed

    private void c4_abrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c4_abrirActionPerformed
        //abriendo la  cuarta compuerta
        compuertas_array[3].setOperation("abrir");
    }//GEN-LAST:event_c4_abrirActionPerformed

    private void c4_cerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_c4_cerrarActionPerformed
        //cerrando la cuarta compuerta
        compuertas_array[3].setOperation("cerrar");
    }//GEN-LAST:event_c4_cerrarActionPerformed

    private void resetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resetActionPerformed
        
        //Reseteamos todo
        inicializa();
        
    }//GEN-LAST:event_resetActionPerformed
    
   

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel a_ex1;
    private javax.swing.JLabel a_ex2;
    private javax.swing.JLabel a_ex3;
    private javax.swing.JLabel bg;
    private javax.swing.JLabel buque;
    private javax.swing.JButton c1_abrir;
    private javax.swing.JButton c1_cerrar;
    private javax.swing.JButton c2_abrir;
    private javax.swing.JButton c2_cerrar;
    private javax.swing.JButton c3_abrir;
    private javax.swing.JButton c3_cerrar;
    private javax.swing.JButton c4_abrir;
    private javax.swing.JButton c4_cerrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton nivel1;
    private javax.swing.JButton nivel2;
    private javax.swing.JButton nivel3;
    private javax.swing.JButton nivel4;
    private javax.swing.JLabel p1;
    private javax.swing.JLabel p2;
    private javax.swing.JLabel p3;
    private javax.swing.JLabel p4;
    private javax.swing.JButton reset;
    // End of variables declaration//GEN-END:variables

   
    
    /**
     * Inner class que se encarga de actualizar el panel de control
     * y la parte gráfica de la simulación.
     */
    public class T_Actualizador extends Thread
            
{
    private javax.swing.JLabel[] jLabel_array;
    private javax.swing.JButton[] jButton_array;
    private Buque barco;
    
    /**Crea un nuevo T_Actualizador.
     @param barco Objeto Buque.
     @param jLabel_array Array de jLabel, donde cada uno contiene una imágen de la simulación.
     @param jButton_array Array que contiene los botones del panel de control.*/
    public T_Actualizador(Buque barco, javax.swing.JLabel[] jLabel_array, javax.swing.JButton[] jButton_array)
    {
        this.jLabel_array =jLabel_array;
        this.jButton_array =jButton_array;
        this.barco = barco;
    }
    
    /**Método sobreescrito que se encarga de actualizar la parte gráfica y el panel de 
     control de la simulación.*/
    
    public void run()
    {
        
        while(true){
            try
            {
                
                
                //Controla la parte gráfica de la simulación
                jLabel_array[0].setLocation(barco.getPosicion(),168-barco.getAltura());//buque
                jLabel_array[1].setSize(140,exclusas_array[0].getNivel());//exclusa 1
                jLabel_array[1].setLocation(88,217-exclusas_array[0].getNivel());//exclusa 1
                jLabel_array[2].setSize(140,exclusas_array[1].getNivel());//exclusa 2
                jLabel_array[2].setLocation(225,191-exclusas_array[1].getNivel()); //exclusa 2 
                jLabel_array[3].setSize(140,exclusas_array[2].getNivel());//exclusa 3
                jLabel_array[3].setLocation(359,163-exclusas_array[2].getNivel());  //exclusa 3
                
                jLabel_array[4].setSize(5+compuertas_array[0].getPosicion(),53);//compuerta 1
                jLabel_array[5].setSize(5+compuertas_array[1].getPosicion(),53);//compuerta 2
                jLabel_array[6].setSize(5+compuertas_array[2].getPosicion(),53);//compuerta 3
                jLabel_array[7].setSize(5+compuertas_array[3].getPosicion(),53);//compuerta 4
                
                
                
                //Controla el estado de los botones durante la simulación
                if(inicio==true&&controlador1==false){
                    
                    nivel2.setEnabled(false);
                    nivel3.setEnabled(false);
                    nivel4.setEnabled(false);
                    
                    c1_cerrar.setEnabled(false);
                    c2_cerrar.setEnabled(false);
                    c3_cerrar.setEnabled(false);
                    c4_cerrar.setEnabled(false);
                    
                    c2_abrir.setEnabled(false);
                    c3_abrir.setEnabled(false);
                    c4_abrir.setEnabled(false);
                    
                }
                if(controlador1==true&&controlador2==false){
                
                    nivel3.setEnabled(false);
                    nivel4.setEnabled(false);
                    
                    c1_abrir.setEnabled(false);
                    
                    
                    c2_cerrar.setEnabled(false);
                    c3_cerrar.setEnabled(false);
                    c4_cerrar.setEnabled(false);
                }
              
                if(controlador2==true&&controlador3==false){
                
                    nivel3.setEnabled(false);
                    nivel4.setEnabled(false);
                    
                    c1_abrir.setEnabled(false);
                    c3_cerrar.setEnabled(false);
                    c4_cerrar.setEnabled(false);
                }
                
                
                if(compuertas_array[0].getStatus()==1&&exclusas_array[0].getNivel()==26&&c1==false){
                    jButton_array[0].setEnabled(true);
                  
                    c1=true;
                   
                }
                if(c1==false){
                    jButton_array[0].setEnabled(false);
                 
                }
                
                
                if(compuertas_array[0].getStatus()==1&&exclusas_array[0].getNivel()==26&&c1==true&&barco.getPosicion()==90&&controlador1==false ){
                   
                    nivel1.setEnabled(false);
                    c1_cerrar.setEnabled(true);
                    controlador1=true;                                 
                }
                
                if(compuertas_array[0].getPosicion()==0&&controlador1==true&& controlador2 == false){
                    
                    nivel2.setEnabled(true);
                    controlador2=true;
                    c1_cerrar.setEnabled(false);
                }
                
                
               if(controlador2==true&&exclusas_array[0].getNivel()==52&&controlador3==false){
                
                    nivel2.setEnabled(false);
                    c2_abrir.setEnabled(true);
                    controlador3=true;
                    
                    
                }
                
                if(controlador3==true&&exclusas_array[0].getNivel()==52&&controlador4==false){
                
                   c2_abrir.setEnabled(true);
                   controlador4=true;
                }
                
               if(controlador3==true&&exclusas_array[0].getNivel()==52&&compuertas_array[1].getPosicion()==20&&barco.getPosicion()==230){
                
                   c2_abrir.setEnabled(false);
                   c2_cerrar.setEnabled(true);
                   controlador5=true;
                   
                }
                
                if(controlador5==true&&compuertas_array[1].getPosicion()==0&&controlador6==false){
                    
                    c2_cerrar.setEnabled(false);
                    nivel3.setEnabled(true);
                }
                
                if(exclusas_array[1].getNivel()==52&& controlador5==true&&controlador7==false){
                    
                    nivel3.setEnabled(false);
                    c3_abrir.setEnabled(true);
                    controlador6=true;
                }
                
                if(controlador6==true&&barco.getPosicion()==360&&controlador7==false){
                
                    
                    c3_abrir.setEnabled(false);
                    c3_cerrar.setEnabled(true);
                    controlador7=true;
                }
                
                if(controlador7==true&&barco.getPosicion()==360&&compuertas_array[2].getPosicion()==0&&controlador8==false){
                
                    c3_cerrar.setEnabled(false);
                    nivel4.setEnabled(true);
                    controlador8=true;
                }
                
                if(controlador7==true&&exclusas_array[2].getNivel()==52&&controlador8==true&&controlador9==false){
                    
                    nivel4.setEnabled(false);
                    c4_abrir.setEnabled(true);
                    controlador9=true;
                }
                
                if(controlador9==true&&barco.getPosicion()==510){
                    
                    
                    c4_abrir.setEnabled(false);
                    c4_cerrar.setEnabled(true);
                    controlador10=true;
                }
                
                if(compuertas_array[3].getPosicion()==0&&controlador10==true&&barco.getPosicion()==550){
                    
                    reset.setEnabled(true);
                
                }
                
                 Thread.currentThread().sleep(20);//Un breve descanzo
            }
            catch(InterruptedException e)
            {}
        }
    }
}
/**Restablece todos los valores iniciales de los campos del objeto View*/
public void inicializa(){//Inicializamos todos los parametros 
    
    inicio =true;
    c1 =false;
    controlador1 = false;
    controlador2 = false;
    controlador3=false;
    controlador4=false;
    controlador5=false;
    controlador6=false;
    controlador7=false;
    controlador8=false;
    controlador9=false;
    
    buque.setLocation(-45,168);//Colocamos el buque en la coordenada inicial
    barco.reset();
    
    nivel1.setEnabled(true);
    reset.setEnabled(false);
    
    
}
}
