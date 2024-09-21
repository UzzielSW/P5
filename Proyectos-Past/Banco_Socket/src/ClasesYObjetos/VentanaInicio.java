
package ClasesYObjetos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ImageIcon;
import JButton;
import JFrame;
import static JFrame.EXIT_ON_CLOSE;
import JLabel;
import JOptionPane;
import JPanel;
import JTextArea;
import JTextField;
import SwingConstants;

public class VentanaInicio extends JFrame implements ActionListener {
    private JPanel panelFondo;
    private JTextField cajaNumeroCuenta;
    private JTextField cajaClave;
    private JButton btAdministrador;
    private JButton btIniciar;
    BaseCuentas base;
    
    public VentanaInicio (BaseCuentas base){
    this.base=base;  
    this.setBounds(50,50,1000,600);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
    this.setTitle("                                                                                                                     Inicio "); 
    panelFondo = new JPanel();
    panelFondo.setLayout(null);
    this.getContentPane().add(panelFondo);      
       
       colocarComponentes();  
          
    }
    
    public void colocarComponentes(){
        colocarPanel(); 
        colocarBotones();
        colocarCajaTexto();
       
    
    }
    public void colocarPanel(){
          ImageIcon foto= new ImageIcon("imagenInicio.jpg");
          JLabel etiqueta = new JLabel ();
          etiqueta.setBounds(0,0,this.getWidth(),this.getHeight());
          etiqueta.setIcon(new ImageIcon (foto.getImage().getScaledInstance(this.getWidth(), etiqueta.getHeight(),Image.SCALE_SMOOTH)));
          panelFondo.add(etiqueta);
    }
    
    
    
    
        private void colocarBotones(){
         btAdministrador=new JButton("Ir a Administrador");
         btAdministrador.setBounds(70,480, 150,40);
         btAdministrador.setEnabled(true);
         btAdministrador.setFont(new Font("arial",Font.BOLD,10 ));
         btAdministrador.addActionListener(this);
         panelFondo.add(btAdministrador);
         
       
         btIniciar =new JButton("Iniciar ingreso");
         btIniciar.setBounds(400,435, 190,60);
         btIniciar.setEnabled(true);
         btIniciar.setFont(new Font("arial",Font.BOLD,16 )); 
         btIniciar.addActionListener(this);
         panelFondo.add(btIniciar);
         
                 
     
        }
    
        private void colocarCajaTexto(){
         Font fuente = new Font("Calibri", 2, 25);
         cajaNumeroCuenta=new JTextField( );
         cajaNumeroCuenta.setFont(fuente); 
         cajaNumeroCuenta.setBounds(238,178,476, 40);
         panelFondo.add(cajaNumeroCuenta);
         
         cajaClave=new JTextField( );
         cajaClave.setBounds(246,340,476, 40);
         cajaClave.setFont(fuente);
         panelFondo.add(cajaClave);
        }
        
     
         

    @Override
    public void actionPerformed(ActionEvent e) {
       if (e.getSource()==btAdministrador){
           this.dispose();
           dispose();
           
           VentanaAdministrador admin =new VentanaAdministrador(base);
           admin.setVisible(true);
          }//btAdministrador
       
       if(e.getSource()==btIniciar) {
         
         String clave=cajaClave.getText();
         int id=Integer.parseInt(cajaNumeroCuenta.getText());
           
              if (cajaNumeroCuenta.getText().length()==0 || cajaClave.getText().length()==0){
                  JOptionPane.showMessageDialog(null,"Por favor coloque los campos de manera correcta");
                 }
              else {
                     if (base.buscaCuentaID(Integer.parseInt(cajaNumeroCuenta.getText()))==true){
                        System.out.println(base.obtenerCuenta(id).getCuentaId()+base.obtenerCuenta(id).getSaldo());
                        System.out.println(base.obtenerCuenta(id).getClaveAlfaNum());
                         
                        
                              this.setVisible(false);
                              this.dispose();
                               VentanaUsuario usuario =new VentanaUsuario(base,id);
                               usuario.setVisible(true);
                          
                  
                    } else {
                        JOptionPane.showMessageDialog(null,"Cuenta no existe");  
                          
                            
                       }
                    
              }
           
       
         }//btIniciar
       
    }
    
}

